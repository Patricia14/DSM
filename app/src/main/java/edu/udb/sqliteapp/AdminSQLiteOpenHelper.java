package edu.udb.sqliteapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public static final String CREATE_TABLE = "CREATE TABLE persona ("
            + "codigo INTEGER PRIMARY KEY,"
            + "nombre INTEGER TEXT,"
            + "apellido INTEGER TEXT,"
            + "edad INTEGER INTEGER,"
            + "telefono TEXT);";

    public AdminSQLiteOpenHelper(Context context, String name,
                                 SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}