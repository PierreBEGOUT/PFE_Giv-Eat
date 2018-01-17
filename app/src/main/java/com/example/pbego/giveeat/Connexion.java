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
import android.widget.TextView;

public class Connexion extends AppCompatActivity implements View.OnClickListener {

    private Button b = null;
    EditText text = null;
    String mdp, email= "";
    boolean isTrue =false;
    TextView test =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
        b = findViewById(R.id.connexion);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        text = findViewById(R.id.email);
        email = text.getText().toString();
        text = findViewById(R.id.mdp);
        mdp = text.getText().toString();

        Context context = getApplicationContext();
        UtilisateurRepo repo = new UtilisateurRepo(context);

        Utilisateur user = new Utilisateur();
        user = repo.getUserByMail(email,mdp);


        if(isTrue =true){
            Intent accueil = new Intent(Connexion.this, Accueil.class);
            startActivity(accueil);
        }
        else{
            test = findViewById(R.id.incorrect);
            test.setVisibility(View.VISIBLE);
        }

    }
}
