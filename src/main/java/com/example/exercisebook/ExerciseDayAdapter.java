package com.example.exercisebook;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExerciseDayAdapter extends RecyclerView.Adapter<ExerciseDayAdapter.DayHolder> {
    private List<ExerciseDay> days = new ArrayList<ExerciseDay>();
    @NonNull
    @Override
    public ExerciseDayAdapter.DayHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.exercise_day_item, parent, false);
        return new ExerciseDayAdapter.DayHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseDayAdapter.DayHolder holder, int position) {
        ExerciseDay currentDay = days.get(position);
        Date date = currentDay.getDate();
        holder.dateContainer.setText(DateFormat.getDateInstance(DateFormat.LONG).format(date));
    }

    @Override
    public int getItemCount() {
        return days.size();
    }

    public void setDays(List<ExerciseDay> days) {
        this.days = days;
        notifyDataSetChanged();
    }

    class DayHolder extends RecyclerView.ViewHolder {
        private TextView dateContainer;

        public DayHolder(@NonNull View itemView) {
            super(itemView);
            dateContainer = itemView.findViewById(R.id.dateContainer);
        }
    }
}
