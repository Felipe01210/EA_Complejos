package main.java.com.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Diccionario {
	
	private Map<String,List<String>> diccionario = new HashMap<>();
	
	public Diccionario() {
		
	}
	
	public void addPalabra(String palabra, String significado) {
		if(diccionario.containsKey(palabra)) {
			diccionario.get(palabra).add(significado);
		}else {
			List<String> significados = new ArrayList<>();
			significados.add(significado);
			diccionario.put(palabra,significados);
		}
	}
	
	public void borrarPalabra(String palabra) {
		if(diccionario.containsKey(palabra)) {
			diccionario.remove(palabra);
		}else {
			System.out.println("La palabra no esta en el diccionario");
		}
	}
	
	public List<String> buscarPalabra(String palabra) {
		List<String> res = new ArrayList<String>();
		res = null;
		if(diccionario.containsKey(palabra)) {
			res = diccionario.get(palabra);
		}else {
			System.out.println("La palabra no esta en el diccionario");
		}
		return res;
	}
	
	public List<String> listarPalabras(String cadena){
		List<String> res = new ArrayList<String>();
		for (String s : diccionario.keySet()) {
			if (s.startsWith(cadena)) {
				res.add(s);
			}
		}
		Arrays.sort(res.toArray());
		return res;
	}

}
