package com.luv2code.springboot.cruddemo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "futbolistas")
public class Futbolista {

    @Id
    private String id;

    private String nombre;
    private String apellido;
    private String posicion;
    private String seleccion;
    private String club;
    private int golesTotales;

    public Futbolista() {
    }

    public Futbolista(String nombre, String apellido, String posicion, String seleccion, String club, int golesTotales) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.posicion = posicion;
        this.seleccion = seleccion;
        this.club = club;
        this.golesTotales = golesTotales;
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

    public String getApellido() { 
    	return apellido; 
    }
    
    public void setApellido(String apellido) { 
    	this.apellido = apellido; 
    }

    public String getPosicion() { 
    	return posicion; 
    }
    
    public void setPosicion(String posicion) { 
    	this.posicion = posicion; 
    }

    public String getSeleccion() { 
    	return seleccion; 
    }
    
    public void setSeleccion(String seleccion) { 
    	this.seleccion = seleccion;
    }

    public String getClub() { 
    	return club; 
    }
    
    public void setClub(String club) { 
    	this.club = club; 
    }

    public int getGolesTotales() { 
    	return golesTotales; 
    }
    
    public void setGolesTotales(int golesTotales) { 
    	this.golesTotales = golesTotales; 
    }

    @Override
    public String toString() {
        return "Futbolista{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", posicion='" + posicion + '\'' +
                ", seleccion='" + seleccion + '\'' +
                ", club='" + club + '\'' +
                ", golesTotales=" + golesTotales +
                '}';
    }
}