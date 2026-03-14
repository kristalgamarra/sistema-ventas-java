package cibertec;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.Color;

public class DlgAcercaTienda extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblTienda;
	private JLabel lblAutores;
	private JButton btnCerrar;
	private JTable table;
	private JLabel lblKristalGamarra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgAcercaTienda dialog = new DlgAcercaTienda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgAcercaTienda() {
		setTitle("Acerca de Tienda");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblTienda = new JLabel("Tienda 1.0");
		lblTienda.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTienda.setBounds(166, 22, 102, 14);
		contentPanel.add(lblTienda);
		
		lblAutores = new JLabel("Autores");
		lblAutores.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAutores.setBounds(184, 69, 55, 14);
		contentPanel.add(lblAutores);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(173, 215, 89, 23);
		contentPanel.add(btnCerrar);
		
		table = new JTable();
		table.setBackground(Color.BLACK);
		table.setBounds(10, 47, 404, 1);
		contentPanel.add(table);
		
		lblKristalGamarra = new JLabel("Kristal Gamarra");
		lblKristalGamarra.setBounds(166, 124, 102, 14);
		contentPanel.add(lblKristalGamarra);
		

	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}
