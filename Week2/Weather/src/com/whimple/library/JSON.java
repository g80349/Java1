package com.whimple.library;

import org.json.JSONException;
import org.json.JSONObject;

public class JSON {

	// builds JSON from locations.java enum values
	public static JSONObject buildJSON() {

		JSONObject locationObject = new JSONObject();

		try {
			JSONObject inquiryObject = new JSONObject();

			for (Locations location : Locations.values()) {

				JSONObject locObject = new JSONObject();

				locObject.put("temp", location.setTemp());
				locObject.put("lowTemp", location.lowTemp());
				locObject.put("sky", location.sky());
				locObject.put("humidity", location.humidity());
				locObject.put("windSpeed", location.windSpeed());
				locObject.put("cTemp", location.cTemp());
				locObject.put("cLowTemp", location.cLowTemp());
				inquiryObject.put(location.name().toString(), locObject);
			}

			locationObject.put("inquiry", inquiryObject);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return locationObject;
	}

	// read JSON
	public static String readJSON(String selectedLocation,
			String selectedMeasurement) {

		// variables for the values from the enums after build JSON
		String output = null, temp, lowTemp, sky, humidity, windSpeed, cTemp, cLowTemp;

		JSONObject jsonObject = buildJSON();

		try {
			temp = jsonObject.getJSONObject("inquiry")
					.getJSONObject(selectedLocation).getString("temp");
			lowTemp = jsonObject.getJSONObject("inquiry")
					.getJSONObject(selectedLocation).getString("lowTemp");
			sky = jsonObject.getJSONObject("inquiry")
					.getJSONObject(selectedLocation).getString("sky");
			humidity = jsonObject.getJSONObject("inquiry")
					.getJSONObject(selectedLocation).getString("humidity");
			windSpeed = jsonObject.getJSONObject("inquiry")
					.getJSONObject(selectedLocation).getString("windSpeed");
			cTemp = jsonObject.getJSONObject("inquiry")
					.getJSONObject(selectedLocation).getString("cTemp");
			cLowTemp = jsonObject.getJSONObject("inquiry")
					.getJSONObject(selectedLocation).getString("cLowTemp");

			// if spinner is fahrenheit
			if (selectedMeasurement.equals("Fahrenheit")) {
				output = "Temperature: " + temp + "deg F" + "\r\n" + "Low: "
						+ lowTemp + "deg F" + "\r\n" + "Humidity: " + humidity
						+ "%" + "\r\n" + sky + "\r\n" + windSpeed + "\r\n";
			}
			// if spinner is celcius
			if (selectedMeasurement.equals("Celcius")) {

				output = "Temperature: " + cTemp + "deg C" + "\r\n" + "Low: "
						+ cLowTemp + "deg C" + "\r\n" + "Humidity: " + humidity
						+ "%" + "\r\n" + sky + "\r\n" + windSpeed + "\r\n";

			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return output;
	}

}
