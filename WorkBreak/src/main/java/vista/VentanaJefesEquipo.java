package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.Coordinador;

import modelo.entidad.Desarrollador;
import modelo.entidad.Empleado;
import modelo.entidad.JefeEquipo;
import modelo.entidad.Proyecto;

public class VentanaJefesEquipo extends JFrame implements ActionListener {

	private JPanel contentPane;

	private JTextField txtIdJefeEquipo;
	private JTextField txtNombreJefeEquipo;
	private JTextField txtApellidosJefeEquipo;
	private JTextField txtEmailJefeEquipo;
	private JTextField txtSueldoJefeEquipo;

	private JLabel lblidJefe;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblEmail;
	private JLabel lblSueldo;
	private JLabel lblEspecialidad;

	private JButton btnGuardarJefeEquipo;
	private JButton btnBuscarIdJefeEquipo;
	private JButton btnModificarJefeEquipo;
	private JButton btnListaJefeEquipo;
	private JButton btnEliminarJefeEquipo;
	private JTextField txtEspecialidad;
	private JSeparator separator_1_3;
	private JSeparator separator_1_4;
	private Coordinador miCoordinador;
	
	JefeEquipo jefeEquipo;

	private JTable tableJefesEquipo;
	private DefaultTableModel modeloTablaJefesEquipo;

	JScrollPane scrollPane;
	private JLabel lblNewLabel;

