package modelo.entidad;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.toedter.calendar.JCalendar;

@Entity
@Table(name = "proyectos")
public class Proyecto {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombreProyecto;
	
	@Temporal(TemporalType.DATE)
	private Date fechaInicioProyecto;
	
	@Temporal(TemporalType.DATE)
	private Date fechaFinProyecto;
	
	@OneToMany(mappedBy = "proyecto", cascade = CascadeType.PERSIST)
	private List<Desarrollador> desarrolladoresProyecto; // OneToMany
	
	// "proyectos" porque ese es el nombre que ponemos al objeto de la clase Proyecto en la clase
	//JefeEquipo para referenciarlo --> Miramos la clase JefeEquipo para verlo.
	@ManyToOne
	@JoinColumn(name = "id_jefeEquipo", referencedColumnName = "id")
	private JefeEquipo jefeEquipo; //OneToOne
	
	
	public Proyecto() {
		super();
	}
	
	public Proyecto(Integer id, String nombreProyecto, Date fechaInicioProyecto, Date fechaFinProyecto) {
		super();
		this.id = id;
		this.nombreProyecto = nombreProyecto;
		this.fechaInicioProyecto = fechaInicioProyecto;
		this.fechaFinProyecto = fechaFinProyecto;
	}
	
	public Proyecto(Integer id, String nombreProyecto, Date fechaInicioProyecto, Date fechaFinProyecto, JefeEquipo jefeEquipo) {
		super();
		this.id = id;
		this.nombreProyecto = nombreProyecto;
		this.fechaInicioProyecto = fechaInicioProyecto;
		this.fechaFinProyecto = fechaFinProyecto;
		this.jefeEquipo = jefeEquipo;
	}
	
	public Proyecto(Integer id, String nombreProyecto, Date fechaInicioProyecto, Date fechaFinProyecto, List<Desarrollador> desarrolladoresProyecto) {
		super();
		this.id = id;
		this.nombreProyecto = nombreProyecto;
		this.fechaInicioProyecto = fechaInicioProyecto;
		this.fechaFinProyecto = fechaFinProyecto;
		this.desarrolladoresProyecto = desarrolladoresProyecto;
	}
	
	// Debemos crear tambien un constructor que no esté vacío 
	public Proyecto(Integer id, String nombreProyecto, Date fechaInicioProyecto, Date fechaFinProyecto,
			List<Desarrollador> desarrolladoresProyecto, JefeEquipo jefeEquipo) {
		super();
		this.id = id;
		this.nombreProyecto = nombreProyecto;
		this.fechaInicioProyecto = fechaInicioProyecto;
		this.fechaFinProyecto = fechaFinProyecto;
		this.desarrolladoresProyecto = desarrolladoresProyecto;
		this.jefeEquipo = jefeEquipo;
	}

	// Constructor para no tener problemas a la hora hacer referencia a esta clase desde las demas clases que solo necesitan el id
	public Proyecto(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreProyecto() {
		return nombreProyecto;
	}

	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}

	public Date getFechaInicioProyecto() {
		return fechaInicioProyecto;
	}

	public void setFechaInicioProyecto(Date fechaInicioProyecto) {
		this.fechaInicioProyecto = fechaInicioProyecto;
	}

	public Date getFechaFinProyecto() {
		return fechaFinProyecto;
	}

	public void setFechaFinProyecto(Date fechaFinProyecto) {
		this.fechaFinProyecto = fechaFinProyecto;
	}

	public List<Desarrollador> getDesarrolladoresProyecto() {
		return desarrolladoresProyecto;
	}

	public void setListaDesarrolladores(List<Desarrollador> desarrolladoresProyecto) {
		this.desarrolladoresProyecto = desarrolladoresProyecto;
	}

	public JefeEquipo getJefeEquipo() {
		return jefeEquipo;
	}

	public void setJefeEquipo(JefeEquipo jefeEquipo) {
		this.jefeEquipo = jefeEquipo;
	} 
	
	
	
	
}
