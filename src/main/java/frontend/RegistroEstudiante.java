/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend;

import backend.Biblioteca;
import backend.Bibliotecario;
import backend.ErrorLecturaArchivo;
import backend.Estudiante;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author ronyrojas
 */
public class RegistroEstudiante extends javax.swing.JFrame {

    /**
     * Creates new form RegistrarEstudiante
     */
    private Biblioteca biblioteca;
    private Bibliotecario bibliotecario = new Bibliotecario();
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<ErrorLecturaArchivo> erroresLectura = new ArrayList();
    private ArrayList<String> mensajeError = new ArrayList();
    private SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

    public RegistroEstudiante(Biblioteca biblioteca) {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        SetImageLabel(icnEstudiante, "src/main/java/iconos/estudiante.png");
        this.biblioteca = biblioteca;
        this.estudiantes = biblioteca.getEstudiantes();

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
        lblRegistarEstudiante = new javax.swing.JLabel();
        lblCarnet = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblCarrera = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        fieldCarnet = new javax.swing.JTextField();
        fieldNombre = new javax.swing.JTextField();
        fieldCodigoCarrera = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnListadoEstudiantes = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        icnEstudiante = new javax.swing.JLabel();
        calendario = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlFrame.setBackground(new java.awt.Color(0, 153, 0));
        pnlFrame.setLayout(null);

        lblRegistarEstudiante.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lblRegistarEstudiante.setForeground(new java.awt.Color(0, 0, 0));
        lblRegistarEstudiante.setText("Registrar Nuevo Estudiante");
        pnlFrame.add(lblRegistarEstudiante);
        lblRegistarEstudiante.setBounds(140, 20, 260, 40);

        lblCarnet.setForeground(new java.awt.Color(0, 0, 255));
        lblCarnet.setText("Carnet:");
        pnlFrame.add(lblCarnet);
        lblCarnet.setBounds(50, 90, 60, 18);

        lblNombre.setForeground(new java.awt.Color(0, 0, 255));
        lblNombre.setText("Nombre:");
        pnlFrame.add(lblNombre);
        lblNombre.setBounds(50, 150, 60, 18);

        lblCarrera.setForeground(new java.awt.Color(0, 0, 255));
        lblCarrera.setText("Codigo de Carrera:");
        pnlFrame.add(lblCarrera);
        lblCarrera.setBounds(50, 210, 130, 18);

        lblFecha.setForeground(new java.awt.Color(0, 0, 255));
        lblFecha.setText("Fecha de Nacimiento:");
        pnlFrame.add(lblFecha);
        lblFecha.setBounds(50, 270, 150, 18);

        fieldCarnet.setBackground(new java.awt.Color(255, 255, 255));
        pnlFrame.add(fieldCarnet);
        fieldCarnet.setBounds(50, 110, 150, 30);

        fieldNombre.setBackground(new java.awt.Color(255, 255, 255));
        pnlFrame.add(fieldNombre);
        fieldNombre.setBounds(50, 170, 150, 30);

        fieldCodigoCarrera.setBackground(new java.awt.Color(255, 255, 255));
        pnlFrame.add(fieldCodigoCarrera);
        fieldCodigoCarrera.setBounds(50, 230, 150, 30);

        btnRegistrar.setBackground(new java.awt.Color(0, 204, 204));
        btnRegistrar.setForeground(new java.awt.Color(0, 0, 255));
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        pnlFrame.add(btnRegistrar);
        btnRegistrar.setBounds(50, 350, 150, 30);

        btnListadoEstudiantes.setBackground(new java.awt.Color(0, 204, 204));
        btnListadoEstudiantes.setForeground(new java.awt.Color(0, 0, 255));
        btnListadoEstudiantes.setText("Ver Listado Estudiantes");
        btnListadoEstudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListadoEstudiantesActionPerformed(evt);
            }
        });
        pnlFrame.add(btnListadoEstudiantes);
        btnListadoEstudiantes.setBounds(290, 350, 200, 30);

        btnCancelar.setBackground(new java.awt.Color(255, 0, 51));
        btnCancelar.setForeground(new java.awt.Color(0, 0, 0));
        btnCancelar.setText("Regresar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnlFrame.add(btnCancelar);
        btnCancelar.setBounds(203, 390, 100, 30);
        pnlFrame.add(icnEstudiante);
        icnEstudiante.setBounds(290, 130, 190, 170);

        calendario.setBackground(new java.awt.Color(255, 255, 255));
        calendario.setDateFormatString("yyyy-MM-dd");
        pnlFrame.add(calendario);
        calendario.setBounds(50, 290, 150, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFrame, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFrame, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:

        String carnet = fieldCarnet.getText();
        String codigoCarrera = fieldCodigoCarrera.getText();
        String nombre = fieldNombre.getText();
        String fechaNacimiento = "";
        try {
            fechaNacimiento = formato.format(calendario.getDate());
        } catch (NullPointerException e) {
        }

        if (fieldCarnet.getText().isEmpty() || fieldCodigoCarrera.getText().isEmpty() || fieldNombre.getText().isEmpty()) {
            String mensaje = "Complete los campos vacios";
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            boolean datosValidos = bibliotecario.validarRegistroEstudiante(estudiantes, erroresLectura, mensajeError, carnet, nombre, codigoCarrera, fechaNacimiento);
            if (datosValidos) {
                fieldCarnet.setText("");
                fieldCodigoCarrera.setText("");
                fieldNombre.setText("");
            }
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnListadoEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListadoEstudiantesActionPerformed
        // TODO add your handling code here:
        System.out.println("boton registrar");
        ListadoEstudiantes listadoEstudiantes = new ListadoEstudiantes(biblioteca);
        listadoEstudiantes.setVisible(true);
    }//GEN-LAST:event_btnListadoEstudiantesActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void SetImageLabel(JLabel nombreLabel, String ruta) {
        ImageIcon imagen = new ImageIcon(ruta);
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(nombreLabel.getWidth(), nombreLabel.getHeight(), Image.SCALE_DEFAULT));
        nombreLabel.setIcon(icono);
        this.repaint();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnListadoEstudiantes;
    private javax.swing.JButton btnRegistrar;
    private com.toedter.calendar.JDateChooser calendario;
    private javax.swing.JTextField fieldCarnet;
    private javax.swing.JTextField fieldCodigoCarrera;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.JLabel icnEstudiante;
    private javax.swing.JLabel lblCarnet;
    private javax.swing.JLabel lblCarrera;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRegistarEstudiante;
    private javax.swing.JPanel pnlFrame;
    // End of variables declaration//GEN-END:variables
}
