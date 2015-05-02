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
 * Course: ITEC 4550 Spring 2015
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
//        URL url = new URL(uri);
//        URLConnection conn = url.openConnection();
//        conn.setDoOutput(true);
//        OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
//
////        writer.write("value=1&anotherValue=1");
//        writer.write(parameters);
//        writer.flush();
//        String line;
//        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//        while ((line = reader.readLine()) != null) {
//            System.out.println(line);
//        }
//        writer.close();
//        reader.close();

          //--------------------SECOND ATTEMPT-----------------------------
//        try
//        {
//            Request.Post(uri)
//                    .bodyForm(Form.form().add(parameters[0], parameters[1])
//                            .add(parameters[2], parameters[3])
//                            .add(parameters[4], parameters[5])
//                            .add(parameters[6], parameters[7])
//                            .add(parameters[8], parameters[9])
//                            .add(parameters[10], parameters[11])
//                            .add(parameters[12], parameters[13]).build())
//                    .execute().returnContent();
//        } catch (IOException e)
//        {
//            e.printStackTrace();
//        }


          //---------------------THIRD ATTEMPT-------------------------
//        // Creating HTTP client
//        HttpClient httpClient = new DefaultHttpClient();
//
//        // Creating HTTP Post
//        HttpPost httpPost = new HttpPost(uri);
//
//        // Building post parameters, key and value pair
//        List<NameValuePair> nameValuePair = new ArrayList<>(7);
//        nameValuePair.add(new BasicNameValuePair(parameters[0], parameters[1]));
//        nameValuePair.add(new BasicNameValuePair(parameters[2], parameters[3]));
//        nameValuePair.add(new BasicNameValuePair(parameters[4], parameters[5]));
//        nameValuePair.add(new BasicNameValuePair(parameters[6], parameters[7]));
//        nameValuePair.add(new BasicNameValuePair(parameters[8], parameters[9]));
//        nameValuePair.add(new BasicNameValuePair(parameters[10], parameters[11]));
//        nameValuePair.add(new BasicNameValuePair(parameters[12], parameters[13]));
//
//        // Url Encoding the POST parameters
//        try {
//            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));
//        }
//        catch (UnsupportedEncodingException e) {
//            // writing error to Log
//            e.printStackTrace();
//        }
//
//        // Making HTTP Request
//        try {
//            HttpResponse response = httpClient.execute(httpPost);
//
//            // writing response to log
//            Log.d("Http Response:", response.toString());
//
//        } catch (IOException e) {
//            // writing exception to log
//            e.printStackTrace();
//        }



        //------------------Forth Attempt-------------------------------
//        HttpParams params = new BasicHttpParams();
//        HttpConnectionParams.setConnectionTimeout(params, 5000);
//        HttpConnectionParams.setSoTimeout(params, 5000);

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

//            Toast.makeText(new AddReview(), "Post status: " + status, Toast.LENGTH_LONG).show();

//            HttpEntity entity = response.getEntity();
            Log.d("HTTP POST", "HTTP POST REQUEST: OK");
        } catch (Exception e) {
            Log.e("HTTP", "Error in http connection " + e.toString());
        }

    }
}