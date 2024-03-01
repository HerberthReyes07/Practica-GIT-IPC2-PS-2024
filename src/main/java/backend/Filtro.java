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

    private ArrayList<Estudiante> estudiantesTemp = new ArrayList();
    private Bibliotecario bibliotecario = new Bibliotecario();

    public void filtroEstudiantes(int contadorBorrarEnviado, int carnet, String nombre, int codigoCarrera, DefaultTableModel modeloEstudiantes, ArrayList<Estudiante> estudiantes) {

        String carnetFiltro = Integer.toString(carnet);

        for (int j = 0; j < contadorBorrarEnviado; j++) {
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
