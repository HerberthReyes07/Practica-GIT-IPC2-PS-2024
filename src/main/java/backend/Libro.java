/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.io.Serializable;

/**
 *
 * @author herberthreyes
 */
public class Libro implements Serializable{

    private String titulo;
    private String autor;
    private String codigo;
    private int cantidad;
    private String fechaPublicacion;
    private String editorial;

    public Libro() {
    }

    public Libro(String titulo, String autor, String codigo, int cantidad, String fechaPublicacion, String editorial) {
        this.titulo = titulo;
        this.autor = autor;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.fechaPublicacion= fechaPublicacion;
        this.editorial = editorial;
        
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return "Libro{" + "titulo=" + titulo + ", autor=" + autor + ", codigo=" + codigo + ", cantidad=" + cantidad + ", fechaPublicacion=" + fechaPublicacion + ", editorial=" + editorial + '}';
    }


}
