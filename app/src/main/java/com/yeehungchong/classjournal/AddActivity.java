package com.yeehungchong.classjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class AddActivity extends AppCompatActivity {

    TextView tvWeek;
    RadioGroup rgGrade;
    RadioButton rbGrade;
    Button btnSubmit;
    String choice = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        btnSubmit = findViewById(R.id.buttonSubmit);
        rgGrade = findViewById(R.id.radioGroup);
        tvWeek = findViewById(R.id.textViewWeek);

        

    }
}