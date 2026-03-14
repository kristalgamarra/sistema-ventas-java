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

public class DlgConsultar extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JComboBox comboBox;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgConsultar dialog = new DlgConsultar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgConsultar() {
		setTitle("Consultar Ceramico");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("Modelo");
		lblNewLabel.setBounds(10, 21, 81, 14);
		contentPanel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Precio (S/)");
		lblNewLabel_1.setBounds(10, 57, 81, 14);
		contentPanel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Ancho (cm)");
		lblNewLabel_2.setBounds(10, 92, 81, 14);
		contentPanel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Largo (cm)");
		lblNewLabel_3.setBounds(10, 127, 81, 14);
		contentPanel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Espesor (mm)");
		lblNewLabel_4.setBounds(10, 165, 81, 14);
		contentPanel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Contenido");
		lblNewLabel_5.setBounds(10, 200, 81, 14);
		contentPanel.add(lblNewLabel_5);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(this);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Cinza Plus", "Luxury", "Austria", "Yungay Mix", "Thalia"}));
		comboBox.setBounds(101, 17, 217, 22);
		contentPanel.add(comboBox);
		
		textField = new JTextField(Tienda.modelo0);
		textField.setEditable(false);
		textField.setText("92.56");
		textField.setBounds(101, 54, 217, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField(Tienda.ancho0 + "");
		textField_1.setEditable(false);
		textField_1.setText("62.0");
		textField_1.setBounds(101, 89, 217, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField(Tienda.largo0 + "");
		textField_2.setEditable(false);
		textField_2.setText("62.0");
		textField_2.setBounds(101, 124, 217, 20);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField(Tienda.espesor0 + "");
		textField_3.setEditable(false);
		textField_3.setText("8");
		textField_3.setBounds(101, 162, 217, 20);
		contentPanel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField(Tienda.contenido0);
		textField_4.setEditable(false);
		textField_4.setText("6");
		textField_4.setBounds(101, 197, 217, 20);
		contentPanel.add(textField_4);
		textField_4.setColumns(10);
		
		btnNewButton = new JButton("Cerrar");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(335, 17, 89, 23);
		contentPanel.add(btnNewButton);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == comboBox) {
			actionPerformedComboBox(e);
		}
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		dispose();
	}
	protected void actionPerformedComboBox(ActionEvent e) {
		switch (comboBox.getSelectedIndex()) {
		case 0:
			textField.setText(Tienda.modelo0);
			textField.setText(Tienda.precio0 + "");
			textField_1.setText(Tienda.ancho0 + "");
			textField_2.setText(Tienda.largo0 + "");
			textField_3.setText(Tienda.espesor0 + "");
			textField_4.setText(Tienda.contenido0 + "");
			break;
		case 1:
			textField.setText(Tienda.modelo1);
			textField.setText(Tienda.precio1 + "");
			textField_1.setText(Tienda.ancho1 + "");
			textField_2.setText(Tienda.largo1 + "");
			textField_3.setText(Tienda.espesor1 + "");
			textField_4.setText(Tienda.contenido1 + "");
			break;
		case 2:
			textField.setText(Tienda.modelo2);
			textField.setText(Tienda.precio2 + "");
			textField_1.setText(Tienda.ancho2 + "");
			textField_2.setText(Tienda.largo2 + "");
			textField_3.setText(Tienda.espesor2 + "");
			textField_4.setText(Tienda.contenido2 + "");
			break;
		case 3:
			textField.setText(Tienda.modelo3);
			textField.setText(Tienda.precio3 + "");
			textField_1.setText(Tienda.ancho3 + "");
			textField_2.setText(Tienda.largo3 + "");
			textField_3.setText(Tienda.espesor3 + "");
			textField_4.setText(Tienda.contenido3 + "");
			break;
		default:
			textField.setText(Tienda.modelo4);
			textField.setText(Tienda.precio4 + "");
			textField_1.setText(Tienda.ancho4 + "");
			textField_2.setText(Tienda.largo4 + "");
			textField_3.setText(Tienda.espesor4 + "");
			textField_4.setText(Tienda.contenido4 + "");
			break;
		}
	}
}
