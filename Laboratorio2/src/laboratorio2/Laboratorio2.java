/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio2;

import Controlador.Controlador;
import Datos.Ahorcado;
import Vista.Vista;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author COMPAQ
 */
public class Laboratorio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
      Ahorcado ahorcado=null;
        try {
            ahorcado = new Ahorcado();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            ahorcado.Cargar();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
      Vista vista=null;
        try {
      

            vista=new Vista();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
      Controlador controlador=new Controlador(vista,ahorcado);
    vista.setControlador(controlador);
    }
   
    
    
    
}
