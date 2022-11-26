package view;

import java.awt.Image;

import javax.swing.ImageIcon;

public class VistaCiudad {
	
	private String ruta;
	private ImageIcon recurso;
	Image imagen;
	
	public Image getImage() {
		ruta = "/recursos/mapa_ciudad.jpg";
		recurso = new ImageIcon(this.getClass().getResource(ruta));
		imagen = recurso.getImage();
		return imagen;
	}

}
