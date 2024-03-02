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
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author herberthreyes
 */
public class Reporte4 extends javax.swing.JFrame {

    private Biblioteca biblioteca;
    private Bibliotecario bibliotecario;
    private ArrayList<Prestamo> prestamos;
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Libro> libros;
    private DefaultTableModel modeloTabla;

    /**
     * Creates new form Reporte4
     */
    public Reporte4(Biblioteca biblioteca) {
        initComponents();
        this.biblioteca = biblioteca;
        this.bibliotecario = biblioteca.getBibliotecario();
        this.prestamos = biblioteca.getPrestamos();
        this.estudiantes = biblioteca.getEstudiantes();
        this.libros = biblioteca.getLibros();

        this.modeloTabla = (DefaultTableModel) tblPrestamos.getModel();

        for (Prestamo prestamo : prestamos) {
            modeloTabla.addRow(new Object[]{
                prestamo.getCarnetEstudiante(),
                prestamo.getCodigoLibro(),
                prestamo.getFecha()
            });
        }
        System.out.println("4");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFrame = new javax.swing.JPanel();
        lblPrestamos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPrestamos = new javax.swing.JTable();
        lblCarnetEstudiante = new javax.swing.JLabel();
        fieldCarnetEstudiante = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlFrame.setBackground(new java.awt.Color(0, 204, 102));
        pnlFrame.setLayout(null);

        lblPrestamos.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lblPrestamos.setForeground(new java.awt.Color(0, 0, 0));
        lblPrestamos.setText("Todos Los Prestamos Hechos Por Un Estudiante");
        pnlFrame.add(lblPrestamos);
        lblPrestamos.setBounds(170, 20, 430, 30);

        tblPrestamos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Carnet Estudiante", "Codigo Libro", "Fecha Prestamo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPrestamos);

        pnlFrame.add(jScrollPane1);
        jScrollPane1.setBounds(160, 100, 452, 402);

        lblCarnetEstudiante.setForeground(new java.awt.Color(0, 0, 255));
        lblCarnetEstudiante.setText("Carnet del estudiante: ");
        pnlFrame.add(lblCarnetEstudiante);
        lblCarnetEstudiante.setBounds(10, 60, 150, 20);

        fieldCarnetEstudiante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldCarnetEstudianteKeyReleased(evt);
            }
        });
        pnlFrame.add(fieldCarnetEstudiante);
        fieldCarnetEstudiante.setBounds(160, 60, 110, 24);

        btnRegresar.setBackground(new java.awt.Color(255, 0, 0));
        btnRegresar.setForeground(new java.awt.Color(0, 0, 0));
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        pnlFrame.add(btnRegresar);
        btnRegresar.setBounds(340, 520, 130, 24);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFrame, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFrame, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void fieldCarnetEstudianteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCarnetEstudianteKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCarnetEstudianteKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JTextField fieldCarnetEstudiante;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCarnetEstudiante;
    private javax.swing.JLabel lblPrestamos;
    private javax.swing.JPanel pnlFrame;
    private javax.swing.JTable tblPrestamos;
    // End of variables declaration//GEN-END:variables
}
