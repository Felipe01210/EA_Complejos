package main.java.com.model;

public class Caja {
	
	private boolean cerrado;
	private int idCaja;
	
	public Caja() {
		this.cerrado = true;
	}
	
	public Caja(int idCaja) {
		this.cerrado = true;
		this.idCaja = idCaja;
	}

	public boolean isCerrado() {
		return cerrado;
	}

	public void setCerrado(boolean cerrado) {
		this.cerrado = cerrado;
	}
	
	public int getIdCaja() {
		return idCaja;
	}

	public void setIdCaja(int idCaja) {
		this.idCaja = idCaja;
	}

	public void abrirCaja() {
		if(cerrado) {
			this.cerrado = false;
		}else {
			System.out.println("Esta caja ya esta abierta");
		}
	}
	
	public void cerrarCaja() {
		if(!cerrado) {
			this.cerrado = true;
		}else {
			System.out.println("Esta caja ya esta cerrada");
		}
	}

}
