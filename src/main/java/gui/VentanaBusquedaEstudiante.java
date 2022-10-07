package gui;

import controller.UniversidadController;
import model.Estudiante;
import model.NombreEstudiante;
import model.Universidad;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class VentanaBusquedaEstudiante extends Ventana{
	private UniversidadController universidadController;
	private Universidad universidad;
	private JButton botonBuscar, botonRegresar;
	private JLabel textoEncabezado, textoNombre, textoEstudiante;
	private JComboBox listaEstudiante;
	private JTextField campoNombre;

	public VentanaBusquedaEstudiante(Universidad universidad) {
		super("Búsqueda de Estudiante", 500, 520);
		this.universidad = universidad;
		generarElementosVentana();
	}
	private void generarElementosVentana() {
		generarCampoNombre();
		generarBotonBuscarEstudiante();
		generarBotonCancelar();
		generarListaEstudiante();
	}
	private void generarCampoNombre(){
		String textoNombre= "Nombre Estudiante:";
		super.generarJLabel(this.textoNombre,textoNombre,20,50,150,20);
		this.campoNombre= super.generarJTextField(200,50,250,20);
		this.add(this.campoNombre);
	}
	private void generarListaEstudiante(){
		super.generarJLabel(this.textoEstudiante,"Lista Estudiante:",20,100,100,20);
		this.listaEstudiante=super.generarListaDesplegable(NombreEstudiante.values(),120,100, 100, 20);
		this.add(this.listaEstudiante);
	}
	private void generarBotonBuscarEstudiante() {
		String textoBoton= "Buscar Estudiante";
		this.botonBuscar = super.generarBoton(textoBoton, 75, 400, 150, 20);
		this.add(this.botonBuscar);
		this.botonBuscar.addActionListener(this);
	}
	private void generarBotonCancelar() {
		String textoBotonRegresar = "Regresar";
		this.botonRegresar = super.generarBoton(textoBotonRegresar, 275, 400, 150, 20);
		this.add(this.botonRegresar);
		this.botonRegresar.addActionListener(this);
	}
	private String[][] registrarEstudiante(){
		List<Estudiante> estudiantes= new ArrayList<>();
		String[][] datosEstudiantes;
		if(this.campoNombre.getText().length()==0){
			System.out.println(this.listaEstudiante.getSelectedItem());
			estudiantes= universidad.buscarEstudianteNombre((NombreEstudiante) this.listaEstudiante.getSelectedItem());
		}
		else{
			estudiantes= universidad.buscarEstudianteNombre(this.campoNombre.getText());
		}
		System.out.println(estudiantes.size());
		datosEstudiantes= new String[estudiantes.size()][6];
		for(int i=0; i<estudiantes.size(); i++){
			datosEstudiantes[i][0]=estudiantes.get(i).getNombre();
			datosEstudiantes[i][1]=estudiantes.get(i).getRut();
			datosEstudiantes[i][2]= Integer.toString(estudiantes.get(i).getNumeroMatricula());
			datosEstudiantes[i][3]=estudiantes.get(i).getApellido();
		}
		return datosEstudiantes;
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.botonBuscar){
			String[] nombreColumnas={"Nombre","Rut","Numero Matricula","Apellido"};
			VentanaTabla ventanaTabla= new VentanaTabla(registrarEstudiante(),nombreColumnas);
		}
		if (e.getSource() == this.botonRegresar){
			VentanaBusquedaEstudiante ventanaBusquedaEstudiante = new VentanaBusquedaEstudiante(universidad);
			this.dispose();
		}

	}
}