package com.example.whatyourgrade;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mNameEditText;
    private EditText mScoreEditText;
    private Button mFindGradeButton;
    private Button mExitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameEditText = (EditText) findViewById(R.id.name_edit_text);
        mScoreEditText = (EditText) findViewById(R.id.scroe_edit_text);
        mFindGradeButton = (Button) findViewById(R.id.find_button);
        mExitButton = (Button) findViewById(R.id.exit_button);




        mExitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Confirm Exit");
                dialog.setMessage("แน่ใจว่าต้องการออกจากแอพ?");
                dialog.setPositiveButton("ออก", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }

                });
                dialog.setNegativeButton("ยกเลิก", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }

                });

                dialog.show();
            }
        });

        mFindGradeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mNameEditText.getText().length()==0&&mScoreEditText.getText().length()>0){
                    mNameEditText.setError("ป้อนชื่อ");

                }
                else if(mNameEditText.getText().length()>0&&mScoreEditText.getText().length()==0){
                    mScoreEditText.setError("ป้อนเกรด");

                }
                else if(mNameEditText.getText().length()==0&&mScoreEditText.getText().length()==0){
                    mNameEditText.setError("ป้อนชื่อ");
                    mScoreEditText.setError("ป้อนเกรด");

                }

                else if(mScoreEditText.getText().length()>=0&&mNameEditText.getText().length()>=0) {
                    Intent intent = new Intent(MainActivity.this,ActivityResult.class);
                    String n = mNameEditText.getText().toString();
                    intent.putExtra("name",n);
                    int s = Integer.parseInt(mScoreEditText.getText().toString());
                    String grade = getScoreText(s);
                    intent.putExtra("grade",grade);
                    startActivity(intent);

                }
            }
        });

    }

    private String getScoreText(double score) {
        String grade ="";
        if (score<49){
            grade = "F";
        }else if (score>50 &&score<59 ){
            grade = "D";
        }else if (score>60 &&score<69){
            grade = "C";
        }else if (score>70&&score<79 ){
            grade = "B";
        }else if (score>=80){
            grade = "A";
        }
        return  grade;
    }
}

