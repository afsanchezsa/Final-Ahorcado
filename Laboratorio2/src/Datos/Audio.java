/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.applet.AudioClip;

/**
 *
 * @author COMPAQ
 */
public class Audio {
    private AudioClip Audio;
    public Audio(String ruta){
//    this.Audio=getAudioClip(getDocumentBase(),ruta);
    
    }
    public void playAudioClip(){
    this.Audio.play();
    
    }
}
