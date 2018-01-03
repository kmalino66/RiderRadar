package net.trizmo.riderradar.handlers;

import net.trizmo.riderradar.weather.WeatherObject;
import net.trizmo.riderradar.weather.WeatherScore;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by trizm on 11/23/2017.
 */

public class WUndergroundWeatherLookupAPIHandler {

    /**
     * Classwide Variables
     */
    private JSONObject apiResponse;

    private static final String API_WEATHER_CALL = "http://api.wunderground.com/api/8b64e302dde31c78/hourly/q/";

    /**
     * Create the handler with a location request URL
     * @param locationRequestURL - The ending to the API call address that tells the API the location
     *                           that we would like to get the weather for.
     * @throws Exception
     */
    public WUndergroundWeatherLookupAPIHandler(String locationRequestURL) throws Exception
    {
        String callAddress = API_WEATHER_CALL + locationRequestURL;
        String response = callApi(callAddress);

        apiResponse = new JSONObject(response);
    }

    /**
     * Calls the API for hourly weather
     * @param apiAddress - The API address to call.
     * @return the response from the API
     * @throws Exception
     */
    private String callApi(String apiAddress) throws Exception
    {
        BufferedReader reader = null;

        URL url = new URL(apiAddress);
        reader = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuffer buffer = new StringBuffer();
        int read;
        char[] chars = new char[2048];
        while ((read = reader.read(chars)) != -1)
            buffer.append(chars, 0, read);

        reader.close();

        return buffer.toString();
    }

    public WeatherScore[] getHourlyWeatherInformation() throws Exception
    {
        JSONArray hourlyArray = apiResponse.getJSONArray("hourly_forecast");

        WeatherObject[] weatherObjects = new WeatherObject[hourlyArray.length()];

        for(int i = 0; i < hourlyArray.length(); i++)
        {
            //Get the hourly info from the json
            String temp = hourlyArray.getJSONObject(i).getJSONArray("temp").getJSONObject(0).toString();
            String wspd = hourlyArray.getJSONObject(i).getJSONArray("wspd").getJSONObject(0).toString();
            String pop = hourlyArray.getJSONObject(i).getJSONArray("pop").getJSONObject(0).toString();

            //Convert the information recieved from the web api
            double temperature = Double.parseDouble(temp);
            double windspeed = Double.parseDouble(wspd);
            double percentOfPrecipitation = Double.parseDouble(pop);

            weatherObjects[i] = new WeatherObject(temperature, windspeed, percentOfPrecipitation);

        }

        //Return the weather objects for each hour that we got from the API.
        return weatherObjects;
    }
}
