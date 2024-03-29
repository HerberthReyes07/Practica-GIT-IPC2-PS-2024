/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author herberthreyes
 */
public class ControladorArchivoBinario {
    public void guardarBiblioteca(Biblioteca biblioteca, File archivoBinario){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(archivoBinario);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(biblioteca);
            objectOutputStream.close();
            String mensaje = "Información guardada exitosamente";
            JOptionPane.showMessageDialog(null, mensaje, "Almacenar información", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    public Biblioteca leerBibliotecaGuardada(File archivoBinario){
        try {
            FileInputStream fileInputStream = new FileInputStream(archivoBinario);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Biblioteca biblioteca = (Biblioteca) objectInputStream.readObject();
            objectInputStream.close();
            return biblioteca;
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada");
        }
        return null;
    }
}
