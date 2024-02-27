/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend;

import backend.Biblioteca;
import backend.Libro;
import java.util.ArrayList;
import java.util.InputMismatchException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ronyrojas
 */
public class RegistroLibro extends javax.swing.JFrame {

    private Biblioteca biblioteca;
    private ArrayList<Libro> libros;

    /**
     * Creates new form RegistroLibro
     */
    public RegistroLibro(Biblioteca biblioteca) {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.biblioteca = biblioteca;
        libros = biblioteca.getLibros();
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
        lblRegistrarLibro = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        lblAutor = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblCopias = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblEditorial = new javax.swing.JLabel();
        fieldCodigo = new javax.swing.JTextField();
        fieldAutor = new javax.swing.JTextField();
        fieldTitulo = new javax.swing.JTextField();
        fieldCopias = new javax.swing.JTextField();
        fieldFecha = new javax.swing.JTextField();
        fieldEditorial = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnListadoLibros = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 540));
        setSize(new java.awt.Dimension(6, 0));

        pnlFrame.setBackground(new java.awt.Color(153, 153, 0));
        pnlFrame.setLayout(null);

        lblRegistrarLibro.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lblRegistrarLibro.setForeground(new java.awt.Color(0, 0, 0));
        lblRegistrarLibro.setText("Registrar Nuevo Libro");
        pnlFrame.add(lblRegistrarLibro);
        lblRegistrarLibro.setBounds(190, 30, 210, 40);

        lblCodigo.setForeground(new java.awt.Color(0, 0, 255));
        lblCodigo.setText("Codigo:");
        pnlFrame.add(lblCodigo);
        lblCodigo.setBounds(60, 80, 60, 18);

        lblAutor.setForeground(new java.awt.Color(0, 0, 255));
        lblAutor.setText("Autor:");
        pnlFrame.add(lblAutor);
        lblAutor.setBounds(60, 140, 60, 18);

        lblTitulo.setForeground(new java.awt.Color(0, 0, 255));
        lblTitulo.setText("Titulo:");
        pnlFrame.add(lblTitulo);
        lblTitulo.setBounds(60, 200, 50, 18);

        lblCopias.setForeground(new java.awt.Color(0, 0, 255));
        lblCopias.setText("Cantidad de Copias:");
        pnlFrame.add(lblCopias);
        lblCopias.setBounds(60, 260, 140, 18);

        lblFecha.setForeground(new java.awt.Color(0, 0, 255));
        lblFecha.setText("Fecha de Publicacion:");
        pnlFrame.add(lblFecha);
        lblFecha.setBounds(60, 320, 160, 18);

        lblEditorial.setForeground(new java.awt.Color(0, 0, 255));
        lblEditorial.setText("Editorial:");
        pnlFrame.add(lblEditorial);
        lblEditorial.setBounds(60, 380, 70, 18);

        fieldCodigo.setBackground(new java.awt.Color(255, 255, 255));
        pnlFrame.add(fieldCodigo);
        fieldCodigo.setBounds(60, 100, 180, 24);

        fieldAutor.setBackground(new java.awt.Color(255, 255, 255));
        pnlFrame.add(fieldAutor);
        fieldAutor.setBounds(60, 160, 180, 24);

        fieldTitulo.setBackground(new java.awt.Color(255, 255, 255));
        pnlFrame.add(fieldTitulo);
        fieldTitulo.setBounds(60, 220, 180, 24);

        fieldCopias.setBackground(new java.awt.Color(255, 255, 255));
        pnlFrame.add(fieldCopias);
        fieldCopias.setBounds(60, 280, 180, 24);

        fieldFecha.setBackground(new java.awt.Color(255, 255, 255));
        pnlFrame.add(fieldFecha);
        fieldFecha.setBounds(60, 340, 180, 24);

        fieldEditorial.setBackground(new java.awt.Color(255, 255, 255));
        pnlFrame.add(fieldEditorial);
        fieldEditorial.setBounds(60, 400, 180, 24);

        btnRegistrar.setBackground(new java.awt.Color(0, 255, 255));
        btnRegistrar.setForeground(new java.awt.Color(0, 0, 255));
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        pnlFrame.add(btnRegistrar);
        btnRegistrar.setBounds(60, 450, 180, 30);

        btnListadoLibros.setBackground(new java.awt.Color(0, 255, 255));
        btnListadoLibros.setForeground(new java.awt.Color(0, 0, 255));
        btnListadoLibros.setText("Ver Listado de Libros Existentes");
        btnListadoLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListadoLibrosActionPerformed(evt);
            }
        });
        pnlFrame.add(btnListadoLibros);
        btnListadoLibros.setBounds(330, 450, 240, 30);

        btnCancelar.setBackground(new java.awt.Color(255, 0, 51));
        btnCancelar.setForeground(new java.awt.Color(0, 0, 0));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnlFrame.add(btnCancelar);
        btnCancelar.setBounds(220, 510, 130, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFrame, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFrame, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:

        String codigo = fieldCodigo.getText();
        String autor = fieldAutor.getText();
        String titulo = fieldTitulo.getText();
        int cantidad = 0;

        try {// que no manden texto
            cantidad = Integer.parseInt(fieldCopias.getText());
        } catch (NumberFormatException e) {
            String mensaje = "En el campo: Cantidad de Copias,\nDebe ingresar un valor numerico entero positivo";
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
        }

        String fecha = fieldFecha.getText();
        String editorial = fieldEditorial.getText();

        if (fieldTitulo.getText().isEmpty() || fieldAutor.getText().isEmpty() || fieldTitulo.getText().isEmpty()) {
            String mensaje = "Complete los campos vacios";
            System.out.println("mensaje = " + mensaje);
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);

        } else if (cantidad == 0) {
            cantidad = -1;
            
        } else {
            libros.add(new Libro(titulo, autor, codigo, cantidad, fecha, editorial));

            fieldCodigo.setText("");
            fieldAutor.setText("");
            fieldTitulo.setText("");
            fieldCopias.setText("");
            fieldFecha.setText("");
            fieldEditorial.setText("");
        }

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnListadoLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListadoLibrosActionPerformed
        // TODO add your handling code here:
        ListadoLibros listadoLibros = new ListadoLibros(biblioteca);
        listadoLibros.setVisible(true);
    }//GEN-LAST:event_btnListadoLibrosActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnListadoLibros;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JTextField fieldAutor;
    private javax.swing.JTextField fieldCodigo;
    private javax.swing.JTextField fieldCopias;
    private javax.swing.JTextField fieldEditorial;
    private javax.swing.JTextField fieldFecha;
    private javax.swing.JTextField fieldTitulo;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCopias;
    private javax.swing.JLabel lblEditorial;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblRegistrarLibro;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlFrame;
    // End of variables declaration//GEN-END:variables
}
