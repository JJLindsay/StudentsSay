package controller;

import java.util.HashMap;
import java.util.Iterator;
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

    private static Map<Integer, String> courseList = new HashMap<Integer, String>(){{
        put(1001, "Intro to Computing");
        addCourse(2110, "Digital Media");
        addCourse(2120, "Intro to Programming");
        addCourse(2130, "Web Technologies");
        addCourse(2140, "Programming Fundamentals");
        addCourse(2150, "Intermediate Programming");
        addCourse(2201, "Intro to Info Systems");
        addCourse(3100, "Intro to Networks");
        addCourse(3150, "Advanced Programming");
        addCourse(3200, "Intro to Databases");
        addCourse(3300, "Information Security");
        addCourse(3350, "E-Commerce");
        addCourse(3450, "Comp Graphics and Multimedia");
        addCourse(3600, "Operating Systems");
        addCourse(3700, "Systems Analysis and Design");
        addCourse(3860, "Software Development I");
        addCourse(3870, "Software Development II");
        addCourse(3900, "Professional Practice & Ethics");
        addCourse(4100, "Advanced Networks");
        addCourse(4110, "Digital Media Capstone Project");
        addCourse(4130, "Human Computer Interaction");
        addCourse(4150, "Enterprise Process Integration");
        addCourse(4200, "Advanced Databases");
        addCourse(4260, "Software Testing and QA");
        addCourse(4320, "Internet Security");
        addCourse(4400, "Special Topics in Information Technology: Computer Forensics");
        addCourse(4450, "Web Development");
        addCourse(4550, "Mobile Application Development");
        addCourse(4810, "Info Technology Project I");
        addCourse(4820, "Info Technology Project II");
        addCourse(4860, "Software Development Project");
        addCourse(4900, "Info Technology Internship");
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

    public static String[] getAdapterList()
    {
        temp = new String[32];
        int i = 0;

//        Iterator it = courseList.entrySet().iterator();
//        while (it.hasNext())
//        {
//            Map.Entry pair = (Map.Entry)it.next();
//            temp[i] = "" + pair.getKey() + " " + pair.getValue();
////            it.remove(); // avoids a ConcurrentModificationException
//            i++;
//        }

        for(Map.Entry<Integer, String> entry : courseList.entrySet())
        {
            temp[i] = "" + entry.getKey() + " " + entry.getValue();
            // do what you have to do here
            // In your case, an other loop.
            i++;
        }
        String[] temp = {"Market", "Grocery", "Populations"};

        return temp;
    }
}
