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
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javazoom.jl.decoder.JavaLayerException;

/**
 *
 * @author COMPAQ
 */
public class Controlador implements ActionListener {
    private Vista vista;
    private Ahorcado ahorcado;
   
    public Controlador(Vista vista, Ahorcado ahorcado) throws IOException, JavaLayerException {
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
        String palabrastring,frasestring,textostring;
        if(e.getSource() instanceof JButton){
        JButton boton=(JButton)e.getSource();
        
         if(boton.getText().equals("Siguiente")){
        
           
        if(this.ahorcado.getModoJuego().equals("Palabras")){
        palabra=this.ahorcado.getPalabras().get(this.ahorcado.getIndicePalabra());
        this.vista.LlenarCampos(palabra.getCadena().length());
        this.ahorcado.CambiarPalabra();
        }else if(this.ahorcado.getModoJuego().equalsIgnoreCase("Frases")){
        frase=this.ahorcado.getFrases().get(this.ahorcado.getIndiceFrase());
        this.vista.LlenarCampos(frase.getCadena().length());
        this.ahorcado.CambiarFrase();
      
        }else if(this.ahorcado.getModoJuego().equals("Textos")){
        texto=this.ahorcado.getTextos().get(this.ahorcado.getIndiceTexto());
        this.vista.LlenarCampos(texto.getCadena().length());
        this.ahorcado.CambiarTexto();
        }
        
           
        
        
        
        }else if(boton.getText().equals("Escuchar")){
       // this.ahorcado.getPalabras().get(this.ahorcado.getIndicePalabra()).Escuchar();
        
        
        }
         
         else{
         /*(boton.getText().equalsIgnoreCase("A")){
            System.out.println("la letra es a");
            System.out.println(this.ahorcado.getPalabras().get(0).getCadena());
        */
         //MODO PALABRAS
         if(this.ahorcado.getModoJuego().equals("Palabras")){
        ArrayList<Integer>indiceletraencontrada=new ArrayList<>();
            palabra=this.ahorcado.getPalabras().get(this.ahorcado.getIndicePalabra()-1);//se pone -1 dado que arriba se puso la declaracion cambiarpalabra dado que esta ultima posicion del arreglo no esta ocupada pero la penultima si
       
            palabrastring=palabra.getCadena();
        for(int i=0;i<palabrastring.length();i++){
        char letra=palabrastring.charAt(i);
        if(Character.toString(letra).equalsIgnoreCase(boton.getText())){
        indiceletraencontrada.add(i);//pone en arraylist la posicion de la letra encontrada en la palabra
              }
         
        }
        this.vista.setCamposTexto( indiceletraencontrada, boton.getText());
       if(indiceletraencontrada.size()==0){//si el tamaño del arreglo de indices de letras encontradas es cero entonces la funcion equivocacion pinta una imagen
        if(this.vista.numImagen()>=16){
        this.vista.AvisoPerder();
        }
           this.vista.Equivocacion();
            
        }
        }
        //----------------------------------------------------------------------------
        //MODO FRASES
        else if(this.ahorcado.getModoJuego().equals("Frases")){
        ArrayList<Integer>indiceletraencontrada=new ArrayList<>();
        frase=this.ahorcado.getFrases().get(this.ahorcado.getIndiceFrase()-1);
        frasestring=frase.getCadena();
         for(int i=0;i<frasestring.length();i++){
        char letra=frasestring.charAt(i);
        if(Character.toString(letra).equalsIgnoreCase(boton.getText())){
        indiceletraencontrada.add(i);//pone en arraylist la posicion de la letra encontrada en la palabra
              }
         
        }
        this.vista.setCamposTexto( indiceletraencontrada, boton.getText());//llena los campos que les corresponde la letra del boton
       if(indiceletraencontrada.size()==0){//si el tamaño del arreglo de indices de letras encontradas es cero entonces la funcion equivocacion pinta una imagen
        if(this.vista.numImagen()>=16){
        this.vista.AvisoPerder();
        }
           this.vista.Equivocacion();
            
        }
        //MODO TEXTOS
        }else if(this.ahorcado.getModoJuego().equals("Textos")){
        
        ArrayList<Integer>indiceletraencontrada=new ArrayList<>();
        
        texto=this.ahorcado.getTextos().get(this.ahorcado.getIndiceTexto()-1);
        textostring=texto.getCadena();
         for(int i=0;i<textostring.length();i++){
        char letra=textostring.charAt(i);
        if(Character.toString(letra).equalsIgnoreCase(boton.getText())){
        indiceletraencontrada.add(i);//pone en arraylist la posicion de la letra encontrada en la palabra
              }
         
        }
        this.vista.setCamposTexto( indiceletraencontrada, boton.getText());//llena los campos que les corresponde la letra del boton
       if(indiceletraencontrada.size()==0){//si el tamaño del arreglo de indices de letras encontradas es cero entonces la funcion equivocacion pinta una imagen
        if(this.vista.numImagen()>=16){
        this.vista.AvisoPerder();
            
        }
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
            } catch (IOException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JavaLayerException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            } else if(radio.getText().equals("Frases")&&radio.isSelected()){
                
            try {
                this.ahorcado.setModoJuego("Frases");
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JavaLayerException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            }else if(radio.getText().equalsIgnoreCase("Textos")){
            try {
                this.ahorcado.setModoJuego("Textos");
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JavaLayerException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            }
        
        
        }
        
        
    }
    
}
