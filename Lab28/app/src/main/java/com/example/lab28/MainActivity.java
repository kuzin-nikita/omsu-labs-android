package com.example.lab28;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button streetViewButton = findViewById(R.id.streetViewButton);
        streetViewButton.setOnClickListener(view -> {
            String geoUriString = "google.streetview:cbll=59.939448,30.328264&cbp=1,99.56,,1,2.0&mz=19";
            Uri geoUri = Uri.parse(geoUriString);
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, geoUri);

            if (mapIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(mapIntent);
            }
        });


    }

    public void onClick(View view) {
        /*String geoUriString = "geo:0,10?z=2";
        Uri geoUri = Uri.parse(geoUriString);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, geoUri);
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }*/

        String geoURI = "geo:0,0?q=москва+театр+кошек&z=8";
        Uri geo = Uri.parse(geoURI);
        Intent geoIntent = new Intent(Intent.ACTION_VIEW, geo);

        if (geoIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(geoIntent);
        }
    }
}