	/**
	 * Create the frame.
	 */
	public VentanaJefesEquipo() {
		setTitle("JEFES DE EQUIPO");
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
		contentPane.setBorder(new CompoundBorder());
		contentPane.setBackground(new Color(255, 255, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(178, 34, 34));
		panel.setBounds(0, 0, 126, 566);
		contentPane.add(panel);
				panel.setLayout(null);
		
				btnEliminarJefeEquipo = new JButton("ELIMINAR");
				btnEliminarJefeEquipo.setBounds(24, 502, 71, 53);
				panel.add(btnEliminarJefeEquipo);
				btnEliminarJefeEquipo.setVerticalTextPosition(SwingConstants.BOTTOM);
				btnEliminarJefeEquipo.setBorder(null);
				btnEliminarJefeEquipo.setIcon(new ImageIcon("images/eliminar.png"));
				btnEliminarJefeEquipo.setHorizontalTextPosition(SwingConstants.CENTER);
				btnEliminarJefeEquipo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnEliminarJefeEquipo.setForeground(Color.WHITE);
				btnEliminarJefeEquipo.setBackground(new Color(178, 34, 34));
				btnEliminarJefeEquipo.setFont(new Font("Times New Roman", Font.BOLD, 14));
				
						btnBuscarIdJefeEquipo = new JButton("BUSCAR");
						btnBuscarIdJefeEquipo.setBounds(-3, 133, 119, 60);
						panel.add(btnBuscarIdJefeEquipo);
						btnBuscarIdJefeEquipo.setVerticalTextPosition(SwingConstants.BOTTOM);
						btnBuscarIdJefeEquipo.setIcon(new ImageIcon("images/lupa.png"));
						btnBuscarIdJefeEquipo.setHorizontalTextPosition(SwingConstants.CENTER);
						btnBuscarIdJefeEquipo.setForeground(new Color(255, 255, 255));
						btnBuscarIdJefeEquipo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						btnBuscarIdJefeEquipo.setBorder(null);
						btnBuscarIdJefeEquipo.setBackground(new Color(178, 34, 34));
						btnBuscarIdJefeEquipo.setFont(new Font("Times New Roman", Font.BOLD, 14));
						
								btnListaJefeEquipo = new JButton("LISTA");
								btnListaJefeEquipo.setBounds(-3, 218, 109, 61);
								panel.add(btnListaJefeEquipo);
								btnListaJefeEquipo.setVerticalTextPosition(SwingConstants.BOTTOM);
								btnListaJefeEquipo.setIcon(new ImageIcon("images/lista.png"));
								btnListaJefeEquipo.setHorizontalTextPosition(SwingConstants.CENTER);
								btnListaJefeEquipo.setForeground(new Color(255, 255, 255));
								btnListaJefeEquipo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
								btnListaJefeEquipo.setBorder(null);
								btnListaJefeEquipo.setBackground(new Color(178, 34, 34));
								btnListaJefeEquipo.setFont(new Font("Times New Roman", Font.BOLD, 14));
								
										// Botones
										btnGuardarJefeEquipo = new JButton("GUARDAR");
										btnGuardarJefeEquipo.setBounds(0, 303, 119, 68);
										panel.add(btnGuardarJefeEquipo);
										btnGuardarJefeEquipo.setForeground(new Color(255, 255, 255));
										btnGuardarJefeEquipo.setBorder(null);
										btnGuardarJefeEquipo.setBackground(new Color(178, 34, 34));
										btnGuardarJefeEquipo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
										btnGuardarJefeEquipo.setVerticalTextPosition(SwingConstants.BOTTOM);
										btnGuardarJefeEquipo.setHorizontalTextPosition(SwingConstants.CENTER);
										btnGuardarJefeEquipo.setIcon(new ImageIcon("images/guardar.png"));
										btnGuardarJefeEquipo.setFont(new Font("Times New Roman", Font.BOLD, 14));
										
												btnModificarJefeEquipo = new JButton("MODIFICAR");
												btnModificarJefeEquipo.setBounds(0, 382, 119, 76);
												panel.add(btnModificarJefeEquipo);
												btnModificarJefeEquipo.setVerticalTextPosition(SwingConstants.BOTTOM);
												btnModificarJefeEquipo.setHorizontalTextPosition(SwingConstants.CENTER);
												btnModificarJefeEquipo.setIcon(new ImageIcon("images/modifica.png"));
												btnModificarJefeEquipo.setForeground(new Color(255, 255, 255));
												btnModificarJefeEquipo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
												btnModificarJefeEquipo.setBorder(null);
												btnModificarJefeEquipo.setBackground(new Color(178, 34, 34));
												btnModificarJefeEquipo.setFont(new Font("Times New Roman", Font.BOLD, 14));
												
												lblNewLabel = new JLabel("");
												lblNewLabel.setIcon(new ImageIcon("images/jequipo.png"));
												lblNewLabel.setBounds(45, 28, 71, 76);
												panel.add(lblNewLabel);
												
												JPanel panel_1 = new JPanel();
												panel_1.setBackground(new Color(178, 34, 34));
												panel_1.setBounds(123, 0, 699, 127);
												contentPane.add(panel_1);
														panel_1.setLayout(null);
												
														// Etiquetas
														lblidJefe = new JLabel("ID:");
														lblidJefe.setForeground(new Color(255, 255, 255));
														lblidJefe.setBounds(17, 27, 22, 17);
														panel_1.add(lblidJefe);
														lblidJefe.setFont(new Font("Times New Roman", Font.BOLD, 14));
														
														// Campos de texto
														txtIdJefeEquipo = new JTextField();
														txtIdJefeEquipo.setBackground(new Color(178, 34, 34));
														txtIdJefeEquipo.setFont(new Font("Times New Roman", Font.BOLD, 14));
														txtIdJefeEquipo.setForeground(new Color(255, 255, 255));
														txtIdJefeEquipo.setBorder(null);
														txtIdJefeEquipo.setBounds(46, 10, 86, 28);
														panel_1.add(txtIdJefeEquipo);
														txtIdJefeEquipo.setColumns(10);
														
														JSeparator separator = new JSeparator();
														separator.setBounds(46, 42, 86, 2);
														panel_1.add(separator);
														separator.setForeground(new Color(255, 255, 255));
														
																lblNombre = new JLabel("Nombre:");
																lblNombre.setForeground(new Color(255, 255, 255));
																lblNombre.setBounds(155, 20, 71, 28);
																panel_1.add(lblNombre);
																lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
																
																		txtNombreJefeEquipo = new JTextField();
																		txtNombreJefeEquipo.setForeground(new Color(255, 255, 255));
																		txtNombreJefeEquipo.setFont(new Font("Times New Roman", Font.BOLD, 14));
																		txtNombreJefeEquipo.setBackground(new Color(178, 34, 34));
																		txtNombreJefeEquipo.setBorder(null);
																		txtNombreJefeEquipo.setBounds(223, 11, 171, 26);
																		panel_1.add(txtNombreJefeEquipo);
																		txtNombreJefeEquipo.setColumns(10);
																		
																		JSeparator separator_1 = new JSeparator();
																		separator_1.setForeground(Color.WHITE);
																		separator_1.setBounds(223, 42, 171, 2);
																		panel_1.add(separator_1);
																		
																				lblApellidos = new JLabel("Apellidos:");
																				lblApellidos.setForeground(new Color(255, 255, 255));
																				lblApellidos.setBounds(404, 20, 71, 28);
																				panel_1.add(lblApellidos);
																				lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 14));
																				
																						txtApellidosJefeEquipo = new JTextField();
																						txtApellidosJefeEquipo.setForeground(new Color(255, 255, 255));
																						txtApellidosJefeEquipo.setFont(new Font("Times New Roman", Font.BOLD, 14));
																						txtApellidosJefeEquipo.setBackground(new Color(178, 34, 34));
																						txtApellidosJefeEquipo.setBorder(null);
																						txtApellidosJefeEquipo.setBounds(482, 14, 196, 26);
																						panel_1.add(txtApellidosJefeEquipo);
																						txtApellidosJefeEquipo.setColumns(10);
																						
