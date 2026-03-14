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

public class DlgGenerarReportes extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblTipodeReporte;
	private JComboBox cboReporte;
	private JButton btnCerrar;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgGenerarReportes dialog = new DlgGenerarReportes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgGenerarReportes() {
		setTitle("Consultar Ceramico");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblTipodeReporte = new JLabel("Tipo de reporte");
		lblTipodeReporte.setBounds(10, 21, 81, 14);
		contentPanel.add(lblTipodeReporte);
		
		cboReporte = new JComboBox();
		cboReporte.addActionListener(this);
		cboReporte.setModel(new DefaultComboBoxModel(new String[] {"Ventas por modelo", "Comparacion de precios con el precio promedio", "Comparacion de cajas vendidas con la cantidad optima", "Estadistica sobre el precio"}));
		cboReporte.setBounds(101, 17, 217, 22);
		contentPanel.add(cboReporte);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(335, 17, 89, 23);
		contentPanel.add(btnCerrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 53, 414, 197);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == cboReporte) {
			actionPerformedCboModelo(e);
		}
	}
	
	void imprimir(String cad) {
		txtS.append(cad + "\n");
	}
	
	protected void actionPerformedCboModelo(ActionEvent e) {
		String reporte = leerReporte();
		double precioPromedio = calcularPrecioPromedio();
		double preMayor = calcularPrecioMayor();
		double preMenor = calcularPrecioMenor();
		switch(reporte){
		case "Ventas por modelo": ventasPorModelo(); break;
		case "Comparacion de precios con el precio promedio": comparacionPrecios(precioPromedio); break;
		case "Comparacion de cajas vendidas con la cantidad optima": comparacionCajasVendidas(precioPromedio); break;
		default: estadisticas(precioPromedio, preMayor, preMenor);
		}
	}
	
	public String leerReporte(){
		return cboReporte.getSelectedItem().toString();
	}
	
	void ventasPorModelo() {
		txtS.setText("VENTAS POR MODELO" + "\n");
		imprimir("Modelo: " + Tienda.modelo0);
		imprimir("Cantidad de ventas: " + DlgVender.contVentCinzaPlus);
		imprimir("Cantidad de cajas vendidas: " + DlgVender.contCantCinzaPlus);
		imprimir("Importe total vendido: S/." + DlgVender.montoImpCinzaPlus);
		imprimir("\n");
		
		imprimir("Modelo: " + Tienda.modelo1);
		imprimir("Cantidad de ventas: " + DlgVender.contVentLuxury);
		imprimir("Cantidad de cajas vendidas: " + DlgVender.contCantLuxury);
		imprimir("Importe total vendido: S/." + DlgVender.montoImpLuxury);
		imprimir("\n");
		
		imprimir("Modelo: " + Tienda.modelo2);
		imprimir("Cantidad de ventas: " + DlgVender.contVentAustria);
		imprimir("Cantidad de cajas vendidas: " + DlgVender.contCantAustria);
		imprimir("Importe total vendido: S/." + DlgVender.montoImpAustria);
		imprimir("\n");
		
		imprimir("Modelo: " + Tienda.modelo3);
		imprimir("Cantidad de ventas: " + DlgVender.contVentYungay);
		imprimir("Cantidad de cajas vendidas: " + DlgVender.contCantYungay);
		imprimir("Importe total vendido: S/." + DlgVender.montoImpYungay);
		imprimir("\n");
		
		imprimir("Modelo: " + Tienda.modelo4);
		imprimir("Cantidad de ventas: " + DlgVender.contVentThalia);
		imprimir("Cantidad de cajas vendidas: " + DlgVender.contCantThalia);
		imprimir("Importe total vendido: S/." + DlgVender.montoImpThalia);
	}
	
	public double calcularPrecioPromedio(){
		return (Tienda.precio0 + Tienda.precio1 + Tienda.precio2 + Tienda.precio3 + Tienda.precio4) / 5;
	}
	
	void comparacionPrecios(double precioPromedio) {
		double diferencia;
		
		txtS.setText("COMPARACION DE PRECIOS CON EL PRECIO PROMEDIO" + "\n");
		imprimir("Modelo: " + Tienda.modelo0);
		imprimir("Precio: " + Tienda.precio0);
		imprimir("Precio promedio: " + precioPromedio);
		
		if(precioPromedio > Tienda.precio0) {
			diferencia = precioPromedio - Tienda.precio0;
			imprimir("Comparacion: " + diferencia + " menos que el promedio");
	    }else {
	    	diferencia = Tienda.precio0 - precioPromedio;
	    	imprimir("Comparacion: " + diferencia + " mas que el promedio");
	    }
		
		imprimir("\n");
		
		imprimir("Modelo: " + Tienda.modelo1);
		imprimir("Precio: " + Tienda.precio1);
		imprimir("Precio promedio: " + precioPromedio);
		
		if(precioPromedio > Tienda.precio1) {
			diferencia = precioPromedio - Tienda.precio1;
			imprimir("Comparacion: " + diferencia + " menos que el promedio");
	    }else {
	    	diferencia = Tienda.precio1 - precioPromedio;
	    	imprimir("Comparacion: " + diferencia + " mas que el promedio");
	    }
		
		imprimir("\n");
		
		imprimir("Modelo: " + Tienda.modelo2);
		imprimir("Precio: " + Tienda.precio2);
		imprimir("Precio promedio: " + precioPromedio);
		
		if(precioPromedio > Tienda.precio2) {
			diferencia = precioPromedio - Tienda.precio2;
			imprimir("Comparacion: " + diferencia + " menos que el promedio");
	    }else {
	    	diferencia = Tienda.precio2 - precioPromedio;
	    	imprimir("Comparacion: " + diferencia + " mas que el promedio");
	    }
		
		imprimir("\n");
		
		imprimir("Modelo: " + Tienda.modelo3);
		imprimir("Precio: " + Tienda.precio3);
		imprimir("Precio promedio: " + precioPromedio);
		
		if(precioPromedio > Tienda.precio3) {
			diferencia= precioPromedio - Tienda.precio3;
			imprimir("Comparacion: " + diferencia + " menos que el promedio");
	    }else {
	    	diferencia = Tienda.precio3 - precioPromedio;
	    	imprimir("Comparacion: " + diferencia + " mas que el promedio");
	    }
		
		imprimir("\n");
		
		imprimir("Modelo: " + Tienda.modelo4);
		imprimir("Precio: " + Tienda.precio4);
		imprimir("Precio promedio: " + precioPromedio);
		
		if(precioPromedio > Tienda.precio4) {
			diferencia = precioPromedio - Tienda.precio4;
			imprimir("Comparacion: " + diferencia + " menos que el promedio");
	    }else {
	    	diferencia = Tienda.precio4 - precioPromedio;
	    	imprimir("Comparacion: " + diferencia + " mas que el promedio");
	    }
	}
	
	void comparacionCajasVendidas(double precioPromedio) {
		int diferencia;
		
		txtS.setText("COMPARACI�N DE CAJAS VENDIDAS CON LA CANTIDAD �PTIMA" + "\n");
		imprimir("Modelo: " + Tienda.modelo0);
		imprimir("Cantidad de cajas vendidas: " + DlgVender.contCantCinzaPlus);
		imprimir("Cantidad optima: " + Tienda.cantidadOptima);
		
		if(DlgVender.contCantCinzaPlus > Tienda.cantidadOptima) {
			diferencia = DlgVender.contCantCinzaPlus - Tienda.cantidadOptima;
			imprimir("Comparacion: " + diferencia + " m�s que la cantidad optima");
	    }else if(DlgVender.contCantCinzaPlus < Tienda.cantidadOptima) {
	    	diferencia = Tienda.cantidadOptima - DlgVender.contCantCinzaPlus;
	    	imprimir("Comparacion: " + diferencia + " menos que la cantidad optima");
	    }else {
	    	imprimir("Comparacion: igual que la cantidad optima");
	    }
		
		imprimir("\n");
		
		imprimir("Modelo: " + Tienda.modelo1);
		imprimir("Cantidad de cajas vendidas: " + DlgVender.contCantLuxury);
		imprimir("Cantidad optima: " + Tienda.cantidadOptima);
		
		if(DlgVender.contCantLuxury > Tienda.cantidadOptima) {
			diferencia = DlgVender.contCantLuxury - Tienda.cantidadOptima;
			imprimir("Comparacion: " + diferencia + " mas que la cantidad optima");
	    }else if(DlgVender.contCantLuxury < Tienda.cantidadOptima) {
	    	diferencia = Tienda.cantidadOptima - DlgVender.contCantLuxury;
	    	imprimir("Comparacion: " + diferencia + " menos que la cantidad optima");
	    }else {
	    	imprimir("Comparacion: igual que la cantidad optima");
	    }
		
		imprimir("\n");
		
		imprimir("Modelo: " + Tienda.modelo2);
		imprimir("Cantidad de cajas vendidas: " + DlgVender.contCantAustria);
		imprimir("Cantidad optima: " + Tienda.cantidadOptima);
		
		if(DlgVender.contCantAustria > Tienda.cantidadOptima) {
			diferencia = DlgVender.contCantAustria - Tienda.cantidadOptima;
			imprimir("Comparacion: " + diferencia + " mas que la cantidad optima");
	    }else if(DlgVender.contCantAustria < Tienda.cantidadOptima) {
	    	diferencia = Tienda.cantidadOptima - DlgVender.contCantAustria;
	    	imprimir("Comparacion: " + diferencia + " menos que la cantidad optima");
	    }else {
	    	imprimir("Comparacion: igual que la cantidad optima");
	    }
		
		imprimir("\n");
		
		imprimir("Modelo: " + Tienda.modelo3);
		imprimir("Cantidad de cajas vendidas: " + DlgVender.contCantYungay);
		imprimir("Cantidad optima: " + Tienda.cantidadOptima);
		
		if(DlgVender.contCantYungay > Tienda.cantidadOptima) {
			diferencia = DlgVender.contCantYungay - Tienda.cantidadOptima;
			imprimir("Comparacion: " + diferencia + " mas que la cantidad optima");
	    }else if(DlgVender.contCantYungay < Tienda.cantidadOptima) {
	    	diferencia = Tienda.cantidadOptima - DlgVender.contCantYungay;
	    	imprimir("Comparacion: " + diferencia + " menos que la cantidad optima");
	    }else {
	    	imprimir("Comparacion: igual que la cantidad optima");
	    }
		
		imprimir("\n");
		
		imprimir("Modelo: " + Tienda.modelo4);
		imprimir("Cantidad de cajas vendidas: " + DlgVender.contCantThalia);
		imprimir("Cantidad optima: " + Tienda.cantidadOptima);
		
		if(DlgVender.contCantThalia > Tienda.cantidadOptima) {
			diferencia = DlgVender.contCantThalia - Tienda.cantidadOptima;
			imprimir("Comparacion: " + diferencia + " mas que la cantidad optima");
	    }else if(DlgVender.contCantThalia < Tienda.cantidadOptima) {
	    	diferencia = Tienda.cantidadOptima - DlgVender.contCantThalia;
	    	imprimir("Comparacion: " + diferencia + " menos que la cantidad optima");
	    }else {
	    	imprimir("Comparacion: igual que la cantidad optima");
	    }
		
		imprimir("\n");
	}
	
	public double calcularPrecioMayor() {
		int i;
		double[] precios = {Tienda.precio0, Tienda.precio1, Tienda.precio2, Tienda.precio3, Tienda.precio4};
		double precioMayor = precios[0];
		for(i = 0; i < precios.length; i++) {
			if (precios[i] > precioMayor) {
		        return precioMayor = precios[i];
		    }
		}
		return precioMayor;
	}
	
	public double calcularPrecioMenor() {
		int i;
		double[] precios = {Tienda.precio0, Tienda.precio1, Tienda.precio2, Tienda.precio3, Tienda.precio4};
		double precioMenor = precios[0];
		for(i = 0; i < precios.length; i++) {
			if (precios[i] < precioMenor) {
		        return precioMenor = precios[i];
		    }
		}
		return precioMenor;
	}
	
	void estadisticas(double precioPromedio, double preMayor, double preMenor) {
		txtS.setText("ESTADISTICA SOBRE EL PRECIO" + "\n");
		imprimir("Precio promedio : S/." + precioPromedio);
		imprimir("Precio mayor : S/." + preMayor);
		imprimir("Precio menor : S/." + preMenor);
	}
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}
