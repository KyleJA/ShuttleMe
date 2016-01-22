package com.example.kyle.shuttleme.routingHelpers;

/**
 * Created by Kyle on 01/04/2015.
 */
import com.example.kyle.shuttleme.routingHelpers.Route;
import com.google.android.gms.maps.model.PolylineOptions;


public interface RoutingListener {

    public void onRoutingFailure();

    public void onRoutingStart();

    public void onRoutingF();

    public void onRStart();

    public void onRF();

    public void onRoutStart();

    public void onRoutF();

    public void onRoutS();

    public void onRouF();

    public void onRouS();

    public void onRoutSuccess(PolylineOptions mPolyOptions, Route route);

    public void onRoutingSuccess(PolylineOptions mPolyOptions, Route route);

    public void onRSuccess(PolylineOptions mPolyOptions, Route route);

    public void onRouteS(PolylineOptions mPolyOptions, Route route);

    public void onRouSuccess(PolylineOptions mPolyOptions, Route route);




    // public void onRoutingSuccesss(PolylineOptions mPolyOptions, Route route);
}
