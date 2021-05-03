/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.vacunas;

import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author luPinheiro
 */
public class VacAlmacen {
	
	private HashSet<Vacuna> coleccion;
	
	public void listarVacunas() {
		for (Vacuna c:coleccion) {
			c.toString();
		}
	}
   
	public Vacuna buscarVacuna(Vacuna v) {
		Vacuna aux = new Vacuna();
		for (Vacuna item:this.coleccion) {
			if (item.equals(v))  {
				aux = item;
			}
		}
		return aux; 		
	}
	
	public void agregar (Vacuna v) {
		this.coleccion.add(v);
	}
	
	public void eliminar(Vacuna v) {
		this.coleccion.remove(v);
	}
    
}
