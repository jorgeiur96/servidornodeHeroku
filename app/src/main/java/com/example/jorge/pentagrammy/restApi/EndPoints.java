package com.example.jorge.pentagrammy.restApi;




import com.example.jorge.pentagrammy.modelo.UsuarioResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface EndPoints {

    @FormUrlEncoded
    @POST(Constantes.KEY_POST_ID_TOKEN)
    Call<UsuarioResponse> registrarTokenId(@Field("id_dispositivo") String id_dispositivo,
                                           @Field("id_usuario_instagram") String id_usuario_instagram);
}
