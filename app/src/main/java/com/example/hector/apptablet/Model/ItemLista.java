package com.example.hector.apptablet.Model;

/**
 * Created by hector on 23/08/2014.
 */
public class ItemLista {

    int image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;

    public ItemLista(int id, String nombre, String autor, String genero,  int valoracion, String duracion, String letra, int image) {
        this.id = id;
        this.image = image;
        this.nombre = nombre;
        this.autor = autor;
        Genero = genero;
        this.valoracion = valoracion;
        this.duracion = duracion;
        this.letra = letra;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    String nombre;
    String autor;
    String Genero;
    int valoracion;
    String duracion;
    String letra;

}
