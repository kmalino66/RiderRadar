package net.trizmo.riderradar.weather;

import net.trizmo.riderradar.weather.WeatherObject;

/**
 * Created by trizm on 11/22/2017.
 */

public class WeatherScore {

    private double temperature;
    private double windspeed;
    private double percentOfPrecipitation;

    public WeatherScore(double temperature, double windspeed, double percentOfPrecipitation)
    {
        this.temperature = temperature;
        this.windspeed = windspeed;
        this.percentOfPrecipitation = percentOfPrecipitation;
    }

    public WeatherScore(WeatherObject weatherObject)
    {
        this.temperature = weatherObject.getTemperature();
        this.windspeed = weatherObject.getWindspeed();
        this.percentOfPrecipitation = weatherObject.getPercentPrecipitation();
    }

    /**
     * Calculate the score of temperature.
     * @return temperature score
     */
    public int getTemperatureScore()
    {
        return (int)(((1/20)*Math.pow(temperature - 65, 2)) + 100);
    }

    /**
     * Calculate the score for the windspeed.
     * @return windspeed score
     */
    public int getWindspeedScore()
    {
        return (int)(((-1/25)* Math.pow(windspeed, 2)) + 100);
    }

    /**
     * Calculate the score for the precipitation chance.
     * @return precipitation chance score.
     */
    public int getPrecipitationScore()
    {
        return (int)(-1 * percentOfPrecipitation)+ 100;
    }

    /**
     * Calculate the "total score". This is the average of the following scores:
     * - Temperature Score
     * - Windspeed Score
     * - Precipitation Chance Score.
     * @return the total score.
     */
    public int getTotalScore()
    {
        return (int)((getPrecipitationScore() + getWindspeedScore() + getTemperatureScore()) / 3);
    }

    /**
     *
     * @return temperature
     */
    public double getTemperature()
    {
        return temperature;
    }

    /**
     *
     * @return windspeed
     */
    public double getWindspeed()
    {
        return windspeed;
    }

    /**
     *
     * @return percent chance of precipitation.
     */
    public double getPercentOfPrecipitation()
    {
        return percentOfPrecipitation;
    }

    /**
     * Set the temperature
     * @param temperature - Temperature to set the value to in F.
     */
    public void setTemperature(double temperature)
    {
        this.temperature = temperature;
    }

    /**
     * Set the windwpeed
     * @param windspeed - Windspeed to set the value to in MPH.
     */
    public void setWindspeed(double windspeed)
    {
        this.windspeed = windspeed;
    }

    /**
     * Set the percent chance of precipitation.
     * @param percentOfPrecipitation - Percent chance of percipitation to set the value to.
     */
    public void setPercentOfPrecipitation(double percentOfPrecipitation)
    {
        this.percentOfPrecipitation = percentOfPrecipitation;
    }

}
