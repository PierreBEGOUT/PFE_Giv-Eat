package com.example.pbego.giveeat;
import android.content.Intent;
import android.widget.ImageButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;

public class Accueil extends AppCompatActivity implements OnClickListener {


    private ImageButton profil= null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        final TextView NomPage = (TextView) findViewById(R.id.nompage);
        NomPage.setText("Annonces");

        profil = findViewById(R.id.profil_photo);
        profil.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            //si on appuit sur le profil
            case R.id.profil_photo:
                Intent prof = new Intent(Accueil.this, Profil.class);
                startActivity(prof);
                break;


        }
    }


}
