package net.trizmo.riderradar.handlers;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import net.trizmo.riderradar.MainActivity;


public class LocationHandler implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    MainActivity mainActivity;

    public LocationHandler(MainActivity mainActivity)
    {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
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
