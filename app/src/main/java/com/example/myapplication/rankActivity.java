package com.example.myapplication;

import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;

import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class rankActivity extends Activity
{
    Button button;
    TextView [] rankname = new TextView[10];
    TextView [] ranktime = new TextView[10];
    String []name = new String[10];
    String []point = new String[10];

    private static String URL_LOGIN = "http://kis2702.dothome.co.kr/json.php";;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rank_activity);

        rankname[0] = findViewById(R.id.rank1name);
        ranktime[0] = findViewById(R.id.rank1time);

        rankname[1] = findViewById(R.id.rank2name);
        ranktime[1] = findViewById(R.id.rank2time);

        rankname[2] = findViewById(R.id.rank3name);
        ranktime[2] = findViewById(R.id.rank3time);

        rankname[3] = findViewById(R.id.rank4name);
        ranktime[3] = findViewById(R.id.rank4time);

        rankname[4] = findViewById(R.id.rank5name);
        ranktime[4] = findViewById(R.id.rank5time);

        rankname[5] = findViewById(R.id.rank6name);
        ranktime[5] = findViewById(R.id.rank6time);

        rankname[6] = findViewById(R.id.rank7name);
        ranktime[6] = findViewById(R.id.rank7time);

        rankname[7] = findViewById(R.id.rank8name);
        ranktime[7] = findViewById(R.id.rank8time);

        rankname[8] = findViewById(R.id.rank9name);
        ranktime[8] = findViewById(R.id.rank9time);

        rankname[9] = findViewById(R.id.rank10name);
        ranktime[9] = findViewById(R.id.rank10time);



        //button = (Button) findViewById(R.id.button);


        //button.setOnClickListener(new View.OnClickListener() {
           // @Override
           // public void onClick(View v) {

                URLConnector url = new URLConnector();
                url.start();
                try {
                    url.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String result = url.getTemp();

                System.out.println(ParseJSON(result));

                ParseJSON(result);
           // }
       // });
    }


    public String ParseJSON(String target) // JSON 파싱 시작
    { // JSON은 키 값 또는 속성 값으로 이루어진 데이터를 텍스트로 읽어 받기 위한 포맷임
        try {

            JSONObject json = new JSONObject(target); // 제이슨 객체를 생성
            // 참고로 target은 URLConnector라는 클래스에서 전달 받은 DB에 저장된 스트링 문자열들임.
            // URLConnector은 DB 값들을 불러와서 리턴하는 역할을 하는 클래스임
            JSONArray arr = json.getJSONArray("result"); // 제이슨 배열을 가져오기 위해 선언
            // result는 php에서 데이터 값을 가져오기 위한 키 값임

            for(int i = 0; i < arr.length(); i++)
            {
                JSONObject json2 = arr.getJSONObject(i); // 배열에 저장된 JSON 값들을 json2에 저장해줌

                if(i < 10) // 랭킹을 10위까지 출력 하기 위해서 10 단위로 끊어버림
                {
                    name[i] = json2.getString("name"); // 이름을 불러와서 name[i]에 저장
                    point[i] = json2.getString("point"); // 클리어 타임을 불러와서 point[i]에 저장
                }


            }

            rankname[0].setText(name[0]);
            ranktime[0].setText(point[0]);

            rankname[1].setText(name[1]);
            ranktime[1].setText(point[1]);

            rankname[2].setText(name[2]);
            ranktime[2].setText(point[2]);

            rankname[3].setText(name[3]);
            ranktime[3].setText(point[3]);

            rankname[4].setText(name[4]);
            ranktime[4].setText(point[4]);

            rankname[5].setText(name[5]);
            ranktime[5].setText(point[5]);

            rankname[6].setText(name[6]);
            ranktime[6].setText(point[6]);

            rankname[7].setText(name[7]);
            ranktime[7].setText(point[7]);

            rankname[8].setText(name[8]);
            ranktime[8].setText(point[8]);

            rankname[9].setText(name[9]);
            ranktime[9].setText(point[9]);




            //return "";
        }

        catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public void onBackPressed()
    {
        Intent intent=new Intent(rankActivity.this,MenuActivity.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }

}




