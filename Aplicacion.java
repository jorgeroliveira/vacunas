/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.vacunas;

import java.util.Scanner;

/**
 *
 * @author a19lucianabp
 */
public class Aplicacion {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		VacAlmacen almacenVacunas = new VacAlmacen();
		int opcionMenu = 0;
		Scanner input = new Scanner(System.in);

		do {
			menu();
			opcionMenu = ControlData.leerInt(input); // se lee de teclado una opcion
			if (opcionMenu >= 1 && opcionMenu <= 11) { // se comprueba que es una opcion correcta del menu

				switch (opcionMenu) {
				case 1:
					almacenVacunas.listarVacunas();
					break;
				case 2:
					System.out.print("Introduce el código de una vacuna:");
					String codigoVacuna = ControlData.leerString(input);
					Vacuna v = almacenVacunas.buscarVacunaPorCodigo(codigoVacuna);
					if (v == null) {
						System.out.print("No existe una vacuna con el código introducido.");
					} else {
						v.toString();
					}
					break;
				case 3:
					Vacuna vac = crearNuevaVacuna(input);
					almacenVacunas.agregar(vac);

					break;
				case 4:
					System.out.print("Introduce el código de la vacuna a eliminar:");
					String codigo = ControlData.leerString(input);
					Vacuna vacuna = almacenVacunas.buscarVacunaPorCodigo(codigo);
					if (vacuna == null) {
						System.out.print("No existe una vacuna con el código introducido.");
					} else {
						almacenVacunas.eliminar(vacuna);
					}
					break;
				case 5:
					introducirResultadoFases(almacenVacunas, input);
					break;
				case 6:

					break;
				case 7:

					break;
				case 8:

					break;
				case 9:

					break;
				case 10:

					break;

				case 11:
					System.out.println("*** Fin.***");
					break;

				}

			} else {
				// no es una opcion correcta del menu
				System.out.println("*** Por favor, introduzca una opcion valida.***");
			}

		} while (opcionMenu != 11);

	}

	private static void introducirResultadoFases(VacAlmacen almacenVacunas, Scanner input) {
		System.out.print("Introduce el código de una vacuna:");
		String codigoVacuna = ControlData.leerString(input);
		Vacuna vacuna = almacenVacunas.buscarVacunaPorCodigo(codigoVacuna);
		if (vacuna == null) {
			System.out.println("No existe una vacuna con el código introducido.");
		} else {
			byte fasesCompletadas = vacuna.getFasesCompletadas();
			if (fasesCompletadas == 3) {
				System.out.println("Las tres fases ya han sido completadas.");
				System.out.println("No se pueden introducir mas fases.");
			} else {
				boolean resultadoUltimaFase = vacuna.getResultadoUltimaFase();
				if (resultadoUltimaFase) {
					System.out.print("Introduce el resultado de la fase:" + (fasesCompletadas + 1));
					boolean resultadoFase = ControlData.leerBoolean(input);
					vacuna.modificarFase(fasesCompletadas + 1, resultadoFase);
				} else {
					System.out.println("No se puede modificar la fase:" + (fasesCompletadas + 1));
					System.out.println("El resultado de la fase " + (fasesCompletadas) + " es:" + resultadoUltimaFase);
				}
			}
		}
	}

	private static Vacuna crearNuevaVacuna(Scanner input) {
		System.out.println("Introduce el código de la nueva vacuna:");
		String codigo = ControlData.leerString(input);

		System.out.println("Introduce el nombre de la nueva vacuna:");
		String nombre = ControlData.leerString(input);

		System.out.println("Introduce el principio activo de la nueva vacuna:");
		String principioActivo = ControlData.leerString(input);

		System.out.println("Introduce el nombre de la farmaceutica de la nueva vacuna:");
		String farmaceutica = ControlData.leerString(input);

		System.out.println("Introduce el precio recomendado de la nueva vacuna:");
		double precioRecomendado = ControlData.leerDouble(input);

		return new Vacuna(codigo, nombre, principioActivo, farmaceutica, precioRecomendado);
	}

	private static void menu() {
		System.out.println();
		System.out.println("**************GESTIÓN VACUNAS CONTRA EL COVID-19************");
		System.out.println("1- Listar Vacunas y mostrar datos");
		System.out.println("2- Buscar Vacuna");
		System.out.println("3- Agregar Vacuna");
		System.out.println("4- Eliminar vacuna");
		System.out.println("5- Introducir resultado de las fases de la vacuna");
		System.out.println("6- Autorización/Rechazar vacuna");
		System.out.println("7- Ver vacunas autorizadas");
		System.out.println("8- Ver vacunas rechazadas");
		System.out.println("9- Ver vacunas pendientes de autorizar/rechazar");
		System.out.println("10- Ver la última fase investida de cada vacuna almacenada");
		System.out.println("11- Salir");

	}

}
