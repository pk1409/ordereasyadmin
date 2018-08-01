package com.oeasy.ordereasyadmin.Others;

/**
 * Created by Stan on 4/10/2018.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DatabaseHelper extends SQLiteOpenHelper {

    // Logcat tag
    private static final String LOG = DatabaseHelper.class.getName();

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "OrderEasy";

    // Table Names
    private static final String TABLE_FOOD_ITEMS = "fooditem";
    private static final String TABLE_WAITER="waiter";
    private static final String TABLE_BILL="bill";

    // Common column names
    private static final String KEY_FOOD_ID="food_id";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_CATEGORY = "category";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_PRICE = "price";
    private static final String KEY_QUANTITY_TYPE = "quantity_type";
    private static final String KEY_IMAGE = "image";
    private static final String KEY_QTY = "quantity";
    private static final String KEY_CONTACT_NO="contact_no";
    private static final String KEY_TABLE_NO="table_no";
    private static final String KEY_WAITER_ID="waiter_id";
    private static final String KEY_RATING="rating";

    // Table Create Statements

    private static final String CREATE_TABLE_FOOD_ITEMS = "CREATE TABLE "
            + TABLE_FOOD_ITEMS + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            +KEY_NAME+" varchar(100), "+ KEY_CATEGORY +" INTEGER, "
            + KEY_DESCRIPTION+" varchar(255), " +KEY_PRICE+" float, "
            +KEY_QUANTITY_TYPE +" int, "+ KEY_IMAGE+" varchar(100), "
            +KEY_QTY+" varchar(50), "+KEY_FOOD_ID + " INTEGER, "+KEY_RATING+" FLOAT(1,1))";
    private static final String CREATE_TABLE_BILL = "CREATE TABLE "
            + TABLE_BILL + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            +KEY_NAME+" varchar(100), "+ KEY_CATEGORY +" INTEGER, "
            + KEY_DESCRIPTION+" varchar(255), " +KEY_PRICE+" float, "
            +KEY_QUANTITY_TYPE +" int, "+ KEY_IMAGE+" varchar(100), "
            +KEY_QTY+" varchar(50), "+KEY_FOOD_ID + " INTEGER, "+KEY_RATING+" FLOAT(1,1))";
    private static final String CREATE_TABLE_WAITER = "CREATE TABLE " + TABLE_WAITER
            +"("+KEY_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
            +KEY_NAME + " varchar(100), "+ KEY_CONTACT_NO+" varchar(13), "
            +KEY_TABLE_NO+ " varchar(100), "+ KEY_WAITER_ID+ " INTEGER)" ;
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e("LOL","LOL");
        // creating required tables
        db.execSQL(CREATE_TABLE_FOOD_ITEMS);
        db.execSQL(CREATE_TABLE_WAITER);
        db.execSQL(CREATE_TABLE_BILL);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_FOOD_ITEMS);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_WAITER);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_BILL);
        // create new tables
        onCreate(db);
    }




}