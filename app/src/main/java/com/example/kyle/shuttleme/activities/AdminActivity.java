package com.example.kyle.shuttleme.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.kyle.shuttleme.R;
import com.parse.ParseUser;

public class AdminActivity extends ActionBarActivity {

    //protected Button DelaysButton;
    protected Button GPS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        //intialize
        //DelaysButton = (Button)findViewById(R.id.delaysButton);
        GPS = (Button)findViewById(R.id.gpsButton);

        //set click listener
        /*
        DelaysButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent goToDelays = new Intent(AdminActivity.this, DelaySelectorActivity.class);
                startActivity(goToDelays);
            }

        });
        */

        GPS.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                Intent goToTracker = new Intent(AdminActivity.this, MyLocationActivity.class);

                startActivity(goToTracker);

            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_admin, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent goToSetting = new Intent(AdminActivity.this, SettingsActivity.class);
            //Intent goToSetting = new Intent(android.provider.Settings.ACTION_SETTINGS);
            startActivity(goToSetting);
            //return true;
        }
        else if (id == R.id.action_AboutUs){
            Intent goToAbout = new Intent(AdminActivity.this, AboutActivity.class);
            startActivity(goToAbout);
            //return true;
        }
        else if (id == R.id.action_Help) {
                Intent goToHelp = new Intent(AdminActivity.this, HelpActivity.class);
                startActivity(goToHelp);
                //return true;
        }
        else if (id == R.id.action_logout) {
            ParseUser.getCurrentUser().logOut();
            Intent intent = new Intent(AdminActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            //return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
