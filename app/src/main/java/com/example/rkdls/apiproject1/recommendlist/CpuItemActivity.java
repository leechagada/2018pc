package com.example.rkdls.apiproject1.recommendlist;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.rkdls.apiproject1.R;
import com.example.rkdls.apiproject1.data.CpuItem;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CpuItemActivity extends AppCompatActivity {

    public static final String TAG = "CpuItemActivity";
    TextView cpu_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cpu_layout);

        Intent intent = getIntent();

        cpu_result = (TextView) findViewById(R.id.cpu_result);
//        result.setMovementMethod(new ScrollingMovementMethod()); // 스크롤 기능

        MyAsyncTask mProcessTask = new MyAsyncTask();
        mProcessTask.execute();

    }

    public class MyAsyncTask extends AsyncTask<String, Void, CpuItem[]>{
        ProgressDialog progressDialog = new ProgressDialog(CpuItemActivity.this);

        OkHttpClient client = new OkHttpClient();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setMessage("\tLoading...");
            progressDialog.show();
        }

        @Override
        protected CpuItem[] doInBackground(String... voids) {
            HttpUrl.Builder urlBuilder = HttpUrl.parse("http://api.danawa.com/api/search/product/info?key=bc716b5130a42e5aa7b0534e25821e51&keyword=cpu&mediatype=json&charset=utf8").newBuilder();
//            urlBuilder.addQueryParameter()

            String url = urlBuilder.build().toString();

            Request request = new Request.Builder().url(url).build();

            try{
                Response response = client.newCall(request).execute();

                Gson gson = new GsonBuilder().create();
                JsonParser parser = new JsonParser();

                JsonElement rootObject = parser.parse(response.body().charStream())
                        .getAsJsonObject().get("productList");
                CpuItem[] items = gson.fromJson(rootObject, CpuItem[].class);

                return items;
            } catch (Exception e){
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(CpuItem[] result) {
            super.onPostExecute(result);
            progressDialog.dismiss();
            // 요청 결과 처리 ex. 화면 출력
            if(result.length > 0){
                for(CpuItem item: result){
                    cpu_result.append("상품명: " + item.getName() + "\n");
                    cpu_result.append("제조사: " + item.getMaker() + "\n");
                    cpu_result.append("최저가: " + String.valueOf(item.getMinPrice()) + "원\n");
//                    cpu_result.append("평균가: " + String.valueOf(item.getAvrPrice()) + "원\n\n");
                    cpu_result.append("제품 정보: " + item.getDanawaUrl() + "\n\n");

                }
            }
//            Log.d("Result: ", result.toString());

//            cpu_result.setText(result.toString());
        }
    }
}