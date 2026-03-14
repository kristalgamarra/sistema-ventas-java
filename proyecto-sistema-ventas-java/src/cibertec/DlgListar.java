package cibertec;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgListar extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private JTextArea txtAreaListado;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgListar dialog = new DlgListar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgListar() {
		setTitle("Listado de Ceramicos");
		setBounds(100, 100, 450, 315);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 434, 233);
		contentPanel.add(scrollPane);
		
		txtAreaListado = new JTextArea();
		scrollPane.setViewportView(txtAreaListado);
		txtAreaListado.setColumns(10);
		
		btnNewButton = new JButton("Cerrar");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(120, 244, 89, 23);
		contentPanel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Listar");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setBounds(234, 244, 89, 23);
		contentPanel.add(btnNewButton_1);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton_1) {
			actionPerformedBtnNewButton_1(e);
		}
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		dispose();
	}
	protected void actionPerformedBtnNewButton_1(ActionEvent e) {
		txtAreaListado.setText("LISTADO DE CERAMICOS" + "\n");
		txtAreaListado.append("\n");
		
		txtAreaListado.append("Modelo : " + Tienda.modelo0 + "\n");
		txtAreaListado.append("Precio (S/): " + Tienda.precio0 + "\n");
		txtAreaListado.append("Ancho (cm): "  + Tienda.ancho0 + "\n");
		txtAreaListado.append("Largo (cm): "  + Tienda.largo0 + "\n");
		txtAreaListado.append("Espesor (mm): " + Tienda.espesor0 + "\n");
		txtAreaListado.append("Contenido : " + Tienda.contenido0 + "\n");
		txtAreaListado.append("\n");
		
		txtAreaListado.append("Modelo : " + Tienda.modelo1 + "\n");
		txtAreaListado.append("Precio (S/): "+ Tienda.precio1 + "\n");
		txtAreaListado.append("Ancho (cm): " + Tienda.ancho1 + "\n");
		txtAreaListado.append("Largo (cm): "+ Tienda.largo1 + "\n");
		txtAreaListado.append("Espesor (mm): "+ Tienda.espesor1 + "\n");
		txtAreaListado.append("Contenido : " + Tienda.contenido1 + "\n");
		txtAreaListado.append("\n");
		
		txtAreaListado.append("Modelo : " + Tienda.modelo2 + "\n");
		txtAreaListado.append("Precio (S/): "+ Tienda.precio2 + "\n");
		txtAreaListado.append("Ancho (cm): "+ Tienda.ancho2 + "\n");
		txtAreaListado.append("Largo (cm): "+ Tienda.largo2 + "\n");
		txtAreaListado.append("Espesor (mm): "+ Tienda.espesor2 + "\n");
		txtAreaListado.append("Contenido : " + Tienda.contenido2 + "\n");
		txtAreaListado.append("\n");
		
		txtAreaListado.append("Modelo : " + Tienda.modelo3 + "\n");
		txtAreaListado.append("Precio (S/): "+ Tienda.precio3 + "\n");
		txtAreaListado.append("Ancho (cm): "+ Tienda.ancho3 + "\n");
		txtAreaListado.append("Largo (cm): "+ Tienda.largo3 + "\n");
		txtAreaListado.append("Espesor (mm): "+ Tienda.espesor3 + "\n");
		txtAreaListado.append("Contenido : " + Tienda.contenido3 + "\n");
		txtAreaListado.append("\n");
		
		txtAreaListado.append("Modelo : " + Tienda.modelo4 + "\n");
		txtAreaListado.append("Precio (S/): "+ Tienda.precio4 + "\n");
		txtAreaListado.append("Ancho (cm): "+ Tienda.ancho4 + "\n");
		txtAreaListado.append("Largo (cm): "+ Tienda.largo4 + "\n");
		txtAreaListado.append("Espesor (mm): "+ Tienda.espesor4 + "\n");
		txtAreaListado.append("Contenido : " + Tienda.contenido4 + "\n");	
	}
}
