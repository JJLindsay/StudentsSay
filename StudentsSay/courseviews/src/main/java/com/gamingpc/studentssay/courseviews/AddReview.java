package com.gamingpc.studentssay.courseviews;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import controller.Review;

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
public class AddReview extends Activity
{
    RatingBar ratingBar1, ratingBar2, ratingBar3;
    Button submit;
    SeekBar seeker;
    TextView careerIntern, tools;
    float discrete = 0;
    float start = 0;
    float end = 3;
    float start_pos = 0;
    int start_position = 0;
    int p;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_review);

        submit = (Button)findViewById(R.id.button3);
        careerIntern = (TextView)findViewById(R.id.textView17);
        tools = (TextView)findViewById(R.id.textView18);
        ratingBar1 = (RatingBar)findViewById(R.id.ratingBar4);
        ratingBar2 = (RatingBar)findViewById(R.id.ratingBar5);
        ratingBar3 = (RatingBar)findViewById(R.id.ratingBar6);
        seeker = (SeekBar)findViewById(R.id.seekBar);
        seeker.setVisibility(View.VISIBLE);

        start_position = (int)(((start_pos-start)/(end-start))*100);
        discrete = start_pos;
        seeker.setProgress(start_position);


        submit.setOnClickListener(new SubmitListener());
        seeker.setOnSeekBarChangeListener(new SeekerListener()); //this will send a post request
    }


    class SubmitListener implements View.OnClickListener
    {
        @Override
        public void onClick(View view)
        {
            //casted as int this retrieves the number of stars 1-5
            int readBk = (int)ratingBar1.getRating();
            int goodBk = (int)ratingBar2.getRating();
            int projects = (int)ratingBar3.getRating();

            if (p >= 0 && careerIntern.toString() != null && tools.toString() != null)
            {
                Review review = new Review(2120, readBk, goodBk, projects, p, careerIntern.toString(), tools.toString());
                //send this as a post not get to website
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Your review could not be added. Make sure you answer all fields.", Toast.LENGTH_LONG).show();
            }
        }
    }

    class SeekerListener implements SeekBar.OnSeekBarChangeListener
    {
//        int p = 0;

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
        {
            /*
            //this will increase the font with moving the seekerBar
            txtV.setTextSize(p);
             */
            //This is a textView being set with the progress
            //seekBarValue.setText(String.valueOf(progress));
            p=progress;


        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar)
        {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar)
        {
            if (p<30)
            {
                p=30;
                seeker.setProgress(p);
            }
        }
    }
}