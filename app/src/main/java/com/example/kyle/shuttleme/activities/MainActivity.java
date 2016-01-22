package com.example.kyle.shuttleme.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.kyle.shuttleme.R;


public class MainActivity extends ActionBarActivity {

    protected Button login;
    protected Button RouteSelection;
    protected Button SecurityInfo;
    protected Button Help;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize
        login = (Button) findViewById(R.id.loginButton);
        RouteSelection = (Button) findViewById(R.id.routeSelectionButton);
        SecurityInfo = (Button) findViewById(R.id.securityInfoButton);
        Help = (Button) findViewById(R.id.helpButton);


        //set click listener
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent goToLogin = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(goToLogin);
            }
        });

        RouteSelection.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent goToRouteSel = new Intent(MainActivity.this, RouteSelectionActivity.class);
                startActivity(goToRouteSel);


            }






        });

        SecurityInfo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent goToSecurity = new Intent(MainActivity.this, SecurityActivity.class);
                startActivity(goToSecurity);
            }

        });

        Help.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent goToHelp = new Intent(MainActivity.this, HelpActivity.class);
                startActivity(goToHelp);
            }

        });


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
            Intent goToAbout = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(goToAbout);
        }

        return super.onOptionsItemSelected(item);
    }




}


