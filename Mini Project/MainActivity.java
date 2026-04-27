package com.example.ridermate;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnExplore, btnBrotherhood, btnIncoming;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnExplore = findViewById(R.id.btnExplore);
        btnBrotherhood = findViewById(R.id.btnBrotherhood);
        btnIncoming = findViewById(R.id.btnIncoming);

        btnExplore.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ExploreBikesActivity.class));
        });
    }
}