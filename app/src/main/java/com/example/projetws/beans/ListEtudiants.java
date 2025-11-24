package com.example.projetws.beans;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import com.example.projetws.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListEtudiants extends AppCompatActivity {

    ListView list;
    String URL = "http://192.168.1.6/WebServiceEtudiant/ws/loadEtudiant.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_etudiants);

        list = findViewById(R.id.listEtudiants);
        loadEtudiants();
    }

    private void loadEtudiants() {
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, URL, null,
                response -> {
                    ArrayList<String> data = new ArrayList<>();

                    try {
                        for (int i = 0; i < response.length(); i++) {
                            JSONObject obj = response.getJSONObject(i);

                            String line = obj.getInt("id") + " - " +
                                    obj.getString("nom") + " " +
                                    obj.getString("prenom") + " (" +
                                    obj.getString("ville") + ")";

                            data.add(line);
                        }

                        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                                ListEtudiants.this,
                                android.R.layout.simple_list_item_1,
                                data
                        );
                        list.setAdapter(adapter);

                    } catch (Exception e) {
                        Log.e("ERR", e.toString());
                    }
                },
                error -> Log.e("ERR", error.toString())
        );

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }
}
