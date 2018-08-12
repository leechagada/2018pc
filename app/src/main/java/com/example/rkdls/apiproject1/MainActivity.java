package com.example.rkdls.apiproject1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        result.setMovementMethod(new ScrollingMovementMethod()); // 스크롤 기능

        ImageButton btn_monitor = findViewById(R.id.imgbtn_monitor);
        ImageButton btn_desktop = findViewById(R.id.imgbtn_desktop);
        ImageButton btn_keyboard = findViewById(R.id.imgbtn_keyboard);
        ImageButton btn_mouse = findViewById(R.id.imgbtn_mouse);

        btn_monitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UsageActivity.class);
                startActivity(intent);
            }
        });

        btn_desktop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), UsageActivity.class));
            }
        });


    }
}