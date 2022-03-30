package test.java.com;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.java.com.model.Alumno;
import main.java.com.model.Equipo;

class Pruebax {

	@Test
	public void testEquipoVacioAlPrincipio() {
		Equipo equipoA = new Equipo();
		
		assertEquals(equipoA.getAlumnos().size(),0);
	}
	
	@Test
	public void testAddAlumnoAtributosAumentaTamanio() {
		Equipo equipoA = new Equipo();
		equipoA.anadirAlumno(new Alumno("JM","0000001A"));
		
		assertEquals(equipoA.getAlumnos().size(),1);
	}
	
	@Test
	public void testAddAlumnoClaseTamania() {
		Equipo equipoA = new Equipo();
		Alumno alumno = new Alumno("JM","0000001A");
		equipoA.anadirAlumno(alumno);
		
		assertEquals(equipoA.getAlumnos().size(),1);
	}
	
	@Test
	public void testUnirEquipos() {
		Alumno alumno1 = new Alumno("JM","0000001A");
		Alumno alumno2 = new Alumno("FA","0000002A");
		Equipo equipoA = new Equipo();
		Equipo equipoB = new Equipo();
		
		equipoA.anadirAlumno(alumno1);
		equipoB.anadirAlumno(alumno2);
		
		Equipo unido = equipoA.unirEquipos(equipoB);
		
		System.out.println(unido);
		
		assertEquals(unido.getAlumnos().size(),2);
		assertEquals(unido.getAlumnos().get(0),alumno1);
		assertEquals(unido.getAlumnos().get(1),alumno2);
	}
	
	@Test
	public void testIntereseccionEquipo() {
		Alumno alumno1 = new Alumno("JM","0000001A");
		Alumno alumno2 = new Alumno("FA","0000002A");
		Equipo equipoA = new Equipo();
		Equipo equipoB = new Equipo();
		equipoA.anadirAlumno(alumno1);
		equipoA.anadirAlumno(alumno2);
		equipoB.anadirAlumno(alumno2);
		
		Equipo interseccion = equipoA.interseccion(equipoB);
		
		System.out.println(interseccion);
		
		assertEquals(interseccion.getAlumnos().size(),1);
		assertEquals(interseccion.getAlumnos().get(0),alumno2);
	}
	
	@Test
	public void testEquipoGenerico() {
		
		Alumno alumno1 = new Alumno("JM","0000001A");
		Integer int1 = 1;
		
		Equipo<Alumno> equipoA = new Equipo<Alumno>();
		Equipo<Integer> equipoI = new Equipo<Integer>();
		
		equipoA.anadirAlumno(alumno1);
		equipoI.anadirAlumno(int1);
		
		assertEquals(equipoA.getAlumnos().size(),1);
	}

}
