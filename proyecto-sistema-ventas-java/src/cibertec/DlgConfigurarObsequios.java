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

public class DlgConfigurarObsequios extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtTipoObs;
	private JTextField txt1a5;
	private JTextField txt6a10;
	private JTextField txt11aMas;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgConfigurarObsequios dialog = new DlgConfigurarObsequios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgConfigurarObsequios() {
		setTitle("Configurar obsequios");
		setBounds(100, 100, 450, 204);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		JLabel lblTipoObs = new JLabel("Tipo de obsequio");
		lblTipoObs.setBounds(10, 14, 89, 14);
		contentPanel.add(lblTipoObs);
		
		JLabel lbl1a5 = new JLabel("1 a 5 unidades");
		lbl1a5.setBounds(10, 51, 89, 14);
		contentPanel.add(lbl1a5);
		
		JLabel lbl6a10 = new JLabel("6 a 10 unidades");
		lbl6a10.setBounds(10, 89, 118, 14);
		contentPanel.add(lbl6a10);
		
		JLabel lbl11aMas = new JLabel("11 a m\u00E1s unidades");
		lbl11aMas.setBounds(10, 126, 118, 14);
		contentPanel.add(lbl11aMas);
		
		txtTipoObs = new JTextField();
		txtTipoObs.setBounds(138, 11, 104, 20);
		contentPanel.add(txtTipoObs);
		txtTipoObs.setColumns(10);
		txtTipoObs.setText(Tienda.tipoObsequio);
		txtTipoObs.setEditable(true);

		txt1a5 = new JTextField();
		txt1a5.setBounds(138, 48, 104, 20);
		contentPanel.add(txt1a5);
		txt1a5.setColumns(10);
		txt1a5.setText(Integer.toString(Tienda.obsequioCantidad1));
		txt1a5.setEditable(true);
		
		txt6a10 = new JTextField();
		txt6a10.setBounds(138, 86, 104, 20);
		contentPanel.add(txt6a10);
		txt6a10.setColumns(10);
		txt6a10.setText(Integer.toString(Tienda.obsequioCantidad2));
		txt6a10.setEditable(true);

		txt11aMas = new JTextField();
		txt11aMas.setBounds(138, 123, 104, 20);
		contentPanel.add(txt11aMas);
		txt11aMas.setColumns(10);
		txt11aMas.setText(Integer.toString(Tienda.obsequioCantidad3));
		txt11aMas.setEditable(true);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(335, 7, 89, 23);
		contentPanel.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(335, 42, 89, 23);
		contentPanel.add(btnCancelar);
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
		Tienda.tipoObsequio = txtTipoObs.getText();
		Tienda.obsequioCantidad1 = Integer.parseInt(txt1a5.getText());
		Tienda.obsequioCantidad2 = Integer.parseInt(txt6a10.getText());
		Tienda.obsequioCantidad3 = Integer.parseInt(txt11aMas.getText());
		JOptionPane.showInternalMessageDialog(null, "Cambio Realizado con Exito", "Aviso", 1, null);
		dispose();
	}
}