package com.gamingpc.studentssay.courseviews;

import android.os.AsyncTask;
import controller.Review;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;

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
    static final String GETURL = "https://studentssay-aljaccount.c9.io/reviews.txt";
    static final String POSTURL = "https://studentssay-aljaccount.c9.io/";

    static ArrayList<Review> reviewList = new ArrayList<Review>();

    public static ArrayList getReviews(int courseNum)
    {
        String rawReviews = HttpManager.getData(GETURL);
        if (rawReviews != null)
        {
            String[] temp = rawReviews.split("[\n]]");
            for(String element : temp)
            {
                //if the number for the course matches the parameter add it to the review list
                if(Integer.parseInt(element.substring(0,4)) == courseNum)
                {
                    String[] rev = element.split("[\t]]");
                    reviewList.add(new Review(Integer.parseInt(rev[0]), Integer.parseInt(rev[1]),
                            Integer.parseInt(rev[2]), Integer.parseInt(rev[3]), Integer.parseInt(rev[4]), rev[5], rev[6]));
                }
            }
        }
        return reviewList;
    }

    public void postReview(Review review)
    {
//        String parameters[] = { "itecnum", String.valueOf(review.getCourseNum()), "readbk",
//                String.valueOf(review.getReadBk()), "goodbk", String.valueOf(review.getGoodBk()),
//                "projects", String.valueOf(review.getProjects()), "workload", String.valueOf(review.getWorkload()),
//                "career", review.getCareer(), "tools", review.getTools()};
//
//
//            HttpManager.postData(POSTURI, parameters);

        PostTask postTask = new PostTask();
        postTask.execute("itecnum", String.valueOf(review.getCourseNum()), "readbk",
                String.valueOf(review.getReadBk()), "goodbk", String.valueOf(review.getGoodBk()),
                "projects", String.valueOf(review.getProjects()), "workload", String.valueOf(review.getWorkload()),
                "career", review.getCareer(), "tools", review.getTools());

    }

    class GetTask extends AsyncTask<String, Void, String>
    {

        @Override
        protected String doInBackground(String... strings)
        {
            HttpManager.getData(GETURL);
            return null;
        }
    }


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
}