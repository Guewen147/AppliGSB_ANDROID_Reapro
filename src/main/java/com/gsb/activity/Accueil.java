package com.gsb.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.adapter.R;



public class Accueil extends AppCompatActivity {
    private Button menuButtonAjoutEchantillon;
    private Button menuButtonListeEchantillons;
    private Button menuButtonMajEchantillons;
    private Button menuButtonListeReaprovisionnement;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuButtonAjoutEchantillon = (Button) findViewById(R.id.menuButtonAjoutEchantillon);

        menuButtonListeEchantillons = (Button) findViewById(R.id.menuButtonListeEchantillons);

        menuButtonMajEchantillons = (Button) findViewById(R.id.menuButtonMajEchantillons);

        menuButtonListeReaprovisionnement = (Button) findViewById(R.id.menuButtonListeReaprovisionnement);

        menuButtonAjoutEchantillon.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(Accueil.this, AjoutEchantillon.class);
                        startActivity (intent);
            }
        });

        menuButtonListeEchantillons.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(Accueil.this, ListeEchantillon.class);
                startActivity (intent);
            }
        });

        menuButtonListeReaprovisionnement.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(Accueil.this, ListeReaprovisionnement.class);
                startActivity (intent);
            }
        });

        menuButtonMajEchantillons.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(Accueil.this, MajEchantillon.class);
                startActivity (intent);
            }
        });
    }
}