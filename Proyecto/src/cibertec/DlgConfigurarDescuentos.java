package cibertec;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgConfigurarDescuentos extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txt1a5;
	private JTextField txt6a10;
	private JTextField txt11a15;
	private JTextField txtMas15;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JLabel lblPorc1;
	private JLabel lblPorc2;
	private JLabel lblPorc3;
	private JLabel lblPorc4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgConfigurarDescuentos dialog = new DlgConfigurarDescuentos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgConfigurarDescuentos() {
		setTitle("Configurar porcentajes de descuento");
		setBounds(100, 100, 450, 204);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		JLabel lbl1a5 = new JLabel("1 a 5 unidades");
		lbl1a5.setBounds(10, 14, 89, 14);
		contentPanel.add(lbl1a5);
		
		JLabel lbl6a10 = new JLabel("6 a 10 unidades");
		lbl6a10.setBounds(10, 51, 89, 14);
		contentPanel.add(lbl6a10);
		
		JLabel lbl11a15 = new JLabel("11 a 15 unidades");
		lbl11a15.setBounds(10, 89, 118, 14);
		contentPanel.add(lbl11a15);
		
		JLabel lblMas15 = new JLabel("M\u00E1s de 15 unidades");
		lblMas15.setBounds(10, 126, 118, 14);
		contentPanel.add(lblMas15);
		
		txt1a5 = new JTextField();
		txt1a5.setBounds(138, 11, 104, 20);
		contentPanel.add(txt1a5);
		txt1a5.setColumns(10);
		txt1a5.setText(Double.toString(Tienda.porcentaje1));
		txt1a5.setEditable(true);

		txt6a10 = new JTextField();
		txt6a10.setBounds(138, 48, 104, 20);
		contentPanel.add(txt6a10);
		txt6a10.setColumns(10);
		txt6a10.setText(Double.toString(Tienda.porcentaje2));
		txt6a10.setEditable(true);
		
		txt11a15 = new JTextField();
		txt11a15.setBounds(138, 86, 104, 20);
		contentPanel.add(txt11a15);
		txt11a15.setColumns(10);
		txt11a15.setText(Double.toString(Tienda.porcentaje3));
		txt11a15.setEditable(true);

		txtMas15 = new JTextField();
		txtMas15.setBounds(138, 123, 104, 20);
		contentPanel.add(txtMas15);
		txtMas15.setColumns(10);
		txtMas15.setText(Double.toString(Tienda.porcentaje4));
		txtMas15.setEditable(true);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(335, 7, 89, 23);
		contentPanel.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(335, 42, 89, 23);
		contentPanel.add(btnCancelar);

		lblPorc1 = new JLabel("%");
		lblPorc1.setBounds(257, 14, 68, 14);
		contentPanel.add(lblPorc1);
	
		lblPorc2 = new JLabel("%");
		lblPorc2.setBounds(257, 51, 68, 14);
		contentPanel.add(lblPorc2);

		lblPorc3 = new JLabel("%");
		lblPorc3.setBounds(257, 89, 68, 14);
		contentPanel.add(lblPorc3);

		lblPorc4 = new JLabel("%");
		lblPorc4.setBounds(257, 126, 68, 14);
		contentPanel.add(lblPorc4);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}
	
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
	
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		Tienda.porcentaje1 = Double.parseDouble(txt1a5.getText());
		Tienda.porcentaje2 = Double.parseDouble(txt6a10.getText());
		Tienda.porcentaje3 = Double.parseDouble(txt11a15.getText());
		Tienda.porcentaje4 = Double.parseDouble(txtMas15.getText());
		JOptionPane.showInternalMessageDialog(null, "Cambio Realizado con Exito", "Aviso", 1, null);
		dispose();
	}
}