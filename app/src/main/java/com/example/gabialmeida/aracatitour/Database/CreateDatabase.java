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
    private static String sql = "DROP TABLE tbRestaurante; " +
            "CREATE TABLE tbRestaurante("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "nome TEXT"
            + ");";

    public CreateDatabase(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
