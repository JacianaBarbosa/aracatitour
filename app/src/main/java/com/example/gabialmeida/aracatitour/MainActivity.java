package com.example.gabialmeida.aracatitour;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;


public class MainActivity extends Activity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

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

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private View.OnClickListener BtRestaurantesAction = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent it = new Intent(MainActivity.this, RestaurantActiviry.class);
            startActivity(it);
        }
    };

    private View.OnClickListener BtHoteisAction = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent it = new Intent(MainActivity.this, HotelActivity.class);
            startActivity(it);
        }
    };

    private View.OnClickListener BtPontosAction = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent it = new Intent(MainActivity.this, PointActivity.class);
            startActivity(it);
        }
    };

    private View.OnClickListener BtLocaisProximosAction = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent it = new Intent(MainActivity.this, MapActivity.class);
            startActivity(it);
        }
    };

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}