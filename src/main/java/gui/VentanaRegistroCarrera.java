package gui;

import controller.UniversidadController;
import model.CodigoCarrera;
import model.NombreEstudiante;
import model.Universidad;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.text.InternationalFormatter;
import java.awt.event.ActionEvent;

public class VentanaRegistroCarrera extends Ventana{
	private UniversidadController universidadController;
	private JLabel textoEncabezado,textoNombreCarrera,textoCodigoCarrera,textoCantidadSemestre;
	private JTextField campoNombreCarrera, campoCodigoCarrera, campoCantidadSemestres;
	private JButton botonRegistrar, botonCancelar;
	private JComboBox listaCarreras;
	private Universidad universidad;

	private void generarEncabezado() {
		String textoCabecera = "Registro de Carreras";
		super.generarJLabelEncabezado(this.textoEncabezado, textoCabecera, 190, 10, 200, 50);

	}
	public VentanaRegistroCarrera(Universidad universidad){
		super("Registro de Carreras");
		this.universidad = universidad;
		generarElementosVentana();

	}
	private void generarElementosVentana() {
		generarEncabezado();
		generarCampoNombreCarrera();
		generarCampoCodigoCarrera();
		generarCampoCantidadSemestre();
		generarBotonRegistrar();
		generarBotonCancelar();
		generarListaCarreras();
	}
	private void generarListaCarreras(){
		super.generarJLabel(this.textoNombreCarrera,"Nombre Carrera:",20,100,100,20);
		String [] arreglo = new String[]{"ICI","ICI-I"};
		this.listaCarreras=super.generarListaDesplegable(arreglo,120,100, 100, 20);
		this.add(this.listaCarreras);
	}
	private void generarBotonRegistrar() {
		String textoBoton= "Registrar Carrera";
		this.botonRegistrar = super.generarBoton(textoBoton, 75, 400, 150, 20);
		this.add(this.botonRegistrar);
		this.botonRegistrar.addActionListener(this);
	}
	private void generarBotonCancelar() {
		String textoBotonCancelar = "Cancelar";
		this.botonCancelar = super.generarBoton(textoBotonCancelar, 275, 400, 150, 20);
		this.add(this.botonCancelar);
		this.botonCancelar.addActionListener(this);
	}
	private void generarCampoNombreCarrera(){
		String textoNombre= "Nombre Carrera:";
		super.generarJLabel(this.textoNombreCarrera,textoNombre,20,50,150,20);
		this.campoNombreCarrera= super.generarJTextField(200,50,250,20);
		this.add(this.campoNombreCarrera);
	}
	private void generarCampoCodigoCarrera() {
		super.generarJLabel(this.textoCodigoCarrera, "A??o:", 20, 150, 200, 20);
		InternationalFormatter formato = super.generarFormato(1950);
		this.campoCodigoCarrera = super.generarJFormattedTextField(formato, 200, 150, 250, 20);
		this.add(this.campoCodigoCarrera);
	}
	private void generarCampoCantidadSemestre(){
		super.generarJLabel(this.textoCantidadSemestre, "Precio:", 20, 200, 200, 20);
		InternationalFormatter formato = super.generarFormato(0);
		this.campoCantidadSemestres = super.generarJFormattedTextField(formato, 200, 200, 250, 20);
		this.add(this.campoCantidadSemestres);
	}
	private boolean registrarCarrera(){
		if(this.campoNombreCarrera.getText().length()==0 || this.campoCodigoCarrera.getText().length()==0 ||
				this.campoCantidadSemestres.getText().length()==0){
			return false;
		   }
		  else{

			return true;
		  }
	  }

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.botonRegistrar){
			if(registrarCarrera()){
				universidad.a??adirCarrera(this.campoNombreCarrera.getText(),(CodigoCarrera) this.listaCarreras.getSelectedItem(),Integer.parseInt(this.campoCantidadSemestres.getText()));
				JOptionPane.showMessageDialog(this,"Carrera Registrada Correctamente","Mensaje de confirmaci??n",JOptionPane.INFORMATION_MESSAGE);
				VentanaBienvenida ventanaMenuBienvenida = new VentanaBienvenida(universidad);
				this.dispose();
			}
			else{
				JOptionPane.showMessageDialog(this,"Complete todos los datos", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == this.botonCancelar){
			VentanaBienvenida ventanaMenuBienvenida = new VentanaBienvenida(universidad);
			this.dispose();
		}

	}
}