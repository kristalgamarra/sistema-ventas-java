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

public class DlgConfigurarCuotaDiaria extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCtaDiaria;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgConfigurarCuotaDiaria dialog = new DlgConfigurarCuotaDiaria();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgConfigurarCuotaDiaria() {
		setTitle("Configurar cuota diaria");
		setBounds(100, 100, 450, 113);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		JLabel lblCantOptima = new JLabel("Cuota diaria esperada (S/.)");
		lblCantOptima.setBounds(10, 14, 222, 14);
		contentPanel.add(lblCantOptima);
		
		txtCtaDiaria = new JTextField();
		txtCtaDiaria.setBounds(175, 11, 89, 20);
		contentPanel.add(txtCtaDiaria);
		txtCtaDiaria.setColumns(10);
		txtCtaDiaria.setText(Double.toString(Tienda.cuotaDiaria));
		txtCtaDiaria.setEditable(true);
		
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
		Tienda.cuotaDiaria = Double.parseDouble(txtCtaDiaria.getText());
		JOptionPane.showInternalMessageDialog(null, "Cambio Realizado con Exito", "Aviso", 1, null);
		dispose();
	}
}