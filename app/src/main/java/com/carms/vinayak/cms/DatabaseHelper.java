package com.carms.vinayak.cms;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ItsAPro on 06/04/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "CMS.db";

    // Table User

    public static final String T1_TABLE_NAME = "USER";
    public static final String T1_COL_1 = "USER_ID";
    public static final String T1_COL_2 = "FIRSTNAME";
    public static final String T1_COL_3 = "LASTNAME";
    public static final String T1_COL_4 = "DOB";
    public static final String T1_COL_5 = "PHONE";


    //Table Vehicle

    public static final String T2_TABLE_NAME = "VEHICLE";
    public static final String T2_COL_1 = "VEHICLE_ID";
    public static final String T2_COL_2 = "REGNO";
    public static final String T2_COL_3 = "CHASISNO";
    public static final String T2_COL_4 = "CARMAKE";
    public static final String T2_COL_5 = "CARMODEL";
    public static final String T2_COL_6 = "YEAROFMFG";
    public static final String T2_COL_7 = "TANKCAP";
    public static final String T2_COL_8 = "FUELAVG";
    public static final String T2_COL_9 = "REGISTERER";
    public static final String T2_COL_10 = "USERID";


    //Table Expenses

    public static final String T3_TABLE_NAME = "EXPENSE";
    public static final String T3_COL_1 = "EXPENSE_ID";
    public static final String T3_COL_2 = "DATE";
    public static final String T3_COL_3 = "TOLL";
    public static final String T3_COL_4 = "FUEL";
    public static final String T3_COL_5 = "SERVICE";
    public static final String T3_COL_6 = "PARKING";
    public static final String T3_COL_7 = "NOTES";
    public static final String T3_COL_8 = "VEHICLEID";


    //Table Trip

    public static final String T4_TABLE_NAME = "TRIP";
    public static final String T4_COL_1 = "TRIP_ID";
    public static final String T4_COL_2 = "DATE";
    public static final String T4_COL_3 = "TRIP_TO";
    public static final String T4_COL_4 = "TRIP_FROM";
    public static final String T4_COL_5 = "DISTANCE";
    public static final String T4_COL_6 = "COSTING";
    public static final String T4_COL_7 = "NOTES";
    public static final String T4_COL_8 = "VEHICLEID";




    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
//        SQLiteDatabase db = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + T1_TABLE_NAME + "( " + T1_COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + T1_COL_2 + " VARCHAR(45), " + T1_COL_3 + " VARCHAR(45), " + T1_COL_4 + " VARCHAR(45), " + T1_COL_5 + " VARCHAR(45)) ");
        db.execSQL("CREATE TABLE " + T2_TABLE_NAME + "( " + T2_COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + T2_COL_2 + " VARCHAR(45), " + T2_COL_3 + " VARCHAR(45), " + T2_COL_4 + " VARCHAR(45), " + T2_COL_5 + " VARCHAR(45), " + T2_COL_6 + " VARCHAR(45), " + T2_COL_7 + " VARCHAR(45), " + T2_COL_8 + " VARCHAR(45), " + T2_COL_9 + " VARCHAR(45), " + T2_COL_10 + " INTEGER NOT NULL, FOREIGN KEY (" + T2_COL_10 + ") REFERENCES " + T1_TABLE_NAME + "(" + T1_COL_1 + ")) ");
        db.execSQL("CREATE TABLE " + T3_TABLE_NAME + "( " + T3_COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + T3_COL_2 + " VARCHAR(45), " + T3_COL_3 + " VARCHAR(45), " + T3_COL_4 + " VARCHAR(45), " + T3_COL_5 + " VARCHAR(45), " + T3_COL_6 + " VARCHAR(45), " + T3_COL_7 + " VARCHAR(45), " + T3_COL_8 + " INTEGER NOT NULL, FOREIGN KEY (" + T3_COL_8 + ") REFERENCES " + T2_TABLE_NAME + "(" + T2_COL_1 + ")) ");
        db.execSQL("CREATE TABLE " + T4_TABLE_NAME + "( " + T4_COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + T4_COL_2 + " VARCHAR(45), " + T4_COL_3 + " VARCHAR(45), " + T4_COL_4 + " VARCHAR(45), " + T4_COL_5 + " VARCHAR(45), " + T4_COL_6 + " VARCHAR(45), " + T4_COL_7 + " VARCHAR(45), " + T4_COL_8 + " INTEGER NOT NULL, FOREIGN KEY (" + T4_COL_8 + ") REFERENCES " + T2_TABLE_NAME + "(" + T2_COL_1 + ")) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + T1_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + T2_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + T3_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + T4_TABLE_NAME);
        onCreate(db);

    }

    public boolean insertUser(String firstname, String lastname, String dob, String phone){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(T1_COL_2, firstname);
        contentValues.put(T1_COL_3, lastname);
        contentValues.put(T1_COL_4, dob);
        contentValues.put(T1_COL_5, phone);
        long result = db.insert(T1_TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;

    }
}
