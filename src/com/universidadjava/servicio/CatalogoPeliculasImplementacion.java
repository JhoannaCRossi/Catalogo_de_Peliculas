
package com.universidadjava.servicio;

import com.universidadjava.datos.AccesoDatosImplementacion;
import com.universidadjava.datos.IAccesoDatos;
import com.universidadjava.peliculas.Pelicula;
import com.universidadjava.peliculasexcepciones.AccesoDatosExcepcion;
import java.util.List;

public class CatalogoPeliculasImplementacion implements ICatalogoPeliculas{
    
    private final IAccesoDatos datos;
    
    public CatalogoPeliculasImplementacion(){
        this.datos = new AccesoDatosImplementacion();
    }
    
    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
        } catch (AccesoDatosExcepcion ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void listarPeliculas() {
        try {
            List<Pelicula> peliculas = this.datos.listar(NOMBRE_RECURSO);
            peliculas.forEach((pelicula) -> {
                System.out.println("pelicula= " + pelicula);
            });
        } catch (AccesoDatosExcepcion ex) {
            System.out.println("Error de acceso datos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPelicula(String buscar) {
        String resultado = "No se ha encontrado la película";
        try {
            resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);
        } catch (AccesoDatosExcepcion ex) {
            System.out.println("Error de acceso datos");
            ex.printStackTrace(System.out);       
        }
        System.out.println("resultado = " + resultado);
    }

    @Override
    public void iniciarCatalogoPeliculas() {
        try {
            if(this.datos.existe(NOMBRE_RECURSO)){
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
            }
            else{
                datos.crear(NOMBRE_RECURSO);
            }
        } catch (AccesoDatosExcepcion ex) {
            System.out.println("Error al iniciar catalogo de películas");
            ex.printStackTrace(System.out);             }
    }
    
}
