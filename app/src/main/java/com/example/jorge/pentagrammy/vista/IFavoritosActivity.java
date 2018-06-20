package com.example.jorge.pentagrammy.vista;

import com.example.jorge.pentagrammy.adaptadores.Favoritos;
import com.example.jorge.pentagrammy.modelo.PetInfo;

import java.util.ArrayList;

/**
 * Created by jorge on 3/02/18.
 */

public interface IFavoritosActivity {
    public void generarLayoutVertical();

    public Favoritos crearAdaptador(ArrayList<PetInfo> listaPets);

    public void inicializarAdaptadorRV(Favoritos adaptador);
}
