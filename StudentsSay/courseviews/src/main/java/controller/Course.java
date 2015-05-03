package controller;

/**
 * author: JJ Lindsay
 * version: 1.0
 * Course: ITEC 4550 - End of Semester Project
 * Written: 4/26/2015
 *
 *
 * Purpose: To represent a course
 */
public class Course
{
    private static int courseNumber;
    private static String courseName;

    private Course(int aCourseNumber, String aCourseName)
    {
        Course.courseNumber = aCourseNumber;
        Course.courseName = aCourseName;
    }

    public Course(int aCourseNumber)
    {
        this(aCourseNumber, Courses.getCourseList().get(aCourseNumber));
    }

    public static int getCourseNumber()
    {
        return courseNumber;
    }

    private void setCourseNumber(int courseNumber)
    {
        Course.courseNumber = courseNumber;
    }

    public String getCourseName()
    {
        return courseName;
    }

    private void setCourseName(String courseName)
    {
        Course.courseName = courseName;
    }
}