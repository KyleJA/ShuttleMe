package com.example.kyle.shuttleme.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.kyle.shuttleme.R;
import com.example.kyle.shuttleme.adapters.TabsPagerAdapter;


public class RouteSelectionActivity extends ActionBarActivity {

    //protected Button Route1Button;
    //protected Button Route2Button;
    //protected Button Route3Button;
    //protected Button Route4Button;
    //protected Button Route5Button;

    private ViewPager viewPager;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_selection);

        actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        //actionBar.setHomeButtonEnabled(true);
        //actionBar.setDisplayUseLogoEnabled(true);
        //actionBar.setDisplayShowHomeEnabled(true);
        //actionBar.setLogo(R.drawable.ic_action);
        //actionBar.setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.pager);

        FragmentManager fm = getSupportFragmentManager();

        ViewPager.SimpleOnPageChangeListener pageChangeListener = new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                actionBar.setSelectedNavigationItem(position);
            }
        };

        viewPager.setOnPageChangeListener(pageChangeListener);

        TabsPagerAdapter fragmentPagerAdapter = new TabsPagerAdapter(fm);

        viewPager.setAdapter(fragmentPagerAdapter);

        actionBar.setDisplayShowTitleEnabled(true);

        ActionBar.TabListener tabListener = new ActionBar.TabListener() {

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
            }

            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
            }
        };

        ActionBar.Tab tab = actionBar.newTab()
                .setText("Route 1")
                .setTabListener(tabListener);

        actionBar.addTab(tab);

        /** Creating fragment2 Tab */
        tab = actionBar.newTab()
                .setText("Route 2")
                .setTabListener(tabListener);

        actionBar.addTab(tab);

        tab = actionBar.newTab()
                .setText("Route 3")
                .setTabListener(tabListener);

        actionBar.addTab(tab);

        tab = actionBar.newTab()
                .setText("Route 4")
                .setTabListener(tabListener);

        actionBar.addTab(tab);

        tab = actionBar.newTab()
                .setText("Route 5")
                .setTabListener(tabListener);

        actionBar.addTab(tab);

        /*Using Buttons to Navigate interface

        Route1Button = (Button)findViewById(R.id.route1Button);
        Route2Button = (Button)findViewById(R.id.route2Button);
        Route3Button = (Button)findViewById(R.id.route3Button);
        Route4Button = (Button)findViewById(R.id.route4Button);
        Route5Button = (Button)findViewById(R.id.route5Button);

        Route1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewRoute1 = new Intent(RouteSelectionActivity.this, RouteOneActivity.class);
                startActivity(viewRoute1);
            }
        });

        Route2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewRoute2 = new Intent(RouteSelectionActivity.this, RouteFiveActivity.class);
                startActivity(viewRoute2);
            }
        });

        Route3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewRoute3 = new Intent(RouteSelectionActivity.this, RouteThreeActivity.class);
                startActivity(viewRoute3);
            }
        });

        Route4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewRoute4 = new Intent(RouteSelectionActivity.this, RouteFourActivity.class);
                startActivity(viewRoute4);
            }
        });

        Route5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewRoute5 = new Intent(RouteSelectionActivity.this, RouteTwoActivity.class);
                startActivity(viewRoute5);
            }
        }); */

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_other, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        /*switch (id){
        //noinspection SimplifiableIfStatement
            case android.R.id.home:
                Intent upIntent = NavUtils.getParentActivityIntent(this);
                if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
                    // This activity is NOT part of this app's task, so create a new task
                    // when navigating up, with a synthesized back stack.
                    TaskStackBuilder.create(this)
                            // Add all of this activity's parents to the back stack
                            .addNextIntentWithParentStack(upIntent)
                                    // Navigate up to the closest parent
                            .startActivities();
                } else {
                    // This activity is part of this app's task, so simply
                    // navigate up to the logical parent activity.
                    NavUtils.navigateUpTo(this, upIntent);
                }
                return true;
        }*/
        if (id == R.id.action_AboutUs){
            Intent goToAbout = new Intent(RouteSelectionActivity.this, AboutActivity.class);
            startActivity(goToAbout);
        }
        else {
            if (id == R.id.action_Help) {
                Intent goToAbout = new Intent(RouteSelectionActivity.this, HelpActivity.class);
                startActivity(goToAbout);
            }
        }

        return super.onOptionsItemSelected(item);
    }

}
