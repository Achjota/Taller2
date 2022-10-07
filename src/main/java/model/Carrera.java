package model;

public class Carrera {
	private String nombreCarrera;
	private CodigoCarrera codigoCarrera;
	private int cantidadSemestres;

	public Carrera(String nombreCarrera){
		this.nombreCarrera=nombreCarrera;
				this.codigoCarrera=codigoCarrera;
				this.cantidadSemestres=cantidadSemestres;}

	public String getNombreCarrera() {
		return this.nombreCarrera;
	}

	public void setNombreCarrera() {
		this.nombreCarrera=nombreCarrera;
	}

	public CodigoCarrera getCodigoCarrera() {
		return this.codigoCarrera;
	}

	public void setCodigoCarrera() {
		this.codigoCarrera=codigoCarrera;
	}

	public int getCantidadSemestres() {
		return this.cantidadSemestres;
	}

	public void setCantidadSemestres() {this.cantidadSemestres=cantidadSemestres;}
}