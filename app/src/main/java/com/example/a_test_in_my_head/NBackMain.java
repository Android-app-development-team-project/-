package com.example.a_test_in_my_head;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NBackMain extends AppCompatActivity {
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nback_main);

        Button button1 = (Button) findViewById(R.id.levelTestBtn);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent1 = new Intent(NBackMain.this,NBackGame.class);
                startActivity(myintent1);
            }
        });

    }



    public void onClickTest(View view) {
        Intent intent3 = new Intent(this,NBackPracticeGameSetting.class);
        startActivity(intent3);
    }

/*
    public void onClickLevelTest(View v){
        Intent intent = new Intent(this, NBackGame.class);
        startActivity(intent);
    }

    public void onClickPractice(View v){
        Intent intent = new Intent(this, NBackPracticeGameSetting.class);
        startActivity(intent);
    }*/
}