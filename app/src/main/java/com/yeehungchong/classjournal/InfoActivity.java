package com.yeehungchong.classjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {

    Button btnAdd, btnInfo, btnEmail;
    ListView lv;
    ArrayAdapter aa;
    ArrayList<GradeInfo> grade;
    String emailMessage = "";

    int requestAdd = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        btnAdd = findViewById(R.id.buttonAdd);
        btnInfo = findViewById(R.id.buttonInfo);
        btnEmail = findViewById(R.id.buttonEmail);
        lv = findViewById(R.id.lvGrade);

        grade = new ArrayList<GradeInfo>();
        grade.add(new GradeInfo(1, "DC", "A"));
        grade.add(new GradeInfo(2, "DC", "B"));
        grade.add(new GradeInfo(3, "DC", "C"));

        aa = new GradeAdapter(this, R.layout.activity_info_row, grade);
        lv.setAdapter(aa);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(InfoActivity.this, AddActivity.class);
                i.putExtra("currentWeek", grade.size());
                Module module = (Module) i.getSerializableExtra("module");
                startActivityForResult(i, requestAdd);
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent infoIntent = new Intent(Intent.ACTION_VIEW);
                infoIntent.setData(Uri.parse("https://www.rp.edu.sg/SOI/full-time-diplomas/Details/diploma-in-digital-design-and-development"));
                startActivity(infoIntent);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT, "Test Email from C347");
                for (int i =0; i <grade.size(); i++){
                   emailMessage += "Week " + grade.get(i).getWeek() + ": "+ grade.get(i).getTitle() + ": " + grade.get(i).getGrade() + "\n";
                }
                email.putExtra(Intent.EXTRA_TEXT, "Hi Faci, \n" + "I am..." + "\n Please see my remarks so far, thank you! \n" + emailMessage);
                emailMessage = "";
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            if (data != null) {
                String nowGrade = data.getStringExtra("grade");
                int nowWeek = data.getIntExtra("week", 0);
                String statement = "";
                if(requestCode == requestAdd){
                    statement = "Grade " + grade + " week " + nowWeek;
                }
                grade.add(new GradeInfo(nowWeek, "DG", nowGrade));
                aa.notifyDataSetChanged();
            }
        }
    }

}