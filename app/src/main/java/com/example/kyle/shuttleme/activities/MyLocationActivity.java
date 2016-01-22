package com.example.kyle.shuttleme.activities;

import android.app.Dialog;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.kyle.shuttleme.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

/**
 * Created by Kyle on 31/03/2015.
 */
public class MyLocationActivity extends FragmentActivity{
    private int geo1Int;
    private int geo2Int;
    private ParseGeoPoint point1;
    private ParseUser a;

    /*private GoogleMap mMap;
    private LatLngBounds AUSTRALIA = new LatLngBounds(
            new LatLng(-44, 113), new LatLng(-10, 154));

    public MainActivity(GoogleMap mMap) {
        this.mMap = mMap;
    }*/

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_my_location);
            // Getting Google Play availability status
            int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getBaseContext());
            // Showing status
            if(status!=ConnectionResult.SUCCESS){ // Google Play Services not available
                int requestCode = 10;
                Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status, this, requestCode);
                dialog.show();
            }// Google Play Services is available
                // Getting reference to the SupportMapFragment of activity_my_location.xml
                GoogleMap googleMap;

                //Getting user that is currently logged in and using this Activity
            final ParseUser user = ParseUser.getCurrentUser();
            final ParseObject object = new ParseObject("PlaceObject0");
            final ParseObject object1 = new ParseObject("PlaceObject1");
                //name = object.getParseUser("username");
                SupportMapFragment fm = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
                // Getting Google Map object from the fragment
                googleMap = fm.getMap();

                // Enabling MyLocationActivity Layer of Google
                googleMap.setMyLocationEnabled(true);

                // Getting LocationManager object from System Service LOCATION_SERVICE
                LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
                // Creating a criteria object to retrieve provider
                Criteria criteria = new Criteria();
                // Getting the name of the best provider
                String provider = locationManager.getBestProvider(criteria, true);
                // Getting current location
                Location location = locationManager.getLastKnownLocation(provider);
                LocationListener locationListener = new LocationListener(){
                    public void onLocationChanged(Location location){
                        // Redraw the marker when get location update
                        drawMarker(location);
                        /*if(name == user){
                            drawMarker(location);
                            ParseGeoPoint point= new ParseGeoPoint(location.getLatitude(), location.getLongitude());
                            object.put("username", user);
                            object.put("location", point);
                            object.saveInBackground();
                        }
                        else if (name1 == user){
                            drawMarker(location);
                            ParseGeoPoint point= new ParseGeoPoint(location.getLatitude(), location.getLongitude());
                            object1.put("username", user);
                            object1.put("location", point);
                            object1.saveInBackground();
                        }
                        //ParseUser user = ParseUser.getCurrentUser();
                        //object.setUser(ParseUser.getCurrentUser());
                        */
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
                    public void onStatusChanged(String provider, int status, Bundle extras) {
                        // TODO Auto-generated method stub

                    }
                };
                if(location!=null){
                    // Place the initial marker
                    drawMarker(location);
                }
                locationManager.requestLocationUpdates(provider, 15000, 25, locationListener);


        }

    public ParseUser isKyle(){
        ParseQuery<ParseUser> query = ParseUser.getQuery();
        query.whereEqualTo("username", "Kyle");
        query.findInBackground();
        return isKyle();
    }

        public void drawMarker(final Location location) {
            SupportMapFragment fm = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
            GoogleMap googleMap = fm.getMap();
            googleMap.clear();

            //Parse.enableLocalDatastore(this);
            //Parse.initialize(this, "J0rxWXQK2mNvqywnIajNoyqbvNuFCVuRfCVxFWmA", "ijPw81KABO6fl6vVQiWAYAupEUaLgJeZBBy8qNiZ");

            //Save the current Installation to Parse.
            //ParseInstallation.getCurrentInstallation().saveInBackground();

            //getting a specific user by object ID then put the value in a table according to user
            // ParseQuery<ParseUser> query = ParseUser.getQuery();
            //query.getInBackground("wV2yl590u3", new GetCallback<ParseUser>(){
                //public void done(ParseUser object, ParseException e){

                    //if (e == null){
                        //ParseUser A = object.getParseUser("username");
                        ParseUser user = ParseUser.getCurrentUser();
                        //ParseUser B = user.getParseUser("username");
                        ParseGeoPoint point = new ParseGeoPoint(location.getLatitude(), location.getLongitude());
                        //if(A == B) {
                            ParseObject object0 = new ParseObject("PlaceObject0");
                            object0.put("location", point);
                            object0.put("username", user);
                            object0.saveInBackground();
                            //Toast.makeText(MyLocationActivity.this, B.toString() + "and" + A.toString(), Toast.LENGTH_LONG).show();
                        //}
                        /*else {
                            ParseObject object1 = new ParseObject("PlaceObject1");
                            object1.put("location", point);
                            object1.put("username", user);
                            object1.saveInBackground();
                        } */
                    //}
                    //else {
                        /*something went wrong
                        Toast.makeText(MyLocationActivity.this, "Parse Query failed", Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }*/

                //}
            //}); //end getInBackground method

            //LatLng currentPosition = new LatLng(location.getLatitude(), location.getLongitude());
            //LatLng point = currentPosition;
            /*object1 placement*/

            LatLng currentPosition = new LatLng(location.getLatitude(), location.getLongitude());
            googleMap.addMarker(new MarkerOptions()
                    .position(currentPosition)
                    .snippet("Lat:" + location.getLatitude() + "Lng" + location.getLongitude())
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                    .title("ME"));

            /*
            CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(currentPosition, 20);
            googleMap.animateCamera(cameraUpdate);
            */

            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(currentPosition)    // Sets the center of the map to the user's current position
                    .zoom(20)                   // Sets the zoom
                    .bearing(0)
                    .tilt(80)                   // Sets the tilt of the camera to 80 degrees
                    .build();                   // Creates a CameraPosition from the builder
            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition), 4000, null);


            /*Save the current Installation to Parse.
            ParseInstallation.getCurrentInstallation().saveInBackground();
            */

            //ParseGeoPoint point = new ParseGeoPoint(location.getLatitude(), location.getLongitude());
            //ParseObject object = new ParseObject("PlaceObject");
            //object.put("location", point);
            //object.saveInBackground();

/*
            ParseGeoPoint point= new ParseGeoPoint(location.getLatitude(), location.getLongitude());

            ParseObject object = new ParseObject("PlaceObject");
            object.put("location", point);
            object.saveInBackground();



            ParseQuery<ParseObject> query = ParseQuery.getQuery("PlaceObject");
            query.getInBackground("9OM1koEtgi", new GetCallback<ParseObject>() {
                public void done(ParseObject object, ParseException e) {
                    if (e == null) {
                        //String adresGet = "";
                        ParseGeoPoint Location;

                       // for (int i = 0; i < object.size(); i++) {
                            //adresGet = adresGet + object.get(i).getString("Adres") +"\n";

                            Location = object.getParseGeoPoint("location");
                            geo1Int = (int) (Location.getLatitude()*1E6);
                            geo2Int = (int) (Location.getLongitude()*1E6);
                        LatLng cPoint = new LatLng(geo1Int, geo2Int);
                             Intent intent=new Intent(MyLocationActivity.this, RouteOneActivity.class);
                             intent.putExtra(ParseComp.INTENT_EXTRA_LOCATION,cPoint);
                             //startActivity(intent);


                    } else {
                        // something went wrong
                        e.printStackTrace();
                    }
                }

                @Override
                public void done(ParseObject parseObject, com.parse.ParseException e) {

                }


            }); */

        }

}
