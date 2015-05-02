package controller;

import java.util.LinkedHashMap;
import java.util.Map;

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
public class Courses
{
    static String[] temp;

    private static Map<Integer, String> courseList = new LinkedHashMap<Integer, String>(){{
        put(1001, "Intro to Computing");
        put(2110, "Digital Media");
        put(2120, "Intro to Programming");
        put(2130, "Web Technologies");
        put(2140, "Programming Fundamentals");
        put(2150, "Intermediate Programming");
        put(2201, "Intro to Info Systems");
        put(3100, "Intro to Networks");
        put(3150, "Advanced Programming");
        put(3200, "Intro to Databases");
        put(3300, "Information Security");
        put(3350, "E-Commerce");
        put(3450, "Comp Graphics and Multimedia");
        put(3600, "Operating Systems");
        put(3700, "Systems Analysis and Design");
        put(3860, "Software Development I");
        put(3870, "Software Development II");
        put(3900, "Professional Practice & Ethics");
        put(4100, "Advanced Networks");
        put(4110, "Digital Media Capstone Project");
        put(4130, "Human Computer Interaction");
        put(4150, "Enterprise Process Integration");
        put(4200, "Advanced Databases");
        put(4260, "Software Testing and QA");
        put(4320, "Internet Security");
        put(4400, "Special Topics in Information Technology: Computer Forensics");
        put(4450, "Web Development");
        put(4550, "Mobile Application Development");
        put(4810, "Info Technology Project I");
        put(4820, "Info Technology Project II");
        put(4860, "Software Development Project");
        put(4900, "Info Technology Internship");
    }};

    private Courses()
    {}

    private static void addCourse(Course course)
    {
        courseList.put(course.getCourseNumber(), course.getCourseName());
    }

    private static void addCourse(int aCouseNumber, String aCourseName)
    {
        courseList.put(aCouseNumber, aCourseName);
    }

    public static Map<Integer, String> getCourseList()
    {
        return courseList;
    }

    /**
     * This returns a courseList in an array, a format usable by listActivity
     * @return courseList in arrayList form
     */
    public static String[] getAdapterList()
    {
        temp = new String[courseList.size()];
        int i = 0;

        for(Map.Entry<Integer, String> entry : courseList.entrySet())
        {
            temp[i] = "" + entry.getKey() + " " + entry.getValue();
            i++;
        }
        return temp;
    }
}