package com.example.goodeats;

public class Fitness {

    public double calculateCarbs (double amr) {
        return Math.ceil(amr*0.6/4);
    }

    public double calculateProtein (double amr) {
        return Math.ceil(amr*0.2/4);
    }
    public double calculateFats (double amr) {
        return Math.ceil(amr*0.2/9);
    }
}
