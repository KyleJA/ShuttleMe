package com.example.kyle.shuttleme.activities;

/**
 * Created by Kyle on 02/04/2015.
 */

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.kyle.shuttleme.R;


public class SettingsActivity extends ActionBarActivity {

    protected Button gps;
    protected Button data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        gps = (Button) findViewById(R.id.gpsButton);
        data = (Button) findViewById(R.id.dataButton);

        gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);

            }
        });

        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS);
                startActivity(intent1);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_AboutUs) {
            Intent goToAbout = new Intent(SettingsActivity.this, AboutActivity.class);
            startActivity(goToAbout);
            //return true;
        }

        return super.onOptionsItemSelected(item);
    }
}