package com.example.jorge.pentagrammy.vista;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jorge.pentagrammy.R;
import com.example.jorge.pentagrammy.adaptadores.Pets;
import com.example.jorge.pentagrammy.modelo.PetInfo;
import com.example.jorge.pentagrammy.presentadores.IPets;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PetsFragment extends Fragment implements IPetsFragment {
    private RecyclerView rvListaPets;
    private IPets iPresentador;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_pets, container, false);
        //v.setTag(TAG);

        rvListaPets = (RecyclerView) v.findViewById(R.id.rvListaPets);
        iPresentador = new com.example.jorge.pentagrammy.presentadores.Pets(this, getContext());
        return v;
    }

    @Override
    public void generarLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvListaPets.setLayoutManager(llm);

    }

    @Override
    public Pets crearAdaptador(ArrayList<PetInfo> listaPets) {
        Pets adaptador = new Pets(listaPets, getActivity()  );
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(Pets adaptador) {
        rvListaPets.setAdapter(adaptador);
    }
}

