package com.example.bustracker;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.location.Location;
import android.location.LocationManager;


public class MainActivity extends Activity {

	 private Spinner spinner1;
	 private Button btnSubmit;
	 
	 LocationManager locationManager = (LocationManager) 
			 getSystemService(Context.LOCATION_SERVICE);
	
	 public void addListenerOnButton() {
		 
			spinner1 = (Spinner) findViewById(R.id.spinner1);
			btnSubmit = (Button) findViewById(R.id.button1);
		 
			btnSubmit.setOnClickListener(new OnClickListener() {
		 
			  @Override
			  public void onClick(View v) {
		 
			    Toast.makeText(MainActivity.this,
				"OnClickListener : " + 
		                "\nSpinner 1 : "+ String.valueOf(spinner1.getSelectedItem()), Toast.LENGTH_SHORT);
			  }
		 
			});
	 }
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	} 
	
	public void findStop() {
		
		
	}
	
}

