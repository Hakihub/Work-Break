package controlador;

import modelo.procesos.ProcesosLogicos;
import vista.VentanaLogin;
import vista.VentanaMenu;
import vista.VentanaProyectos;
import vista.VentanaEmpleados;
import vista.VentanaDesarrolladores;
import vista.VentanaJefesEquipo;

/**
 * 
 * @author Jennifer y Alejandro.
 * 
 *         Creamos este método para iniciar todas las relaciones establecidas
 *         entre clases. Además evitaremos que se creer nuevos objetos que
 *         cuando en realidad necesitamos un unico objeto de cada clase y
 *         evitamos ocupar memoria innecesaria porque dificultaría la
 *         escalabilidad del proyecto.
 *
 */

public class Relaciones {

	// Instanciamos las clases de forma unica.
	public void iniciar() {
		VentanaLogin ventanaLogin = new VentanaLogin();
		VentanaMenu ventanaMenu = new VentanaMenu();
		VentanaEmpleados ventanaEmpleados = new VentanaEmpleados();
		VentanaDesarrolladores ventanaDesarrolladores = new VentanaDesarrolladores();
		VentanaJefesEquipo ventanaJefesEquipo = new VentanaJefesEquipo();
		VentanaProyectos ventanaProyectos = new VentanaProyectos();

		ProcesosLogicos procesosLogicos = new ProcesosLogicos();
		ProcesosBBDD procesosBBDD = new ProcesosBBDD();
		
		Coordinador miCoordinador = new Coordinador();
		
		
		// Se establecen las relaciones entre clases.

		ventanaLogin.setCoordinador(miCoordinador);
		ventanaMenu.setCoordinador(miCoordinador);
		ventanaEmpleados.setCoordinador(miCoordinador);
		ventanaDesarrolladores.setCoordinador(miCoordinador);
		ventanaJefesEquipo.setCoordinador(miCoordinador);
		ventanaProyectos.setCoordinador(miCoordinador);
		
		
		procesosLogicos.setCoordinador(miCoordinador);
		procesosBBDD.setCoordinador(miCoordinador);
		
		
		// Se establecen las relaciones con nuestro coordinador/intermediario
		
		miCoordinador.setVentanaLogin(ventanaLogin);
		miCoordinador.setVentanaMenu(ventanaMenu);
		miCoordinador.setVentanaEmpleados(ventanaEmpleados);
		miCoordinador.setVentanaDesarrolladores(ventanaDesarrolladores);
		miCoordinador.setVentanaJefesEquipo(ventanaJefesEquipo);
		miCoordinador.setVentanaProyectos(ventanaProyectos);
		
		miCoordinador.setProcesosLogicos(procesosLogicos);
		miCoordinador.setProcesosBBDD(procesosBBDD);
		
		
		miCoordinador.activarVentanaLogin();
		
		
	}
}
