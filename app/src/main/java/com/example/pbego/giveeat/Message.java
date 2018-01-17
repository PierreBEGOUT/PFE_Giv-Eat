package com.example.pbego.giveeat;
import android.content.Context;
/**
 * Created by pbego on 15/01/2018.
 */

public class Message {
    //Labels table name
    public static final String TABLE = "Message";

    //Labels columns names
    public static final String KEY_ID_MESSAGE = "id_message";
    public static final String KEY_ID_CONVERSATION= "id_conversation";
    public static final String KEY_ID_UTILISATEUR = "id_utilisateur";
    public static final String KEY_DATE_HEURE = "date_heure";
    public static final String KEY_MESSAGE = "message";

    public long id_message;
    public long id_conversation;
    public long id_utilisateur;
    public String date_heure;
    public String message;

    public Message( long id_conv, long id_ut, String date, String mess) {
        this.id_conversation=id_conv;
        this.id_utilisateur = id_ut;
        this.date_heure=date;
        this.message=mess;
    }

    public long getId_message(){return id_message;}
    public long getId_conversation(){return id_conversation;}
    public long getIdUtilisateur(){return id_utilisateur;}
    public String getDate_heure(){return date_heure;}
    public String getMessage(){return message;}
}

