package com.whimple.library;

//David Whimple Java 1 Week 3 1404
import java.util.concurrent.ExecutionException;

import com.example.weather.MainActivity;
import com.whimple.library.connection.getData;

import org.json.JSONException;
import org.json.JSONObject;

public class JSON {

	static String responseString = "";

	// read JSON
	public static String readJSON(String cityString, String selectedMeasurement) {

		// variables for the values from after build JSON
		String output = null, temp, feelsLike, sky, humidity, windSpeed, cTemp, cFeelsLike;
		// create json object variable
		JSONObject locationObject = new JSONObject();

		try {
			// set variables to call getData
			connection.getData data = new getData();
			responseString = data.execute(cityString).get();
			locationObject = new JSONObject(responseString);
			System.out.println(locationObject);
			// if user has invalid request to api call alert
			if (locationObject.getJSONObject("response").getJSONObject("error")
					.getString("type").equals("querynotfound")) {

				MainActivity
						.newAlertView("You have entered an invalid city. Please try again.");
			}
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			// get info from json and set to variables
			temp = locationObject.getJSONObject("current_observation")
					.getString("temp_f");

			feelsLike = locationObject.getJSONObject("current_observation")
					.getString("feelslike_f");

			sky = locationObject.getJSONObject("current_observation")
					.getString("weather");

			humidity = locationObject.getJSONObject("current_observation")
					.getString("relative_humidity");

			windSpeed = locationObject.getJSONObject("current_observation")
					.getString("wind_string");

			cTemp = locationObject.getJSONObject("current_observation")
					.getString("temp_c");

			cFeelsLike = locationObject.getJSONObject("current_observation")
					.getString("feelslike_c");

			// if spinner is fahrenheit
			if (selectedMeasurement.equals("Fahrenheit")) {
				output = "Temperature: " + temp + "deg F" + "\r\n"
						+ "Feels Like: " + feelsLike + "deg F" + "\r\n"
						+ "Humidity: " + humidity + "\r\n" + sky + "\r\n"
						+ windSpeed + "\r\n";
			}
			// if spinner is celcius
			if (selectedMeasurement.equals("Celcius")) {

				output = "Temperature: " + cTemp + "deg C" + "\r\n"
						+ "Feels Like: " + cFeelsLike + "deg C" + "\r\n"
						+ "Humidity: " + humidity + "\r\n" + sky + "\r\n"
						+ windSpeed + "\r\n";

			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return output;
	}

}
