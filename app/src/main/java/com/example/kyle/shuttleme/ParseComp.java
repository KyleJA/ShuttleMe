package com.example.kyle.shuttleme;


import android.app.Application;

import com.parse.Parse;


public class ParseComp extends Application {

    // Used to pass location from MainActivity to PostActivity
    public static final String INTENT_EXTRA_LOCATION = "location";
    @Override
    public void onCreate() {


        super.onCreate();
        //Enable Local Datastore.

        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "ovXhVQ2t2Ww2yshawfN4zmVmanm005J44EjZtqeS", "l3Bg1afuBUelIg936CwVvkxCIKnT9gWVgCJ9DCvk");

        //Save the current Installation to Parse.
        // ParseInstallation.getCurrentInstallation().saveInBackground();
        // List<String> subscribedChannels = ParseInstallation.getCurrentInstallation().getList("channels");

/*
        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();

     */

/*
        ParseGeoPoint point = new ParseGeoPoint(10.6423880, -61.4005280);

        ParseObject object = new ParseObject("PlaceObject");
        object.put("location", point);
        object.saveInBackground();
        */
/*
        ParseQuery<ParseObject> query = ParseQuery.getQuery("PlaceObject");
        query.getInBackground("9OM1koEtgi", new GetCallback<ParseObject>() {
            public void done(ParseObject object, ParseException e) {
                if (e == null) {


                } else {
                    // something went wrong
                }
            }

            @Override
            public void done(ParseObject parseObject, com.parse.ParseException e) {

            }
        });

    }
}



/*

        myObject.fetchInBackground(new GetCallback<ParseObject>() {
            public void done(ParseObject object, ParseException e) {
                if (e == null) {
                    // Success!
                } else {
                    // Failure!
                }
            }


            @Override
            public void done(ParseObject parseObject, com.parse.ParseException e) {

            }


        });

    }
    */


    }
}



