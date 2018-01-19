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

public class CategorieRepo {

    private DBHandler dbHandler;
    public CategorieRepo(Context context){
        dbHandler =new DBHandler(context);
    }

    public long insertCategorie(Categorie cat){

        //Open connection to write data
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Categorie.KEY_ID_CATEGORIE, cat.id_categorie);
        values.put(Categorie.KEY_ID_CATEGORIE, cat.texte_categorie);

        long cat_Id=db.insert(Annonce_Categorie.TABLE, null, values);
        db.close();
        return cat_Id;
    }

    public void delete(long cat_Id)
    {
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        db.delete(Categorie.TABLE, Categorie.KEY_ID_CATEGORIE + "= ?", new String[] { String.valueOf(cat_Id) });
        db.close(); // Closing database connection
    }
}
