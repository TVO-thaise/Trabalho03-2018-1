package com.example.samsung.trabalho03_2018_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.samsung.trabalho03_2018_1.model.Oficina;

import java.util.ArrayList;

public class ManageOficinaActivity extends AppCompatActivity implements ClickRecyclerViewListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oficina_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarr);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabb);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OficinaListaActivity.this, ManageOficinaActivity.class);
                startActivity(intent);
            }
        });
    }

    protected void onResume(){
        super.onResume();
        RecyclerView recyclerView = findViewById(R.id.rvOficinas);
        recyclerView.setAdapter(new OficinaAdapter(this.getOficinas(),this,this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    public Lista<Oficina> getOficinas(){

        ArrayList<Oficina> lista = new ArrayList<>();

        Oficina oficina = new Oficina();
        oficina.setNome("Nova");
        oficina.setRua("Marechal Deodoro");

        list.add(oficina);

        return lista;
    }

    @Override
    public void onClick(Object object) {

    }
}