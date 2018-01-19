package com.example.pbego.giveeat;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * Created by pbego on 19/01/2018.
 */

public class Annonce_CategorieRepo {

    private DBHandler dbHandler;
    public Annonce_CategorieRepo(Context context){
        dbHandler =new DBHandler(context);
    }

    public long insertAnnonce_Cat(Annonce_Categorie ann_cat){

        //Open connection to write data
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Annonce_Categorie.KEY_ID_ANNONCE, ann_cat.id_annonce);
        values.put(Annonce_Categorie.KEY_ID_CATEGORIE, ann_cat.id_categorie);

        long annonce_cat_Id=db.insert(Annonce_Categorie.TABLE, null, values);
        db.close();
        return annonce_cat_Id;
    }

    public void delete(long annonce_cat_Id)
    {
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        db.delete(Annonce_Categorie.TABLE, Annonce_Categorie.KEY_ID_ANNONCE + "= ?", new String[] { String.valueOf(annonce_cat_Id) });
        db.close(); // Closing database connection
    }

    public void updateAnnonce_Categorie(Annonce_Categorie annonce_cat){

        //Open connection to write data
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Annonce_Categorie.KEY_ID_ANNONCE, annonce_cat.id_annonce);
        values.put(Annonce_Categorie.KEY_ID_CATEGORIE, annonce_cat.id_categorie);

        //Inserting row
        // It's a good practice to use parameter ?, instead of concatenate string
        db.update(Annonce_Categorie.TABLE, values, Annonce_Categorie.KEY_ID_ANNONCE + "= ?", new String[] { String.valueOf(annonce_cat.id_annonce) });
        db.close(); // Closing database connection
    }

    public ArrayList<HashMap<String, String>>  getCategorieListByAnnonce(long annonce_ID) {
        //Open connection to read only
        SQLiteDatabase db = dbHandler.getReadableDatabase();
        String selectQuery =  "SELECT " +
                Annonce_Categorie.KEY_ID_ANNONCE + "," +
                Annonce_Categorie.KEY_ID_CATEGORIE +
                " FROM " + Annonce_Categorie.TABLE + " WHERE " + Annonce_Categorie.KEY_ID_ANNONCE + " =?";

        ArrayList<HashMap<String, String>> catList = new ArrayList<HashMap<String, String>>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> annonce_cat = new HashMap<String, String>();
                annonce_cat.put("id_annonce", cursor.getString(cursor.getColumnIndex(Annonce_Categorie.KEY_ID_ANNONCE)));
                annonce_cat.put("id_categorie", cursor.getString(cursor.getColumnIndex(Annonce_Categorie.KEY_ID_CATEGORIE)));
                catList.add(annonce_cat);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        System.out.println("CatList : " + catList);
        return catList;
    }
}
