package com.gamingpc.studentssay.courseviews;

import android.util.Log;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.*;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * author: JJ Lindsay
 * version: 1.0
 * Course: ITEC 4550 - End of Semester Project
 * Written: 4/13/2015
 *
 * This class represents a STANDARD Android Design Pattern
 * HttpURLConnection is constantly being updated, which is why its preferred over the alternative
 * Allows for making a request and get back a response you can call anywhere in the Android app
 *
 * Purpose: Allows for HTTP Requests
 */
public class HttpManager
{
    //returns all the data in the reviews.txt
    public static String getData(String uri)
    {
        BufferedReader reader = null;

        try{
            URL url = new URL(uri);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            StringBuilder sb = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null)
            {
                sb.append(line + "\n");
            }
            Log.d("HTTP GET", "HTTP GET REQUEST: OK");
            return sb.toString();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        finally
        {
            if (reader != null)
            {
                try{
                    reader.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void postData(String url, String[] parameters)
    {
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair(parameters[0], parameters[1]));
        nameValuePairs.add(new BasicNameValuePair(parameters[2], parameters[3]));
        nameValuePairs.add(new BasicNameValuePair(parameters[4], parameters[5]));
        nameValuePairs.add(new BasicNameValuePair(parameters[6], parameters[7]));
        nameValuePairs.add(new BasicNameValuePair(parameters[8], parameters[9]));
        nameValuePairs.add(new BasicNameValuePair(parameters[10], parameters[11]));
        nameValuePairs.add(new BasicNameValuePair(parameters[12], parameters[13]));

        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(url);

        try {
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = httpclient.execute(httppost);

            int status = response.getStatusLine().getStatusCode();
            Log.i("Post Activity", "Post status: " + status);

            Log.d("HTTP POST", "HTTP POST REQUEST: OK");
        } catch (Exception e) {
            Log.e("HTTP", "Error in http connection " + e.toString());
        }
    }
}