package com.example.rkdls.apiproject1.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.rkdls.apiproject1.R;
import com.example.rkdls.apiproject1.recommendlist.CpuItemActivity;

public class UsageActivity extends AppCompatActivity {

    Button btn_documentver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usage);

        Intent intent = getIntent();
        btn_documentver = (Button) findViewById(R.id.txt_document_ver);

        btn_documentver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), CpuItemActivity.class);
                startActivity(intent1);
            }
        });
    }
}
