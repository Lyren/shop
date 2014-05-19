package org.tmp.shopclient.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragments;

    public MyFragmentPagerAdapter(FragmentManager fm,ArrayList<Fragment> list){
        super(fm);
        this.fragments = list ;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
