package com.example.exercisebook;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


public class ViewPagerAdapter extends FragmentPagerAdapter{
    int mNumOfTabs;
    int userId;
    SparseArray<Fragment> registeredFragments = new SparseArray<>();

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
                ExerciseDayFragment tab1 = new ExerciseDayFragment();
                tab1.setArguments(bundle);
                return tab1;
            case 1:
                MeasurementDayFragment tab2 = new MeasurementDayFragment();
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

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        registeredFragments.put(position, fragment);
        return fragment;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        registeredFragments.remove(position);
        super.destroyItem(container, position, object);
    }

    public Fragment getRegisteredFragment(int position) {
        return registeredFragments.get(position);
    }
}
