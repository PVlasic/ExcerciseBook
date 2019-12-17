package com.example.exercisebook;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

public interface ExcerciseDAO {
    @Query("SELECT Id, dayId, exerciseName, numberOfSets, weight FROM Exercise WHERE dayId=:dayId")
    List<Exercise> getAllExercisesById(int dayId);

    @Insert
    void insert(ExerciseDay day);

    @Delete
    void delete(ExerciseDay day);

    @Query("UPDATE Exercise SET exerciseName=:name, numberOfSets=:numberOfSets, weight=:weight WHERE id = :id")
    void update(int id, String name, int numberOfSets, int weight);
}
