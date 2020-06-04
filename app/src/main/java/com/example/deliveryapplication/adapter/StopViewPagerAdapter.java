package com.example.deliveryapplication.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class StopViewPagerAdapter extends FragmentStatePagerAdapter {
    private final List<Fragment> mList = new ArrayList<>();
    private final List<String> mTitleList = new ArrayList<>();

    public StopViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }


    @NonNull
    @Override
    public Fragment getItem(int i) {
        return mList.get(i);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    public void addFragment(Fragment fragment, String title) {
        mList.add(fragment);
        mTitleList.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleList.get(position);
    }
}