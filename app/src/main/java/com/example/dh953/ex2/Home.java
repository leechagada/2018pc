package com.example.dh953.ex2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

       ImageButton btnMonitor = findViewById(R.id.imgbtn_monitor);

        btnMonitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Monitor.class);

                startActivity(intent);
            }
        });

        ImageButton btnKeyboard = findViewById(R.id.imgbtn_keyboard);

        btnKeyboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Keyboard.class);

                startActivity(intent);
            }
        });

        ImageButton btnMouse = findViewById(R.id.imgbtn_mouse);

        btnMouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Mouse.class);

                startActivity(intent);
            }
        });

        ImageButton btnDesktop = findViewById(R.id.imgbtn_desktop);

        btnDesktop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Desktop.class);

                startActivity(intent);
            }
        });
    }
}
