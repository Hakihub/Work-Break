package modelo.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
//@PrimaryKeyJoinColumn(referencedColumnName = "id")
@Table(name = "jefes")
public class JefeEquipo extends Empleado implements Serializable {


	private String especialidad;
	
	@ManyToOne
	@JoinColumn(name = "id_empleado", referencedColumnName = "id")
	private Empleado empleado;

	@OneToMany(mappedBy = "jefeEquipo", cascade = CascadeType.PERSIST)
	private List<Desarrollador> desarrolladores;

	@OneToMany(mappedBy = "jefeEquipo", cascade = CascadeType.PERSIST)
	private List<Proyecto> proyectos; // "proyectos" va a ser la forma de hacer mappedBy en Proyectos

	public JefeEquipo() {
		super();
	}

	// Debemos crear tambien un constructor que no esté vacío

	
	/*
	public JefeEquipo(Integer id, String nombre, String apellidos, String email, float sueldo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.sueldo = sueldo;
	}
	/*
	public JefeEquipo(Integer id, String nombre, String apellidos, String email, float sueldo, Empleado empleado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.sueldo = sueldo;
	}
*/
	
	public JefeEquipo(Integer id, String nombre, String apellidos, String email, float sueldo, String especialidad) {
		super(id, nombre, apellidos, email, sueldo);
		this.especialidad = especialidad;
	}
	
	public JefeEquipo(Integer id) {
		super(id);
	}

	
	/*
	public JefeEquipo(Integer id, String nombre, String apellidos, String email, float sueldo, Empleado empleado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.sueldo = sueldo;
		
	}
	*/
	
	
	

	
	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public List<Desarrollador> getDesarrolladores() {
		return desarrolladores;
	}

	public void setDesarrolladores(List<Desarrollador> desarrolladores) {
		this.desarrolladores = desarrolladores;
	}

	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}



}
