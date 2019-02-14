package com.example.fragmentprova;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

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

    void addVestito(String colore, int disponibile, String tessuto, int tipoVestito_ID, String pic_tag){
        open();

        ContentValues values = new ContentValues();
        values.put("COLORE", colore);
        values.put("DISPONIBILE", disponibile);
        values.put("TESSUTO", tessuto);
        values.put("TIPOVESTITO_ID", tipoVestito_ID);
        values.put("PIC_TAG", pic_tag);

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

    void addTipoOutfit(int id, String nome, int[] tipoOutfitPrincipale_ID, int[] tipiVestito){
        open();

        ContentValues values = new ContentValues();
        values.put("NOME", nome);

        database.insert(DBHelper.TABLE_TIPOOUTFIT, null, values);

        ContentValues values2 = new ContentValues();
        ContentValues values3 = new ContentValues();
        if(tipoOutfitPrincipale_ID!=null) {
            for (int i : tipoOutfitPrincipale_ID) {
                values2.put("tipoOutfitPrincipale_ID", i);
                values2.put("tipiOutfit_ID", id);
            }
            database.insert(DBHelper.TABLE_TIPOOUTFIT_TIPOOUTFIT, null, values2);
        }

        if(tipiVestito!=null){
            for(int i : tipiVestito){
                values3.put("tipiOutfit_ID", id);
                values3.put("tipiVestito_ID", i);
            }
            database.insert(DBHelper.TABLE_TIPOVESTITO_TIPOOUTFIT, null, values3);
        }

        close();

    }

    void addTipoVestito(int id, String nome){
        open();

        ContentValues values = new ContentValues();
        values.put("ID", id);
        values.put("NOME", nome);

        database.insert(DBHelper.TABLE_TIPOVESTITO, null, values);

        close();
    }

    ArrayList<String> getVestiti(String outfit){
        open();
        Cursor cursor = database.query(DBHelper.TABLE_OUTFIT, new String[]{"ID"}, "NOME" + "=?",
                new String[]{outfit},null,null,null,null);
        if(cursor!=null)
            cursor.moveToFirst();
        int id_out = Integer.parseInt(cursor.getString(0));

        Cursor cursor2 = database.query(DBHelper.TABLE_OUTFIT, new String[]{"TIPOOUTFIT_ID"}, "OUTFITPRINCIPALE_ID" + "=?",
                new String[]{String.valueOf(id_out)},null,null,null,null);
        if(cursor2!=null)
            cursor2.moveToFirst();
        int id_tipoOutfit = Integer.parseInt(cursor2.getString(0));

        String selectQuery = "SELECT  * FROM " + DBHelper.TABLE_TIPOOUTFIT_TIPOOUTFIT + " WHERE tipoOutfitPrincipale_ID = ?";
        Cursor cursor3 = database.rawQuery(selectQuery, new String[]{String.valueOf(id_tipoOutfit)});

        ArrayList<String> tipiOutfit_id = new ArrayList<String>();
        if(cursor3.moveToFirst()) {
            do {
                tipiOutfit_id.add(cursor3.getString(1));
            } while (cursor3.moveToNext());
        }

        close();
        return tipiOutfit_id;
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

        Cursor cursor = database.query(DBHelper.TABLE_CONTACTS, new String[]{DBHelper.KEY_PASSWORD}, DBHelper.KEY_EMAIL + "=?",
                new String[]{email},null,null,null,null);
        if(cursor!=null) {
            cursor.moveToFirst();
            String pw = cursor.getString(0);
            return pw;
        }
        return null;
    }
}
