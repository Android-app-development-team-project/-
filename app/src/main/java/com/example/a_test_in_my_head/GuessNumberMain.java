package com.example.a_test_in_my_head;


import static java.util.Collections.shuffle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;

public class GuessNumberMain extends AppCompatActivity {
    TextView timer; // 타이머 textView
    int value; // 타이머 숫자 표시
    int i;
    private long backKeyPressedTime = 0;

    @Override
    public void onBackPressed() {
        if(System.currentTimeMillis()>backKeyPressedTime+2000){
            backKeyPressedTime=System.currentTimeMillis();
            Toast.makeText(this,"뒤로가기 버튼을 한번 더 누르시면 return home!",Toast.LENGTH_SHORT).show();
            return;
        }
        if(System.currentTimeMillis()<=backKeyPressedTime+2000){
            finishAffinity();
            System.runFinalization();
            System.exit(0);
        }
    }
    /*    @Override
        public void onBackPressed() {
            if(System.currentTimeMillis()>backKeyPressedTime+2000){
                backKeyPressedTime=System.currentTimeMillis();
                Toast.makeText(this,"뒤로가기 버튼을 한번 더 누르시면 return home!",Toast.LENGTH_SHORT).show();
                return;
            }
            if(System.currentTimeMillis()<=backKeyPressedTime+2000){
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }

        }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_number_main);
        // 타이머
        timer = (TextView) findViewById(R.id.countDown);
        value = 0;
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 5초 카운트 다운
                for(i = 5; i >= 0; i--){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    value = i;
                    GuessNumberMain.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            timer.setText(String.valueOf(value));
                            if(value == 0){
                                Intent intent = new Intent(GuessNumberMain.this, GuessNumberInGame.class);
                                startActivity(intent);
                            }
                        }
                    });
                }
            }
        }).start();

    }
}