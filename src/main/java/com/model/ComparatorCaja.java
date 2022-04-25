package main.java.com.model;

import java.util.Comparator;

public class ComparatorCaja implements Comparator<Caja> {
	
	public ComparatorCaja() {
		
	}

	@Override
	public int compare(Caja o1, Caja o2) {
		// TODO Auto-generated method stub
		return o1.getIdCaja()-o2.getIdCaja();
	}

}
