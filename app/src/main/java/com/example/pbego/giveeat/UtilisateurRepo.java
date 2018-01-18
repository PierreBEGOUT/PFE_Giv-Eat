package com.example.pbego.giveeat;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * Created by pbego on 17/01/2018.
 */

public class UtilisateurRepo {

    private DBHandler dbHandler;

    public UtilisateurRepo(Context context){
        dbHandler =new DBHandler(context);
    }

    public long insertSansAdresse(Utilisateur User){

        //Open connection to write data
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Utilisateur.KEY_NOM, User.nom);
        values.put(Utilisateur.KEY_PRENOM, User.prenom);
        values.put(Utilisateur.KEY_EMAIL, User.email);
        values.put(Utilisateur.KEY_MDP, User.mdp);

        //Inserting row
        long user_Id=db.insert(Utilisateur.TABLE, null, values);
        db.close();
        return user_Id;
    }

    public long insertAvecAdresse(Utilisateur User){

        //Open connection to write data
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Utilisateur.KEY_NOM, User.nom);
        values.put(Utilisateur.KEY_PRENOM, User.prenom);
        values.put(Utilisateur.KEY_EMAIL, User.email);
        values.put(Utilisateur.KEY_MDP, User.mdp);
        values.put(Utilisateur.KEY_VILLE, User.ville);
        values.put(Utilisateur.KEY_CODE_POSTAL, User.code_post);
        values.put(Utilisateur.KEY_ADRESS_RUE, User.rue);

        //Inserting row
        long user_Id=db.insert(User.TABLE, null, values);
        db.close();
        return user_Id;
    }

    public void delete(long user_Id)
    {
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        db.delete(Utilisateur.TABLE, Utilisateur.KEY_ID + "= ?", new String[] { String.valueOf(user_Id) });
        db.close(); // Closing database connection
    }

    public void update(Utilisateur user)
    {
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Utilisateur.KEY_ID, user.id);
        values.put(Utilisateur.KEY_NOM, user.nom);
        values.put(Utilisateur.KEY_PRENOM, user.prenom);
        values.put(Utilisateur.KEY_EMAIL, user.email);
        values.put(Utilisateur.KEY_MDP, user.mdp);
        values.put(Utilisateur.KEY_VILLE, user.ville);
        values.put(Utilisateur.KEY_CODE_POSTAL, user.code_post);
        values.put(Utilisateur.KEY_ADRESS_RUE, user.rue);

        // It's a good practice to use parameter ?, instead of concatenate string
        db.update(Utilisateur.TABLE, values, Utilisateur.KEY_ID + "= ?", new String[] { String.valueOf(user.id) });
        db.close(); // Closing database connection
    }

    public Utilisateur getUserById(long Id){
        SQLiteDatabase db = dbHandler.getReadableDatabase();
        String selectQuery =  "SELECT " +
                Utilisateur.KEY_ID + "," +
                Utilisateur.KEY_NOM + "," +
                Utilisateur.KEY_PRENOM + "," +
                Utilisateur.KEY_EMAIL +
                " FROM " + Utilisateur.TABLE
                + " WHERE " +
                Utilisateur.KEY_ID + "=?";// It's a good practice to use parameter ?, instead of concatenate string

        Utilisateur user = new Utilisateur();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );

        if (cursor.moveToFirst()) {
            do {
                user.id =cursor.getInt(cursor.getColumnIndex(Utilisateur.KEY_ID));
                user.nom =cursor.getString(cursor.getColumnIndex(Utilisateur.KEY_NOM));
                user.prenom =cursor.getString(cursor.getColumnIndex(Utilisateur.KEY_PRENOM));
                user.email =cursor.getString(cursor.getColumnIndex(Utilisateur.KEY_EMAIL));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return user;
    }

    public Utilisateur getUserByMail(String email, String mdp){
        SQLiteDatabase db = dbHandler.getReadableDatabase();
        String selectQuery =  "SELECT " +
                Utilisateur.KEY_ID + "," +
                Utilisateur.KEY_NOM + "," +
                Utilisateur.KEY_PRENOM + "," +
                Utilisateur.KEY_EMAIL  +
                " FROM " + Utilisateur.TABLE
                + " WHERE " +
                Utilisateur.KEY_EMAIL + "=? AND "+ Utilisateur.KEY_MDP +"=?";// It's a good practice to use parameter ?, instead of concatenate string

        Utilisateur user = new Utilisateur();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(email), String.valueOf(mdp) } );

        if (cursor.moveToFirst()) {
            do {
                user.id =cursor.getInt(cursor.getColumnIndex(Utilisateur.KEY_ID));
                user.nom =cursor.getString(cursor.getColumnIndex(Utilisateur.KEY_NOM));
                user.prenom =cursor.getString(cursor.getColumnIndex(Utilisateur.KEY_PRENOM));
                user.email =cursor.getString(cursor.getColumnIndex(Utilisateur.KEY_EMAIL));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        System.out.println("Succès");
        return user;
    }

}
