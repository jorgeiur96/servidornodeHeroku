package com.example.jorge.pentagrammy.restApi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by jorge on 3/02/18.
 */

public interface API_Endpoints {

    @GET(API_Config.URL_GET_RECENT_MEDIA_USER)
    Call<API_model> getRecentMedia();
}
