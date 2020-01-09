package com.example.exercisebook;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


public class ViewPagerAdapter extends FragmentPagerAdapter{
    int mNumOfTabs;
    int userId;

    public ViewPagerAdapter(FragmentManager fm, int numOfTabs, int userId) {
        super(fm, numOfTabs);
        this.mNumOfTabs = numOfTabs;
        this.userId = userId;
    }
    @Override
    public Fragment getItem(int position) {

        Bundle bundle = new Bundle();
        bundle.putInt("userId", userId);

        switch (position) {
            case 0:
                ExerciseDaysFragment tab1 = new ExerciseDaysFragment();
                tab1.setArguments(bundle);
                return tab1;
            case 1:
                MeasurementsFragment tab2 = new MeasurementsFragment();
                tab2.setArguments(bundle);
                return tab2;
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return mNumOfTabs;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Exercises";
            case 1:
                return "Measurements";
            default:
                return null;
        }
    }
}
