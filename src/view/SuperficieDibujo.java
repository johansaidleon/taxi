package view;


import java.awt.Graphics;
import javax.swing.JPanel;

import model.Taxi;

@SuppressWarnings("serial")
public class SuperficieDibujo extends JPanel{

	private final VistaCiudad vistaciudad;
	private final VistaTaxi vistataxi;
	private final VistaPasajero vistapasajero;
	private Taxi elTaxi; 
	
	
	public SuperficieDibujo(Taxi elTaxi) {
		this.vistaciudad = new VistaCiudad();
		this.vistataxi = new VistaTaxi();
		this.vistapasajero = new VistaPasajero();
		this.elTaxi = elTaxi;
	}
	
	public void paint(Graphics g) {
		g.drawImage(vistaciudad.getImage(),0,0,880,880,null);
		g.drawImage(vistataxi.getImage(),elTaxi.getPosicionActual().getX(),elTaxi.getPosicionActual().getY(),null);
		//g.drawImage(vistapasajero.getImage(),70,70,80,80,null);
		repintar();
	}
	public void repintar() {
		repaint();
	}
}
