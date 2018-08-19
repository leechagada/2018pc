package com.example.rkdls.apiproject1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class RecommendListActivity extends AppCompatActivity {
    ListView listView;
//    MyBaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend_list);

        listView = (ListView) findViewById(R.id.ListView);

//        adapter = new MyBaseAdapter(this);
//        Resources res = getResources();
//
//        final String[] txt_component =

//        listView.setAdapter(adapter);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String[] currentData = currentItem.getData();
//            }
//        });

//        @Override
//        public boolean onCreateOptionsMenu(Menu menu) {
//            getMenuInflater().inflate(R.);
//
//            return super.onCreateOptionsMenu(menu);
//        }

    }
}
