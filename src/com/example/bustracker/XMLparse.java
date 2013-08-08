package com.example.bustracker;

public class XMLparse {
	
	public static String[][] dbs(String info){
		String[] busses = info.split("<departure ");
		
		int x = busses.length;
		
		String[][] bus = new String[x][25];
		
		for (int i = 0; i < x-1; i++)
		{
			bus[i] = dbsBreakdown(busses[i+1]);
		}
		
		return bus;
	}
	
	public static String[] dbsBreakdown(String departure){
		String[] args = new String[25]; 
		String[] parts = departure.split("=" + '"');
		for (int i = 0; i < 25; i++)
		{
			args[i] = parts[i+1].split("" + '"')[0];
		}
		return args;
	}
	
}
