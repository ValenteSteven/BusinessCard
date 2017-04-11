package com.example.reiko.businesscard;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by reiko on 04/04/2017.
 */

public class DictionaryOpenHelper extends SQLiteOpenHelper {
    private static final String DICTIONNARY_TABLE_NAME = "mytable";
    public static final String DICTIONNARY_KEY_WORD = "category";
    public static final String DICTIONNARY_KEY_DEFINITION = "word";
    private static final String DICTIONNARY_TABLE_CREATE = "CREATE TABLE "+
    DICTIONNARY_TABLE_NAME +
            ExampleContract.ExampleEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " ("+DICTIONNARY_KEY_WORD + " TEXT, " + DICTIONNARY_KEY_DEFINITION + " TEXT);";
    public static final String DATABASE_NAME = "example.db";
    DictionaryOpenHelper(Context context){
        super(context,DATABASE_NAME,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(ExampleContract.ExampleEntry.getSqlCreate());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ExampleContract.ExampleEntry.getTableName());
        onCreate(db);
    }
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}
