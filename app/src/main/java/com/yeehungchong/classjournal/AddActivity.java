package com.yeehungchong.classjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

        Intent i = getIntent();
        int weekNum = i.getIntExtra("currentWeek",0) + 1;
        tvWeek.setText("Week " + weekNum);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedID = rgGrade.getCheckedRadioButtonId();
                rbGrade = findViewById(selectedID);
                Intent i = new Intent();
                i.putExtra("grade", rbGrade.getText().toString());
                i.putExtra("week", weekNum);
                setResult(RESULT_OK, i);
                finish();
            }
        });

    }
}