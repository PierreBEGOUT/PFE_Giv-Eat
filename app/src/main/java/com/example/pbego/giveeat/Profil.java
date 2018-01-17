package com.example.pbego.giveeat;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

public class Profil extends AppCompatActivity {

    SessionManagement session;
    HashMap<String,String> user;
    Utilisateur User;


    TextView nomprof, prenomprof;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        final ImageView ProfilColor = (ImageView) findViewById(R.id.profil_color2);
        ProfilColor.setVisibility(View.VISIBLE);

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
        prenomprof=findViewById(R.id.prenomProf);
        prenomprof.setText(User.prenom);

    }

}
