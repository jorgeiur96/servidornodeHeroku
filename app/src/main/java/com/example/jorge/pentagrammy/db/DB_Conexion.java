package com.example.jorge.pentagrammy.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.jorge.pentagrammy.modelo.PetInfo;
import com.example.jorge.pentagrammy.modelo.Pet_Favoritos;

import java.util.ArrayList;

/**
 * Created by jorge on 3/02/18.
 */

public class DB_Conexion extends SQLiteOpenHelper {

    private Context context;

    public DB_Conexion(Context context) {
        super(context, DB_Config.DATABASE_NAME, null, DB_Config.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaPetInfo = "CREATE TABLE " + DB_Config.TABLE_PETS + "(" +
                DB_Config.TABLE_PETS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DB_Config.TABLE_PETS_NOMBRE + " TEXT, " +
                DB_Config.TABLE_PETS_FOTO + " INTEGER, " +
                DB_Config.TABLE_PETS_LIKES + " INTEGER " +
                ")";

        db.execSQL(queryCrearTablaPetInfo);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST "+ DB_Config.TABLE_PETS);
        onCreate(db);
    }

    public ArrayList<PetInfo> leerTodo() {
        ArrayList<PetInfo> listaPets = new ArrayList<>();

        String query = "SELECT * FROM " + DB_Config.TABLE_PETS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursorReg = db.rawQuery(query, null);

        while (cursorReg.moveToNext()){
            PetInfo petActual = new PetInfo(cursorReg.getInt(0), cursorReg.getString(1), cursorReg.getInt(2), cursorReg.getInt(3));
            listaPets.add(petActual);
            Pet_Favoritos.esFavorito(petActual); // va formando lista de 5 favoritos
        }

        db.close();

        return listaPets;
    }

    public boolean estaVacio() {
        String query = "SELECT * FROM " + DB_Config.TABLE_PETS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursorReg = db.rawQuery(query, null);

        boolean swVacio = true;
        if (cursorReg.getCount() > 0) swVacio = false;
        db.close();

        return swVacio;
    }

    public void limpiaBD(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXIST " + DB_Config.TABLE_PETS);
        db.close();
    }

    public void insertarPetInfo(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(DB_Config.TABLE_PETS,null, contentValues);
        db.close();
    }

    public void updateLikes(int petId, int likes){
        ContentValues values = new ContentValues();
        values.put(DB_Config.TABLE_PETS_LIKES, likes);

        SQLiteDatabase db = this.getWritableDatabase();
        db.update(DB_Config.TABLE_PETS, values, "id="+petId, null);
        db.close();
    }

}
