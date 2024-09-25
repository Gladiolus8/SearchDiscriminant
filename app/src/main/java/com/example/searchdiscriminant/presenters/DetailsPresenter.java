package com.example.searchdiscriminant.presenters;


import com.example.searchdiscriminant.fragments.CalculationFragment;
import com.example.searchdiscriminant.fragments.DetailsFragment;
import com.example.searchdiscriminant.model.CalculationDetailsModel;
import com.example.searchdiscriminant.router.FragmentRouter;

public class DetailsPresenter {


    private final DetailsFragment view;
    private final FragmentRouter fragmentRouter;

    public DetailsPresenter(FragmentRouter fragmentRouter, DetailsFragment view) {
        this.fragmentRouter = fragmentRouter;
        this.view = view;
    }

        public void updateData(CalculationDetailsModel calculationDetailsModel) {
        }
    }

