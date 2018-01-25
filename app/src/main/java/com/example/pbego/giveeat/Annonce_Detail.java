package com.example.pbego.giveeat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;

public class Annonce_Detail extends AppCompatActivity {


    SessionManagement session;
    AnnonceRepo repo ;
    HashMap<String,String> annonce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        long id =getIntent().getIntExtra("id_annonce",0);

        final TextView NomPage = (TextView) findViewById(R.id.nompage);
        NomPage.setText("Détail de l'annonce");

        session = new SessionManagement(getApplicationContext());
        session.checkLogin();

        repo = new AnnonceRepo(getApplicationContext());
        annonce = repo.getAnnonceById(id);


    }
}
