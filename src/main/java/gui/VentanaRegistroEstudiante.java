package gui;

import controller.UniversidadController;
import model.Universidad;
import javax.swing.text.InternationalFormatter;
import javax.swing.*;
import java.awt.event.ActionEvent;
import gui.Ventana.*;

public class VentanaRegistroEstudiante extends Ventana{
	private UniversidadController universidadController;
	private JLabel textoEncabezado, textoRut, textoNombre, textoApellido, textoNumeroMatricula, textoCarrera;
	private JTextField campoRut, campoNombre, campoApellido, campoNumeroMatricula, campoCarrera;
	private JButton botonRegistrar, botonCancelar;
	private Universidad universidad;

	public VentanaRegistrarCliente(Universidad universidad){
		super("Registro de Estudiante", 500, 520);
		this.universidad= universidad;
		generarElementosVentana();
	}
	private void generarElementosVentana() {
		generarEncabezado();
		generarBotonCancelar();
		generarBotonRegistrar();
		generarCampoApellido();
		generarCampoNombre();
		generarCampoNumeroMatricula();
		generarCampoRut();
		generarCampoCarrera();
	}
	private void generarEncabezado() {
		String textoCabecera = "Registro de Estudiante";
		super.generarJLabelEncabezado(this.textoEncabezado, textoCabecera, 190, 10, 200, 50);
	}
	private void generarBotonRegistrar() {
		String textoBoton= "Registrar Estudiante";
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
	private void generarCampoNombre(){
		String textoNombre= "Nombre:";
		super.generarJLabel(this.textoNombre,textoNombre,20,50,150,20);
		this.campoNombre= super.generarJTextField(200,50,250,20);
		this.add(this.campoNombre);
	}
	private void generarCampoRut(){
		String textoRut= "Rut:";
		super.generarJLabel(this.textoRut,textoRut,20,100,150,20);
		this.campoRut= super.generarJTextField(200,100,250,20);
		this.add(this.campoRut);
	}
	private void generarCampoApellido(){
		String textoDireccion= "Apellido:";
		super.generarJLabel(this.textoApellido,textoDireccion,20,150,150,20);
		this.campoApellido= super.generarJTextField(200,150,250,20);
		this.add(this.campoApellido);
	}
	private void generarCampoCarrera(){
		String textoCorreo= "Carrera:";
		super.generarJLabel(this.textoCarrera,textoCorreo,20,200,150,20);
		this.campoCarrera= super.generarJTextField(200,200,250,20);
		this.add(this.campoCarrera);
	}
	private void generarCampoNumeroMatricula(){
		String textoNumero= "Número Matricula:";
		super.generarJLabel(this.textoNumeroMatricula,textoNumero,20,250,150,20);
		this.campoNumeroMatricula= super.generarJTextField(200,250,250,20);
		this.add(this.campoNumeroMatricula);
	}
	private boolean registrarEstudiante(){
		return universidad.añadirEstudiante(this.campoNombre.getText(),this.campoNombre.getText(),this.campoRut.getText(),
				this.campoNumeroMatricula.getText(), this.campoRut.getText());
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.botonRegistrar) {
			if(registrarEstudiante()) {
				JOptionPane.showMessageDialog(this,"Estudiante registrado correctamente");
				VentanaBienvenida ventanaBienvenida = new VentanaBienvenida(universidad);
				this.dispose();
			}
			else{
				JOptionPane.showMessageDialog(this,"Ingrese un rut válido");
			}

		}
		if (e.getSource() == this.botonCancelar){
			VentanaBienvenida ventanaBienvenida = new VentanaBienvenida(universidad);
			this.dispose();
		}

	}
}