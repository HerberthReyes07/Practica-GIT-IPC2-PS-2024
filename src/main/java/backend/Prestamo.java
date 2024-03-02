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
    private boolean activo = true;
    private int carreraEstudiante;

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

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getCarreraEstudiante() {
        return carreraEstudiante;
    }

    public void setCarreraEstudiante(int carreraEstudiante) {
        this.carreraEstudiante = carreraEstudiante;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "codigoLibro=" + codigoLibro + ", carnetEstudiante=" + carnetEstudiante + ", fecha=" + fecha + ", activo=" + activo + ", carreraEstudiante=" + carreraEstudiante + '}';
    }
}
