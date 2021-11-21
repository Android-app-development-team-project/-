package com.example.a_test_in_my_head;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;


public class Wrong extends AppCompatActivity {

    Button RetryBtn, BackBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeout);
        requestWindowFeature( Window.FEATURE_NO_TITLE );

        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        RetryBtn = (Button) findViewById(R.id.RetryBtn);
        BackBtn = (Button) findViewById(R.id.BackBtn);



    }

    public void Back(View v){
        Intent intent = new Intent(Wrong.this,MainActivity.class);
        startActivity(intent);
    }

    public void Retry(View v){
        Intent intent = new Intent(Wrong.this,GuessNumberMain.class);
        startActivity(intent);
    }

    public boolean onTouchEvent(MotionEvent event){
        if(event.getAction()==MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;

    }
    public void onBackPressed(){
        return;
    }
}