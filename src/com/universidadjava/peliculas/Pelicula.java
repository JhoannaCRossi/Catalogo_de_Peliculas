
package com.universidadjava.peliculas;

//clase de entidad del proyecto
public class Pelicula {
    
    //aplicamos teoria de java beans
    private String nombre;
    
    public Pelicula(){
    }
    
    public Pelicula(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
    
    
}
