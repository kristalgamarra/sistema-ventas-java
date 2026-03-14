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
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DlgVender extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblModelo;
	private JLabel lblPrecio;
	private JLabel lblCantidad;
	private JComboBox cboModelo;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JButton btnCerrar;
	private JButton btnVender;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgVender dialog = new DlgVender();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgVender() {
		setTitle("Consultar Ceramico");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 21, 81, 14);
		contentPanel.add(lblModelo);
		
		lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setBounds(10, 57, 81, 14);
		contentPanel.add(lblPrecio);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 92, 81, 14);
		contentPanel.add(lblCantidad);
		
		cboModelo = new JComboBox();
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {"Cinza Plus", "Luxury", "Austria", "Yungay Mix", "Thalia"}));
		cboModelo.setBounds(101, 17, 217, 22);
		contentPanel.add(cboModelo);
		
		txtPrecio = new JTextField();
		txtPrecio.setText("92.56");
		txtPrecio.setBounds(101, 54, 217, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		txtPrecio.setText(Double.toString(Tienda.porcentaje1));
		txtPrecio.setEditable(false);
		
		btnVender = new JButton("Vender");
		btnVender.addActionListener(this);
		btnVender.setBounds(335, 17, 89, 23);
		contentPanel.add(btnVender);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(335, 48, 89, 23);
		contentPanel.add(btnCerrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 127, 414, 123);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(101, 89, 86, 20);
		contentPanel.add(txtCantidad);
		txtCantidad.setColumns(10);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == btnVender) {
			actionPerformedBtnVender(e);
		}
	}
	
	void imprimir(String cad) {
		txtS.append(cad + "\n");
	}
	
	
	private static int numVentas = 0;
	private static double imp_t = 0;
	public static int contVentCinzaPlus, contVentLuxury, contVentAustria, contVentYungay, contVentThalia; 
	public static int contCantCinzaPlus, contCantLuxury, contCantAustria, contCantYungay, contCantThalia;
	public static double montoImpCinzaPlus, montoImpLuxury, montoImpAustria, montoImpYungay, montoImpThalia;
	
	protected void actionPerformedBtnVender(ActionEvent e) {
		String modelo = leerModelo();
		int cant = leerCantidad();
		double precio = calcularPrecio(modelo);
		double imp_c = calcularImpCompra(precio,cant);
		double imp_d = calcularImpDscto(cant, imp_c);
		double imp_p = calcularImpPagar(imp_c, imp_d);
		int ud_obsequios_total = obsequios(cant);
		contabilizarMontosContador(modelo, cant, imp_p);
		
		txtS.setText("BOLETA DE VENTA" + "\n");
		imprimir("Modelo: " + modelo);
		imprimir("Precio: S/." + precio);
		imprimir("Cantidad adquirida: " + cant);
		imprimir("Importe compra: S/." + imp_c);
		imprimir("Importe descuento: S/." + imp_d);
		imprimir("Importe pagar: S/." + imp_p);
		imprimir("Tipo de obsequio: " + Tienda.tipoObsequio);
		imprimir("Unidades obsequiadas: " + ud_obsequios_total);
		
		imp_t+= imp_c;
		numVentas++;
		if(numVentas % 5 == 0) {
			JOptionPane.showMessageDialog(this, 
					"Venta Nro. 5" + "\n"+
							"Importe total general acumulado: S/. " + imp_t + "\n"+
							"Porcentaje de la cuota diaria: "
					, "Avance de ventas", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public String leerModelo(){
		return cboModelo.getSelectedItem().toString();
	}
	
	public int leerCantidad(){
		return Integer.parseInt(txtCantidad.getText());
	}
	
	public double calcularPrecio(String modelo) {
		switch(modelo){
		case "Cinza Plus": return Tienda.precio0;
		case "Luxury": return Tienda.precio1;
		case "Austria": return Tienda.precio2;
		case "Yungay Mix": return Tienda.precio3;
		default: return Tienda.precio4;
		}
	}
	
	public double calcularImpCompra(double precio, int cant){
		return precio * cant;
	}
	
	public double calcularImpDscto(int cant, double imp_c){
		double porc_dscto;
		if(cant >= 1 && cant <=5) {
			porc_dscto = Tienda.porcentaje1;
		}else if(cant >= 6 && cant <=10) {
			porc_dscto = Tienda.porcentaje2;
		}else if(cant >= 11 && cant <=15) {
			porc_dscto = Tienda.porcentaje3;
		}else {
			porc_dscto = Tienda.porcentaje4;
		}
		return imp_c * (porc_dscto / 100);
	}
	
	public double calcularImpPagar(double imp_c, double imp_d){
		return imp_c - imp_d;
	}
	
	public int obsequios(int cant){
		int ud_obsequio;
		if(cant >= 1 && cant <=5) {
			ud_obsequio = Tienda.obsequioCantidad1;
		}else if(cant >= 6 && cant <=10) {
			ud_obsequio = Tienda.obsequioCantidad2;
		}else {
			ud_obsequio = Tienda.obsequioCantidad3;
		}
		return ud_obsequio * cant;
	}
	
	void contabilizarMontosContador(String modelo, int cant, double imp_p){
		switch(modelo){
		case "Cinza Plus": contVentCinzaPlus++; contCantCinzaPlus+= cant; montoImpCinzaPlus+= imp_p; break;
		case "Luxury": contVentLuxury++; contCantLuxury+= cant; montoImpLuxury+= imp_p; break;
		case "Austria": contVentAustria++; contCantAustria+= cant; montoImpAustria+= imp_p; break;
		case "Yungay Mix": contVentYungay++; contCantYungay+= cant; montoImpYungay+= imp_p; break;
		default: contVentThalia++; contCantThalia+= cant; montoImpThalia+= imp_p;
		}
	}
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}
