package com.example.jorge.pentagrammy.presentadores;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.jorge.pentagrammy.modelo.CuentaInstagram;
import com.example.jorge.pentagrammy.modelo.PerfilInfo;
import com.example.jorge.pentagrammy.restApi.API_Endpoints;
import com.example.jorge.pentagrammy.restApi.API_adapter;
import com.example.jorge.pentagrammy.restApi.API_model;
import com.example.jorge.pentagrammy.vista.IPerfilFragment;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jorge on 3/02/18.
 */

public class Perfil implements IPerfil {

    private IPerfilFragment iPerfilFragment;
    private Context context;
    private ArrayList<PerfilInfo> listaPerfil;
    private static final String TAG = "MainActivity";
    private CuentaInstagram cuentaActual;

    public Perfil(IPerfilFragment iPerfilFragment, Context context) {
        this.iPerfilFragment = iPerfilFragment;
        this.context = context;
        if (CuentaInstagram.listaCuentas.size() == 0) {
            LlenaCuentas ();
        }
        obtenerListaInstagram();
    }

    @Override
    public void LlenaCuentas () {
        CuentaInstagram.userPerfil = "954535820";
        cuentaActual = new CuentaInstagram("954535820", "nitha_aragon", "Snapchat: varagon1996", "https://scontent.cdninstagram.com/vp/94f9504d26d222ae61ed9c4f2f835000/5B003D8B/t51.2885-19/s150x150/23498917_910570589119130_8166409619288096768_n.jpg");
        cuentaActual = new CuentaInstagram("1943067530", "jorgeivanurueta", "Jorge Ivan Urueta", "https://scontent.cdninstagram.com/vp/8b3bc0b4817f31e8e4d1b39d9314994d/5B1DF314/t51.2885-19/s150x150/11428630_1638270123104417_1652654287_a.jpg");

    }

    @Override
    public void obtenerListaInstagram() {
        API_adapter apiAdapter = new API_adapter();
        Gson gsonMediaRecent = apiAdapter.construyeGsonDeserializadorMediaRecent();
        API_Endpoints apiEndpoints = apiAdapter.establecerConexionApiInstagram(gsonMediaRecent);
        Call<API_model> apiModelCall = apiEndpoints.getRecentMedia();

        apiModelCall.enqueue(new Callback<API_model>() {
            @Override
            public void onResponse(Call<API_model> call, Response<API_model> response) {
                Log.v(TAG, "CONEXION API REALIZADA");
                API_model apiModel = response.body();
                listaPerfil = apiModel.getListaInstagram();
                mostrarListaRV();
            }

            @Override
            public void onFailure(Call<API_model> call, Throwable t) {
                Toast.makeText(context, "¡falló conexión! Intenta de nuevo", Toast.LENGTH_LONG).show();
                Log.e("FALLO LA CONEXION API", t.toString());
            }
        });
    }


    @Override
    public void mostrarListaRV() {
        iPerfilFragment.inicializarAdaptadorRV(iPerfilFragment.crearAdaptador(listaPerfil));
        iPerfilFragment.generarLayout();
    }


}
