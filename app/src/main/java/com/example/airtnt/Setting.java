package com.example.airtnt;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Setting {
    private enum THEME {Day, Night}
    private THEME theme;

    private Region fromRegion;
    private Region toRegion;

    private Language fromLang;
    private Language toLang;

    private Context mContext;
    private SQLiteDatabase mDatabase;

    public Setting() {

    }




}