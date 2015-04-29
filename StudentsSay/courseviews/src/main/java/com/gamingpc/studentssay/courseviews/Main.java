package com.gamingpc.studentssay.courseviews;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import controller.Courses;

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

    //compeleted!
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
            //if get request with num rerun
            courseNumber = Integer.parseInt(courseNum.getText().toString());

            if (Courses.getCourseList().containsKey(courseNumber))
            {
                startActivity(new Intent(Main.this, Summary.class));
            }
            else
            {
                Toast.makeText(getApplicationContext(), "A course could not be found", Toast.LENGTH_LONG).show();
            }
        }
    }
}