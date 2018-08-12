package com.example.rkdls.apiproject1;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MonitorItemActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    TextView monitor_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monitor_layout);

        monitor_result = (TextView) findViewById(R.id.monitor_result);

        MyAsyncTask mProcessTask = new MyAsyncTask();
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
//            HttpUrl.Builder urlBuilder = HttpUrl.parse("http://api.danawa.com/api/search/product/info?key=bc716b5130a42e5aa7b0534e25821e51&keyword=cpu&mediatype=json&charset=utf8").newBuilder();
            HttpUrl.Builder urlBuilder = HttpUrl.parse("http://api.danawa.com/api/main/category/product/list?charset=euckr&key=bc716b5130a42e5aa7b0534e25821e51&cate1=860&cate2=13735&orderBy=minPriceDESC&limit=100&offset=0&mediatype=json").newBuilder();
//            urlBuilder.addQueryParameter()

            String url = urlBuilder.build().toString();

            Request request = new Request.Builder().url(url).build();

            try{
                Response response = client.newCall(request).execute();

                Gson gson = new GsonBuilder().create();
                JsonParser parser = new JsonParser();

//                JsonElement rootObject = parser.parse(response.body().charStream())
//                        .getAsJsonObject().get("productList");
                JsonElement rootObject = parser.parse(response.body().charStream())
                        .getAsJsonObject().get("productCategory").getAsJsonObject().get("product");
//                CpuItem[] items = gson.fromJson(rootObject, CpuItem[].class);
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
                for(MonitorItem item: result){
//                    cpu_result.append("상품명: " + item.getName() + "\n");
                    monitor_result.append("제조사: " + item.getMaker() + "\n");
                    monitor_result.append("최저가: " + String.valueOf(item.getMinPrice()) + "원\n");
//                    cpu_result.append("평균가: " + String.valueOf(item.getAvrPrice()) + "원\n\n");

                }
            }
//            Log.d("Result: ", aVoid.toString());

//            result.setText(aVoid.toString());
        }
    }
}
