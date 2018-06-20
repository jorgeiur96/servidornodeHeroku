package com.example.jorge.pentagrammy.modelo;

/**
 * Created by jorge on 3/02/18.
 */

public class PerfilInfo {
    private String urlFoto;
    private int meGusta;
    public static String userID;
    public static String userFullName;
    public static String userPicture;

    public PerfilInfo() {
        this.urlFoto = "";
        this.meGusta = 0;
    }

    public PerfilInfo(String urlFoto) {
        this.urlFoto = urlFoto;
        this.meGusta = 0;
    }

    public PerfilInfo(String urlFoto, int meGusta) {
        this.urlFoto = urlFoto;
        this.meGusta = meGusta;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public int getMeGusta() {
        return meGusta;
    }

    public void setMeGusta(int meGusta) {
        this.meGusta = meGusta;
    }
}
