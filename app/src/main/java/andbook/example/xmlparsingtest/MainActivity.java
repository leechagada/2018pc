package andbook.example.xmlparsingtest;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String loadedXMLString = loadXML(); //결과값 반환

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();//이걸 이용해서 태그기반의 xml을 이용한다.
            XmlPullParser parser = factory.newPullParser();
            parser.setInput( new StringReader(loadedXMLString));

            Log.i("====parser===", "loaded!");

        } catch (Exception e){

        }


    }

    // load xml String to String
    private String loadXML() {
        AssetManager assetManager = getResources().getAssets();
        AssetManager.AssetInputStream ais = null;

        try {
            ais = (AssetManager.AssetInputStream)assetManager.open("mainboard.xml");

        } catch (Exception e){
            e.printStackTrace();
        }

        Log.d("======","loaded");

        BufferedReader br = new BufferedReader(new InputStreamReader(ais));

        String line;//문자열 생성
        StringBuilder sb = new StringBuilder();

        try{
            while ((line = br.readLine())!= null){
                sb.append(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        Log.d("===000===", "lines loaded");
        Log.i("loaded", sb.toString());

        return sb.toString();
    }
}
