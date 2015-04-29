package com.gamingpc.studentssay.courseviews;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

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
public class Summary extends Activity
{
    RatingBar ratingBar1, ratingBar2, ratingBar3;
    Button addReview, back, next;
    SeekBar seeker;
    TextView careerIntern, tools;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.summary);

        addReview = (Button)findViewById(R.id.button4);
        back = (Button)findViewById(R.id.button);
        next = (Button)findViewById(R.id.button5);
        careerIntern = (TextView)findViewById(R.id.textView21);
        tools = (TextView)findViewById(R.id.textView22);
        ratingBar1 = (RatingBar)findViewById(R.id.ratingBar);
        ratingBar2 = (RatingBar)findViewById(R.id.ratingBar2);
        ratingBar3 = (RatingBar)findViewById(R.id.ratingBar3);
        seeker = (SeekBar)findViewById(R.id.seekBar);
        seeker.setVisibility(View.VISIBLE);

        addReview.setOnClickListener(new AddRevListener());
        back.setOnClickListener(new BackListener());
        next.setOnClickListener(new NextListener());
    }

    //completed!
    class AddRevListener implements View.OnClickListener
    {

        @Override
        public void onClick(View view)
        {
            startActivity(new Intent(Summary.this, AddReview.class));
        }
    }

    class BackListener implements View.OnClickListener
    {

        @Override
        public void onClick(View view)
        {

        }
    }

    class NextListener implements View.OnClickListener
    {

        @Override
        public void onClick(View view)
        {

        }
    }
}