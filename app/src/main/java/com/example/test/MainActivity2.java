package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    ArrayList<String> subjectList = new ArrayList<>();
    ArrayList<String> subjectMarksList = new ArrayList<>();
    ListView listView;
    public static final String ID="ID";
    public static final String CGPA="CGPA";
    String id, cgpa;
    TextView displayInfo;
    EditText newSubject, newMarks;
    Button addData, gpaIntent;
    String newSubjectData, newMarksData;

    // initialize data
    {
        subjectList.add("Object Oriented Programming");
        subjectMarksList.add("89");
        subjectList.add("Data Structures & Algorithms");
        subjectMarksList.add("90");
        subjectList.add("Distributed Systems");
        subjectMarksList.add("57");
        subjectList.add("Mathematics");
        subjectMarksList.add("100");
        subjectList.add("Big Data Modelling");
        subjectMarksList.add("60");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView = (ListView) findViewById(R.id.listView);
        newSubject = (EditText) findViewById(R.id.editTextText3);
        newMarks = (EditText) findViewById(R.id.editTextText4);
        addData = (Button) findViewById(R.id.button2);
        gpaIntent = (Button) findViewById(R.id.button4);

        displayInfo = (TextView) findViewById(R.id.textView);

        Intent i = getIntent();
        id = i.getStringExtra(ID);
        cgpa = i.getStringExtra(CGPA);

        displayInfo.setText("Hello student: "+id+" \nYour cgpa is: "+cgpa);

        // ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_list_view, R.id.textView2, SubjectList);
        // listView.setAdapter(arrayAdapter);
        CustomListAdapter ctxListAdapter = new CustomListAdapter(getApplicationContext(), subjectList, subjectMarksList);
        listView.setAdapter(ctxListAdapter);

        Toast.makeText(this, "Enter marks for every subject", Toast.LENGTH_SHORT).show();

        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newSubjectData = newSubject.getText().toString().trim();
                newMarksData = newMarks.getText().toString().trim();
                ctxListAdapter.addSubject(newSubjectData, newMarksData);
                newSubject.setText("");
                newMarks.setText("");
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String sub = subjectList.get(position);
                String m = subjectMarksList.get(position);

                sendSubjectData(sub, m);

            }
        });

        gpaIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendDataForGPACalc(subjectMarksList);
            }
        });
    }

    public void sendSubjectData(String sendSubject, String sendMarks){
        Intent intent = new Intent(getApplicationContext(), SubjectInfo.class);
        intent.putExtra(SubjectInfo.SUBJECT, sendSubject);
        intent.putExtra(SubjectInfo.MARKS, sendMarks);
        startActivity(intent);
    }

    public void sendDataForGPACalc(ArrayList<String> SubjectMarks){
        Intent i = new Intent(getApplicationContext(), CalcGPA.class);
        i.putStringArrayListExtra(String.valueOf(CalcGPA.SUBJECTMARKS), SubjectMarks);
        startActivity(i);

    }
}