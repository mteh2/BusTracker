package com.example.bustracker;
import java.io.*;
import java.net.*;

public class Internet_Call {

   public String getHTML(String urlToRead) {
      URL url;
      HttpURLConnection conn;
      BufferedReader rd;
      String line;
      String result = "";
      try {
         url = new URL(urlToRead);
         conn = (HttpURLConnection) url.openConnection();
         conn.setRequestMethod("GET");
         rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
         while ((line = rd.readLine()) != null) {
            result += line;
         }
         rd.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
      return result;
   }

   public static String main(String args[])
   {
     Internet_Call c = new Internet_Call();
     return c.getHTML(args[0]);
   }
}
