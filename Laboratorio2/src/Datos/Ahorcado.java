/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Vista.CargarObjeto;
import Vista.CargarObjeto.Tipo;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;
import javazoom.jl.decoder.JavaLayerException;

/**
 *
 * @author COMPAQ
 */
public class Ahorcado {
    private ArrayList<Palabra>palabras;
      private ArrayList<Texto>textos;
      private ArrayList<Frase>frases;
      private String ModoJuego;
    
      private int indicePalabra,indiceFrase,indiceTexto;
      public Ahorcado() throws FileNotFoundException, IOException, JavaLayerException{
      this.palabras=new ArrayList<>();
      this.frases=new ArrayList<>();
      this.textos=new ArrayList<>();
      this.ModoJuego="Palabras";
      this.indicePalabra=0;
      this.indiceFrase=0;
      this.indiceTexto=0;
      this.Cargar();
      
      }

   

    public int getIndicePalabra() {
        return indicePalabra;
    }

    public int getIndiceFrase() {
        return indiceFrase;
    }

    public int getIndiceTexto() {
        return indiceTexto;
    }
    public void AddPalabra(Palabra palabra){
    this.palabras.add(palabra);
    }
    public void AddFrase(Frase frase){
    this.frases.add(frase);
    
    }
    public void AddTexto(Texto texto){
    this.textos.add(texto);
    }
    public void setModoJuego(String modojuego) throws FileNotFoundException, IOException, JavaLayerException{
    this.ModoJuego=modojuego;
    this.Cargar();
    
    }
    public  void Cargar() throws FileNotFoundException, IOException, JavaLayerException{
         CargarObjeto cargar;
        if(this.ModoJuego.equalsIgnoreCase("Palabras")){
            cargar=new CargarObjeto(Tipo.Palabras);
            ArrayList<String>cadenas=cargar.getCadenas();
            for(String s:cadenas){
            this.palabras.add(new Palabra(s,s+".mp3"));
            }
        }else if(this.ModoJuego.equalsIgnoreCase("Frases")){
         cargar=new CargarObjeto(Tipo.Frases);
            ArrayList<String>cadenas=cargar.getCadenas();
            for(String s:cadenas){
            this.frases.add(new Frase(s));
        
        
        }}else if(this.ModoJuego.equalsIgnoreCase("Textos")){
         cargar=new CargarObjeto(Tipo.Texto);
            ArrayList<String>cadenas=cargar.getCadenas();
            for(String s:cadenas){
            this.textos.add(new Texto(s));
    
    
    }
        }}

    public String getModoJuego() {
        return ModoJuego;
    }
    public void CambiarPalabra(){
    this.indicePalabra++;
    
    }
 public void CambiarFrase(){
    this.indiceFrase++;
    
    } 
 public void CambiarTexto(){
    this.indiceTexto++;
    
    }

    public ArrayList<Palabra> getPalabras() {
        return palabras;
    }

    public ArrayList<Texto> getTextos() {
        return textos;
    }

    public ArrayList<Frase> getFrases() {
        return frases;
    }
 

}
