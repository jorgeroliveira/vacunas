/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.vacunas;

import java.time.LocalDate;

/**
 *
 * @author luPinheiro
 */
public abstract class VacunaAutorizacion implements IAutorizable {

	private boolean fase1Superada = false;
	private boolean fase2Superada = false;
	private boolean fase3Superada = false;
	private byte fasesCompletadas = 0;
	private LocalDate fechaResultado;
	public boolean autorizada;
	public boolean rechazada;

	public LocalDate getFechaResultado() { // Devuelve el valor de la fecha
		return this.fechaResultado;
	}

	public boolean getResultadoUltimaFase() { // Devuelve el resultado de la investigación
		boolean fase;
		byte aux = this.fasesCompletadas; // guardo en aux la ultima fase de la investigación

		switch (aux) {
		case 1:
			fase = this.fase1Superada; // guardo el resultado en la variable retornada en la variable fase
			break;
		case 2:
			fase = this.fase2Superada;
			break;
		case 3:
			fase = this.fase3Superada;
			break;
		default:
			fase = false;
			break;
		}

		return fase;
	}

	// metodo para modificar el valor de las fases superadas
	// metodo case 5
	public void modificarFase(int fase, boolean resultadoFase) {

		switch (fase) {
		case 1:
			this.fase1Superada = resultadoFase;
			break;
		case 2:
			this.fase2Superada = resultadoFase;
			break;
		case 3:
			this.fase3Superada = resultadoFase;
			break;
		}

	}

	// Implementacion de los metodos de la interface IAutorizable
	// para saber si la vacuna ha sido autorizada o no
	@Override
	public boolean autorizar() {
		// si una vacuna fue rechazada no se puede autorizar
		if (this.rechazada == true) {
			System.out.println("Vacuna rechazada, no se puede autorizar.");
		} else {
			// si todas las fases fueron superadas entonces la vacuna está autorizada
			if ((this.fase1Superada == true) && (this.fase2Superada == true) && (this.fase3Superada == true)) {
				this.autorizada = true;
			} else {
				this.autorizada = false;
			}
		}

		this.fechaResultado = LocalDate.now();
		return this.autorizada;
	}

	@Override
	public boolean rechazar() {
		// si una vacuna ya fue autorizada no se puede rechazar.
		if (this.autorizada == true) {
			System.out.println("Vacuna autorizada, no se puede rechazar.");
		} else {
			// La decisión de rechazar una vacuna es una decisión de la EMA, más allá de que
			// una vacuna haya superado todas las fases (que podría ser).

			this.rechazada = false;
			this.fechaResultado = LocalDate.now();
		}

		return this.rechazada;
	}

	// true si la vacuna está autorizada
	public boolean isVacunaAutorizada() {

		if (this.autorizada == true && this.rechazada == false) {
			return true;
		}
		return false;
	}

}
