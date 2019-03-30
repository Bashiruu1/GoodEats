package com.example.goodeats;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button calculateCalories;
    EditText age;
    EditText height;
    EditText weight;
    RadioGroup gender;
    RadioButton genderChoice;
    Spinner activityLevel;
    Spinner goalLevel;
    TextView calorieView;
    AMRCalculator amrCalculator;

    private final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        age = findViewById(R.id.age);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        gender = findViewById(R.id.gender);
        calorieView = findViewById(R.id.calorie_view);

        activityLevel = findViewById(R.id.activity_level);
        ArrayAdapter<CharSequence> activityLevelAdapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.activities, R.layout.support_simple_spinner_dropdown_item);
        activityLevelAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        activityLevel.setAdapter(activityLevelAdapter);
        activityLevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String currentLevel = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, currentLevel, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        goalLevel = findViewById(R.id.goal_level);
        ArrayAdapter<CharSequence> goalLevelAdapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.goals, R.layout.support_simple_spinner_dropdown_item);
        goalLevelAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        goalLevel.setAdapter(goalLevelAdapter);
        goalLevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String currentGoalLevel = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, currentGoalLevel, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        calculateCalories = findViewById(R.id.calculate_calorie);
        calculateCalories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    public void checkButton (View view) {
        int radioId = gender.getCheckedRadioButtonId();
        genderChoice = findViewById(radioId);
        Toast.makeText(MainActivity.this, genderChoice.getText(), Toast.LENGTH_LONG).show();
    }
}
