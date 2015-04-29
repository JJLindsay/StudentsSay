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
public class Course
{
    int courseNumber;
    String courseName;

    private Course(int aCouseNumber, String aCourseName)
    {
        this.courseNumber = aCouseNumber;
        this.courseName = aCourseName;
    }

    public int getCourseNumber()
    {
        return courseNumber;
    }

    private void setCourseNumber(int courseNumber)
    {
        this.courseNumber = courseNumber;
    }

    public String getCourseName()
    {
        return courseName;
    }

    private void setCourseName(String courseName)
    {
        this.courseName = courseName;
    }
}