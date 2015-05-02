package com.gamingpc.studentssay.courseviews;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import controller.Review;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

/**
 * author: JJ Lindsay
 * version: 1.0
 * Course: ITEC 4550 Spring 2015
 * Written: 4/30/2015
 *
 * This class represents a ...
 *
 * Purpose: Allows the manipulation of a ...
 */
public class ReviewAdapter
{
    private static final String GETURL = "https://studentssay-aljaccount.c9.io/reviews.txt";
    private static final String POSTURL = "https://studentssay-aljaccount.c9.io/";
    private static String rawReviews;

    //This is a list holding only the reviews of interest
    //chosen over Set so forward and backward traversal is easier
    private static ArrayList<Review> reviewsList;

    /**start this early
     * This starts during the Splash screen and retrieves all the raw data
     */
    public void startGetData()
    {
        GetTask getTask = new GetTask();
        getTask.execute(GETURL);
    }

    /**
     * This searches the raw data and returns only the reviews of interest
     * @param courseNum  Course number of interest
     * @return ArrayList of reviews pertaining to the course number
     */
    public static ArrayList<Review> getReviews(int courseNum)
    {
        double x =0.0;
        while(x<20)
        {
            x++;
        }

        Log.d("Element1", "outside");

        if (rawReviews != null)
        {
            Log.d("Element2", "entered");

            String[] temp = rawReviews.split("[\n]");
            reviewsList = new ArrayList<>();
            for(String element : temp)
            {
                Log.d("Element3", "" + element);

                //if the number for the course matches the parameter add it to the review list
                if(element.length() > 4 && Integer.parseInt(element.substring(0,4)) == courseNum)
                {
                    String[] rev = element.split("[\t]");
                    reviewsList.add(new Review(Integer.parseInt(rev[0].trim()), Integer.parseInt(rev[1].trim()),
                            Integer.parseInt(rev[2].trim()), Integer.parseInt(rev[3].trim()),
                            Integer.parseInt(rev[4].trim()), rev[5].trim(), rev[6].trim()));
                    Log.d("AsyncTask4", "ITEC: " + Integer.parseInt(rev[0].trim()) + " Read: " + Integer.parseInt(rev[1].trim()) + " Good: " +
                            Integer.parseInt(rev[2].trim()) + " Projects: " + Integer.parseInt(rev[3].trim()) + " Work: " +
                            Integer.parseInt(rev[4].trim()) + " Career: " + rev[5].trim() + " Tools: " + rev[6].trim());
                }
            }
        }
        return reviewsList;
    }

    /**
     * This unpacks the review object and formats it for the HTTP POST Request
     * @param review The object to be sent to the server
     */
    public void postReview(Review review)
    {
        PostTask postTask = new PostTask();
        postTask.execute("itecnum", String.valueOf(review.getCourseNum()), "readbk",
                String.valueOf(review.getReadBk()), "goodbk", String.valueOf(review.getGoodBk()),
                "projects", String.valueOf(review.getProjects()), "workload", String.valueOf(review.getWorkload()),
                "career", review.getCareer(), "tools", review.getTools());

    }

    //AsyncTask GetTask connection to main thread
    protected void setReviewsData(String reviewsData)
    {
        rawReviews = reviewsData;
        Log.d("AsyncTask5", "AsyncTask Completed!");
    }

    /**
     * AsyncTask for the the HTTP Get Request
     */
    class GetTask extends AsyncTask<String, Void, String>
    {
        @Override
        protected String doInBackground(String... attributes)
        {
            //Returns all the reviews, separating them by newline
            return HttpManager.getData(GETURL);
        }

        //makes the Async results accessible on the main thread
        @Override
        protected void onPostExecute(String result)
        {
            setReviewsData(result);
        }
    }

    /**
     * AsyncTask class for HTTP POST Request to the server
     */
    class PostTask extends AsyncTask<String, Void, String>
    {
        protected String doInBackground(String... attributes) {
            try {

                String parameters[] = { attributes[0], attributes[1], attributes[2], attributes[3],
                        attributes[4], attributes[5], attributes[6], attributes[7], attributes[8], attributes[9],
                        attributes[10], attributes[11], attributes[12], attributes[13]};

                HttpManager.postData(POSTURL, parameters);

            } catch (Exception e) {
                return null;
            }
            return null;
        }
    }

    /**
     * Updates the raw reviews data
     * @param review
     */
    public static void updateRawData(Review review)
    {
        String temp = "\n" + review.getCourseNum() + "\t" + review.getReadBk() + "\t" + review.getGoodBk() + "\t" +
        review.getProjects() + "\t" + review.getWorkload() + "\t" + review.getCareer() + "\t" + review.getTools();

        //update the raw Data review string
        rawReviews += temp;


//        String tem = ""+review.getCourseNum()""	 "+review.getReadBk()"	 "+"review.getGoodBk()	 "+
//                "review.getProjects()	 "+"review.getWorkload()	 "+"review.getCareer()	 "+"review.getTools()";
    }
}