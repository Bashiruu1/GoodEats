package com.example.goodeats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MeanPlan extends AppCompatActivity {

    Intent intent;
    double calories;
    double carb;
    double protein;
    double fat;
    Spinner numberOfMealSpinner;

    int numberOfMeals;

    LinearLayout linearLayout;
    public static TextView[] meals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mean_plan);

        numberOfMealSpinner = findViewById(R.id.meal_spinner);
        linearLayout = findViewById(R.id.mean_plan_layout);
        ArrayAdapter<CharSequence> goalLevelAdapter = ArrayAdapter.createFromResource(MeanPlan.this, R.array.meals, R.layout.support_simple_spinner_dropdown_item);
        goalLevelAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        numberOfMealSpinner.setAdapter(goalLevelAdapter);
        numberOfMealSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                numberOfMeals = Integer.valueOf(parent.getItemAtPosition(position).toString());
                meals = new TextView[numberOfMeals];
                for (int i = 0; i < numberOfMeals; i++) {
                    meals[i] = new TextView(MeanPlan.this);
                    meals[i].setText("Meal: " + i);
                    meals[i].setTextSize(2, 30);
                    linearLayout.addView(meals[i]);
                    FetchMeals process = new FetchMeals();
                    process.execute();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        intent = getIntent();
        calories = intent.getDoubleExtra("calories", 0)/ numberOfMeals;
        carb = intent.getDoubleExtra("carb", 0)/ numberOfMeals;
        protein = intent.getDoubleExtra("protein", 0)/ numberOfMeals;
        fat = intent.getDoubleExtra("fat", 0)/ numberOfMeals;


    }
}
