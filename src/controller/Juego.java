package controller;

import java.util.ArrayList;

import view.SuperficieDibujo;
import view.Ventana;
import model.Ciudad;
import model.Pasajero;
import model.Taxi;

public class Juego {
	
	public void inicializarObjetos() {
		// 1) creamos la ciudad 
		Ciudad cali = new Ciudad(800,800);
						
		// 2) Creamos el taxi
		cali.crearTaxi(0,0);
        String infoTaxi = cali.getTaxi().impInfoTaxi();
        System.out.println(infoTaxi);
						
		// 3) Creamos el pasajero
		cali.crearPasajeros();
        ArrayList<Pasajero> listaSolicitudes = Ciudad.getListaSolicitudes();
        for(Pasajero pepito:listaSolicitudes){
            System.out.println("*) "+ pepito.getInfoPasajero());
        }
        
        Taxi elTaxi = cali.getTaxi();
        
        Ventana ventana = new Ventana();
		ventana.add(new SuperficieDibujo(elTaxi));
		elTaxi.decidirObjetivo();
	}
	
	public static void main(String[] args) {
		System.out.println("Usted entró al main");
		Juego instancia = new Juego();
		instancia.inicializarObjetos();
	}

}
