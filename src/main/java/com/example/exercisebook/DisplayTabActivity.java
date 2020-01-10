package com.example.exercisebook;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.Date;

public class DisplayTabActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ViewPagerAdapter pagerAdapter;
    private TabLayout tabLayout;

    int userId;

    public Fragment currentFragment;
    public static final int ADD_EXCERCISE_DAY_REQUEST = 1;
    public static final int ADD_MEASUREMENT_DAY_REQUEST = 2;
    public static final int NUMBER_OF_TABS = 2;
    public static final String EXTRA_DATE =
            "com.example.exercisebook.EXTRA_DATE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_display_layout);

        Intent intent = getIntent();
        if(intent.hasExtra(AddEditUserActivity.EXTRA_USER_ID)){
            userId = intent.getIntExtra(AddEditUserActivity.EXTRA_USER_ID,-1);

            if (userId != -1) {

                viewPager = findViewById(R.id.pager);
                pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), NUMBER_OF_TABS, userId);

                viewPager.setAdapter(pagerAdapter);

                tabLayout = findViewById(R.id.tabs);
                tabLayout.setupWithViewPager(viewPager);
                tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
                viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


            }
        }
        //when activity is first created current fragment is ExerciseDayFragment
        currentFragment = new ExerciseDayFragment();
        //listener for tab changing
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentFragment = pagerAdapter.getRegisteredFragment(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        FloatingActionButton addDayButton = findViewById(R.id.buttonAddDay);
        addDayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DisplayTabActivity.this, PickDate.class);

                if (currentFragment instanceof ExerciseDayFragment) {
                    startActivityForResult(intent, ADD_EXCERCISE_DAY_REQUEST);
                } else if (currentFragment instanceof MeasurementDayFragment) {
                    startActivityForResult(intent, ADD_MEASUREMENT_DAY_REQUEST);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (requestCode == ADD_EXCERCISE_DAY_REQUEST && resultCode == RESULT_OK) {
            Long dateLong = intent.getLongExtra(EXTRA_DATE, -1);
            if (dateLong != -1) {
                Date date = new Date();
                date.setTime(dateLong);
                //new exercise day is created
                ExerciseDay day = new ExerciseDay(userId, date);
                ExerciseDayFragment.dayViewModel.insert(day);
            }
        } else if (requestCode == ADD_MEASUREMENT_DAY_REQUEST && resultCode == RESULT_OK) {
            Long dateLong = intent.getLongExtra(EXTRA_DATE, -1);
            if (dateLong != -1) {
                Date date = new Date();
                date.setTime(dateLong);
                //new measurement day is created
                MeasurementDay day = new MeasurementDay(userId, date);
                MeasurementDayFragment.dayViewModel.insert(day);
            }
        }
    }
}
