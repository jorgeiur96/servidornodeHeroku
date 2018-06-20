package com.example.jorge.pentagrammy.restApi;

/**
 * Created by jorge on 3/02/18.
 */

public class API_Config {

    //https://api.instagram.com/v1/
    public static final String ROOT_URL = "https://api.instagram.com/v1/";
    //public static final String ACCESS_TOKEN = "?access_token=3259702353.aa0d0f4.e61865afc9144ecc8ffc8f6dc84aa17b"; // Perrito Mike
    public static final String ACCESS_TOKEN = "?access_token=1943067530.682b3ae.2201fdebc1114fffbc0e62f4b30b1f74";
    //public static final String URL_GET_RECENT_MEDIA_USER = ROOT_URL + KEY_GET_RECENT_MEDIA_USER + ACCESS_TOKEN;
    public static final String URL_GET_RECENT_MEDIA_USER = "users/self/media/recent/" + ACCESS_TOKEN;
    //https://api.instagram.com/v1/users/self/media/recent/?access_token=3470121575.e91c373.c9c9d75d5bb442ad800da010af91b7d0
}
