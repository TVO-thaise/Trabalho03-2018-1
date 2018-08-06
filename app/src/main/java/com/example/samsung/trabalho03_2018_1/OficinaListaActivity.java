package com.example.samsung.trabalho03_2018_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class OficinaListaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oficina_lista);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarr);
        setSupportActionBarb(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabb);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(OficinaListActivity.this, ManageOficinaActivity.class);
                startActivity(intent);
            }
        }
    }
}
