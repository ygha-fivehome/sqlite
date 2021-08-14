package com.ygha.mysql.exam;

import android.provider.BaseColumns;

public class SpaceDatabaseContract {


    private SpaceDatabaseContract(){

    }


    public static class SapceEntry implements BaseColumns{
        public static final String TABLE_NAME = "space";
        public static final String SAPCE = "column_space";
        public static final String NICKNAME = "column_nickname";
        public static final String UUID = "column_uuid";
    }


}
