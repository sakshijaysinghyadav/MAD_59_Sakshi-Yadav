package com.example.ridermate;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import android.content.SharedPreferences;
import android.content.Intent;
import android.net.Uri;

public class MyRidesActivity extends AppCompatActivity {

    TextView tvMyRide, tvContactMyRide;
    Button btnCancelRide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_rides);

        tvMyRide = findViewById(R.id.tvMyRide);
        tvContactMyRide = findViewById(R.id.tvContactMyRide);
        btnCancelRide = findViewById(R.id.btnCancelRide);

        SharedPreferences prefs = getSharedPreferences("rides", MODE_PRIVATE);
        String ride = prefs.getString("ride", "");

        if ("Goa Ride".equals(ride)) {

            tvMyRide.setText(
                    "📍 Goa Ride\n\n" +
                            "🗓 Date: 25 April\n" +
                            "🕒 Time: 6:00 AM\n" +
                            "📌 Start: Kolhapur\n" +
                            "🏨 Stay: Beach Camp"
            );

            // 👉 CONTACT SEPARATE
            tvContactMyRide.setText("📞 Rahul - 9876543210");

            tvContactMyRide.setOnClickListener(v -> {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:9876543210"));
                startActivity(intent);
            });

        }
        else if ("Mahabaleshwar Ride".equals(ride)) {

            tvMyRide.setText(
                    "📍 Mahabaleshwar Ride\n\n" +
                            "🗓 Date: 30 April\n" +
                            "🕒 Time: 7:00 AM\n" +
                            "📌 Start: Pune\n" +
                            "🏨 Stay: Hotel HillTop"
            );

            tvContactMyRide.setText("📞 Aman - 9123456789");

            tvContactMyRide.setOnClickListener(v -> {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:9123456789"));
                startActivity(intent);
            });

        }
        else {
            tvMyRide.setText("😕 No rides yet\n\nStart exploring and join your first ride!");
            tvContactMyRide.setText("");
        }

        // 👉 CANCEL BUTTON
        btnCancelRide.setOnClickListener(v -> {
            SharedPreferences.Editor editor = prefs.edit();
            editor.clear();
            editor.apply();

            tvMyRide.setText("❌ Ride Cancelled");
            tvContactMyRide.setText("");

            Toast.makeText(this, "Ride Cancelled", Toast.LENGTH_SHORT).show();
        });
    }
}