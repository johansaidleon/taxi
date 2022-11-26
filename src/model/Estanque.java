package model;

public class Estanque extends Contenedor {
	
	private Reserva reserva;

	
	public Estanque() {
	}

	public Estanque(Reserva reserva, int capacidad, int contenido) {
		super(capacidad, contenido);
		this.reserva = reserva;
	}


	

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	
	public String recargarCombustible(int litros){
		setContenido(getContenido()+ litros);
		if (getContenido()<= getCapacidad()) {
			return "recarga realizada ahora posee"+ getContenido ()+ "Lts.";
			
		}else {
			int exceso = getContenido()-getCapacidad();
			setContenido(getCapacidad());
			reserva.setContenido(reserva.getContenido()+exceso);
			if (reserva.getContenido()<=reserva.getCapacidad()) {
				return "estanque lleno, con reserva de"+reserva.getContenido()+"Lts.";
			}else {
				int perdida = exceso-reserva.getCapacidad(); 
				reserva.setContenido(reserva.getCapacidad());
				return "Estanque y reserva completos, pero se perdieron"+ perdida + "Lts.";
				
			}
		}
	}
}
