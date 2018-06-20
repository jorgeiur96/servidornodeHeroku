package com.example.jorge.pentagrammy.vista;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.jorge.pentagrammy.R;
import com.example.jorge.pentagrammy.adaptadores.Favoritos;
import com.example.jorge.pentagrammy.modelo.PetInfo;
import com.example.jorge.pentagrammy.presentadores.IFavoritos;

import java.util.ArrayList;

public class FavoritosActivity extends AppCompatActivity implements IFavoritosActivity{
    private RecyclerView rvListaFavoritos;
    private IFavoritos iPresentador;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        Toolbar actionBar = (Toolbar) findViewById(R.id.barraSup);
        setSupportActionBar(actionBar);

        actionBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FavoritosActivity.this, "Regresando", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        activity = this;


        rvListaFavoritos = (RecyclerView) this.findViewById(R.id.rvListaFavoritos);
        iPresentador = new com.example.jorge.pentagrammy.presentadores.Favoritos(this);
    }


    @Override
    public void generarLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(activity);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvListaFavoritos.setLayoutManager(llm);

    }

    @Override
    public Favoritos crearAdaptador(ArrayList<PetInfo> listaPets) {
        Favoritos adaptador = new Favoritos(listaPets, activity);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(Favoritos adaptador) {
        rvListaFavoritos.setAdapter(adaptador);
    }
}
