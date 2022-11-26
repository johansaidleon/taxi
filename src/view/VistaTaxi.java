package view;

import java.awt.Image;

import javax.swing.ImageIcon;

public class VistaTaxi {
	
	private String ruta;
	private ImageIcon recurso;
	Image imagen;
	
	public Image getImage() {
		ruta = "/recursos/ImagenesTaxi/Dr01.png";
		recurso = new ImageIcon(this.getClass().getResource(ruta));
		imagen = recurso.getImage();
		return imagen;
	}

}
