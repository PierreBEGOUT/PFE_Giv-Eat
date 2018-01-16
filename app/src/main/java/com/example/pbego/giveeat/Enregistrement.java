package com.example.pbego.giveeat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Enregistrement extends AppCompatActivity implements View.OnClickListener {

    private Button b = null;
    EditText text = null;
    String nom, prenom, mdp, email= "";

    DBHandler dbHandler = new DBHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enregistrement);
        b = findViewById(R.id.suivant);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Globals g = (Globals)getApplication();
        long idUt = g.getIdUt();
        text = findViewById(R.id.nom);
        nom = text.toString();
        text = findViewById(R.id.prenom);
        prenom = text.toString();
        text = findViewById(R.id.email);
        email = text.toString();
        text = findViewById(R.id.mdp1);
        mdp = text.toString();

        g.setIdUt(idUt+1);
        Utilisateur newUser = new Utilisateur(idUt, nom, prenom, email, mdp );

       /*//Open connection to write data
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();*/

        Intent accueil = new Intent(Enregistrement.this, Accueil.class);
        startActivity(accueil);
    }
}

