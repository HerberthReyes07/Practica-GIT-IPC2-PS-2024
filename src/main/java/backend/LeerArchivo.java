/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import frontend.InterfazIngresoArchivo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author herberthreyes
 */
public class LeerArchivo extends Thread {

    private File archivoEntrada;
    private InterfazIngresoArchivo iia;
    private JLabel lblCarga;

    Bibliotecario bto = new Bibliotecario();

    private Libro lbr = new Libro();
    private ArrayList<Libro> libros = new ArrayList();
    private boolean enLibro = false;

    private Estudiante est = new Estudiante();
    private ArrayList<Estudiante> estudiantes = new ArrayList();
    private boolean enEstudiante = false;

    private Prestamo prt = new Prestamo();
    private ArrayList<Prestamo> prestamos = new ArrayList();
    private boolean enPrestamo = false;

    private ArrayList<ErrorLecturaArchivo> erroresLectura = new ArrayList();
    private ArrayList<String> mensajeError = new ArrayList();

    @Override
    public void run() {
        BarraCarga bc = new BarraCarga();
        bc.setjLabel1(lblCarga);
        bc.setExecute(true);
        bc.start();

        BufferedReader brp = null;
        try {
            brp = new BufferedReader(new FileReader(archivoEntrada));
            //int linea = 1;
            //int lineaError = 1;
            try {
                String cadena = brp.readLine();
                while (cadena != null) {
                    //System.out.println("Cadena: " + cadena);
                    //linea++;
                    switch (cadena) {
                        case "LIBRO":
                            nuevoRegistroLeido();
                            lbr = new Libro();
                            lbr.setCantidad(-1);
                            enLibro = true;
                            break;
                        case "ESTUDIANTE":
                            nuevoRegistroLeido();
                            est = new Estudiante();
                            est.setCarnet(-1);
                            est.setCodigoCarrera(-1);
                            enEstudiante = true;
                            break;
                        case "PRESTAMO":
                            nuevoRegistroLeido();
                            prt = new Prestamo();
                            prt.setCarnetEstudiante(-1);
                            enPrestamo = true;
                            break;
                        default:
                            if (!cadena.isBlank()) {
                                String[] info = cadena.split(":");
                                if (info.length >= 2) {
                                    String tipoDato = info[0];
                                    String dato = info[1];
                                    if (enLibro) {
                                        switch (tipoDato) {
                                            case "TITULO":
                                                lbr.setTitulo(dato);
                                                break;
                                            case "AUTOR":
                                                lbr.setAutor(dato);
                                                break;
                                            case "CODIGO":
                                                if (bto.codigoLibroValido(dato)) {
                                                    lbr.setCodigo(dato);
                                                } else {
                                                    mensajeError.add("CODIGO: '" + dato + "' no valido");
                                                    lbr.setCodigo("CNV");
                                                }
                                                break;
                                            case "CANTIDAD":
                                                if (bto.isNumeric(dato)) {
                                                    lbr.setCantidad(Integer.parseInt(dato));
                                                } else {
                                                    mensajeError.add("CANTIDAD: '" + dato + "' no valida");
                                                    lbr.setCantidad(-2);
                                                }
                                                break;
                                            default:
                                                break;
                                        }
                                    }

                                    if (enEstudiante) {
                                        switch (tipoDato) {
                                            case "CARNET":
                                                if (bto.isNumeric(dato)) {
                                                    est.setCarnet(Integer.parseInt(dato));
                                                } else {
                                                    mensajeError.add("CARNET: '" + dato + "' no valido");
                                                    est.setCarnet(-2);
                                                }
                                                break;
                                            case "NOMBRE":
                                                est.setNombre(dato);
                                                break;
                                            case "CARRERA":
                                                if (bto.codigoCarreraValido(dato)) {
                                                    est.setCodigoCarrera(Integer.parseInt(dato));
                                                } else {
                                                    mensajeError.add("CARRERA: '" + dato + "' no valida (1-5)");
                                                    est.setCodigoCarrera(-2);
                                                }
                                                break;
                                            default:
                                                break;
                                        }
                                    }

                                    if (enPrestamo) {
                                        switch (tipoDato) {
                                            case "CODIGOLIBRO":
                                                if (bto.codigoLibroValido(dato)) {
                                                    prt.setCodigoLibro(dato);
                                                } else {
                                                    mensajeError.add("CODIGO_LIBRO: '" + dato + "' no valido");
                                                    prt.setCodigoLibro("CNV");
                                                }
                                                break;
                                            case "CARNET":
                                                if (bto.isNumeric(dato)) {
                                                    prt.setCarnetEstudiante(Integer.parseInt(dato));
                                                } else {
                                                    mensajeError.add("CARNET_ESTUDIANTE: '" + dato + "' no valido");
                                                    prt.setCarnetEstudiante(-2);
                                                }
                                                break;
                                            case "FECHA":
                                                if (bto.fechaValida(dato)) {
                                                    prt.setFecha(dato);
                                                } else {
                                                    mensajeError.add("FECHA: '" + dato + "' no valida");
                                                    prt.setFecha("FNV");
                                                }
                                                break;
                                            default:
                                                break;
                                        }
                                    }
                                }
                            }
                            break;
                    }
                    cadena = brp.readLine();
                    if (cadena == null) {
                        nuevoRegistroLeido();
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(LeerArchivo.class.getName()).log(Level.SEVERE, null, ex);
            }
            // Verificar errores luego de la lectura en caso de que sea un solo archivo de entrada
            bto.verificarPrestamosLeidos(libros, estudiantes, prestamos, erroresLectura, mensajeError);
            // Verificar que no se repite alguna llave primaria en el archivo de entrada
            bto.verificarCodigoLibroRepetido(libros, erroresLectura, mensajeError);
            bto.verificarCarnetEstudianteRepetido(estudiantes, erroresLectura, mensajeError);

            Thread.sleep(3000);
            bc.setExecute(false);
            iia.verErrores(libros, estudiantes, prestamos, erroresLectura);

        } catch (FileNotFoundException | InterruptedException ex) {
            Logger.getLogger(LeerArchivo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                brp.close();
            } catch (IOException ex) {
                Logger.getLogger(LeerArchivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void nuevoRegistroLeido() {
        if (enLibro) {
            bto.nuevoLibroLeido(lbr, libros, erroresLectura, mensajeError);
            enLibro = false;
        } else if (enEstudiante) {
            bto.nuevoEstudianteLeido(est, estudiantes, erroresLectura, mensajeError);
            enEstudiante = false;
        } else if (enPrestamo) {
            bto.nuevoPrestamoLeido(prt, prestamos, estudiantes, erroresLectura, mensajeError);
            enPrestamo = false;
        }
        mensajeError = new ArrayList();
    }

    public File getArchivoEntrada() {
        return archivoEntrada;
    }

    public void setArchivoEntrada(File archivoEntrada) {
        this.archivoEntrada = archivoEntrada;
    }

    public InterfazIngresoArchivo getIia() {
        return iia;
    }

    public void setIia(InterfazIngresoArchivo iia) {
        this.iia = iia;
    }

    public void setLblCarga(JLabel lblCarga) {
        this.lblCarga = lblCarga;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(ArrayList<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public ArrayList<ErrorLecturaArchivo> getErroresLectura() {
        return erroresLectura;
    }

    public void setErroresLectura(ArrayList<ErrorLecturaArchivo> erroresLectura) {
        this.erroresLectura = erroresLectura;
    }
}
