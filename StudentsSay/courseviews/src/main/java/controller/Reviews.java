package controller;

import android.util.Log;
import com.gamingpc.studentssay.courseviews.ReviewAdapter;

import java.util.ArrayList;

/**
 * author: JJ Lindsay
 * version: 1.0
 * Course: ITEC 4550 Spring 2015
 * Written: 5/2/2015
 *
 * This class represents a
 *
 * Purpose: To retrieve all the corresponding reviews while hiding the how.
 */
public class Reviews
{
    private static ArrayList<Review> courseReviews;
    private Reviews()
    {}

    /**
     * returns a lis of all the reviews for the given course number
     * @param courseNumber the course number of interest
     * @return a list of Review objects
     */
    public static void findReviews(int courseNumber)
    {
        if (ReviewAdapter.getReviews(courseNumber) == null)
            courseReviews =  new ArrayList<>();
        else
            courseReviews =  new ArrayList<>(ReviewAdapter.getReviews(courseNumber));
    }

    /**
     * This is the initial call that pulls down all the server reviews
     */
    public static void pullLatestReviews()
    {
        new ReviewAdapter().startGetData();
    }

    /**
     * Updates the lists on the device
     * @param review The review being added
     */
    public static void addReview(Review review)
    {
        Log.d("AsyncTask", "ITEC: " + review.getCourseNum());

        //updates the temporary list
        courseReviews.add(review);

        //updates the raw data list
        ReviewAdapter.updateRawData(review);
    }

    public static ArrayList<Review> getReviewsList()
    {
        return courseReviews;
    }
}
