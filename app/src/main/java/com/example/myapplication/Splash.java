package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        try
        {
            Thread.sleep(4000);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        startActivity(new Intent(this,MenuActivity.class));
        finish();
    }
}