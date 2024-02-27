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
public class ErrorEstudiante extends javax.swing.JFrame {

    private DefaultTableModel modelo;
    private ArrayList<ErrorLecturaArchivo> erroresEstudiante;

    /**
     * Creates new form ErrorEstudiante
     */
    public ErrorEstudiante() {
        initComponents();
        this.setLocationRelativeTo(null);
        modelo = (DefaultTableModel) jTable1.getModel();
    }

    public void listarErroresEstudiantes(ArrayList<ErrorLecturaArchivo> erroresEnviados) {
        this.erroresEstudiante = erroresEnviados;
        for (int i = 0; i < erroresEnviados.size(); i++) {
            String carnet = "CNV";
            String carrera = "CNV";
            if (erroresEnviados.get(i).getEstudianteError().getCarnet() > 0) {
                carnet = Integer.toString(erroresEnviados.get(i).getEstudianteError().getCarnet());
            } else if (erroresEnviados.get(i).getEstudianteError().getCarnet() == -1) {
                carnet = null;
            }
            if (erroresEnviados.get(i).getEstudianteError().getCodigoCarrera() > 0) {
                carrera = Integer.toString(erroresEnviados.get(i).getEstudianteError().getCodigoCarrera());
            } else if (erroresEnviados.get(i).getEstudianteError().getCodigoCarrera() == -1) {
                carrera = null;
            }
            modelo.addRow(new Object[]{carnet, erroresEnviados.get(i).getEstudianteError().getNombre(),
                /*erroresEnviados.get(i).getEstudianteError().getCodigoCarrera()*/carrera, "-Ver mensaje-"});
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
                "Carnet", "Nombre", "Carrera", "Mensaje"
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
        jLabel1.setText("ERROR EN ESTUDIANTES");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        // TODO add your handling code here:
        if (jTable1.getSelectedColumn() == 3) {
            int posicionError = jTable1.getSelectedRow();
            String mensaje = "";
            for (int i = 0; i < erroresEstudiante.get(posicionError).getMensaje().size(); i++) {
                mensaje += erroresEstudiante.get(posicionError).getMensaje().get(i) + "\n";
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