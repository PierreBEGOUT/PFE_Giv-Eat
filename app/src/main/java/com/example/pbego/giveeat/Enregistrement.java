package com.example.pbego.giveeat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Enregistrement extends AppCompatActivity implements View.OnClickListener {

    private Button b = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enregistrement);
        b = findViewById(R.id.suivant);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}

