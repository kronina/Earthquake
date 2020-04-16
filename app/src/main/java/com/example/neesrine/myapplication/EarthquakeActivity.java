package com.example.neesrine.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.neesrine.quakereport.QueryUtils;

import org.json.JSONException;

import java.util.ArrayList;


public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);


        // Create a fake list of earthquake locations.

        ArrayList<Earthquake> earthquakes = null;
        try {
            earthquakes = QueryUtils.extractEarthquakes();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        EarthquakeAdapter adapter = new EarthquakeAdapter(
                this , earthquakes );

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);
    }
}