package com.example.exercisebook;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MeasurementDayFragment extends Fragment {
    private int userId;
    public static MeasurementDayViewModel dayViewModel;
    public MeasurementDayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final MeasurementDayAdapter adapter = new MeasurementDayAdapter();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.measurement_days_layout, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewMeasurementDays);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        Bundle bundle = getArguments();
        userId = bundle.getInt("userId");


        dayViewModel = ViewModelProviders.of(this).get(MeasurementDayViewModel.class);
        dayViewModel.getAllDaysByUserId(userId).observe(this, new Observer<List<MeasurementDay>>() {
            @Override
            public void onChanged(List<MeasurementDay> days) {
                adapter.setDays(days);
            }
        });

        return view;
    }
}
