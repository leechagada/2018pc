package com.example.rkdls.apiproject1.recommendlist;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.example.rkdls.apiproject1.R;
import com.example.rkdls.apiproject1.data.MonitorItem;
import com.example.rkdls.apiproject1.listview.MyBaseAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MonitorItemActivity extends AppCompatActivity {

    public static final String TAG = "MonitorItemActivity";
    TextView monitor_result;

    ListView listView;
    MyBaseAdapter adapter;

    String[] productName;
    int[] price;
    String msg = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monitor_layout);

        monitor_result = (TextView) findViewById(R.id.monitor_result);

        Intent intent = getIntent(); // 앱에 데이터 넣은 것 intent 변수로 받아온 것

        MyAsyncTask mProcessTask = new MyAsyncTask();

        msg = intent.getStringExtra("keyword"); // samsung을 누르면 samsung이 keyowrd 값


//        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();

//        listView = (ListView) findViewById(R.id.ListView);
//        adapter = new MyBaseAdapter(this);

//        Resources res = getResources();
        // String 배열에 데이터 넣기

        // 항목별 이미지 한 개와, 텍스트 3개를 어댑터(데이터 관리 및 처리)에 넣는다.
//        adapter.addItem(new IconDataBox())

//        listView.setAdapter(adapter);

        mProcessTask.execute();
    }

    public class MyAsyncTask extends AsyncTask<String, Void, MonitorItem[]> {
        ProgressDialog progressDialog = new ProgressDialog(MonitorItemActivity.this);

        OkHttpClient client = new OkHttpClient();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //로딩 창 띄우기
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setMessage("\tLoading...");
            progressDialog.show();
        }

        @Override
        protected MonitorItem[] doInBackground(String... voids) {

//            HttpUrl.Builder urlBuilder = HttpUrl.parse("http://api.danawa.com/api/search/product/info?key=bc716b5130a42e5aa7b0534e25821e51&keyword=monitor&cate_c1=860&cate_c2=13735&mediatype=json&charset=utf8&sort=2").newBuilder();
//            urlBuilder.addQueryParameter()
//            String apiUrl="http://api.danawa.com/api/search/product/info?key=bc716b5130a42e5aa7b0534e25821e51&keyword=monitor&cate_c1=860&cate_c2=13735&cate_c3=14883&cate_c4=58970&mediatype=json&charset=utf8&start_no=100";
            String apiUrl = "";

            switch(msg){
                case "samsung":
                    apiUrl="http://api.danawa.com/api/search/product/info?key=bc716b5130a42e5aa7b0534e25821e51&keyword=monitor&cate_c1=860&cate_c2=13735&mediatype=json&charset=utf8&sort=2";
                    break;

                case "23":
                    apiUrl="http://api.danawa.com/api/search/product/info?key=bc716b5130a42e5aa7b0534e25821e51&keyword=monitor&cate_c1=860&cate_c2=13735&cate_c3=14883&cate_c4=58970&mediatype=json&charset=utf8&start_no=100";
                    break;
            }

            HttpUrl.Builder urlBuilder = HttpUrl.parse(apiUrl).newBuilder();

            String url = urlBuilder.build().toString();

            Request request = new Request.Builder().url(url).build();

            try{
                Response response = client.newCall(request).execute();

                Gson gson = new GsonBuilder().create();
                JsonParser parser = new JsonParser();

                JsonElement rootObject = parser.parse(response.body().charStream())
                        .getAsJsonObject().get("productList");

                MonitorItem[] items = gson.fromJson(rootObject, MonitorItem[].class);

                return items;
            } catch (Exception e){
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(MonitorItem[] result) {
            super.onPostExecute(result);
            progressDialog.dismiss();
            // 요청 결과 처리 ex. 화면 출력
            if(result.length > 0){
                MonitorItem[] item = result;

                for(int i = 0; i < result.length; i++){
                    if(item[i].getMaker() != null){ // maker 값이 null 이 아니면 출력
                        monitor_result.append("제조사: " + item[i].getMaker() + "\n");
                        monitor_result.append("최저가: " + String.valueOf(item[i].getMinPrice()) + "원\n\n");
                    }
                }
            }

//            Log.d("Result: ", aVoid.toString());

//            result.setText(aVoid.toString());
        }
    }
}
