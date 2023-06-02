package modelo.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "empleados") // Es posible que no necesitemos una tabla, ya veremos....
@Inheritance(strategy = InheritanceType.JOINED) // A ver si funciona...
public class Empleado implements Serializable { //antes era clase abstracta

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String nombre;

	private String apellidos;

	private String email;

	private float sueldo;

	// Empleado es el "dueño/propietario" de Desarrollador y JefeEquipo, por tanto,
	// debe poner name y no mappedby
	// porque mappedBy debe ir en Desarrollador y JefeEquipo para que su dueño sea
	// mapeado por su
	// propiedad en este caso Desarro.... y JefeEquipo. Esto es para los casos
	// OneToOne.

	@OneToMany(mappedBy = "empleado")
	private List<Desarrollador> desarrolladores;

	@OneToMany(mappedBy = "empleado")
	private List<JefeEquipo> jefesEquipos;;

	public Empleado() {
		super();
	}
	
	// Constructor para no tener problemas a la hora hacer referencia a esta clase desde las demas clases que solo necesitan el id
	public Empleado(Integer id) {
		super();
		this.id = id;
	}

	// Debemos crear tambien un constructor que no esté vacío

	public Empleado(Integer id, String nombre, String apellidos, String email, float sueldo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.sueldo = sueldo;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	public List<Desarrollador> getDesarrolladores() {
		return desarrolladores;
	}

	public void setDesarrolladores(List<Desarrollador> desarrolladores) {
		this.desarrolladores = desarrolladores;
	}

	public List<JefeEquipo> getJefesEquipos() {
		return jefesEquipos;
	}

	

}