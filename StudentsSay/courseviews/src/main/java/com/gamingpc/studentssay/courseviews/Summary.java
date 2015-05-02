package com.gamingpc.studentssay.courseviews;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import controller.Course;
import controller.Review;
import controller.Reviews;

import java.util.ArrayList;

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
    private RatingBar ratingBar1, ratingBar2, ratingBar3;
    private Button addReview, back, next;
    private SeekBar seeker;
    private TextView careerIntern, tools, title;
    private ArrayList<Review> currentCourseReviews;
    private int currentPos;

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
        seeker = (SeekBar)findViewById(R.id.seekBar2);
        title = (TextView)findViewById(R.id.textView);
//        back.setVisibility(View.INVISIBLE);

        //set seekbar to unchangeable
        seeker.setEnabled(false);

        //rtBar1, 2, 3 & seekBar2 & career & tools
        //sets the number of stars that will be fillable
        ratingBar1.setNumStars(5);
        ratingBar2.setNumStars(5);
        ratingBar3.setNumStars(5);

        //sets the rating bar to unchangeable
        ratingBar1.setIsIndicator(true);
        ratingBar2.setIsIndicator(true);
        ratingBar3.setIsIndicator(true);

        //set the stars that are filled
//        ratingBar1.setRating(2.0f);
//        ratingBar2.setRating(1.0f);
//        ratingBar3.setRating(4.0f);

//        careerIntern.setText("Yes");
//        tools.setText("Gimp/etc");
//        title.setText("Student Views On ITEC " + Course.getCourseNumber());
//        seeker.setProgress(25);

        initialReview();

        addReview.setOnClickListener(new AddRevListener());
        back.setOnClickListener(new BackListener());
        next.setOnClickListener(new NextListener());
    }

    private void initialReview()
    {
        currentCourseReviews = Reviews.getReviewsList();

        if (currentCourseReviews == null || !(currentCourseReviews.size() > 0))
        {
            ratingBar1.setRating(0f);
            ratingBar2.setRating(0f);
            ratingBar3.setRating(0f);
            title.setText("NO REVIEWS for ITEC " + Course.getCourseNumber());
            title.setTextColor(Color.RED);
            seeker.setProgress(0);
            back.setEnabled(false);
            next.setEnabled(false);

        }
        else
        {
            Log.d("Summary", "A" + currentCourseReviews.get(0).getGoodBk());

            ratingBar1.setRating(currentCourseReviews.get(0).getReadBk());
            ratingBar2.setRating(currentCourseReviews.get(0).getGoodBk());
            ratingBar3.setRating(currentCourseReviews.get(0).getProjects());
            careerIntern.setText(currentCourseReviews.get(0).getCareer());
            tools.setText(currentCourseReviews.get(0).getTools());
            title.setText("Student Views On ITEC " + Course.getCourseNumber());
            seeker.setProgress(currentCourseReviews.get(0).getWorkload());
            currentPos = 0;
        }
    }

    //completed!
    private class AddRevListener implements View.OnClickListener
    {
        @Override
        public void onClick(View view)
        {
            startActivity(new Intent(Summary.this, AddReview.class));
        }
    }

    private class BackListener implements View.OnClickListener
    {
        @Override
        public void onClick(View view)
        {
            if (currentPos > 0)
            {
                currentPos--;
                ratingBar1.setRating(currentCourseReviews.get(currentPos).getReadBk());
                ratingBar2.setRating(currentCourseReviews.get(currentPos).getGoodBk());
                ratingBar3.setRating(currentCourseReviews.get(currentPos).getProjects());
                careerIntern.setText(currentCourseReviews.get(currentPos).getCareer());
                tools.setText(currentCourseReviews.get(currentPos).getTools());
                title.setText("Student Views On ITEC " + Course.getCourseNumber());
                seeker.setProgress(currentCourseReviews.get(currentPos).getWorkload());
            }
            else
            {
                Toast.makeText(getApplicationContext(), "This is the first review.", Toast.LENGTH_LONG).show();

            }
        }
    }

    private class NextListener implements View.OnClickListener
    {
        @Override
        public void onClick(View view)
        {
            if (currentPos < currentCourseReviews.size()-1)
            {
                currentPos++;
                ratingBar1.setRating(currentCourseReviews.get(currentPos).getReadBk());
                ratingBar2.setRating(currentCourseReviews.get(currentPos).getGoodBk());
                ratingBar3.setRating(currentCourseReviews.get(currentPos).getProjects());
                careerIntern.setText(currentCourseReviews.get(currentPos).getCareer());
                tools.setText(currentCourseReviews.get(currentPos).getTools());
                title.setText("Student Views On ITEC " + Course.getCourseNumber());
                seeker.setProgress(currentCourseReviews.get(currentPos).getWorkload());
            }
            else
            {
                Toast.makeText(getApplicationContext(), "This is the last review.", Toast.LENGTH_LONG).show();
            }
        }
    }
}