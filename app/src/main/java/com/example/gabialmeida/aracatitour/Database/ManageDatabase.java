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

    public void addItemRestaurante(String RES_NOME){
        String sql = "INSERT INTO tbRestaurante (RES_NOME) VALUES ('"+RES_NOME+"')";
        SQLiteDatabase db = crtDatabase.getWritableDatabase();
        db.execSQL(sql);
    }

    public void addItemHotel(String HOT_NOME){
        String sql = "INSERT INTO tbHotel (HOT_NOME) VALUES ('"+HOT_NOME+"')";
        SQLiteDatabase db = crtDatabase.getWritableDatabase();
        db.execSQL(sql);
    }

    public void addItemPonto(String PNT_NOME){
        String sql = "INSERT INTO tbPonto (PNT_NOME) VALUES ('"+PNT_NOME+"')";
        SQLiteDatabase db = crtDatabase.getWritableDatabase();
        db.execSQL(sql);
    }

    public void deleteTableRestaurante(){
        String deleteRestaurante = "DELETE FROM tbRestaurante;";
        SQLiteDatabase db = crtDatabase.getWritableDatabase();
        db.execSQL(deleteRestaurante);
    }

    public void deleteTableHotel(){
        String deleteRestaurante = "DELETE FROM tbHotel;";
        SQLiteDatabase db = crtDatabase.getWritableDatabase();
        db.execSQL(deleteRestaurante);
    }

    public void deleteTablePonto(){
        String deleteRestaurante = "DELETE FROM tbPonto;";
        SQLiteDatabase db = crtDatabase.getWritableDatabase();
        db.execSQL(deleteRestaurante);
    }

    public ArrayList<String> getAllItensRestaurante(){
        SQLiteDatabase db = crtDatabase.getReadableDatabase();
        String sql = "SELECT RES_NOME FROM tbRestaurante";
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

    public ArrayList<String> getAllItensHotel(){
        SQLiteDatabase db = crtDatabase.getReadableDatabase();
        String sql = "SELECT HOT_NOME FROM tbHotel";
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

    public ArrayList<String> getAllItensPonto(){
        SQLiteDatabase db = crtDatabase.getReadableDatabase();
        String sql = "SELECT PNT_NOME FROM tbPonto";
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
