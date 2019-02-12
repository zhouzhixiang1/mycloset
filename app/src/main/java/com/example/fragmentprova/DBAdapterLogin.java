package com.example.fragmentprova;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBAdapterLogin {

    private Context context;
    private SQLiteDatabase database;
    private DBHelper dbHelper;

    public DBAdapterLogin(Context context) {
        this.context = context;
    }

    public DBAdapterLogin open() throws SQLException {
        dbHelper = new DBHelper(context);
        database = dbHelper.getWritableDatabase();

        return this;
    }

    public void close() {
        dbHelper.close();
        database.close();
    }

    void addEmail(String email){
        open();

        ContentValues values = new ContentValues();
        values.put(DBHelper.KEY_EMAIL, email);

        database.insert(DBHelper.TABLE_CONTACTS, null, values);

        close();
    }

    void addPassword(String password){
        open();

        ContentValues values = new ContentValues();
        values.put(DBHelper.KEY_PASSWORD, password);

        database.insert(DBHelper.TABLE_CONTACTS, null, values);

        close();
    }

    Boolean isEmailPresent(String email){
        open();

        Cursor cursor = database.query(DBHelper.TABLE_CONTACTS, new String[]{DBHelper.KEY_EMAIL}, DBHelper.KEY_EMAIL + "=?",
                new String[]{email},null,null,null,null);
        if(cursor!=null)
            cursor.moveToFirst();
        else return false;

        String email2 = cursor.getString(0);
        if(email.equals(email2))
            return true;
        else
            return false;
    }

    String getPassword(String email){
        open();

        Cursor cursor = database.query(DBHelper.TABLE_CONTACTS, new String[]{DBHelper.KEY_PASSWORD}, DBHelper.KEY_EMAIL + "=?",
                new String[]{email},null,null,null,null);
        if(cursor!=null)
            cursor.moveToFirst();

        String pw = cursor.getString(0);
        return pw;
    }
}
