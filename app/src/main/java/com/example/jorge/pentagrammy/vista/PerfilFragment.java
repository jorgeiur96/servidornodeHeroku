package com.example.jorge.pentagrammy.vista;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jorge.pentagrammy.R;
import com.example.jorge.pentagrammy.adaptadores.Perfil;
import com.example.jorge.pentagrammy.modelo.CuentaInstagram;
import com.example.jorge.pentagrammy.modelo.PerfilInfo;
import com.example.jorge.pentagrammy.presentadores.IPerfil;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment implements IPerfilFragment {
    private RecyclerView rvLista;
    private ImageView imgPerfil;
    private TextView tvNombrePerfil;
    private IPerfil iPresentador;
    private Activity activity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        activity = getActivity();

        rvLista = (RecyclerView) v.findViewById(R.id.rvListaPerfil);
        imgPerfil = (ImageView) v.findViewById(R.id.imgPerfil);
        tvNombrePerfil = (TextView) v.findViewById(R.id.tvNombrePerfil);
        iPresentador = new com.example.jorge.pentagrammy.presentadores.Perfil(this, getContext());
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (CuentaInstagram.userPerfil != CuentaInstagram.userSelected) {
            // refrescar fragment
            Log.d("MainActivity", "Cuanta seleccionada cambio: refrescando fragment");
            CuentaInstagram.userPerfil = CuentaInstagram.userSelected;
            iPresentador = new com.example.jorge.pentagrammy.presentadores.Perfil(this, getContext());
            //do the data changes. In this case, I am refreshing the arrayList cart_list and then calling the listview to refresh.
            //getCartData();
            //lv1.setAdapter(new custom_list_one(this.getActivity(),cart_list));
        }
    }

    @Override
    public void generarLayout() {
        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        glm.setOrientation(GridLayoutManager.VERTICAL);
        rvLista.setLayoutManager(glm);
        Picasso.with(activity)
                .load(PerfilInfo.userPicture)
                .placeholder(R.drawable.hueso)
                .into(imgPerfil);
        tvNombrePerfil.setText(PerfilInfo.userFullName);
    }

    @Override
    public Perfil crearAdaptador(ArrayList<PerfilInfo> listaPerfil) {
        Perfil adaptador = new Perfil(listaPerfil, getActivity()  );
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(Perfil adaptador) {
        rvLista.setAdapter(adaptador);
    }
}