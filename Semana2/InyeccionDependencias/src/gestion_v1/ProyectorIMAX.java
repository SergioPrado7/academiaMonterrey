package gestion_v1;

public class ProyectorIMAX implements Proyector{
	@Override
	public void reproducirPelicula(String pelicula) {
		System.out.println("Se esta proyectando en el formato IMAX con calidad alta la pelicula: " + pelicula);
	}
}
