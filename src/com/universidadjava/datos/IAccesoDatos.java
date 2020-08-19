
package com.universidadjava.datos;

import com.universidadjava.peliculas.Pelicula;
import com.universidadjava.peliculasexcepciones.*;
import java.util.List;

public interface IAccesoDatos {
    
    boolean existe(String nombreRecurso) throws AccesoDatosExcepcion;

    List<Pelicula> listar(String nombreRecurso) throws LecturaDatosExcepcion;
    
    void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws 
            EscrituraDatosExcepcion;
    
    String buscar(String nombreRecurso, String buscar) throws LecturaDatosExcepcion;
    
    void crear(String nombreRecurso) throws AccesoDatosExcepcion;
    
    void borrar(String nombreRecurso) throws AccesoDatosExcepcion;
}
