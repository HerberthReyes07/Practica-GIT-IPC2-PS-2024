/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author herberthreyes
 */
public class BarraCarga extends Thread {

    private JLabel jLabel1;
    private boolean execute;

    @Override
    public void run() {
        try {
            jLabel1.setVisible(true);
            String textoCarga = "Cargando #";
            int cont = 0;
            while (execute) {
                if (cont < 40) {
                    textoCarga += "#";
                    jLabel1.setText(textoCarga);
                } else {
                    textoCarga = "Cargando #";
                    jLabel1.setText(textoCarga);
                    cont = 0;
                }
                cont++;
                Thread.sleep(50);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(BarraCarga.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public boolean isExecute() {
        return execute;
    }

    public void setExecute(boolean execute) {
        this.execute = execute;
    }

}
