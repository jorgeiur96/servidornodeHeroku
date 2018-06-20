package com.example.jorge.pentagrammy.modelo;

/**
 * Created by jorge on 3/02/18.
 */

public class PetInfo {

    private int id;
    private String nombre;
    private int foto;
    private int likes;

    public PetInfo() {
        this.nombre = "";
        this.foto = 0;
        this.likes = 0;
    }

    public PetInfo(String nombre, int foto) {
        this.nombre = nombre;
        this.foto = foto;
        this.likes = 0;
    }

    public PetInfo(int id, String nombre, int foto, int likes) {
        this.id = id;
        this.nombre = nombre;
        this.foto = foto;
        this.likes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public boolean incrementaLikes() {
        this.likes++;
        return Pet_Favoritos.esFavorito(this);
    }
}
