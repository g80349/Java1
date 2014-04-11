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

	// variables
	Spinner spinnerLoc;
	String[] locList;
	Spinner spinnerMeasure;
	String[] measurementList;
	String selectedMeasurement;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// get location spinner list and item on spinner that is selected
		locList = getResources().getStringArray(R.array.location_array);
		spinnerLoc = (Spinner) findViewById(R.id.location);
		spinnerLoc.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// text for toast from selected spinner item
				Toast.makeText(spinnerLoc.getContext(),
						"You have selected " + locList[position],
						Toast.LENGTH_LONG).show();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});

		// get measurement spinner list and item on spinner that is selected
		measurementList = getResources().getStringArray(
				R.array.measurement_array);
		spinnerMeasure = (Spinner) findViewById(R.id.measurement);
		spinnerMeasure.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// text for toast from selected spinner item
				Toast.makeText(spinnerLoc.getContext(),
						"You have selected " + measurementList[position],
						Toast.LENGTH_LONG).show();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});
	};

	public void onClick(View view) {

		// get the selected location spinner and compare strings for to enum
		// names.
		// change name of spinner to appropriate name for enum
		String selectedLocation = spinnerLoc.getSelectedItem().toString();
		TextView results = (TextView) findViewById(R.id.forecast);
		if (selectedLocation.equals("Las Vegas")) {
			selectedLocation = "Vegas";
		}
		if (selectedLocation.equals("North Las Vegas")) {
			selectedLocation = "NLV";
		}
		// get the selected measurement spinner name and put both spinner
		// selections in the read JSON method
		selectedMeasurement = spinnerMeasure.getSelectedItem().toString();

		results.setText(JSON.readJSON(selectedLocation, selectedMeasurement));

	}

}
