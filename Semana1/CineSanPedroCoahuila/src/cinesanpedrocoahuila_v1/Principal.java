package cinesanpedrocoahuila_v1;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		double totalDineroCine = 0;
		boolean taquillaActiva = true;
		Scanner teclas = new Scanner(System.in);
		
		Cine cine1 = new Cine();
		System.out.println("Bienvenidos al " + cine1.getNombreCine());
		System.out.println("El cual esta ubicado en " + cine1.getUbicacionCine());
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

		Pelicula peli1 = new Pelicula("El Padrino", 95);
		Pelicula peli2 = new Pelicula("Avenger End Game", 115);
		Pelicula peli3 = new Pelicula("Spiderman Brands New Day", 125);
		
		Sala sala1 = new Sala(1, peli1);
		Sala sala2 = new Sala(2, peli2);
		Sala sala3 = new Sala(3, peli3);
		
		sala1.mostrarCartelera();
		sala2.mostrarCartelera();
		sala3.mostrarCartelera();
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
		while (taquillaActiva) {
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Estas en la Taquilla");
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("¿Qué pelicula deseas ver? Elige la pelicula");
			System.out.println("1 - " + sala1.getPeliculaAsignada().getTitulo());
			System.out.println("2 - " + sala2.getPeliculaAsignada().getTitulo());
			System.out.println("3 - " + sala3.getPeliculaAsignada().getTitulo());
			System.out.println("0 - Para salir y ver estado del cine");
			
			int numeroSala = teclas.nextInt();
			teclas.nextLine();
			
			if (numeroSala == 0) {
				System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("Taquilla cerrada, aquí esta el reporte del día");
				taquillaActiva = false;
			}
			else if(numeroSala == 1 || numeroSala == 2 || numeroSala == 3) {
				System.out.println("¿Qué boleto quiere?");
				System.out.println("1- Basico en $50");
				System.out.println("2- Premium en $100");
				int tipoBoleto = teclas.nextInt();
				teclas.nextLine();
				
				System.out.println("¿Dónde se gustaría sentar?");
				System.out.println("Si es Basico: B1, B2 ...");
				System.out.println("Si es Premium: P1, P2 ...");
				String asientoEleccion = teclas.nextLine();
				
				if (numeroSala == 1) {
					if (tipoBoleto == 1) {
						sala1.venderBoleto(new BoletoBasico(asientoEleccion));
					}
					else {
						sala1.venderBoleto(new BoletoPremium(asientoEleccion));
					}
					System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("Boleto vendido para la Sala 1");
				}
				else if (numeroSala == 2) {
					if(tipoBoleto == 1) {
						sala2.venderBoleto(new BoletoBasico(asientoEleccion));			
					}
					else {
						sala2.venderBoleto(new BoletoPremium(asientoEleccion));
					}
					System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("Boleto vendido para la Sala 2");
				}
				else if (numeroSala == 3) {
					if (tipoBoleto == 1) {
						sala3.venderBoleto(new BoletoBasico(asientoEleccion));			
					}
					else {
						sala3.venderBoleto(new BoletoPremium(asientoEleccion));
					}
					System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("Boleto vendido para la Sala 3");
				}
			}
		}
		
		teclas.close();
		
		//sala1.venderBoleto(new BoletoBasico("A1"));
		//sala1.venderBoleto(new BoletoBasico("A2"));
		//sala1.venderBoleto(new BoletoPremium("V1"));
		
		//sala2.venderBoleto(new BoletoPremium("V1"));
		//sala2.venderBoleto(new BoletoPremium("V2"));
		
		//sala3.venderBoleto(new BoletoBasico("A1"));
		
		ArrayList<Sala> listaSalas = new ArrayList<>();
		listaSalas.add(sala1);
		listaSalas.add(sala2);
		listaSalas.add(sala3);
		
		for(Sala salaActual : listaSalas) {
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Reporte de la Sala " + salaActual.getNumeroSala());
			for (Boleto b : salaActual.getBoletosVendidos()) {
				System.out.println("El asiento " + b.getNumeroAsiennto() + " ---> " + "Se cobró: $" + b.calcularPrecio());
				if (b instanceof BoletoPremium) {
					BoletoPremium premium = (BoletoPremium) b;
					premium.pedirComidaAsiento();
				}
			}
			double totalSala = salaActual.calcularTotalVendido();
			System.out.println("Total vendido en la sala " + salaActual.getNumeroSala() + " = $" + totalSala);
			totalDineroCine += totalSala;
		}
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
		System.out.println("Total vendido en el " + cine1.getNombreCine() + " = $" + totalDineroCine);
	}

}
