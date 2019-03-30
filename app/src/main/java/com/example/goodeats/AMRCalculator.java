package com.example.goodeats;

public class AMRCalculator {

    double bmr;
    double amr;
    String[] activityLevels = {"Light", "Moderate", "Active", "Very Active"};


    public String getActivityLevel(int a) {
        return activityLevels[a];
    }
    public double calculateFemaleBMR(double weight, double height, double age) {
        bmr = (655 + (4.35 * weight) + (4.7 * height) - (4.7 * age));
        return bmr;
    }

    public double calculateMaleBMR(double weight, double height, double age) {
        bmr = (66 + (6.23 * weight) + (12.7 * height) - (6.8 * age));
        return bmr;
    }

    public double calculateAMR(double bmr, String activityLevel) {
        if (activityLevel.equals(activityLevels[0])) {
            return bmr * 1.375;
        } else if (activityLevel.equals(activityLevels[1])) {
            return bmr * 1.55;
        } else if (activityLevel.equals(activityLevels[2])) {
            return bmr * 1.725;
        } else if (activityLevel.equals(activityLevels[3])) {
            return bmr * 1.9;
        }
        return -1.0;
    }

}
