/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Datos.Ahorcado;
import Datos.Frase;
import Datos.Palabra;
import Datos.Texto;
import static Vista.CargarObjeto.Tipo.Texto;
import Vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
        //this.vista.LlenarCampos();
         try {
                this.ahorcado.setModoJuego("Palabras");
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
            
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Palabra palabra;
        Texto texto;
        Frase frase;
        String palabrastring;
        if(e.getSource() instanceof JButton){
        JButton boton=(JButton)e.getSource();
        
         if(boton.getText().equals("Siguiente")){
        
           
        if(this.ahorcado.getModoJuego().equals("Palabras")){
        palabra=this.ahorcado.getPalabras().get(this.ahorcado.getIndicePalabra());
        this.vista.LlenarCampos(palabra.getCadena().length());
        this.ahorcado.CambiarPalabra();
        }
        
           
        
        
        
        }
         
         else{
         /*(boton.getText().equalsIgnoreCase("A")){
            System.out.println("la letra es a");
            System.out.println(this.ahorcado.getPalabras().get(0).getCadena());
        */if(this.ahorcado.getModoJuego().equals("Palabras")){
        ArrayList<Integer>indiceletraencontrada=new ArrayList<>();
            palabra=this.ahorcado.getPalabras().get(this.ahorcado.getIndicePalabra()-1);
       
            palabrastring=palabra.getCadena();
        for(int i=0;i<palabrastring.length();i++){
        char letra=palabrastring.charAt(i);
        if(Character.toString(letra).equalsIgnoreCase(boton.getText())){
        indiceletraencontrada.add(i);//pone en arraylist la posicion de la letra encontrada en la palabra
              }
         
        }
        this.vista.setCamposTexto( indiceletraencontrada, boton.getText());
       if(indiceletraencontrada.size()==0){//si el tamaño del arreglo de indices de letras encontradas es cero entonces la funcion equivocacion pinta una imagen
        this.vista.Equivocacion();
            
        }
        }
         
         
         }
         }
        
                
        else if(e.getSource() instanceof JRadioButton ){
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
