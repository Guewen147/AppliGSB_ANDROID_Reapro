package com.gsb.activity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.adapter.R;
import com.gsb.adapter.BdAdapter;

public class ListeReaprovisionnement extends AppCompatActivity {{

}
        private Button buttonQuitterListe2 ;
        private ListView listViewEchant2;
        private BdAdapter echantBdd2;

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.reaprovisionnement);

            listViewEchant2 = (ListView) findViewById(R.id.listViewEchantillon);

            echantBdd2 = new BdAdapter(this);
            //On ouvre la base de données pour écrire dedans
            echantBdd2.open();
            Cursor leCurseur = echantBdd2.getDataR();
            Toast.makeText(getApplicationContext(), "il y a " + String.valueOf(leCurseur.getCount()) + " echantillons dans la BD", Toast.LENGTH_LONG).show();

            // colonnes à afficher
            String[] colNoms = new String[] {BdAdapter.COL_CODE,BdAdapter.COL_LIB, BdAdapter.COL_STOCK};
            // champs dans lesquelles afficher les colonnes
            int[] colNumeros = new int[] {R.id.echantillon_id, R.id.echantillons_lib, R.id.echantillons_quantity};
            SimpleCursorAdapter dataAdapter = new SimpleCursorAdapter(this, R.layout.echantillon,leCurseur,colNoms,colNumeros);
            // Assign adapter to ListView
            listViewEchant2.setAdapter(dataAdapter);
            echantBdd2.close();




            buttonQuitterListe2 = (Button) findViewById(R.id.buttonQuitterListe);

            buttonQuitterListe2.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    finish();
                }
            });
        }

}
