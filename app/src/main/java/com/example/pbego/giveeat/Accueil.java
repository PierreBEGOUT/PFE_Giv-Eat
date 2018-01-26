package com.example.pbego.giveeat;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Accueil extends AppCompatActivity implements OnClickListener{

    // Session Manager Class
    SessionManagement session;
    HashMap<String, String> user, annonce;
    private ImageButton profil, add = null;
    ArrayList<LinkedHashMap<String, String>> annonces;
    ArrayList<HashMap<String,String>> annonceList, cat;
    private ListView maListView;
    Utilisateur newUser;
    UtilisateurRepo rep ;
    Annonce_CategorieRepo repp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        final TextView NomPage = (TextView) findViewById(R.id.nompage);
        NomPage.setText("Annonces");

        profil = findViewById(R.id.profil2);
        profil.setOnClickListener(this);

        add = findViewById(R.id.add2);
        add.setOnClickListener(this);

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
        annonces = annrep.getAnnonceListByUtDiff(Long.parseLong(id));
        rep = new UtilisateurRepo(getApplicationContext());

        annonceList = new ArrayList<HashMap<String, String>>();
        for(LinkedHashMap<String, String> a : annonces){

            annonce =  new HashMap<String, String>();
            annonce.put("id_ann", a.get("id_annonce"));
            annonce.put("id_ut", a.get("id_utilisateur"));
            annonce.put("texte", a.get("texte_annonce"));
            annonce.put("local", a.get("localisation"));
            annonce.put("img", String.valueOf(R.drawable.planet));
            newUser = rep.getUserById(Long.parseLong(a.get("id_utilisateur")));
            annonce.put("nom", newUser.prenom);

            cat = repp.getCategorieListByAnnonce(Long.parseLong(a.get("id_annonce")));
            for(HashMap<String, String> s : cat){
                if(s.get("id_categorie")=="7"){
                    String st = "Frais";
                    annonce.put("Frais", st);
                }
                if(s.get("id_categorie")=="8"){
                    String st = "Conserve";
                    annonce.put("Conserve", st);
                }
                if(s.get("id_categorie")=="9"){
                    String st = "Epicerie";
                    annonce.put("Epicerie", st);
                }
            }
            annonce.put("tags", "Tags : ");
            annonceList.add(annonce);
    }
        maListView = findViewById(R.id.listView);

        SimpleAdapter mSchedule = new SimpleAdapter(getApplicationContext(), annonceList, R.layout.annonce_liste,
               new String[]{"id_ann","texte","img", "local","nom", "Frais", "Conserve", "Epicerie", "tags"}, new int[]{R.id.numAnn,R.id.texteAnnonce,R.id.photo, R.id.localAnnonce,  R.id.nomUt, R.id.Frais
        , R.id.Conserve, R.id.Epicerie, R.id.Tags} );

        maListView.setAdapter(mSchedule);

        maListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3)
            {
                TextView id =  v.findViewById(R.id.numAnn);
                long id_ann=Long.parseLong(id.getText().toString());
                Intent detail = new Intent(Accueil.this, Annonce_Detail.class);
                detail.putExtra("id_annonce", id_ann);
                System.out.println(id_ann);
                startActivity(detail);
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //si on appuit sur le profil
            case R.id.profil2:
                Intent prof = new Intent(Accueil.this, Profil.class);
                startActivity(prof);
                break;
            case R.id.add2:
                Intent add = new Intent(Accueil.this, Add.class);
                startActivity(add);
                break;
        }
    }

}



