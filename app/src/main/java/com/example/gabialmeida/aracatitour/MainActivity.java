package com.example.gabialmeida.aracatitour;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gabialmeida.aracatitour.Database.ManageDatabase;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

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


}