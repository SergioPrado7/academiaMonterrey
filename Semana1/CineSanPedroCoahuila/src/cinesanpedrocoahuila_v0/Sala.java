package cinesanpedrocoahuila_v0;

import java.util.ArrayList;

public class Sala {
	private int numeroSala;
	private Pelicula peliculaAsignada;
	private ArrayList<Boleto> boletosVendidos;
	
	public Sala(int numeroSala, Pelicula peliculaAsignada) {
		this.numeroSala = numeroSala;
		this.peliculaAsignada = peliculaAsignada;
		this.boletosVendidos = new ArrayList<>();
	}
	
	public void mostrarCartelera() {
		System.out.println("Función en Sala " + numeroSala + " ---> Pelicula: " + peliculaAsignada.getTitulo() + " / Duración: " + peliculaAsignada.getDuracionMins() + " mins");
	}
	
	public void venderBoleto(Boleto nuevoBoleto) {
		boletosVendidos.add(nuevoBoleto);
	}
	
	public double calcularTotalVendido() {
		double total = 0;
		for(Boleto b : boletosVendidos) {
			total = total + b.calcularPrecio();
		}
		return total;
	}

	public int getNumeroSala() {
		return numeroSala;
	}

	public Pelicula getPeliculaAsignada() {
		return peliculaAsignada;
	}
	
	public ArrayList<Boleto> getBoletosVendidos() {
		return boletosVendidos;
	}
}
