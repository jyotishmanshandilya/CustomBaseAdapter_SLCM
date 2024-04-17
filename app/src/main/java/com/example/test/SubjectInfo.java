package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SubjectInfo extends AppCompatActivity {

    public static String SUBJECT="SUBJECT";
    public static String MARKS = "MARKS";

    String sub, marks;
    String displayData;
    TextView subjectInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_info);
        subjectInfo = (TextView) findViewById(R.id.textView4);

        Intent i = getIntent();
        sub = i.getStringExtra(SUBJECT);
        marks = i.getStringExtra(MARKS);

        subjectInfo.setText("Heyy!!\nYou scored "+marks+" in your subject\n "+sub);
//        for tomorrow, Add an alert box on button click to reveal some static info(Alertbox practice)
    }
}