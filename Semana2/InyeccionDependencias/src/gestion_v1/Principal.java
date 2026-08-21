package gestion_v1;

public class Principal {
	public static void main(String[] args) {
		System.out.println("ESTE ES EL SISTEMA DE GESTION DEL CINE SAN PEDRO \n");
		
		SalaCine salaVIP = AdministradorCine.configurarSalaVIP();
		SalaCine salaBase = AdministradorCine.configurarSalaBase();
		
		salaVIP.iniciarFuncion("Narnia");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
		salaBase.iniciarFuncion("End Game");
	}
}
