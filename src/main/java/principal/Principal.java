package principal;

import controller.UniversidadController;
import gui.VentanaBienvenida;
import model.Universidad;

public class Principal {
    public static void main(String[] args) {
        Universidad universidad= new Universidad();
        Universidad Universidad= UniversidadController.cargaMasivaDatos(universidad);
        VentanaBienvenida ventana=new VentanaBienvenida(Universidad);
    }
}