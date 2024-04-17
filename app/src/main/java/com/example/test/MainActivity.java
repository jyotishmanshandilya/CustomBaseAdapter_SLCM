package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btn;

    EditText id, cgpa;
    String studentId, studentCGPA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.button);
        id = (EditText) findViewById(R.id.editTextText);
        cgpa = (EditText) findViewById(R.id.editTextText2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });
    }

    public void sendData(){
        studentId = id.getText().toString().trim();
        studentCGPA = cgpa.getText().toString().trim();
        id.setText("Enter Student name:");
        cgpa.setText("Enter CGPA");
        Intent intent = new Intent(getBaseContext(), MainActivity2.class);
        intent.putExtra(MainActivity2.ID, studentId);
        intent.putExtra(MainActivity2.CGPA, studentCGPA);
        startActivity(intent);
    }
}
