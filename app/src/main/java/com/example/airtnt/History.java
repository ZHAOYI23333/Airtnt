package com.example.airtnt;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.LinkedList;

public class History {

    private LinkedList<String> dialog;

    private Context mContext;
    private SQLiteDatabase mDatabase;

    public History(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new AppBaseHelper(mContext).getWritableDatabase();
        this.dialog = new LinkedList<String>();

    }

    public LinkedList<String> getDialog() {
        return this.dialog;
    }

    public void insertDialog(String newDialog) {
        this.dialog.add(newDialog);
    }


}
