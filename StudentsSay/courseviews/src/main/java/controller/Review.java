package controller;

import java.util.ArrayList;

/**
 * author: JJ Lindsay
 * version: 1.0
 * Course: ITEC 4550 - End of Semester Project
 * Written: 4/26/2015
 *
 * Purpose: To create a single review
 */
public class Review
{
    float readBk, goodBk, projects;
    int workload;
    String career, tools;
    int courseNum;
    static ArrayList<Review> reviewList = new ArrayList<Review>();

    public Review(int courseNumber, int aReadBk, int aGoodBk, int aProjects, int aWorkload, String aCareer, String aTools)
    {
        this.courseNum = courseNumber;
        this.readBk = aReadBk;
        this.goodBk = aGoodBk;
        this.projects = aProjects;
        this.workload = aWorkload;
        this.career = aCareer;
        this.tools = aTools;
    }

    public float getReadBk()
    {
        return readBk;
    }

    public void setReadBk(int readBk)
    {
        this.readBk = readBk;
    }

    public float getGoodBk()
    {
        return goodBk;
    }

    public void setGoodBk(int goodBk)
    {
        this.goodBk = goodBk;
    }

    public float getProjects()
    {
        return projects;
    }

    public void setProjects(int projects)
    {
        this.projects = projects;
    }

    public int getWorkload()
    {
        return workload;
    }

    public void setWorkload(int workload)
    {
        this.workload = workload;
    }

    public String getCareer()
    {
        return career;
    }

    public void setCareer(String career)
    {
        this.career = career;
    }

    public String getTools()
    {
        return tools;
    }

    public void setTools(String tools)
    {
        this.tools = tools;
    }

    public int getCourseNum()
    {
        return courseNum;
    }

    public void setCourseNum(int courseNum)
    {
        this.courseNum = courseNum;
    }

    public static ArrayList<Review> getReviewList()
    {
        return reviewList;
    }

    public void addReview(Review review)
    {
        reviewList.add(review);
    }
}