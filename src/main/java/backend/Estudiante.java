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
public class Estudiante implements Serializable{

    private int carnet;
    private String nombre;
    private int codigoCarrera;
    private String fechaNacimiento;
    private int numeroPrestamos = 3;

    public Estudiante() {
    }

    public Estudiante(int carnet, String nombre, int codigoCarrera, String fechaNacimiento) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.codigoCarrera = codigoCarrera;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getCarnet() {
        return carnet;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigoCarrera() {
        return codigoCarrera;
    }

    public void setCodigoCarrera(int codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getNumeroPrestamos() {
        return numeroPrestamos;
    }

    public void setNumeroPrestamos(int numeroPrestamos) {
        this.numeroPrestamos = numeroPrestamos;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "carnet=" + carnet + ", nombre=" + nombre + ", codigoCarrera=" + codigoCarrera + ", fechaNacimiento=" + fechaNacimiento + ", numeroPrestamos=" + numeroPrestamos + '}';
    }

}
