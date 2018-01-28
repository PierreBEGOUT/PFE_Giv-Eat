package com.example.pbego.giveeat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Mes_Annonces extends AppCompatActivity {

    SessionManagement session;
    HashMap<String, String> user, annonce;
    ArrayList<HashMap<String, String>> annonces, annonceList;
    UtilisateurRepo rep;
    AnnonceRepo annrep;
    Utilisateur newUser;
    ListView maListView;
    SimpleAdapter mSchedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mes__annonces);

        final TextView NomPage = (TextView) findViewById(R.id.nompage);
        NomPage.setText("Mes annonces");

        session = new SessionManagement(getApplicationContext());

        session.checkLogin();
        AnnonceRepo annrep = new AnnonceRepo(getApplicationContext());
        Annonce_CategorieRepo repp=new Annonce_CategorieRepo(getApplicationContext());


        // get user data from session
        user = session.getUserDetails();

        // name
        String name = user.get(SessionManagement.KEY_NOM);

        // id
        String id = user.get(SessionManagement.KEY_ID);

        //Gestion de l'affichage des annonces
        annonces = annrep.getAnnonceListByUser(Long.parseLong(id));
        rep = new UtilisateurRepo(getApplicationContext());

        annonceList = new ArrayList<HashMap<String, String>>();
        for(HashMap<String, String> a : annonces){

            annonce =  new HashMap<String, String>();
            annonce.put("id_ann", a.get("id_annonce"));
            annonce.put("id_ut", a.get("id_utilisateur"));
            annonce.put("texte", a.get("texte_annonce"));
            annonce.put("local", a.get("localisation"));
            annonce.put("img", String.valueOf(R.drawable.planet));
            newUser = rep.getUserById(Long.parseLong(a.get("id_utilisateur")));
            annonce.put("nom", newUser.prenom);

            annonce.put("tags", "Tags : ");
            annonceList.add(annonce);
        }
        maListView = findViewById(R.id.mesAnnonces);

        SimpleAdapter mSchedule = new SimpleAdapter(getApplicationContext(), annonceList, R.layout.annonce_liste,
                new String[]{"id_ann","texte","img", "local","nom", "Frais", "Conserve", "Epicerie", "tags"}, new int[]{R.id.numAnn,R.id.texteAnnonce,R.id.photo, R.id.localAnnonce,  R.id.nomUt, R.id.Frais
                , R.id.Conserve, R.id.Epicerie, R.id.Tags} );

        maListView.setAdapter(mSchedule);
    }
}
