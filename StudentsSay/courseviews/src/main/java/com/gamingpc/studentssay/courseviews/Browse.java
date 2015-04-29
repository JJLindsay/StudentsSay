package com.gamingpc.studentssay.courseviews;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import controller.Courses;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * author: JJ Lindsay
 * version: 1.0
 * Course: ITEC 4550 Spring 2015
 * Written: 4/2/2015
 *
 * This class represents a ...
 *
 * Purpose: Allows the manipulation of a ...
 */
public class Browse extends ListActivity
{
    ListView lv;
    ArrayAdapter<String> listAdapter;  //converts string[] to a listView

    private static Map<Integer, String> courseList = new HashMap<Integer, String>(){{
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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.browse);

//        lv = (ListView)findViewById(R.id.listView);

        String[] attraction = {"Market", "Grocery", "Populations"};
        String[] temp = new String[32];
        int i = 0;

        for(Map.Entry<Integer, String> entry : courseList.entrySet())
        {
            temp[i] = "" + entry.getKey() + " " + entry.getValue();
            // do what you have to do here
            // In your case, an other loop.
            i++;
        }

        setListAdapter(new ArrayAdapter<String>(this, R.layout.browse, R.id.travel, temp));

//        listAdapter = new ArrayAdapter<String>(this, R.layout.browse, R.id.travel, temp);
//
//        setListAdapter(listAdapter);

        //works
//        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, temp));
    }
}