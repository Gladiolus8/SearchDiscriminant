package com.example.searchdiscriminant.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.searchdiscriminant.R;
import com.example.searchdiscriminant.presenters.DetailsPresenter;

public class DetailsFragment extends Fragment {

    TextView discriminant;
    TextView discFinding;
    TextView sqrtX;
    TextView sqrtFinding;
    Button btnBack;
    DetailsPresenter presenter;
    public static final String TAG = "DetailsFragment";

    TextView test;




    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


            discFinding = getView().findViewById(R.id.discriminant_find);
            discriminant = getView().findViewById(R.id.disc);
            sqrtFinding = getView().findViewById(R.id.sqrt_find);
            sqrtX = getView().findViewById(R.id.sqrt);
            btnBack = getView().findViewById(R.id.btn_back);

        test = getView().findViewById(R.id.test);

//        presenter.creatingEquation();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onBackClicked();
            }
        });



    }




    public void setPresenter(DetailsPresenter detailsPresenter) {
        this.presenter = presenter;
    }


    public void showEquation(String equationDisc, String disc, String equationSqrt, String sqrt) {
        discFinding.setText(equationDisc);
        discriminant.setText(disc);
        sqrtFinding.setText(equationSqrt);
        sqrtX.setText(sqrt);
    }

    public void showTest(String test1){
        test.setText(test1);
    }

    public void  hidingText() {
//        sqrtX.setVisibility(View.GONE);
        sqrtFinding.setVisibility(View.GONE);
    }



}