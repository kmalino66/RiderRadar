package net.trizmo.riderradar;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final int PERMISSION_REQUEST_COARSE_LOCATION = 0;
    public static final int PERMISSION_REQUEST_FINE_LOCATION = 1;

    public LocationManager locationManager;
    public WeatherScore[] weatherScores;

    private boolean useInputtedLocation = false;


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

        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        verifyGPSAndSetLocationListener(locationManager);

    }

    private void verifyGPSAndSetLocationListener(LocationManager locationManager)
    {

    }

    /**
     * Request permission from the user to use their Coarse location.
     */
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

    /**
     * Request permission from the user to use their fine location.
     */
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
        ArrayList<ScoreItem> detailedScoreList = populateDetailedScoreList();

        Intent detailsLaunchIntent = new Intent(this, DetailsActivity.class);
        detailsLaunchIntent.putParcelableArrayListExtra(DetailsActivity.EXTRA_ARRAY_LIST, null); //TODO
        startActivity(detailsLaunchIntent);
    }

    private ArrayList<ScoreItem> populateDetailedScoreList()
    {
        return null; //TODO
    }



    /**
     * Set the click listener for the circular progress bar.
     */
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

    /**
     * Set the click listener for the text view.
     */
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

    private void refreshData()
    {
        
    }

    /**
     * Create the menu options for the main activity.
     * @param menu - The menu opject to create.
     * @return - true if the menu is created correctly.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return true;
    }

    /**
     * Handle the clicks sent to the menu items.
     * @param item - The item that was clicked.
     * @return - True if handled, false if not.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_search:
                //TODO Search
                return true;
            case R.id.menu_refresh:
                //TODO Refresh
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
