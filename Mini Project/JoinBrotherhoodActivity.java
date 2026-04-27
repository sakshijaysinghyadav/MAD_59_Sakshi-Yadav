package com.example.ridermate;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class JoinBrotherhoodActivity extends AppCompatActivity {

    EditText etName, etCity, etBike;
    Button btnJoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_brotherhood);

        etName = findViewById(R.id.etName);
        etCity = findViewById(R.id.etCity);
        etBike = findViewById(R.id.etBike);
        btnJoin = findViewById(R.id.btnJoin);

        btnJoin.setOnClickListener(v -> {

            String name = etName.getText().toString();
            String city = etCity.getText().toString();
            String bike = etBike.getText().toString();

            if(name.isEmpty() || city.isEmpty() || bike.isEmpty()){
                Toast.makeText(this, "Please fill all details", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Welcome to Brotherhood 🔥", Toast.LENGTH_LONG).show();
            }
        });
    }
}