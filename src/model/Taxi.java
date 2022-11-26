package model;

import java.util.ArrayList;

public class Taxi {
	private Integer cantidadPasajeros;
	private Coordenada2D posicionActual;
	private Coordenada2D posicionInicial;
    private ArrayList<Pasajero> pasajeros;
    public int vida;

    
	public Taxi(int x,int y) {
		cantidadPasajeros = 0;
		posicionInicial = new Coordenada2D(x,y);
                posicionActual = posicionInicial;
                pasajeros = new ArrayList<Pasajero>();
	}
        
        public String impInfoTaxi(){
           String infoTaxi = "posicion Inicial taxi: "+posicionInicial.obtenerCoordenadas()+
                   " Cantidad pasajeros: "+cantidadPasajeros;  
           return  infoTaxi;
        }
        
        public void decidirObjetivo(){
            ArrayList<Pasajero> listaSolicitudes = Ciudad.getListaSolicitudes();
            Boolean veces = true;
            while(veces){
            	System.out.println("************************************************************************************");
                if(!listaSolicitudes.isEmpty() && pasajeros.isEmpty()){
                    System.out.println("Primer caso solo solitudes en el mapa");
                    int posicionSolicitudMin = obtenerSolicitudMasCercana(listaSolicitudes);
                    movimiento(listaSolicitudes.get(posicionSolicitudMin).getPosicionRecogida());
                    recoger(listaSolicitudes.get(posicionSolicitudMin));
                    
                    
                }else if(!listaSolicitudes.isEmpty() && !pasajeros.isEmpty()){
                    System.out.println("Segundo caso solitudes en el mapa y pasajeros en el taxi");
                    int posicionSolicitudMin = obtenerSolicitudMasCercana(listaSolicitudes);
                    int posicionPasajeroMin = obtenerPasajeroMasCercano();
                    int distRecogida = Coordenada2D.calcularDistancia(listaSolicitudes.get(posicionSolicitudMin).getPosicionRecogida(), posicionActual);
                    int distLlevada = Coordenada2D.calcularDistancia(pasajeros.get(posicionPasajeroMin).getPosicionLlevada(), posicionActual);
                    int numPersonasSolicitud = listaSolicitudes.get(posicionSolicitudMin).getCantidadPersonas();
                    
                    
                    if(distRecogida<distLlevada && numPersonasSolicitud + cantidadPasajeros<=4) {
                    	 movimiento(listaSolicitudes.get(posicionSolicitudMin).getPosicionRecogida());
                         recoger(listaSolicitudes.get(posicionSolicitudMin));
                         
                         
                    }else {
                    	movimiento(pasajeros.get(posicionPasajeroMin).getPosicionLlevada());
                        llevar(pasajeros.get(posicionPasajeroMin));
                    }
                    
                    
                }else if(listaSolicitudes.isEmpty() && !pasajeros.isEmpty()){
                    System.out.println("Tercer caso solo pasajeros en el mapa");
                    int posicionPasajeroMin = obtenerPasajeroMasCercano();
                    movimiento(pasajeros.get(posicionPasajeroMin).getPosicionLlevada());
                    llevar(pasajeros.get(posicionPasajeroMin));
                    
                    
                }else if(listaSolicitudes.isEmpty() && pasajeros.isEmpty()){
                    System.out.println("Cuarto caso ni pasajeros ni solicitudes");
                    veces = false;
                    System.out.println("Gracias por jugar");
                }
            }
            
        }
        
        public int obtenerSolicitudMasCercana(ArrayList<Pasajero> listaSolicitudes) {
        	ArrayList<Integer> listaDistancias = new ArrayList<Integer>();
        	
        	
        	for(Pasajero pasajero:listaSolicitudes) {
            	int distancia = Coordenada2D.calcularDistancia(pasajero.getPosicionRecogida(), posicionActual);
            	listaDistancias.add(distancia);
            }
            int minimo = listaDistancias.get(0);
            
            
            for (int distancia:listaDistancias) {
            	int numPersonasSolicitud = listaSolicitudes.get(listaDistancias.indexOf(distancia)).getCantidadPersonas();
            	if(distancia<minimo && numPersonasSolicitud + cantidadPasajeros<=4) {
            		minimo = distancia;
            	}
            }
            int posicionSolicitudMin = listaDistancias.indexOf(minimo);
            return posicionSolicitudMin;
        }
        
        public int obtenerPasajeroMasCercano() {
        	ArrayList<Integer> listaDistancias = new ArrayList<Integer>();
        	for(Pasajero pasajero:pasajeros) {
            	int distancia = Coordenada2D.calcularDistancia(pasajero.getPosicionRecogida(), posicionActual);
            	listaDistancias.add(distancia);
            }
        	int minimo = listaDistancias.get(0);
            for (int distancia:listaDistancias) {
            	if(distancia<minimo) {
            		minimo=distancia;
            	}
            }
            int posicionPasajeroMin = listaDistancias.indexOf(minimo);
            return posicionPasajeroMin;	
        }
        
        public void movimiento(Coordenada2D posicionCercana){
            if(posicionActual.getX()<posicionCercana.getX()) {
            	for(int i=posicionActual.getX();i<posicionCercana.getX();i++) {
            		posicionActual.setX(posicionActual.getX()+1);
            		try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
            	}
            	
            }else {
            	for(int i=posicionActual.getX();i>posicionCercana.getX();i--) {
            		posicionActual.setX(posicionActual.getX()-1);
            		try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
            	}
            }
            
            if(posicionActual.getY()<posicionCercana.getY()) {
            	for(int i=posicionActual.getY();i<posicionCercana.getY();i++) {
            		posicionActual.setY(posicionActual.getY()+1);
            		try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
            	}
            	
            }else {
            	for(int i=posicionActual.getY();i>posicionCercana.getY();i--) {
            		posicionActual.setY(posicionActual.getY()-1);
            		try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
            	}
            }
            System.out.println("La posicion actual del taxi es: "+posicionActual.obtenerCoordenadas());
        }
        
        public void recoger(Pasajero pasajeroRecoger) {
        	pasajeros.add(pasajeroRecoger);
        	cantidadPasajeros = cantidadPasajeros + pasajeroRecoger.getCantidadPersonas();
        	System.out.println("voy a recoger al pasajero en "+pasajeroRecoger.getPosicionRecogida().obtenerCoordenadas());
        	System.out.println("La cantidad de pasajeros en el taxi es -----"+cantidadPasajeros+"-----");
        	Ciudad.getListaSolicitudes().remove(pasajeroRecoger);
        }
        
        public void llevar(Pasajero pasajeroLlevar) {
        	System.out.println("voy a llevar al pasajero en "+pasajeroLlevar.getPosicionLlevada().obtenerCoordenadas());
        	cantidadPasajeros = cantidadPasajeros - pasajeroLlevar.getCantidadPersonas();
        	System.out.println("La cantidad de pasajeros en el taxi es -----"+cantidadPasajeros+"-----");
        	pasajeros.remove(pasajeroLlevar);
        }

		
        
        public Integer getCantidadPasajeros() {
			return cantidadPasajeros;
		}

		public Coordenada2D getPosicionActual() {
			return posicionActual;
		}
        
        

        

}
