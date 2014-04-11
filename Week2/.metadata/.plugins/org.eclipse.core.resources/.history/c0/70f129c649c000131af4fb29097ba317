package com.example.weather;


import com.whimple.library.JSON;

import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;


public class MainActivity extends ActionBarActivity {

	Spinner spinnerLoc;
	String [] locList;

	 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);   
        
        locList = getResources().getStringArray(R.array.location_array);
        
        spinnerLoc = (Spinner) findViewById(R.id.location);
        spinnerLoc.setOnItemSelectedListener(new OnItemSelectedListener(){
        	public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
        		Toast.makeText(spinnerLoc.getContext(), "You have selected " + locList[position], Toast.LENGTH_LONG).show();
        	}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
        });
    };

    public void onClick(View view){
    	
    	String selectedLocation = spinnerLoc.getSelectedItem().toString();
    	TextView results = (TextView)findViewById(R.id.forecast);
    	results.setText(JSON.readJSON(selectedLocation));
    }
    
    
}
