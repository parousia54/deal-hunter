package com.pinkdroid.dealshunter.screen.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class DealViewerPageAdapter extends FragmentPagerAdapter {
	
	
    public DealViewerPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = DealViewerPageFragment.getNewInstance(i);
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: return "Popular";
            case 1: return "Most Recent";
            case 2: return "Near by";
            case 3: return "Ends soon";
        }
        return null;
    }
}
