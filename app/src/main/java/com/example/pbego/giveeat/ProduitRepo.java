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

public class ProduitRepo {

    private DBHandler dbHandler;

    public ProduitRepo(Context context){
        dbHandler =new DBHandler(context);
    }

    public long insertProduit(Produit prod){

        //Open connection to write data
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Produit.KEY_ID_ANNONCE, prod.id_annonce);
        values.put(Produit.KEY_NOM_PRODUIT, prod.nom_produit);
        values.put(Produit.KEY_QUANTITE, prod.quantite);


        //Inserting row
        long prod_Id=db.insert(Produit.TABLE, null, values);
        db.close();
        return prod_Id;
    }

    public void delete(long prod_Id)
    {
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        db.delete(Produit.TABLE, Produit.KEY_ID_PRODUIT + "= ?", new String[] { String.valueOf(prod_Id) });
        db.close(); // Closing database connection
    }

    public void updateProduit(Produit produit){

        //Open connection to write data
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Produit.KEY_ID_ANNONCE, produit.id_annonce);
        values.put(Produit.KEY_ID_PRODUIT, produit.id_produit);
        values.put(Produit.KEY_NOM_PRODUIT, produit.nom_produit);
        values.put(Produit.KEY_QUANTITE, produit.quantite);

        //Inserting row
        // It's a good practice to use parameter ?, instead of concatenate string
        db.update(Produit.TABLE, values, Produit.KEY_ID_PRODUIT + "= ?", new String[] { String.valueOf(produit.id_produit) });
        db.close(); // Closing database connection
    }

    public ArrayList<HashMap<String, String>>  getProduitListByAnnonce(long annonce_ID) {
        //Open connection to read only
        SQLiteDatabase db = dbHandler.getReadableDatabase();
        String selectQuery =  "SELECT " +
                Produit.KEY_ID_ANNONCE + "," +
                Produit.KEY_ID_PRODUIT + "," +
                Produit.KEY_NOM_PRODUIT + "," +
                Produit.KEY_QUANTITE +
                " FROM " + Produit.TABLE + " WHERE " + Produit.KEY_ID_ANNONCE + " =?";

        ArrayList<HashMap<String, String>> produitList = new ArrayList<HashMap<String, String>>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> produit = new HashMap<String, String>();
                produit.put("id_annonce", cursor.getString(cursor.getColumnIndex(Produit.KEY_ID_ANNONCE)));
                produit.put("id_produit", cursor.getString(cursor.getColumnIndex(Produit.KEY_ID_PRODUIT)));
                produit.put("nom_produit", cursor.getString(cursor.getColumnIndex(Produit.KEY_NOM_PRODUIT)));
                produit.put("quantite", cursor.getString(cursor.getColumnIndex(Produit.KEY_QUANTITE)));
                produitList.add(produit);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        System.out.println("UserList : " + produitList);
        return produitList;
    }


}
