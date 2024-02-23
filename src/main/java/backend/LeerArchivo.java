/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author herberthreyes
 */
public class LeerArchivo {
    
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
    
    public void leerArchivoEntrada(File archivo) throws FileNotFoundException {
        BufferedReader brp = new BufferedReader(new FileReader(archivo));
        //String textoTotal = "";

        try {
            String cadena = brp.readLine();
            while (cadena != null) {

                //System.out.println("Cadena: " + cadena);
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
                                                mensajeError.add("El codigo: " + dato + " no es valido");
                                            }
                                            break;
                                        case "CANTIDAD":
                                            if (isNumeric(dato)) {
                                                lbr.setCantidad(Integer.parseInt(dato));
                                            } else {
                                                mensajeError.add("La cantidad: " + dato + " no es numerica");
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
                                                mensajeError.add("El carnet: " + dato + " no es numerico");
                                            }
                                            break;
                                        case "NOMBRE":
                                            est.setNombre(dato);
                                            break;
                                        case "CARRERA":
                                            if (isNumeric(dato)) {
                                                int codigoCarrera = Integer.parseInt(dato);
                                                if (codigoCarrera > 0 && codigoCarrera < 6) {
                                                    est.setCodigoCarrera(codigoCarrera);
                                                } else {
                                                    mensajeError.add("El codigo de la carrera: " + dato + " no es valido (1-5)");
                                                }
                                            } else {
                                                mensajeError.add("La carrera: " + dato + " no es numerica");
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
                                            }
                                            break;
                                        case "CARNET":
                                            if (isNumeric(dato)) {
                                                prt.setCarnetEstudiante(Integer.parseInt(dato));
                                            }
                                            break;
                                        case "FECHA":
                                            if (dato.contains("-")) {
                                                String[] fecha = dato.split("-");
                                                if (fecha.length == 3) {
                                                    String yyyy = fecha[0];
                                                    String mm = fecha[1];
                                                    String dd = fecha[2];
                                                    if (yyyy.length() == 4 && mm.length() == 2 && dd.length() == 2 && isNumeric(yyyy) && isNumeric(mm) && isNumeric(dd)) {
                                                        if (Integer.parseInt(mm) < 13 && Integer.parseInt(dd) < 32) {
                                                            prt.setFecha(dato);
                                                        }
                                                    }
                                                }
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
                prestamos.remove(i - contEliminados);
                contEliminados++;
            }
        }

        // Verificar que no se repite alguna llave primaria en el archivo de entrada
        int contEstudiantesVerificados = 0;
        while (true) {
            int cantidadEstudiantes = estudiantes.size();
            for (int j = 0; j < cantidadEstudiantes; j++) {
                if (j < estudiantes.size()) {
                    if ((estudiantes.get(contEstudiantesVerificados).getCarnet() == estudiantes.get(j).getCarnet())
                            && (contEstudiantesVerificados) != j) {
                        estudiantes.remove(j);
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
        
        int contLibrosVerificados = 0;
        while (true) {
            int cantidadLibros = libros.size();
            for (int j = 0; j < cantidadLibros; j++) {
                if (j < libros.size()) {
                    if ((libros.get(contLibrosVerificados).getCodigo().equals(libros.get(j).getCodigo()))
                            && (contLibrosVerificados) != j) {
                        libros.remove(j);
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
        
        System.out.println("\n----- LIBROS -----");
        System.out.println("----- CORRECTOS -----");
        System.out.println("Total de libros: " + libros.size());
        System.out.println(libros);
        System.out.println("----- ERRONEOS -----");
        System.out.println(erroresLectura);

        /*System.out.println("\n----- ESTUDIANTES -----");
        System.out.println("Total de estudiantes: " + estudiantes.size());
        System.out.println(estudiantes);
        System.out.println("");

        System.out.println("\n----- PRESTAMOS -----");
        System.out.println("Total de prestamos: " + prestamos.size());
        System.out.println(prestamos);
        System.out.println("");*/
    }
    
    private void nuevoRegistroLeido() {
        if (enLibro) {
            if (!isAllBlank(lbr.getTitulo()) && !isAllBlank(lbr.getAutor()) && lbr.getCodigo() != null && lbr.getCantidad() >= 0) {
                libros.add(lbr);
            } else {
                if (isAllBlank(lbr.getTitulo())) {
                    mensajeError.add("Falta el titulo");
                }
                if (isAllBlank(lbr.getAutor())) {
                    mensajeError.add("Falta el autor");
                }
                if (lbr.getCodigo() == null && mensajeError.isEmpty()) {//
                    mensajeError.add("Falta el codigo");
                }
                if (lbr.getCantidad() < 0 && mensajeError.size() <= 1) {//
                    mensajeError.add("Falta la cantidad");
                }
                erroresLectura.add(new ErrorLecturaArchivo(1, lbr, mensajeError));
            }
            enLibro = false;
            mensajeError = new ArrayList();
        } else if (enEstudiante) {
            if (est.getCarnet() >= 0 && !isAllBlank(est.getNombre()) && est.getCodigoCarrera() >= 0) {
                estudiantes.add(est);
            } else {
                //System.out.println("ERROR EN ESTUDIANTE");
                if (est.getCarnet() < 0 && mensajeError.isEmpty()) {//
                    mensajeError.add("Falta el carnet");
                }
                if (isAllBlank(est.getNombre())) {
                    mensajeError.add("Falta el nombre");
                }
                if (est.getCodigoCarrera() < 0 /*&& mensajeError.size() <= 1*/) {//
                    mensajeError.add("Falta la carrera");
                }
                erroresLectura.add(new ErrorLecturaArchivo(2, est, mensajeError));
            }
            enEstudiante = false;
            mensajeError = new ArrayList();
        } else if (enPrestamo) {
            if (prt.getCodigoLibro() != null && prt.getCarnetEstudiante() >= 0 && !isAllBlank(prt.getFecha())) {
                prestamos.add(prt);
            } else {
                System.out.println("ERROR EN PRESTAMOS");
            }
            enPrestamo = false;
            mensajeError = new ArrayList();
        }
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
