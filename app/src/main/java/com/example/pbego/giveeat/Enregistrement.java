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
    String nom, prenom, mdp1, email= "";

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

        text = findViewById(R.id.nom);
        nom = text.getText().toString();
        text = findViewById(R.id.prenom);
        prenom = text.getText().toString();
        text = findViewById(R.id.email);
        email = text.getText().toString();
        text = findViewById(R.id.mdp1);
        mdp1 = text.getText().toString();

        Utilisateur newUser = new Utilisateur(nom, prenom, email, mdp1 );
        Context context = getApplicationContext();
        UtilisateurRepo repo = new UtilisateurRepo(context);
        long Id = repo.insertSansAdresse(newUser);
        System.out.println("Gros Connard");
        System.out.println(Id);
        Intent accueil = new Intent(Enregistrement.this, Accueil.class);
        startActivity(accueil);
    }
}

