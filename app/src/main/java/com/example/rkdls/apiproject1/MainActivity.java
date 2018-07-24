package com.example.rkdls.apiproject1;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView) findViewById(R.id.result);

        MyAsyncTask mProcessTask = new MyAsyncTask();
        mProcessTask.execute();
    }

    public class MyAsyncTask extends AsyncTask<String, Void, String>{
        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);

        OkHttpClient client = new OkHttpClient();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setMessage("\tLoading...");
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... voids) {
            HttpUrl.Builder urlBuilder = HttpUrl.parse("http://api.danawa.com/api/search/product/info?key=bc716b5130a42e5aa7b0534e25821e51&keyword=cpu&mediatype=xml&charset=utf8").newBuilder();
//            urlBuilder.addQueryParameter()

            String url = urlBuilder.build().toString();

            Request request = new Request.Builder().url(url).build();

            try{
                Response response = client.newCall(request).execute();


                return response.body().string();
            } catch (Exception e){
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String aVoid) {
            super.onPostExecute(aVoid);
            progressDialog.dismiss();
            Log.d("Result: ", aVoid.toString());

            result.setText(aVoid.toString());

        }
    }
}