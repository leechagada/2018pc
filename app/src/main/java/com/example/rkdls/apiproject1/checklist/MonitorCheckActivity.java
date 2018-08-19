package com.example.rkdls.apiproject1.checklist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.rkdls.apiproject1.R;
import com.example.rkdls.apiproject1.recommendlist.MonitorItemActivity;

public class MonitorCheckActivity extends AppCompatActivity {

    ImageButton btn_search;
    CheckBox cb_price_all, cb_size_all, cb_samsung, cb_lg, cb_etc, cb_23, cb_24, cb_27, cb_30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor_check);

        Intent intent = getIntent();

        btn_search = (ImageButton) findViewById(R.id.btn_search);
        cb_price_all = (CheckBox) findViewById(R.id.cb_price_all);
        cb_samsung = (CheckBox) findViewById(R.id.cb_samsung);
        cb_lg = (CheckBox) findViewById(R.id.cb_lg);
        cb_etc = (CheckBox) findViewById(R.id.cb_etc);

        cb_size_all = (CheckBox) findViewById(R.id.cb_size_all);
        cb_23 = (CheckBox) findViewById(R.id.cb_23);
        cb_24 = (CheckBox) findViewById(R.id.cb_24_26);
        cb_27 = (CheckBox) findViewById(R.id.cb_27_29);
        cb_30 = (CheckBox) findViewById(R.id.cb_30);

        // 모두 누르면 전체선택, 다시 누르면 전체해제
        cb_price_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cb_price_all.isChecked() == true) {
                    cb_samsung.setChecked(true);
                    cb_lg.setChecked(true);
                    cb_etc.setChecked(true);
                } else {
                    cb_samsung.setChecked(false);
                    cb_lg.setChecked(false);
                    cb_etc.setChecked(false);
                }
            }
        });


        cb_size_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cb_size_all.isChecked() == true) {
                    cb_23.setChecked(true);
                    cb_24.setChecked(true);
                    cb_27.setChecked(true);
                    cb_30.setChecked(true);
                } else {
                    cb_23.setChecked(false);
                    cb_24.setChecked(false);
                    cb_27.setChecked(false);
                    cb_30.setChecked(false);
                }
            }
        });

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isChecked2()) {
                    checkContent();
                    Intent intent = new Intent(getApplicationContext(), MonitorItemActivity.class);

                    intent.putExtra("keyword", checked(view));
                    startActivity(intent);
                } else
                    Toast.makeText(getApplicationContext(),
                            "선택 사항이 없습니다.",
                            Toast.LENGTH_SHORT).show();
            }
        });
    }

    public boolean isChecked2() {
        boolean result;
        if (cb_price_all.isChecked() || cb_samsung.isChecked() || cb_lg.isChecked() || cb_etc.isChecked()
                || cb_size_all.isChecked() || cb_23.isChecked() || cb_24.isChecked() || cb_27.isChecked() || cb_30.isChecked())
            result = true;
        else
            result = false;

        return result;
    }

    public void checkContent() {

        cb_samsung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checked(view); // 체크되었을 때 동작코드
            }
        });

        cb_23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checked(view);
            }
        });

    }

    public String checked(View v) {
        String result = "";

        if (cb_samsung.isChecked())
            result = "samsung";

        if (cb_23.isChecked())
            result = "23";

        return result;
    }
}
