package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.Coordinador;
import modelo.entidad.Desarrollador;
import modelo.entidad.Empleado;
import modelo.entidad.JefeEquipo;
import modelo.entidad.Proyecto;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class VentanaDesarrolladores extends JFrame implements ActionListener {

	private JPanel contentPane;

	private JTextField txtIdDesarrollador;
	private JTextField txtNombreDesarrollador;
	private JTextField txtApellidosDesarrollador;
	private JTextField txtEmailDesarrollador;
	private JTextField txtSueldoDesarrollador;
	private JTextField txtIdProyecto;
	private JTextField txtIdJefeEquipo;

	private JLabel lblNumId;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblEmail;
	private JLabel lblSueldo;
	private JLabel lbliDJefe;
	private JLabel lbliDProyecto;

	private JButton btnGuardarDesarrollador;
	private JButton btnBuscarIdDesarrollador;
	private JButton btnModificarDesarrolladores;
	private JButton btnListaDesarrolladores;
	private JButton btnEliminarDesarrolladores;
	private JButton btnBuscarIdJefeEquipo;
	private JButton btnBuscarIdProyecto;

	private JTable tableDesarrolladores;
	private DefaultTableModel modeloDesarrolladores;

	private JScrollPane scrollPane;

	private Coordinador miCoordinador;
	private Empleado empleado;
	private Desarrollador desarrollador;
	private JefeEquipo jefeEquipo;
	private Proyecto proyecto;
	private JPanel panel_1;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JSeparator separator_4;

	/**
	 * Create the frame.
	 */
	public VentanaDesarrolladores() {
		setTitle("DESARROLLADORES");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 838, 634);
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

		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBorder(null);
		scrollPane.setBounds(123, 123, 699, 425);
		contentPane.add(scrollPane);

		tableDesarrolladores = new JTable();
		scrollPane.setViewportView(tableDesarrolladores);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(178, 34, 34));
		panel.setBounds(0, 0, 126, 595);
		contentPane.add(panel);
				panel.setLayout(null);
		
				btnBuscarIdDesarrollador = new JButton("BUSCAR");
				btnBuscarIdDesarrollador.setBorder(null);
				btnBuscarIdDesarrollador.setBackground(new Color(178, 34, 34));
				btnBuscarIdDesarrollador.setForeground(new Color(255, 255, 255));
				btnBuscarIdDesarrollador.setVerticalTextPosition(SwingConstants.BOTTOM);
				btnBuscarIdDesarrollador.setIcon(new ImageIcon("images/lupa.png"));
				btnBuscarIdDesarrollador.setHorizontalTextPosition(SwingConstants.CENTER);
				btnBuscarIdDesarrollador.setBounds(10, 133, 106, 68);
				panel.add(btnBuscarIdDesarrollador);
				btnBuscarIdDesarrollador.setFont(new Font("Times New Roman", Font.BOLD, 14));
				
						btnListaDesarrolladores = new JButton("LISTA");
						btnListaDesarrolladores.setHorizontalTextPosition(SwingConstants.CENTER);
						btnListaDesarrolladores.setVerticalTextPosition(SwingConstants.BOTTOM);
						btnListaDesarrolladores.setIcon(new ImageIcon("images/lista.png"));
						btnListaDesarrolladores.setForeground(new Color(255, 255, 255));
						btnListaDesarrolladores.setBorder(null);
						btnListaDesarrolladores.setBackground(new Color(178, 34, 34));
						btnListaDesarrolladores.setBounds(10, 230, 106, 53);
						panel.add(btnListaDesarrolladores);
						btnListaDesarrolladores.setFont(new Font("Times New Roman", Font.BOLD, 14));
						
								// Botones
								btnGuardarDesarrollador = new JButton("GUARDAR");
								btnGuardarDesarrollador.setBorder(null);
								btnGuardarDesarrollador.setBackground(new Color(178, 34, 34));
								btnGuardarDesarrollador.setForeground(new Color(255, 255, 255));
								btnGuardarDesarrollador.setHorizontalTextPosition(SwingConstants.CENTER);
								btnGuardarDesarrollador.setVerticalTextPosition(SwingConstants.BOTTOM);
								btnGuardarDesarrollador.setIcon(new ImageIcon("images/guardar.png"));
								btnGuardarDesarrollador.setBounds(10, 316, 106, 62);
								panel.add(btnGuardarDesarrollador);
								btnGuardarDesarrollador.setFont(new Font("Tahoma", Font.BOLD, 14));
								
										btnModificarDesarrolladores = new JButton("MODIFICAR");
										btnModificarDesarrolladores.setVerticalTextPosition(SwingConstants.BOTTOM);
										btnModificarDesarrolladores.setHorizontalTextPosition(SwingConstants.CENTER);
										btnModificarDesarrolladores.setForeground(new Color(255, 255, 255));
										btnModificarDesarrolladores.setIcon(new ImageIcon("images/modifica.png"));
										btnModificarDesarrolladores.setBorder(null);
										btnModificarDesarrolladores.setBackground(new Color(178, 34, 34));
										btnModificarDesarrolladores.setBounds(10, 408, 106, 62);
										panel.add(btnModificarDesarrolladores);
										btnModificarDesarrolladores.setFont(new Font("Times New Roman", Font.BOLD, 14));
										
												btnEliminarDesarrolladores = new JButton("ELIMINAR");
												btnEliminarDesarrolladores.setBorder(null);
												btnEliminarDesarrolladores.setVerticalTextPosition(SwingConstants.BOTTOM);
												btnEliminarDesarrolladores.setHorizontalTextPosition(SwingConstants.CENTER);
												btnEliminarDesarrolladores.setIcon(new ImageIcon("images/eliminar.png"));
												btnEliminarDesarrolladores.setBounds(10, 522, 106, 62);
												panel.add(btnEliminarDesarrolladores);
												btnEliminarDesarrolladores.setForeground(Color.WHITE);
												btnEliminarDesarrolladores.setBackground(new Color(178, 34, 34));
												btnEliminarDesarrolladores.setFont(new Font("Times New Roman", Font.BOLD, 14));
												
												JLabel lblNewLabel = new JLabel("");
												lblNewLabel.setIcon(new ImageIcon("images/dev.png"));
												lblNewLabel.setBounds(40, 33, 65, 62);
												panel.add(lblNewLabel);
												btnEliminarDesarrolladores.addActionListener(this);
										btnModificarDesarrolladores.addActionListener(this);
								btnGuardarDesarrollador.addActionListener(this);
						btnListaDesarrolladores.addActionListener(this);
				btnBuscarIdDesarrollador.addActionListener(this);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(178, 34, 34));
		panel_1.setBounds(123, 0, 699, 127);
		contentPane.add(panel_1);
				panel_1.setLayout(null);
		
				// Etiquetas
				lblNumId = new JLabel("ID:");
				lblNumId.setForeground(new Color(255, 255, 255));
				lblNumId.setBounds(10, 20, 22, 17);
				panel_1.add(lblNumId);
				lblNumId.setFont(new Font("Times New Roman", Font.BOLD, 14));
				
				JSeparator separator = new JSeparator();
				separator.setBounds(46, 35, 95, 2);
				panel_1.add(separator);
				
						// Campos de texto
						txtIdDesarrollador = new JTextField();
						txtIdDesarrollador.setBorder(null);
						txtIdDesarrollador.setBackground(new Color(178, 34, 34));
						txtIdDesarrollador.setFont(new Font("Times New Roman", Font.BOLD, 14));
						txtIdDesarrollador.setForeground(new Color(255, 255, 255));
						txtIdDesarrollador.setBounds(42, 11, 99, 20);
						panel_1.add(txtIdDesarrollador);
						txtIdDesarrollador.setColumns(10);
						
								txtNombreDesarrollador = new JTextField();
								txtNombreDesarrollador.setForeground(new Color(255, 255, 255));
								txtNombreDesarrollador.setBorder(null);
								txtNombreDesarrollador.setBackground(new Color(178, 34, 34));
								txtNombreDesarrollador.setFont(new Font("Times New Roman", Font.BOLD, 14));
								txtNombreDesarrollador.setBounds(217, 11, 148, 20);
								panel_1.add(txtNombreDesarrollador);
								txtNombreDesarrollador.setColumns(10);
								
										lblNombre = new JLabel("Nombre:");
										lblNombre.setForeground(new Color(255, 255, 255));
										lblNombre.setBounds(157, 14, 71, 28);
										panel_1.add(lblNombre);
										lblNombre.setFont(new Font("Times New Roman", Font.BOLD, 14));
										
												txtEmailDesarrollador = new JTextField();
												txtEmailDesarrollador.setBorder(null);
												txtEmailDesarrollador.setBackground(new Color(178, 34, 34));
												txtEmailDesarrollador.setForeground(new Color(255, 255, 255));
												txtEmailDesarrollador.setFont(new Font("Times New Roman", Font.BOLD, 14));
												txtEmailDesarrollador.setBounds(56, 57, 172, 28);
												panel_1.add(txtEmailDesarrollador);
												txtEmailDesarrollador.setColumns(10);
												
														lblEmail = new JLabel("Email:");
														lblEmail.setForeground(new Color(255, 255, 255));
														lblEmail.setBounds(10, 70, 71, 28);
														panel_1.add(lblEmail);
														lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 14));
														
														separator_1 = new JSeparator();
														separator_1.setBounds(217, 35, 148, 2);
														panel_1.add(separator_1);
														
																lblApellidos = new JLabel("Apellidos:");
																lblApellidos.setForeground(new Color(255, 255, 255));
																lblApellidos.setBounds(375, 13, 71, 28);
																panel_1.add(lblApellidos);
																lblApellidos.setFont(new Font("Times New Roman", Font.BOLD, 14));
																
																separator_2 = new JSeparator();
																separator_2.setBounds(439, 35, 148, 2);
																panel_1.add(separator_2);
																
																		txtApellidosDesarrollador = new JTextField();
																		txtApellidosDesarrollador.setForeground(new Color(255, 255, 255));
																		txtApellidosDesarrollador.setFont(new Font("Times New Roman", Font.BOLD, 14));
																		txtApellidosDesarrollador.setBorder(null);
																		txtApellidosDesarrollador.setBackground(new Color(178, 34, 34));
																		txtApellidosDesarrollador.setBounds(439, 11, 148, 20);
																		panel_1.add(txtApellidosDesarrollador);
																		txtApellidosDesarrollador.setColumns(10);
																		
																		separator_3 = new JSeparator();
																		separator_3.setBounds(57, 88, 171, 2);
																		panel_1.add(separator_3);
																		
																				lblSueldo = new JLabel("Sueldo:");
																				lblSueldo.setForeground(new Color(255, 255, 255));
																				lblSueldo.setBounds(260, 69, 71, 28);
																				panel_1.add(lblSueldo);
																				lblSueldo.setFont(new Font("Times New Roman", Font.BOLD, 14));
																				
																				separator_4 = new JSeparator();
																				separator_4.setBounds(311, 88, 171, 2);
																				panel_1.add(separator_4);
																				
																						txtSueldoDesarrollador = new JTextField();
																						txtSueldoDesarrollador.setForeground(new Color(255, 255, 255));
																						txtSueldoDesarrollador.setBorder(null);
																						txtSueldoDesarrollador.setBackground(new Color(178, 34, 34));
																						txtSueldoDesarrollador.setFont(new Font("Times New Roman", Font.BOLD, 14));
																						txtSueldoDesarrollador.setBounds(313, 61, 169, 24);
																						panel_1.add(txtSueldoDesarrollador);
																						txtSueldoDesarrollador.setColumns(10);
																						
																						JPanel panel_2 = new JPanel();
																						panel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
																						panel_2.setBackground(new Color(178, 34, 34));
																						panel_2.setBounds(123, 548, 697, 47);
																						contentPane.add(panel_2);
																						panel_2.setLayout(null);
																						
																						lbliDProyecto = new JLabel("ID Proyecto:");
																						lbliDProyecto.setForeground(new Color(255, 255, 255));
																						lbliDProyecto.setBounds(10, 11, 88, 17);
																						panel_2.add(lbliDProyecto);
																						lbliDProyecto.setFont(new Font("Times New Roman", Font.BOLD, 14));
																						
																						JSeparator separator_5 = new JSeparator();
																						separator_5.setBounds(95, 26, 88, 2);
																						panel_2.add(separator_5);
																						
																						btnBuscarIdProyecto = new JButton("BUSCAR");
																						btnBuscarIdProyecto.setBorder(null);
																						btnBuscarIdProyecto.setForeground(new Color(255, 255, 255));
																						btnBuscarIdProyecto.setBackground(new Color(178, 34, 34));
																						btnBuscarIdProyecto.setIcon(new ImageIcon("images/pr.png"));
																						btnBuscarIdProyecto.setHorizontalTextPosition(SwingConstants.LEFT);
																						btnBuscarIdProyecto.setHorizontalAlignment(SwingConstants.LEFT);
																						btnBuscarIdProyecto.setBounds(206, 14, 88, 23);
																						panel_2.add(btnBuscarIdProyecto);
																						btnBuscarIdProyecto.addActionListener(this);
																						btnBuscarIdProyecto.setFont(new Font("Times New Roman", Font.BOLD, 14));
																						
																								lbliDJefe = new JLabel("ID Jefe Equipo:");
																								lbliDJefe.setForeground(new Color(255, 255, 255));
																								lbliDJefe.setBounds(317, 11, 112, 28);
																								panel_2.add(lbliDJefe);
																								lbliDJefe.setFont(new Font("Times New Roman", Font.BOLD, 14));
																								
																								JSeparator separator_5_1 = new JSeparator();
																								separator_5_1.setBounds(424, 30, 88, 4);
																								panel_2.add(separator_5_1);
																								
																								txtIdJefeEquipo = new JTextField();
																								txtIdJefeEquipo.setForeground(new Color(255, 255, 255));
																								txtIdJefeEquipo.setBorder(null);
																								txtIdJefeEquipo.setBackground(new Color(178, 34, 34));
																								txtIdJefeEquipo.setFont(new Font("Times New Roman", Font.BOLD, 14));
																								txtIdJefeEquipo.setBounds(426, 10, 86, 20);
																								panel_2.add(txtIdJefeEquipo);
																								txtIdJefeEquipo.setColumns(10);
																								
																								btnBuscarIdJefeEquipo = new JButton("BUSCAR ");
																								btnBuscarIdJefeEquipo.setBorder(null);
																								btnBuscarIdJefeEquipo.setBackground(new Color(178, 34, 34));
																								btnBuscarIdJefeEquipo.setForeground(new Color(255, 255, 255));
																								btnBuscarIdJefeEquipo.setHorizontalAlignment(SwingConstants.RIGHT);
																								btnBuscarIdJefeEquipo.setHorizontalTextPosition(SwingConstants.LEFT);
																								btnBuscarIdJefeEquipo.setIcon(new ImageIcon("images/je.png"));
																								btnBuscarIdJefeEquipo.setBounds(495, 14, 123, 23);
																								panel_2.add(btnBuscarIdJefeEquipo);
																								btnBuscarIdJefeEquipo.addActionListener(this);
																								btnBuscarIdJefeEquipo.setFont(new Font("Times New Roman", Font.BOLD, 14));
																						
																						txtIdProyecto = new JTextField();
																						txtIdProyecto.setBackground(new Color(178, 34, 34));
																						txtIdProyecto.setBorder(null);
																						txtIdProyecto.setFont(new Font("Times New Roman", Font.BOLD, 14));
																						txtIdProyecto.setForeground(new Color(255, 255, 255));
																						txtIdProyecto.setBounds(222, 551, 83, 17);
																						contentPane.add(txtIdProyecto);
																						txtIdProyecto.setColumns(10);
	}

	public void modeloTablaDesarrolladores() {
		modeloDesarrolladores = new DefaultTableModel();

		modeloDesarrolladores.addColumn("ID");
		modeloDesarrolladores.addColumn("Nombre");
		modeloDesarrolladores.addColumn("Apellidos");
		modeloDesarrolladores.addColumn("Email");
		modeloDesarrolladores.addColumn("Sueldo");
		modeloDesarrolladores.addColumn("ID Jefe");
		modeloDesarrolladores.addColumn("ID Proy.");

		tableDesarrolladores.setModel(modeloDesarrolladores);
	}

	public void llenarTabla() {
		List<Desarrollador> listaDesarrolladores = miCoordinador.listaDesarrolladoresBBDD();
		modeloTablaDesarrolladores();

		for (Desarrollador desarrollador : listaDesarrolladores) {
			Object[] fila = new Object[7];
			fila[0] = desarrollador.getId();
			fila[1] = desarrollador.getNombre();
			fila[2] = desarrollador.getApellidos();
			fila[3] = desarrollador.getEmail();
			fila[4] = desarrollador.getSueldo();
			fila[5] = desarrollador.getJefeEquipo().getId();
			fila[6] = desarrollador.getProyecto().getId();
			

			modeloDesarrolladores.addRow(fila);
		}
	}

	public void datosDesarrollador() {

		desarrollador = new Desarrollador();

		try {
			this.desarrollador.setId(null);
			this.desarrollador.setNombre(txtNombreDesarrollador.getText());
			this.desarrollador.setApellidos(txtApellidosDesarrollador.getText());
			this.desarrollador.setEmail(txtEmailDesarrollador.getText());
			this.desarrollador.setSueldo(Float.parseFloat(txtSueldoDesarrollador.getText()));
			this.desarrollador.setJefeEquipo(new JefeEquipo(Integer.parseInt(txtIdJefeEquipo.getText())));
			this.desarrollador.setProyecto(new Proyecto(Integer.parseInt(txtIdProyecto.getText())));

			miCoordinador.guardarDesarrolladorEnBBDD(desarrollador);
		} catch (NumberFormatException nfe) {
			nfe.getStackTrace();
			JOptionPane.showMessageDialog(null, "Es obligatorio rellenar todos los campos.", "DESARROLLADORES",
					JOptionPane.ERROR_MESSAGE);
		}catch (Exception e) {
			e.getStackTrace();
			JOptionPane.showMessageDialog(null, "Comprueba los campos", "DESARROLLADORES", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	
	
	public void recuperarDesarrolladorPorId() {
		List<Desarrollador> desarrolladorId = miCoordinador.recuperarDesarrolladorBBDD(txtIdDesarrollador.getText());
		
		
		if (desarrolladorId.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No se encuentra desarrollador con el id: " + txtIdDesarrollador.getText());
		}else {
			modeloTablaDesarrolladores();
			
			for (Desarrollador desarrollador : desarrolladorId) {
				Object[] fila = new Object[7];
				fila[0] = desarrollador.getId();
				fila[1] = desarrollador.getNombre();
				fila[2] = desarrollador.getApellidos();
				fila[3] = desarrollador.getEmail();
				fila[4] = desarrollador.getSueldo();
				fila[5] = desarrollador.getJefeEquipo().getId();
				fila[6] = desarrollador.getProyecto().getId();
				

				modeloDesarrolladores.addRow(fila);
			}
		}
	}
	
	public void modificarDesarrollador() {
		desarrollador = new Desarrollador();

		this.desarrollador.setId(Integer.parseInt(txtIdDesarrollador.getText()));
		this.desarrollador.setNombre(txtNombreDesarrollador.getText());
		this.desarrollador.setApellidos(txtApellidosDesarrollador.getText());
		this.desarrollador.setEmail(txtEmailDesarrollador.getText());
		this.desarrollador.setSueldo(Float.parseFloat(txtSueldoDesarrollador.getText()));
		this.desarrollador.setJefeEquipo(new JefeEquipo(Integer.parseInt(txtIdJefeEquipo.getText())));
		this.desarrollador.setProyecto(new Proyecto(Integer.parseInt(txtIdProyecto.getText())));

		miCoordinador.modificarDesarrolladorEnBBDD(desarrollador);
	}
	
	public void recuperarDesarrolladorPorJefeId() {
		List<Desarrollador> desarrolladorJefeId = miCoordinador.recuperarDesarrolladorPorJefeIdBBDD(txtIdJefeEquipo.getText());
		
		
		if (desarrolladorJefeId.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No se encuentra desarrollador con el jefe id: " + txtIdJefeEquipo.getText());
		}else {
			modeloTablaDesarrolladores();
			
			for (Desarrollador desarrollador : desarrolladorJefeId) {
				Object[] fila = new Object[7];
				fila[0] = desarrollador.getId();
				fila[1] = desarrollador.getNombre();
				fila[2] = desarrollador.getApellidos();
				fila[3] = desarrollador.getEmail();
				fila[4] = desarrollador.getSueldo();
				fila[5] = desarrollador.getJefeEquipo().getId();
				fila[6] = desarrollador.getProyecto().getId();
				

				modeloDesarrolladores.addRow(fila);
			}
		}
	}

	public void recuperarDesarrolladorPorProyectoId() {
		List<Desarrollador> desarrolladorProyectoId = miCoordinador.recuperarDesarrolladorPorProyectoIdBBDD(txtIdProyecto.getText());
		
		
		if (desarrolladorProyectoId.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No se encuentra desarrollador con el proyecto id: " + txtIdProyecto.getText());
		}else {
			modeloTablaDesarrolladores();
			
			for (Desarrollador desarrollador : desarrolladorProyectoId) {
				Object[] fila = new Object[7];
				fila[0] = desarrollador.getId();
				fila[1] = desarrollador.getNombre();
				fila[2] = desarrollador.getApellidos();
				fila[3] = desarrollador.getEmail();
				fila[4] = desarrollador.getSueldo();
				fila[5] = desarrollador.getJefeEquipo().getId();
				fila[6] = desarrollador.getProyecto().getId();
				

				modeloDesarrolladores.addRow(fila);
			}
		}
	}
	
	private void eliminarDesarrollador() {
		int result = JOptionPane.showConfirmDialog(null, "Confirma eliminar", null, JOptionPane.YES_NO_OPTION);

		if (result == JOptionPane.YES_OPTION) {
			List<Desarrollador> desarrolldorId = miCoordinador.eliminarDesarrolladorPorIdBBDD(txtIdDesarrollador.getText());
			JOptionPane.showConfirmDialog(null, "Desarrollador con ID: " + txtIdDesarrollador.getText() + " eliminado.");
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (btnBuscarIdDesarrollador == e.getSource()) {
			recuperarDesarrolladorPorId();
		} else if (btnGuardarDesarrollador == e.getSource()) {
			datosDesarrollador();
		} else if (btnModificarDesarrolladores == e.getSource()) {
			modificarDesarrollador();
		} else if (btnListaDesarrolladores == e.getSource()) {
			llenarTabla();
		} else if (btnEliminarDesarrolladores == e.getSource()) {
			eliminarDesarrollador();
		} else if (btnBuscarIdProyecto == e.getSource()) {
			recuperarDesarrolladorPorProyectoId();
		} else if (btnBuscarIdJefeEquipo == e.getSource()) {
			recuperarDesarrolladorPorJefeId();
		}

	}
}
