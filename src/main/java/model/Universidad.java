package model;
import Utils.ValidadorRut;

import java.util.ArrayList;
import java.util.List;
public class Universidad{
    private List<Estudiante> estudiantes;
    private List<Carrera> carreras;

public Universidad() {
    this.estudiantes=new ArrayList<Estudiante>();
    this.carreras= new ArrayList<Carrera>();
    }
    public List<Estudiante> getEstudiantes() {return estudiantes;}

    public List<Carrera> getCarreras() {return carreras;}

    public Estudiante buscarEstudiante(String rut) {
        Estudiante estudiante = null;
        for (Estudiante estudianteAux : this.estudiantes) {
            if (estudianteAux.getRut().equals(rut)) {
                estudiante = estudianteAux;
                break;
            }
        }
        return estudiante;
    }
    public Carrera buscarCarrera(String nombreCarrera){
        Carrera carrera = null;
        for (Carrera carreraAux : this.carreras) {
            if (carreraAux.getNombreCarrera().equals(nombreCarrera)) {
                carrera = carreraAux;
                break;
            }
        }
        return carrera;
    }
    public Carrera añadirCarrera(String nombreCarrera, CodigoCarrera codigoCarrera, int cantidadSemestres){
        Carrera carrera= new Carrera(nombreCarrera);
        this.carreras.add(carrera);
        return carrera;
    }
    public List<Carrera> buscarCarreraNombre(String nombre) {
        List<Carrera> carreras = new ArrayList<Carrera>();
        for (Carrera carrera : this.carreras) {
            if (carrera.getNombreCarrera().equals(nombre)) {
                carreras.add(carrera);
            }
        }
        return carreras;
    }
    public List<Estudiante> buscarEstudianteNombre(String nombre) {
        List<Estudiante> estudiantes = new ArrayList<Estudiante>();
        for (Estudiante estudiante : this.estudiantes) {
            if (estudiante.getNombre().equals(nombre)) {
                estudiantes.add(estudiante);
            }
        }
        return estudiantes;
    }

    public boolean añadirEstudiante(String nombre,String rut,String apellido,int numeroMatricula) {
        if (ValidadorRut.validarDigito(rut) && this.buscarEstudiante(rut)==null) {
            Estudiante estudiante= new Estudiante(nombre,rut,apellido);
            this.estudiantes.add(estudiante);
            return true;
        } else {
            return false;
        }
    }
}