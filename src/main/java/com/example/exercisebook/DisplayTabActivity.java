package com.example.exercisebook;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.Date;
import java.util.List;

public class DisplayTabActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ViewPagerAdapter pagerAdapter;
    private TabLayout tabLayout;
    private ExerciseDayViewModel dayViewModel;
    public static final int NUMBER_OF_TABS = 2;
    int userId;

    public static final int ADD_DAY_REQUEST = 1;

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
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        Log.d("request","requestCode " + requestCode);
        Log.d("result","resultCode " + resultCode);
        if(requestCode == ADD_DAY_REQUEST && resultCode == RESULT_OK){
            Log.d("dateSaved","here1?");
            Long dateLong = intent.getLongExtra(EXTRA_DATE, -1);
            Log.d("hasDate", "date: " + dateLong);
            Log.d("dateSaved","here2?");
            if(dateLong != -1){
                Date date = new Date();
                date.setTime(dateLong);
                //new exercise day was created
                ExerciseDay day = new ExerciseDay(userId, date);

                Log.d("dateSaved","here3?");
                ExerciseDaysFragment.dayViewModel.insert(day);
            }


        }
    }
}
