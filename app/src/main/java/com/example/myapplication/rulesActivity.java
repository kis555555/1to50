package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class rulesActivity extends Activity
{
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rules_activity);
    }

    @Override
    public void onBackPressed()
    {
        Intent intent=new Intent(rulesActivity.this,MenuActivity.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }
}