/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.oscarmaestre.jminilogo;

import javax.swing.JFrame;

/**
 *
 * @author usuario
 */
public class Main {
    
    public static void ejecutar(){
        JFrame ventana=new SwingGUI().getUI();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setTitle("JMiniLogo");
        ventana.pack();
        ventana.setVisible(true);
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ejecutar();
            }
        });
        
    }
    
}
