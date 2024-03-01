/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.util.ArrayList;
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
        for (int j = 0; j < contadorBorrado; j++) {
            modeloLibros.removeRow(0);
        }
        
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
            modeloLibros.addRow(new Object[] {
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

        for (int j = 0; j < contadorBorrado; j++) {
            modeloEstudiantes.removeRow(0);
        }

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

}
