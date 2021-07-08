package com.example.infs3605;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class MeditateFragment extends Fragment {

    private NumberPicker timePicker;
    private int meditationTime;
    private Button btnStart;

    public MeditateFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_meditate, container, false);

        timePicker = view.findViewById(R.id.npTimePicker);
        btnStart = view.findViewById(R.id.btnStart);

        timePicker.setMaxValue(10);
        timePicker.setMinValue(0);
        timePicker.setValue(5);

        meditationTime = timePicker.getValue();

        timePicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                meditationTime = newVal;
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MeditateActivity.class);
                intent.putExtra("Time", meditationTime);
                startActivity(intent);
            }
        });



        return view;
    }
}