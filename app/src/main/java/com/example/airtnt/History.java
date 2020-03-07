package com.example.airtnt;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.LinkedList;
import java.util.List;

public class History {
    private static History mhistory;
//    private List<String> dialog;

    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static History get(Context context) {
        if (mhistory == null) {
            mhistory = new History(context);
        }
        return mhistory;
    }

    public History(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new AppBaseHelper(mContext).getWritableDatabase();
//        this.dialog = new LinkedList<String>();

    }

    public List<String> getHistory() {
//        return this.dialog;
//        return new LinkedList<>();
//        return null;
        List<String> dialog = new LinkedList<>();
        HistoryCursorWapper cursor = queryHistory(null, null);
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                dialog.add(cursor.getDialog());
                cursor.moveToNext();
            }
        } finally {
                cursor.close();
            }
        return dialog;
        }





    public void addHistory(String newDialog) {
//        this.dialog.addFirst(newDialog);
        ContentValues values = getContentValues(newDialog);
        mDatabase.insert(AppDbSchema.HistoryTable.NAME, null, values);
    }

    public void updateHistory(String newDialog) {
        ContentValues values = getContentValues(newDialog);
        // not finished
    }

    private HistoryCursorWapper queryHistory(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                AppDbSchema.HistoryTable.NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );

        return new HistoryCursorWapper(cursor);
    }

    private static ContentValues getContentValues(String dialog) {
        ContentValues values = new ContentValues();
        values.put(AppDbSchema.HistoryTable.Cols.DIALOG, dialog);

        return values;
    }




}
