package com.example.pbego.giveeat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnTouchListener;
import android.view.View.OnClickListener;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private Button b = null;
    private Button a = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = findViewById(R.id.connexion);
        b.setOnClickListener(this);
        a=findViewById(R.id.creationCompte);
        a.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            //si on appuit sur le 1er
            case R.id.connexion:
                Intent connexion = new Intent(MainActivity.this, Connexion.class);
                startActivity(connexion);
                break;
            //si on appuit sur le 2e
            case R.id.creationCompte:
                Intent enregistrement = new Intent(MainActivity.this, Enregistrement.class);
                startActivity(enregistrement);
            break;

        }
    }


}

