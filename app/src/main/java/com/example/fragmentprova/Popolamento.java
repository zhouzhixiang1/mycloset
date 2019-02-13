package com.example.fragmentprova;

import android.content.Context;

public class Popolamento {

    private Context context;
    private DBAdapterLogin db;

    public Popolamento(Context context){
        this.context = context;
        this.db = new DBAdapterLogin(context);
        popolaOutfit();
        popolaTipoOutfit();
    }

    private void popolaOutfit(){
        db.addOutfit(0, "InvernaleFeriale", 0, 0, 0, 0);
        db.addOutfit(0, "invernale 1", 0, 5, 1, 3);
    }

    private void popolaTipoOutfit(){
        db.addTipoOutfit(1, "Completo", null);
    }
}
