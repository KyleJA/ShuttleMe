package com.example.kyle.shuttleme.activities;

/**
 * Created by Kyle on 01/04/2015.
 */

import android.app.Dialog;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.example.kyle.shuttleme.R;
import com.example.kyle.shuttleme.routingHelpers.Route;
import com.example.kyle.shuttleme.routingHelpers.Routing;
import com.example.kyle.shuttleme.routingHelpers.RoutingListener;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

public class RouteFiveActivity extends FragmentActivity implements RoutingListener {
    //initializing protected variables
    protected GoogleMap map;
    protected LatLng uwi;
    protected LatLng sanjuan;
    protected LatLng tunapuna;
    protected LatLng stjohns;
    protected LatLng TgrNorth;
    protected LatLng JFKUnderpass;
    protected LatLng Optometry;
    //  protected Button mRouteSelection;
    //  protected Button mDelays;
    // protected Button mGPSButton;
    protected Marker marker;

    /**
     * This activity loads a map and then displays the route and pushpins on it.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route5);
        // Getting Google Play availability status

        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getBaseContext());
        // Showing status
        if (status != ConnectionResult.SUCCESS) { // Google Play Services not available
            int requestCode = 10;
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status, this, requestCode);
            dialog.show();
        } // Google Play Services are available
        // Getting reference to the SupportMapFragment of activity_main.xml
        //GoogleMap googleMap;

        SupportMapFragment fm = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);


        // Getting Google Map object from the fragment
        map = fm.getMap();

        CameraUpdate center = CameraUpdateFactory.newLatLng(new LatLng(10.646960, -61.397804));
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(16);

        map.moveCamera(center);
        map.animateCamera(zoom);

        uwi = new LatLng(10.6423880, -61.4005280);
        sanjuan = new LatLng(10.6500000, -61.4499999);


        stjohns= new LatLng(10.6496179, -61.3955833);
        tunapuna = new LatLng(10.65125250, -61.38810730);

        TgrNorth= new LatLng(10.640605, -61.401547);
        JFKUnderpass = new LatLng(10.638741, -61.398903);

        JFKUnderpass = new LatLng(10.638741, -61.398903);
        Optometry= new LatLng(10.647472, -61.400369);


        Routing routing1 = new Routing(Routing.TravelMode.DRIVING);
        routing1.registerListener(this);
        routing1.execute(uwi, stjohns);

        LatLng defaultPosition = uwi;
        marker = map.addMarker(new MarkerOptions()
                .position(defaultPosition)
                .snippet("Lat: 10.6423880" + "Lng: -61.4005280" )
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))
                .title("UWI Shuttle #5"));

        //log into shuttle 2's account in backgrd in order to access Parse's server
        ParseUser.logInInBackground("Shuttle5", "shuttleMaster_5");
        // Execute a runnable task on creation of Activity
        handler.post(runnableCode);

        /*
        Routing routing = new Routing(Routing.TravelMode.DRIVING);
        routing.registerListener(this);
        routing.execute(uwi, sanjuan);

        Routing routing5 = new Routing(Routing.TravelMode.DRIVING);
        routing5.registerListener(this);
        routing5.execute(uwi, tunapuna);


        Routing routing3 = new Routing(Routing.TravelMode.DRIVING);
        routing3.registerListener(this);
        routing3.execute(TgrNorth, JFKUnderpass);

        Routing routing4 = new Routing(Routing.TravelMode.DRIVING);
        routing4.registerListener(this);
        routing4.execute(JFKUnderpass, Optometry);
        */

