package modelo.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
//@PrimaryKeyJoinColumn(referencedColumnName = "id")
@Table(name = "desarrolladores")
public class Desarrollador extends Empleado implements Serializable {

	// Establecemos relacion bidireccional con Proyecto, JefeEquipo y Empleado.

	@ManyToOne
	@JoinColumn(name = "id_proyecto", referencedColumnName = "id")
	private Proyecto proyecto; // ManyToOne

	@ManyToOne
	@JoinColumn(name = "id_jefeEquipo", referencedColumnName = "id")
	private JefeEquipo jefeEquipo; // ManyToOne

	@ManyToOne
	@JoinColumn(name = "id_empleado", referencedColumnName = "id")
	private Empleado empleado;

	public Desarrollador() {
		super();
	}
	
	public Desarrollador(Integer id) {
		super(id);
	}
	
	// Usamos este constructor cuando fichemos a un desarrollador pero aun no sabemos que jefe ni que proyecto
	// se le va a asignar.
	public Desarrollador(Integer id, String nombre, String apellidos, String email, float sueldo) {
		super(id, nombre, apellidos, email, sueldo);
	}


	// Usamos este constructor cuando queramos asignarle un Jefe de Equipo
	public Desarrollador(Integer id, String nombre, String apellidos, String email, float sueldo, JefeEquipo jefeEquipo) {
		super(id, nombre, apellidos, email, sueldo);
		this.jefeEquipo = jefeEquipo;
	}

	// Usamos este constructor cuando queramos asignarle un proyecto
	public Desarrollador(Integer id, String nombre, String apellidos, String email, float sueldo, Proyecto proyecto) {
		super(id, nombre, apellidos, email, sueldo);
		this.proyecto = proyecto;
	}

	// Usamos este constructor cuando queramos asignarle un Jefe de Equipo y un Proyecto
	public Desarrollador(Integer id, String nombre, String apellidos, String email, float sueldo, JefeEquipo jefeEquipo,
			Proyecto proyecto) {
		super(id, nombre, apellidos, email, sueldo);
		this.jefeEquipo = jefeEquipo;
		this.proyecto = proyecto;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public JefeEquipo getJefeEquipo() {
		return jefeEquipo;
	}

	public void setJefeEquipo(JefeEquipo jefeEquipo) {
		this.jefeEquipo = jefeEquipo;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

}
