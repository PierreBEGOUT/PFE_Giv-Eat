package com.example.pbego.giveeat;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by pbego on 05/01/2018.
 */

public class DBHandler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 2;
    // Database Name
    public static final String DATABASE_NAME = "GivEat.db";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_TABLE_UTILISATEUR = "CREATE TABLE " + Utilisateur.TABLE + "(" + Utilisateur.KEY_ID + " INTEGER PRIMARY KEY, "
                + Utilisateur.KEY_NOM + " TEXT, " + Utilisateur.KEY_PRENOM + " TEXT, " + Utilisateur.KEY_EMAIL + " TEXT, "
                + Utilisateur.KEY_MDP + " TEXT, "+ Utilisateur.KEY_VILLE + " TEXT, " +
                Utilisateur.KEY_CODE_POSTAL + " INTEGER, " + Utilisateur.KEY_ADRESS_RUE + " TEXT, " + Utilisateur.KEY_PHOTO + " BLOB" +")";
        db.execSQL(CREATE_TABLE_UTILISATEUR);

        String CREATE_TABLE_ANNONCE = "CREATE TABLE " + Annonce.TABLE + "(" + Annonce.KEY_ID_ANNONCE + " INTEGER PRIMARY KEY, " +
                Annonce.KEY_ID_UTILISATEUR + " INTEGER ," + Annonce.KEY_LOCALISATION +" TEXT, " + Annonce.KEY_TEXT_ANNONCE + " TEXT, " +
                Annonce.KEY_STATUT + " TEXT" +")";
        db.execSQL(CREATE_TABLE_ANNONCE);

        String CREATE_TABLE_ANNONCE_CATEGORIE = "CREATE TABLE "+ Annonce_Categorie.TABLE + "(" + Annonce_Categorie.KEY_ID_ANNONCE + " INTEGER PRIMARY KEY, " +
                Annonce_Categorie.KEY_ID_CATEGORIE + " INTEGER" + ")";
        db.execSQL(CREATE_TABLE_ANNONCE_CATEGORIE);

        String CREATE_TABLE_CATEGORIE = "CREATE TABLE "+ Categorie.TABLE + "(" + Categorie.KEY_ID_CATEGORIE + " INTEGER PRIMARY KEY ," +
                Categorie.KEY_TEXTE_CATEGORIE + " TEXT, " + Categorie.KEY_COMMENTAIRE + " TEXT" + ")";
        db.execSQL(CREATE_TABLE_CATEGORIE);

        String CREATE_TABLE_PRODUIT = "CREATE TABLE " + Produit.TABLE + "(" + Produit.KEY_ID_PRODUIT + " INTEGER PRIMARY KEY ," +
                Produit.KEY_ID_ANNONCE + "INTEGER, " + Produit.KEY_NOM_PRODUIT + "TEXT, " + Produit.KEY_QUANTITE + "INTEGER" + ")";
        db.execSQL(CREATE_TABLE_PRODUIT);

        String CREATE_TABLE_CONVERSATION = "CREATE TABLE " + Conversation.TABLE + "(" + Conversation.KEY_ID_CONVERSATION + " INTEGER PRIMARY KEY ," +
                Conversation.KEY_ID_UTILISATEUR1 + " INTEGER, " + Conversation.KEY_ID_UTILISATEUR2 + " INTEGER, " + Conversation.KEY_DATE_DEBUT + " TEXT" + ")";
        db.execSQL(CREATE_TABLE_CONVERSATION);

        String CREATE_TABLE_MESSAGE = "CREATE TABLE " + Message.TABLE + "(" + Message.KEY_ID_MESSAGE + " INTEGER PRIMARY KEY, " + Message.KEY_ID_CONVERSATION +
                " INTEGER, " + Message.KEY_ID_UTILISATEUR + " INTEGER, " + Message.KEY_DATE_HEURE + " TEXT, " + Message.KEY_MESSAGE + " TEXT" + ")";
        db.execSQL(CREATE_TABLE_MESSAGE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Utilisateur.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Annonce.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Annonce_Categorie.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Categorie.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Produit.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Conversation.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Message.TABLE);
        // Creating tables again
        onCreate(db);
    }


}
