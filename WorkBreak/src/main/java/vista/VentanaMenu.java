package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public class VentanaMenu extends JFrame implements ActionListener {

	private JPanel contentPaneMenu;

	private JPanel panelBotonesMenu;
	private JButton btnEmpleados;
	private JButton btnDesarrolladores;
	private JButton btnJefesEquipo;
	private JButton btnProyectos;

	private Coordinador miCoordinador;
	private JPanel panelFuncionalidades;
	private JButton btnSalir;

	/**
	 * Create the frame.
	 */
	public VentanaMenu() {
		setTitle("MENU");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 838, 605);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Work&Break");
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/logorbg.png"));
		iniciarComponentes();

	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;

	}

	private void iniciarComponentes() {
		contentPaneMenu = new JPanel();
		contentPaneMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneMenu);
		contentPaneMenu.setLayout(null);

		panelFuncionalidades = new JPanel();
		panelFuncionalidades.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panelFuncionalidades.setBackground(new Color(255, 255, 255));
		panelFuncionalidades.setBounds(211, 0, 611, 566);
		contentPaneMenu.add(panelFuncionalidades);
		panelFuncionalidades.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("images/logo192x192.png"));
		lblNewLabel.setBounds(166, 30, 193, 152);
		panelFuncionalidades.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("images/Avatar1.png"));
		lblNewLabel_1.setBounds(43, 352, 147, 192);
		panelFuncionalidades.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("images/Avatar2.png"));
		lblNewLabel_2.setBounds(43, 222, 125, 137);
		panelFuncionalidades.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Diseñado y Desarrollado por:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_3.setBounds(74, 175, 462, 36);
		panelFuncionalidades.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Alejandro García de la Cruz");
		lblNewLabel_4.setFont(new Font("Yu Gothic Light", Font.BOLD, 18));
		lblNewLabel_4.setBounds(181, 305, 305, 27);
		panelFuncionalidades.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("agcdev85@gmail.com");
		lblNewLabel_5.setForeground(new Color(0, 0, 255));
		lblNewLabel_5.setFont(new Font("Yu Gothic Light", Font.BOLD, 18));
		lblNewLabel_5.setBounds(191, 332, 242, 27);
		panelFuncionalidades.add(lblNewLabel_5);
		
		JLabel lblNewLabel_4_1 = new JLabel("Jenifer Casas Fenández");
		lblNewLabel_4_1.setFont(new Font("Yu Gothic Light", Font.BOLD, 18));
		lblNewLabel_4_1.setBounds(181, 464, 305, 27);
		panelFuncionalidades.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("dev.des.jen@gmail.com");
		lblNewLabel_5_1.setForeground(Color.BLUE);
		lblNewLabel_5_1.setFont(new Font("Yu Gothic Light", Font.BOLD, 18));
		lblNewLabel_5_1.setBounds(189, 496, 242, 27);
		panelFuncionalidades.add(lblNewLabel_5_1);

		panelBotonesMenu = new JPanel();
		panelBotonesMenu.setBackground(new Color(0, 128, 255));
		panelBotonesMenu.setBounds(0, 0, 211, 566);
		contentPaneMenu.add(panelBotonesMenu);
		panelBotonesMenu.setLayout(null);

		btnEmpleados = new JButton("  EMPLEADOS");
		btnEmpleados.setRolloverIcon(new ImageIcon("images/em.png"));
		btnEmpleados.setPressedIcon(new ImageIcon("images/emp.png"));
		btnEmpleados.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEmpleados.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEmpleados.setBackground(new Color(0, 128, 255));
		btnEmpleados.setForeground(new Color(255, 255, 255));
		btnEmpleados.setBorder(null);
		btnEmpleados.setIcon(new ImageIcon("images/emp.png"));
		btnEmpleados.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnEmpleados.setBounds(10, 196, 173, 70);
		btnEmpleados.addActionListener(this);
		panelBotonesMenu.add(btnEmpleados);

		btnDesarrolladores = new JButton("  DESARROLLADORES");
		btnDesarrolladores.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnDesarrolladores.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDesarrolladores.setRolloverIcon(new ImageIcon("images/de.png"));
		btnDesarrolladores.setPressedIcon(new ImageIcon("images/dev.png"));
		btnDesarrolladores.setForeground(new Color(255, 255, 255));
		btnDesarrolladores.setBorder(null);
		btnDesarrolladores.setBackground(new Color(0, 128, 255));
		btnDesarrolladores.setIcon(new ImageIcon("images/dev.png"));
		btnDesarrolladores.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnDesarrolladores.setBounds(0, 92, 201, 70);
		btnDesarrolladores.addActionListener(this);
		panelBotonesMenu.add(btnDesarrolladores);

		btnJefesEquipo = new JButton("  JEFES DE EQUIPO");
		btnJefesEquipo.setHorizontalTextPosition(SwingConstants.CENTER);
		btnJefesEquipo.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnJefesEquipo.setRolloverIcon(new ImageIcon("images/je.png"));
		btnJefesEquipo.setPressedIcon(new ImageIcon("images/jequipo.png"));
		btnJefesEquipo.setForeground(new Color(255, 255, 255));
		btnJefesEquipo.setBorder(null);
		btnJefesEquipo.setBackground(new Color(0, 128, 255));
		btnJefesEquipo.setIcon(new ImageIcon("images/jequipo.png"));
		btnJefesEquipo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnJefesEquipo.setBounds(10, 11, 173, 70);
		btnJefesEquipo.addActionListener(this);
		panelBotonesMenu.add(btnJefesEquipo);

		btnProyectos = new JButton("  PROYECTOS");
		btnProyectos.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnProyectos.setHorizontalTextPosition(SwingConstants.CENTER);
		btnProyectos.setPressedIcon(new ImageIcon("images/pro.png"));
		btnProyectos.setRolloverIcon(new ImageIcon("images/pr.png"));
		btnProyectos.setForeground(new Color(255, 255, 255));
		btnProyectos.setBorder(null);
		btnProyectos.setBackground(new Color(0, 128, 255));
		btnProyectos.setIcon(new ImageIcon("images/pro.png"));
		btnProyectos.setSelectedIcon(new ImageIcon("images/pro.png"));
		btnProyectos.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnProyectos.setBounds(10, 277, 173, 70);
		btnProyectos.addActionListener(this);
		panelBotonesMenu.add(btnProyectos);

		btnSalir = new JButton("SALIR");
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setPressedIcon(new ImageIcon("images/sal1.png"));
		btnSalir.setBorder(null);
		btnSalir.setBackground(new Color(0, 128, 255));
		btnSalir.setIcon(new ImageIcon("images/sal1.png"));
		btnSalir.setRolloverIcon(new ImageIcon("images/sal2.png"));
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalir.setBounds(0, 485, 173, 70);
		btnSalir.addActionListener(this);
		panelBotonesMenu.add(btnSalir);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (btnEmpleados == e.getSource()) {
			miCoordinador.activarVentanaEmpleados();
		} else if (btnDesarrolladores == e.getSource()) {
			miCoordinador.activarVentanaDesarrolladores();
		} else if (btnJefesEquipo == e.getSource()) {
			miCoordinador.activarVentanaJefesEquipo();
		} else if (btnSalir == e.getSource()) {

			miCoordinador.botonSalir();
		} else if(btnProyectos == e.getSource()) {
			miCoordinador.activarVentanaProyectos();
		}

	}
}
