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
    static int courseNumber;
    static String courseName;

    private Course(int aCourseNumber, String aCourseName)
    {
        Course.courseNumber = aCourseNumber;
        Course.courseName = aCourseName;
    }

    public Course(int aCourseNumber)
    {
        Course.courseNumber = aCourseNumber;
        //this uses the key to get the value, in this case the course name
        Course.courseName = Courses.getCourseList().get(aCourseNumber);
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