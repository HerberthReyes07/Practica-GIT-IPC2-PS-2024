/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author herberthreyes
 */
public class Prestamo {

    private String codigoLibro;
    private int carnetEstudiante;
    private String fecha;

    public Prestamo() {
    }

    public Prestamo(String codigoLibro, int carnetEstudiante, String fecha) {
        this.codigoLibro = codigoLibro;
        this.carnetEstudiante = carnetEstudiante;
        this.fecha = fecha;
    }

    public String getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(String codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public int getCarnetEstudiante() {
        return carnetEstudiante;
    }

    public void setCarnetEstudiante(int carnetEstudiante) {
        this.carnetEstudiante = carnetEstudiante;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "codigoLibro=" + codigoLibro + ", carnetEstudiante=" + carnetEstudiante + ", fecha=" + fecha + '}';
    }
}
