package com.example.searchdiscriminant.fragments;

import androidx.fragment.app.Fragment;

import com.example.searchdiscriminant.presenters.CalculationPresenter;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.searchdiscriminant.R;

public class CalculationFragment extends Fragment {



    EditText varA;
    EditText varB;
    EditText varC;
    TextView discriminant;
    TextView headEquation;
    Button btnCalculate;
    Button btnDetailed;
    public static final String TAG = "CalculationFragment";


    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        return inflater.inflate(R.layout.fragment_calculations, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        varA = getView().findViewById(R.id.text_input_A);
        varB = getView().findViewById(R.id.text_input_B);
        varC = getView().findViewById(R.id.text_input_C);
        discriminant = getView().findViewById(R.id.discriminant);
        btnCalculate = getView().findViewById(R.id.btn_calculation);
        btnDetailed = getView().findViewById(R.id.btn_details);
        headEquation = getView().findViewById(R.id.head_equation);

    }




    public void showEmptyFieldError() {
    }

    public void showDisc(String discriminant) {
    }

    public void showHeadEquation(String headEquation) {
    }

    public void showIncorrectInputNum() {
    }

    public void setPresenter(CalculationPresenter calcPresenter) {
    }
}