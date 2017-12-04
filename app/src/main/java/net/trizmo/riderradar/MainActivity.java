package net.trizmo.riderradar;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import net.trizmo.riderradar.scores.ScoreItem;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final int PERMISSION_REQUEST_COARSE_LOCATION = 0;
    public static final int PERMISSION_REQUEST_FINE_LOCATION = 1;

    private WeatherScore currentWeatherScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setProgressBarClickListener();
        setDetailsTextViewClickListener();

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        requestCoarseLocationPermission();
        requestFineLocationPermission();
    }

    private void requestCoarseLocationPermission()
    {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION)) {
                // Provide an additional rationale to the user if the permission was not granted
                // and the user would benefit from additional context for the use of the permission.
                // Display a SnackBar with a button to request the missing permission.
                Snackbar.make(findViewById(R.id.frameLayout), "Location access required to determine the location for weather.",
                        Snackbar.LENGTH_INDEFINITE).setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Request the permission
                        ActivityCompat.requestPermissions(MainActivity.this,
                                new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                                PERMISSION_REQUEST_COARSE_LOCATION);
                    }
                }).show();

            } else {
                Snackbar.make(findViewById(R.id.frameLayout),
                        "Permission is not available. Requesting location permission.",
                        Snackbar.LENGTH_SHORT).show();
                // Request the permission. The result will be received in onRequestPermissionResult().
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                        PERMISSION_REQUEST_COARSE_LOCATION);
            }
        }
    }

    private void requestFineLocationPermission()
    {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                // Provide an additional rationale to the user if the permission was not granted
                // and the user would benefit from additional context for the use of the permission.
                // Display a SnackBar with a button to request the missing permission.
                Snackbar.make(findViewById(R.id.frameLayout), "Location access required to determine the location for weather.",
                        Snackbar.LENGTH_INDEFINITE).setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Request the permission
                        ActivityCompat.requestPermissions(MainActivity.this,
                                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                PERMISSION_REQUEST_FINE_LOCATION);
                    }
                }).show();

            } else {
                Snackbar.make(findViewById(R.id.frameLayout),
                        "Permission is not available. Requesting location permission.",
                        Snackbar.LENGTH_SHORT).show();
                // Request the permission. The result will be received in onRequestPermissionResult().
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        PERMISSION_REQUEST_FINE_LOCATION);
            }
        }
    }

    /**
     * Start the Details Activity
     */
    private void launchDetailsActivity()
    {
        ArrayList<ScoreItem> detailedScoreList = populateDetatiledScoreList();

        Intent detailsLaunchIntent = new Intent(this, DetailsActivity.class);
        detailsLaunchIntent.putParcelableArrayListExtra(DetailsActivity.EXTRA_ARRAY_LIST, null); //TODO
        startActivity(detailsLaunchIntent);
    }

    private ArrayList<ScoreItem> populateDetatiledScoreList()
    {
        return null; //TODO
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return true;
    }

    private void setProgressBarClickListener()
    {
        CircleProgressBar circleProgressBar = (CircleProgressBar) findViewById(R.id.custom_progressBar);
        circleProgressBar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                launchDetailsActivity();
                return true;
            }
        });
    }

    private void setDetailsTextViewClickListener()
    {
        TextView details = (TextView) findViewById(R.id.details_textview);
        details.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                launchDetailsActivity();
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        //TODO Add refresh button, and handle it.
        switch (item.getItemId()) {
            case R.id.menu_search:
                //TODO Search
                return true;
            case R.id.menu_settings:
                //TODO Settings
                return true;
            case R.id.menu_time_select:
                //TODO Time select
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
