package com.example.searchdiscriminant.fragments;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.searchdiscriminant.presenters.CalculationPresenter;

import android.content.Context;
import android.graphics.Color;
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


    Context context  = getContext();

    EditText varA;
    EditText varB;
    EditText varC;
    TextView discriminant;
    TextView result;
    TextView headEquation;
    Button btnCalculate;
    Button btnDetailed;
    CalculationPresenter presenter;
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
        result = getView().findViewById(R.id.result);
        btnCalculate = getView().findViewById(R.id.btn_calculation);
        btnDetailed = getView().findViewById(R.id.btn_details);
        headEquation = getView().findViewById(R.id.head_equation);



        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onCalculateClicked(
                        varA.getText().toString(),
                        varB.getText().toString(),
                        varC.getText().toString()
                );
            }
        });

        btnDetailed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onDetailedClicked();
            }
        });

    }

    public void setPresenter(CalculationPresenter presenter) {
        this.presenter = presenter;
    }

    public void showEmptyFieldError() {

        discriminant.setTextColor(Color.parseColor("#D32D2D"));

        discriminant.setText("Ошибка, поля не могут быть пусты!");
    }

    public void showDisc(String disc) {
        discriminant.setText(disc);
        btnDetailed.setVisibility(View.VISIBLE);
    }

    public void showResult(String res) {
        result.setText(res);
    }

    public void showHeadEquation(String headEquation) {
        this.headEquation.setText(headEquation);
    }

    public void showIncorrectInputNum() {
        discriminant.setText("Ошибка, введён неверный символ");
        discriminant.setTextColor(Color.parseColor("#D32D2D"));
    }





}