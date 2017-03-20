package com.example.gabialmeida.aracatitour.Layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.gabialmeida.aracatitour.Database.ManageDatabase;
import com.example.gabialmeida.aracatitour.R;

import java.util.ArrayList;


/**
 * Created by Gabi Almeida on 22/11/2016.
 */

public class RestaurantActivity extends Activity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_res);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Restaurantes");

        ManageDatabase dbManager = new ManageDatabase(this);

        ArrayList<String> itens = dbManager.getAllItens("tbRestaurante", "RES_NOME");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                itens
        );

        ListView listaItens = (ListView) findViewById(R.id.list_view_restaurantes);
        listaItens.setAdapter(adapter);

        listaItens.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(RestaurantActivity.this, DefaultActivity.class);
                it.putExtra("ID", Integer.toString(i+1));
                it.putExtra("tabela", "tbRestaurante");
                it.putExtra("atributoID","RES_ID");
                it.putExtra("atributoNome","RES_NOME");
                it.putExtra("atributoRua","RES_RUA");
                it.putExtra("atributoNumero","RES_NUMERO");
                it.putExtra("atributoBairro","RES_BAIRRO");
                it.putExtra("atributoImagem", "RES_IMAGEM");
                startActivity(it);
            }
        });


    }
}
