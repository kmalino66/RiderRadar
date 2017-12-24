package net.trizmo.riderradar.handlers;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by trizm on 11/22/2017.
 */

public class WUndergroundGeoLookupAPIHandler {

    /**
     * Classwide variables
     */
    private JSONObject apiResponse;

    private static final String API_GEO_CALL = "http://api.wunderground.com/api/8b64e302dde31c78/geolookup/q/";

    /**
     * Create the handler with a latitude and longitude.
     * @param latitude - The latitude of the current location.
     * @param longitude - The longitude of the current location.
     * @throws Exception
     */
    public WUndergroundGeoLookupAPIHandler(long latitude, long longitude) throws Exception
    {
        //We want to use Lat,Long
        String callAddress = API_GEO_CALL + latitude + "," + longitude;
        String response = callApi(callAddress);


        apiResponse = new JSONObject(response);

    }

    private String callApi(String apiAddress) throws Exception
    {
        BufferedReader reader = null;

        // Make the call to the API
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

    /**
     * Gets the ending of the request URL for the nearest city based on the latitude and longitude
     * that was passed in.
     * @return a string containing the ending of the request URL that can be passed to get the weather.
     * @throws Exception
     */
    public String getLocationRequestURLEnding() throws Exception
    {
        return apiResponse.getString("requesturl");
    }



}
