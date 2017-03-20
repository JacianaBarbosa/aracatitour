package com.example.gabialmeida.aracatitour.Layout;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.gabialmeida.aracatitour.Database.ManageDatabase;
import com.example.gabialmeida.aracatitour.Mapa.MapActivity;
import com.example.gabialmeida.aracatitour.R;

public class MainActivity extends Activity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);

            }
        }

        setContentView(R.layout.layout_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Aracati Tour");

        ManageDatabase dbManager = new ManageDatabase(this);

        boolean mboolean = false;

        try {
            SharedPreferences settings = getSharedPreferences("PREFS_NAME", 0);
            mboolean = settings.getBoolean("FIRST_RUN", false);
            if (!mboolean) {
                // do the thing for the first time

                dbManager.addItem();

                settings = getSharedPreferences("PREFS_NAME", 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putBoolean("FIRST_RUN", true);
                editor.commit();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        Button BtRestaurantes;
        BtRestaurantes = (Button) findViewById(R.id.restaurantes);
        BtRestaurantes.setOnClickListener(BtRestaurantesAction);

        Button BtHoteis;
        BtHoteis = (Button) findViewById(R.id.hoteis);
        BtHoteis.setOnClickListener(BtHoteisAction);

        Button BtPontos;
        BtPontos = (Button) findViewById(R.id.pontos);
        BtPontos.setOnClickListener(BtPontosAction);

        Button BtLocaisProximos;
        BtLocaisProximos = (Button) findViewById(R.id.locais);
        BtLocaisProximos.setOnClickListener(BtLocaisProximosAction);

    }

    private View.OnClickListener BtRestaurantesAction = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(MainActivity.this, RestaurantActivity.class));
        }
    };

    private View.OnClickListener BtHoteisAction = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(MainActivity.this, HotelActivity.class));
        }
    };

    private View.OnClickListener BtPontosAction = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(MainActivity.this, PointActivity.class));
        }
    };

    private View.OnClickListener BtLocaisProximosAction = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(MainActivity.this, MapActivity.class));
        }
    };

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

}