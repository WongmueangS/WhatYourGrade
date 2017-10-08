package com.example.whatyourgrade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView sname = (TextView)findViewById(R.id.textView1);
        TextView sgrade = (TextView)findViewById(R.id.textView2);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String grade = intent.getStringExtra("grade");

        sname.setText(name);
        sgrade.setText(grade);

    }
}
