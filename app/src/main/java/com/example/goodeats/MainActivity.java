package com.example.goodeats;

import android.content.Intent;
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

    Button showMyResults;
    EditText age;
    EditText height;
    EditText weight;
    Double bmr;
    Double amr;
    RadioGroup gender;
    RadioButton genderChoice;
    Spinner activityLevel;
    String currentLevel;
    String currentGoalLevel;
    Spinner goalLevel;
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
        amrCalculator = new AMRCalculator();

        activityLevel = findViewById(R.id.activity_level);
        ArrayAdapter<CharSequence> activityLevelAdapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.activities, R.layout.support_simple_spinner_dropdown_item);
        activityLevelAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        activityLevel.setAdapter(activityLevelAdapter);
        activityLevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                currentLevel = parent.getItemAtPosition(position).toString();
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
                currentGoalLevel = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        showMyResults = findViewById(R.id.show_my_result);
        showMyResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bmr = amrCalculator.calculateMaleBMR(Double.valueOf(weight.getText().toString()), Double.valueOf(height.getText().toString()), Double.valueOf(age.getText().toString()));
                if (currentLevel.equals(amrCalculator.getActivityLevel(0))) {
                    amr = Math.ceil(bmr * 1.375);
                    sendAmr();
                } else if (currentLevel.equals(amrCalculator.activityLevels[1])) {
                    amr = Math.ceil(bmr * 1.55);
                    sendAmr();
                } else if (currentLevel.equals(amrCalculator.activityLevels[2])) {
                    amr = Math.ceil(bmr * 1.725);
                    sendAmr();
                } else if (currentLevel.equals(amrCalculator.activityLevels[3])) {
                    amr = Math.ceil(bmr * 1.9);
                    sendAmr();
                }
            }
        });
    }

    private void sendAmr() {
        Intent myIntent = new Intent(MainActivity.this, Results.class);
        myIntent.putExtra("amr", amr);
        myIntent.putExtra("currentGoalLevel", currentGoalLevel);
        startActivity(myIntent);
    }

    public void checkButton (View view) {
        int radioId = gender.getCheckedRadioButtonId();
        genderChoice = findViewById(radioId);
        Toast.makeText(MainActivity.this, genderChoice.getText(), Toast.LENGTH_LONG).show();
    }
}
