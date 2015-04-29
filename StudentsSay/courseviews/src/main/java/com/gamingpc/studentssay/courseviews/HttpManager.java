package com.gamingpc.studentssay.courseviews;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * author: JJ Lindsay
 * version: 1.0
 * Course: ITEC 4550 Spring 2015
 * Written: 4/13/2015
 *
 * This class represents a ...
 *
 * Purpose: Allows the manipulation of a ...
 */

/**STANDARD Android Design Pattern
 * HttpURLConnection is constantly being updated, which is why its preferred over the alternative
 * Allows for making a request and get back a response you can call anywhere in the Android app
 * Created by JON-JULIUS on 3/26/2015.
 */
public class HttpManager
{
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
                    return null;
                }
            }
        }

    }
}