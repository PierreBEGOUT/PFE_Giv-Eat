package com.example.pbego.giveeat;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.HashMap;

public class Add extends AppCompatActivity implements View.OnClickListener{


    SessionManagement session;
    HashMap<String,String> user;

    public Button ajouter =null;
    MultiAutoCompleteTextView description = null;
    EditText date = null;
    String localisation , id="", descrip, dat;
    CheckBox choix1, choix2;
    Utilisateur User;
    Categorie Frais, Conserve, Epicerie;
    long cat_id, annonce_id;
    ToggleButton frais, conserve, epicerie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        final TextView NomPage = (TextView) findViewById(R.id.nompage);
        NomPage.setText("Ajouter une annonce");

        session = new SessionManagement(getApplicationContext());
        session.checkLogin();
        // get user data from session
        user = session.getUserDetails();

        ajouter =findViewById(R.id.add_butt);
        ajouter.setOnClickListener(this);

        id = user.get(SessionManagement.KEY_ID);
        Context context = getApplicationContext();
        UtilisateurRepo repo = new UtilisateurRepo(context);
        CategorieRepo catrepo = new CategorieRepo(context);

        Frais = new Categorie("Frais");
        Conserve = new Categorie("Conserve");
        Epicerie = new Categorie("Epicerie");

        cat_id = catrepo.insertCategorie(Frais);
        System.out.println(cat_id);
        cat_id = catrepo.insertCategorie(Conserve);
        System.out.println(cat_id);
        cat_id = catrepo.insertCategorie(Epicerie);
        System.out.println(cat_id);

        User = repo.getUserById(Long.parseLong(id));

        frais = findViewById(R.id.frais);
        conserve = findViewById(R.id.conserve);
        epicerie = findViewById(R.id.epicerie);
    }

    @Override
    public void onClick(View v){
        Context context = getApplicationContext();
        AnnonceRepo annonceRepo= new AnnonceRepo(context);
        Annonce_CategorieRepo ann_cat = new Annonce_CategorieRepo(context);

        description = findViewById(R.id.description_complete);
        descrip = description.getText().toString();
        date = findViewById(R.id.date);
        dat = date.getText().toString();
        choix1 = findViewById(R.id.choix_mess);
        choix2=findViewById(R.id.choix_rdv);

        if(choix1.isChecked()){
            localisation = "Lieux de rendez-vous à définir";
        }
        else if(choix2.isChecked())
        {
            localisation = User.rue + " " + User.code_post + " " + User.ville;
        }

        Annonce annonce = new Annonce(User.id, descrip, dat, localisation);
        annonce_id = annonceRepo.insertAnnonce(annonce);

        if(frais.isActivated()){
            Annonce_Categorie ann1 = new Annonce_Categorie(annonce_id, 1);
            long ancatid = ann_cat.insertAnnonce_Cat(ann1);
            System.out.println(ancatid);
        }
        if(conserve.isActivated()){
            Annonce_Categorie ann1 = new Annonce_Categorie(annonce_id, 2);
            long ancatid = ann_cat.insertAnnonce_Cat(ann1);
            System.out.println(ancatid);
        }
        if(epicerie.isActivated()){
            Annonce_Categorie ann1 = new Annonce_Categorie(annonce_id, 3);
            long ancatid = ann_cat.insertAnnonce_Cat(ann1);
            System.out.println(ancatid);
        }

        System.out.println(annonce_id);

        Intent connexion = new Intent(Add.this, Accueil.class);
        startActivity(connexion);
    }
}