        /*trying to return and set location in a route active
        public ParseGeoPoint getLocation() {
            return getParseGeoPoint("location");
        }

        public void setLocation(ParseGeoPoint value) {
            put("location", value);
        }*/
/*
          map.setMyLocationEnabled(true);
            // Getting LocationManager object from System Service LOCATION_SERVICE
            final LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
            // Creating a criteria object to retrieve provider
            Criteria criteria = new Criteria();
            // Getting the name of the best provider
            final String provider = locationManager.getBestProvider(criteria, true);
            // Getting current location
            final Location location = locationManager.getLastKnownLocation(provider);
            final LocationListener locationListener = new LocationListener() {
                public void onLocationChanged(Location location) {
                    // Redraw the marker when get location update
                    drawMarker(location);
                }

                @Override
                public void onProviderDisabled(String provider) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void onProviderEnabled(String provider) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void onStatusChanged(String provider, int status,
                                            Bundle extras) {
                    // TODO Auto-generated method stub

                }
            };
                if(location!=null)

                {
                    // Place the initial marker
                    drawMarker(location);
                }

                locationManager.requestLocationUpdates(provider,0,0,locationListener);
*/
    }

    /*
    @Override
    public void onResume(){
        super.onResume();
    }

    @Override
    public void onStart(){
        super.onStart();
        //log into shuttle 4's account in backgrd in order to access Parse's server
        ParseUser.logInInBackground("Shuttle1", "shuttleMaster_1");
        // Execute a runnable task on creation of Activity
        handler.post(runnableCode);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();  // Always call the superclass
        ParseUser.logOutInBackground();
        handler.removeCallbacks(runnableCode);
    }
*/

    @Override
    protected void onRestart() {
        super.onRestart();  // Always call the superclass method first
        ParseUser.logInInBackground("Shuttle1", "shuttleMaster_1");
        handler.post(runnableCode);
    }


    @Override
    public void onStop() {
        super.onStop();
        ParseUser.logOutInBackground();
        handler.removeCallbacks(runnableCode);
    }


    private void drawMarker(Location location) {
        SupportMapFragment fm= (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        GoogleMap map = fm.getMap();
        map.clear();
        LatLng currentPosition = new LatLng(location.getLatitude(), location.getLongitude());
        map.addMarker(new MarkerOptions()
                .position(currentPosition)
                .snippet("Lat:" + location.getLatitude() + "Lng" + location.getLongitude())
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                .title("ME"));

    }

    // Create the Handler object
    Handler handler = new Handler();
    //Define the task to be run
    private Runnable runnableCode = new Runnable() {
        @Override
        public void run() {
            marker.remove();
            ParseUser user = ParseUser.getCurrentUser();

            ParseQuery<ParseObject> query = ParseQuery.getQuery("PlaceObject0");
            query.whereEqualTo("username", user);
            query.orderByDescending("createdAt");
            query.getFirstInBackground(new GetCallback<ParseObject>() {
                public void done(ParseObject object, ParseException e) {
                    if (e == null) {
                        //String adresGet = "";
                        ParseGeoPoint Location;
                        //query.whereEqualTo("username", user);
                        //ParseUser username;
                        // for (int i = 0; i < object.size(); i++) {
                        //adresGet = adresGet + object.get(i).getString("Adres") +"\n";
                        //username = object.getParseUser("username");
                        Location = object.getParseGeoPoint("location");
                        LatLng cPoint = new LatLng(Location.getLatitude(), Location.getLongitude());
                        //Toast.makeText(RouteFiveActivity.this, "Parse Query Successful", Toast.LENGTH_LONG).show();
                        marker = map.addMarker(new MarkerOptions()
                                .position(cPoint)
                                .snippet("Lat:" + Location.getLatitude() + "Lng" + Location.getLongitude())
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))
                                .title("UWI Shuttle #5"));

                    } else {
                        // something went wrong
                        Toast.makeText(RouteFiveActivity.this, "Fetching Location data...", Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }
                }

            });
            // Repeat this runnable code block again every 15 seconds
            handler.postDelayed(runnableCode, 15000);

        }
    };

    @Override
    public void onRoutingFailure() {
        // The Routing request failed
    }

    @Override
    public void onRoutingStart() {

    }


    @Override
    public void onRoutingSuccess(PolylineOptions mPolyOptions, Route route) {
        /*
        PolylineOptions polyoptions = new PolylineOptions();
        polyoptions.color(Color.GREEN);
        polyoptions.width(10);
        polyoptions.addAll(mPolyOptions.getPoints());
        map.addPolyline(polyoptions);


        // Start marker
        MarkerOptions options = new MarkerOptions();
        options.position(uwi);
        options.icon(BitmapDescriptorFactory.fromResource(R.drawable.start_blue));
        map.addMarker(options);


        // End marker
        options = new MarkerOptions();
        options.position(sanjuan);
        options.icon(BitmapDescriptorFactory.fromResource(R.drawable.end_blue));
        map.addMarker(options);
        */
    }



    @Override
    public void onRoutingF() {

    }




    @Override
    public void onRoutStart() {

    }



    @Override
    public void onRoutSuccess(PolylineOptions mPolyOptions, Route route){
        PolylineOptions polys= new PolylineOptions();
        polys.color(Color.YELLOW);
        polys.width(10);
        polys.addAll(mPolyOptions.getPoints());
        map.addPolyline(polys);

        MarkerOptions options1 = new MarkerOptions();
        options1.position(uwi);
        options1.icon(BitmapDescriptorFactory.fromResource(R.drawable.start_orange));
        map.addMarker(options1);


        options1 = new MarkerOptions();
        options1.position(stjohns);
        options1.icon(BitmapDescriptorFactory.fromResource(R.drawable.end_orange));
        map.addMarker(options1);

    }

    @Override
    public void onRF() {

    }

    @Override
    public void onRStart() {

    }

    @Override
    public void onRSuccess(PolylineOptions mPolyOptions, Route route) {
        /*
        PolylineOptions poly= new PolylineOptions();
        poly.color(Color.YELLOW);
        poly.width(10);
        poly.addAll(mPolyOptions.getPoints());
        map.addPolyline(poly);

        MarkerOptions options2 = new MarkerOptions();
        options2.position(uwi);
        options2.icon(BitmapDescriptorFactory.fromResource(R.drawable.start_purple));
        map.addMarker(options2);


        options2 = new MarkerOptions();
        options2.position(tunapuna);
        options2.icon(BitmapDescriptorFactory.fromResource(R.drawable.end_purple));
        map.addMarker(options2);
        */
    }



    @Override
    public void onRouF() {

    }

    @Override
    public void onRouS() {

    }

    @Override
    public void onRouteS(PolylineOptions mPolyOptions, Route route) {
        /*
        PolylineOptions poly= new PolylineOptions();
        poly.color(Color.YELLOW);
        poly.width(10);
        poly.addAll(mPolyOptions.getPoints());
        map.addPolyline(poly);

        MarkerOptions options3 = new MarkerOptions();
        options3.position(TgrNorth);
        options3.icon(BitmapDescriptorFactory.fromResource(R.drawable.start_red));
        map.addMarker(options3);


        options3 = new MarkerOptions();
        options3.position(JFKUnderpass);
        options3.icon(BitmapDescriptorFactory.fromResource(R.drawable.end_red));
        map.addMarker(options3);
        */

    }
    @Override
    public void onRoutF() {

    }

    @Override
    public void onRoutS() {

    }

    @Override
    public void onRouSuccess(PolylineOptions mPolyOptions, Route route) {
        /*
        PolylineOptions poly= new PolylineOptions();
        poly.color(Color.YELLOW);
        poly.width(10);
        poly.addAll(mPolyOptions.getPoints());
        map.addPolyline(poly);

        MarkerOptions options4 = new MarkerOptions();
        options4.position(JFKUnderpass);
        options4.icon(BitmapDescriptorFactory.fromResource(R.drawable.start_green));
        map.addMarker(options4);


        options4 = new MarkerOptions();
        options4.position(Optometry);
        options4.icon(BitmapDescriptorFactory.fromResource(R.drawable.end_green));
        map.addMarker(options4);
        */
    }


}