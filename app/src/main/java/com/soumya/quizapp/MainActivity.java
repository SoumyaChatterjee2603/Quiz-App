package com.soumya.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView quesNum, ques;
    private Button option1, option2, option3, option4;
    private ImageButton prev, next;
    private ArrayList<QuizModel> quizModelArrayList;
    //Random random;
    int currentScore = 0, questionAttempted = 0, currentPos = 0;
    //int currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quesNum = findViewById(R.id.QuesNum);
        ques = findViewById(R.id.Ques);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        prev = findViewById(R.id.prev);
        next = findViewById(R.id.next);
        quizModelArrayList = new ArrayList<>();
        //random = new Random();
        quizQuestions(quizModelArrayList);
        //currentPos = random.nextInt(quizModelArrayList.size());
        setDataToViews(currentPos);

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizModelArrayList.get(currentPos).getAnswer().trim().equalsIgnoreCase(option1.getText().toString().trim())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos++;
                //currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizModelArrayList.get(currentPos).getAnswer().trim().equalsIgnoreCase(option2.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                //currentPos = random.nextInt(quizModelArrayList.size());
                currentPos++;
                setDataToViews(currentPos);
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizModelArrayList.get(currentPos).getAnswer().trim().equalsIgnoreCase(option3.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                //currentPos = random.nextInt(quizModelArrayList.size());
                currentPos++;
                setDataToViews(currentPos);
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizModelArrayList.get(currentPos).getAnswer().trim().equalsIgnoreCase(option4.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                //currentPos = random.nextInt(quizModelArrayList.size());
                currentPos++;
                setDataToViews(currentPos);
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //currentPos = random.nextInt(quizModelArrayList.size());
                if (currentPos !=0) {
                    currentPos--;
                }else{
                    currentPos = 9;
                }
                setDataToViews(currentPos);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //currentPos = random.nextInt(quizModelArrayList.size());
                if (currentPos != 9) {
                    currentPos++;
                }else{
                    currentPos = 0;
                }
                setDataToViews(currentPos);
            }
        });
    }

    //setting overlay for total score & restart//
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_board,
                (LinearLayout) findViewById(R.id.LinearScore));
        TextView score = bottomSheetView.findViewById(R.id.scoreBoard);
        Button restartQuiz = bottomSheetView.findViewById(R.id.quizRestart);
        score.setText("Your Score is \n"+ currentScore +"\10");
        restartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionAttempted = 0;
                currentPos=0;
                //currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
                currentScore = 0;
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    //fetching questions now //
    private void setDataToViews(int currentPos) {
        quesNum.setText("Questions Attempted:       "+ questionAttempted +"/10");
        //if (questionAttempted == 10)
        if (currentPos == 10) {
            showBottomSheet();
        }else {
            ques.setText(quizModelArrayList.get(currentPos).getQuestion());
            option1.setText(quizModelArrayList.get(currentPos).getOption1());
            option2.setText(quizModelArrayList.get(currentPos).getOption2());
            option3.setText(quizModelArrayList.get(currentPos).getOption3());
            option4.setText(quizModelArrayList.get(currentPos).getOption4());
        }
    }

    //set of question//
    private void quizQuestions(ArrayList<QuizModel> quizModelArrayList) {
        quizModelArrayList.add(new QuizModel("1. Android is licensed under which open source licensing license ?","1. Gnus GPL","2. Apache/MIT","3. OSS","4. Sourceforge","2. Apache/MIT"));
        quizModelArrayList.add(new QuizModel("2. Android is ?","1. Web Server","2. Web Browser","3. Operating System","4. None of These","3. Operating System"));
        quizModelArrayList.add(new QuizModel("3. Who owns Android platform ?","1. Oracle","2. Google","3. Open Handset Alliance","4. None of the above","3. Open Handset Alliance"));
        quizModelArrayList.add(new QuizModel("4. Android is developed specially for ?","1. Laptops","2. Desktops","3. Servers","4. Mobile Devices","4. Mobile Devices"));
        quizModelArrayList.add(new QuizModel("5. Android Operating system is based on ?","1. Mac","2. Windows","3. Linux","4. Solaris","3. Linux"));
        quizModelArrayList.add(new QuizModel("6. OHA stands for ?","1. Open Handset Alliance","2. Open Host Application","3. Open Handset Association","4. Open Handset Application","1. Open Handset Alliance"));
        quizModelArrayList.add(new QuizModel("7. What was the first phone released that ran Android OS ?","1. Google gPhone","2. T-Mobile G1","3. Motorola Droid","4. HTC Hero","2. T-Mobile G1"));
        quizModelArrayList.add(new QuizModel("8. What year was the Open Handset Alliance announced ?","1. 2005","2. 2006","3. 2007","4. 2008","3. 2007"));
        quizModelArrayList.add(new QuizModel("9. Android releases since 1.5 have been given nicknames derived how ?","1. Food","2. American states","3. Adjective and Strange Animal","4. None of these","1. Food"));
        quizModelArrayList.add(new QuizModel("10. In Android Architecture, layer below Application Framework is ?","1. Applications","2. Linux Kernel","3. Application Framework","4. System Libraries & ART","4. System Libraries & ART"));
    }
}