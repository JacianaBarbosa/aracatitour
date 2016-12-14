package com.example.gabialmeida.aracatitour.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Alberto Zaranza on 12/12/2016.
 */

public class ManegeDatabase {
    private static CreateDatabase crtDatabase = null;

    public ManegeDatabase(Context context){
        if(crtDatabase == null){
            crtDatabase = new CreateDatabase(context);
        }
    }

    public void addItem(String nome){
        String sql = "INSERT INTO tbRestaurante (nome) VALUES ('"+nome+"')";
        SQLiteDatabase db = crtDatabase.getWritableDatabase();
        db.execSQL(sql);
    }

    public void deleteRestaurante(){
        String deleteRestaurante = "DELETE FROM tbRestaurante;";
        SQLiteDatabase db = crtDatabase.getWritableDatabase();
        db.execSQL(deleteRestaurante);
    }

    public ArrayList<String> getAllItens(){
        SQLiteDatabase db = crtDatabase.getReadableDatabase();
        String sql = "SELECT nome FROM tbRestaurante";
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
