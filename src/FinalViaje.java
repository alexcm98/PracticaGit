import java.awt.EventQueue;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FinalViaje {

	protected JFrame framevi;
	private JTextField textSuplementos;
	private JTextField textPagado;
	private JTextField textCambio;
	private JLabel label;
	
	private static int hora;
	private static int dia;
	private static int minuto;
	private static int segundo;
	private static int hora1;
	private static int dia1;
	private static int minuto1;
	private static int segundo1;
	private JLabel labelPrecio1;
	private JLabel label_1;
	private float total;
	Calendar fecha = Calendar.getInstance();

	/**
	 * Create the application.
	 */
	public FinalViaje() {
		initialize();
	}

	/**
	 * Metodos
	 */
private void Comenzar1(){
	 dia1 = fecha.get(Calendar.DAY_OF_WEEK);
	 hora1 = fecha.get(Calendar.HOUR_OF_DAY);
	 minuto1 = fecha.get(Calendar.MINUTE);
	 segundo1 = fecha.get(Calendar.SECOND);
}
	private  void ComenzarTiempo() {

		Calendar fecha = Calendar.getInstance();

		dia = fecha.get(Calendar.DAY_OF_WEEK);
		hora = fecha.get(Calendar.HOUR_OF_DAY);
		minuto = fecha.get(Calendar.MINUTE);
		segundo = fecha.get(Calendar.SECOND);

		if (dia <= 5) {
			label.setText("3.65$");
		} else {
			label.setText("4.55$");
		}

	}

	private static String validarSuplementos(String cantidad) {
		String cadena = "";

		try {
			int num = Integer.parseInt(cantidad);
		} catch (Exception e) {
			cadena = "ERROR: solo se aceptan numeros en los suplementos";
		}
		return cadena;
	}

	private static String validarCambio(String cantidad) {
		String cadena = "";

		try {
			int num = Integer.parseInt(cantidad);
		} catch (Exception e) {
			cadena = "ERROR: solo se aceptan numeros en el cambio";
		}
		return cadena;
	}

	private  void  actualizarCambio(String cantidad){
		
		float num = Integer.parseInt(cantidad);
		
		num = num -total;
		
		textCambio.setText(num+"$");
		
		
	}
	private  void ComprobarTotal(int hora1,int minuto1,int segundo1){
		
		
		hora1 = hora1-hora;
		minuto1 = minuto1-minuto;
		segundo1 = segundo1-segundo;
		
		 total = (float) (hora1*0.18);
		total = (float) (minuto1*0.18);
		
		if (dia <= 5) {
			total += 3.65;
		} else {
			total+=4.55;
		}
		
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		

		framevi = new JFrame();
		framevi.setBounds(100, 100, 580, 456);
		framevi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framevi.getContentPane().setLayout(null);

		JButton btnFinalTrayecto = new JButton("Final Trayecto");
		btnFinalTrayecto.setBounds(115, 13, 158, 102);
		framevi.getContentPane().add(btnFinalTrayecto);

		JLabel lblPrecio = new JLabel("Precio Inicial");
		lblPrecio.setBounds(42, 155, 78, 38);
		framevi.getContentPane().add(lblPrecio);

		JLabel lblSuplementos = new JLabel("Suplementos:");
		lblSuplementos.setBounds(31, 206, 89, 16);
		framevi.getContentPane().add(lblSuplementos);

		textSuplementos = new JTextField();
		textSuplementos.setBounds(145, 203, 116, 22);
		framevi.getContentPane().add(textSuplementos);
		textSuplementos.setColumns(10);

		label = new JLabel("0$");
		label.setBounds(145, 166, 56, 16);
		framevi.getContentPane().add(label);

		JLabel lblPreciototal = new JLabel("PrecioTotal:");
		lblPreciototal.setBounds(31, 254, 89, 16);
		framevi.getContentPane().add(lblPreciototal);

		 labelPrecio1 = new JLabel("0$");
		labelPrecio1.setBounds(145, 254, 56, 16);
		framevi.getContentPane().add(labelPrecio1);

		JLabel lblCantidadPagada = new JLabel("Cantidad Pagada");
		lblCantidadPagada.setBounds(12, 296, 108, 16);
		framevi.getContentPane().add(lblCantidadPagada);
		lblCantidadPagada.setVisible(false);

		textPagado = new JTextField();
		textPagado.setBounds(145, 293, 116, 22);
		framevi.getContentPane().add(textPagado);
		textPagado.setColumns(10);
		textPagado.setVisible(false);

		JLabel lblCambio = new JLabel("Cambio:");
		lblCambio.setBounds(56, 346, 56, 16);
		framevi.getContentPane().add(lblCambio);
		lblCambio.setVisible(false);

		textCambio = new JTextField();
		textCambio.setBounds(145, 343, 116, 22);
		framevi.getContentPane().add(textCambio);
		textCambio.setColumns(10);
		textCambio.setEnabled(false);

		JButton btnGuardarDatos = new JButton("Guardar datos");
		btnGuardarDatos.setBounds(365, 13, 166, 102);
		framevi.getContentPane().add(btnGuardarDatos);
		
		JLabel lblDuracion = new JLabel("Duracion;");
		lblDuracion.setBounds(42, 138, 56, 16);
		framevi.getContentPane().add(lblDuracion);
		
		JLabel label_1 = new JLabel("0/0/0");
		label_1.setBounds(145, 138, 78, 16);
		framevi.getContentPane().add(label_1);
		
		JButton btnComprobarCambio = new JButton("Comprobar Cambio");
		btnComprobarCambio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				
				String cadena = validarCambio(textPagado.getText());

				if (cadena.equals("")) {
					
					actualizarCambio(textPagado.getText());
					btnGuardarDatos.setVisible(true);
					
				} else {
					JOptionPane.showMessageDialog(null, cadena);
				}

			}
		});
		btnComprobarCambio.setBounds(390, 190, 141, 25);
		framevi.getContentPane().add(btnComprobarCambio);
		btnComprobarCambio.setVisible(false);
		textCambio.setVisible(false);
		btnGuardarDatos.setVisible(false);

		/**
		 * EVENTOS
		 */
		btnFinalTrayecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String cadena = validarSuplementos(textSuplementos.getText());

				if (cadena.equals("")) {
					
Comenzar1();
					
					
					ComprobarTotal(hora1,minuto1,segundo1);
					
					hora1 = hora1-hora;
					minuto1 = minuto1-minuto;
					segundo1 = segundo1-segundo;
					
			int num = Integer.parseInt(textSuplementos.getText());
					
					total += num;
					
					labelPrecio1.setText(total+"$");

					label_1.setText(hora1+"/"+minuto1+"/"+segundo1);
					
					btnComprobarCambio.setVisible(true);
					lblCantidadPagada.setVisible(true);
					lblCambio.setVisible(true);
					textCambio.setVisible(true);
					textPagado.setVisible(true);
					
				} else {
					JOptionPane.showMessageDialog(null, cadena);
				}

			}
		});

		btnGuardarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		
					

					framevi.dispose();
					Principal p = new Principal();
			

			}
		});

		ComenzarTiempo();
	}
}
