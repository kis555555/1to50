package com.example.myapplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MenuActivity extends Activity
{
    Button start;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        start = (Button)findViewById(R.id.start);
    }

    public void startclick(View v)
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(this); // 네모난 창 하나 띄움

        alert.setTitle("닉네임을 입력하세요");

        final EditText username = new EditText(this); // 텍스트 값을 입력 하기 위해 선언해줌
        alert.setView(username); // 네모난 창에 EditText를 표시해줌

        alert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) { // ok 버튼을 눌렀으면
                String name = username.getText().toString();

                Intent intent=new Intent(MenuActivity.this,MainActivity.class);
                intent.putExtra("name",name);
                startActivity(intent);
                finish();
                // MainActivity로 name 값을 넘겨줌
            }
        });

        alert.setNegativeButton("no",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

            }
        });
        // No를 입력하면 취소
        alert.show();
    }
    public void rankclick(View v) // 랭킹
    {
        Intent intent=new Intent(MenuActivity.this,rankActivity.class);
        startActivity(intent);
        finish();
    }
    public void ruleclick(View v) // 규칙
    {
        Intent intent=new Intent(MenuActivity.this,rulesActivity.class);
        startActivity(intent);
        finish();
    }
    public void finishclick(View v)
    {
        System.exit(0);
    } // 종료
}
