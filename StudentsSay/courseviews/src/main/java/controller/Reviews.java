package controller;

import com.gamingpc.studentssay.courseviews.ReviewAdapter;

import java.util.LinkedHashSet;

/**
 * author: JJ Lindsay
 * version: 1.0
 * Course: ITEC 4550 Spring 2015
 * Written: 5/2/2015
 *
 * This class represents a ...
 *
 * Purpose: Allows the manipulation of a ...
 */
public class Reviews
{
    private Reviews()
    {}

    public static LinkedHashSet getReviews(int courseNumber)
    {
        ReviewAdapter.getReviews(courseNumber);
        return null;
    }

}
