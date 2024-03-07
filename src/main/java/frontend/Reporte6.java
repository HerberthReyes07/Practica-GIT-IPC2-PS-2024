/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend;

import backend.Biblioteca;
import backend.Bibliotecario;
import backend.Estudiante;
import backend.Filtro;
import backend.Libro;
import backend.Prestamo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author herberthreyes
 */
public class Reporte6 extends javax.swing.JFrame {

    private Biblioteca biblioteca;
    private Bibliotecario bibliotecario = new Bibliotecario();
    private ArrayList<Prestamo> prestamos;
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Libro> libros;
    private DefaultTableModel modeloTabla;
    private SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Creates new form Reporte6
     */
    public Reporte6(Biblioteca biblioteca) {
        initComponents();
        this.biblioteca = biblioteca;
        this.prestamos = biblioteca.getPrestamos();
        this.estudiantes = biblioteca.getEstudiantes();
        this.libros = biblioteca.getLibros();
        this.modeloTabla = (DefaultTableModel) tblPrestamos.getModel();
        
        calendarioInicio.getDateEditor().setEnabled(false);
        calendarioFin.getDateEditor().setEnabled(false);

        for (Prestamo prestamo : prestamos) {
            modeloTabla.addRow(new Object[]{
                prestamo.getCarnetEstudiante(),
                prestamo.getCodigoLibro(),
                prestamo.getFecha()
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblPrestamos = new javax.swing.JLabel();
        lblCarrera = new javax.swing.JLabel();
        lblFechaInicio = new javax.swing.JLabel();
        lblFechaFin = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPrestamos = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        comboBoxCarrera = new javax.swing.JComboBox<>();
        calendarioInicio = new com.toedter.calendar.JDateChooser();
        calendarioFin = new com.toedter.calendar.JDateChooser();
        btnLimpiarFechas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 102));
        jPanel1.setLayout(null);

        lblPrestamos.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lblPrestamos.setForeground(new java.awt.Color(0, 0, 0));
        lblPrestamos.setText("Prestamos Hechos A Cada Carrera");
        jPanel1.add(lblPrestamos);
        lblPrestamos.setBounds(120, 20, 320, 30);

        lblCarrera.setForeground(new java.awt.Color(0, 0, 255));
        lblCarrera.setText("Carrera: ");
        jPanel1.add(lblCarrera);
        lblCarrera.setBounds(20, 70, 70, 20);

        lblFechaInicio.setForeground(new java.awt.Color(0, 0, 255));
        lblFechaInicio.setText("Fecha inicio:");
        jPanel1.add(lblFechaInicio);
        lblFechaInicio.setBounds(220, 70, 90, 20);

        lblFechaFin.setForeground(new java.awt.Color(0, 0, 255));
        lblFechaFin.setText("Fecha fin:");
        jPanel1.add(lblFechaFin);
        lblFechaFin.setBounds(220, 110, 70, 20);

        tblPrestamos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Carnet Estudiante", "Codigo Libro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPrestamos);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(70, 150, 452, 402);

        btnRegresar.setBackground(new java.awt.Color(255, 0, 51));
        btnRegresar.setForeground(new java.awt.Color(0, 0, 0));
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar);
        btnRegresar.setBounds(220, 570, 120, 24);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar);
        btnBuscar.setBounds(440, 70, 140, 30);

        comboBoxCarrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "1", "2", "3", "4", "5", "6" }));
        jPanel1.add(comboBoxCarrera);
        comboBoxCarrera.setBounds(90, 70, 100, 30);

        calendarioInicio.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(calendarioInicio);
        calendarioInicio.setBounds(310, 70, 110, 30);

        calendarioFin.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(calendarioFin);
        calendarioFin.setBounds(310, 110, 110, 30);

        btnLimpiarFechas.setText("Limpiar Fechas");
        btnLimpiarFechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarFechasActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiarFechas);
        btnLimpiarFechas.setBounds(440, 110, 140, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        String fechaInicio = "";
        String fechaFin = "";
        try {
            fechaInicio = formato.format(calendarioInicio.getDate());
        } catch (NullPointerException e) {
        }
        try {
            fechaFin = formato.format(calendarioFin.getDate());
        } catch (NullPointerException e) {
        }
        int carrera = comboBoxCarrera.getSelectedIndex();
        while (modeloTabla.getRowCount() > 0) {
            modeloTabla.removeRow(0);
        }

        if (fechaInicio == "" && fechaFin != "" || fechaInicio != "" && fechaFin == "") {
            String mensaje = "Ingrese la fecha del prestamo faltante";
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
        } else if (fechaInicio == "" && fechaFin == "") {
            fechaInicio = "todos";
            fechaFin = "todos";
            try {
                Filtro filtro = new Filtro();
                filtro.filtrarPrestamosRango(fechaInicio, fechaFin, prestamos, estudiantes, modeloTabla, carrera);
            } catch (ParseException ex) {
                Logger.getLogger(Reporte6.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                Filtro filtro = new Filtro();
                filtro.filtrarPrestamosRango(fechaInicio, fechaFin, prestamos, estudiantes, modeloTabla, carrera);
            } catch (ParseException ex) {
                Logger.getLogger(Reporte6.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimpiarFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarFechasActionPerformed
        // TODO add your handling code here:
        calendarioInicio.setCalendar(null);
        calendarioFin.setCalendar(null);
    }//GEN-LAST:event_btnLimpiarFechasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpiarFechas;
    private javax.swing.JButton btnRegresar;
    private com.toedter.calendar.JDateChooser calendarioFin;
    private com.toedter.calendar.JDateChooser calendarioInicio;
    private javax.swing.JComboBox<String> comboBoxCarrera;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCarrera;
    private javax.swing.JLabel lblFechaFin;
    private javax.swing.JLabel lblFechaInicio;
    private javax.swing.JLabel lblPrestamos;
    private javax.swing.JTable tblPrestamos;
    // End of variables declaration//GEN-END:variables
}
