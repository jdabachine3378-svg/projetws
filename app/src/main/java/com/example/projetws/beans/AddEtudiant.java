package com.example.projetws.beans;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.projetws.R;

import java.util.HashMap;
import java.util.Map;

public class AddEtudiant extends AppCompatActivity {

    EditText nom, prenom, ville;
    RadioGroup groupSexe;
    Button btnAdd, btnList;

    String URL_ADD = "http://192.168.1.6/WebServiceEtudiant/ws/createEtudiant.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_etudiant);

        nom = findViewById(R.id.nom);
        prenom = findViewById(R.id.prenom);
        ville = findViewById(R.id.ville);
        groupSexe = findViewById(R.id.groupSexe);
        btnAdd = findViewById(R.id.btnAdd);
        btnList = findViewById(R.id.btnList);

        btnAdd.setOnClickListener(v -> addStudent());

        btnList.setOnClickListener(v -> {
            Intent intent = new Intent(AddEtudiant.this, ListEtudiants.class);
            startActivity(intent);
        });
    }

    private void addStudent() {

        String sNom = nom.getText().toString();
        String sPrenom = prenom.getText().toString();
        String sVille = ville.getText().toString();

        int selected = groupSexe.getCheckedRadioButtonId();
        RadioButton rb = findViewById(selected);
        String sexe = rb.getText().toString();

        StringRequest request = new StringRequest(Request.Method.POST, URL_ADD,
                response -> {
                    Toast.makeText(AddEtudiant.this, response, Toast.LENGTH_LONG).show();
                },
                error -> {
                    Toast.makeText(AddEtudiant.this, "Erreur : " + error, Toast.LENGTH_LONG).show();
                }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();

                params.put("nom", sNom);
                params.put("prenom", sPrenom);
                params.put("ville", sVille);
                params.put("sexe", sexe);

                return params;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(AddEtudiant.this);
        queue.add(request);
    }
}
