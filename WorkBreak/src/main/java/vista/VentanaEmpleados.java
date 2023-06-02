package vista;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import modelo.entidad.Desarrollador;
import modelo.entidad.Empleado;
import modelo.entidad.JefeEquipo;
import modelo.entidad.Proyecto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class VentanaEmpleados extends JFrame implements ActionListener {

	private JPanel contentPaneEmpleados;

	private JTextField txtIdEmpleado;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtEmail;
	private JTextField txtSueldo;

	private JLabel lblNumId;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblEmail;
	private JLabel lblSueldo;

	private JButton btnGuardar;
	private JButton btnBuscarIdEmpleado;
	private JButton btnModificar;
	private JButton btnLista;
	private JButton btnEliminar;

	private JScrollPane scrollPane;

	private Coordinador miCoordinador;

	// private Object empleado;

	Empleado empleado;
	private JTable tableEmpleados;
	private DefaultTableModel modelo;
	private final JPanel panel_1 = new JPanel();
	private JLabel lblNewLabel;

	/**
	 * Create the frame.
	 */
	public VentanaEmpleados() {
		setBackground(new Color(0, 51, 255));

		setTitle("EMPLEADOS");
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
		contentPaneEmpleados = new JPanel();
		contentPaneEmpleados.setBorder(new CompoundBorder());
		contentPaneEmpleados.setBackground(new Color(255, 255, 255));
		setContentPane(contentPaneEmpleados);
		contentPaneEmpleados.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(123, 123, 699, 443);
		contentPaneEmpleados.add(scrollPane);

		tableEmpleados = new JTable();
		scrollPane.setViewportView(tableEmpleados);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(178, 34, 34));
		panel.setBounds(0, 0, 126, 566);
		contentPaneEmpleados.add(panel);
				panel.setLayout(null);
		
				btnLista = new JButton("LISTA");
				btnLista.setVerticalTextPosition(SwingConstants.BOTTOM);
				btnLista.setHorizontalTextPosition(SwingConstants.CENTER);
				btnLista.setForeground(new Color(255, 255, 255));
				btnLista.setBorder(null);
				btnLista.setBackground(new Color(178, 34, 34));
				btnLista.setIcon(new ImageIcon("images/lista.png"));
				btnLista.setBounds(36, 230, 65, 57);
				panel.add(btnLista);
				btnLista.setFont(new Font("Times New Roman", Font.BOLD, 14));
				
						// Botones
						btnGuardar = new JButton("GUARDAR");
						btnGuardar.setVerticalTextPosition(SwingConstants.BOTTOM);
						btnGuardar.setHorizontalTextPosition(SwingConstants.CENTER);
						btnGuardar.setIcon(new ImageIcon("images/guardar.png"));
						btnGuardar.setForeground(new Color(255, 255, 255));
						btnGuardar.setBorder(null);
						btnGuardar.setBackground(new Color(178, 34, 34));
						btnGuardar.setBounds(27, 298, 74, 68);
						panel.add(btnGuardar);
						btnGuardar.setFont(new Font("Times New Roman", Font.BOLD, 14));
						
								btnModificar = new JButton("MODIFICAR");
								btnModificar.setVerticalTextPosition(SwingConstants.BOTTOM);
								btnModificar.setForeground(new Color(255, 255, 255));
								btnModificar.setBorder(null);
								btnModificar.setBackground(new Color(178, 34, 34));
								btnModificar.setHorizontalTextPosition(SwingConstants.CENTER);
								btnModificar.setIcon(new ImageIcon("images/modifica.png"));
								btnModificar.setBounds(13, 392, 106, 57);
								panel.add(btnModificar);
								btnModificar.setFont(new Font("Times New Roman", Font.BOLD, 14));
								
										btnEliminar = new JButton("ELIMINAR");
										btnEliminar.setVerticalTextPosition(SwingConstants.BOTTOM);
										btnEliminar.setHorizontalTextPosition(SwingConstants.CENTER);
										btnEliminar.setIcon(new ImageIcon("images/eliminar.png"));
										btnEliminar.setBorder(null);
										btnEliminar.setBounds(13, 487, 106, 68);
										panel.add(btnEliminar);
										btnEliminar.setForeground(Color.WHITE);
										btnEliminar.setBackground(new Color(178, 34, 34));
										btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
										
												btnBuscarIdEmpleado = new JButton("BUSCAR");
												btnBuscarIdEmpleado.setVerticalTextPosition(SwingConstants.BOTTOM);
												btnBuscarIdEmpleado.setHorizontalTextPosition(SwingConstants.CENTER);
												btnBuscarIdEmpleado.setBorder(null);
												btnBuscarIdEmpleado.setForeground(new Color(255, 255, 255));
												btnBuscarIdEmpleado.setIcon(new ImageIcon("images/lupa.png"));
												btnBuscarIdEmpleado.setBackground(new Color(178, 34, 34));
												btnBuscarIdEmpleado.setBounds(13, 147, 106, 57);
												panel.add(btnBuscarIdEmpleado);
												btnBuscarIdEmpleado.setFont(new Font("Times New Roman", Font.BOLD, 14));
												
												lblNewLabel = new JLabel("");
												lblNewLabel.setIcon(new ImageIcon("images/emp.png"));
												lblNewLabel.setBounds(51, 33, 65, 57);
												panel.add(lblNewLabel);
												panel_1.setBackground(new Color(178, 34, 34));
												panel_1.setBounds(123, 0, 699, 127);
												contentPaneEmpleados.add(panel_1);
														panel_1.setLayout(null);
												
														// Etiquetas
														lblNumId = new JLabel("ID:");
														lblNumId.setForeground(new Color(255, 255, 255));
														lblNumId.setBounds(10, 11, 22, 17);
														panel_1.add(lblNumId);
														lblNumId.setFont(new Font("Times New Roman", Font.BOLD, 14));
														
														JSeparator separator = new JSeparator();
														separator.setBounds(33, 27, 107, 2);
														panel_1.add(separator);
														
																// Campos de texto
																txtIdEmpleado = new JTextField();
																txtIdEmpleado.setForeground(new Color(255, 255, 255));
																txtIdEmpleado.setBackground(new Color(178, 34, 34));
																txtIdEmpleado.setBorder(null);
																txtIdEmpleado.setFont(new Font("Times New Roman", Font.BOLD, 14));
																txtIdEmpleado.setBounds(33, 11, 107, 17);
																panel_1.add(txtIdEmpleado);
																txtIdEmpleado.setColumns(10);
																
																		lblNombre = new JLabel("Nombre:");
																		lblNombre.setForeground(new Color(255, 255, 255));
																		lblNombre.setBounds(150, 4, 71, 28);
																		panel_1.add(lblNombre);
																		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
																		
																		JSeparator separator_1 = new JSeparator();
																		separator_1.setBounds(225, 30, 148, 2);
																		panel_1.add(separator_1);
																		
																				txtNombre = new JTextField();
																				txtNombre.setForeground(new Color(255, 255, 255));
																				txtNombre.setFont(new Font("Times New Roman", Font.BOLD, 14));
																				txtNombre.setBorder(null);
																				txtNombre.setBackground(new Color(178, 34, 34));
																				txtNombre.setBounds(215, 10, 148, 20);
																				panel_1.add(txtNombre);
																				txtNombre.setColumns(10);
																				
																						lblApellidos = new JLabel("Apellidos:");
																						lblApellidos.setForeground(new Color(255, 255, 255));
																						lblApellidos.setBounds(383, 5, 71, 28);
																						panel_1.add(lblApellidos);
																						lblApellidos.setFont(new Font("Times New Roman", Font.BOLD, 14));
																						
																						JSeparator separator_1_1 = new JSeparator();
																						separator_1_1.setBounds(215, 27, 148, 2);
																						panel_1.add(separator_1_1);
																						
																						JSeparator separator_1_2 = new JSeparator();
																						separator_1_2.setBounds(449, 30, 148, 2);
																						panel_1.add(separator_1_2);
																						
																								txtApellidos = new JTextField();
																								txtApellidos.setFont(new Font("Times New Roman", Font.BOLD, 14));
																								txtApellidos.setForeground(new Color(255, 255, 255));
																								txtApellidos.setBorder(null);
																								txtApellidos.setBackground(new Color(178, 34, 34));
																								txtApellidos.setBounds(449, 8, 138, 20);
																								panel_1.add(txtApellidos);
																								txtApellidos.setColumns(10);
																								
																										lblEmail = new JLabel("Email:");
																										lblEmail.setForeground(new Color(255, 255, 255));
																										lblEmail.setBounds(20, 53, 71, 28);
																										panel_1.add(lblEmail);
																										lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 14));
																										
																										JSeparator separator_1_3 = new JSeparator();
																										separator_1_3.setBounds(79, 79, 138, 2);
																										panel_1.add(separator_1_3);
																										
																												txtEmail = new JTextField();
																												txtEmail.setForeground(new Color(255, 255, 255));
																												txtEmail.setBorder(null);
																												txtEmail.setBackground(new Color(178, 34, 34));
																												txtEmail.setFont(new Font("Times New Roman", Font.BOLD, 14));
																												txtEmail.setBounds(69, 58, 138, 20);
																												panel_1.add(txtEmail);
																												txtEmail.setColumns(10);
																												
																														lblSueldo = new JLabel("Sueldo:");
																														lblSueldo.setForeground(new Color(255, 255, 255));
																														lblSueldo.setBounds(240, 52, 71, 28);
																														panel_1.add(lblSueldo);
																														lblSueldo.setFont(new Font("Times New Roman", Font.BOLD, 14));
																														
																														JSeparator separator_1_2_1 = new JSeparator();
																														separator_1_2_1.setBounds(296, 79, 148, 2);
																														panel_1.add(separator_1_2_1);
																														
																																txtSueldo = new JTextField();
																																txtSueldo.setBorder(null);
																																txtSueldo.setBackground(new Color(178, 34, 34));
																																txtSueldo.setFont(new Font("Times New Roman", Font.BOLD, 14));
																																txtSueldo.setForeground(new Color(255, 255, 255));
																																txtSueldo.setBounds(296, 58, 148, 20);
																																panel_1.add(txtSueldo);
																																txtSueldo.setColumns(10);
												btnBuscarIdEmpleado.addActionListener(this);
										btnEliminar.addActionListener(this);
								btnModificar.addActionListener(this);
						btnGuardar.addActionListener(this);
				btnLista.addActionListener(this);
	}

	public void modeloTabla() {
		modelo = new DefaultTableModel();

		modelo.addColumn("ID");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellidos");
		modelo.addColumn("Email");
		modelo.addColumn("Sueldo");

		tableEmpleados.setModel(modelo);
	}

	public void datosEmpleado() {
		try {
			Empleado empleado = new Empleado();

			empleado.setId(null);
			empleado.setNombre(txtNombre.getText());
			empleado.setApellidos(txtApellidos.getText());
			empleado.setEmail(txtEmail.getText());
			empleado.setSueldo(Float.parseFloat(txtSueldo.getText()));

			miCoordinador.guardarEmpleadoEnBBDD(empleado);
		} catch (NumberFormatException nfe) {
			nfe.getStackTrace();
			JOptionPane.showMessageDialog(null, "Es obligatorio rellenar todos los campos.", "EMPLEADOS",
					JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			e.getStackTrace();
			JOptionPane.showMessageDialog(null, "Comprueba los campos", "EMPLEADOS", JOptionPane.ERROR_MESSAGE);
		}

	}

	public void llenarTabla() {
		List<Empleado> listaEmpleados = miCoordinador.listaEmpleadosBBDD();
		modeloTabla();
		for (Empleado empleado : listaEmpleados) {
			Object[] fila = new Object[5];
			fila[0] = empleado.getId();
			fila[1] = empleado.getNombre();
			fila[2] = empleado.getApellidos();
			fila[3] = empleado.getEmail();
			fila[4] = empleado.getSueldo();

			modelo.addRow(fila);
		}
	}

	public void recuperarEmpleadoPorId() {
		List<Empleado> empleadoId = miCoordinador.recuperarEmpleadoBBDD(txtIdEmpleado.getText());

		if (empleadoId.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No se encuentra empleado con el id: " + txtIdEmpleado.getText());
		} else {
			modeloTabla();
			for (Empleado empleado : empleadoId) {
				Object[] fila = new Object[5];
				fila[0] = empleado.getId();
				fila[1] = empleado.getNombre();
				fila[2] = empleado.getApellidos();
				fila[3] = empleado.getEmail();
				fila[4] = empleado.getSueldo();

				modelo.addRow(fila);
			}
		}

	}

	private void modificarEmpleado() {
		empleado = new Desarrollador();

		this.empleado.setId(Integer.parseInt(txtIdEmpleado.getText()));
		this.empleado.setNombre(txtNombre.getText());
		this.empleado.setApellidos(txtApellidos.getText());
		this.empleado.setEmail(txtEmail.getText());
		this.empleado.setSueldo(Float.parseFloat(txtSueldo.getText()));

		miCoordinador.modificarEmpleadoEnBBDD(empleado);

	}

	public void eliminarEmpleado() {
		int result = JOptionPane.showConfirmDialog(null, "Confirma eliminar", null, JOptionPane.YES_NO_OPTION);

		if (result == JOptionPane.YES_OPTION) {
			List<Empleado> empleadoId = miCoordinador.eliminarEmpleadoBBDD(txtIdEmpleado.getText());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (btnBuscarIdEmpleado == e.getSource()) {
			recuperarEmpleadoPorId();
		} else if (btnGuardar == e.getSource()) {
			datosEmpleado();
		} else if (btnModificar == e.getSource()) {
			modificarEmpleado();
		} else if (btnLista == e.getSource()) {
			llenarTabla();
		} else if (btnEliminar == e.getSource()) {
			eliminarEmpleado();
		}

	}
}
