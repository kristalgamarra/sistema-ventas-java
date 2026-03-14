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

public class DlgModificar extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnCerrar;
	private JButton btnGrabar;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgModificar dialog = new DlgModificar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgModificar() {
		setTitle("Modificar Ceramico");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Modelo");
			lblNewLabel.setBounds(10, 11, 89, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Precio (S/)");
			lblNewLabel_1.setBounds(10, 46, 89, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Ancho (cm)");
			lblNewLabel_2.setBounds(10, 83, 89, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Largo (cm)");
			lblNewLabel_3.setBounds(10, 121, 89, 14);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Espesor (mm)");
			lblNewLabel_4.setBounds(10, 158, 89, 14);
			contentPanel.add(lblNewLabel_4);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Contenido");
			lblNewLabel_5.setBounds(10, 195, 89, 14);
			contentPanel.add(lblNewLabel_5);
		}
		{
			comboBox = new JComboBox();
			comboBox.addActionListener(this);
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Cinza Plus", "Luxury", "Austria", "Yungay Mix", "Thalia"}));
			comboBox.setBounds(109, 7, 208, 22);
			contentPanel.add(comboBox);
		}
		{
			textField = new JTextField(Tienda.modelo0);
			textField.setText("92.56");
			textField.setBounds(109, 43, 208, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			textField_1 = new JTextField(Tienda.ancho0 + "");
			textField_1.setText("62.0");
			textField_1.setBounds(109, 80, 208, 20);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			textField_2 = new JTextField(Tienda.largo0 + "");
			textField_2.setText("62.0");
			textField_2.setBounds(109, 118, 208, 20);
			contentPanel.add(textField_2);
			textField_2.setColumns(10);
		}
		{
			textField_3 = new JTextField(Tienda.espesor0 + "");
			textField_3.setText("8");
			textField_3.setBounds(109, 155, 208, 20);
			contentPanel.add(textField_3);
			textField_3.setColumns(10);
		}
		{
			textField_4 = new JTextField(Tienda.contenido0);
			textField_4.setText("6");
			textField_4.setBounds(109, 192, 208, 20);
			contentPanel.add(textField_4);
			textField_4.setColumns(10);
		}
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(335, 7, 89, 23);
			contentPanel.add(btnCerrar);
		}
		{
			btnGrabar = new JButton("Grabar");
			btnGrabar.addActionListener(this);
			btnGrabar.setBounds(335, 42, 89, 23);
			contentPanel.add(btnGrabar);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == comboBox) {
			actionPerformedComboBox(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	
	public String leerModelo(){
		return comboBox.getSelectedItem().toString();
	}
	
	protected void actionPerformedComboBox(ActionEvent e) {
		String modelo = leerModelo();
		switch (modelo) {
		case "Cinza Plus":
			textField.setText(Tienda.modelo0);
			textField.setText(Tienda.precio0 + "");
			textField_1.setText(Tienda.ancho0 + "");
			textField_2.setText(Tienda.largo0 + "");
			textField_3.setText(Tienda.espesor0 + "");
			textField_4.setText(Tienda.contenido0 + "");
			break;
		case "Luxury":
			textField.setText(Tienda.modelo1);
			textField.setText(Tienda.precio1 + "");
			textField_1.setText(Tienda.ancho1 + "");
			textField_2.setText(Tienda.largo1 + "");
			textField_3.setText(Tienda.espesor1 + "");
			textField_4.setText(Tienda.contenido1 + "");
			break;
		case "Austria":
			textField.setText(Tienda.modelo2);
			textField.setText(Tienda.precio2 + "");
			textField_1.setText(Tienda.ancho2 + "");
			textField_2.setText(Tienda.largo2 + "");
			textField_3.setText(Tienda.espesor2 + "");
			textField_4.setText(Tienda.contenido2 + "");
			break;
		case "Yungay Mix":
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
	protected void actionPerformedBtnGrabar(ActionEvent arg0) {	
		String modelo = leerModelo();
		if (modelo == "Cinza Plus") {
			Tienda.precio0 = Double.parseDouble(textField.getText());
			Tienda.ancho0 = Double.parseDouble(textField_1.getText());
			Tienda.largo0 = Double.parseDouble(textField_2.getText());
			Tienda.espesor0 = Double.parseDouble(textField_3.getText());
			Tienda.contenido0 = Integer.parseInt(textField_4.getText());
		}else if (modelo == "Luxury") {
			Tienda.precio1 = Double.parseDouble(textField.getText());
			Tienda.ancho1 = Double.parseDouble(textField_1.getText());
			Tienda.largo1 = Double.parseDouble(textField_2.getText());
			Tienda.espesor1 = Double.parseDouble(textField_3.getText());
			Tienda.contenido1 = Integer.parseInt(textField_4.getText());
		}else if (modelo == "Austria") {
			Tienda.precio2 = Double.parseDouble(textField.getText());
			Tienda.ancho2 = Double.parseDouble(textField_1.getText());
			Tienda.largo2 = Double.parseDouble(textField_2.getText());
			Tienda.espesor2 = Double.parseDouble(textField_3.getText());
			Tienda.contenido2 = Integer.parseInt(textField_4.getText());
		}else if (modelo == "Yungay Mix") {
			Tienda.precio3 = Double.parseDouble(textField.getText());
			Tienda.ancho3 = Double.parseDouble(textField_1.getText());
			Tienda.largo3 = Double.parseDouble(textField_2.getText());
			Tienda.espesor3 = Double.parseDouble(textField_3.getText());
			Tienda.contenido3 = Integer.parseInt(textField_4.getText());
		}else {
			Tienda.precio4 = Double.parseDouble(textField.getText());
			Tienda.ancho4 = Double.parseDouble(textField_1.getText());
			Tienda.largo4 = Double.parseDouble(textField_2.getText());
			Tienda.espesor4 = Double.parseDouble(textField_3.getText());
			Tienda.contenido4 = Integer.parseInt(textField_4.getText());
		}
		JOptionPane.showInternalMessageDialog(null, "Datos Guardados con Exito", "Aviso", 1, null);
		dispose();
	}
	}