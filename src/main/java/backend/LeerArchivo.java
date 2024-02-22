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

    public String leerArchivoEntrada(File archivo) throws FileNotFoundException {
        BufferedReader brp = new BufferedReader(new FileReader(archivo));
        String textoTotal = "";

        try {
            String cadena = brp.readLine();
            while (cadena != null) {

                System.out.println("Cadena: " + cadena);

                switch (cadena) {
                    case "LIBRO":
                        nuevoRegistro();
                        lbr = new Libro();
                        lbr.setCantidad(-1);
                        enLibro = true;
                        break;
                    case "ESTUDIANTE":
                        nuevoRegistro();
                        est = new Estudiante();
                        est.setCarnet(-1);
                        est.setCodigoCarrera(-1);
                        enEstudiante = true;
                        break;
                    case "PRESTAMO":
                        nuevoRegistro();
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
                                            }
                                            break;
                                        case "CANTIDAD":
                                            if (isNumeric(dato)) {
                                                lbr.setCantidad(Integer.parseInt(dato));
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
                                                }
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

                textoTotal = textoTotal + cadena;
                cadena = brp.readLine();
                if (cadena != null) {
                    textoTotal = textoTotal + "\n";
                } else {
                    nuevoRegistro();
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(LeerArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*for (int i = 0; i < prestamos.size(); i++) {
            boolean codigoLibroEncontrado = false; 
            for (int j = 0; j < libros.size(); j++) {
                if (prestamos.get(i).getCodigoLibro().equals(libros.get(j).getCodigo())) {
                    codigoLibroEncontrado = true;
                }
            }
            if (!codigoLibroEncontrado) {
                //prestamos.get(i).
            }
        }*/
        
        
        System.out.println("\n----- LIBROS -----");
        System.out.println("Total de libros: " + libros.size());
        System.out.println(libros);
        System.out.println("");

        System.out.println("\n----- ESTUDIANTES -----");
        System.out.println("Total de estudiantes: " + estudiantes.size());
        System.out.println(estudiantes);
        System.out.println("");

        System.out.println("\n----- PRESTAMOS -----");
        System.out.println("Total de prestamos: " + prestamos.size());
        System.out.println(prestamos);
        System.out.println("");

        return textoTotal;
    }

    private void nuevoRegistro() {
        if (enLibro) {
            if (!isAllBlank(lbr.getTitulo()) && !isAllBlank(lbr.getAutor()) && lbr.getCodigo() != null && lbr.getCantidad() >= 0) {
                libros.add(lbr);
            } else {
                /*System.out.println("Titulo: " + lbr.getTitulo());
                System.out.println("Autor: " + lbr.getAutor());
                System.out.println("Codigo: " + lbr.getCodigo());
                System.out.println("Cantidad: " + lbr.getCantidad());*/
                System.out.println("ERROR EN LIBRO");
            }
            enLibro = false;
        } else if (enEstudiante) {
            if (est.getCarnet() >= 0 && !isAllBlank(est.getNombre()) && est.getCodigoCarrera() >= 0) {
                estudiantes.add(est);
            } else {
                System.out.println("ERROR EN ESTUDIANTE");
            }
            enEstudiante = false;
        } else if (enPrestamo) {
            if (prt.getCodigoLibro() != null && prt.getCarnetEstudiante() >= 0 && !isAllBlank(prt.getFecha())) {
                prestamos.add(prt);
            } else {
                System.out.println("ERROR EN PRESTAMOS");
            }
            enPrestamo = false;
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
