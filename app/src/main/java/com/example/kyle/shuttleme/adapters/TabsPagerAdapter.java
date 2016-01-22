package com.example.kyle.shuttleme.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.kyle.shuttleme.fragments.FragmentRouteFive;
import com.example.kyle.shuttleme.fragments.FragmentRouteFour;
import com.example.kyle.shuttleme.fragments.FragmentRouteOne;
import com.example.kyle.shuttleme.fragments.FragmentRouteThree;
import com.example.kyle.shuttleme.fragments.FragmentRouteTwo;

public class TabsPagerAdapter extends FragmentPagerAdapter {

    final int TabCount = 5;

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {
        Bundle data = new Bundle();
        switch (index) {
            case 0:
                return new FragmentRouteOne();
            case 1:
                return new FragmentRouteTwo();
            case 2:
                return new FragmentRouteThree();
            case 3:
                return new FragmentRouteFour();
            case 4:
                return new FragmentRouteFive();

        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return TabCount;
    }

}
