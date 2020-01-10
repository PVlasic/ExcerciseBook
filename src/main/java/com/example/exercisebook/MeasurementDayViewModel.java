package com.example.exercisebook;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MeasurementDayViewModel extends AndroidViewModel {
    private MeasurementDayRepository repository;


    public MeasurementDayViewModel(@NonNull Application application) {
        super(application);
        repository = new MeasurementDayRepository(application);

    }

    public void insert(MeasurementDay day){
        repository.insert(day);
    }

    public void update(MeasurementDay day){
        repository.update(day);
    }

    public void delete(MeasurementDay day){
        repository.delete(day);
    }

    public LiveData<List<MeasurementDay>> getAllDaysByUserId(Integer id) {
        return repository.getAllDaysByUserId(id);
    }
}
