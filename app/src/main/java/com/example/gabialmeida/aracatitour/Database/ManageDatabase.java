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

        //Restaurantes
        String sql = "INSERT INTO tbRestaurante (RES_NOME, RES_RUA, RES_NUMERO, RES_BAIRRO) " +
                "VALUES ('Chaparral', 'Rua 1', 100, 'Dique')";
        db.execSQL(sql);
        sql = "INSERT INTO tbRestaurante (RES_NOME, RES_RUA, RES_NUMERO, RES_BAIRRO) " +
                "VALUES ('Picanha no Ponto', 'Rua 2', 200, 'Pedregal')";
        db.execSQL(sql);
        sql = "INSERT INTO tbRestaurante (RES_NOME, RES_RUA, RES_NUMERO, RES_BAIRRO) " +
                "VALUES ('Super Grill', 'Rua 3', 300, 'Centro')";
        db.execSQL(sql);
        sql = "INSERT INTO tbRestaurante (RES_NOME, RES_RUA, RES_NUMERO, RES_BAIRRO) " +
                "VALUES ('Comida Caseira', 'Rua 4', 400, 'Centro')";
        db.execSQL(sql);
        sql = "INSERT INTO tbRestaurante (RES_NOME, RES_RUA, RES_NUMERO, RES_BAIRRO) " +
                "VALUES ('Talher de Prata', 'Rua 5', 500, 'Centro')";
        db.execSQL(sql);

        //Hoteis
        sql = "INSERT INTO tbHotel (HOT_NOME, HOT_RUA, HOT_NUMERO, HOT_BAIRRO) " +
                "VALUES ('Bons Ventos', 'Rua 6', 600, 'Centro')";
        db.execSQL(sql);
        sql = "INSERT INTO tbHotel (HOT_NOME, HOT_RUA, HOT_NUMERO, HOT_BAIRRO) " +
                "VALUES ('Por do Sol', 'Rua 7', 700, 'Centro')";
        db.execSQL(sql);
        sql = "INSERT INTO tbHotel (HOT_NOME, HOT_RUA, HOT_NUMERO, HOT_BAIRRO) " +
                "VALUES ('Sol Nascente', 'Rua 8', 800, 'Centro')";
        db.execSQL(sql);
        sql = "INSERT INTO tbHotel (HOT_NOME, HOT_RUA, HOT_NUMERO, HOT_BAIRRO) " +
                "VALUES ('Bom Sono', 'Rua 9', 900, 'Centro')";
        db.execSQL(sql);
        sql = "INSERT INTO tbHotel (HOT_NOME, HOT_RUA, HOT_NUMERO, HOT_BAIRRO) " +
                "VALUES ('Melhor Dia', 'Rua 10', 1000, 'Centro')";
        db.execSQL(sql);

        //Pontos
        sql = "INSERT INTO tbPonto (PNT_NOME, PNT_RUA, PNT_NUMERO, PNT_BAIRRO) " +
                "VALUES ('Museu', 'Rua 11', 1100, 'Centro')";
        db.execSQL(sql);
        sql = "INSERT INTO tbPonto (PNT_NOME, PNT_RUA, PNT_NUMERO, PNT_BAIRRO) " +
                "VALUES ('Biblioteca', 'Rua 12', 1200, 'Centro')";
        db.execSQL(sql);
        sql = "INSERT INTO tbPonto (PNT_NOME, PNT_RUA, PNT_NUMERO, PNT_BAIRRO) " +
                "VALUES ('Igreja', 'Rua 13', 1300, 'Centro')";
        db.execSQL(sql);
        sql = "INSERT INTO tbPonto (PNT_NOME, PNT_RUA, PNT_NUMERO, PNT_BAIRRO) " +
                "VALUES ('Praça', 'Rua 14', 1400, 'Centro')";
        db.execSQL(sql);
        sql = "INSERT INTO tbPonto (PNT_NOME, PNT_RUA, PNT_NUMERO, PNT_BAIRRO) " +
                "VALUES ('Iglu', 'Rua 15', 1500, 'Centro')";
        db.execSQL(sql);
    }

    public ArrayList<String> getAllItens(String tabela, String atributo){
        SQLiteDatabase db = crtDatabase.getReadableDatabase();
        String sql = "SELECT " + atributo + " FROM " + tabela + "";
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
