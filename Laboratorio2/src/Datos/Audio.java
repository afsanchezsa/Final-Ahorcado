/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;

import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author COMPAQ
 */
public class Audio implements Runnable{
    private URL url = null;
    private String nombreArchivo = "";

    public Audio(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
    @Override
    public void run() {
        try {
            url = new URL("file:Audios/"+nombreArchivo+".wav");
        } catch (MalformedURLException ex) {
            Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
        }
        AudioClip ac = Applet.newAudioClip(url);
         ac.play();
    }
}
