package com.example.gabialmeida.aracatitour;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Gabi Almeida on 25/11/2016.
 */

public class NovaTela2 extends Activity {

    private ListView listaItens;
    private String[] itens = {
            "Hotel"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout3);

        listaItens = (ListView) findViewById(R.id.list_view_hoteis);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                itens
        );

        listaItens.setAdapter(adaptador);

        listaItens.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if (i == 0) {
                    Intent it = new Intent(NovaTela2.this, TelaTeste0.class);
                    startActivity(it);
                }
            }
        });
    };

}
