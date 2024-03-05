/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend;

import backend.Biblioteca;
import backend.Bibliotecario;
import backend.Estudiante;
import backend.Filtro;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ronyrojas
 */
public class ListadoEstudiantes extends javax.swing.JFrame {

    private Biblioteca biblioteca;
    private ArrayList<Estudiante> estudiantes;
    private Bibliotecario bibliotecario = new Bibliotecario();
    private DefaultTableModel modeloTabla;

    /**
     * Creates new form ListadoEstudiantes
     */
    public ListadoEstudiantes(Biblioteca biblioteca) {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.biblioteca = biblioteca;
        this.estudiantes = biblioteca.getEstudiantes();

        modeloTabla = (DefaultTableModel) tblListado.getModel();
        bibliotecario.ordenarEstudiantes(estudiantes);
        for (Estudiante estudiante : estudiantes) {
            modeloTabla.addRow(new Object[]{
                estudiante.getCarnet(),
                estudiante.getNombre(),
                estudiante.getCodigoCarrera(),
                estudiante.getFechaNacimiento()
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

        pnlFrame = new javax.swing.JPanel();
        lblListadoEstudiantes = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListado = new javax.swing.JTable();
        lblFiltrar = new javax.swing.JLabel();
        lblCarnet = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();
        fieldCarnet = new javax.swing.JTextField();
        fieldNombre = new javax.swing.JTextField();
        comboBoxCodigoCarrera = new javax.swing.JComboBox<>();
        lblNombre = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlFrame.setBackground(new java.awt.Color(0, 153, 153));
        pnlFrame.setLayout(null);

        lblListadoEstudiantes.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lblListadoEstudiantes.setForeground(new java.awt.Color(0, 0, 0));
        lblListadoEstudiantes.setText("Listado De Estudiantes Existentes:");
        pnlFrame.add(lblListadoEstudiantes);
        lblListadoEstudiantes.setBounds(350, 20, 330, 22);

        tblListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Carnet", "Nombre", "Codigo Carrera", "Fecha Nacimiento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblListado);

        pnlFrame.add(jScrollPane1);
        jScrollPane1.setBounds(30, 70, 940, 402);

        lblFiltrar.setForeground(new java.awt.Color(0, 0, 0));
        lblFiltrar.setText("Filtrar por:");
        pnlFrame.add(lblFiltrar);
        lblFiltrar.setBounds(30, 500, 100, 20);

        lblCarnet.setForeground(new java.awt.Color(0, 0, 0));
        lblCarnet.setText("Carnet:");
        pnlFrame.add(lblCarnet);
        lblCarnet.setBounds(30, 550, 70, 30);

        btnCerrar.setText("Cerrar Listado");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        pnlFrame.add(btnCerrar);
        btnCerrar.setBounds(830, 590, 140, 40);

        fieldCarnet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldCarnetKeyReleased(evt);
            }
        });
        pnlFrame.add(fieldCarnet);
        fieldCarnet.setBounds(100, 550, 140, 30);

        fieldNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldNombreKeyReleased(evt);
            }
        });
        pnlFrame.add(fieldNombre);
        fieldNombre.setBounds(340, 550, 160, 30);

        comboBoxCodigoCarrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "1", "2", "3", "4", "5" }));
        comboBoxCodigoCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCodigoCarreraActionPerformed(evt);
            }
        });
        pnlFrame.add(comboBoxCodigoCarrera);
        comboBoxCodigoCarrera.setBounds(680, 550, 97, 30);

        lblNombre.setForeground(new java.awt.Color(0, 0, 0));
        lblNombre.setText("Nombre:");
        pnlFrame.add(lblNombre);
        lblNombre.setBounds(260, 550, 80, 30);

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Codigo de Carrera:");
        pnlFrame.add(jLabel1);
        jLabel1.setBounds(520, 550, 160, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFrame, javax.swing.GroupLayout.DEFAULT_SIZE, 996, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFrame, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void fieldCarnetKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCarnetKeyReleased
        // TODO add your handling code here:
        filtrar();
    }//GEN-LAST:event_fieldCarnetKeyReleased

    private void fieldNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNombreKeyReleased
        // TODO add your handling code here:
        filtrar();
    }//GEN-LAST:event_fieldNombreKeyReleased

    private void comboBoxCodigoCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCodigoCarreraActionPerformed
        // TODO add your handling code here:
        filtrar();
    }//GEN-LAST:event_comboBoxCodigoCarreraActionPerformed

    private void filtrar() {
        Filtro filtro = new Filtro();
        int carnetFiltro = -1;
        if (bibliotecario.isNumeric(fieldCarnet.getText())) {
            carnetFiltro = Integer.parseInt(fieldCarnet.getText());
        }
        filtro.filtroEstudiantes(tblListado.getRowCount(), carnetFiltro, fieldNombre.getText(), comboBoxCodigoCarrera.getSelectedIndex(), modeloTabla, estudiantes);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JComboBox<String> comboBoxCodigoCarrera;
    private javax.swing.JTextField fieldCarnet;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCarnet;
    private javax.swing.JLabel lblFiltrar;
    private javax.swing.JLabel lblListadoEstudiantes;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JPanel pnlFrame;
    private javax.swing.JTable tblListado;
    // End of variables declaration//GEN-END:variables
}
