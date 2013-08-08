package com.example.bustracker;

public class distanceCalc {
	static int r = 6371;
	
	public static float findD(double lon, float lat2, double lat, float lon2)
	{
		float d;
		double dlon = lon2 - lat;
		double dlat = lat2 - lon;
		
		float a = (float) (Math.pow(Math.sin(dlat/2),2) + Math.cos(lon) * Math.cos(lat2) * Math.pow(Math.sin(dlon/2),2));
		
		float c = (float) (2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)));
		
		d = r * c;
		
		return d;
	}
}
