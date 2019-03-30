package com.example.goodeats;

public class AMRCalculator {

    public int calculateFemalesBMR(int weight, int height, int age) {
        int BMR = (int) (655 + (4.35 * weight) + (4.7 * height) - (4.7 * age));
        return BMR;
    }

    public int calculateMaleBMR(int weight, int height, int age) {
        int BMR = (int) (66 + (6.23 * weight) + (12.7 * height) - (6.8 * age));
        return BMR;
    }

    public int calculateAMR (int BMR, String activityLevel) {
        return BMR;
    }
}
