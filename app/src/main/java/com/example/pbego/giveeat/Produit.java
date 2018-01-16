package com.example.pbego.giveeat;
import android.content.Context;
/**
 * Created by pbego on 06/01/2018.
 */

public class Produit {

    public static final String TABLE = "Produit";

    //Labels columns names
    public static final String KEY_ID_PRODUIT = "id_produit";
    public static final String KEY_ID_ANNONCE = "id_annonce";
    public static final String KEY_NOM_PRODUIT = "nom_produit";
    public static final String KEY_QUANTITE = "quantite";

    public long id_produit;
    public long id_annonce;
    public String nom_produit;
    public long quantite;

    public Produit(long id_prod, long id_annonce, String nom, long nb){
        this.id_produit=id_prod;
        this.id_annonce=id_annonce;
        this.nom_produit=nom;
        this.quantite=nb;
    }

    public long getId_produit(){return id_produit;}
    public long getId_annonce(){return id_annonce;}
    public String getNom_produit(){return nom_produit;}
    public long getQuantite(){return quantite;}
}
