package com.gsb.activity;

import android.content.Intent;
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

public class AjoutEchantillon extends AppCompatActivity {

    private EditText ajoutEditTextCode;
    private EditText ajoutEditTextLib;
    private EditText ajoutEditTextStock;


    private Button ajoutButtonAjouter;
    private Button ajoutButtonQuitter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajoutechantillon);

        ajoutButtonAjouter = findViewById(R.id.ajoutButtonAjouter);
        ajoutButtonQuitter = findViewById(R.id. ajoutButtonQuitter);
        ajoutEditTextCode = findViewById(R.id.ajoutEditTextCode);
        ajoutEditTextLib = findViewById(R.id.ajoutEditTextLib);
        ajoutEditTextStock = findViewById(R.id.ajoutEditTextStock);


        ajoutButtonAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { addEchantillon()
                 ; }

            private void addEchantillon() {
                BdAdapter adapter = new BdAdapter(AjoutEchantillon.this);
                if (ajoutEditTextCode.getText().toString().matches("") ||
                        ajoutEditTextLib.getText().toString().matches("") ||
                        ajoutEditTextStock.getText().toString().matches("")) {
                    Toast.makeText(AjoutEchantillon.this, "Veuillez remplir tous les champs", Toast.LENGTH_LONG).show();
                    return;
                }
                int stock = Integer.parseInt(ajoutEditTextStock.getText().toString());
                if (stock <= 0) {
                    Toast.makeText(AjoutEchantillon.this, "La quantité doit être supérieur à 0", Toast.LENGTH_LONG).show();
                    return;
                }

                adapter.open();
                adapter.insererEchantillon(new Echantillon(
                ajoutEditTextCode.getText().toString(),
                ajoutEditTextLib.getText().toString(),
                ajoutEditTextStock.getText().toString()));
                //Echantillon ech1 = new Echantillon("1","UN","Nombre");

                Toast.makeText(AjoutEchantillon.this, "Un échantillon a été ajouté", Toast.LENGTH_LONG).show();
                adapter.close();
                }

                });
        ajoutButtonQuitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
