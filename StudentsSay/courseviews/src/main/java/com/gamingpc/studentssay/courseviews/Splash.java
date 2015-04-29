package com.gamingpc.studentssay.courseviews;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

/**
 * author: JJ Lindsay
 * version: 1.0
 * Course: ITEC 4550 Spring 2015
 * Written: 4/2/2015
 *
 * This class represents a ...
 *
 * Purpose: Allows the manipulation of a ...
 */
public class Splash extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        TimerTask task = new TimerTask()
        {
            @Override
            public void run()
            {
                finish();
                startActivity(new Intent(Splash.this, Main.class));
            }
        };

        Timer opening = new Timer();
        opening.schedule(task,3000);
    }
}
