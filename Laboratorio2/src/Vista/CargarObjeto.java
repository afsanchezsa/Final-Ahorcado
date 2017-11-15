/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author COMPAQ
 */
public class CargarObjeto {
   public static  enum  Tipo{
    Palabras,Frases,Texto
    }
    private Tipo tipo;
    private Scanner entrada;
    private ArrayList<String>cadenas;
    
    public CargarObjeto(Tipo tipo) throws FileNotFoundException {
        this.cadenas=new ArrayList<>();
    this.tipo=tipo;
    if(this.tipo.equals(this.tipo.Palabras)){
    this.entrada=new Scanner(new File("Objetos/Palabras.txt"));
    while(entrada.hasNext()){
    String cadena;
    cadena=entrada.next();
    this.cadenas.add(cadena);
                                                        System.out.println("La palabra es: "+this.cadenas);
    }
   entrada.close();
    
    
    
    }else if(this.tipo.equals(this.tipo.Frases)){
      this.entrada=new Scanner(new File("Objetos/Frases.txt"));
    while(entrada.hasNextLine()){
    String cadena;
    cadena=entrada.nextLine();
    this.cadenas.add(cadena);
    
    }
    entrada.close();
            
            
          
    }else if(this.tipo.equals(this.tipo.Texto)){
     this.entrada=new Scanner(new File("Objetos/Textos.txt"));
    while(entrada.hasNextLine()){
    String cadena;
    cadena=entrada.nextLine();
    this.cadenas.add(cadena);
    
    
    }
    entrada.close();
    }
    
}

    public ArrayList<String> getCadenas() {
        return cadenas;
    }
}
