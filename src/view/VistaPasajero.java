package view;

import java.awt.Image;

import javax.swing.ImageIcon;

public class VistaPasajero {
	
	private String ruta;
	private ImageIcon recurso;
	Image imagen;
	
	public Image getImage() {
		ruta = "/recursos/ImageneSolicitudes/Soli11.png";
		recurso = new ImageIcon(this.getClass().getResource(ruta));
		imagen = recurso.getImage();
		return imagen;
	}

}
