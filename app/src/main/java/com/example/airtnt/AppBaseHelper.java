package com.example.airtnt;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.airtnt.AppDbSchema.LanguageTable;
import com.example.airtnt.AppDbSchema.HistoryTable;

public class AppBaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "appBase.db";

    public AppBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL(
//                "CREATE TABLE " + LanguageTable.NAME + "(" + "_id integer primary key autoincrement," +
//                LanguageTable.Cols.LANGID + "," +
//                LanguageTable.Cols.LANGUAGENAME + ")"
//        );

        db.execSQL(
                "CREATE TABLE " + HistoryTable.NAME + "(" + "_id integer primary key autoincrement, " +
                        HistoryTable.Cols.DIALOG + " TEXT "+ ")"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + HistoryTable.NAME);
        onCreate(db);
    }
}
