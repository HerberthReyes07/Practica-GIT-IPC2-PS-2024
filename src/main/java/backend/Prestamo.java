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
    private int pagoNormal = 0;
    private int pagoDemora = 0;

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

    public int getPagoNormal() {
        return pagoNormal;
    }

    public void setPagoNormal(int pagoNormal) {
        this.pagoNormal = pagoNormal;
    }

    public int getPagoDemora() {
        return pagoDemora;
    }

    public void setPagoDemora(int pagoDemora) {
        this.pagoDemora = pagoDemora;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "codigoLibro=" + codigoLibro + ", carnetEstudiante=" + carnetEstudiante + ", fecha=" + fecha + ", activo=" + activo + ", carreraEstudiante=" + carreraEstudiante + ", pagoNormal=" + pagoNormal + ", pagoDemora=" + pagoDemora + '}';
    }
}
