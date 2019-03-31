package com.example.goodeats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Results extends AppCompatActivity {

    TextView leftGoalView, rightGoalVIew;
    TextView leftCalorieView, rightCalorieView;
    TextView leftCarbView, rightCarbView;
    TextView leftProteinView, rightProteinView;
    TextView leftFatView, rightFatView;
    Button createMealPlan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        leftGoalView = findViewById(R.id.goal_left_view);
        rightGoalVIew = findViewById(R.id.goal_right_view);
        leftCalorieView = findViewById(R.id.calorie_left_view);
        rightCalorieView = findViewById(R.id.calorie_right_view);
        leftCarbView = findViewById(R.id.carb_left_view);
        rightCarbView = findViewById(R.id.carb_right_view);
        leftProteinView = findViewById(R.id.protein_left_view);
        rightProteinView = findViewById(R.id.protein_right_view);
        leftFatView = findViewById(R.id.fats_left_view);
        rightFatView = findViewById(R.id.fats_right_view);

        Intent intent = getIntent();
        Double amr = intent.getDoubleExtra("amr", 0);
        String currentGoalLevel = intent.getStringExtra("currentGoalLevel");

        rightGoalVIew.setText(currentGoalLevel);
        if (currentGoalLevel.equals("Gain Weight")) {
            amr += 500;
        }else if (currentGoalLevel.equals("Lose Weight")) {
            amr -= 500;
        }
        rightCalorieView.setText(amr + "");
        rightCarbView.setText(Math.ceil(((0.6*amr)/4)) + "g");
        rightProteinView.setText(Math.ceil(((0.2*amr)/4)) + "g");
        rightFatView.setText(Math.ceil(((0.2*amr)/9)) + "g");

        createMealPlan = findViewById(R.id.create_mealplan_button);
        createMealPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
