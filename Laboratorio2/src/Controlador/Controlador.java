/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Datos.Ahorcado;
import Vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JRadioButton;

/**
 *
 * @author COMPAQ
 */
public class Controlador implements ActionListener {
    private Vista vista;
    private Ahorcado ahorcado;

    public Controlador(Vista vista, Ahorcado ahorcado) {
        this.vista = vista;
        this.ahorcado = ahorcado;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton){
        JButton boton=(JButton)e.getSource();
        if(boton.getText().equalsIgnoreCase("A")){
            System.out.println("la letra es a");
        }else if(e.getSource() instanceof JRadioButton ){
        JRadioButton radio=(JRadioButton)e.getSource();
            if(radio.getText().equals("Palabras")&&radio.isSelected()){
            
            try {
                this.ahorcado.setModoJuego("Palabras");
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
            
            
            } else if(radio.getText().equals("Frases")&&radio.isSelected()){
            
            try {
                this.ahorcado.setModoJuego("Frases");
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
            
            
            }
        
        
        }
        }
        
    }
    
}
