package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView cPlusPlus;
    public static ArrayList<ModelClass> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cPlusPlus=findViewById(R.id.cPlusPlus);

        cPlusPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, CPlusPlusQuiz.class);
                startActivity(i);
            }
        });

        list=new ArrayList<>();

        list.add(new ModelClass("C++ language was developed by","Dennis Rechard","Dennis M. Ritchie","Bjarne Stroustrup","Anders Hejlsberg","Bjarne Stroustrup"));
        list.add(new ModelClass("In which year, the name of the language was changed from \"C with Classes\" to C++","1979","1972","1983","1986","1983"));
        list.add(new ModelClass("C++ language is a successor to which language?","B","C","Java","VB","C"));
        list.add(new ModelClass("C++ language is a","Object Oriented Language","Procedural Oriented Language","Structural Oriented Language","None of the above","Object Oriented Language"));
        list.add(new ModelClass("C++ follows","Top-Down Design approach","Bottom-Up Design approach","Both of the above","None of the above","Bottom-Up Design approach"));
        list.add(new ModelClass("C++ is a","High-level language","Medium level language","Low-level language","None of the above","Medium level language"));
        list.add(new ModelClass("How many keywords are in C++?","32","48","99","95","95"));
        list.add(new ModelClass("Which of the following is not a valid keyword in C++ language?","while","for","switch","do-while","do-while"));
        list.add(new ModelClass("Which of the following is used for single-line comment in C++?","//","\\\\","/* */","##","//"));
        list.add(new ModelClass("In which year C++14 was introduced?","2014","2015","2017","None of the above","2014"));

    }

    public void javaClick(View view) {
        Intent i = new Intent(getApplicationContext(), CPlusPlusQuiz.class);
        startActivity(i);
    }

    public void pythonClick(View view) {
        Intent i = new Intent(getApplicationContext(), CPlusPlusQuiz.class);
        startActivity(i);
    }
}