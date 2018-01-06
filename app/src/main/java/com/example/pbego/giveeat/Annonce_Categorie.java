package com.example.pbego.giveeat;
import android.content.Context;
/**
 * Created by pbego on 06/01/2018.
 */

public class Annonce_Categorie {
    //Labels table name
    public static final String TABLE = "Annonce_Categorie";

    //Labels columns names
    public static final String KEY_ID_ANNONCE = "id_annonce";
    public static final String KEY_ID_CATEGORIE = "id_categorie";

    public long id_annonce;
    public long id_categorie;

    public Annonce_Categorie(long id_a, long id_c){
        this.id_annonce=id_a;
        this.id_categorie=id_c;
    }

    public long getId_annonce(){return id_annonce;}
    public long getId_categorie(){return id_categorie;}
