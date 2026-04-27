package com.example.ridermate;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import android.content.SharedPreferences;
import android.content.Intent;
import android.net.Uri;

public class RideDetailActivity extends AppCompatActivity {

    TextView tvRideName, tvDetails;
    Button btnJoinRide, btnOpenMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride_detail);

        tvRideName = findViewById(R.id.tvRideName);
        tvDetails = findViewById(R.id.tvDetails);
        btnJoinRide = findViewById(R.id.btnJoinRide);
        btnOpenMap = findViewById(R.id.btnOpenMap);

        // 👉 get ride name
        String rideName = getIntent().getStringExtra("ride");

        if (rideName == null) {
            rideName = "";
        }

        // 👉 set ride details + map
        if (rideName.equals("Goa Ride")) {

            tvRideName.setText("📍 Goa Beach Ride 🏖🏍");
            tvDetails.setText(
                    "🗓 Date: 25 April\n" +
                            "🕒 Time: 6:00 AM\n" +
                            "📌 Start: Kolhapur\n" +
                            "🏨 Stay: Beach Camp\n" +
                            "📞 Contact: Rahul - 9876543210"
            );

            // 👉 MAP (Goa)
            btnOpenMap.setOnClickListener(v -> {
                Uri uri = Uri.parse("geo:0,0?q=Goa Beach");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            });

        } else if (rideName.equals("Mahabaleshwar Ride")) {

            tvRideName.setText("📍 Hill Adventure Ride ⛰🏍");
            tvDetails.setText(
                    "🗓 Date: 30 April\n" +
                            "🕒 Time: 7:00 AM\n" +
                            "📌 Start: Pune\n" +
                            "🏨 Stay: Hotel HillTop\n" +
                            "📞 Contact: Aman - 9123456789"
            );

            // 👉 MAP (Mahabaleshwar)
            btnOpenMap.setOnClickListener(v -> {
                Uri uri = Uri.parse("geo:0,0?q=Mahabaleshwar Hill");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            });

        } else {
            tvRideName.setText("No Ride");
            tvDetails.setText("No details available");
        }

        // 👉 SAVE ride
        String finalRideName = rideName;
        btnJoinRide.setOnClickListener(v -> {

            SharedPreferences prefs = getSharedPreferences("rides", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();

            editor.putString("ride", finalRideName);
            editor.apply();

            Toast.makeText(this, "Ride Joined Successfully 🔥", Toast.LENGTH_SHORT).show();
        });
    }
}