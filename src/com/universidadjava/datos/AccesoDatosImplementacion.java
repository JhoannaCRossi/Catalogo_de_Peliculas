package com.universidadjava.datos;

import com.universidadjava.peliculas.Pelicula;
import com.universidadjava.peliculasexcepciones.*;
import java.io.*;
import java.util.*;

public class AccesoDatosImplementacion implements IAccesoDatos {

    @Override
    public boolean existe(String nombreRecurso){
        File archivo = new File(nombreRecurso);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosExcepcion {
        File archivo = new File(nombreRecurso);
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while (linea != null) {
                Pelicula pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosExcepcion("Excepción al listar películas: " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosExcepcion("Excepción al listar películas: " + ex.getMessage());
        }
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosExcepcion {
        File archivo = new File(nombreRecurso);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("Se ha escrito informacion al archivo: " + pelicula);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            throw new EscrituraDatosExcepcion("Excepción al escribir películas: " + ex.getMessage());
        }
    }

    @Override
    public String buscar(String nombreRecurso, String buscar) throws LecturaDatosExcepcion {
        File archivo = new File(nombreRecurso);
        String resultado = null;

        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            int indice = 1;
            while (linea != null) {
                if (buscar != null && buscar.equalsIgnoreCase(linea)) {
                    resultado = "Película " + linea + " encontrada en el índice " + indice;
                    break;
                }
                linea = entrada.readLine();
                indice++;
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosExcepcion("Excepción al leer películas: " + ex.getMessage());

        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosExcepcion("Excepción al leer películas: " + ex.getMessage());
        }
        return resultado;
    }

    @Override
    public void crear(String nombreRecurso) throws AccesoDatosExcepcion {
        File archivo = new File(nombreRecurso);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Se ha creado el archivo");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosExcepcion("Excepción al crear archivo: " + ex.getMessage());
        }
    }

    @Override
    public void borrar(String nombreRecurso) throws AccesoDatosExcepcion {
         File archivo = new File(nombreRecurso);
        if(archivo.exists())
            archivo.delete();
        System.out.println("Se ha borrado el archivo");
    }

}
