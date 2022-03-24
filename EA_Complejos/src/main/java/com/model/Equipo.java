package main.java.com.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Equipo {
	
	private String nombre;
	private List<Alumno> alumnos = new ArrayList<Alumno>();
	
	public Equipo() {}
	
	public Equipo(String nombre, List<Alumno> alumnos) {
		this.nombre = nombre;
		this.alumnos = alumnos;
	}
	
	//añadir alumnos
	
	//borrar alumnos
	
	//alumno pertenece a equipo
	
	//mostrar lista de personas de equipo
	
	//union de equipos
	
	//interseccion de equipos

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(alumnos, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		return Objects.equals(alumnos, other.alumnos) && Objects.equals(nombre, other.nombre);
	}
	
	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", alumnos=" + alumnos + "]";
	}
}
