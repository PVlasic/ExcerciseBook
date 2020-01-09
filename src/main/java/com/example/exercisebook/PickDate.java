package com.example.exercisebook;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;
import java.util.GregorianCalendar;


public class PickDate extends AppCompatActivity {
    CalendarView calendarView;
    Date date;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_picker);

        calendarView = findViewById(R.id.calendar);
        if(calendarView != null){
            calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
                @Override
                public void onSelectedDayChange(CalendarView calendarView, int year, int month,
                                                int day) {
                    Toast.makeText(getApplicationContext(),day+ "/"+month+"/"+year,Toast.LENGTH_SHORT).show();
                    date = new GregorianCalendar(year, month, day).getTime();
                }
            });
        }

        getIntent();
        Button saveDate = findViewById(R.id.saveDate);

        saveDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (date != null) {
                    Intent intent = new Intent(PickDate.this, DisplayTabActivity.class);
                    intent.putExtra(DisplayTabActivity.EXTRA_DATE, date.getTime());
                    //startActivityForResult(intent, DisplayTabActivity.ADD_DAY_REQUEST);
                    setResult(RESULT_OK, intent);
                    finish();
                } else {
                    Toast.makeText(PickDate.this, "Pick a date before saving", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
