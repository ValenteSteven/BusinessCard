package com.example.reiko.businesscard;

import android.os.Environment;
import android.provider.BaseColumns;

/**
 * Created by reiko on 04/04/2017.
 */

public final class ExampleContract {
   public boolean isExternalStorageReadable() {
       String state = Environment.getExternalStorageState();
       return (Environment.MEDIA_MOUNTED.equals(state) ||
               Environment.MEDIA_MOUNTED_READ_ONLY.equals(state));
   }

   public boolean isExternalStorageWritable() {
       String state = Environment.getExternalStorageState();
       return Environment.MEDIA_MOUNTED.equals(state);
   }


    private ExampleContract(){}

    public static abstract class ExampleEntry implements BaseColumns {
        private static final String TABLE_NAME = "mytable";
        private static final String COLUMN_NAME_CATEGORY = "category";
        private static final String COLUMN_NAME_WORD = "word";

        public static String getTableName() {
            return TABLE_NAME;
        }

        public static String getColumnNameCategory() {
            return COLUMN_NAME_CATEGORY;
        }

        public static String getColumnNameWord() {
            return COLUMN_NAME_WORD;
        }

        public static String getSqlCreate() {
            return SQL_CREATE;
        }

        private static final String SQL_CREATE = "CREATE TABLE " +
                TABLE_NAME + "(" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME_CATEGORY + " TEXT, "+
                COLUMN_NAME_WORD + " TEXT);";
    }




}
