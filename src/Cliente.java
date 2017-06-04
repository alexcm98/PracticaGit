
public class Cliente {
	
	private int dia;
	private int hora;
	private int minuto;
	private int segundo;
	private float PrecioFinal;
	
	
	public Cliente(int dia, int hora, int minuto, int segundo, float precioFinal) {
		super();
		this.dia = dia;
		this.hora = hora;
		this.minuto = minuto;
		this.segundo = segundo;
		PrecioFinal = precioFinal;
	}


	public int getDia() {
		return dia;
	}


	public void setDia(int dia) {
		this.dia = dia;
	}


	public int getHora() {
		return hora;
	}


	public void setHora(int hora) {
		this.hora = hora;
	}


	public int getMinuto() {
		return minuto;
	}


	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}


	public int getSegundo() {
		return segundo;
	}


	public void setSegundo(int segundo) {
		this.segundo = segundo;
	}


	public float getPrecioFinal() {
		return PrecioFinal;
	}


	public void setPrecioFinal(float precioFinal) {
		PrecioFinal = precioFinal;
	}
	
	
	
	
	

	
	

}
