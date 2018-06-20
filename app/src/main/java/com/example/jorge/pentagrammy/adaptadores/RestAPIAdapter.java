package com.example.jorge.pentagrammy.adaptadores;


import com.example.jorge.pentagrammy.restApi.Constantes;
import com.example.jorge.pentagrammy.restApi.EndPoints;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestAPIAdapter {


    public EndPoints establecerConexionRestApi(){

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Constantes.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                ;

        return retrofit.create(EndPoints.class);

    }
}
