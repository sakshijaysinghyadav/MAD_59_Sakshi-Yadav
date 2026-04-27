package com.example.ridermate;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class IncomingRidesActivity extends AppCompatActivity {

    Button btnRide1, btnRide2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incoming_rides);

        btnRide1 = findViewById(R.id.btnRide1);
        btnRide2 = findViewById(R.id.btnRide2);

        // 🔥 Goa Ride
        btnRide1.setOnClickListener(v -> {

            // 👉 SAVE DATA
            SharedPreferences prefs = getSharedPreferences("rides", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("ride", "Goa Ride");
            editor.apply();

            Toast.makeText(this, "Joined Goa Ride 🔥", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, RideDetailActivity.class);
            intent.putExtra("ride", "Goa Ride");
            startActivity(intent);
        });

        // 🔥 Mahabaleshwar Ride
        btnRide2.setOnClickListener(v -> {

            // 👉 SAVE DATA
            SharedPreferences prefs = getSharedPreferences("rides", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("ride", "Mahabaleshwar Ride");
            editor.apply();

            Toast.makeText(this, "Joined Mahabaleshwar Ride ⛰️", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, RideDetailActivity.class);
            intent.putExtra("ride", "Mahabaleshwar Ride");
            startActivity(intent);
        });
    }
}