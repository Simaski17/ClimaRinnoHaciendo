package com.example.jimmyhernandez.climarinno.activity.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jimmyhernandez.climarinno.R;
import com.example.jimmyhernandez.climarinno.activity.model.Example;
import com.example.jimmyhernandez.climarinno.activity.model.Forecast;
import com.example.jimmyhernandez.climarinno.activity.rest.ApiClient;
import com.example.jimmyhernandez.climarinno.activity.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    // TODO - insert your themoviedb.org API KEY here
    private final static String API_KEY = "4c9c63494dcf49a18b0194907162710";
    private final static String Q = "Santiago";
    private final static String DAYS = "1";

    private TextView cityText;
    private TextView condDescr;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cityText = (TextView) findViewById(R.id.cityText);
        condDescr = (TextView) findViewById(R.id.condDescr);

        if (API_KEY.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please obtain your API KEY first from themoviedb.org", Toast.LENGTH_LONG).show();
            return;
        }

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<Example> call = apiService.getInfo(API_KEY,Q,DAYS);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                String hola = response.body().getLocation().getName();
                //List<Forecast> movies = response.body().getResults();
                //cityText.setText(hola);
                //condDescr.setText(descr);
                Log.e(TAG, " AQUIIIIIIIIIIIIIIII " + hola);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }
}