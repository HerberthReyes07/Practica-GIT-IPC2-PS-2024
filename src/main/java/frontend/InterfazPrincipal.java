/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend;

/**
 *
 * @author herberthreyes
 */
public class InterfazPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form InterfazPrincipal
     */
    public InterfazPrincipal() {
        initComponents();
        //this.setLocationRelativeTo(null);
        
        /*menuBar.setVisible(false);
        lblReportes.setVisible(false);
        lblAlmacenarInfo.setVisible(false);
        comboBoxReportes.setVisible(false);
        btnGuardarLibros.setVisible(false);
        btnGuardarEstudiantes.setVisible(false);
        btnGuardarPrestamos.setVisible(false);*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        pnlFrame = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        comboBoxReportes = new javax.swing.JComboBox<>();
        lblReportes = new javax.swing.JLabel();
        btnGuardarLibros = new javax.swing.JButton();
        btnGuardarEstudiantes = new javax.swing.JButton();
        btnGuardarPrestamos = new javax.swing.JButton();
        lblAlmacenarInfo = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuRegistrar = new javax.swing.JMenu();
        itemRegistrarLibro = new javax.swing.JMenuItem();
        itemRegistrarEstudiante = new javax.swing.JMenuItem();
        itemRegistrarPrestamo = new javax.swing.JMenuItem();
        menuAyuda = new javax.swing.JMenu();
        menuAcercaDe = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlFrame.setBackground(new java.awt.Color(101, 150, 164));
        pnlFrame.setLayout(null);

        lblTitulo.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 0, 0));
        lblTitulo.setText("BIBLIOTECA - CUNOC");
        pnlFrame.add(lblTitulo);
        lblTitulo.setBounds(290, 20, 220, 50);

        comboBoxReportes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Prestamos de libros a entregar hoy", "Prestamos de libros con mora", "Dinero recaudado en intervalo de tiempo", "Todos los prestamos hechos a un estudiante", "Prestamos actuales a un estudiante", "Prestamos hechos a cada carrera en intervalo de tiempo" }));
        comboBoxReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxReportesActionPerformed(evt);
            }
        });
        pnlFrame.add(comboBoxReportes);
        comboBoxReportes.setBounds(230, 100, 320, 40);

        lblReportes.setForeground(new java.awt.Color(0, 0, 0));
        lblReportes.setText("Reportes");
        pnlFrame.add(lblReportes);
        lblReportes.setBounds(360, 80, 90, 22);

        btnGuardarLibros.setText("Libros");
        pnlFrame.add(btnGuardarLibros);
        btnGuardarLibros.setBounds(220, 460, 120, 40);

        btnGuardarEstudiantes.setText("Estudiantes");
        pnlFrame.add(btnGuardarEstudiantes);
        btnGuardarEstudiantes.setBounds(340, 460, 120, 40);

        btnGuardarPrestamos.setText("Prestamos");
        pnlFrame.add(btnGuardarPrestamos);
        btnGuardarPrestamos.setBounds(460, 460, 120, 40);

        lblAlmacenarInfo.setForeground(new java.awt.Color(0, 0, 0));
        lblAlmacenarInfo.setText("Almacenar informacion");
        pnlFrame.add(lblAlmacenarInfo);
        lblAlmacenarInfo.setBounds(330, 430, 150, 22);

        menuRegistrar.setText("Registrar");

        itemRegistrarLibro.setText("Libro");
        itemRegistrarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRegistrarLibroActionPerformed(evt);
            }
        });
        menuRegistrar.add(itemRegistrarLibro);

        itemRegistrarEstudiante.setText("Estudiante");
        itemRegistrarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRegistrarEstudianteActionPerformed(evt);
            }
        });
        menuRegistrar.add(itemRegistrarEstudiante);

        itemRegistrarPrestamo.setText("Prestamo");
        itemRegistrarPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRegistrarPrestamoActionPerformed(evt);
            }
        });
        menuRegistrar.add(itemRegistrarPrestamo);

        menuBar.add(menuRegistrar);

        menuAyuda.setText("Ayuda");
        menuAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAyudaActionPerformed(evt);
            }
        });
        menuBar.add(menuAyuda);

        menuAcercaDe.setText("Acerca de");
        menuAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAcercaDeActionPerformed(evt);
            }
        });
        menuBar.add(menuAcercaDe);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFrame, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFrame, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemRegistrarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRegistrarLibroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemRegistrarLibroActionPerformed

    private void itemRegistrarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRegistrarEstudianteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemRegistrarEstudianteActionPerformed

    private void itemRegistrarPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRegistrarPrestamoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemRegistrarPrestamoActionPerformed

    private void menuAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAyudaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuAyudaActionPerformed

    private void menuAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAcercaDeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuAcercaDeActionPerformed

    private void comboBoxReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxReportesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxReportesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarEstudiantes;
    private javax.swing.JButton btnGuardarLibros;
    private javax.swing.JButton btnGuardarPrestamos;
    private javax.swing.JComboBox<String> comboBoxReportes;
    private javax.swing.JMenuItem itemRegistrarEstudiante;
    private javax.swing.JMenuItem itemRegistrarLibro;
    private javax.swing.JMenuItem itemRegistrarPrestamo;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel lblAlmacenarInfo;
    private javax.swing.JLabel lblReportes;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JMenu menuAcercaDe;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuRegistrar;
    private javax.swing.JPanel pnlFrame;
    // End of variables declaration//GEN-END:variables
}
