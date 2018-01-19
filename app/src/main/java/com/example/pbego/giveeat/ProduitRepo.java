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

    public long insertAnnonce(Produit prod){

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


}
