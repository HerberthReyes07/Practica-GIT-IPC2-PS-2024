/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author herberthreyes
 */
public class Filtro {

    private ArrayList<Libro> librosTemp = new ArrayList();
    private ArrayList<Estudiante> estudiantesTemp = new ArrayList();
    private Bibliotecario bibliotecario = new Bibliotecario();

    public void filtroLibros(int contadorBorrado, String codigo, String autor, String titulo, DefaultTableModel modeloLibros, ArrayList<Libro> libros) {
        borrarFilas(contadorBorrado, modeloLibros);

        for (int i = 0; i < libros.size(); i++) {
            if (codigo.equals("") && autor.equals("") && titulo.equals("")) {//1
                librosTemp.add(libros.get(i));
            } else {
                if (!codigo.equals("") && autor.equals("") && titulo.equals("")) {//2
                    if (libros.get(i).getCodigo().contains(codigo)) {
                        librosTemp.add(libros.get(i));
                    }
                } else {
                    if (!codigo.equals("") && !autor.equals("") && titulo.equals("")) {//3
                        if (libros.get(i).getCodigo().contains(codigo) && libros.get(i).getAutor().contains(autor)) {
                            librosTemp.add(libros.get(i));
                        }
                    } else {
                        if (!codigo.equals("") && autor.equals("") && !titulo.equals("")) {//4
                            if (libros.get(i).getCodigo().contains(codigo) && libros.get(i).getTitulo().contains(titulo)) {
                                librosTemp.add(libros.get(i));
                            }
                        } else {
                            if (codigo.equals("") && !autor.equals("") && titulo.equals("")) {//5
                                if (libros.get(i).getAutor().contains(autor)) {
                                    librosTemp.add(libros.get(i));
                                }
                            } else {
                                if (codigo.equals("") && !autor.equals("") && !titulo.equals("")) {//6
                                    if (libros.get(i).getAutor().contains(autor) && libros.get(i).getTitulo().contains(titulo)) {
                                        librosTemp.add(libros.get(i));
                                    }
                                } else {
                                    if (codigo.equals("") && autor.equals("") && !titulo.equals("")) {//7
                                        if (libros.get(i).getTitulo().contains(titulo)) {
                                            librosTemp.add(libros.get(i));
                                        }
                                    } else {
                                        if (!codigo.equals("") && !autor.equals("") && !titulo.equals("")) {//8
                                            if (libros.get(i).getCodigo().contains(codigo) && libros.get(i).getAutor().contains(autor)
                                                    && libros.get(i).getTitulo().contains(titulo)) {
                                                librosTemp.add(libros.get(i));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        bibliotecario.ordenarLibros(librosTemp);
        for (Libro libro : librosTemp) {
            modeloLibros.addRow(new Object[]{
                libro.getCodigo(),
                libro.getAutor(),
                libro.getTitulo(),
                libro.getCantidad(),
                libro.getFechaPublicacion(),
                libro.getEditorial()
            });
        }
    }

    public void filtroEstudiantes(int contadorBorrado, int carnet, String nombre, int codigoCarrera, DefaultTableModel modeloEstudiantes, ArrayList<Estudiante> estudiantes) {

        String carnetFiltro = Integer.toString(carnet);
        borrarFilas(contadorBorrado, modeloEstudiantes);

        for (int i = 0; i < estudiantes.size(); i++) {
            if (carnet == -1 && nombre.equals("") && codigoCarrera == 0) {//1
                estudiantesTemp.add(estudiantes.get(i));
            } else {
                if (carnet != -1 && nombre.equals("") && codigoCarrera == 0) {//2
                    if (Integer.toString(estudiantes.get(i).getCarnet()).contains(carnetFiltro)) {
                        estudiantesTemp.add(estudiantes.get(i));
                    }
                } else {
                    if (carnet != -1 && !nombre.equals("") && codigoCarrera == 0) {//3
                        if (Integer.toString(estudiantes.get(i).getCarnet()).contains(carnetFiltro) && estudiantes.get(i).getNombre().contains(nombre)) {
                            estudiantesTemp.add(estudiantes.get(i));
                        }
                    } else {
                        if (carnet != -1 && nombre.equals("") && codigoCarrera != 0) {//4
                            if (Integer.toString(estudiantes.get(i).getCarnet()).contains(carnetFiltro) && estudiantes.get(i).getCodigoCarrera() == codigoCarrera) {
                                estudiantesTemp.add(estudiantes.get(i));
                            }
                        } else {
                            if (carnet == -1 && !nombre.equals("") && codigoCarrera == 0) {//5
                                if (estudiantes.get(i).getNombre().contains(nombre)) {
                                    estudiantesTemp.add(estudiantes.get(i));
                                }
                            } else {
                                if (carnet == -1 && !nombre.equals("") && codigoCarrera != 0) {//6
                                    if (estudiantes.get(i).getNombre().contains(nombre) && estudiantes.get(i).getCodigoCarrera() == codigoCarrera) {
                                        estudiantesTemp.add(estudiantes.get(i));
                                    }
                                } else {
                                    if (carnet == -1 && nombre.equals("") && codigoCarrera != 0) {//7
                                        if (estudiantes.get(i).getCodigoCarrera() == codigoCarrera) {
                                            estudiantesTemp.add(estudiantes.get(i));
                                        }
                                    } else {
                                        if (carnet != -1 && !nombre.equals("") && codigoCarrera != 0) {//8
                                            if (estudiantes.get(i).getNombre().contains(nombre) && Integer.toString(estudiantes.get(i).getCarnet()).contains(carnetFiltro)
                                                    && estudiantes.get(i).getCodigoCarrera() == codigoCarrera) {
                                                estudiantesTemp.add(estudiantes.get(i));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        bibliotecario.ordenarEstudiantes(estudiantesTemp);
        for (Estudiante estudiante : estudiantesTemp) {
            modeloEstudiantes.addRow(new Object[]{
                estudiante.getCarnet(),
                estudiante.getNombre(),
                estudiante.getCodigoCarrera(),
                estudiante.getFechaNacimiento()
            });
        }
    }

    public void filtroPrestamos(int contadorBorrado, int carnet, DefaultTableModel modeloPrestamos, ArrayList<Prestamo> prestamos) {

        String carnetFiltro = Integer.toString(carnet);
        borrarFilas(contadorBorrado, modeloPrestamos);

        for (int i = 0; i < prestamos.size(); i++) {
            if (carnet == -1) {
                agregarPrestamosTabla(i, modeloPrestamos, prestamos);
            } else {
                if (Integer.toString(prestamos.get(i).getCarnetEstudiante()).contains(carnetFiltro)) {
                    agregarPrestamosTabla(i, modeloPrestamos, prestamos);
                }
            }
        }
    }

    public void filtroPrestamoLibro(int contadorBorrado, int carnet, DefaultTableModel modeloPrestamos, ArrayList<Prestamo> prestamos, ArrayList<Libro> libros, ArrayList<Estudiante> estudiantes) {

        String carnetFiltro = Integer.toString(carnet);
        borrarFilas(contadorBorrado, modeloPrestamos);

        for (int i = 0; i < prestamos.size(); i++) {
            if (prestamos.get(i).isActivo()) {
                int indexLibro = bibliotecario.buscarLibro(libros, prestamos.get(i).getCodigoLibro());
                int indexEstudiante = bibliotecario.buscarEstudiante(estudiantes, prestamos.get(i).getCarnetEstudiante());

                if (carnet == -1) {
                    modeloPrestamos.addRow(new Object[]{
                        prestamos.get(i).getCarnetEstudiante(),
                        estudiantes.get(indexEstudiante).getNombre(),
                        prestamos.get(i).getCodigoLibro(),
                        libros.get(indexLibro).getTitulo(),
                        libros.get(indexLibro).getAutor(),
                        libros.get(indexLibro).getCantidad()
                    });
                } else {
                    if (Integer.toString(prestamos.get(i).getCarnetEstudiante()).contains(carnetFiltro)) {
                        modeloPrestamos.addRow(new Object[]{
                            prestamos.get(i).getCarnetEstudiante(),
                            estudiantes.get(indexEstudiante).getNombre(),
                            prestamos.get(i).getCodigoLibro(),
                            libros.get(indexLibro).getTitulo(),
                            libros.get(indexLibro).getAutor(),
                            libros.get(indexLibro).getCantidad()
                        });
                    }
                }
            }
        }

    }

    public boolean filtroPrestamoFecha(int numeroReporte, int contadorBorrado, String fechaActual, DefaultTableModel modeloPrestamos, ArrayList<Prestamo> prestamos) {

        boolean prestamoEncontrado = false;
        borrarFilas(contadorBorrado, modeloPrestamos);

        for (int i = 0; i < prestamos.size(); i++) {
            if (prestamos.get(i).isActivo()) {
                LocalDate ldFechaPrestamo = LocalDate.parse(prestamos.get(i).getFecha());
                LocalDate ldFechaActual = LocalDate.parse(fechaActual);
                long diferenciaDias = bibliotecario.calcularDiferenciaDias(ldFechaPrestamo, ldFechaActual);

                if ((diferenciaDias == 3 && numeroReporte == 1) || (diferenciaDias > 3 && numeroReporte == 2)) {
                    agregarPrestamosTabla(i, modeloPrestamos, prestamos);
                    prestamoEncontrado = true;
                }
            }
        }
        return prestamoEncontrado;
    }

    public boolean filtroPrestamoIntervaloFecha(int contadorBorrado, boolean mostrarTodos, String fechaInicio, String fechaFin, DefaultTableModel modeloPrestamos, ArrayList<Prestamo> prestamos,
            JLabel lblDemora, JLabel lblNormal, JLabel lblTotal) {

        boolean prestamoEncontrado = false;
        int totalPagoNormal = 0;
        int totalPagoDemora = 0;
        borrarFilas(contadorBorrado, modeloPrestamos);

        for (int i = 0; i < prestamos.size(); i++) {

            if (!prestamos.get(i).isActivo()) {

                if (!mostrarTodos) {
                    LocalDate ldFechaInicial = LocalDate.parse(fechaInicio);
                    LocalDate ldFechaFinal = LocalDate.parse(fechaFin);
                    LocalDate ldFechaPrestamo = LocalDate.parse(prestamos.get(i).getFecha());

                    long diferenciaDias = bibliotecario.calcularDiferenciaDias(ldFechaInicial, ldFechaFinal);

                    if (diferenciaDias >= 0) {
                        if ((ldFechaPrestamo.isAfter(ldFechaInicial) && ldFechaPrestamo.isBefore(ldFechaFinal))
                                || prestamos.get(i).getFecha().equals(fechaInicio)
                                || prestamos.get(i).getFecha().equals(fechaFin)) {
                            agregarPrestamosTabla(i, modeloPrestamos, prestamos);
                            totalPagoNormal += prestamos.get(i).getPagoNormal();
                            totalPagoDemora += prestamos.get(i).getPagoDemora();
                            prestamoEncontrado = true;
                        }
                    } else {
                        String mensaje = "La fecha incial no puede ser mayor a la fecha final";
                        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    agregarPrestamosTabla(i, modeloPrestamos, prestamos);
                    totalPagoNormal += prestamos.get(i).getPagoNormal();
                    totalPagoDemora += prestamos.get(i).getPagoDemora();
                    prestamoEncontrado = true;
                }
            }
        }

        if (prestamoEncontrado) {
            lblNormal.setText("Dinero por prestamo normal: Q" + totalPagoNormal + ".00");
            lblDemora.setText("Dinero por demora: Q" + totalPagoDemora + ".00");
            lblTotal.setText("Total de dinero recaudado: Q" + (totalPagoNormal + totalPagoDemora) + ".00");
        } else {
            lblNormal.setText("Dinero por prestamo normal:");
            lblDemora.setText("Dinero por demora:");
            lblTotal.setText("Total de dinero recaudado:");
        }

        return prestamoEncontrado;
    }

    public void filtrarPrestamosRango(String fechaInicio, String fechaFin, ArrayList<Prestamo> prestamos, ArrayList<Estudiante> estudiantes,
            DefaultTableModel modelo, int carrera) throws ParseException {

        if (fechaInicio.equals("todos") && fechaFin.equals("todos")) {

            for (Prestamo prestamo : prestamos) {
                if (carrera == 0) {
                    modelo.addRow(new Object[]{
                        prestamo.getCarnetEstudiante(),
                        prestamo.getCodigoLibro()
                    });
                } else {
                    if (carrera == prestamo.getCarreraEstudiante()) {
                        modelo.addRow(new Object[]{
                            prestamo.getCarnetEstudiante(),
                            prestamo.getCodigoLibro()
                        });
                    }
                }
            }
        } else if (bibliotecario.fechaValida(fechaInicio) && bibliotecario.fechaValida(fechaFin)) {
            LocalDate fechaInicial = LocalDate.parse(fechaInicio);
            LocalDate fechaFinal = LocalDate.parse(fechaFin);

            long diferenciaDias = bibliotecario.calcularDiferenciaDias(fechaInicial, fechaFinal);
            if (diferenciaDias >= 0) {
                for (Prestamo prestamo : prestamos) {
                    LocalDate fechaPrestamo = LocalDate.parse(prestamo.getFecha());
                    if (fechaPrestamo.isAfter(fechaInicial) && fechaPrestamo.isBefore(fechaFinal)
                            || prestamo.getFecha().equals(fechaFinal)
                            || prestamo.getFecha().equals(fechaInicio)) {

                        if (carrera == 0) {
                            modelo.addRow(new Object[]{
                                prestamo.getCarnetEstudiante(),
                                prestamo.getCodigoLibro()
                            });
                        } else {
                            if (carrera == prestamo.getCarreraEstudiante()) {
                                modelo.addRow(new Object[]{
                                    prestamo.getCarnetEstudiante(),
                                    prestamo.getCodigoLibro()
                                });
                            }
                        }
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

    private void agregarPrestamosTabla(int index, DefaultTableModel modeloPrestamos, ArrayList<Prestamo> prestamos) {
        modeloPrestamos.addRow(new Object[]{
            prestamos.get(index).getCarnetEstudiante(),
            prestamos.get(index).getCodigoLibro(),
            prestamos.get(index).getFecha()
        });
    }

    private void borrarFilas(int contadorBorrado, DefaultTableModel modelo) {
        for (int j = 0; j < contadorBorrado; j++) {
            modelo.removeRow(0);
        }
    }
}
