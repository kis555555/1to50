package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.view.View.GONE;


public class loseActivity extends Activity
{
    Button addBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.include_view_lose);

        Button button1 = (Button) findViewById(R.id.losecheck) ;
        button1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(loseActivity.this,MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

}