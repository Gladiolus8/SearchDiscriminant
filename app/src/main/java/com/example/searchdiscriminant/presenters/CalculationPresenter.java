package com.example.searchdiscriminant.presenters;

import com.example.searchdiscriminant.fragments.CalculationFragment;
import com.example.searchdiscriminant.model.CalculationDetailsModel;
import com.example.searchdiscriminant.router.FragmentRouter;
import java.text.DecimalFormat;

public class CalculationPresenter {
    Double varA;
    Double varB;
    Double varC;
    Double discriminant;
    Double sqrt1, sqrt2;
    String result;
    String headEquation;
    CalculationFragment view;
    FragmentRouter fragmentRouter;
    CalculationDetailsModel calculationDetailsModel1;
    DecimalFormat decimalFormat = new DecimalFormat("0.#");

    public CalculationPresenter(FragmentRouter fragmentRouter, CalculationFragment view) {
        this.fragmentRouter = fragmentRouter;
        this.view = view;
    }

    public void onCalculateClicked(
            String varA,
            String varB,
            String varC
    ) {
        if (varA.equals("") || varB.equals("") || varC.equals("")) {
            view.showEmptyFieldError();
        } else if (!varA.equals(".") && !varB.equals(".") && !varC.equals(".")) {
            this.varA = Double.parseDouble(varA);
            this.varB = Double.parseDouble(varB);
            this.varC = Double.parseDouble(varC);
            discriminant = (
                    this.varB * this.varB - 4 * this.varA * this.varC
            );
            if (discriminant > 0){
                sqrt1 = (-this.varB + Math.sqrt(discriminant)/ (2 * this.varA));
                sqrt2 = (-this.varB - Math.sqrt(discriminant)/ (2 * this.varA));
                result = String.format("X1 = %s, X2 = %s",  decimalFormat.format(sqrt1), decimalFormat.format(sqrt2));
            }
            else if (discriminant == 0){
                sqrt1 = (-this.varB / (2 * this.varA));
                sqrt2 = 0.0;
                result = String.format("X = %s",  decimalFormat.format(sqrt1));
            }
            else {
                //result = "Корней нет, D < 0";
                result = "Корней нет, D < 0";
                sqrt1 = 0.0;
                sqrt2 = 0.0;
                }
            saveVar();
            view.showDisc(String.format("D = %s", decimalFormat.format(discriminant)));
            view.showResult(result);
            headEquation = String.format(
                    "%sx\u00B2 + %sx + %s = 0",
                    decimalFormat.format(this.varA),
                    decimalFormat.format(this.varB),
                    decimalFormat.format(this.varC)
            );
            view.showHeadEquation(headEquation);
        } else view.showIncorrectInputNum();
    }

    public void onDetailedClicked() {
        fragmentRouter.showFragmentDetails(calculationDetailsModel1);
    }

    private void saveVar() {
        calculationDetailsModel1 = new CalculationDetailsModel(
                decimalFormat.format(varA),
                decimalFormat.format(varB),
                decimalFormat.format(varC),
                decimalFormat.format(discriminant),
                decimalFormat.format(sqrt1),
                decimalFormat.format(sqrt2),
                result
        );
    }
}