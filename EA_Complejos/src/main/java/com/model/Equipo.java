package main.java.com.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Equipo {
	
	private String nombre;
	private List<Alumno> alumnos = new ArrayList<Alumno>();
	
	public Equipo() {}
	
	public Equipo(String nombre, List<Alumno> alumnos) {
		this.nombre = nombre;
		this.alumnos = alumnos;
	}
	
	//anadir alumnos
	
	public void anadirAlumno (Alumno alumno) {
		if (alumno!=null && !this.alumnos.contains(alumno)) {
			this.alumnos.add(alumno);
		}else {
			if(alumno==null) {
				throw new EquipoException("El alumno no existe");
				
			}else if(this.alumnos.contains(alumno)) {
				throw new EquipoException("El alumno ya est� en el equipo");
			}
		}
		
	}
	
	//borrar alumnos
	
	
	public void borrarAlumno(Alumno alumno) {
		if (alumno!=null && this.alumnos.contains(alumno)) {
			this.alumnos.remove(alumno);
		}else {
			if(alumno==null) {
				throw new EquipoException("El alumno no existe");
				
			}else if(!this.alumnos.contains(alumno)) {
				throw new EquipoException("El alumno no est� en el equipo");
			}
		}
		
	}
	
	
	
	//alumno pertenece a equipo
	
	public Alumno alumnoPerteneceEquipo (Alumno alumno) {
	Alumno resultado = null;
	
	for (int i = 0; i < this.alumnos.size(); i++) {
		if (this.alumnos.get(i).equals(alumno)) {
			resultado = alumno;
		}
	}
	return resultado;
	}
	
	//mostrar lista de personas de equipo
	
	public void mostrarListaPersonasEquipo() {
		for (int i = 0; i < this.alumnos.size(); i++) {
			System.out.println(this.alumnos.get(i));
		}
	}
	
	//union de equipos
	
	public Equipo unirEquipos(Equipo otro) {
		List<Alumno> listaU = new ArrayList<Alumno>();
		for (int i = 0; i< this.alumnos.size();i++) {
			if (this.alumnos.get(i) != null && !listaU.contains(this.alumnos.get(i))) {
				listaU.add(this.alumnos.get(i));
			}
		}
		for (int j = 0; j< this.alumnos.size();j++) {
			if (otro.alumnos.get(j) != null && !listaU.contains(otro.alumnos.get(j))) {
				listaU.add(otro.alumnos.get(j));
			}
		}
		
		Equipo equipoU = new Equipo(this.nombre+" y "+otro.nombre,listaU);
		
		return equipoU;
		
		//modificar cuando tengamos alumno pertenece a equipo
		
	}
	
	public Equipo unirEquipos2(Equipo otro) {
		Set<Alumno> unido = new HashSet<>(this.getAlumnos());
		unido.addAll(otro.getAlumnos());
		List<Alumno> listUnido = new ArrayList<>(unido);
		Equipo eqUnido = new Equipo("unido",listUnido);
		return eqUnido;
	}
	
	
	//interseccion de equipos
	
	public Equipo interseccion(Equipo otro){
		List<Alumno> listaU = new ArrayList<Alumno>();
		for (int i = 0; i<this.getAlumnos().size();i++) {
			if (otro.getAlumnos().contains(this.getAlumnos().get(i))) {
				listaU.add(this.getAlumnos().get(i));
			}
		}
		Equipo equipoI = new Equipo("Interseccion "+this.nombre+" "+otro.nombre,listaU);
		return equipoI;
	}

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
