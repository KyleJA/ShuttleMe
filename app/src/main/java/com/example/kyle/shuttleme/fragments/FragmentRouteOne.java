package com.example.kyle.shuttleme.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.kyle.shuttleme.R;
import com.example.kyle.shuttleme.activities.RouteOneActivity;

public class FragmentRouteOne extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_route1, container, false);
        Button routeButton = (Button) rootView.findViewById(R.id.routeButton);
        routeButton.setOnClickListener(this);
        return rootView;

    }


    @Override
    public void onClick(View v) {
        Intent viewRoute1 = new Intent(getActivity(), RouteOneActivity.class);
        startActivity(viewRoute1);

    }

}
