package com.example.kyle.shuttleme.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.kyle.shuttleme.R;

/**
 * Created by Kyle on 31/03/2015.
 */
public class SecurityActivity extends ActionBarActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            Intent goToAbout = new Intent(SecurityActivity.this, AboutActivity.class);
            startActivity(goToAbout);
        }

        return super.onOptionsItemSelected(item);
    }
}
