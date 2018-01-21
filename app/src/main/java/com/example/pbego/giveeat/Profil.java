package com.example.pbego.giveeat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;

import java.util.HashMap;

public class Profil extends AppCompatActivity implements View.OnClickListener {

    SessionManagement session;
    HashMap<String,String> user;
    Utilisateur User;

    private Button mes_annonces, gerer_annonces = null;
    TextView nomprof, prenomprof;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        final ImageView ProfilColor = (ImageView) findViewById(R.id.profil_color2);
        ProfilColor.setVisibility(View.VISIBLE);

        mes_annonces = findViewById(R.id.mes_annonces);
        mes_annonces.setOnClickListener(this);

        gerer_annonces = findViewById(R.id.button2);
        gerer_annonces.setOnClickListener(this);

        Context context = getApplicationContext();
        UtilisateurRepo repo = new UtilisateurRepo(context);

        session = new SessionManagement(getApplicationContext());
        session.checkLogin();
        User=new Utilisateur();

        user = session.getUserDetails();
        String id = user.get(SessionManagement.KEY_ID);

        User = repo.getUserById(Long.parseLong(id));

        nomprof=findViewById(R.id.nomProf);
        nomprof.setText(User.nom);
        nomprof.setTextSize(18);
        prenomprof=findViewById(R.id.prenomProf);
        prenomprof.setText(User.prenom);
        prenomprof.setTextSize(18);

        if(User.ville == null){
            TextView adress = findViewById(R.id.adress);
            adress.setText("Pas d'adresse");
            adress = findViewById(R.id.code_postal);
            adress.setText("");
            adress = findViewById(R.id.ville);
            adress.setText("");
        }

    }

    @Override
    public void onClick(View v){
        switch(v.getId())
        {
            //si on appuit sur le profil
            case R.id.mes_annonces:

                break;
            case R.id.button2:

                break;
        }
    }

}
