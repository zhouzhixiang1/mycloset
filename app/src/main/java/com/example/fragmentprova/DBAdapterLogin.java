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

    void addDati(String email, String password){
        open();

        ContentValues values = new ContentValues();
        values.put(DBHelper.KEY_EMAIL, email);
        values.put(DBHelper.KEY_PASSWORD, password);

        database.insert(DBHelper.TABLE_CONTACTS, null, values);

        close();
    }

    void addVestito(String colore, int disponibile, String tessuto, int tipoVestito_ID){
        open();

        ContentValues values = new ContentValues();
        values.put("COLORE", colore);
        values.put("DISPONIBILE", disponibile);
        values.put("TESSUTO", tessuto);
        values.put("TIPOVESTITO_ID", tipoVestito_ID);

        database.insert(DBHelper.TABLE_VESTITI, null, values);

        close();
    }

    void addOutfit(int feriale, String nome, int temperatura, int temperaturaMassima, int outfitprincipale_id, int tipooutfit_id){
        open();

        ContentValues values = new ContentValues();
        values.put("FERIALE", feriale);
        values.put("NOME", nome);
        values.put("TEMPERATURA", temperatura);
        values.put("TEMPERATURAMASSIMA", temperaturaMassima);
        values.put("OUTFITPRINCIPALE_ID", outfitprincipale_id);
        values.put("TIPOOUTFIT_ID", tipooutfit_id);

        database.insert(DBHelper.TABLE_OUTFIT, null, values);

        close();
    }

    void addTipoOutfit(int id, String nome, int[] tipoOutfitPrincipale_ID){
        open();

        ContentValues values = new ContentValues();
        values.put("NOME", nome);

        ContentValues values2 = new ContentValues();
        for(int i: tipoOutfitPrincipale_ID){
            values2.put("tipoOutfitPrincipale_ID", i);
            values2.put("tipiOutfit_ID", id);
        }

        database.insert(DBHelper.TABLE_TIPOOUTFIT, null, values);
        database.insert(DBHelper.TABLE_TIPOOUTFIT_TIPOOUTFIT, null, values2);

        close();

    }

    Boolean isEmailPresent(String email){
        open();

        Cursor cursor = database.query(DBHelper.TABLE_CONTACTS, new String[]{DBHelper.KEY_EMAIL, DBHelper.KEY_PASSWORD}, DBHelper.KEY_EMAIL + "=?",
                new String[]{email},null,null,null,null);

        if(cursor.moveToFirst()) {
            String email2 = cursor.getString(0);
            if(email.equals(email2))
                return true;
            else
                return false;
        }
        else return false;
    }

    String getPassword(String email){
        open();

        Cursor cursor = database.query(DBHelper.TABLE_CONTACTS, new String[]{DBHelper.KEY_EMAIL, DBHelper.KEY_PASSWORD}, DBHelper.KEY_EMAIL + "=?",
                new String[]{email},null,null,null,null);
        if(cursor!=null) {
            cursor.moveToFirst();
            String pw = cursor.getString(1);
            return pw;
        }
        return null;
    }
}
