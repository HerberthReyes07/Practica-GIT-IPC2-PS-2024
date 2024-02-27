/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author ronyrojas
 */
public class Bibliotecario {

    public boolean isNumeric(String digitos) {
        return StringUtils.isNumeric(digitos);
    }

    public boolean isAllUpperCase(String letras) {
        return StringUtils.isAllUpperCase(letras);
    }

    public boolean isAllBlank(String dato) {
        return StringUtils.isAllBlank(dato);
    }

    public boolean codigoLibroValido(String dato) {
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

    public boolean codigoCarreraValido(String dato) {
        if (isNumeric(dato)) {
            int codigoCarrera = Integer.parseInt(dato);
            if (codigoCarrera > 0 && codigoCarrera < 6) {
                return true;
            }
        }
        return false;
    }

    public boolean fechaValida(String dato) {
        if (dato.contains("-")) {
            String[] fecha = dato.split("-");
            if (fecha.length == 3) {
                String yyyy = fecha[0];
                String mm = fecha[1];
                String dd = fecha[2];
                if (yyyy.length() == 4 && mm.length() == 2 && dd.length() == 2
                        && isNumeric(yyyy) && isNumeric(mm) && isNumeric(dd)) {
                    if (Integer.parseInt(mm) < 13 && Integer.parseInt(dd) < 32) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void nuevoLibroLeido(Libro lbr, ArrayList<Libro> libros, ArrayList<ErrorLecturaArchivo> erroresLectura,
            ArrayList<String> mensajeError) {
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
    }

    public void nuevoEstudianteLeido(Estudiante est, ArrayList<Estudiante> estudiantes, ArrayList<ErrorLecturaArchivo> erroresLectura,
            ArrayList<String> mensajeError) {
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
    }

    public void nuevoPrestamoLeido(Prestamo prt, ArrayList<Prestamo> prestamos, ArrayList<ErrorLecturaArchivo> erroresLectura,
            ArrayList<String> mensajeError) {
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
    }

    public void verificarPrestamosLeidos(ArrayList<Libro> libros, ArrayList<Estudiante> estudiantes, ArrayList<Prestamo> prestamos,
            ArrayList<ErrorLecturaArchivo> erroresLectura, ArrayList<String> mensajeError) {
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
    }

    public void verificarCodigoLibroRepetido(ArrayList<Libro> libros, ArrayList<ErrorLecturaArchivo> erroresLectura,
            ArrayList<String> mensajeError) {
        int cantidadLibrosInicial = libros.size();
        int contEliminados = 0;
        for (int i = 0; i < libros.size(); i++) {
            for (int j = 0; j < cantidadLibrosInicial; j++) {
                if ((j - contEliminados) > i) {
                    if (libros.get(i).getCodigo().equals(libros.get(j - contEliminados).getCodigo())) {
                        mensajeError.add("CODIGO: '" + libros.get((j - contEliminados)).getCodigo() + "' ya existe en otro libro");
                        erroresLectura.add(new ErrorLecturaArchivo(1, libros.get(j - contEliminados), mensajeError));
                        libros.remove(j - contEliminados);
                        mensajeError = new ArrayList();
                        contEliminados++;
                    }
                }
            }
        }
    }

    public void verificarCarnetEstudianteRepetido(ArrayList<Estudiante> estudiantes, ArrayList<ErrorLecturaArchivo> erroresLectura,
            ArrayList<String> mensajeError) {
        int cantidadEstudiantesInicial = estudiantes.size();
        int contEliminados = 0;
        for (int i = 0; i < estudiantes.size(); i++) {
            for (int j = 0; j < cantidadEstudiantesInicial; j++) {
                if ((j - contEliminados) > i) {
                    if (estudiantes.get(i).getCarnet() == estudiantes.get(j - contEliminados).getCarnet()) {
                        mensajeError.add("CARNET: '" + estudiantes.get(j - contEliminados).getCarnet() + "' ya existe en otro estudiante");
                        erroresLectura.add(new ErrorLecturaArchivo(2, estudiantes.get(j - contEliminados), mensajeError));
                        estudiantes.remove(j - contEliminados);
                        mensajeError = new ArrayList();
                        contEliminados++;
                    }
                }
            }
        }
    }
}
