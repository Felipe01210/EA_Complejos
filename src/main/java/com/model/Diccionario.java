package main.java.com.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Diccionario {
	
	private Map<String,List<String>> dicc = new HashMap<>();
	
	public Diccionario() {
		
	}
	
	public void addPalabra(String palabra, String significado) {
		if(dicc.containsKey(palabra)) {
			dicc.get(palabra).add(significado);
		}else {
			List<String> significados = new ArrayList<>();
			significados.add(significado);
			dicc.put(palabra,significados);
		}
	}
	
	public void borrarPalabra(String palabra) {
		if(dicc.containsKey(palabra)) {
			dicc.remove(palabra);
		}else {
			System.out.println("La palabra no esta en el diccionario");
		}
	}
	
	public List<String> buscarPalabra(String palabra) {
		List<String> res;
		res = null;
		if(dicc.containsKey(palabra)) {
			res = dicc.get(palabra);
		}else {
			System.out.println("La palabra no esta en el diccionario");
		}
		return res;
	}
	
	public List<String> listarPalabras(String cadena){
		List<String> res = new ArrayList<>();
		for (String s : dicc.keySet()) {
			if (s.startsWith(cadena)) {
				res.add(s);
			}
		}
		Arrays.sort(res.toArray());
		return res;
	}

}
