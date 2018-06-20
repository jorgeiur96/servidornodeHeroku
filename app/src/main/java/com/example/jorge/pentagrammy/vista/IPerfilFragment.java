package com.example.jorge.pentagrammy.vista;

import com.example.jorge.pentagrammy.adaptadores.Perfil;
import com.example.jorge.pentagrammy.modelo.PerfilInfo;

import java.util.ArrayList;

/**
 * Created by jorge on 3/02/18.
 */

public interface IPerfilFragment {


    //public void onResume();

    public void generarLayout();

    public Perfil crearAdaptador(ArrayList<PerfilInfo> listaPerfil);

    public void inicializarAdaptadorRV(Perfil adaptador);
}
