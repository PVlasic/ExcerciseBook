package com.example.exercisebook;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ExerciseHolder>{
    private List<Exercise> exercises = new ArrayList<>();
    @NonNull
    @Override
    public ExerciseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.exercise_item, parent, false);
        return new ExerciseHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseHolder holder, int position) {
        final Exercise currentExercise = exercises.get(position);
        Log.d("test3", "on bind Name: " + currentExercise.getName() + " on bind sets: " + currentExercise.repetitionsBySet.size());
        for(Integer i = 1; i <= currentExercise.repetitionsBySet.size(); ++i){
            Log.d("test3", "value: " + currentExercise.repetitionsBySet.get(i));
        }
        holder.nameTextView.setText(currentExercise.getName());
        holder.weightTextView.setText(currentExercise.getWeight().toString());

        for(Integer index = 1; index <= currentExercise.getNumberOfSets(); ++index){
            final Button btn = new Button(holder.setsContainer.getContext());
            btn.setId(index);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(100, 100);
            params.setMargins(5,5,5,10);
            btn.setLayoutParams(params);
            btn.setBackgroundResource(R.drawable.btn_circle_background);
            btn.setTextSize(15);
            btn.setTextColor(Color.parseColor("#EEEEEE"));

            if(currentExercise.repetitionsBySet.get(index, -1) != -1){
                btn.setText(String.valueOf(currentExercise.repetitionsBySet.get(index)));
            }

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(currentExercise.repetitionsBySet.get(v.getId(), -1) == -1){
                        currentExercise.repetitionsBySet.put(v.getId(), 5);
                        btn.setText(String.valueOf(currentExercise.repetitionsBySet.get(v.getId())));
                    } else {
                        if(currentExercise.repetitionsBySet.get(v.getId()) != 0){
                            currentExercise.repetitionsBySet.put(v.getId(), currentExercise.repetitionsBySet.get(v.getId()) - 1);
                            btn.setText(String.valueOf(currentExercise.repetitionsBySet.get(v.getId())));
                        } else {
                            currentExercise.repetitionsBySet.delete(v.getId());
                            btn.setText("");
                        }
                    }

                }
            });
            holder.setsContainer.addView(btn);
        }

    }

    @Override
    public int getItemCount() {

        return exercises.size();
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
        Log.d("myTest3", "Received exercises adapter: " + exercises.size());
        notifyDataSetChanged();
    }

    public List<Exercise> getExercises(){
        return this.exercises;
    }

    class ExerciseHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private LinearLayout setsContainer;
        private TextView weightTextView;

        public ExerciseHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.exerciseName);
            weightTextView = itemView.findViewById(R.id.weight);
            setsContainer = itemView.findViewById(R.id.exerciseSetContainer);

        }
    }
}
