package com.example.jorge.pentagrammy.vista;

import com.example.jorge.pentagrammy.adaptadores.Pets;
import com.example.jorge.pentagrammy.modelo.PetInfo;

import java.util.ArrayList;

/**
 * Created by jorge on 3/02/18.
 */

public interface IPetsFragment {
    public void generarLayoutVertical();

    public Pets crearAdaptador(ArrayList<PetInfo> listaPets);

    public void inicializarAdaptadorRV(Pets adaptador);
}
