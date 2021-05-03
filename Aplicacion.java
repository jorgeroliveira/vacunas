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

        int opcionMenu = 0;
        Scanner input = new Scanner(System.in);

            do {
            menu();
            opcionMenu = ControlData.leerInt(input); // se lee de teclado una opcion
            if (opcionMenu >= 1 && opcionMenu <= 6) { // se comprueba que es una opcion correcta del menu



                switch (opcionMenu) {
                    case 1:

                        break;
                    case 2:
                     
                            break;
                     case 3:
                     
                            break;
                     case 4:
                     
                            break;
                     case 5:
                     
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
    

       private static void menu() {
		System.out.println();
		System.out.println("**************VACUNA CONTRA EL COVID-19************");
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
