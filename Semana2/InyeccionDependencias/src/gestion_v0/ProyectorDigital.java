package gestion_v0;

public class ProyectorDigital implements Proyector{
	@Override
	public void reproducirPelicula(String pelicula) {
		System.out.println("Se esta proyectando en el formato digital la pelicula: " + pelicula);
	}
}
