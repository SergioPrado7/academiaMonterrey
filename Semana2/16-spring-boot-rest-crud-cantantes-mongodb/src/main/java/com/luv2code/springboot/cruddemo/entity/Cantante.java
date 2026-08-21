package com.luv2code.springboot.cruddemo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cantantes")
public class Cantante {

    @Id
    private String id;

    private String nombre;
    private String nacionalidad;
    private int popularidad; // Aquí es una escala del 1 al 100
    private double ganancias; // Aquí es en dolares y por millones
    private String albumMasVendido;

    public Cantante() {
    }

    public Cantante(String nombre, String nacionalidad, int popularidad, double ganancias, String albumMasVendido) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.popularidad = popularidad;
        this.ganancias = ganancias;
        this.albumMasVendido = albumMasVendido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getPopularidad() {
        return popularidad;
    }

    public void setPopularidad(int popularidad) {
        this.popularidad = popularidad;
    }

    public double getGanancias() {
        return ganancias;
    }

    public void setGanancias(double ganancias) {
        this.ganancias = ganancias;
    }

    public String getAlbumMasVendido() {
        return albumMasVendido;
    }

    public void setAlbumMasVendido(String albumMasVendido) {
        this.albumMasVendido = albumMasVendido;
    }

    @Override
    public String toString() {
        return "Cantante{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", popularidad=" + popularidad +
                ", ganancias=" + ganancias +
                ", albumMasVendido='" + albumMasVendido + '\'' +
                '}';
    }
}