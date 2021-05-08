package com.example.etudiantapp1;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edt1;
    EditText edt2;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1=(EditText) findViewById(R.id.edt1);
        edt2=(EditText) findViewById(R.id.edt2);
        btn=(Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1.getText().toString().equals("admin")&& edt2.getText().toString().equals("1234"))
                {
                    Intent i = new Intent(MainActivity.this,AjoutActivity.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Wrong userName and password",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}