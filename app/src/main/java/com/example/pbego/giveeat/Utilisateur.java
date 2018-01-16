package com.example.pbego.giveeat;
import android.content.Context;
import android.media.Image;

/**
 * Created by pbego on 05/01/2018.
 */

public class Utilisateur {

    //Labels table name
    public static final String TABLE = "Utilisateur";

    //Labels columns names
    public static final String KEY_ID = "id";
    public static final String KEY_NOM = "nom";
    public static final String KEY_PRENOM = "prenom";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_MDP = "mdp";
    public static final String KEY_VILLE= "ville";
    public static final String KEY_CODE_POSTAL= "code_post";
    public static final String KEY_ADRESS_RUE ="rue";
    public static final String KEY_PHOTO = "photo";

    public long id;
    public String nom;
    public String prenom;
    public String email;
    public String mdp;
    public String ville;
    public long code_post;
    public String rue;
    public Image photo;

    public Utilisateur(long id, String nom, String prenom, String email, String mdp, String ville, long code, String rue, Image phot) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.ville = ville;
        this.code_post = code;
        this.rue= rue;
        this.photo=phot;
    }

    public long getId(){return id;}
    public String getNom(){return nom;}
    public String getPrenom(){return prenom;}
    public String getEmail(){return email;}
    public String getMdp(){return mdp;}
    public String getVille(){return ville;}
    public long getCode_post(){return code_post;}
    public String getRue(){return rue;}
    public Image getPhote(){return photo;}
}
