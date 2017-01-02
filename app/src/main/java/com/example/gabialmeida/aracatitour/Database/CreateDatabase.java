package com.example.gabialmeida.aracatitour.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Alberto Zaranza on 09/12/2016.
 */

public class CreateDatabase extends SQLiteOpenHelper {

    private static String NOME_BANCO = "BDGuiaTuristico.db";
    private static int VERSAO = 1;


    private static String CreateRes =

            "CREATE TABLE tbRestaurante (" +
            "RES_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "RES_NOME TEXT," +
            "RES_RUA TEXT," +
            "RES_NUMERO INTEGER," +
            "RES_BAIRRO TEXT" +
            ");";

    private static String CreateRst =

            "CREATE TABLE tbRestauranteTelefone (" +
            "RST_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "RST_TELEFONE INTEGER," +
            "FOREING KEY RES_ID REFERENCES tbRestaurante(RES_ID)" +
            ");";

    private static String CreateHot =

            "CREATE TABLE tbHotel (" +
            "HOT_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "HOT_NOME TEXT," +
            "HOT_RUA TEXT," +
            "HOT_NUMERO INTEGER," +
            "HOT_BAIRRO TEXT" +
            ");";

    private static String CreateHtt =

            "CREATE TABLE tbHotelTelefone (" +
            "HTT_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "HTT_TELEFONE INTEGER," +
            "FOREING KEY HOT_ID REFERENCES tbHotel(HOT_ID)" +
            ");";

    private static String CreatePnt =

            "CREATE TABLE tbPonto (" +
            "PNT_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "PNT_NOME TEXT," +
            "PNT_RUA TEXT," +
            "PNT_NUMERO INTEGER," +
            "PNT_BAIRRO TEXT" +
            ");";

    private static String CreatePtt =

            "CREATE TABLE tbPontoTelefone (" +
            "PTT_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "PTT_TELEFONE INTEGER," +
            "FOREING KEY PNT_ID REFERENCES tbPonto(PNT_ID)" +
            ");";

    public CreateDatabase(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CreateRes);
        db.execSQL(CreateRst);
        db.execSQL(CreateHot);
        db.execSQL(CreateHtt);
        db.execSQL(CreatePnt);
        db.execSQL(CreatePtt);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP DATABASE IF EXISTS BDGuiaTuristico.db");
        onCreate(db);
    }


}
