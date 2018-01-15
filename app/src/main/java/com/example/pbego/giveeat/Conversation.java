package com.example.pbego.giveeat;
import android.content.Context;
/**
 * Created by pbego on 15/01/2018.
 */

public class Conversation {
    //Labels table name
    public static final String TABLE = "Conversation";

    //Labels columns names
    public static final String KEY_ID_CONVERSATION = "id_conversation";
    public static final String KEY_ID_UTILISATEUR1= "id_utilisateur1";
    public static final String KEY_ID_UTILISATEUR2 = "id_utilisateur2";
    public static final String KEY_DATE_DEBUT = "date_debut";

    public long id_conversation;
    public long id_utilisateur1;
    public long id_utilisateur2;
    public String date_debut;

    public Conversation(long id, long id_ut1, long id_ut2, String date) {
        this.id_conversation=id;
        this.id_utilisateur1 = id_ut1;
        this.id_utilisateur2=id_ut2;
        this.date_debut=date;
    }

    public long getId_conversation(){return id_conversation;}
    public long getIdUtilisateur1(){return id_utilisateur1;}
    public long getIdUtilisateur2(){return id_utilisateur2;}
    public String getDate_debut(){return date_debut;}
}
