package view;

import javax.swing.JFrame;

public class Ventana extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public Ventana() {
		setVisible(true);
		setTitle("Simulador del taxi");
		setSize(900,910);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
