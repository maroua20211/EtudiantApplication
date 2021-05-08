package com.example.etudiantapp1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class AjoutActivity extends AppCompatActivity {
    EditText nom, classe;
    Button add;
    DatabaseReference databaseReference;
    Etudiant etudiant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);
        //getEtudiantName();
        nom = findViewById(R.id.nom);
        classe = findViewById(R.id.classe);
        add = findViewById(R.id.add);
        databaseReference = FirebaseDatabase.getInstance().getReference("Etudiant");
        etudiant=new Etudiant();

        add.setOnClickListener((v) -> {
            String name=nom.getText().toString();
            String Class=classe.getText().toString();
            etudiant.setClasse(Class);
            etudiant.setNom(name);
            databaseReference.child(name).setValue(etudiant);
            Toast.makeText(getApplicationContext(), "Data inserted !", Toast.LENGTH_LONG).show();
            Intent i = new Intent(getApplicationContext(), ListeActivity.class);
            i.putExtra("child_name","Etudiant");
            //i.putExtra("nom", nom.getText().toString());
            //i.putExtra("classe", classe.getText().toString());
            startActivity(i);

        });

    }
}