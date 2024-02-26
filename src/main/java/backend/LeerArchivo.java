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
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author herberthreyes
 */
public class LeerArchivo extends Thread {

    private File archivoEntrada;
    private InterfazIngresoArchivo iia;
    private JLabel lblCarga;

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
            int linea = 1;
            int lineaError = 1;
            try {
                String cadena = brp.readLine();
                while (cadena != null) {
                    //System.out.println("Cadena: " + cadena);
                    linea++;
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
                                                if (codigoLibroValido(dato)) {
                                                    lbr.setCodigo(dato);
                                                } else {
                                                    mensajeError.add("CODIGO: '" + dato + "' no valido");
                                                    lbr.setCodigo("CNV");
                                                }
                                                break;
                                            case "CANTIDAD":
                                                if (isNumeric(dato)) {
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
                                                if (isNumeric(dato)) {
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
                                                boolean carreraCorrecta = false;
                                                if (isNumeric(dato)) {
                                                    int codigoCarrera = Integer.parseInt(dato);
                                                    if (codigoCarrera > 0 && codigoCarrera < 6) {
                                                        est.setCodigoCarrera(codigoCarrera);
                                                        carreraCorrecta = true;
                                                    }
                                                }
                                                if (!carreraCorrecta) {
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
                                                if (codigoLibroValido(dato)) {
                                                    prt.setCodigoLibro(dato);
                                                } else {
                                                    mensajeError.add("CODIGO_LIBRO: '" + dato + "' no valido");
                                                    prt.setCodigoLibro("CNV");
                                                }
                                                break;
                                            case "CARNET":
                                                if (isNumeric(dato)) {
                                                    prt.setCarnetEstudiante(Integer.parseInt(dato));
                                                } else {
                                                    mensajeError.add("CARNET_ESTUDIANTE: '" + dato + "' no valido");
                                                    prt.setCarnetEstudiante(-2);
                                                }
                                                break;
                                            case "FECHA":
                                                boolean formatoCorrecto = false;
                                                if (dato.contains("-")) {
                                                    String[] fecha = dato.split("-");
                                                    if (fecha.length == 3) {
                                                        String yyyy = fecha[0];
                                                        String mm = fecha[1];
                                                        String dd = fecha[2];
                                                        if (yyyy.length() == 4 && mm.length() == 2 && dd.length() == 2
                                                                && isNumeric(yyyy) && isNumeric(mm) && isNumeric(dd)) {
                                                            if (Integer.parseInt(mm) < 13 && Integer.parseInt(dd) < 32) {
                                                                prt.setFecha(dato);
                                                                formatoCorrecto = true;
                                                            }
                                                        }
                                                    }
                                                }
                                                if (!formatoCorrecto) {
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
            int contEliminados = 0;
            int cantidadPrestamos = prestamos.size();
            for (int i = 0; i < cantidadPrestamos; i++) {
                boolean codigoLibroEncontrado = false;
                boolean carnetEstudianteEncontrado = false;
                for (int j = 0; j < libros.size(); j++) {
                    if (prestamos.get(i - contEliminados).getCodigoLibro().equals(libros.get(j).getCodigo())) {
                        codigoLibroEncontrado = true;
                    }
                }
                for (int j = 0; j < estudiantes.size(); j++) {
                    if (prestamos.get(i - contEliminados).getCarnetEstudiante() == estudiantes.get(j).getCarnet()) {
                        carnetEstudianteEncontrado = true;
                    }
                }
                if (!codigoLibroEncontrado || !carnetEstudianteEncontrado) {
                    if (!codigoLibroEncontrado) {
                        mensajeError.add("CODIGO_LIBRO: '" + prestamos.get(i - contEliminados).getCodigoLibro() + "' no existe");
                    }
                    if (!carnetEstudianteEncontrado) {
                        mensajeError.add("CARNET_ESTUDIANTE: '" + prestamos.get(i - contEliminados).getCarnetEstudiante() + "' no exite");
                    }
                    erroresLectura.add(new ErrorLecturaArchivo(3, prestamos.get(i - contEliminados), mensajeError));
                    prestamos.remove(i - contEliminados);
                    mensajeError = new ArrayList();
                    contEliminados++;
                }
            }
            // Verificar que no se repite alguna llave primaria en el archivo de entrada
            int contLibrosVerificados = 0;
            while (true) {
                int cantidadLibros = libros.size();
                for (int j = 0; j < cantidadLibros; j++) {
                    if (j < libros.size()) {
                        if ((libros.get(contLibrosVerificados).getCodigo().equals(libros.get(j).getCodigo()))
                                && (contLibrosVerificados) != j) {
                            mensajeError.add("CODIGO: '" + libros.get(j).getCodigo() + "' ya existente en otro libro");
                            erroresLectura.add(new ErrorLecturaArchivo(1, libros.get(j), mensajeError));
                            libros.remove(j);
                            mensajeError = new ArrayList();
                        }
                    } else {
                        break;
                    }
                }
                contLibrosVerificados++;
                if (contLibrosVerificados == libros.size()) {
                    break;
                }
            }
            int contEstudiantesVerificados = 0;
            while (true) {
                int cantidadEstudiantes = estudiantes.size();
                for (int j = 0; j < cantidadEstudiantes; j++) {
                    if (j < estudiantes.size()) {
                        if ((estudiantes.get(contEstudiantesVerificados).getCarnet() == estudiantes.get(j).getCarnet())
                                && (contEstudiantesVerificados) != j) {
                            mensajeError.add("CARNET: '" + estudiantes.get(j).getCarnet() + "' ya existente en otro estudiante");
                            erroresLectura.add(new ErrorLecturaArchivo(2, estudiantes.get(j), mensajeError));
                            estudiantes.remove(j);
                            mensajeError = new ArrayList();
                        }
                    } else {
                        break;
                    }
                }
                contEstudiantesVerificados++;
                if (contEstudiantesVerificados == estudiantes.size()) {
                    break;
                }
            }
            
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
            if (!isAllBlank(lbr.getTitulo()) && !isAllBlank(lbr.getAutor())
                    && (lbr.getCodigo() != null && !lbr.getCodigo().equals("CNV")) && lbr.getCantidad() >= 0) {
                libros.add(lbr);
            } else {
                if (isAllBlank(lbr.getTitulo())) {
                    mensajeError.add("TITULO: ausente");
                }
                if (isAllBlank(lbr.getAutor())) {
                    mensajeError.add("AUTOR: ausente");
                }
                if (lbr.getCodigo() == null) {
                    mensajeError.add("CODIGO: ausente");
                }
                if (lbr.getCantidad() == -1) {
                    mensajeError.add("CANTIDAD: ausente");
                }
                erroresLectura.add(new ErrorLecturaArchivo(1, lbr, mensajeError));
            }
            enLibro = false;
        } else if (enEstudiante) {
            if (est.getCarnet() >= 0 && !isAllBlank(est.getNombre()) && est.getCodigoCarrera() >= 0) {
                estudiantes.add(est);
            } else {
                if (est.getCarnet() == -1) {
                    mensajeError.add("CARNET: ausente");
                }
                if (isAllBlank(est.getNombre())) {
                    mensajeError.add("NOMBRE: ausente");
                }
                if (est.getCodigoCarrera() == -1) {
                    mensajeError.add("CARRERA: ausente");
                }
                erroresLectura.add(new ErrorLecturaArchivo(2, est, mensajeError));
            }
            enEstudiante = false;
        } else if (enPrestamo) {
            if ((prt.getCodigoLibro() != null && !prt.getCodigoLibro().equals("CNV")) && prt.getCarnetEstudiante() >= 0
                    && (!isAllBlank(prt.getFecha()) && !prt.getFecha().equals("FNV"))) {
                prestamos.add(prt);
            } else {
                if (prt.getCodigoLibro() == null) {
                    mensajeError.add("CODIGO_LIBRO: ausente");
                }
                if (prt.getCarnetEstudiante() == -1) {
                    mensajeError.add("CARNET_ESTUDIANTE: ausente");
                }
                if (isAllBlank(prt.getFecha())) {
                    mensajeError.add("FECHA: ausente");
                }
                erroresLectura.add(new ErrorLecturaArchivo(3, prt, mensajeError));
            }
            enPrestamo = false;
        }
        mensajeError = new ArrayList();
    }

    private boolean codigoLibroValido(String dato) {
        if (dato.contains("-")) {
            String[] codigo = dato.split("-");
            if (codigo.length == 2) {
                String digitos = codigo[0];
                String letras = codigo[1];
                if (digitos.length() == 3 && letras.length() == 3 && isNumeric(digitos) && isAllUpperCase(letras)) {
                    return true;
                }
            }
        }
        return false;
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

    private boolean isNumeric(String digitos) {
        return StringUtils.isNumeric(digitos);
    }

    private boolean isAllUpperCase(String letras) {
        return StringUtils.isAllUpperCase(letras);
    }

    private static boolean isAllBlank(String dato) {
        return StringUtils.isAllBlank(dato);
    }
}
