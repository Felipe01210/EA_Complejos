package main.java.com.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Equipo<T> {
	
	private String nombre;
	private List<T> alumnos = new ArrayList<T>(); /*List<Alumno> alumnos = new ArrayList<Alumno>*/
	
	public Equipo() {}
	
	public Equipo(String nombre, List<T> alumnos) {
		this.nombre = nombre;
		this.alumnos = alumnos;
	}
	
	//anadir alumnos
	
	public void anadirAlumno (T alumno) {
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
	
	
	public void borrarAlumno(T alumno) {
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
	
	public T alumnoPerteneceEquipo (T alumno) {
	T resultado = null;
	
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
	
	public Equipo<T> unirEquipos(Equipo<T> otro) {
		List<T> listaU = new ArrayList<T>();
		for (int i = 0; i< this.alumnos.size();i++) {
			if (this.alumnos.get(i) != null && !listaU.contains(this.alumnos.get(i))) {
				listaU.add(this.alumnos.get(i));
			}
		}
		for (int j = 0; j< otro.alumnos.size();j++) {
			if (otro.alumnos.get(j) != null && !listaU.contains(otro.alumnos.get(j))) {
				listaU.add(otro.alumnos.get(j));
			}
		}
		
		Equipo<T> equipoU = new Equipo<T>(this.nombre+" y "+otro.nombre,listaU);
		
		return equipoU;
		
		//modificar cuando tengamos alumno pertenece a equipo
		
	}
	
	public Equipo<T> unirEquipos2(Equipo<T> otro) {
		Set<T> unido = new HashSet<>(this.getAlumnos());
		unido.addAll(otro.getAlumnos());
		List<T> listUnido = new ArrayList<>(unido);
		Equipo<T> eqUnido = new Equipo<T>("unido",listUnido);
		return eqUnido;
	}
	
	
	//interseccion de equipos
	
	public /*<F>*/ Equipo<T> interseccion(Equipo<T> otro){
		List<T> listaU = new ArrayList<T>();
		for (int i = 0; i<this.getAlumnos().size();i++) {
			if (otro.getAlumnos().contains(this.getAlumnos().get(i))) {
				listaU.add(this.getAlumnos().get(i));
			}
		}
		Equipo<T> equipoI = new Equipo<T>("Interseccion "+this.nombre+" "+otro.nombre,listaU);
		return equipoI;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<T> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<T> alumnos) {
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
		Equipo<T> other = (Equipo<T>) obj;
		return Objects.equals(alumnos, other.alumnos) && Objects.equals(nombre, other.nombre);
	}
	
	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", alumnos=" + alumnos + "]";
	}
}
