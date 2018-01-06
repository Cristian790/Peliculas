/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Cristian
 */
public class Pelicula extends Categoria {
    
    private int codigo;
    private int precio;
    private String formato4k;
    private String nombre;
    
    public Pelicula(){}
    
    public Pelicula(int id,String descripcion,int codigo,int precio,String formato4k,String nombre){
        super();
        this.codigo=codigo;
        this.precio=precio;
        this.formato4k=formato4k;
        this.nombre=nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getFormato4k() {
        return formato4k;
    }

    public void setFormato4k(String formato4k) {
        this.formato4k = formato4k;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return super.toString()+"Pelicula{" + "codigo=" + codigo + ", precio=" + precio + ", formato4k=" + formato4k + ", nombre=" + nombre + '}';
    }
    
    
}
