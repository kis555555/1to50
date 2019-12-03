package com.example.myapplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.content.Intent;
import android.os.CountDownTimer;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Random;

public class MainActivity extends Activity
{
    View[] include = new View[2];
    TextView now_number;
    RelativeLayout[] button = new RelativeLayout[25];
    TextView[] button_text = new TextView[25];
    RelativeLayout ok_button;
    private static final int MILLISINFUTURE = 11*6000; // 오른쪽 값으로 설정함.
    private static final int COUNT_DOWN_INTERVAL = 1000;

    private int count = 60;
    private TextView countTxt ;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        all_view();
        include[0].setVisibility(View.VISIBLE); // 게임 화면
        include[1].setVisibility(View.GONE); // 승리 화면
        game();
        countTxt = (TextView)findViewById(R.id.count_txt);
        countDownTimer();
        countDownTimer.start();
        all_button_click();

    }
    @Override
    public void onBackPressed()
    {
        Intent intent=new Intent(MainActivity.this,MenuActivity.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }
    int number_group1, number_group2;
    private void game() {
        now_number.setText(Integer.toString(match_number_int));
        for(number_group1 = 1; number_group1 <= 2; number_group1++) {
            for(number_group2 = 1; number_group2 <= 25; number_group2++) {
                random();
            }
        }
        for(int print_button_num = 0; print_button_num <= 24; print_button_num++) {
            button_text[print_button_num].setText(Integer.toString(button_number_01[print_button_num]));
        }
    }
    int match_number_int = 1;
    int random_button_number_int;
    int[] button_number_01 = new int[25];
    int[] button_number_02 = new int[25];
    private void random() {
        Random random = new Random();
        random_button_number_int = random.nextInt(25);
        if(number_group1 == 1 && button_number_01[(random_button_number_int)] == 0) {
            button_number_01[(random_button_number_int)] = number_group2;
        }else if(number_group1 == 1 && number_group2 <= 25){
            random();
        }
        if(number_group1 == 2 && button_number_02[(random_button_number_int)] == 0) {
            button_number_02[(random_button_number_int)] = (number_group2+25);
        }else if(number_group1 == 2 && number_group2 <= 25){
            random();
        }
    }
    private void all_view() {
        include[0] = findViewById(R.id.include_game_view);
        include[1] = findViewById(R.id.include_success_view);
        now_number = (TextView)findViewById(R.id.now_number);
        button[0] = (RelativeLayout)findViewById(R.id.button_1);
        button[1] = (RelativeLayout)findViewById(R.id.button_2);
        button[2] = (RelativeLayout)findViewById(R.id.button_3);
        button[3] = (RelativeLayout)findViewById(R.id.button_4);
        button[4] = (RelativeLayout)findViewById(R.id.button_5);
        button[5] = (RelativeLayout)findViewById(R.id.button_6);
        button[6] = (RelativeLayout)findViewById(R.id.button_7);
        button[7] = (RelativeLayout)findViewById(R.id.button_8);
        button[8] = (RelativeLayout)findViewById(R.id.button_9);
        button[9] = (RelativeLayout)findViewById(R.id.button_10);
        button[10] = (RelativeLayout)findViewById(R.id.button_11);
        button[11] = (RelativeLayout)findViewById(R.id.button_12);
        button[12] = (RelativeLayout)findViewById(R.id.button_13);
        button[13] = (RelativeLayout)findViewById(R.id.button_14);
        button[14] = (RelativeLayout)findViewById(R.id.button_15);
        button[15] = (RelativeLayout)findViewById(R.id.button_16);
        button[16] = (RelativeLayout)findViewById(R.id.button_17);
        button[17] = (RelativeLayout)findViewById(R.id.button_18);
        button[18] = (RelativeLayout)findViewById(R.id.button_19);
        button[19] = (RelativeLayout)findViewById(R.id.button_20);
        button[20] = (RelativeLayout)findViewById(R.id.button_21);
        button[21] = (RelativeLayout)findViewById(R.id.button_22);
        button[22] = (RelativeLayout)findViewById(R.id.button_23);
        button[23] = (RelativeLayout)findViewById(R.id.button_24);
        button[24] = (RelativeLayout)findViewById(R.id.button_25);
        button_text[0] = (TextView)findViewById(R.id.button_text_1);
        button_text[1] = (TextView)findViewById(R.id.button_text_2);
        button_text[2] = (TextView)findViewById(R.id.button_text_3);
        button_text[3] = (TextView)findViewById(R.id.button_text_4);
        button_text[4] = (TextView)findViewById(R.id.button_text_5);
        button_text[5] = (TextView)findViewById(R.id.button_text_6);
        button_text[6] = (TextView)findViewById(R.id.button_text_7);
        button_text[7] = (TextView)findViewById(R.id.button_text_8);
        button_text[8] = (TextView)findViewById(R.id.button_text_9);
        button_text[9] = (TextView)findViewById(R.id.button_text_10);
        button_text[10] = (TextView)findViewById(R.id.button_text_11);
        button_text[11] = (TextView)findViewById(R.id.button_text_12);
        button_text[12] = (TextView)findViewById(R.id.button_text_13);
        button_text[13] = (TextView)findViewById(R.id.button_text_14);
        button_text[14] = (TextView)findViewById(R.id.button_text_15);
        button_text[15] = (TextView)findViewById(R.id.button_text_16);
        button_text[16] = (TextView)findViewById(R.id.button_text_17);
        button_text[17] = (TextView)findViewById(R.id.button_text_18);
        button_text[18] = (TextView)findViewById(R.id.button_text_19);
        button_text[19] = (TextView)findViewById(R.id.button_text_20);
        button_text[20] = (TextView)findViewById(R.id.button_text_21);
        button_text[21] = (TextView)findViewById(R.id.button_text_22);
        button_text[22] = (TextView)findViewById(R.id.button_text_23);
        button_text[23] = (TextView)findViewById(R.id.button_text_24);
        button_text[24] = (TextView)findViewById(R.id.button_text_25);
        ok_button = (RelativeLayout)findViewById(R.id.ok_button);
    }
    int button_num;
    private void all_button_click()
    {
        for (int i = 0; i < 25; i++) // 버튼이 총 25개 이므로 25번 반복함
        {
            final int j = i;
            button[j].setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    if(match_number_int == 50) // 숫자 50까지 다 눌러졌으면
                    {
                        countDownTimer.cancel(); // 현재 타이머를 멈춘다
                        include[1].setVisibility(View.VISIBLE); // 승리 화면을 보여줌
                        include[0].setVisibility(View.GONE); // 현재 게임 창을 가림
                    }
                    int number = j; // 아직 눌러야 할 숫자들이 남아 있을 시
                    if(match_number_int == button_number_01[number])
                    { // 현재 누른 숫자와, 버튼01에 있는 숫자가 동일 하다면,
                        match_number_int += 1; // 현재 누른 숫자 값을 1 증가 시키고
                        button_text[number].setText(Integer.toString(button_number_02[number]));
                    } // 버튼02에 있는 26~50까지의 숫자를 하나씩 채워 넣는다.
                    if(match_number_int == button_number_02[number])
                    {
                        match_number_int += 1;
                        button_text[number].setVisibility(View.GONE);
                    }
                    now_number.setText(Integer.toString(match_number_int));
                }
            });
        }

        ok_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                match_number_int = 1;
                for(int reset_button_number = 0; reset_button_number <= 24; reset_button_number++) {
                    button_number_01[reset_button_number] = 0;
                    button_number_02[reset_button_number] = 0;
                    button_text[reset_button_number].setVisibility(View.VISIBLE);
                }
                include[0].setVisibility(View.VISIBLE);
                include[1].setVisibility(View.GONE);


                String point = count +"";

                Intent getintent = getIntent();
                String name = getintent.getExtras().getString("name");
                //Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();

                insertoToDatabase(name,point);

                Intent intent=new Intent(MainActivity.this,MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void countDownTimer()
    {

        countDownTimer = new CountDownTimer(MILLISINFUTURE, COUNT_DOWN_INTERVAL)
        { // millisInFuture 는 타이머가 동작할 총 시간을 의미한다.

            public void onTick(long millisUntilFinished)
            {
                countTxt.setText(String.valueOf(count));
                count --;


                if(count <= 9 && count >= 0) // 현재 타이머가 10 이하로 떨어지면 빨간색으로 바꿈
                {
                    countTxt.setTextColor(Color.RED);
                }
                if(count == -1) // 타이머가 -1이 되면 타이머를 멈추고 게임을 종료함.
                {
                    onFinish();
                    countDownTimer.cancel();
                }
            }
            public void onFinish ()
            {
                Intent intent=new Intent(MainActivity.this,loseActivity.class);
                startActivity(intent);
                finish();
            }
        };
    }
    @Override
    public void onDestroy()
    {
        super.onDestroy();
        try
        {
            countDownTimer.cancel();
        }
        catch (Exception e)
        {}
        countDownTimer=null;
    }

    private void insertoToDatabase(String name, String point) {
        class InsertData extends AsyncTask<String, Void, String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(MainActivity.this, "Please Wait", null, true, true);
            }
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
            }
            @Override
            protected String doInBackground(String... params) {

                try {
                    String name = (String) params[0];
                    String point = (String) params[1];

                    String link = "http://kis2702.dothome.co.kr/post.php";
                    String data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8");
                    data += "&" + URLEncoder.encode("point", "UTF-8") + "=" + URLEncoder.encode(point, "UTF-8");

                    URL url = new URL(link);
                    URLConnection conn = url.openConnection();

                    conn.setDoOutput(true);
                    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

                    wr.write(data);
                    wr.flush();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                    StringBuilder sb = new StringBuilder();
                    String line = null;

                    // Read Server Response
                    while ((line = reader.readLine()) != null) {
                        sb.append(line);
                        break;
                    }
                    return sb.toString();
                } catch (Exception e) {
                    return new String("Exception: " + e.getMessage());
                }
            }
        }
        InsertData task = new InsertData();
        task.execute(name, point);
    }
}
