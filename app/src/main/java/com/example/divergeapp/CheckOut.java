package com.example.divergeapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;


import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class CheckOut extends AppCompatActivity {
    Button button;
    EditText cvc,card;
    FusedLocationProviderClient providerClient;
    private FirebaseAuth mAuth;
    LocationRequest request;

    static final int RCS=1001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        button=findViewById(R.id.pay);
        card=findViewById(R.id.cardnumber);
        cvc=findViewById(R.id.cvc);

        request = LocationRequest.create();
        request.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        request.setInterval(5000);
        request.setFastestInterval(2000);


        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder().addLocationRequest(request);
        builder.setAlwaysShow(true);
        Task<LocationSettingsResponse> locationSettingsResponseTask = LocationServices.getSettingsClient(getApplicationContext()).checkLocationSettings(builder.build());

        locationSettingsResponseTask.addOnCompleteListener(new OnCompleteListener<LocationSettingsResponse>() {
            @Override
            public void onComplete(@NonNull Task<LocationSettingsResponse> task) {
                try {
                    LocationSettingsResponse obj = locationSettingsResponseTask.getResult(ApiException.class);
                } catch (ApiException e) {
                    e.printStackTrace();
                    switch (e.getStatusCode()) {
                        case LocationSettingsStatusCodes
                                .RESOLUTION_REQUIRED:

                            try {
                                ResolvableApiException exception = (ResolvableApiException) e;
                                exception.startResolutionForResult(CheckOut.this, RCS);
                            } catch (IntentSender.SendIntentException sendIntentException) {
                                sendIntentException.printStackTrace();
                            }
                            break;

                        case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                            break;
                    }
                }


            }
        });

        providerClient= LocationServices.getFusedLocationProviderClient(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (checkout()) {
                if (ActivityCompat.checkSelfPermission(CheckOut.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    providerClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
                        @Override
                        public void onComplete(@NonNull Task<Location> task) {
                            Location location = task.getResult();
                            if (location != null) {

                                try {
                                    Geocoder geocoder = new Geocoder(CheckOut.this, Locale.getDefault());
                                    List<Address> list = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                                    String address = list.get(0).getAddressLine(0);
                                    Toast.makeText(CheckOut.this, "Payment Made!", Toast.LENGTH_SHORT).show();
                                    Toast.makeText(CheckOut.this, "Delivery to '" + address + "' on the way", Toast.LENGTH_LONG).show();

                                    startActivity(new Intent(CheckOut.this,StoreActivity.class));

                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                            }

                        }
                    });
                } else {
                    ActivityCompat.requestPermissions(CheckOut.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
                }
            }

            }
        });
    }


    private Boolean checkout() {
        String cardnum = card.getText().toString().trim();
        String cvcnum = cvc.getText().toString().trim();

        if (cardnum.isEmpty()) {  
            card.setError("Card Number is required");
            card.requestFocus();
            return false;
            
        }
        if (cvcnum.isEmpty()) {
            cvc.setError("CVC is required");
            cvc.requestFocus();
            return false;

        }
        return  true;







    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==RCS){
            switch (requestCode){
                case Activity
                        .RESULT_OK:
                    Toast.makeText(CheckOut.this, "Location turned On", Toast.LENGTH_SHORT).show();
                    break;
                case Activity
                        .RESULT_CANCELED:
                    Toast.makeText(CheckOut.this, "location is required", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

}

