package com.example.jorge.pentagrammy.modelo;

import android.content.ContentValues;
import android.content.Context;

import com.example.jorge.pentagrammy.R;
import com.example.jorge.pentagrammy.db.DB_Conexion;
import com.example.jorge.pentagrammy.db.DB_Config;

import java.util.ArrayList;

/**
 * Created by jorge on 3/02/18.
 */

public class DB_Manager {
    private static final int LIKE = 1;
    private Context context;
    public DB_Manager(Context context) {
        this.context = context;
    }

    public ArrayList<PetInfo> obtenerDatos() {
        DB_Conexion db = new DB_Conexion(context);
        if (db.estaVacio()) cargarDatos(db);
        return  db.leerTodo();
    }

    public void cargarDatos(DB_Conexion db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(DB_Config.TABLE_PETS_NOMBRE, "tobie");
        contentValues.put(DB_Config.TABLE_PETS_FOTO, R.drawable.img2);
        contentValues.put(DB_Config.TABLE_PETS_LIKES, 13);
        db.insertarPetInfo(contentValues);

        contentValues = new ContentValues();
        contentValues.put(DB_Config.TABLE_PETS_NOMBRE, "kira");
        contentValues.put(DB_Config.TABLE_PETS_FOTO, R.drawable.img3);
        contentValues.put(DB_Config.TABLE_PETS_LIKES, 18);
        db.insertarPetInfo(contentValues);

        contentValues = new ContentValues();
        contentValues.put(DB_Config.TABLE_PETS_NOMBRE, "lory");
        contentValues.put(DB_Config.TABLE_PETS_FOTO, R.drawable.img4);
        contentValues.put(DB_Config.TABLE_PETS_LIKES, 2);
        db.insertarPetInfo(contentValues);

        contentValues = new ContentValues();
        contentValues.put(DB_Config.TABLE_PETS_NOMBRE, "caiser");
        contentValues.put(DB_Config.TABLE_PETS_FOTO, R.drawable.img5);
        contentValues.put(DB_Config.TABLE_PETS_LIKES, 2);
        db.insertarPetInfo(contentValues);

        contentValues = new ContentValues();
        contentValues.put(DB_Config.TABLE_PETS_NOMBRE, "atilas");
        contentValues.put(DB_Config.TABLE_PETS_FOTO, R.drawable.img6);
        contentValues.put(DB_Config.TABLE_PETS_LIKES, 2);
        db.insertarPetInfo(contentValues);


    }

    public void actualizarMascota(PetInfo petInfo){
        DB_Conexion db = new DB_Conexion(context);
        db.updateLikes(petInfo.getId(), petInfo.getLikes());
    }

}
