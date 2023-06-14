package controlador;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import modelo.entidad.Desarrollador;
import modelo.entidad.Empleado;
import modelo.entidad.JefeEquipo;
import modelo.entidad.Proyecto;

public class ProcesosBBDD {

	public static EntityManagerFactory emf = null;
	public static EntityManager em = null;
	private Coordinador miCoordinador;

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;

	}

	public void ingresarEmpleado(Empleado empleado) {
		emf = Persistence.createEntityManagerFactory("ProyectoWorkBreak");

		em = emf.createEntityManager();
		em.getTransaction().begin();

		em.persist(new Empleado(null, empleado.getNombre(), empleado.getApellidos(), empleado.getEmail(),
				empleado.getSueldo()));

		em.getTransaction().commit();
		em.close();
		emf.close();

		JOptionPane.showMessageDialog(null, "El empleado ha sido guardado correctamente");

	}

	public List<Empleado> listadoEmpleados() {
		emf = Persistence.createEntityManagerFactory("ProyectoWorkBreak");

		em = emf.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery("SELECT e FROM Empleado e");

		List<Empleado> listaEmpleados = query.getResultList();

		em.getTransaction().commit();
		em.close();
		emf.close();
		return listaEmpleados;
	}

	public List<Empleado> recuperarEmpleado(String id) {

		Query query = null;
		List<Empleado> empleadoId = null;

		try {
			emf = Persistence.createEntityManagerFactory("ProyectoWorkBreak");

			em = emf.createEntityManager();
			em.getTransaction().begin();

			query = em.createQuery("SELECT e FROM Empleado e WHERE e.id = " + id);

			empleadoId = query.getResultList();

			em.getTransaction().commit();
			em.close();
			emf.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Campo ID Empleado vacio.", "Error", JOptionPane.ERROR_MESSAGE);
		}

		return empleadoId;
	}

	public void modificarEmpleado(Empleado empleado) {
		emf = Persistence.createEntityManagerFactory("ProyectoWorkBreak");

		em = emf.createEntityManager();
		em.getTransaction().begin();

		empleado.setId(empleado.getId());
		empleado.setNombre(empleado.getNombre());
		empleado.setApellidos(empleado.getApellidos());
		empleado.setEmail(empleado.getEmail());
		empleado.setSueldo(empleado.getSueldo());

		em.merge(empleado);

		em.getTransaction().commit();
		em.close();
		emf.close();

		JOptionPane.showMessageDialog(null,
				"El Empleado con ID: " + empleado.getId() + " ha sido modificado correctamente");

	}

	public List<Empleado> eliminarEmpleado(String id) {
		emf = Persistence.createEntityManagerFactory("ProyectoWorkBreak");

		em = emf.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery("SELECT e FROM Empleado e WHERE e.id = " + id);
		Empleado empleado = (Empleado) query.getSingleResult();

		em.remove(empleado);

		Query query2 = em.createQuery("SELECT e FROM Empleado e WHERE e.id =" + id);

		List<Empleado> listaEmpleados = query2.getResultList();
		em.getTransaction().commit();
		em.close();
		emf.close();

		return listaEmpleados;
	}

	public void ingresarDesarrollador(Desarrollador desarrollador) {
		emf = Persistence.createEntityManagerFactory("ProyectoWorkBreak");

		em = emf.createEntityManager();
		em.getTransaction().begin();

		em.persist(new Desarrollador(null, desarrollador.getNombre(), desarrollador.getApellidos(),
				desarrollador.getEmail(), desarrollador.getSueldo(), desarrollador.getJefeEquipo(),
				desarrollador.getProyecto()));

		em.getTransaction().commit();
		em.close();
		emf.close();

		JOptionPane.showMessageDialog(null, "El desarrollador ha sido guardado correctamente");

	}

	public List<Desarrollador> listadoDesarrolladores() {
		emf = Persistence.createEntityManagerFactory("ProyectoWorkBreak");

		em = emf.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery("SELECT d FROM Desarrollador d");

		List<Desarrollador> listaDesarrolladores = query.getResultList();

		em.getTransaction().commit();
		em.close();
		emf.close();

		return listaDesarrolladores;

	}

	public List<Desarrollador> recuperarDesarrollador(String id) {

		Query query = null;
		List<Desarrollador> desarrolladorId = null;
		try {
			emf = Persistence.createEntityManagerFactory("ProyectoWorkBreak");

			em = emf.createEntityManager();
			em.getTransaction().begin();

			query = em.createQuery("SELECT d FROM Desarrollador d WHERE d.id = " + id);

			desarrolladorId = query.getResultList();

			em.getTransaction().commit();
			em.close();
			emf.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Campo ID Desarrollador vacio.", "Error", JOptionPane.ERROR_MESSAGE);
		}

		return desarrolladorId;

	}

	public void modificarDesarrollador(Desarrollador desarrollador) {
		emf = Persistence.createEntityManagerFactory("ProyectoWorkBreak");

		em = emf.createEntityManager();
		em.getTransaction().begin();

		desarrollador.setId(desarrollador.getId());
		desarrollador.setNombre(desarrollador.getNombre());
		desarrollador.setApellidos(desarrollador.getApellidos());
		desarrollador.setEmail(desarrollador.getEmail());
		desarrollador.setSueldo(desarrollador.getSueldo());
		desarrollador.setJefeEquipo(desarrollador.getJefeEquipo());
		desarrollador.setProyecto(desarrollador.getProyecto());

		em.merge(desarrollador);

		em.getTransaction().commit();
		em.close();
		emf.close();

		JOptionPane.showMessageDialog(null,
				"El Desarrollador con ID: " + desarrollador.getId() + " ha sido modificado correctamente");

	}

	public List<Desarrollador> recuperarDesarrolladorPorJefeId(String jefeId) {

		Query query = null;
		List<Desarrollador> desarrolladorJefeId = null;

		try {
			emf = Persistence.createEntityManagerFactory("ProyectoWorkBreak");

			em = emf.createEntityManager();
			em.getTransaction().begin();

			query = em.createQuery("SELECT d FROM Desarrollador d WHERE id_jefeEquipo = " + jefeId);

			desarrolladorJefeId = query.getResultList();

			em.getTransaction().commit();
			em.close();
			emf.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Campo ID Jefe Equipo vacio.", "Error", JOptionPane.ERROR_MESSAGE);
		}

		return desarrolladorJefeId;

	}

	public List<Desarrollador> recuperarDesarrolladorPorProyectoId(String proyectoId) {
		
		Query query = null;
		List<Desarrollador> desarrolladorProyectoId = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("ProyectoWorkBreak");

			em = emf.createEntityManager();
			em.getTransaction().begin();

			query = em.createQuery("SELECT d FROM Desarrollador d WHERE id_proyecto = " + proyectoId);

			desarrolladorProyectoId = query.getResultList();

			em.getTransaction().commit();
			em.close();
			emf.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Campo ID Proyecto vacio.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		return desarrolladorProyectoId;
		
	}

	public List<Desarrollador> eliminarDesarrollador(String id) {
		emf = Persistence.createEntityManagerFactory("ProyectoWorkBreak");

		em = emf.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery("SELECT d FROM Desarrollador d WHERE d.id = " + id);
		Desarrollador desarrollador = (Desarrollador) query.getSingleResult();

		em.remove(desarrollador);

		Query query2 = em.createQuery("SELECT d FROM Desarrollador d WHERE d.id =" + id);

		List<Desarrollador> listaDesarrolladores = query2.getResultList();
		em.getTransaction().commit();
		em.close();
		emf.close();

		return listaDesarrolladores;
	}

	public void ingresarJefeEquipo(JefeEquipo jefeEquipo) {
		emf = Persistence.createEntityManagerFactory("ProyectoWorkBreak");

		em = emf.createEntityManager();
		em.getTransaction().begin();

		em.persist(new JefeEquipo(null, jefeEquipo.getNombre(), jefeEquipo.getApellidos(), jefeEquipo.getEmail(),
				jefeEquipo.getSueldo(), jefeEquipo.getEspecialidad()));

		em.getTransaction().commit();
		em.close();
		emf.close();

		JOptionPane.showMessageDialog(null, "El jefe de equipo ha sido guardado correctamente");

	}

	public List<JefeEquipo> listadoJefesEquipo() {

		emf = Persistence.createEntityManagerFactory("ProyectoWorkBreak");

		em = emf.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery("SELECT je FROM JefeEquipo je");

		List<JefeEquipo> listaJefeEquipos = query.getResultList();

		em.getTransaction().commit();
		em.close();
		emf.close();

		return listaJefeEquipos;

	}

	public List<JefeEquipo> recuperarJefeEquipo(String id) {

		Query query = null;
		List<JefeEquipo> jefeEquipoId = null;

		try {
			emf = Persistence.createEntityManagerFactory("ProyectoWorkBreak");

			em = emf.createEntityManager();
			em.getTransaction().begin();

			query = em.createQuery("SELECT j FROM JefeEquipo j WHERE j.id = " + id);

			jefeEquipoId = query.getResultList();

			em.getTransaction().commit();
			em.close();
			emf.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Campo ID Jefes de Equipo vacio.", "Error", JOptionPane.ERROR_MESSAGE);
		}

		return jefeEquipoId;
	}

	public void modificarJefeEquipo(JefeEquipo jefeEquipo) {
		emf = Persistence.createEntityManagerFactory("ProyectoWorkBreak");

		em = emf.createEntityManager();
		em.getTransaction().begin();

		jefeEquipo.setId(jefeEquipo.getId());
		jefeEquipo.setNombre(jefeEquipo.getNombre());
		jefeEquipo.setApellidos(jefeEquipo.getApellidos());
		jefeEquipo.setEmail(jefeEquipo.getEmail());
		jefeEquipo.setSueldo(jefeEquipo.getSueldo());
		jefeEquipo.setEspecialidad(jefeEquipo.getEspecialidad());

		em.merge(jefeEquipo);

		em.getTransaction().commit();
		em.close();
		emf.close();

		JOptionPane.showMessageDialog(null,
				"El Jefe de Equipo con ID: " + jefeEquipo.getId() + " ha sido modificado correctamente");

	}

	public List<JefeEquipo> eliminarJefeEquipo(String id) {
		emf = Persistence.createEntityManagerFactory("ProyectoWorkBreak");

		em = emf.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery("SELECT j FROM JefeEquipo j WHERE j.id = " + id);
		JefeEquipo jefeEquipo = (JefeEquipo) query.getSingleResult();

		em.remove(jefeEquipo);

		Query query2 = em.createQuery("SELECT j FROM JefeEquipo j WHERE j.id =" + id);

		List<JefeEquipo> listaJefesEquipo = query2.getResultList();
		em.getTransaction().commit();
		em.close();
		emf.close();

		return listaJefesEquipo;
	}

	public void ingresarProyecto(Proyecto proyecto) {
		emf = Persistence.createEntityManagerFactory("ProyectoWorkBreak");

		em = emf.createEntityManager();
		em.getTransaction().begin();

		em.persist(new Proyecto(null, proyecto.getNombreProyecto(), proyecto.getFechaInicioProyecto(),
				proyecto.getFechaFinProyecto(), proyecto.getJefeEquipo()));

		em.getTransaction().commit();
		em.close();
		emf.close();

		JOptionPane.showMessageDialog(null, "El proyecto ha sido guardado correctamente");

	}

	public List<Proyecto> listadoProyectos() {
		emf = Persistence.createEntityManagerFactory("ProyectoWorkBreak");

		em = emf.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery("SELECT p FROM Proyecto p");

		List<Proyecto> listaProyectos = query.getResultList();

		em.getTransaction().commit();
		em.close();
		emf.close();

		return listaProyectos;

	}

	public List<Proyecto> eliminarProyecto(String id) {
		emf = Persistence.createEntityManagerFactory("ProyectoWorkBreak");

		em = emf.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery("SELECT p FROM Proyecto p WHERE p.id = " + id);
		Proyecto proyecto = (Proyecto) query.getSingleResult();

		em.remove(proyecto);

		Query query2 = em.createQuery("SELECT p FROM Proyecto p WHERE p.id =" + id);

		List<Proyecto> listaProyectos = query2.getResultList();
		em.getTransaction().commit();
		em.close();
		emf.close();

		return listaProyectos;

	}

	public List<Proyecto> recuperarProyecto(String id) {
		Query query = null;
		List<Proyecto> proyectoId = null;

		try {
			emf = Persistence.createEntityManagerFactory("ProyectoWorkBreak");

			em = emf.createEntityManager();
			em.getTransaction().begin();

			query = em.createQuery("SELECT p FROM Proyecto p WHERE p.id = " + id);

			proyectoId = query.getResultList();

			em.getTransaction().commit();
			em.close();
			emf.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Campo ID Proyecto vacio.", "Error", JOptionPane.ERROR_MESSAGE);
		}

		return proyectoId;
	}

	public List<Proyecto> recuperarProyectoPorJefeId(String jefeId) {

		Query query = null;
		List<Proyecto> proyectoJefeId = null;

		try {
			emf = Persistence.createEntityManagerFactory("ProyectoWorkBreak");

			em = emf.createEntityManager();
			em.getTransaction().begin();

			query = em.createQuery("SELECT p FROM Proyecto p WHERE id_jefeEquipo = " + jefeId);

			proyectoJefeId = query.getResultList();

			em.getTransaction().commit();
			em.close();
			emf.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Campo ID Jefe de Proyecto vacio.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return proyectoJefeId;
	}

	public void modificarProyecto(Proyecto proyecto) {
		emf = Persistence.createEntityManagerFactory("ProyectoWorkBreak");

		em = emf.createEntityManager();
		em.getTransaction().begin();

		proyecto.setId(proyecto.getId());
		proyecto.setNombreProyecto(proyecto.getNombreProyecto());
		proyecto.setFechaInicioProyecto(proyecto.getFechaInicioProyecto());
		proyecto.setFechaFinProyecto(proyecto.getFechaFinProyecto());
		proyecto.setJefeEquipo(proyecto.getJefeEquipo());

		em.merge(proyecto);

		em.getTransaction().commit();
		em.close();
		emf.close();

		JOptionPane.showMessageDialog(null,
				"El Proyeto con ID: " + proyecto.getId() + " ha sido modificado correctamente");

	}

}
