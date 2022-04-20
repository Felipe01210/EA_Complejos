package test.java.com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import main.java.com.model.Diccionario;

class TestDiccionario {

	@Test
	void testAddPalabra() {
		
		Diccionario dic = new Diccionario();
		dic.addPalabra("máquina", "Artificio para aprovechar, dirigir o regular la acción de una fuerza.");
		dic.addPalabra("máquina", "Conjunto de aparatos combinados para recibir cierta forma de energía y "
									+ "transformarla en otra más adecuada, o para producir un efecto determinado.");
		
		assertTrue(!dic.buscarPalabra("máquina").isEmpty());
		assertEquals(dic.buscarPalabra("máquina").size(), 2);
	}

	
	@Test
	void testBorrarPalabra() {
		Diccionario dic = new Diccionario();
		dic.addPalabra("máquina", "Artificio para aprovechar, dirigir o regular la acción de una fuerza.");
		
		assertTrue(!dic.buscarPalabra("máquina").isEmpty());
		
		dic.borrarPalabra("máquina");
		
		assertNull(dic.buscarPalabra("máquina"));
	}
	
	@Test
	void testListarPalabras() {
		Diccionario dic = new Diccionario();
		dic.addPalabra("maquinar", "Urdir, tramar algo oculta y artificiosamente.");
		dic.addPalabra("maquiavélico", "Astuto y engañoso.");
		
		assertEquals(dic.listarPalabras("maqu").size(), 2);
		assertEquals(dic.listarPalabras("hi").size(), 0);
		
	}
	
}
