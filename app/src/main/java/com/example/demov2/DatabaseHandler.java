package com.example.demov2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "firstaid";
    private static final String TABLE_CONTACTS = "injurydetails";
    private static final String KEY_ID = "d_id";
    private static final String KEY_BODY_PART = "body_part";
    private static final String KEY_SB_PART = "sb_part";
    private static final String KEY_INJURY = "injury";
    private static final String KEY_CONTENT = "content";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_BODY_PART + " TEXT,"
                + KEY_SB_PART + " TEXT,"+ KEY_INJURY + " TEXT,"+ KEY_CONTENT + " TEXT," +
                "IMAGE" + " BLOB" + ");";
        db.execSQL(CREATE_CONTACTS_TABLE);

        Log.v("DS>>","i am here 2");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        // Create tables again
        onCreate(db);
    }

    // code to add the new contact
    void addInjury(InjuryModel injuryModel) {
        //Log.v("DS>>","ds "+injuryModel.getBody_part());
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_BODY_PART, injuryModel.getBody_part()); // Contact Name
        values.put(KEY_SB_PART, injuryModel.getSb_part()); // Contact Phone
        values.put(KEY_INJURY, injuryModel.getInjury()); // Contact Phone
        values.put(KEY_CONTENT, injuryModel.getContent()); // Contact Phone
        values.put("IMAGE", injuryModel.getImage());

        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    // code to get the single contact
    InjuryModel getInjury(int id) {
        Log.v("DS>>","id "+id);
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new String[]{KEY_ID,
                        KEY_BODY_PART, KEY_SB_PART, KEY_INJURY,KEY_CONTENT}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        InjuryModel injuryModel = new InjuryModel(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2),
                cursor.getString(3), cursor.getString(4));
        // return contact
        return injuryModel;
    }

    // code to get the single contact
    public List<InjuryModel> getInjurybyName(String bodypart) {
        List<InjuryModel> injuryModelList = new ArrayList<InjuryModel>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS + "WHERE" + KEY_BODY_PART +" = "+ bodypart;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                InjuryModel injury = new InjuryModel();
                injury.set_id(Integer.parseInt(cursor.getString(0)));
                injury.setBody_part(cursor.getString(1));
                injury.setSb_part(cursor.getString(2));
                injury.setInjury(cursor.getString(3));
                injury.setContent(cursor.getString(4));
                Log.v("DS","444"+cursor.getInt(5));
                injury.setImage(cursor.getInt(5));
                // Adding contact to list
                injuryModelList.add(injury);
            } while (cursor.moveToNext());
        }

        // return contact list
        return injuryModelList;
    }

    // code to get all contacts in a list view
    public List<InjuryModel> getAllInjuries() {
        List<InjuryModel> injuryModelList = new ArrayList<InjuryModel>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                InjuryModel injury = new InjuryModel();
                injury.set_id(Integer.parseInt(cursor.getString(0)));
                injury.setBody_part(cursor.getString(1));
                injury.setSb_part(cursor.getString(2));
                injury.setInjury(cursor.getString(3));
                injury.setContent(cursor.getString(4));
                //Log.v("DS","444"+cursor.getBlob(5));
                injury.setImage(cursor.getInt(5));
                // Adding contact to list
                injuryModelList.add(injury);
            } while (cursor.moveToNext());
        }

        // return contact list
        return injuryModelList;
    }

    // Getting contacts Count
    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }
}
