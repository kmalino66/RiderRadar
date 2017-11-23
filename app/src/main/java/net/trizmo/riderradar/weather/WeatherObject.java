package net.trizmo.riderradar.weather;

/**
 * Created by trizm on 11/23/2017.
 */

public class WeatherObject {

    private double temperature;
    private double windspeed;
    private double percentPrecipitation;

    public WeatherObject(double temperature, double windspeed, double percentPrecipitation)
    {
        this.temperature = temperature;
        this.windspeed = windspeed;
        this.percentPrecipitation = percentPrecipitation;
    }

    public double getTemperature()
    {
        return temperature;
    }

    public double getWindspeed()
    {
        return windspeed;
    }

    public double getPercentPrecipitation()
    {
        return percentPrecipitation;
    }
}
