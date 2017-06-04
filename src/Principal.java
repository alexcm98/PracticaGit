import java.awt.EventQueue;

import javax.swing.JFrame;



import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal {

	private JFrame frame;
	private JButton btnCajaTotal;
	private JButton btnSubidaViajero;
	private ArrayList<Cliente> lista = new ArrayList<Cliente>();
	Calendar fecha = Calendar.getInstance();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 704, 356);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		btnSubidaViajero = new JButton("Subida Viajero");
		btnSubidaViajero.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int dia = fecha.get(Calendar.DAY_OF_WEEK);
				int	hora = fecha.get(Calendar.HOUR_OF_DAY);
				int minuto = fecha.get(Calendar.MINUTE);
				int segundo = fecha.get(Calendar.SECOND);
					
					Cliente c= new Cliente(dia, hora,minuto, segundo, 0f);
					
					lista.add(c);
					frame.dispose();
					FinalViaje p = new FinalViaje();
					p.framevi.setVisible(true);
					
			}
		});
		btnSubidaViajero.setBounds(0, 0, 332, 309);
		frame.getContentPane().add(btnSubidaViajero);

		btnCajaTotal = new JButton("Caja Total");
		btnCajaTotal.setBounds(354, 0, 332, 309);
		frame.getContentPane().add(btnCajaTotal);

		/**
		 * EVENTOS
		 */

		btnCajaTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

	

	}
}
