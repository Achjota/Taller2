package model;
import Utils.ValidadorRut;

import java.awt.*;
import java.io.CharArrayReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Universidad {
    private List<Estudiante> estudiantes;
    private List<Carrera> carreras;

public Universidad() {
    this.estudiantes=new ArrayList<Estudiante>;
    this.carreras= new ArrayList<Carrera>;
    }
    public List<Estudiante> getEstudiantes() {return estudiantes;}

    public List<Carrera> getCarreras() {return carreras;}

    public Estudiante buscarEstudiante(String rut) {
        Estudiante estudiante = null;
        for (Estudiante estudianteAux : this.estudiantes) {
            if (estudianteAux.getRut().equals(rut)) {
                estudiantes = estudianteAux;
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
    public boolean añadirVendedor(String nombre, String rut,String apellido) {
        if (ValidadorRut.validarDigito(rut) && this.buscarEstudiante(rut)==null) {
            Estudiante vendedor = new Estudiante(nombre, rut, apellido);
            this.estudiantes.add(estudiantes);
            return true;
        } else {
            return false;
        }
    }

}