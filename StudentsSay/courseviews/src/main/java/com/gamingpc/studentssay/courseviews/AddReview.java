package com.gamingpc.studentssay.courseviews;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import controller.Course;
import controller.Courses;
import controller.Review;
import controller.Reviews;

/**
 * author: JJ Lindsay
 * version: 1.0
 * Course: ITEC 4550 - End of Semester Project
 * Written: 4/2/2015
 *
 * Purpose: Allows the manipulation of a ...
 */
public class AddReview extends Activity
{
    RatingBar ratingBar1, ratingBar2, ratingBar3;
    Button submit;
    SeekBar seeker;
    EditText careerIntern, tools;
    TextView title;
    float discrete = 0;
//    float start = 0;
//    float end = 3;
    float start_pos = 0;
//    int start_position = 0;
    int p;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_review);

        title = (TextView)findViewById(R.id.textView7);
        submit = (Button)findViewById(R.id.button3);
        careerIntern = (EditText)findViewById(R.id.edittext17);
        tools = (EditText)findViewById(R.id.edittext18);
        ratingBar1 = (RatingBar)findViewById(R.id.ratingBar4);
        ratingBar2 = (RatingBar)findViewById(R.id.ratingBar5);
        ratingBar3 = (RatingBar)findViewById(R.id.ratingBar6);
        seeker = (SeekBar)findViewById(R.id.seekBar);

        title.setText("ITEC " + Course.getCourseNumber()+ " " + Courses.getCourseList().get(Course.getCourseNumber()));

        //sets the number of visible stars
        ratingBar1.setNumStars(5);
        ratingBar2.setNumStars(5);
        ratingBar3.setNumStars(5);

        //sets the step of the rating 0.0f - 1f
        ratingBar1.setStepSize(1.0f);
        ratingBar2.setStepSize(1.0f);
        ratingBar3.setStepSize(1.0f);

//        start_position = (int)(((start_pos-start)/(end-start))*100);
        discrete = start_pos;
        seeker.setProgress(0);


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

            if (p >= 0 && !(careerIntern.getText().toString().equals("")) && !(tools.getText().toString().equals("")))
            {
                Review review = new Review(Course.getCourseNumber(), readBk, goodBk, projects, p,
                        careerIntern.getText().toString(), tools.getText().toString());

                //this is to post to the website
                new ReviewAdapter().postReview(review);

                //updates the list on the device, retrieved via HTTPGet request during the Splash Screen
                Reviews.addReview(review);
                Toast.makeText(getApplicationContext(), "Excellent! Your review has been added.", Toast.LENGTH_LONG).show();
                startActivity(new Intent(AddReview.this, Main.class));
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
            p=progress; //this can be seen moving automatically in log just after creating apk and running


        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar)
        {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar)
        {
//            if (p<30)
//            {
                seeker.setProgress(p);
//            }
        }
    }
}