package com.example.pbego.giveeat;
import android.content.Context;
/**
 * Created by pbego on 06/01/2018.
 */

public class Annonce {

    //Labels table name
    public static final String TABLE = "Annonce";

    //Labels columns names
    public static final String KEY_ID_ANNONCE = "id_annonce";
    public static final String KEY_ID_UTILISATEUR = "id_utilisateur";
    public static final String KEY_TEXT_ANNONCE = "text_annonce";
    public static final String KEY_LOCALISATION = "localisation";
    public static final String KEY_STATUT = "satut";

    public long id_annonce;
    public long id_utilisateur;
    public String text_annonce;
    public String localisation;
    public String statut;

    public Annonce( long id_ut, String texte, String local){
        this.id_utilisateur =id_ut;
        this.text_annonce=texte;
        this.localisation=local;
        this.statut= "Disponible";
    }

    public long getId_annonce(){return id_annonce;}
    public long getId_ut(){return id_utilisateur;}
    public String getTexte(){return text_annonce;}
    public String getlocalisation(){return localisation;}
    public String getStatut(){return statut;}
}
