package com.example.ridermate;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BikeDetailActivity extends AppCompatActivity {

    TextView tvBikeName, tvBikeDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike_detail);

        tvBikeName = findViewById(R.id.tvBikeName);
        tvBikeDetails = findViewById(R.id.tvBikeDetails);

        String bike = getIntent().getStringExtra("bike");

        tvBikeName.setText(bike);

        if (bike.equals("Himalayan")) {
            tvBikeDetails.setText("Engine: 452cc\nPrice: ₹2.8 Lakh\nType: Adventure Bike");
        }
        else if (bike.equals("Classic 350")) {
            tvBikeDetails.setText("Engine: 349cc\nPrice: ₹2.0 Lakh\nType: Cruiser Bike");
        }
        else if (bike.equals("GT 650C")) {
            tvBikeDetails.setText("Engine: 648cc\nPrice: ₹3.2 Lakh\nType: Cafe Racer");
        }
    }
}