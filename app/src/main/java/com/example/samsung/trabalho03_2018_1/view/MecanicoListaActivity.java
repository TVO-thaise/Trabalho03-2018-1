package com.example.samsung.trabalho03_2018_1.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.samsung.trabalho03_2018_1.ClickRecyclerViewListener;
import com.example.samsung.trabalho03_2018_1.adapter.MecanicoAdapter;
import com.example.samsung.trabalho03_2018_1.view.ManageMecanicoActivity;

public class MecanicoListaActivity extends AppCompatActivity implements ClickRecyclerViewListener {

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mecanico_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.realm = Realm.getDefaultInstance();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MecanicoListActivity.this, ManageMecanicoActivity.class);
                intent.putExtra("id",0);
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
        return (Lista) this.realm.where(Mecanico.class).findAll();
    }

    @Override
    public void onClick(Object object) {
        Mecanico m = (Mecanico) object;
        Intent intent = new Intent(MecanicoListActivity.this, ManageMecanicoActivity.class);
        intent.putExtra("id", m.getId());
        startActivity(intent);
    }

    public void finish(){
        super.finish();
        this.realm.close();
    }
}
