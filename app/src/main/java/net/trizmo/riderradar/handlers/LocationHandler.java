package net.trizmo.riderradar.handlers;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import net.trizmo.riderradar.MainActivity;

import java.util.List;
import java.util.Locale;


/**
 * Created by trizm on 1/2/2018.
 */

public class LocationHandler implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    MainActivity mainActivity;

    public LocationHandler(MainActivity mainActivity)
    {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        //TODO Get the location.
        mainActivity.getLocation();

    }

    @Override
    public void onConnectionSuspended(int i) {
        //TODO Restore the connection.
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        //TODO Notify user of failed connection.
    }
}
