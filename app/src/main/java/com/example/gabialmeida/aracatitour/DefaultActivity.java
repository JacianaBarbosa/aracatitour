package com.example.gabialmeida.aracatitour;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Alberto Zaranza on 29/11/2016.
 */

public class DefaultActivity extends Activity {

    private TextView textNome;
    private TextView textRua;
    private TextView textNumero;
    private TextView textBairro;

    private SQLiteDatabase dataBase;

    private int ID;
    private String tabela;
    private String atributoID;
    private String atributoNome;
    private String atributoRua;
    private String atributoNumero;
    private String atributoBairro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_def);

        textNome = (TextView) findViewById(R.id.textViewNome);
        textRua = (TextView) findViewById(R.id.textViewRua);
        textNumero = (TextView) findViewById(R.id.textViewNum);
        textBairro = (TextView) findViewById(R.id.textViewBairro);


        try {
            Bundle extra = getIntent().getExtras();

            if (extra != null) {
                ID = Integer.parseInt(extra.getString("ID"));
                tabela = extra.getString("tabela");
                atributoID = extra.getString("atributoID");
                atributoNome = extra.getString("atributoNome");
                atributoRua = extra.getString("atributoRua");
                atributoNumero = extra.getString("atributoNumero");
                atributoBairro = extra.getString("atributoBairro");
            }

            dataBase = openOrCreateDatabase("BDGuiaTuristico.db", MODE_PRIVATE, null);

            Cursor cursor = dataBase.rawQuery("SELECT * FROM " + tabela + " WHERE " + atributoID + " = " + ID + "", null);

            cursor.moveToFirst();

            while (cursor != null) {
                textNome.setText(cursor.getString(cursor.getColumnIndex("" + atributoNome + "")));
                textRua.setText(cursor.getString(cursor.getColumnIndex("" + atributoRua + "")));
                textNumero.setText(cursor.getString(cursor.getColumnIndex("" + atributoNumero + "")));
                textBairro.setText(cursor.getString(cursor.getColumnIndex("" + atributoBairro + "")));
                cursor.moveToNext();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
