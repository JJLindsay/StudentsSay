package com.gamingpc.studentssay.courseviews;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import controller.Course;
import controller.Courses;
import controller.Reviews;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * author: JJ Lindsay
 * version: 1.0
 * Course: ITEC 4550 - End of Semester Project
 * Written: 4/2/2015
 *
 * Purpose: To inflate the main sceen holding the search and browse buttons
 */
public class Main extends Activity
{
    Button searchBtn, browseBtn;
    EditText courseNum;
    int courseNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        searchBtn = (Button)findViewById(R.id.enter_button);
        browseBtn = (Button)findViewById(R.id.browse_button); //ok
        courseNum = (EditText)findViewById(R.id.editText); //ok

        browseBtn.setOnClickListener(new BrowsingListener());
        searchBtn.setOnClickListener(new SearchingListener());
    }

    //completed!
    class BrowsingListener implements View.OnClickListener
    {
        @Override
        public void onClick(View view)
        {
            startActivity(new Intent(Main.this, Browse.class));
        }
    }

    //completed!
    class SearchingListener implements View.OnClickListener
    {
        @Override
        public void onClick(View view)
        {
            if (courseNum.getText().length() > 3)
            {
                //if get request with num rerun
                courseNumber = Integer.parseInt(courseNum.getText().toString());

                if (Courses.getCourseList().containsKey(courseNumber))
                {
                    new Course(courseNumber);
                    Reviews.findReviews(courseNumber);

                    //once the number is collected, send it to the server and
                    //create an arrayList or LinkedHashList for order
                    startActivity(new Intent(Main.this, Summary.class));
                } else
                {
                    Toast.makeText(getApplicationContext(), "Your course could not be found", Toast.LENGTH_LONG).show();
                }
            } else
            {
                Toast.makeText(getApplicationContext(), "Course numbers must be 4 digits", Toast.LENGTH_LONG).show();
            }
        }
    }
}