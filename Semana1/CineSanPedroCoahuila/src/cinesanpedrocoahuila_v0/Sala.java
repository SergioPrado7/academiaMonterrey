package cinesanpedrocoahuila_v0;

import java.util.ArrayList;

public class Sala {
	private int numeroSala;
	private Pelicula peliculaAsignada;
	private Pelicula duracionPelicula;
	private ArrayList<Boleto> boletosVendidos;
	
	public Sala(int numeroSala, Pelicula peliculaAsignada, Pelicula duracionPelicula) {
		this.numeroSala = numeroSala;
		this.peliculaAsignada = peliculaAsignada;
		this.duracionPelicula = duracionPelicula;
		this.boletosVendidos = new ArrayList<>();
	}
	
	public void VenderBoleto(Boleto nuevoBoleto) {
		boletosVendidos.add(nuevoBoleto);
	}
	
	public double CalcularTotalVendido() {
		double total = 0;
		for(Boleto b : boletosVendidos) {
			total = total + b.CalcularPrecio();
		}
		return total;
	}

	public int getNumeroSala() {
		return numeroSala;
	}

	public Pelicula getPeliculaAsignada() {
		return peliculaAsignada;
	}
	
	public Pelicula getDuracionPelicula() {
		return duracionPelicula;
	}
	
	public ArrayList<Boleto> getBoletosVendidos() {
		return boletosVendidos;
	}
}
