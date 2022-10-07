package model;

public enum NombreEstudiante {
    Jorge("Jorge")

    private String nombreEstudiante;

    private NombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }
}
