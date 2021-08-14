package com.ygha.mysql.exam;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SpaceDatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION =1;
    public static final String DATABASE_NAME = "space.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + SpaceDatabaseContract.SapceEntry.TABLE_NAME + " (" +
                    SpaceDatabaseContract.SapceEntry._ID + " INTEGER PRIMARY KEY," +
                    SpaceDatabaseContract.SapceEntry.SAPCE + " TEXT," +
                    SpaceDatabaseContract.SapceEntry.NICKNAME + " TEXT," +
                    SpaceDatabaseContract.SapceEntry.UUID + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + SpaceDatabaseContract.SapceEntry.TABLE_NAME;


    public SpaceDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }
}
