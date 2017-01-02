package com.example.gabialmeida.aracatitour;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Alberto Zaranza on 29/11/2016.
 */

public class DefaultActivity extends AppCompatActivity {

    private TextView textNome;
    private TextView textBairro;
    private TextView textRua;
    private TextView textNumero;
    private SQLiteDatabase dataBase;
    int ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_def);

        textNome = (TextView) findViewById(R.id.textViewNome);
        textBairro = (TextView) findViewById(R.id.textViewBairro);
        textRua = (TextView) findViewById(R.id.textViewRua);
        textNumero = (TextView) findViewById(R.id.textViewNum);


        try {
            Bundle extra = getIntent().getExtras();

            if (extra != null) {
                String lastText = extra.getString("ID");
                ID = Integer.parseInt(lastText);
                //textNumero.setText(lastText);
            }

            dataBase = openOrCreateDatabase("BDGuiaTuristico.db", MODE_PRIVATE, null);

            Cursor cursor = dataBase.rawQuery("SELECT * FROM tbRestaurante WHERE RES_ID = " + ID + "", null);

            cursor.moveToFirst();

            while (cursor != null) {
                textNome.setText(cursor.getString(cursor.getColumnIndex("RES_NOME")));
                textNumero.setText(cursor.getString(cursor.getColumnIndex("RES_ID")));
                cursor.moveToNext();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
