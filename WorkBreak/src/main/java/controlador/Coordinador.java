package controlador;

import java.awt.Window;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modelo.entidad.Desarrollador;
import modelo.entidad.Empleado;
import modelo.entidad.JefeEquipo;
import modelo.entidad.Proyecto;
import modelo.procesos.ProcesosLogicos;

import vista.VentanaEmpleados;
import vista.VentanaDesarrolladores;
import vista.VentanaJefesEquipo;
import vista.VentanaLogin;
import vista.VentanaMenu;
import vista.VentanaProyectos;

import java.util.*;

/**
 * 
 * @author Jennifer y Alejandro.
 * 
 *         Esta clase será el intermediario para delegar funciones a quien
 *         corresponda para aprovechar la potencia del MVC.
 *
 */
public class Coordinador {

	private Empleado empleado;
	private Desarrollador desarrollador;
	private JefeEquipo jefeEquipo;
	private Proyecto proyecto;

	private ProcesosLogicos procesosLogicos;

	private VentanaLogin ventanaLogin;
	private VentanaMenu ventanaMenu;
	private VentanaEmpleados ventanaEmpleados;
	private VentanaDesarrolladores ventanaDesarrolladores;
	private VentanaJefesEquipo ventanaJefesEquipo;
	private VentanaProyectos ventanaProyectos;

	private ProcesosBBDD procesosBBDD;

	public void setVentanaLogin(VentanaLogin ventanaLogin) {
		this.ventanaLogin = ventanaLogin;

	}

	public void setVentanaMenu(VentanaMenu ventanaMenu) {
		this.ventanaMenu = ventanaMenu;

	}

	public void setVentanaEmpleados(VentanaEmpleados ventanaEmpleados) {
		this.ventanaEmpleados = ventanaEmpleados;
	}

	public void setVentanaDesarrolladores(VentanaDesarrolladores ventanaDesarrolladores) {
		this.ventanaDesarrolladores = ventanaDesarrolladores;

	}

	public void setVentanaJefesEquipo(VentanaJefesEquipo ventanaJefesEquipo) {
		this.ventanaJefesEquipo = ventanaJefesEquipo;
	}

	public void setVentanaProyectos(VentanaProyectos ventanaProyectos) {
		this.ventanaProyectos = ventanaProyectos;
	}

	public void setProcesosLogicos(ProcesosLogicos procesosLogicos) {
		this.procesosLogicos = procesosLogicos;

	}

	/**
	 * Hacemos visibles o invisibles las distintas ventanas ventanas
	 */
	public void activarVentanaLogin() {
		ventanaLogin.setVisible(true);

	}

	public void desactivarVentanaLogin() {
		ventanaLogin.setVisible(false);

	}

	public void activarVentanaMenu() {
		ventanaMenu.setVisible(true);
	}

	public void activarVentanaEmpleados() {
		ventanaEmpleados.setVisible(true);

	}

	public void activarVentanaDesarrolladores() {
		ventanaDesarrolladores.setVisible(true);
	}

	public void activarVentanaJefesEquipo() {
		ventanaJefesEquipo.setVisible(true);

	}

	public void activarVentanaProyectos() {
		ventanaProyectos.setVisible(true);
	}

	// Mejorar en la clase ProcesosLogicos
	public void botonSalir() {
		procesosLogicos.salirApp();
	}

	public void setProcesosBBDD(ProcesosBBDD procesosBBDD) {
		this.procesosBBDD = procesosBBDD;

	}

	public void guardarEmpleadoEnBBDD(Empleado empleado) {
		procesosBBDD.ingresarEmpleado(empleado);

	}

	public List<Empleado> recuperarEmpleadoBBDD(String id) {

		return procesosBBDD.recuperarEmpleado(id);
	}

	public List<Empleado> listaEmpleadosBBDD() {

		return procesosBBDD.listadoEmpleados();

	}
	
	public void modificarEmpleadoEnBBDD(Empleado empleado) {
		procesosBBDD.modificarEmpleado(empleado);
		
	}

	public List<Empleado> eliminarEmpleadoBBDD(String id) {

		return procesosBBDD.eliminarEmpleado(id);
	}
	
	public void guardarDesarrolladorEnBBDD(Desarrollador desarrollador) {
		procesosBBDD.ingresarDesarrollador(desarrollador);

	}

	public List<Desarrollador> listaDesarrolladoresBBDD() {

		return procesosBBDD.listadoDesarrolladores();
	}
	
	public List<Desarrollador> recuperarDesarrolladorBBDD(String id) {

		return procesosBBDD.recuperarDesarrollador(id);
	}

	public void modificarDesarrolladorEnBBDD(Desarrollador desarrollador) {
		procesosBBDD.modificarDesarrollador(desarrollador);
	}
	
	public List<Desarrollador> recuperarDesarrolladorPorJefeIdBBDD(String jefeId) {
		return procesosBBDD.recuperarDesarrolladorPorJefeId(jefeId);
	}

	public List<Desarrollador> recuperarDesarrolladorPorProyectoIdBBDD(String proyectoId) {
		return procesosBBDD.recuperarDesarrolladorPorProyectoId(proyectoId);
	}
	
	public List<Desarrollador> eliminarDesarrolladorPorIdBBDD(String id){
		return procesosBBDD.eliminarDesarrollador(id);
	}

	public void guardarJefesdeEquipoEnBBDD(JefeEquipo jefeEquipo) {
		procesosBBDD.ingresarJefeEquipo(jefeEquipo);

	}

	public List<JefeEquipo> listaJefesEquipoBBDD() {

		return procesosBBDD.listadoJefesEquipo();
	}

	public List<JefeEquipo> recuperarJefeEquipoBBDD(String id) {

		return procesosBBDD.recuperarJefeEquipo(id);
	}
	
	public void modificarJefeEquipoEnBBDD(JefeEquipo jefeEquipo) {
		procesosBBDD.modificarJefeEquipo(jefeEquipo);
		
	}
	
	public List<JefeEquipo> eliminarJefeEquipoPorIdBBDD(String id) {
		return procesosBBDD.eliminarJefeEquipo(id);
	}

	public List<Proyecto> listaProyectosBBDD() {

		return procesosBBDD.listadoProyectos();
	}
	
	public void guardarProyectoEnBBDD(Proyecto proyecto) {
		procesosBBDD.ingresarProyecto(proyecto);

	}
	
	public List<Proyecto> recuperarProyectoBBDD(String id) {

		return procesosBBDD.recuperarProyecto(id);
	}
	
	public List<Proyecto> recuperarProyectoPorJefeIdBBDD(String jefeId) {
		return procesosBBDD.recuperarProyectoPorJefeId(jefeId);
	}
	
	public void modificarProyectoEnBBDD(Proyecto proyecto) {
		procesosBBDD.modificarProyecto(proyecto);
		
	}

	public List<Proyecto> eliminarProyectoBBDD(String id) {
		
		return procesosBBDD.eliminarProyecto(id);
	}

	


}
