package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.Coordinador;
import modelo.entidad.Desarrollador;
import modelo.entidad.Empleado;
import modelo.entidad.Proyecto;
import modelo.entidad.JefeEquipo;
import modelo.entidad.Empleado;

import java.util.List;

import java.sql.Date;
import java.text.SimpleDateFormat;

import com.toedter.calendar.JDateChooser;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class VentanaProyectos extends JFrame implements ActionListener {

	private JPanel contentPane;

	private JLabel lblNombreProyecto;
	private JLabel lblidProyecto;
	private JLabel lblFechaInicio;
	private JLabel lblFechaFinal;
	private JLabel lbliDJefeEquipo;

	private JTextField txtIdProyecto;
	private JTextField txtNombreProyecto;
	private JTextField txtIdJefeProyecto;

	private JButton btnGuardarProyecto;
	private JButton btnBuscarIdProyecto;
	private JButton btnBuscarIdJefeProyecto;
	private JButton btnModificarProyecto;
	private JButton btnEliminarProyecto;
	private JButton btnListaProyectos;

	private JDateChooser dateFechaInicio;
	private JDateChooser dateFechaFinal;

	private Coordinador miCoordinador;

	private JScrollPane scrollPane;

	private JTable tableProyectos;
	private DefaultTableModel modeloTablaProyectos;

	Proyecto proyecto;
	private final JPanel panel = new JPanel();
	private JPanel panel_1;
	private JPanel panel_2;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JLabel lblNewLabel;

	/**
	 * Create the frame.
	 */
	public VentanaProyectos() {
		setTitle("PROYECTOS");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 838, 605);
		setResizable(false);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/logorbg.png"));
		iniciarComponentes();
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;

	}

	private void iniciarComponentes() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		dateFechaInicio = new JDateChooser();
		dateFechaInicio.setDateFormatString("dd/MM/yyyy");
		dateFechaInicio.setBounds(390, 50, 151, 28);
		dateFechaInicio.getCalendarButton().addActionListener(this);
		contentPane.add(dateFechaInicio);

		dateFechaFinal = new JDateChooser();
		dateFechaFinal.setDateFormatString("dd/MM/yyyy");
		dateFechaFinal.setBounds(664, 50, 148, 28);
		dateFechaFinal.getCalendarButton().addActionListener(this);
		contentPane.add(dateFechaFinal);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(123, 125, 699, 381);
		contentPane.add(scrollPane);

		tableProyectos = new JTable();
		scrollPane.setViewportView(tableProyectos);
		panel.setBackground(new Color(178, 34, 34));
		panel.setBounds(0, 0, 126, 566);
		contentPane.add(panel);
				panel.setLayout(null);
		
				// Botones
				btnBuscarIdProyecto = new JButton("BUSCAR");
				btnBuscarIdProyecto.setBorder(null);
				btnBuscarIdProyecto.setForeground(new Color(255, 255, 255));
				btnBuscarIdProyecto.setVerticalTextPosition(SwingConstants.BOTTOM);
				btnBuscarIdProyecto.setHorizontalTextPosition(SwingConstants.CENTER);
				btnBuscarIdProyecto.setIcon(new ImageIcon("images/lupa.png"));
				btnBuscarIdProyecto.setBackground(new Color(178, 34, 34));
				btnBuscarIdProyecto.setBounds(23, 124, 77, 60);
				panel.add(btnBuscarIdProyecto);
				btnBuscarIdProyecto.setFont(new Font("Times New Roman", Font.BOLD, 14));
				
						btnListaProyectos = new JButton("LISTA");
						btnListaProyectos.setVerticalTextPosition(SwingConstants.BOTTOM);
						btnListaProyectos.setIcon(new ImageIcon("images/lista.png"));
						btnListaProyectos.setHorizontalTextPosition(SwingConstants.CENTER);
						btnListaProyectos.setForeground(new Color(255, 255, 255));
						btnListaProyectos.setBackground(new Color(178, 34, 34));
						btnListaProyectos.setBorder(null);
						btnListaProyectos.setBounds(10, 215, 106, 50);
						panel.add(btnListaProyectos);
						btnListaProyectos.setFont(new Font("Times New Roman", Font.BOLD, 14));
						
								btnGuardarProyecto = new JButton("GUARDAR");
								btnGuardarProyecto.setForeground(new Color(255, 255, 255));
								btnGuardarProyecto.setBackground(new Color(178, 34, 34));
								btnGuardarProyecto.setBorder(null);
								btnGuardarProyecto.setVerticalTextPosition(SwingConstants.BOTTOM);
								btnGuardarProyecto.setIcon(new ImageIcon("images/guardar.png"));
								btnGuardarProyecto.setHorizontalTextPosition(SwingConstants.CENTER);
								btnGuardarProyecto.setBounds(10, 289, 106, 56);
								panel.add(btnGuardarProyecto);
								btnGuardarProyecto.setFont(new Font("Times New Roman", Font.BOLD, 14));
								
										btnModificarProyecto = new JButton("MODIFICAR");
										btnModificarProyecto.setVerticalTextPosition(SwingConstants.BOTTOM);
										btnModificarProyecto.setHorizontalTextPosition(SwingConstants.CENTER);
										btnModificarProyecto.setIcon(new ImageIcon("images/modifica.png"));
										btnModificarProyecto.setBorder(null);
										btnModificarProyecto.setBackground(new Color(178, 34, 34));
										btnModificarProyecto.setForeground(new Color(255, 255, 255));
										btnModificarProyecto.setBounds(10, 371, 106, 60);
										panel.add(btnModificarProyecto);
										btnModificarProyecto.setFont(new Font("Tahoma", Font.BOLD, 11));
										
												btnEliminarProyecto = new JButton("ELIMINAR");
												btnEliminarProyecto.setVerticalTextPosition(SwingConstants.BOTTOM);
												btnEliminarProyecto.setHorizontalTextPosition(SwingConstants.CENTER);
												btnEliminarProyecto.setIcon(new ImageIcon("images/eliminar.png"));
												btnEliminarProyecto.setBorder(null);
												btnEliminarProyecto.setBounds(10, 495, 106, 60);
												panel.add(btnEliminarProyecto);
												btnEliminarProyecto.setForeground(Color.WHITE);
												btnEliminarProyecto.setBackground(new Color(178, 34, 34));
												btnEliminarProyecto.setFont(new Font("Times New Roman", Font.BOLD, 14));
												
												lblNewLabel = new JLabel("");
												lblNewLabel.setIcon(new ImageIcon("images/pro.png"));
												lblNewLabel.setBounds(36, 38, 64, 50);
												panel.add(lblNewLabel);
												btnEliminarProyecto.addActionListener(this);
										btnModificarProyecto.addActionListener(this);
								btnGuardarProyecto.addActionListener(this);
						btnListaProyectos.addActionListener(this);
				btnBuscarIdProyecto.addActionListener(this);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(178, 34, 34));
		panel_1.setBounds(123, 0, 699, 127);
		contentPane.add(panel_1);
								panel_1.setLayout(null);
						
								// Etiquetas
								lblidProyecto = new JLabel("ID:");
								lblidProyecto.setForeground(new Color(255, 255, 255));
								lblidProyecto.setBounds(10, 11, 22, 17);
								panel_1.add(lblidProyecto);
								lblidProyecto.setFont(new Font("Times New Roman", Font.BOLD, 14));
				
						txtNombreProyecto = new JTextField();
						txtNombreProyecto.setBorder(null);
						txtNombreProyecto.setBackground(new Color(178, 34, 34));
						txtNombreProyecto.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
						txtNombreProyecto.setForeground(new Color(255, 255, 255));
						txtNombreProyecto.setBounds(287, 5, 146, 20);
						panel_1.add(txtNombreProyecto);
						txtNombreProyecto.setColumns(10);
		
				lblNombreProyecto = new JLabel("Nombre:");
				lblNombreProyecto.setForeground(new Color(255, 255, 255));
				lblNombreProyecto.setBounds(201, 10, 61, 18);
				panel_1.add(lblNombreProyecto);
				lblNombreProyecto.setFont(new Font("Times New Roman", Font.BOLD, 14));
				
						// Campos de texto
						txtIdProyecto = new JTextField();
						txtIdProyecto.setBackground(new Color(178, 34, 34));
						txtIdProyecto.setBorder(null);
						txtIdProyecto.setForeground(new Color(255, 255, 255));
						txtIdProyecto.setFont(new Font("Times New Roman", Font.BOLD, 14));
						txtIdProyecto.setBounds(32, 5, 86, 20);
						panel_1.add(txtIdProyecto);
						txtIdProyecto.setColumns(10);
						
						separator = new JSeparator();
						separator.setBounds(32, 26, 86, 2);
						panel_1.add(separator);
						
								lblFechaInicio = new JLabel("Fecha Inicio:");
								lblFechaInicio.setForeground(new Color(255, 255, 255));
								lblFechaInicio.setBounds(148, 39, 92, 28);
								panel_1.add(lblFechaInicio);
								lblFechaInicio.setFont(new Font("Times New Roman", Font.BOLD, 14));
								
										lblFechaFinal = new JLabel("Fecha Final:");
										lblFechaFinal.setForeground(new Color(255, 255, 255));
										lblFechaFinal.setBounds(444, 39, 92, 28);
										panel_1.add(lblFechaFinal);
										lblFechaFinal.setFont(new Font("Times New Roman", Font.BOLD, 14));
										
										separator_1 = new JSeparator();
										separator_1.setBounds(286, 26, 147, 2);
										panel_1.add(separator_1);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(178, 34, 34));
		panel_2.setBounds(123, 506, 699, 60);
		contentPane.add(panel_2);
				panel_2.setLayout(null);
		
				lbliDJefeEquipo = new JLabel("ID Jefe Proyecto:");
				lbliDJefeEquipo.setForeground(new Color(255, 255, 255));
				lbliDJefeEquipo.setBounds(10, 21, 120, 17);
				panel_2.add(lbliDJefeEquipo);
				lbliDJefeEquipo.setFont(new Font("Times New Roman", Font.BOLD, 14));
				
						txtIdJefeProyecto = new JTextField();
						txtIdJefeProyecto.setBorder(null);
						txtIdJefeProyecto.setBackground(new Color(178, 34, 34));
						txtIdJefeProyecto.setFont(new Font("Times New Roman", Font.BOLD, 14));
						txtIdJefeProyecto.setForeground(new Color(255, 255, 255));
						txtIdJefeProyecto.setBounds(120, 8, 147, 27);
						panel_2.add(txtIdJefeProyecto);
						txtIdJefeProyecto.setColumns(10);
						
								btnBuscarIdJefeProyecto = new JButton("BUSCAR");
								btnBuscarIdJefeProyecto.setHorizontalAlignment(SwingConstants.LEFT);
								btnBuscarIdJefeProyecto.setHorizontalTextPosition(SwingConstants.LEFT);
								btnBuscarIdJefeProyecto.setIcon(new ImageIcon("C:\\Users\\devde\\OneDrive\\Escritorio\\WorkBreak\\images\\pr.png"));
								btnBuscarIdJefeProyecto.setBorder(null);
								btnBuscarIdJefeProyecto.setBackground(new Color(178, 34, 34));
								btnBuscarIdJefeProyecto.setForeground(new Color(255, 255, 255));
								btnBuscarIdJefeProyecto.setBounds(289, 18, 106, 23);
								panel_2.add(btnBuscarIdJefeProyecto);
								btnBuscarIdJefeProyecto.setFont(new Font("Times New Roman", Font.BOLD, 14));
								
								separator_2 = new JSeparator();
								separator_2.setBounds(120, 36, 147, 2);
								panel_2.add(separator_2);
								btnBuscarIdJefeProyecto.addActionListener(this);

	}

	public void datosProyecto() {
		Proyecto proyecto = new Proyecto();

		try {
			proyecto.setId(null);
			proyecto.setNombreProyecto(txtNombreProyecto.getText());
			proyecto.setFechaInicioProyecto(dateFechaInicio.getCalendar().getTime());
			proyecto.setFechaFinProyecto(dateFechaFinal.getCalendar().getTime());
			proyecto.setJefeEquipo(new JefeEquipo(Integer.parseInt(txtIdJefeProyecto.getText())));

			miCoordinador.guardarProyectoEnBBDD(proyecto);
		} catch (NumberFormatException nfe) {
			nfe.getStackTrace();
			JOptionPane.showMessageDialog(null, "Es obligatorio rellenar todos los campos.", "PROYECTOS",
					JOptionPane.ERROR_MESSAGE);
		} catch(Exception e) {
			e.getStackTrace();
			JOptionPane.showMessageDialog(null, "Comprueba los campos", "PROYECTOS", JOptionPane.ERROR_MESSAGE);
		}
		
	}

	public void modeloTabla() {
		modeloTablaProyectos = new DefaultTableModel();

		modeloTablaProyectos.addColumn("ID");
		modeloTablaProyectos.addColumn("Nombre");
		modeloTablaProyectos.addColumn("Fecha Inicio");
		modeloTablaProyectos.addColumn("Fecha Fin");
		modeloTablaProyectos.addColumn("ID Jefe");

		tableProyectos.setModel(modeloTablaProyectos);
	}

	public void llenarTablaProyectos() {
		List<Proyecto> listaProyectos = miCoordinador.listaProyectosBBDD();
		modeloTabla();
		for (Proyecto proyecto : listaProyectos) {
			Object[] fila = new Object[5];
			fila[0] = proyecto.getId();
			fila[1] = proyecto.getNombreProyecto();
			fila[2] = proyecto.getFechaInicioProyecto();
			fila[3] = proyecto.getFechaFinProyecto();
			fila[4] = proyecto.getJefeEquipo().getId();

			modeloTablaProyectos.addRow(fila);
		}
	}

	public void recuperarProyectoPorId() {
		List<Proyecto> proyectoId = miCoordinador.recuperarProyectoBBDD(txtIdProyecto.getText());

		if (proyectoId.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No se encuentra Proyecto con el id: " + txtIdProyecto.getText());
		} else {
			modeloTabla();
			for (Proyecto proyecto : proyectoId) {
				Object[] fila = new Object[5];
				fila[0] = proyecto.getId();
				fila[1] = proyecto.getNombreProyecto();
				fila[2] = proyecto.getFechaInicioProyecto();
				fila[3] = proyecto.getFechaFinProyecto();
				fila[4] = proyecto.getJefeEquipo().getId();

				modeloTablaProyectos.addRow(fila);
			}
		}
	}

	private void recuperarProyectoPorJefeId() {
		List<Proyecto> proyectoJefeId = miCoordinador.recuperarProyectoPorJefeIdBBDD(txtIdJefeProyecto.getText());

		if (proyectoJefeId.isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"No se encuentra a Jefe de Proyecto con el id: " + txtIdJefeProyecto.getText());
		} else {
			modeloTabla();
			for (Proyecto proyecto : proyectoJefeId) {
				Object[] fila = new Object[5];
				fila[0] = proyecto.getId();
				fila[1] = proyecto.getNombreProyecto();
				fila[2] = proyecto.getFechaInicioProyecto();
				fila[3] = proyecto.getFechaFinProyecto();
				fila[4] = proyecto.getJefeEquipo().getId();

				modeloTablaProyectos.addRow(fila);
			}
		}

	}
	
	private void modificarProyecto() {
		proyecto = new Proyecto();

		proyecto.setId(Integer.parseInt(txtIdProyecto.getText()));
		proyecto.setNombreProyecto(txtNombreProyecto.getText());
		proyecto.setFechaInicioProyecto(dateFechaInicio.getCalendar().getTime());
		proyecto.setFechaFinProyecto(dateFechaFinal.getCalendar().getTime());
		proyecto.setJefeEquipo(new JefeEquipo(Integer.parseInt(txtIdJefeProyecto.getText())));
		
		miCoordinador.modificarProyectoEnBBDD(proyecto);
		
	}

	public void eliminarProyecto() {
		int result = JOptionPane.showConfirmDialog(null, "Confirma eliminar", null, JOptionPane.YES_NO_OPTION);

		if (result == JOptionPane.YES_OPTION) {
			List<Proyecto> proyectoId = miCoordinador.eliminarProyectoBBDD(txtIdProyecto.getText());
			JOptionPane.showConfirmDialog(null, "Proyecto con ID: " + txtIdProyecto.getText() + " eliminado.");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (btnBuscarIdProyecto == e.getSource()) {
			recuperarProyectoPorId();
		} else if (btnGuardarProyecto == e.getSource()) {
			datosProyecto();
		} else if (btnModificarProyecto == e.getSource()) {
			modificarProyecto();
		} else if (btnListaProyectos == e.getSource()) {
			llenarTablaProyectos();
		} else if (btnEliminarProyecto == e.getSource()) {
			eliminarProyecto();
		} else if (btnBuscarIdJefeProyecto == e.getSource()) {
			recuperarProyectoPorJefeId();
		}

	}

	

}
