package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CalcGPA extends AppCompatActivity {

//    Receive subjectMarksArray from the activity_main2 and use that data to calculate the gpa out of 10 (use average(out of 100)/10)
    public static String SUBJECTMARKS = "SUBJECTMARKS";
    ArrayList<String> subjectMarks;
    String avgCalc;
    TextView avgDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_gpa);
        avgDisplay = (TextView) findViewById(R.id.textView5);

        Intent i = getIntent();
        subjectMarks = i.getStringArrayListExtra(SUBJECTMARKS);

        double totalMarks = 0;
        for (int j = 0; j < subjectMarks.size(); j++) {
            totalMarks+=Double.parseDouble(subjectMarks.get(j));
        }
        double gpaCalc = (double)(totalMarks/(subjectMarks.size()*10));

        avgDisplay.setText("Your GPA for this sem is: "+ gpaCalc);

    }
}