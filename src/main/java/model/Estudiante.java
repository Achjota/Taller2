package model;

public class Estudiante {
	private String nombre;
	private String rut;
	private String apellido;
	private int numeroMatricula;
	private Carrera carrera;
	public Cliente(String nombre, String rut, String apellido,int numeroMatricula) {
		super(nombre,rut);
		this.apellido = apellido;
		this.numeroMatricula = numeroMatricula ;}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre() {
		this.nombre=nombre;
	}

	public String getRut() {
		return this.rut;
	}

	public void setRut() {this.rut=rut;}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido() {
		this.apellido= apellido;
	}

	public int getNumeroMatricula() {
		return this.numeroMatricula;
	}

	public void setNumeroMatricula() {
		this.numeroMatricula=numeroMatricula;
	}
}