package com.gamingpc.studentssay.courseviews;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import controller.Reviews;

import java.util.Timer;
import java.util.TimerTask;

/**
 * author: JJ Lindsay
 * version: 1.0
 * Course: ITEC 4550 - End of Semester Project
 * Written: 4/2/2015
 *
 * Purpose: To display the slash screen and play media. This is also where the AsyncTask is called from.
 */
public class Splash extends Activity
{
    private MediaPlayer opener;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Reviews.pullLatestReviews();  //alls the AsyncTask to get the latest reviews
        opener = new MediaPlayer();
        opener = MediaPlayer.create(this, R.raw.opening);
        opener.start();

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
        opening.schedule(task,3500);
    }
}
