package com.example.a_test_in_my_head;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private long backKeyPressedTime=0;

    @Override
    public void onBackPressed() {
        if(System.currentTimeMillis()>backKeyPressedTime+2000){
            backKeyPressedTime=System.currentTimeMillis();
            Toast.makeText(this,"뒤로가기 버튼을 한번 더 누르시면 종료됩니다!",Toast.LENGTH_SHORT).show();
            return;
        }
        if(System.currentTimeMillis()<=backKeyPressedTime+2000){
            finishAffinity();
            System.runFinalization();
            System.exit(0);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        boolean k_f = intent.getBooleanExtra("kill", false);
        if(k_f == true){
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button) findViewById(R.id.guessnumber);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent1 = new Intent(MainActivity.this,GuessNumberMain.class);
                startActivity(myintent1);
                finish();
            }
        });
        Button button2 = (Button) findViewById(R.id.nback);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent2 = new Intent(MainActivity.this,NBackMain.class);
                startActivity(myintent2);
                finish();
            }
        });
        Button listButton = (Button) findViewById(R.id.exit);
        listButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("정말로 종료하시겠습니까?");
                builder.setTitle("종료 알림창")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                finishAffinity();
                                System.runFinalization();
                                System.exit(0);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.setTitle("종료 알림창");
                alert.show();
            }
        });



    }

}