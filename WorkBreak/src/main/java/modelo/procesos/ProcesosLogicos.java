package modelo.procesos;

import javax.swing.JOptionPane;

import controlador.Coordinador;

/**
 * 
 * @author Jennifer y Alejandro.
 * 
 *         En esta clase llevaremos a cabo todos los procesos de lógica.
 *
 */
public class ProcesosLogicos {

	private Coordinador miCoordinador;

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;

	}

	public void salirApp() {
		int result = JOptionPane.showConfirmDialog(null, "¿Salir?", null, JOptionPane.YES_NO_OPTION);
		
		if (result == JOptionPane.YES_OPTION) {
			System.exit(1);
		}

	}

}
