package com.example.exercisebook;

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

public class ExerciseDaysAdapter extends RecyclerView.Adapter<ExerciseDaysAdapter.DayHolder> {
    private List<ExerciseDay> days = new ArrayList<ExerciseDay>();
    @NonNull
    @Override
    public ExerciseDaysAdapter.DayHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.day_item, parent, false);
        return new ExerciseDaysAdapter.DayHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseDaysAdapter.DayHolder holder, int position) {
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
