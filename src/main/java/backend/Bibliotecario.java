/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;
import org.apache.commons.lang3.StringUtils;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.swing.table.DefaultTableModel;

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

    public void nuevoPrestamoLeido(Prestamo prt, ArrayList<Prestamo> prestamos, ArrayList<Estudiante> estudiantes, ArrayList<ErrorLecturaArchivo> erroresLectura,
            ArrayList<String> mensajeError) {
        if ((prt.getCodigoLibro() != null && !prt.getCodigoLibro().equals("CNV")) && prt.getCarnetEstudiante() >= 0
                && (!isAllBlank(prt.getFecha()) && !prt.getFecha().equals("FNV"))) {
            int numeroEstudiante = buscarEstudiante(estudiantes, prt.getCarnetEstudiante());
            prt.setCarreraEstudiante(estudiantes.get(numeroEstudiante).getCodigoCarrera());
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
                    int numeroCopias = libros.get(j).getCantidad();
                    libros.get(j).setCantidad(numeroCopias - 1);
                }
            }
            for (int j = 0; j < estudiantes.size(); j++) {
                if (prestamos.get(i - contEliminados).getCarnetEstudiante() == estudiantes.get(j).getCarnet()) {
                    carnetEstudianteEncontrado = true;
                    int numeroPrestamos = estudiantes.get(j).getNumeroPrestamos();
                    estudiantes.get(j).setNumeroPrestamos(numeroPrestamos - 1);
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

    public boolean verificarCodigoLibroRepetido(ArrayList<Libro> libros, ArrayList<ErrorLecturaArchivo> erroresLectura,
            ArrayList<String> mensajeError) {
        int cantidadLibrosInicial = libros.size();
        int contEliminados = 0;
        boolean numeroEliminado = false;
        for (int i = 0; i < libros.size(); i++) {
            for (int j = 0; j < cantidadLibrosInicial; j++) {
                if ((j - contEliminados) > i) {
                    if (libros.get(i).getCodigo().equals(libros.get(j - contEliminados).getCodigo())) {
                        mensajeError.add("CODIGO: '" + libros.get((j - contEliminados)).getCodigo() + "' ya existe en otro libro");
                        erroresLectura.add(new ErrorLecturaArchivo(1, libros.get(j - contEliminados), mensajeError));
                        libros.remove(j - contEliminados);
                        numeroEliminado = true;
                        mensajeError = new ArrayList();
                        contEliminados++;
                    }
                }
            }
        }
        if (numeroEliminado) {
            return true;
        }
        return false;
    }

    public boolean verificarCarnetEstudianteRepetido(ArrayList<Estudiante> estudiantes, ArrayList<ErrorLecturaArchivo> erroresLectura,
            ArrayList<String> mensajeError) {
        int cantidadEstudiantesInicial = estudiantes.size();
        int contEliminados = 0;
        boolean contEliminado = false;
        for (int i = 0; i < estudiantes.size(); i++) {
            for (int j = 0; j < cantidadEstudiantesInicial; j++) {
                if ((j - contEliminados) > i) {
                    if (estudiantes.get(i).getCarnet() == estudiantes.get(j - contEliminados).getCarnet()) {
                        mensajeError.add("CARNET: '" + estudiantes.get(j - contEliminados).getCarnet() + "' ya existe en otro estudiante");
                        erroresLectura.add(new ErrorLecturaArchivo(2, estudiantes.get(j - contEliminados), mensajeError));
                        estudiantes.remove(j - contEliminados);
                        contEliminado = true;
                        mensajeError = new ArrayList();
                        contEliminados++;
                    }
                }
            }
        }
        if (contEliminado) {
            return true;
        }
        return false;
    }

    public void ordenarLibros(ArrayList<Libro> libros) {
        System.out.println("ordenando libros...");

        Collections.sort(libros, new Comparator<Libro>() {
            @Override
            public int compare(Libro libro1, Libro libro2) {
                return libro1.getCodigo().compareTo(libro2.getCodigo());
            }
        });
    }

    public boolean validarRegistroLibro(ArrayList<Libro> libros, ArrayList<ErrorLecturaArchivo> erroresLectura, ArrayList<String> mensajeError,
            String titulo, String autor, String codigo, int cantidad, String fecha, String editorial) {

        if (codigoLibroValido(codigo)) {

            if (!isAllBlank(fecha) && !fechaValida(fecha)) {
                String mensaje = "Formato de fecha incorrecto (yyyy-mm-dd)";
                JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            Libro libroTmp = new Libro(titulo, autor, codigo, cantidad, fecha, editorial);
            libros.add(libroTmp);
            if (verificarCodigoLibroRepetido(libros, erroresLectura, mensajeError)) {

                String mensaje = "Codigo de libro repetido";
                JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            } else {
                String mensaje = "Libro registrado correctamente";
                JOptionPane.showMessageDialog(null, mensaje, "Registro Libro", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
        }
        String mensaje = "Codigo de libro no valido";
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    public void ordenarEstudiantes(ArrayList<Estudiante> estudiantes) {
        System.out.println("ordenando estudiantes...");

        Collections.sort(estudiantes, new Comparator<Estudiante>() {
            @Override
            public int compare(Estudiante estudiante1, Estudiante estudiante2) {
                return Integer.compare(estudiante1.getCarnet(), estudiante2.getCarnet());
            }
        });
    }

    public boolean validarRegistroEstudiante(ArrayList<Estudiante> estudiantes, ArrayList<ErrorLecturaArchivo> erroresLectura, ArrayList<String> mensajeError,
            int carnet, String nombre, int codigoCarrera, String fechaNacimiento/*, boolean existeFechaNacimiento*/) {

        String codigoCarreraStr = Integer.toString(codigoCarrera);
        if (codigoCarreraValido(codigoCarreraStr)) {
            if (!isAllBlank(fechaNacimiento) && !fechaValida(fechaNacimiento)) {
                String mensaje = "Formato de fecha incorrecto (yyyy-mm-dd)";
                JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            Estudiante estudianteTmp = new Estudiante(carnet, nombre, codigoCarrera, fechaNacimiento);
            estudiantes.add(estudianteTmp);
            if (verificarCarnetEstudianteRepetido(estudiantes, erroresLectura, mensajeError)) {

                String mensaje = "Carnet de estudiante repetido";
                JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            } else {

                String mensaje = "Estudiante registrado correctamente";
                JOptionPane.showMessageDialog(null, mensaje, "Registro Estudiante", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
        } else {
            String mensaje = "Codigo de carrera no valido (1-5)";
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private int buscarEstudiante(ArrayList<Estudiante> estudiantes, int carnet) {
        //boolean encontrado = false;
        int encontrado = -1;
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getCarnet() == carnet) {
                encontrado = i;
            }
        }
        return encontrado;
    }

    public int verificarPrestamosEstudiante(ArrayList<Estudiante> estudiantes, int carnet) {

        if (buscarEstudiante(estudiantes, carnet) >= 0) {
            for (Estudiante estudiante : estudiantes) {
                if (estudiante.getCarnet() == carnet) {
                    return estudiante.getNumeroPrestamos();
                }
            }
        } else {
            String mensaje = "El estudiante con carnet: " + carnet + ", no existe";
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        return -2;
    }

    private boolean buscarLibro(ArrayList<Libro> libros, String codigoLibro) {

        boolean encontrado = false;
        for (Libro libro : libros) {
            if (libro.getCodigo().equals(codigoLibro)) {
                encontrado = true;
            }
        }
        return encontrado;
    }

    public int verificarCopias(ArrayList<Libro> libros, String codigoLibro) {

        if (buscarLibro(libros, codigoLibro)) {
            for (Libro libro : libros) {
                if (libro.getCodigo().equals(codigoLibro)) {
                    return libro.getCantidad();
                }
            }
        } else {
            String mensaje = "El libro con codigo: " + codigoLibro + ", no existe";
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        return -2;
    }

    public void crearPrestamo(ArrayList<Estudiante> estudiantes, ArrayList<Libro> libros, ArrayList<Prestamo> prestamos,
            int carnetEstudiante, String codigoLibro, String fecha) {
        Prestamo prestamo = new Prestamo(codigoLibro, carnetEstudiante, fecha);
        prestamos.add(prestamo);
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCarnet() == carnetEstudiante) {
                int numeroPrestamos = estudiante.getNumeroPrestamos();
                estudiante.setNumeroPrestamos(numeroPrestamos - 1);
                prestamo.setCarreraEstudiante(estudiante.getCodigoCarrera());//pasando codigoCarrera estudiante a prestamo
            }
        }
        for (Libro libro : libros) {
            if (libro.getCodigo().equals(codigoLibro)) {
                int copias = libro.getCantidad();
                libro.setCantidad(copias - 1);
            }
        }
        System.out.println(prestamo.toString());
    }

    public boolean devolverLibro(ArrayList<Libro> libros, ArrayList<Estudiante> estudiantes, ArrayList<Prestamo> prestamos,
            int carnetEstudiante, String codigoLibro, String fechaDevolucion) {
        if (buscarEstudiante(estudiantes, carnetEstudiante) >= 0) {
            if (buscarLibro(libros, codigoLibro)) {
                int numeroPrestamo = buscarPrestamo(prestamos, carnetEstudiante, codigoLibro);
                if (numeroPrestamo != -1) {

                    String fechaPrestamo = prestamos.get(numeroPrestamo).getFecha();
                    LocalDate ldFechaPrestamo = LocalDate.parse(fechaPrestamo);
                    LocalDate ldFechaDevolucion = LocalDate.parse(fechaDevolucion);
                    long diferenciaDias = calcularDiferenciaDias(ldFechaPrestamo, ldFechaDevolucion);
                    System.out.println("La diferencia de días entre las fechas es: " + diferenciaDias + " días.");

                    if (diferenciaDias >= 0) {
                        for (Estudiante estudiante : estudiantes) {
                            if (estudiante.getCarnet() == carnetEstudiante) {
                                int numeroPrestamos = estudiante.getNumeroPrestamos();
                                estudiante.setNumeroPrestamos(numeroPrestamos + 1);
                            }
                        }
                        for (Libro libro : libros) {
                            if (libro.getCodigo().equals(codigoLibro)) {
                                int copias = libro.getCantidad();
                                libro.setCantidad(copias + 1);
                            }
                        }

                        //calcular el total a pagar
                        int totalPagar = 0;
                        String mensajePago = "";
                        if (diferenciaDias > 3) {
                            totalPagar += 15 + ((diferenciaDias - 3) * 10);
                            prestamos.get(numeroPrestamo).setPagoDemora(totalPagar);
                            mensajePago = "3 días reglamentarios: Q15.00\n"
                                    + (diferenciaDias - 3) + " día(s) de atraso: Q" + ((diferenciaDias - 3) * 10) + ".00\n"
                                    + "Total a pagar: Q" + totalPagar + ".00";
                        } else {
                            totalPagar += diferenciaDias * 5;
                            prestamos.get(numeroPrestamo).setPagoNormal(totalPagar);
                            mensajePago = diferenciaDias + " día(s) reglamentario(s): Q" + (diferenciaDias * 5) + ".00\n"
                                    + "Total a pagar: Q" + totalPagar + ".00";
                        }

                        JOptionPane.showMessageDialog(null, mensajePago, "Pago", JOptionPane.INFORMATION_MESSAGE);
                        JOptionPane.showMessageDialog(null, "El libro se ha devuelto exitosamente", "Devolución", JOptionPane.INFORMATION_MESSAGE);
                        for (Prestamo prestamo : prestamos) {
                            if (prestamo.getCarnetEstudiante() == carnetEstudiante || prestamo.getCodigoLibro().equals(codigoLibro)) {
                                prestamo.setActivo(false);
                            }
                        }
                        return true;
                    } else {
                        String mensaje = "El libro no se puede devolver porque la fecha de devolución es menor a la del prestamo";
                        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } else {
                    String mensaje = "El estudiante: " + carnetEstudiante + ", no tiene prestado el libro: " + codigoLibro;
                    JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                String mensaje = "El libro con codigo: " + codigoLibro + ", no existe";
                JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            String mensaje = "El estudiante con carnet: " + carnetEstudiante + ", no existe";
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return false;
    }

    private int buscarPrestamo(ArrayList<Prestamo> prestamos, int carnetEstudiante, String codigoLibro) {

        int encontrado = -1; // boolean entrontrado = false;
        for (int i = 0; i < prestamos.size(); i++/*Prestamo prestamo : prestamos*/) {
            if (prestamos.get(i).getCodigoLibro().equals(codigoLibro) || prestamos.get(i).getCarnetEstudiante() == carnetEstudiante) {
                encontrado = i;//encontrado = true;
            }
        }
        return encontrado;
    }

    public long calcularDiferenciaDias(LocalDate fecha1, LocalDate fecha2) {
        return ChronoUnit.DAYS.between(fecha1, fecha2);
    }

    public void filtrarPrestamosRango(String fechaInicio, String fechaFin, ArrayList<Prestamo> prestamos, ArrayList<Estudiante> estudiantes,
            DefaultTableModel modelo, int carrera) throws ParseException {

        if (fechaValida(fechaInicio) && fechaValida(fechaFin)) {
            LocalDate fechaInicial = LocalDate.parse(fechaInicio);
            LocalDate fechaFinal = LocalDate.parse(fechaFin);

            long diferenciaDias = calcularDiferenciaDias(fechaInicial, fechaFinal);
            if (diferenciaDias >= 0) {

                for (Prestamo prestamo : prestamos) {
                    LocalDate fechaPrestamo = LocalDate.parse(prestamo.getFecha());
                    if (fechaPrestamo.isAfter(fechaInicial) && fechaPrestamo.isBefore(fechaFinal)
                            || prestamo.getFecha().equals(fechaFinal)
                            || prestamo.getFecha().equals(fechaInicio)
                            && carrera == 0) {
                        modelo.addRow(new Object[]{
                            prestamo.getCarnetEstudiante(),
                            prestamo.getCodigoLibro()
                        });
                    } else if (fechaPrestamo.isAfter(fechaInicial) && fechaPrestamo.isBefore(fechaFinal)
                            || prestamo.getFecha().equals(fechaInicio)
                            || prestamo.getFecha().equals(fechaInicio)
                            && prestamo.getCarreraEstudiante() == carrera) {
                        modelo.addRow(new Object[]{
                            prestamo.getCarnetEstudiante(),
                            prestamo.getCodigoLibro()
                        });
}
                }

            } else {
                String mensaje = "La fecha incial no puede ser despues de la fecha final...";
                JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            String mensaje = "Formato de fecha incorrecto (yyyy-mm-dd)";
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

}
