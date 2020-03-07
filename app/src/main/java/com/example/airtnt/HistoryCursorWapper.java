package com.example.airtnt;

import android.database.Cursor;
import android.database.CursorWrapper;

public class HistoryCursorWapper extends CursorWrapper {

    public HistoryCursorWapper(Cursor cursor) {
        super(cursor);
    }

    public String getDialog() {
        String dialog = getString(getColumnIndex(AppDbSchema.HistoryTable.Cols.DIALOG));

        return dialog;
    }

}
