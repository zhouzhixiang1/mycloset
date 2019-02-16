package com.example.fragmentprova.utility;
import java.util.ArrayList;

public class AbbinaColori {

    private ArrayList<String> colori;
    private String nome;
    private String[] coloriCaldi = {"rosso","arancione","giallo", "rosso", "magenta", "magenta", "rosa", "marrone", "jeans", "grigio"};
    private String[] coloriFreddi = {"verde chiaro", "verde", "blu", "azzurro", "jeans", "viola", "fucsia", "grigio"};
    private String[] primari = {"giallo", "blu", "rosso"};
    private boolean eccentric;

    //il parametro nome si riferisce al nome di tipo di outfit
    public AbbinaColori(ArrayList<String> colori, String nome) {
        this.colori = colori;
        this.nome = nome;
    }

    public AbbinaColori() {
        this.eccentric=false;
    }

    public AbbinaColori(String ecc) {
        if(ecc.equals("eccentric"))
            this.eccentric = true;
    }

    //se l'outfit è di tipo "sopra" (es: camicia e jeans) non potranno essere abbinati due vestiti di colori uguali
    public boolean combina() {
        if(colori.size() == 1)
            return true;
        else if(abbina(colori.get(0),(colori.get(1)))==false && nome.equals("Sopra")) {
            return false;
        }

        else if(nome.equals("Intimo") && colori.get(colori.size()-2).equals(colori.get(colori.size()-1))==false) {
            return false;
        }
        return true;
    }

    public boolean abbina(String col1, String col2) {
        if(col1.equals(col2))
            return false;
        else if(eccentric) {
            if((col1.equals("rosso") && col2.equals("verde"))||((col1.equals("verde") && col2.equals("rosso"))) ||
                    (col1.equals("giallo") && col2.equals("viola"))||((col1.equals("viola") && col2.equals("giallo"))) ||
                    (col1.equals("blu") && col2.equals("arancione"))||((col1.equals("arancione") && col2.equals("blu")))) {
                return true;
            }
            return false;
        }
        else if((isCaldo(col1) && isCaldo(col2)) || (isFreddo(col2) && isFreddo(col1))) {
            return true;
        }
        else
            return false;
    }

    private boolean isCaldo(String col){
        for(String colr: this.coloriCaldi) {
            if (colr.equals(col))
                return true;
        }
        return false;
    }

    private boolean isFreddo(String col){
        for(String colr: this.coloriFreddi) {
            if (colr.equals(col))
                return true;
        }
        return false;
    }

    private boolean isPrimario(String col){
        for(String colr: this.primari) {
            if (colr.equals(col))
                return true;
        }
        return false;
    }



}