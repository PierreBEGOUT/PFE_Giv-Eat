package com.example.pbego.giveeat;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;

import java.util.HashMap;

public class Accueil extends AppCompatActivity implements OnClickListener {

    // Session Manager Class
    SessionManagement session;
    HashMap<String,String> user;
    private ImageButton profil= null;
    TextView test1, test2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        final TextView NomPage = (TextView) findViewById(R.id.nompage);
        NomPage.setText("Annonces");

        profil = findViewById(R.id.profil2);
        profil.setOnClickListener(this);

        session = new SessionManagement(getApplicationContext());

        session.checkLogin();

        // get user data from session
        user = session.getUserDetails();

        // name
        String name = user.get(SessionManagement.KEY_NOM);

        // id
        String id = user.get(SessionManagement.KEY_ID);

    }







    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            //si on appuit sur le profil
            case R.id.profil2:
                Intent prof = new Intent(Accueil.this, Profil.class);
                startActivity(prof);
                break;
        }
    }


}
