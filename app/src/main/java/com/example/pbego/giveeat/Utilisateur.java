package com.example.pbego.giveeat;
import android.content.Context;
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

    public long id;
    public String nom;
    public String prenom;
    public String email;
    public String mdp;


    public Utilisateur(String id, String nom, String prenom, String email, String mdp){
        this.id = Long.parseLong(id);
        this.nom=nom;
        this.prenom=prenom;
        this.email=email;
        this.mdp=mdp;
    }

    public Utilisateur(long id, String nom, String prenom, String email, String mdp) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
    }

    public long getId(){return id;}
    public String getNom(){return nom;}
    public String getPrenom(){return prenom;}
    public String getEmail(){return email;}
    public String getMdp(){return mdp;}
}
