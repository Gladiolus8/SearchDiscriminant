package com.example.searchdiscriminant.presenters;


import com.example.searchdiscriminant.fragments.CalculationFragment;
import com.example.searchdiscriminant.fragments.DetailsFragment;
import com.example.searchdiscriminant.model.CalculationDetailsModel;
import com.example.searchdiscriminant.router.FragmentRouter;

public class DetailsPresenter {


        DetailsFragment view;
        FragmentRouter fragmentRouter;
        String varA;
        String varB;
        String varC;
        String discriminant;
        String equationDisc;
        String sqrt1;
        String sqrt2;
        String equationSqrt;
        String result;
        CalculationDetailsModel calculationDetailsModel;


        public DetailsPresenter(FragmentRouter fragmentRouter, DetailsFragment view) {
        this.fragmentRouter = fragmentRouter;
        this.view = view;
        }

        public void updateData(CalculationDetailsModel model) {
                calculationDetailsModel = model;

                

        }




        public void creatingEquation() {

                getVar();

                equationDisc = String.format("D = %s\u00B2 - 4 \u00D7 %s \u00D7 %s", varB, varA, varC);

                if (result.equals("Корней нет, D < 0")){
                        view.hidingText();
                        equationSqrt = "";
                }
                else if (discriminant.equals("0")) {
                        equationSqrt = String.format("X = -%s / 2 \u00D7 %s ", varB, varA);

                }
                else {
                        equationSqrt = String.format("X = (-%s \u00B1 \u221A%s) / 2 \u00D7 %s ", varB,discriminant, varA);
                }
                discriminant = String.format("D = %s", discriminant);
                view.showEquation(equationDisc, discriminant, equationSqrt, result);

        }

        public void onBackClicked() {
           fragmentRouter.showFragmentCalculator();
        }

        private void getVar() {
                varA = calculationDetailsModel.varA;
                varB = calculationDetailsModel.varB;
                varC = calculationDetailsModel.varC;
                discriminant = calculationDetailsModel.discriminant;
                sqrt1 = calculationDetailsModel.sqrt1;
                sqrt2 = calculationDetailsModel.sqrt2;
                result = calculationDetailsModel.result;
        }

    }

