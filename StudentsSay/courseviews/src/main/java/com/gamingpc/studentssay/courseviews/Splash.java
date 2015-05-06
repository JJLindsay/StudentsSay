package com.gamingpc.studentssay.courseviews;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;
import controller.Reviews;
import controller.WifiDialogFragment;

import java.util.Timer;
import java.util.TimerTask;

/**
 * author: JJ Lindsay
 * version: 1.0
 * Course: ITEC 4550 - End of Semester Project
 * Written: 4/2/2015
 *
 * Purpose: To display the slash screen and play media. This is also where the AsyncTask is called to load all the reviews.
 */
public class Splash extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

//        FragmentManager fragmentManager = getSupportFragmentManager();

        if (isNetworkAvailable())
        {
            Reviews.pullLatestReviews();  //calls the AsyncTask to get the latest reviews

            MediaPlayer opener = new MediaPlayer();
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
            opening.schedule(task, 3500);
        }
        else
        {
//            Toast.makeText(this, "A Network Connection is required to run this application", Toast.LENGTH_LONG).show();
            DialogFragment wifiDialog = new WifiDialogFragment();
            wifiDialog.show(this.getFragmentManager(), "wifi");

            TimerTask wifiTask = new TimerTask()
            {
                @Override
                public void run()
                {
                    finish();
                }
            };
            Timer closing = new Timer();
            closing.schedule(wifiTask, 3000);
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
