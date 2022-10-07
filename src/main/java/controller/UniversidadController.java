package controller;

import data.GestorDatos;
import model.*;
import model.Carrera;
import model.Estudiante;
import model.Universidad;
import model.CodigoCarrera;
public class UniversidadController {
	public static Universidad cargaMasivaDatos(Universidad universidad) {
		GestorDatos.leerArchivoEstudiantes(universidad, "estudiantes.txt");
		GestorDatos.leerArchivoCarreras(universidad, "carreras.txt");
		return universidad;
	}

	public static void almacenarDatos(Universidad universidad) {
		GestorDatos.registrarDatos(universidad.getEstudiantes(), "estudiantes.txt");
		GestorDatos.registrarDatos(universidad.getCarreras(), "carreras.txt");
	}
}