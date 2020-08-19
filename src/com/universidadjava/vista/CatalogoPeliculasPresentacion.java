package com.universidadjava.vista;

import com.universidadjava.servicio.*;
import java.util.Scanner;

public class CatalogoPeliculasPresentacion {

    public static void main(String[] args) {
        int opcion = -1;
        Scanner scanner = new Scanner(System.in);
        ICatalogoPeliculas catalogo = new CatalogoPeliculasImplementacion();

        while (opcion != 0) {
            System.out.println("\nElige una opcion: \n"
                    + "1. Iniciar catálogo películas \n"
                    + "2. Agregar película \n"
                    + "3. Listar películas \n"
                    + "4. Buscar película \n"
                    + "0. Salir");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    catalogo.iniciarCatalogoPeliculas();
                    break;
                case 2:
                    System.out.println("Introduce el nombre de la pelicula: ");
                    String nombrePelicula = scanner.nextLine();
                    catalogo.agregarPelicula(nombrePelicula);
                    break;
                case 3:
                    catalogo.listarPeliculas();
                    break;
                case 4:
                    System.out.println("Introduce una película a buscar: ");
                    String buscar = scanner.nextLine();
                    catalogo.buscarPelicula(buscar);
                    break;
                case 0:
                    System.out.println("Hasta Pronto!!");
                    break;
                default:
                    System.out.println("Opción no reconocida");
                    break;
            }
        }
    }
}
