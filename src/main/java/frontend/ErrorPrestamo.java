/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend;

import backend.ErrorLecturaArchivo;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author herberthreyes
 */
public class ErrorPrestamo extends javax.swing.JFrame {

    private DefaultTableModel modelo;
    private ArrayList<ErrorLecturaArchivo> erroresPrestamo;

    /**
     * Creates new form ErrorPrestamo
     */
    public ErrorPrestamo() {
        initComponents();
        this.setLocationRelativeTo(null);
        modelo = (DefaultTableModel) jTable1.getModel();
    }

    public void listarErroresPrestamos(ArrayList<ErrorLecturaArchivo> erroresEnviados) {
        this.erroresPrestamo = erroresEnviados;
        for (int i = 0; i < erroresEnviados.size(); i++) {
            String carnetEstudiante = "CNV";
            if (erroresEnviados.get(i).getPrestamoError().getCarnetEstudiante() > 0) {
                carnetEstudiante = Integer.toString(erroresEnviados.get(i).getPrestamoError().getCarnetEstudiante());
            } else if (erroresEnviados.get(i).getPrestamoError().getCarnetEstudiante() == -1) {
                carnetEstudiante = null;
            }
            modelo.addRow(new Object[]{erroresEnviados.get(i).getPrestamoError().getCodigoLibro(), carnetEstudiante,
                erroresEnviados.get(i).getPrestamoError().getFecha(), "-Ver mensaje-"});
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Libro", "Carnet Estudiante", "Fecha", "Mensaje"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("ERROR EN PRESTAMOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(259, 259, 259))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        // TODO add your handling code here:
        if (jTable1.getSelectedColumn() == 3) {
            int posicionError = jTable1.getSelectedRow();
            String mensaje = "";
            for (int i = 0; i < erroresPrestamo.get(posicionError).getMensaje().size(); i++) {
                mensaje += erroresPrestamo.get(posicionError).getMensaje().get(i) + "\n";
            }
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }//GEN-LAST:event_jTable1MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}