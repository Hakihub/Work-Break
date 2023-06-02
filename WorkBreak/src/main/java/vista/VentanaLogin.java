package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

@SuppressWarnings("serial")
public class VentanaLogin extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnEntrar;
	private JLabel lblUsuario;
	private JLabel lblPassword;

	private Coordinador miCoordinador;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JSeparator separator;
	private JSeparator separator_1;
	private JLabel lblNewLabel_3;
	/**
	 * Create the frame.
	 */
	public VentanaLogin() {
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		    setSize(1000, 500);
		    setLocationRelativeTo(this);
		    setUndecorated(true);
		    getContentPane().setLayout(null);
			setTitle("Work&Break");
			setIconImage(Toolkit.getDefaultToolkit().getImage("images/logorbg.png"));
		    setVisible(true);
		iniciarComponentes();

	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

	//
	private void iniciarComponentes() {
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBorder(null);
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField.setSelectionColor(new Color(0, 0, 64));
		textField.setBounds(603, 121, 296, 41);
		contentPane.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBorder(null);
		passwordField.setBounds(603, 259, 296, 41);
		contentPane.add(passwordField);

		btnEntrar = new JButton("");
		btnEntrar.setRolloverIcon(new ImageIcon("images/entrarG.png"));
		btnEntrar.setPressedIcon(new ImageIcon("images/entrarP.png"));
		btnEntrar.setContentAreaFilled(false);
		btnEntrar.setBorder(null);
		btnEntrar.setIcon(new ImageIcon("images/entrarP.png"));
		btnEntrar.setBackground(new Color(255, 255, 255));
		btnEntrar.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setBounds(686, 342, 133, 147);
		btnEntrar.addActionListener(this); // Importante para que oiga el evento de este botón
		contentPane.add(btnEntrar);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("images/clave2.png"));
		lblNewLabel.setBounds(484, 243, 98, 77);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("images/usuario2.png"));
		lblNewLabel_1.setBounds(484, 89, 98, 84);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("images/logorbg.png"));
		lblNewLabel_2.setBounds(806, 0, 194, 110);
		contentPane.add(lblNewLabel_2);
		
		separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 255));
		separator.setBounds(603, 173, 296, 2);
		contentPane.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLUE);
		separator_1.setBounds(603, 304, 296, 2);
		contentPane.add(separator_1);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("images/FondoLogin.png"));
		lblNewLabel_3.setBounds(0, 0, 1000, 500);
		contentPane.add(lblNewLabel_3);
		

	}

	// Es mejor crear este metodo por separado para que sea mas ordenado
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEntrar) {
			JOptionPane.showMessageDialog(null, "Bienvenido");
			miCoordinador.activarVentanaMenu();
			miCoordinador.desactivarVentanaLogin();
			
		}

	}

}
