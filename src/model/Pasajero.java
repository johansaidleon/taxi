package model;

public class Pasajero {
	
        private Coordenada2D posicionRecogida;
        private Coordenada2D posicionLlevada;
        private int cantidadPersonas;

        public Pasajero() {
                posicionRecogida = new Coordenada2D();
                posicionLlevada = new Coordenada2D();
                cantidadPersonas = (int) Math.round(Math.random()*(4-1)+1);
        }
        public String getInfoPasajero(){
            String infoPasajero = "Recoger: "+posicionRecogida.obtenerCoordenadas()
                    +" ---llevar: "+posicionLlevada.obtenerCoordenadas()
                    +" ---num personas: "+cantidadPersonas
                    +" ---distancia total a recorrer: "+Coordenada2D.calcularDistancia(posicionRecogida, posicionLlevada);
            
            return infoPasajero;
        }

        public Coordenada2D getPosicionRecogida() {
            return posicionRecogida;
        }

        public Coordenada2D getPosicionLlevada() {
            return posicionLlevada;
        }

        public int getCantidadPersonas() {
            return cantidadPersonas;
        } 
}
