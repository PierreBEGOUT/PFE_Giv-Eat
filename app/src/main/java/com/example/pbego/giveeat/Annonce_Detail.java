package com.example.pbego.giveeat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import java.util.HashMap;

public class Annonce_Detail extends AppCompatActivity {


    SessionManagement session;
    AnnonceRepo repo ;
    HashMap<String,String> annonce;

    TextView date, user, nom;
    MultiAutoCompleteTextView texteAnnonce, lieuxRdv;
    Utilisateur Util;
    UtilisateurRepo utilrep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        long id =this.getIntent().getLongExtra("id_annonce",0);
        System.out.println(id);

        final TextView NomPage = (TextView) findViewById(R.id.nompage);
        NomPage.setText("Détail de l'annonce");

        session = new SessionManagement(getApplicationContext());
        session.checkLogin();
        repo = new AnnonceRepo(getApplicationContext());
        annonce = repo.getAnnonceById(id);

        date =findViewById(R.id.DataRecup);
        user= findViewById(R.id.nomPrenom);
        nom= findViewById(R.id.User);
        texteAnnonce =findViewById(R.id.texteAnnonce3);
        lieuxRdv =findViewById(R.id.pRdv);

        date.setText(annonce.get("date"));
        texteAnnonce.setText(annonce.get("texte_annonce"));
        lieuxRdv.setText(annonce.get("localisation"));
        user.setText("Gros donneur");

        utilrep = new UtilisateurRepo(getApplicationContext());
        Util = utilrep.getUserById(Long.parseLong(annonce.get("id_utilisateur")));
        nom.setText(Util.prenom + " " + Util.nom);
    }
}
