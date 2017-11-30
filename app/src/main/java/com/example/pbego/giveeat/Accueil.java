package com.example.pbego.giveeat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Accueil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        final TextView NomPage = (TextView) findViewById(R.id.nompage);
        NomPage.setText("Accueil");
    }
}
