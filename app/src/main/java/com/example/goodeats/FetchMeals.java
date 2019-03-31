package com.example.goodeats;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static com.example.goodeats.MeanPlan.meals;

public class FetchMeals extends AsyncTask<Void, Void, Void> {

    String data, dataParsed, singleParsed = "";

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://api.myjson.com/bins/5zq6a");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line = "";
            while (line != null) {
                line = bufferedReader.readLine();
                data += line;
            }

            JSONArray jsonArray = new JSONArray(data);
            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                singleParsed = "Name: " + jsonObject.get("name") +"\n" +
                               "Calories: " + jsonObject.get("calorie") +"\n" +
                               "Carbs: " + jsonObject.get("carb") +"\n" +
                               "Protein: " + jsonObject.get("protein") +"\n" +
                               "Fats: " + jsonObject.get("fat") +"\n";

                dataParsed += singleParsed;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        for (int i = 0; i < meals.length; i++) {
            MeanPlan.meals[i].setText(this.data);
        }
    }
}
