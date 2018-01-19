package com.example.pbego.giveeat;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * Created by pbego on 18/01/2018.
 */

public class AnnonceRepo {

    private DBHandler dbHandler;

    public AnnonceRepo(Context context){
        dbHandler =new DBHandler(context);
    }

    public long insertAnnonce(Annonce annonce){

        //Open connection to write data
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Annonce.KEY_ID_UTILISATEUR, annonce.id_utilisateur);
        values.put(Annonce.KEY_LOCALISATION, annonce.localisation);
        values.put(Annonce.KEY_TEXT_ANNONCE, annonce.text_annonce);
        values.put(Annonce.KEY_STATUT, annonce.statut);

        //Inserting row
        long annonce_Id=db.insert(Annonce.TABLE, null, values);
        db.close();
        return annonce_Id;
    }

    public void delete(long annonce_Id)
    {
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        db.delete(Annonce.TABLE, Annonce.KEY_ID_ANNONCE + "= ?", new String[] { String.valueOf(annonce_Id) });
        db.close(); // Closing database connection
    }

    public void updateAnnonce(Annonce annonce){

        //Open connection to write data
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Annonce.KEY_ID_UTILISATEUR, annonce.id_utilisateur);
        values.put(Annonce.KEY_LOCALISATION, annonce.localisation);
        values.put(Annonce.KEY_TEXT_ANNONCE, annonce.text_annonce);
        values.put(Annonce.KEY_STATUT, annonce.statut);

        //Inserting row
        // It's a good practice to use parameter ?, instead of concatenate string
        db.update(Annonce.TABLE, values, Annonce.KEY_ID_ANNONCE + "= ?", new String[] { String.valueOf(annonce.id_annonce) });
        db.close(); // Closing database connection
    }

    public ArrayList<HashMap<String, String>>  getAnnonceList() {
        //Open connection to read only
        SQLiteDatabase db = dbHandler.getReadableDatabase();
        String selectQuery =  "SELECT " +
                Annonce.KEY_ID_ANNONCE + "," +
                Annonce.KEY_ID_UTILISATEUR + "," +
                Annonce.KEY_LOCALISATION + "," +
                Annonce.KEY_TEXT_ANNONCE + "," +
                Annonce.KEY_STATUT +
                " FROM " + Annonce.TABLE;

        ArrayList<HashMap<String, String>> annonceList = new ArrayList<HashMap<String, String>>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> annonce = new HashMap<String, String>();
                annonce.put("id_annonce", cursor.getString(cursor.getColumnIndex(Annonce.KEY_ID_ANNONCE)));
                annonce.put("id_utilisateur", cursor.getString(cursor.getColumnIndex(Annonce.KEY_ID_UTILISATEUR)));
                annonce.put("localisation", cursor.getString(cursor.getColumnIndex(Annonce.KEY_LOCALISATION)));
                annonce.put("texte_annonce", cursor.getString(cursor.getColumnIndex(Annonce.KEY_TEXT_ANNONCE)));
                annonce.put("statut", cursor.getString(cursor.getColumnIndex(Annonce.KEY_STATUT)));
                annonceList.add(annonce);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        System.out.println("annonceList : " + annonceList);
        return annonceList;
    }

    public ArrayList<HashMap<String, String>>  getAnnonceListByUser(long user_ID) {
        //Open connection to read only
        SQLiteDatabase db = dbHandler.getReadableDatabase();
        String selectQuery =  "SELECT " +
                Annonce.KEY_ID_ANNONCE + "," +
                Annonce.KEY_ID_UTILISATEUR + "," +
                Annonce.KEY_LOCALISATION + "," +
                Annonce.KEY_TEXT_ANNONCE + "," +
                Annonce.KEY_STATUT +
                " FROM " + Annonce.TABLE + " WHERE " + Annonce.KEY_ID_UTILISATEUR + " =?";

        ArrayList<HashMap<String, String>> annonceList = new ArrayList<HashMap<String, String>>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> annonce = new HashMap<String, String>();
                annonce.put("id_annonce", cursor.getString(cursor.getColumnIndex(Annonce.KEY_ID_ANNONCE)));
                annonce.put("id_utilisateur", cursor.getString(cursor.getColumnIndex(Annonce.KEY_ID_UTILISATEUR)));
                annonce.put("localisation", cursor.getString(cursor.getColumnIndex(Annonce.KEY_LOCALISATION)));
                annonce.put("texte_annonce", cursor.getString(cursor.getColumnIndex(Annonce.KEY_TEXT_ANNONCE)));
                annonce.put("statut", cursor.getString(cursor.getColumnIndex(Annonce.KEY_STATUT)));
                annonceList.add(annonce);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        System.out.println("annonceList : " + annonceList);
        return annonceList;
    }
}
