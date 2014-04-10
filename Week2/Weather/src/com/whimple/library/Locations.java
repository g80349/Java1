package com.whimple.library;

public enum Locations {
	
			Las_Vegas(86.0, 61,"Mostly Cloudy", 6, "6mph" ),
			
			Henderson(83.0, 58,"Mostly Cloudy", 8, "8mph" ),
			
			North_Las_Vegas(85.0, 60,"Mostly Cloudy", 6, "10mph" ),
			
			Stateline(88.0, 57, "Mostly Cloudy", 4, "12mph" );
			
			private final double temp;
			private final int lowTemp;
			private final String sky;
			private final int humidity;
			private final String windSpeed;
			
			private Locations(double temp, int lowTemp, String sky, int humidity, String windSpeed){
				this.temp = temp;
				this.lowTemp = lowTemp;
				this.sky = sky;
				this.humidity = humidity;
				this.windSpeed = windSpeed;
			}
			
			public double setTemp(){
				return temp;
			}
			public int lowTemp(){
				return lowTemp;
			}
			public String sky(){
				return sky;
			}
			public int humidity(){
				return humidity;
			}
			public String windSpeed(){
				return windSpeed;
			}
}