																						JSeparator separator_1_1 = new JSeparator();
																						separator_1_1.setForeground(Color.WHITE);
																						separator_1_1.setBounds(482, 42, 196, 2);
																						panel_1.add(separator_1_1);
																						
																						

																						lblEspecialidad = new JLabel("Especialidad:");
																						lblEspecialidad.setForeground(new Color(255, 255, 255));
																						lblEspecialidad.setBounds(10, 77, 106, 28);
																						panel_1.add(lblEspecialidad);
																						lblEspecialidad.setFont(new Font("Tahoma", Font.BOLD, 14));
																						
																						txtEspecialidad = new JTextField();
																						txtEspecialidad.setForeground(new Color(255, 255, 255));
																						txtEspecialidad.setFont(new Font("Times New Roman", Font.BOLD, 14));
																						txtEspecialidad.setBorder(null);
																						txtEspecialidad.setBackground(new Color(178, 34, 34));
																						txtEspecialidad.setBounds(104, 67, 148, 26);
																						panel_1.add(txtEspecialidad);
																						txtEspecialidad.setColumns(10);
																						
																								lblSueldo = new JLabel("Sueldo:");
																								lblSueldo.setForeground(new Color(255, 255, 255));
																								lblSueldo.setBounds(262, 77, 71, 28);
																								panel_1.add(lblSueldo);
																								lblSueldo.setFont(new Font("Tahoma", Font.BOLD, 14));
																								
																										txtSueldoJefeEquipo = new JTextField();
																										txtSueldoJefeEquipo.setBorder(null);
																										txtSueldoJefeEquipo.setBackground(new Color(178, 34, 34));
																										txtSueldoJefeEquipo.setFont(new Font("Times New Roman", Font.BOLD, 14));
																										txtSueldoJefeEquipo.setForeground(new Color(255, 255, 255));
																										txtSueldoJefeEquipo.setBounds(320, 70, 106, 23);
																										panel_1.add(txtSueldoJefeEquipo);
																										txtSueldoJefeEquipo.setColumns(10);
																										
																												lblEmail = new JLabel("Email:");
																												lblEmail.setForeground(new Color(255, 255, 255));
																												lblEmail.setBounds(436, 77, 71, 28);
																												panel_1.add(lblEmail);
																												lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
																												
																														txtEmailJefeEquipo = new JTextField();
																														txtEmailJefeEquipo.setForeground(new Color(255, 255, 255));
																														txtEmailJefeEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
																														txtEmailJefeEquipo.setBorder(null);
																														txtEmailJefeEquipo.setBackground(new Color(178, 34, 34));
																														txtEmailJefeEquipo.setBounds(482, 64, 196, 29);
																														panel_1.add(txtEmailJefeEquipo);
																														txtEmailJefeEquipo.setColumns(10);
																														
																														JSeparator separator_1_2 = new JSeparator();
																														separator_1_2.setForeground(Color.WHITE);
																														separator_1_2.setBounds(104, 96, 148, 2);
																														panel_1.add(separator_1_2);
																														
																														separator_1_3 = new JSeparator();
																														separator_1_3.setForeground(Color.WHITE);
																														separator_1_3.setBounds(320, 96, 106, 2);
																														panel_1.add(separator_1_3);
																														
																														separator_1_4 = new JSeparator();
																														separator_1_4.setForeground(Color.WHITE);
																														separator_1_4.setBounds(482, 96, 196, 2);
																														panel_1.add(separator_1_4);
												btnModificarJefeEquipo.addActionListener(this);
										btnGuardarJefeEquipo.addActionListener(this);
								btnListaJefeEquipo.addActionListener(this);
						btnBuscarIdJefeEquipo.addActionListener(this);
				btnEliminarJefeEquipo.addActionListener(this);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Times New Roman", Font.BOLD, 14));
		scrollPane.setBorder(null);
		scrollPane.setBackground(new Color(178, 34, 34));
		scrollPane.setBounds(123, 123, 699, 443);
		contentPane.add(scrollPane);

