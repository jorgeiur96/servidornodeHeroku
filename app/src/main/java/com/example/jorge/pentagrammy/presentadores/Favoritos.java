package com.example.jorge.pentagrammy.presentadores;

import com.example.jorge.pentagrammy.modelo.PetInfo;
import com.example.jorge.pentagrammy.modelo.Pet_Favoritos;
import com.example.jorge.pentagrammy.vista.IFavoritosActivity;

import java.util.ArrayList;

/**
 * Created by jorge on 3/02/18.
 */

public class Favoritos implements IFavoritos {


    private IFavoritosActivity iFavoritosActivity;
    private ArrayList<PetInfo> listaPets;

    public Favoritos(IFavoritosActivity iFavoritosActivity) {
        this.iFavoritosActivity = iFavoritosActivity;
        obtenerLista();
    }

    @Override
    public void obtenerLista() {
        listaPets = Pet_Favoritos.listaFav;
        mostrarListaRV();
    }


    @Override
    public void mostrarListaRV() {
        iFavoritosActivity.inicializarAdaptadorRV(iFavoritosActivity.crearAdaptador(listaPets));
        iFavoritosActivity.generarLayoutVertical();
    }
}
