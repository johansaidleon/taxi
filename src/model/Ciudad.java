package model;

import java.util.ArrayList;

public class Ciudad {
	
	private Integer ancho;
	private Integer alto;
	private Taxi taxi; 
	private static ArrayList<Pasajero> listaSolicitudes;
	
	
	public Ciudad(Integer ancho,Integer alto) {
		this.alto = alto;
		this.ancho = ancho;
		System.out.println("Usted ha creado una ciudad de alto "+alto+" y ancho "+ancho);
        listaSolicitudes = new ArrayList<Pasajero>();
	}

	public void crearTaxi(int x, int y) {
		this.taxi = new Taxi(x,y);
	}
	
	public void crearGasolinera(int x, int y) {
		this.taxi = new Taxi(x,y);
	}
	
	public void crearPasajeros() {
        int num = (int) Math.round(Math.random()*(10-1)+1);
        System.out.println("Vamos a crear "+num+" pasajeros");
        for (int i=0;i<num;i++){
        	Pasajero pasajero = new Pasajero();
            listaSolicitudes.add(pasajero);
        }
	}
        
	public Integer getAncho() {
		return ancho;
	}

	public Integer getAlto() {
		return alto;
	}

	public Taxi getTaxi() {
		return taxi;
	}

    public static ArrayList<Pasajero> getListaSolicitudes() {
        return listaSolicitudes;
    }

	
}