		tableJefesEquipo = new JTable();
		scrollPane.setViewportView(tableJefesEquipo);

	}

	
	
	
	public void datosJefeEquipo() {
		jefeEquipo = new JefeEquipo();

		try {
			this.jefeEquipo.setId(null);
			this.jefeEquipo.setNombre(txtNombreJefeEquipo.getText());
			this.jefeEquipo.setApellidos(txtApellidosJefeEquipo.getText());
			this.jefeEquipo.setEmail(txtEmailJefeEquipo.getText());
			this.jefeEquipo.setSueldo(Float.parseFloat(txtSueldoJefeEquipo.getText()));
			this.jefeEquipo.setEspecialidad(txtEspecialidad.getText());

			miCoordinador.guardarJefesdeEquipoEnBBDD(jefeEquipo);
		} catch (NumberFormatException nfe) {
			nfe.getStackTrace();
			JOptionPane.showMessageDialog(null, "Es obligatorio rellenar todos los campos.", "JEFES DE EQUIPO",
					JOptionPane.ERROR_MESSAGE);
		} catch(Exception e) {
			e.getStackTrace();
			JOptionPane.showMessageDialog(null, "Comprueba los campos", "JEFES DE EQUIPO", JOptionPane.ERROR_MESSAGE);
		}
		
	}

	public void modeloTablaJefesEquipo() {
		modeloTablaJefesEquipo = new DefaultTableModel();

		modeloTablaJefesEquipo.addColumn("ID");
		modeloTablaJefesEquipo.addColumn("Nombre");
		modeloTablaJefesEquipo.addColumn("Apellidos");
		modeloTablaJefesEquipo.addColumn("Email");
		modeloTablaJefesEquipo.addColumn("Sueldo");
		modeloTablaJefesEquipo.addColumn("Especialidad");

		tableJefesEquipo.setModel(modeloTablaJefesEquipo);
	}

	public void llenarTablaJefesEquipo() {
		List<JefeEquipo> listaJefesEquipo = miCoordinador.listaJefesEquipoBBDD();
		modeloTablaJefesEquipo();
		for (JefeEquipo jefeEquipo : listaJefesEquipo) {
			Object[] fila = new Object[6];
			fila[0] = jefeEquipo.getId();
			fila[1] = jefeEquipo.getNombre();
			fila[2] = jefeEquipo.getApellidos();
			fila[3] = jefeEquipo.getEmail();
			fila[4] = jefeEquipo.getSueldo();
			fila[5] = jefeEquipo.getEspecialidad();

			modeloTablaJefesEquipo.addRow(fila);
		}
	}
	
	public void recuperarJefeEquipoPorId() {
		List<JefeEquipo> jefeEquipoId = miCoordinador.recuperarJefeEquipoBBDD(txtIdJefeEquipo.getText());//Igual hay que parsearlo a Integer
		
		
		if (jefeEquipoId.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No se encuentra empleado con el id: " + txtIdJefeEquipo.getText());
		}else {
			modeloTablaJefesEquipo();
			
			for (JefeEquipo jefeEquipo : jefeEquipoId) {
				Object[] fila = new Object[6];
				fila[0] = jefeEquipo.getId();
				fila[1] = jefeEquipo.getNombre();
				fila[2] = jefeEquipo.getApellidos();
				fila[3] = jefeEquipo.getEmail();
				fila[4] = jefeEquipo.getSueldo();
				fila[5] = jefeEquipo.getEspecialidad();

				modeloTablaJefesEquipo.addRow(fila);
			}
		}
	}
	
	private void modificarJefeEquipo() {
		JefeEquipo jefeEquipo = new JefeEquipo();

		jefeEquipo.setId(Integer.parseInt(txtIdJefeEquipo.getText()));
		jefeEquipo.setNombre(txtNombreJefeEquipo.getText());
		jefeEquipo.setApellidos(txtApellidosJefeEquipo.getText());
		jefeEquipo.setEmail(txtEmailJefeEquipo.getText());
		jefeEquipo.setSueldo(Float.parseFloat(txtSueldoJefeEquipo.getText()));
		jefeEquipo.setEspecialidad(txtEspecialidad.getText());

		miCoordinador.modificarJefeEquipoEnBBDD(jefeEquipo);
	}

	private void eliminarJefeEquipo() {
		int result = JOptionPane.showConfirmDialog(null, "Confirma eliminar", null, JOptionPane.YES_NO_OPTION);

		if (result == JOptionPane.YES_OPTION) {
			List<JefeEquipo> jefeEquipoId = miCoordinador.eliminarJefeEquipoPorIdBBDD(txtIdJefeEquipo.getText());
			JOptionPane.showConfirmDialog(null, "Jefe de equipo con ID: " + txtIdJefeEquipo.getText() + " eliminado.");
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (btnBuscarIdJefeEquipo == e.getSource()) {
			recuperarJefeEquipoPorId();
		} else if (btnGuardarJefeEquipo == e.getSource()) {
			datosJefeEquipo();
		} else if (btnModificarJefeEquipo == e.getSource()) {
			modificarJefeEquipo();
		} else if (btnListaJefeEquipo == e.getSource()) {
			llenarTablaJefesEquipo();
		} else if (btnEliminarJefeEquipo == e.getSource()) {
			eliminarJefeEquipo();
		}

	}

	

	
}
