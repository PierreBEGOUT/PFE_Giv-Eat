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
    private static final int DATABASE_VERSION = 1;
    // Database Name
    public static final String DATABASE_NAME = "GivEat.db";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_TABLE_UTILISATEUR = "CREATE TABLE " + Utilisateur.TABLE + "(" + Utilisateur.KEY_ID + " INTEGER PRIMARY KEY , "
                + Utilisateur.KEY_NOM + " TEXT, " + Utilisateur.KEY_PRENOM + " TEXT, " + Utilisateur.KEY_EMAIL + " TEXT, "
                + Utilisateur.KEY_EMAIL + "TEXT" +")";
        db.execSQL(CREATE_TABLE_UTILISATEUR);

        String CREATE_TABLE_ANNONCE = "CREATE TABLE " + Annonce.TABLE + "(" + Annonce.KEY_ID_ANNONCE + "INTEGER PRIMARY KEY ," +
                Annonce.KEY_ID_UTILISATEUR + "INTEGER ," + Annonce.KEY_LOCALISATION +"TEXT, " + Annonce.KEY_TEXT_ANNONCE + "TEXT, " +
                Annonce.KEY_STATUT + "TEXT" +")";
        db.execSQL(CREATE_TABLE_ANNONCE);

        String CREATE_TABLE_ANNONCE_CATEGORIE = "CREATE TABLE "+ Annonce_Categorie.TABLE + "(" + Annonce_Categorie.KEY_ID_ANNONCE + "INTEGER PRIMARY KEY ," +
                Annonce_Categorie.KEY_ID_CATEGORIE + "INTEGER" + ")";
        db.execSQL(CREATE_TABLE_ANNONCE_CATEGORIE);

        //Manque 4 tables, ça se fait vite

        //String CREATE_TABLE_CATEGORIE = "CREATE TABLE "+ Categorie.TABLE
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}
