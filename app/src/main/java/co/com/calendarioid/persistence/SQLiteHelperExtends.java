package co.com.calendarioid.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import co.com.calendarioid.R;

public class SQLiteHelperExtends extends SQLiteOpenHelper {

    public SQLiteHelperExtends(Context context, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, context.getResources().getString(R.string.db_name), factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}