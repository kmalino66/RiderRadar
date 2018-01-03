package net.trizmo.riderradar.weather;

/**
 * Created by trizm on 1/3/2018.
 */

public class WeatherAnalyzer {

    private WeatherScore[] HourlyScores;

    public WeatherAnalyzer(WeatherScore[] scoreArray)
    {
        HourlyScores = scoreArray;
    }

    public int getHoursAvailable()
    {
        return HourlyScores.length;
    }

    public int getOverallTemperatureScore()
    {

    }

    public int getOverallWindspeedScore()
    {

    }

    public int getPercentOfPrecipitationScore()
    {

    }

}
