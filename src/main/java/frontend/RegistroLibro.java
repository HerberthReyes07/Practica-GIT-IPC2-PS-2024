/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend;

import backend.Biblioteca;
import backend.Bibliotecario;
import backend.ErrorLecturaArchivo;
import backend.Libro;
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
public class RegistroLibro extends javax.swing.JFrame {

    private Biblioteca biblioteca;
    private Bibliotecario bibliotecario = new Bibliotecario();
    private ArrayList<Libro> libros;
    private ArrayList<ErrorLecturaArchivo> erroresLectura = new ArrayList();
    private ArrayList<String> mensajeError = new ArrayList();
    private SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Creates new form RegistroLibro
     */
    public RegistroLibro(Biblioteca biblioteca) {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        SetImageLabel(icnLibro, "src/main/java/iconos/libro.png");
        this.biblioteca = biblioteca;
        this.libros = biblioteca.getLibros();
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
        fieldEditorial = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnListadoLibros = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        icnLibro = new javax.swing.JLabel();
        btnAgregarCopias = new javax.swing.JButton();
        calendario = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(6, 0));

        pnlFrame.setBackground(new java.awt.Color(153, 153, 0));
        pnlFrame.setLayout(null);

        lblRegistrarLibro.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lblRegistrarLibro.setForeground(new java.awt.Color(0, 0, 0));
        lblRegistrarLibro.setText("Registrar Libro");
        pnlFrame.add(lblRegistrarLibro);
        lblRegistrarLibro.setBounds(250, 30, 140, 40);

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
        lblCopias.setBounds(60, 260, 180, 18);

        lblFecha.setForeground(new java.awt.Color(0, 0, 255));
        lblFecha.setText("Fecha de Publicacion:");
        pnlFrame.add(lblFecha);
        lblFecha.setBounds(60, 320, 180, 18);

        lblEditorial.setForeground(new java.awt.Color(0, 0, 255));
        lblEditorial.setText("Editorial:");
        pnlFrame.add(lblEditorial);
        lblEditorial.setBounds(60, 380, 70, 18);

        fieldCodigo.setBackground(new java.awt.Color(255, 255, 255));
        pnlFrame.add(fieldCodigo);
        fieldCodigo.setBounds(60, 100, 180, 30);

        fieldAutor.setBackground(new java.awt.Color(255, 255, 255));
        pnlFrame.add(fieldAutor);
        fieldAutor.setBounds(60, 160, 180, 30);

        fieldTitulo.setBackground(new java.awt.Color(255, 255, 255));
        pnlFrame.add(fieldTitulo);
        fieldTitulo.setBounds(60, 220, 180, 30);

        fieldCopias.setBackground(new java.awt.Color(255, 255, 255));
        pnlFrame.add(fieldCopias);
        fieldCopias.setBounds(60, 280, 180, 30);

        fieldEditorial.setBackground(new java.awt.Color(255, 255, 255));
        pnlFrame.add(fieldEditorial);
        fieldEditorial.setBounds(60, 400, 180, 30);

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
        btnListadoLibros.setBounds(130, 520, 300, 30);

        btnCancelar.setBackground(new java.awt.Color(255, 0, 51));
        btnCancelar.setForeground(new java.awt.Color(0, 0, 0));
        btnCancelar.setText("Regresar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnlFrame.add(btnCancelar);
        btnCancelar.setBounds(240, 590, 130, 30);
        pnlFrame.add(icnLibro);
        icnLibro.setBounds(340, 160, 220, 190);

        btnAgregarCopias.setBackground(new java.awt.Color(0, 255, 255));
        btnAgregarCopias.setForeground(new java.awt.Color(0, 0, 255));
        btnAgregarCopias.setText("Agregar Copias");
        btnAgregarCopias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCopiasActionPerformed(evt);
            }
        });
        pnlFrame.add(btnAgregarCopias);
        btnAgregarCopias.setBounds(310, 450, 190, 30);

        calendario.setDateFormatString("yyyy-MM-dd");
        pnlFrame.add(calendario);
        calendario.setBounds(60, 340, 180, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFrame, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:

        String codigo = fieldCodigo.getText();
        String autor = fieldAutor.getText();
        String titulo = fieldTitulo.getText();
        String cantidadCopias = fieldCopias.getText();
        String editorial = fieldEditorial.getText();
        String fecha = "FNV";
        try {
            fecha = formato.format(calendario.getDate());
        } catch (NullPointerException e) {
        }

        if (fieldTitulo.getText().isEmpty() || fieldAutor.getText().isEmpty() || fieldCopias.getText().isEmpty()) {
            String mensaje = "Complete los campos vacios";
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            boolean datosValidos = bibliotecario.validarRegistroLibro(libros, erroresLectura, mensajeError, titulo, autor, codigo, cantidadCopias, fecha, editorial);
            if (datosValidos) {
                fieldCodigo.setText("");
                fieldAutor.setText("");
                fieldTitulo.setText("");
                fieldCopias.setText("");
                calendario.setCalendar(null);
                fieldEditorial.setText("");
            }
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

    private void btnAgregarCopiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCopiasActionPerformed
        // TODO add your handling code here:
        AgregarCopiaLibro agregarCopiaLibro = new AgregarCopiaLibro(biblioteca);
        agregarCopiaLibro.setVisible(true);
    }//GEN-LAST:event_btnAgregarCopiasActionPerformed

    private void SetImageLabel(JLabel nombreLabel, String ruta) {
        ImageIcon imagen = new ImageIcon(ruta);
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(nombreLabel.getWidth(), nombreLabel.getHeight(), Image.SCALE_DEFAULT));
        nombreLabel.setIcon(icono);
        this.repaint();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCopias;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnListadoLibros;
    private javax.swing.JButton btnRegistrar;
    private com.toedter.calendar.JDateChooser calendario;
    private javax.swing.JTextField fieldAutor;
    private javax.swing.JTextField fieldCodigo;
    private javax.swing.JTextField fieldCopias;
    private javax.swing.JTextField fieldEditorial;
    private javax.swing.JTextField fieldTitulo;
    private javax.swing.JLabel icnLibro;
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
