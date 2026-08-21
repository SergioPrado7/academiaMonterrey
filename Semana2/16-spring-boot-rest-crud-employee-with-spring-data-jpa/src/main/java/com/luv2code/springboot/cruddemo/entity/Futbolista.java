package com.luv2code.springboot.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="futbolista")
public class Futbolista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name="posicion")
    private String posicion;

    @Column(name="seleccion")
    private String seleccion;

    @Column(name="club")
    private String club;

    @Column(name="goles_totales")
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
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", posicion='" + posicion + '\'' +
                ", seleccion='" + seleccion + '\'' +
                ", club='" + club + '\'' +
                ", golesTotales=" + golesTotales +
                '}';
    }
}