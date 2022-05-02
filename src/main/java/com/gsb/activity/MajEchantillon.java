package com.gsb.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.adapter.R;
import com.gsb.adapter.BdAdapter;
import com.gsb.modele.Echantillon;

public class MajEchantillon extends AppCompatActivity {

    private Button majButtonAjouter;
    private Button majButtonSupprimer;
    private Button majButtonQuitterListe;
    private EditText ajoutEditTextCode;
    private EditText ajoutEditTextStock;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.majechantillon);

        ajoutEditTextCode = findViewById(R.id.majEditTextCode);
        ajoutEditTextStock = findViewById(R.id.majEditTextQte);
        majButtonAjouter = findViewById(R.id.majButtonAjouter);
        majButtonSupprimer = findViewById(R.id.majButtonSupprimer);
        majButtonQuitterListe = findViewById(R.id.majButtonQuitterListe);


        majButtonAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                majAjoutQteEchantillon();
            }
        });

        majButtonSupprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                majSupprimerQteEchantillon();
            }
        });

        majButtonQuitterListe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


        public void majAjoutQteEchantillon () {
            BdAdapter adapter = new BdAdapter(this);
            adapter.open();

            Echantillon echantillon = adapter.getEchantillonWithLib(ajoutEditTextCode.getText().toString());

            if (ajoutEditTextStock.getText().toString().matches("")) {
                Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_LONG).show();
                return;
            }

            int stock = Integer.parseInt(echantillon.getQuantiteStock());
            int stockToAdd = Integer.parseInt(ajoutEditTextStock.getText().toString());
            int newQuantite = stock + stockToAdd;

            if (stockToAdd <= 0) {
                Toast.makeText(this, "La quantité à ajouter doit être supérieur à 0", Toast.LENGTH_LONG).show();
                return;
            }

            Toast.makeText(this, "Le stock concernant le code saisi est mis à jour", Toast.LENGTH_LONG).show();
            echantillon.setQuantiteStock(String.valueOf(newQuantite));
            adapter.updateEchantillon(echantillon.getCode(), echantillon);
        }

        public void majSupprimerQteEchantillon(){
            BdAdapter adapter = new BdAdapter(this);
            adapter.open();

            Echantillon echantillon = adapter.getEchantillonWithLib(ajoutEditTextCode.getText().toString());

            if (ajoutEditTextStock.getText().toString().matches("")) {
                Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_LONG).show();
                return;
            }

            int stock = Integer.parseInt(echantillon.getQuantiteStock());
            int stockToAdd = Integer.parseInt(ajoutEditTextStock.getText().toString());
            int newQuantite = stock - stockToAdd;

            if (newQuantite <= 0) {
                Toast.makeText(this, "Il n'y a pas assez de stock", Toast.LENGTH_LONG).show();
                return;
            }
            Toast.makeText(this, "Le stock concernant le code saisi est mis à jour", Toast.LENGTH_LONG).show();
            echantillon.setQuantiteStock(String.valueOf(newQuantite));
            adapter.updateEchantillon(echantillon.getCode(),echantillon);
        }
}

