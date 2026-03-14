package cibertec;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Tienda extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	// Datos m�nimos del primer colch�n
	public static String modelo0 = "Cinza Plus";
	public static double precio0 = 92.56;
	public static double ancho0 = 62.0;
	public static double largo0 = 62.0;
	public static double espesor0 = 8;
	public static int contenido0 = 6;
	
	// Datos m�nimos del segundo colch�n
	public static String modelo1 = "Luxury";
	public static double precio1 = 42.77;
	public static double ancho1 = 60;
	public static double largo1 = 60;
	public static double espesor1 = 8.5;
	public static int contenido1 = 4;
	
	// Datos m�nimos del tercer colch�n
	public static String modelo2 = "Austria";
	public static double precio2 = 52.45;
	public static double ancho2 = 45;
	public static double largo2 = 45;
	public static double espesor2 = 6.5;
	public static int contenido2 = 12;
	
	// Datos m�nimos del cuarto colch�n
	public static String modelo3 = "Yungay Mix";
	public static double precio3 = 55.89;
	public static double ancho3 = 80;
	public static double largo3 = 120;
	public static double espesor3 = 6.8;
	public static int contenido3 = 9;
	
	
	// Datos m�nimos del quinto colch�n
	public static String modelo4 = "Thalia";
	public static double precio4 = 45;
	public static double ancho4 = 45;
	public static double largo4 = 11.8;
	public static double espesor4 = 7.2;
	public static int contenido4 = 10;

	
	// Porcentajes de descuento
	public static double porcentaje1 = 7.5;
	public static double porcentaje2 = 10.0;
	public static double porcentaje3 = 12.5;
	public static double porcentaje4 = 15.0;
	
	//Obsequio
	public static String tipoObsequio = "Lapicero";
	public static int obsequioCantidad1 = 2;
	public static int obsequioCantidad2 = 3;
	public static int obsequioCantidad3 = 4;
	
	// Cantidad optima de unidades vendidas por dia
	public static int cantidadOptima = 10;
	
	// Cuota diaria
	public static double cuotaDiaria = 30000;

	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_2;
	private JMenu mnNewMenu_3;
	private JMenu mnNewMenu_4;
	private JMenuItem menuSalir;
	private JMenuItem menuConsultarCeramico;
	private JMenuItem menuModificarCeramico;
	private JMenuItem menuListarCeramicos;
	private JMenuItem menuVender;
	private JMenuItem menuGenerarReportes;
	private JMenuItem menuConfigDsctos;
	private JMenuItem menuConfigObs;
	private JMenuItem menuConfigCantOptima;
	private JMenuItem menuConfigCtaDiaria;
	private JMenuItem menuAcercaTienda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tienda frame = new Tienda();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tienda() {
		setTitle("Tienda 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 307);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);
		
		menuSalir = new JMenuItem("Salir");
		menuSalir.addActionListener(this);
		mnNewMenu.add(menuSalir);
		
		mnNewMenu_1 = new JMenu("Mantenimiento");
		menuBar.add(mnNewMenu_1);
		
		menuConsultarCeramico = new JMenuItem("Consultar cer\u00E1mico ");
		menuConsultarCeramico.addActionListener(this);
		mnNewMenu_1.add(menuConsultarCeramico);
		
		menuModificarCeramico = new JMenuItem("Modificar cer\u00E1mico");
		menuModificarCeramico.addActionListener(this);
		mnNewMenu_1.add(menuModificarCeramico);
		
		menuListarCeramicos = new JMenuItem("Listar cer\u00E1micos");
		menuListarCeramicos.addActionListener(this);
		mnNewMenu_1.add(menuListarCeramicos);
		
		mnNewMenu_2 = new JMenu("Ventas");
		menuBar.add(mnNewMenu_2);
		
		menuVender = new JMenuItem("Vender");
		menuVender.addActionListener(this);
		mnNewMenu_2.add(menuVender);
		
		menuGenerarReportes = new JMenuItem("Generar reportes");
		menuGenerarReportes.addActionListener(this);
		mnNewMenu_2.add(menuGenerarReportes);
		
		mnNewMenu_3 = new JMenu("Configuraci\u00F3n");
		menuBar.add(mnNewMenu_3);
		
		menuConfigDsctos = new JMenuItem("Configurar descuentos");
		menuConfigDsctos.addActionListener(this);
		mnNewMenu_3.add(menuConfigDsctos);
		
		menuConfigObs = new JMenuItem("Configurar obsequios");
		menuConfigObs.addActionListener(this);
		mnNewMenu_3.add(menuConfigObs);
		
		menuConfigCantOptima = new JMenuItem("Configurar cantidad \u00F3ptima");
		menuConfigCantOptima.addActionListener(this);
		mnNewMenu_3.add(menuConfigCantOptima);
		
		menuConfigCtaDiaria = new JMenuItem("Configurar cuota diaria");
		menuConfigCtaDiaria.addActionListener(this);
		mnNewMenu_3.add(menuConfigCtaDiaria);
		
		mnNewMenu_4 = new JMenu("Ayuda");
		menuBar.add(mnNewMenu_4);
		
		menuAcercaTienda = new JMenuItem("Acerca de Tienda");
		menuAcercaTienda.addActionListener(this);
		mnNewMenu_4.add(menuAcercaTienda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menuSalir) {
			actionPerformedMenuSalir(e);
		}
		if (e.getSource() == menuConsultarCeramico) {
			actionPerformedMenuConsultarCeramico(e);
		}
		if (e.getSource() == menuModificarCeramico) {
			actionPerformedModificarCeramico(e);
		}
		if (e.getSource() == menuListarCeramicos) {
			actionPerformedListarCeramicos(e);
		}
		if (e.getSource() == menuVender) {
			actionPerformedMenuVender(e);
		}
		if (e.getSource() == menuGenerarReportes) {
			actionPerformedMenuGenerarReportes(e);
		}
		if (e.getSource() == menuConfigDsctos) {
			actionPerformedMenuConfigDsctos(e);
		}
		if (e.getSource() == menuConfigObs) {
			actionPerformedMenuConfigObs(e);
		}
		if (e.getSource() == menuConfigCantOptima) {
			actionPerformedMenuConfigCantOptima(e);
		}
		if (e.getSource() == menuConfigCtaDiaria) {
			actionPerformedMenuConfigCtaDiaria(e);
		}
		if (e.getSource() == menuAcercaTienda) {
			actionPerformedMenuAcercaTienda(e);
		}
	}
	
	protected void actionPerformedMenuSalir(ActionEvent e) {
		System.exit(0);
	}
	
	protected void actionPerformedMenuConsultarCeramico(ActionEvent e) {
		DlgConsultar d = new DlgConsultar();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	
	protected void actionPerformedModificarCeramico(ActionEvent e) {
		DlgModificar d = new DlgModificar();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	protected void actionPerformedListarCeramicos(ActionEvent e) {
		DlgListar d = new DlgListar();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	protected void actionPerformedMenuVender(ActionEvent e) {
		DlgVender d = new DlgVender();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	protected void actionPerformedMenuGenerarReportes(ActionEvent e) {
		DlgGenerarReportes d = new DlgGenerarReportes();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	protected void actionPerformedMenuConfigDsctos(ActionEvent e) {
		DlgConfigurarDescuentos d = new DlgConfigurarDescuentos();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	protected void actionPerformedMenuConfigObs(ActionEvent e) {
		DlgConfigurarObsequios d = new DlgConfigurarObsequios();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	
	protected void actionPerformedMenuConfigCantOptima(ActionEvent e) {
		DlgConfigurarCantOptima d = new DlgConfigurarCantOptima();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	
	protected void actionPerformedMenuConfigCtaDiaria(ActionEvent e) {
		DlgConfigurarCuotaDiaria d = new DlgConfigurarCuotaDiaria();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	protected void actionPerformedMenuAcercaTienda(ActionEvent e) {
		DlgAcercaTienda d = new DlgAcercaTienda();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
}
