package model;

public class Carrera {
	private String nombreCarrera;
	private String codigoCarrera;
	private int cantidadSemestres;

	public String getNombreCarrera() {
		return this.nombreCarrera;
	}

	public void setNombreCarrera() {
		this.nombreCarrera=nombreCarrera;
	}

	public String getCodigoCarrera() {
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