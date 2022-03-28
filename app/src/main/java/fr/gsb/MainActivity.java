package fr.gsb;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;


import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.*;

import android.widget.Toast;

import fr.gsb.rv.modeles.ModeleGsb;
import fr.gsb.rv.entites.*;
import fr.gsb.rv.technique.Session;

import static fr.gsb.R.layout.activity_main ;
import static fr.gsb.rv.technique.Session.ouvrir;

public class MainActivity extends AppCompatActivity {
    static final String TAG = "GSB_MAIN_ACTIVITY";
    TextView tvVisiteur;
    TextView tvErreur;
    EditText etMatricule;
    EditText etMdp;
    Visiteur leVisiteur;
    Session session;
    Button bSeConnecter;
    Button bSeDeconnecter;
    Button bAnnuler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        tvVisiteur = (TextView) findViewById(R.id.tvVisiteur);
        tvErreur = (TextView) findViewById(R.id.tvErreur);

        etMatricule = (EditText) findViewById(R.id.etMatricule);
        etMdp = (EditText) findViewById(R.id.etMdp);

        bSeConnecter = (Button) findViewById(R.id.bValider);
        bAnnuler = (Button) findViewById(R.id.bAnnuler);


        bSeConnecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seConnecter(v);
            };
        });

        bAnnuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                annuler();
            };
        });

    }


    public void seConnecter(View v ) {
        try {

            String matricule = leVisiteur.getMatricule();
            String mdp = leVisiteur.getMdp();

            Visiteur visiteur = ModeleGsb.getInstance().seConnecter(leVisiteur.getMdp(), leVisiteur.getMatricule());

            if (matricule.equals(visiteur.getMatricule())  && mdp.equals(visiteur.getMdp()) ) {
                    if (session != null){
                    ouvrir(visiteur);
                    bSeConnecter.isEnabled();
                    bAnnuler.isEnabled();

                    Toast.makeText(this,"message",Toast.LENGTH_LONG).show();
            }
                else {
                    tvErreur.getError().toString();
                    }
                }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void annuler(){
        etMdp.getText().clear();
        etMatricule.getText().clear();
    }
}