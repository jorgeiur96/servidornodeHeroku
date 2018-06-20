package com.example.jorge.pentagrammy.modelo;

import java.util.ArrayList;

/**
 * Created by jorge on 3/02/18.
 */

public class CuentaInstagram {
    private String userID;
    private String userName;
    private String userFullName;
    private String userPicture;
    public static ArrayList<Object> listaCuentas = new ArrayList<Object>();
    public static String userPerfil;
    public static String userSelected;

    public CuentaInstagram(String userID, String userName, String userFullName, String userPicture) {

        this.userID = userID;
        this.userName = userName;
        this.userFullName = userFullName;
        this.userPicture = userPicture;
        setItem(this);
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }

    public static ArrayList<Object> getListaCuentas() {
        return listaCuentas;
    }

    public static void setListaCuentas(ArrayList<Object> listaCuentas) {
        CuentaInstagram.listaCuentas = listaCuentas;
    }

    public static void setItem(Object newObjeto) {
        listaCuentas.add(newObjeto);
    }

    public static CuentaInstagram getItem(int indice) {
        return (CuentaInstagram) listaCuentas.get(indice);
    }
}
