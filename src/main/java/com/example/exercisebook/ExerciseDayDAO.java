package com.example.exercisebook;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

public interface ExerciseDayDAO {
    @Query("SELECT Id, userId FROM ExerciseDay WHERE userId=:userId")
    List<ExerciseDay> getAllDaysByUserId(int userId);

    @Insert
    void insert(ExerciseDay day);

    @Delete
    void delete(ExerciseDay day);

    //updating excercise day only makes sense when there is an date

//    @Query("UPDATE ExerciseDay SET dateeee WHERE id = :id")
//    void update(int id, String firstName, String lastName);

}
