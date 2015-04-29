package controller;

/**
 * author: JJ Lindsay
 * version: 1.0
 * Course: ITEC 4550 Spring 2015
 * Written: 4/26/2015
 *
 * This class represents a ...
 *
 * Purpose: Allows the manipulation of a ...
 */
public class Review
{
    int readBk, goodBk, projects, workload;
    String career, tools;
    int courseNum;

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

    public int getReadBk()
    {
        return readBk;
    }

    public void setReadBk(int readBk)
    {
        this.readBk = readBk;
    }

    public int getGoodBk()
    {
        return goodBk;
    }

    public void setGoodBk(int goodBk)
    {
        this.goodBk = goodBk;
    }

    public int getProjects()
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
}