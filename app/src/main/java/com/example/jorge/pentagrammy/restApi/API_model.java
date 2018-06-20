package com.example.jorge.pentagrammy.restApi;

import com.example.jorge.pentagrammy.modelo.PerfilInfo;

import java.util.ArrayList;

/**
 * Created by jorge on 3/02/18.
 */

public class API_model {
    ArrayList<PerfilInfo> listaInstagram;

    public ArrayList<PerfilInfo> getListaInstagram() {
        return listaInstagram;
    }

    public void setListaInstagram(ArrayList<PerfilInfo> listaInstagram) {
        this.listaInstagram = listaInstagram;
    }

}
