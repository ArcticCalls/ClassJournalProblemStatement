package com.yeehungchong.classjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


//Qayyum Codes
public class MainActivity extends AppCompatActivity {
    int requestCodeForModule = 1;
    TextView tvModuleCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvModuleCode = (TextView) findViewById(R.id.textViewModuleCode);

        // Set listener
        tvModuleCode.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {

                Module c347 = new Module("C347");
                Intent i = new Intent(MainActivity.this,
                        InfoActivity.class);

                i.putExtra("module", c347);
                startActivityForResult(i,requestCodeForModule);
            }});

    }
}