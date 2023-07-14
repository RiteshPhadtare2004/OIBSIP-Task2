package com.example.quizapp;

import static com.example.quizapp.MainActivity.list;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Collections;
import java.util.List;

public class CPlusPlusQuiz extends AppCompatActivity {

    List<ModelClass> allQuestionsList;
    ModelClass modelClass;
    int index = 0, correctCount = 0, wrongCount = 0;
    TextView que, optiona, optionb, optionc, optiond;
    ImageView oAbtn, oBbtn, oCbtn, oDbtn;
    ImageButton next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cplus_plus_quiz);

        Intialise();


        allQuestionsList = list;
        Collections.shuffle(allQuestionsList);
        modelClass = list.get(index);
        next.setClickable(false);
        setData();
    }


    private void Intialise() {
        que = findViewById(R.id.que);
        optiona = findViewById(R.id.optiona);
        optionb = findViewById(R.id.optionb);
        optionc = findViewById(R.id.optionc);
        optiond = findViewById(R.id.optiond);

        oAbtn = findViewById(R.id.oAbtn);
        oBbtn = findViewById(R.id.oBbtn);
        oCbtn = findViewById(R.id.oCbtn);
        oDbtn = findViewById(R.id.oDbtn);


        next = findViewById(R.id.next);
    }

    private void setData() {
        que.setText(modelClass.getQuestion());
        optiona.setText(modelClass.getoA());
        optionb.setText(modelClass.getoB());
        optionc.setText(modelClass.getoC());
        optiond.setText(modelClass.getoD());

    }

    public void Correct(ImageView imgView) {

        imgView.setBackground(getResources().getDrawable(R.drawable.correct_color));

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correctCount++;
                index++;
                modelClass = list.get(index);
                enableButton();
                resetColor();
                setData();
            }
        });


    }

    public void Wrong(ImageView imgView) {
        imgView.setBackground(getResources().getDrawable(R.drawable.wrong_color));
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wrongCount++;
                if (index < list.size() - 1) {
                    index++;
                    modelClass = list.get(index);
                    enableButton();
                    resetColor();
                    setData();


                } else {
                    GameWon();
                }
            }
        });

    }

    private void GameWon() {
        Intent intent = new Intent(CPlusPlusQuiz.this, WonActivity.class);
        intent.putExtra("correct", correctCount);
        intent.putExtra("wrong", wrongCount);
        startActivity(intent);
    }

    public void resetColor() {
        oAbtn.setBackground(getResources().getDrawable(R.drawable.bg_color));
        oBbtn.setBackground(getResources().getDrawable(R.drawable.bg_color));
        oCbtn.setBackground(getResources().getDrawable(R.drawable.bg_color));
        oDbtn.setBackground(getResources().getDrawable(R.drawable.bg_color));

    }

    public void enableButton() {
        oAbtn.setClickable(true);
        oBbtn.setClickable(true);
        oCbtn.setClickable(true);
        oDbtn.setClickable(true);
    }

    public void disableButton() {
        oAbtn.setClickable(false);
        oBbtn.setClickable(false);
        oCbtn.setClickable(false);
        oDbtn.setClickable(false);
    }

    public void optionAClick(View view) {
        disableButton();
        next.setClickable(true);
        if (modelClass.getoA().equals(modelClass.getAns())) {
            oAbtn.setBackground(getResources().getDrawable(R.drawable.correct_color));
            if (index < list.size() - 1) {
                Correct(oAbtn);
            } else {
                GameWon();
            }

        } else {
            Wrong(oAbtn);
        }
    }

    public void optionBClick(View view) {
        disableButton();
        next.setClickable(true);
        if (modelClass.getoB().equals(modelClass.getAns())) {
            oBbtn.setBackground(getResources().getDrawable(R.drawable.correct_color));
            if (index < list.size() - 1) {
                Correct(oBbtn);
            } else {
                GameWon();
            }

        } else {
            Wrong(oBbtn);
        }
    }

    public void optionCClick(View view) {
        disableButton();
        next.setClickable(true);
        if (modelClass.getoC().equals(modelClass.getAns())) {
            oCbtn.setBackground(getResources().getDrawable(R.drawable.correct_color));
            if (index < list.size() - 1) {
                Correct(oCbtn);
            } else {
                GameWon();
            }

        } else {
            Wrong(oCbtn);
        }
    }

    public void optionDClick(View view) {
        disableButton();
        next.setClickable(true);
        if (modelClass.getoD().equals(modelClass.getAns())) {
            oDbtn.setBackground(getResources().getDrawable(R.drawable.correct_color));
            if (index < list.size() - 1) {
                Correct(oDbtn);
            } else {
                GameWon();
            }

        } else {
            Wrong(oDbtn);
        }
    }

}