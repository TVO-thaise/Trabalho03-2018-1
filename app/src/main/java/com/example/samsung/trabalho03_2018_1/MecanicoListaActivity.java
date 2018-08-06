package com.example.samsung.trabalho03_2018_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class MecanicoListaActivity extends AppCompatActivity implements ClickRecyclerViewListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mecanico_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MecanicoListaActivity.this, ManageMecanicoActivity.class);
                startActivity(intent);
            }
        });
    }


    protected void onResume(){
        super.onResume();
        RecyclerView recyclerView = findViewById(R.id.rvMecanicos);
        recyclerView.setAdapter(new MecanicoAdapter(this.getMecanicos(),this,this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    public List<Mecanico> getMecanicos(){

        ArrayList<Mecanico> list = new ArrayList<>();

        Mecanico mecanico = new Mecanico();
        mecanico.setNome("João");
        mecanico.setFuncao("Mecanico");

        list.add(mecanico);

        return list;
    }

    @Override
    public void onClick(Object object) {

    }

}
