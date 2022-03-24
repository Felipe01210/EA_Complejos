package test.java.com;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.java.com.model.Alumno;
import main.java.com.model.Equipo;

class Prueba {
	
	@Test
	public void testEquipoVacioAlPrincipio() {
		Equipo equipoA = new Equipo();
		
		assertEquals(equipoA.getAlumnos().size(),0);
	}
	
	@Test
	public void testAddAlumnoAtributosAumentaTamanio() {
		Equipo equipoA = new Equipo();
		equipoA.añadirAlumno("JM","0000001A");
		
		assertEquals(equipoA.getAlumnos().size(),1);
	}
	
	@Test
	public void testAddAlumnoClaseTamania() {
		Equipo equipoA = new Equipo();
		Alumno alumno = new Alumno("JM","0000001A");
		equipoA.addAlumno(alumno);
		
		assertEquals(equipoA.getAlumnos().size(),1);
	}

	

}
