package com.gamingpc.studentssay.courseviews;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import controller.Course;
import controller.Courses;
import controller.Review;
import controller.Reviews;

import java.util.ArrayList;

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
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<>(this, R.layout.browse, R.id.iteccources, Courses.getAdapterList()));

        //works
//        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, temp));
    }

    //parameters: l - where the click happened, v - the view that was clicked within listview, pos - the postion of the view
    //in the list, id - the row id of the item that was clicked
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        //pulls the itec number from the selected item
        String selectedItem = (String)getListView().getItemAtPosition(position);
        int itecNum = Integer.parseInt(selectedItem.substring(0, 4));
        new Course(itecNum);

        Reviews.findReviews(itecNum);

        startActivity(new Intent(Browse.this, Summary.class));
    }
}