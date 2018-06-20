package com.example.jorge.pentagrammy.presentadores;

import android.content.Context;

import com.example.jorge.pentagrammy.modelo.DB_Manager;
import com.example.jorge.pentagrammy.modelo.PetInfo;
import com.example.jorge.pentagrammy.vista.IPetsFragment;

import java.util.ArrayList;

/**
 * Created by jorge on 3/02/18.
 */

public class Pets implements IPets {

    private IPetsFragment iPetsFragment;
    private Context context;
    private DB_Manager db_Manager;
    private ArrayList<PetInfo> listaPets;

    public Pets(IPetsFragment iPetsFragment, Context context) {
        this.iPetsFragment = iPetsFragment;
        this.context = context;
        obtenerLista();
    }

    @Override
    public void obtenerLista() {
        db_Manager = new DB_Manager(context);
        listaPets = db_Manager.obtenerDatos();
        mostrarListaRV();
    }


    @Override
    public void mostrarListaRV() {
        iPetsFragment.inicializarAdaptadorRV(iPetsFragment.crearAdaptador(listaPets));
        iPetsFragment.generarLayoutVertical();
    }
}
