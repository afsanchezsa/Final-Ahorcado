/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.io.FileNotFoundException;
import java.io.IOException;
import javazoom.jl.decoder.JavaLayerException;

/**
 *
 * @author COMPAQ
 */
    public class Palabra extends ObjetoJuego {
//    private Audio audio;
    public Palabra(String cadena,String rutaaudio) throws IOException, FileNotFoundException, JavaLayerException {
        super(cadena);
    }
}
