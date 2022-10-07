package model;

public enum CodigoCarrera {
    Ici("ICI");
    private String codigoCarrera;
    private CodigoCarrera(String codigoCarrera ){
        this.codigoCarrera= codigoCarrera;
    }

    public String getCodigoCarrera() {
        return codigoCarrera;
    }
    }
