package com.example.mireles.geolocalizacion;

import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class MainActivity extends AppCompatActivity {

    private FusedLocationProviderClient fusedLocationProviderClient;

    TextView latitud;
    TextView longitud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        latitud = findViewById(R.id.tv_lat);
        longitud = findViewById(R.id.tv_lng);

        this.fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
    }

    public void getLocation (View view){
        if(ActivityCompat.checkSelfPermission(
                            MainActivity.this,
                                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                            && ActivityCompat.checkSelfPermission(MainActivity.this,
                            Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
                ){
                    ActivityCompat.requestPermissions( MainActivity.this,
                                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }else {
            this.fusedLocationProviderClient.getLastLocation()
                    .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    if (location != null){
                        tv_lat.setText(Double.toString(location.getLatitude()));
                        tv_lng.setText(Double.toString(location.getLongitude()));

                        Toast.makeText(getApplicationContext(),
                                location.getLatitude() + "-----"
                                        + location.getLongitude(),
                                            Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(getApplicationContext(),
                                "No se encuentra la ubicacion",
                                    Toast.LENGTH_LONG).show();

                    }

                }
            });

        }
    }
}
