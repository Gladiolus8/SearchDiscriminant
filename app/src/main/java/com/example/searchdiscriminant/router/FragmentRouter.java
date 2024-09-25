package com.example.searchdiscriminant.router;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.searchdiscriminant.fragments.CalculationFragment;
import com.example.searchdiscriminant.fragments.DetailsFragment;
import com.example.searchdiscriminant.model.CalculationDetailsModel;
import com.example.searchdiscriminant.presenters.CalculationPresenter;
import com.example.searchdiscriminant.presenters.DetailsPresenter;

public class FragmentRouter {

    private final FragmentManager manager;
    private final int containerId;

    public FragmentRouter(FragmentManager manager, int containerId) {
        this.manager = manager;
        this.containerId = containerId;
    }

    public void showFragmentCalculator() {
        CalculationFragment fragment = (CalculationFragment) manager.findFragmentByTag(CalculationFragment.TAG);
        if (fragment == null) {
            fragment = new CalculationFragment();
            CalculationPresenter calcPresenter = new CalculationPresenter(this, fragment);
            fragment.setPresenter(calcPresenter);
        }
        showFragment(fragment, CalculationFragment.TAG);
    }

    public void showFragmentDetails(CalculationDetailsModel calculationDetailsModel) {
        DetailsFragment fragment = (DetailsFragment) manager.findFragmentByTag(DetailsFragment.TAG);
        if (fragment == null) {
            fragment = new DetailsFragment();
            DetailsPresenter detailsPresenter = new DetailsPresenter(this, fragment);
            fragment.setPresenter(detailsPresenter);
            detailsPresenter.updateData(calculationDetailsModel);
        }
        showFragment(fragment, DetailsFragment.TAG);
    }

    private void showFragment(Fragment fragment, String tag) {
        manager.beginTransaction()
                .replace(containerId, fragment, tag)
                .addToBackStack(null)
                .commit();
    }
}
