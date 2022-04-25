package main.java.com.model;

public class Cliente {
	
	private int numCliente;
	private int idClienteActual = 0;
	
	public Cliente() {
		this.numCliente = this.idClienteActual++;
	}

	public int getNumCliente() {
		return numCliente;
	}

	public void setNumCliente(int numCliente) {
		this.numCliente = numCliente;
	}

	public int getIdClienteActual() {
		return idClienteActual;
	}

	public void setIdClienteActual(int idClienteActual) {
		this.idClienteActual = idClienteActual;
	}

}
