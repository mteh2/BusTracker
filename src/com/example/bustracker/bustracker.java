package com.example.bustracker;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class bustracker {
	
	public static String[] findStop(double lat, double lon, String route) throws IOException
	{
		try {
			@SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Miles Teh/workspace/bustracker/assets/stops.txt"));
			
			String line;
			String[] info = new String[10];
			float d = 10000; 
			String sID = "";
			String vID = "";
			String eta = "";
			String direction = "";
			
			line = reader.readLine();
			
 			
			while ((line = reader.readLine()) != null )
			{
				info = line.split(",");
				
				info[0] = info[0].substring(0,info[0].length()-2);
				
				float tempd = distanceCalc.findD(lon, Float.parseFloat(info[4]) ,lat, Float.parseFloat(info[5]));
				
				if (tempd < d)
				{
					boolean check = false;
					boolean done = false;
					
					@SuppressWarnings("resource")
					BufferedReader reader2 = new BufferedReader(new FileReader("C:/Users/Miles Teh/workspace/bustracker/assets/stoptoroute.txt"));
					
					while(!done)
					{
						String line2 = reader2.readLine();
						
						String[] minfo = line2.split(",");
						
						if (minfo[0].equals(info[0]))
						{
							done = true;
							
							for(int i = 1; i < minfo.length - 1; i++)
							{
								if(minfo[i].equalsIgnoreCase(route)) check = true;
							}
						}
						
					}
					
					if (check == true) sID = info[0];
				}
			}
			
			String args = Internet_Call.main("http://developer.cumtd.com/api/v2.2/xml/GetDeparturesByStop?key=ec56803a6f7740fa8497b7b4a9f58235&stop_id=" + sID);
			String[][] busses = XMLparse.dbs(args);
			
			int num = busses.length;
			
			for(int i = 0; i < num; i ++)
			{
				if(route.equalsIgnoreCase(busses[i][10]))
				{
					sID = busses[i][4];
					vID = busses[i][0];
					eta = busses[i][8];
					direction = busses[i][19];
				}
			}
			
			
			String[] ans = new String [4];
			ans[0] = sID; ans[1] = vID; ans[2] = eta; ans[3] = direction;	
			
			return ans;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;

	}
}