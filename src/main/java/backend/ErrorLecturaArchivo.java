/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.util.ArrayList;

/**
 *
 * @author herberthreyes
 */
public class ErrorLecturaArchivo {
    private int tipo;
    private Libro libroError;
    private Estudiante estudianteError;
    private Prestamo prestamoError;
    //private String mensaje;
    ArrayList<String> mensaje;

    public ErrorLecturaArchivo() {
    }

    public ErrorLecturaArchivo(int tipo, Libro libroError, ArrayList<String> mensaje) {
        this.tipo = tipo;
        this.libroError = libroError;
        this.mensaje = mensaje;
    }

    public ErrorLecturaArchivo(int tipo, Estudiante estudianteError, ArrayList<String> mensaje) {
        this.tipo = tipo;
        this.estudianteError = estudianteError;
        this.mensaje = mensaje;
    }

    public ErrorLecturaArchivo(int tipo, Prestamo prestamoError, ArrayList<String> mensaje) {
        this.tipo = tipo;
        this.prestamoError = prestamoError;
        this.mensaje = mensaje;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Libro getLibroError() {
        return libroError;
    }

    public void setLibroError(Libro libroError) {
        this.libroError = libroError;
    }

    public Estudiante getEstudianteError() {
        return estudianteError;
    }

    public void setEstudianteError(Estudiante estudianteError) {
        this.estudianteError = estudianteError;
    }

    public Prestamo getPrestamoError() {
        return prestamoError;
    }

    public void setPrestamoError(Prestamo prestamoError) {
        this.prestamoError = prestamoError;
    }

    public ArrayList<String> getMensaje() {
        return mensaje;
    }

    public void setMensaje(ArrayList<String> mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "ErrorLecturaArchivo{" + "tipo=" + tipo + ", libroError=" + libroError + ", estudianteError=" + estudianteError + ", prestamoError=" + prestamoError + ", mensaje=" + mensaje + '}';
    }

}
