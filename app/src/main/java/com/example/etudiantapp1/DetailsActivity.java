package com.example.etudiantapp1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
import java.util.HashMap;
public class DetailsActivity extends AppCompatActivity {
    TextView nom,classe;
    Button mod,sup;
    int position;
   // DatabaseReference databaseReference;
    Etudiant etudiant;
    //params p=new params();
    //HashMap<String,String> m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        nom=findViewById(R.id.nom);
        classe=findViewById(R.id.classe);
        mod=findViewById(R.id.modifier);
        sup=findViewById(R.id.supprimer);
       /* Bundle extras=getIntent().getExtras();
        if(extras!=null)
        {
            position=extras.getInt("position");
        }*/
        //m=p.values.get(position);
        //nom.setText(m.get("nom"));
        //classe.setText(m.get("classe"));
        //databaseReference = FirebaseDatabase.getInstance().getReference("Etudiant");
        etudiant=new Etudiant();
        mod.setOnClickListener((v) -> {
            String name=nom.getText().toString();
            String Class=classe.getText().toString();
            etudiant.setClasse(Class);
            etudiant.setNom(name);
            //databaseReference.child(name).setValue(etudiant);
            Toast.makeText(getApplicationContext(), "Data modified!", Toast.LENGTH_LONG).show();
            Intent i = new Intent(getApplicationContext(),ListeActivity.class);
            startActivity(i);
            finish();
        });
        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //p.values.remove(position);
                Intent i = new Intent(getApplicationContext(),ListeActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}