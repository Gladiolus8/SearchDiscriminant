package com.example.searchdiscriminant.model;

public class CalculationDetailsModel {
    public String varA;
    public String varB;
    public String varC;
    public String discriminant;
    public String result;
    public String sqrt1;
    public String sqrt2;

    public CalculationDetailsModel(String varA, String varB, String varC, String discriminant, String sqrt1, String sqrt2, String result) {
        this.varA = varA;
        this.varB = varB;
        this.varC = varC;
        this.discriminant = discriminant;
        this.result = result;
        this.sqrt1 = sqrt1;
        this.sqrt2 = sqrt2;
    }
}
