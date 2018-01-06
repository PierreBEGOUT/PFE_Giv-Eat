package com.example.pbego.giveeat;
import android.content.Context;
/**
 * Created by pbego on 06/01/2018.
 */

public class Categorie {
    //Labels table name
    public static final String TABLE = "Categorie";

    //Labels columns names
    public static final String KEY_ID_CATEGORIE = "id_categorie";
    public static final String KEY_TEXTE_CATEGORIE = "texte_categorie";
    public static final String KEY_COMMENTAIRE = "commentaire";

    public long id_categorie;
    public String texte_categorie;
    public String commentaire;

    public Categorie(long id_cat, String texte, String com){
        this.id_categorie=id_cat;
        this.texte_categorie=texte;
        this.commentaire=com;
    }

    public long getId_categorie(){return id_categorie;}
    public String getTexte_categorie(){return texte_categorie;}
    public String getCommentaire(){return commentaire;}
}
