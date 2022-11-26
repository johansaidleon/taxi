package model;

public class Coordenada2D {
	
	private Integer x;
	private Integer y;
	
	public Coordenada2D(Integer x,Integer y) {
		this.x = x;
		this.y = y;
	}
	
	public Coordenada2D() {
		x = (int) Math.round(Math.random()*800);
		y = (int) Math.round(Math.random()*800);
	}
	
	public String obtenerCoordenadas() {
		String posicion = "("+x+","+y+")";
		return posicion;
	}
        
    public static Integer calcularDistancia(Coordenada2D posA, Coordenada2D posB){
        Integer distancia = Math.abs(posB.getX()-posA.getX())+Math.abs(posB.getY()-posA.getY());
        return distancia;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }
    
    public void setX(Integer x) {
    	this.x = x;
    }

	public void setY(Integer y) {
		this.y = y;
	}

}
