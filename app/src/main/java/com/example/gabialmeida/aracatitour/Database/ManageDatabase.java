package com.example.gabialmeida.aracatitour.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Alberto Zaranza on 12/12/2016.
 */

public class ManageDatabase {

    private static CreateDatabase crtDatabase = null;

    public ManageDatabase(Context context){
        if(crtDatabase == null){
            crtDatabase = new CreateDatabase(context);
        }
    }

    public void addItem(){
        SQLiteDatabase db = crtDatabase.getWritableDatabase();
        String RES = "INSERT INTO tbRestaurante (RES_NOME, RES_RUA, RES_NUMERO, RES_BAIRRO) " +
                "VALUES ('Chaparral', 'Rua 1', 100, 'Dique')";
        db.execSQL(RES);
        RES = "INSERT INTO tbRestaurante (RES_NOME, RES_RUA, RES_NUMERO, RES_BAIRRO) " +
                "VALUES ('Picanha no Ponto', 'Rua 2', 200, 'Pedregal')";
        db.execSQL(RES);
        RES = "INSERT INTO tbRestaurante (RES_NOME, RES_RUA, RES_NUMERO, RES_BAIRRO) " +
                "VALUES ('Super Grill', 'Rua 3', 300, 'Centro')";
        db.execSQL(RES);
        RES = "INSERT INTO tbRestaurante (RES_NOME, RES_RUA, RES_NUMERO, RES_BAIRRO) " +
                "VALUES ('Comida Caseira', 'Rua 4', 400, 'Centro')";
        db.execSQL(RES);
        RES = "INSERT INTO tbRestaurante (RES_NOME, RES_RUA, RES_NUMERO, RES_BAIRRO) " +
                "VALUES ('Talher de Prata', 'Rua 5', 500, 'Centro')";
        db.execSQL(RES);
    }

    public ArrayList<String> getAllItens(String tabela, String atributo){
        SQLiteDatabase db = crtDatabase.getReadableDatabase();
        String sql = "SELECT "+atributo+" FROM "+tabela+"";
        Cursor cursor = db.rawQuery(sql, null);
        ArrayList<String> itens = null;

        if(cursor != null && cursor.moveToFirst()){
            itens = new ArrayList<String>();

            do{
                itens.add(cursor.getString(0));
            }while (cursor.moveToNext());
        }

        return itens;
    }
}
