package main.java.com.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestionCola {
	
	private Map<Caja,List<Cliente>> distribucion = new HashMap<>();
	
	public static final int NUMERO_CAJAS = 20;
	
	public GestionCola() {
		for (int i = 1; i<=NUMERO_CAJAS; i++) {
			this.distribucion.put(new Caja(i),new ArrayList<Cliente>());
		}
	}
	
	public void abrirCaja(int id) {
		for (Caja c : distribucion.keySet()) {
			if(c.getIdCaja()==id) {
				c.abrirCaja();
			}
		}
	}
	
	public void cerrarCaja(int id) {
		for (Caja c: distribucion.keySet()) {
			if(c.getIdCaja()==id && distribucion.get(c).isEmpty()) {
				c.cerrarCaja();
			}
		}
	}
	
	public Caja obtenerCajaPrioritaria() {
		List<Caja> cajas = new ArrayList<>(distribucion.keySet());
		cajas.sort(new ComparatorCaja());
		
		Caja res = cajas.get(0);
		
		for (int i = 0; i< cajas.size()-1; i++) {
			if(distribucion.get(res).size()>distribucion.get(i).size()) {
				res = cajas.get(i);
			}
		}
		
		return res;
	}
	
	public String asignarCliente(Cliente c) {
		Caja caja = obtenerCajaPrioritaria();
		distribucion.get(caja).add(c);
		return "Usted es el cliente "+c.getIdClienteActual()+" y debe ir a la caja "+caja.getIdCaja();
	}
	
	public String atenderCliente(int caja) {
		String mensaje = "";
		for (Caja c: distribucion.keySet()) {
			if (c.getIdCaja()==caja && !distribucion.get(caja).isEmpty()) {
				Cliente cliente = distribucion.get(c).get(0);
				mensaje = "Se ha atendido al cles.iente con numero "+cliente.getNumCliente();
				distribucion.get(c).remove(0);
			}
		}
		return mensaje;
		
	}

}
