package com.example.etudiantapp1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.etudiantapp1.Etudiant;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.HashMap;

//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
public class ListeActivity extends AppCompatActivity {
    ListView ls;
    String nom, classe;
    Etudiant etudiant;
    //HashMap<String,String> map;
    //params p=new params();
    DatabaseReference databaseReference;
    //HashMap<String,String> AllEtudiants=new HashMap<>();
    ArrayList<String> allEtudiant = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);
        ls = findViewById(R.id.lst);
        Intent i = getIntent();
        databaseReference = FirebaseDatabase.getInstance().getReference().child(i.getStringExtra("child_name"));


        /*Bundle extras=getIntent().getExtras();
        if(extras!=null)
        {
            nom= extras.getString("nom");
            classe= extras.getString("classe");
            map=new HashMap<String, String>();
            map.put("nom",nom);
            map.put("classe",classe);
            p.values.add(map);
        }
        SimpleAdapter adapter=new SimpleAdapter(ListeActivity.this,p.values, R.layout.item,
                new String[]{"nom","classe"},new int[]{R.id.nom,R.id.classe}
        );
        ls.setAdapter(adapter);*/
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(ListeActivity.this, DetailsActivity.class);
                i.putExtra("position", position);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.getEtudiants();
        /*SimpleAdapter adapter=new SimpleAdapter(ListeActivity.this,p.values, R.layout.item,
                new String[]{"nom","classe"},new int[]{R.id.nom,R.id.classe});*/
        ArrayAdapter adapter = new ArrayAdapter(ListeActivity.this, android.R.layout.simple_list_item_1, this.allEtudiant);
        ls.setAdapter(adapter);

    }

    public void getEtudiants() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    Etudiant e = ds.getValue(Etudiant.class);
                    allEtudiant.add(e.getNom());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ListeActivity.this, "Fail to get Data", Toast.LENGTH_SHORT).show();
            }
        });

    }
}