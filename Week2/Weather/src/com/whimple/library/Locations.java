package com.whimple.library;

public enum Locations {
	
	Vegas(86.0, 61, "Mostly Cloudy", 6, "6mph", 30, 16.1),

	Henderson(83.0, 58, "Mostly Cloudy", 8, "8mph", 28.3, 14.4),

	NLV(85.0, 60, "Mostly Cloudy", 6, "10mph", 29.4, 15.5),

	Stateline(88.0, 57, "Mostly Cloudy", 4, "12mph", 31.1, 13.8);

	private final double temp;
	private final int lowTemp;
	private final String sky;
	private final int humidity;
	private final String windSpeed;
	private final double cTemp;
	private final double cLowTemp;

	private Locations(double temp, int lowTemp, String sky, int humidity,
			String windSpeed, double cTemp, double cLowTemp) {
		this.temp = temp;
		this.lowTemp = lowTemp;
		this.sky = sky;
		this.humidity = humidity;
		this.windSpeed = windSpeed;
		this.cTemp = cTemp;
		this.cLowTemp = cLowTemp;
	}

	public double setTemp() {
		return temp;
	}

	public int lowTemp() {
		return lowTemp;
	}

	public String sky() {
		return sky;
	}

	public int humidity() {
		return humidity;
	}

	public String windSpeed() {
		return windSpeed;
	}

	public double cTemp() {
		return cTemp;
	}

	public double cLowTemp() {
		return cLowTemp;
	}
}
