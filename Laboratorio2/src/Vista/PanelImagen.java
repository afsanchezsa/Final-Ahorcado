/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.layout.Border;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author COMPAQ
 */
public class PanelImagen extends JPanel {
   private BufferedImage imagen;
   private int numImagen;
   private ArrayList<Image>imagenes;
   
  Image imagentemporal=null;
private Image fondo;
  public PanelImagen() throws IOException{
        this.setSize(252, 252);
        
        Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
        this.fondo=CargarImagen("Fondo.jpg");
         //this.setBackground(Color.WHITE);
        this.setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
        
    this.numImagen=0;
    this.imagenes=new ArrayList<>();
    imagen=ImageIO.read(new File("ahorcado.png"));
    
    /*for(int i=0,j=0;i<4;i++){
    imagentemporal=this.imagen.getSubimage(63*i,j*63, 63, 63);//aqui tomamos 16 subimahenes de 63*63 que se hiran dibujando posteriormente en el panel
    this.imagenes.add(imagentemporal);
   
    if(i==3&&j!=3){
    i=-1;
    j++;
    }
    if(i==3&&j==3){
    break;
    }
   
    
    
    }*/
    
    int i=0,j=0;
    boolean permanecer=true;
    while(permanecer){
     imagentemporal=this.imagen.getSubimage(63*i,j*63, 63, 63);
     this.imagenes.add(imagentemporal);
            
     if(i==3&&j!=3){
     i=0;
     j++;
     }else if(i==3&&j==3){
     permanecer=false;
     }
             else{
     i++;
     }
     
    
    
    
    }
   
    this.setVisible(true);
    }
    public void paintComponent(Graphics g){
    super.paintComponent(g);
       /* System.out.println(this.imagenes.size());
    for(int  m=0,i=0,j=0;i<this.numImagen;m++,i++){
     g.drawImage(this.imagenes.get(m),63*i , j*63, this);
     
         if(i==3&&j!=3){
    i=0;
    j++;
    }
    }
   
   for(int i=0;i<16;i++){
   
   }*/
     //       g.drawImage(this.fondo,0,0, this.getHeight(),this.getWidth(), this);
       
       for(int i=0,j=0,m=0;m<numImagen;m++){
       g.drawImage(this.imagenes.get(m),i*63 , j*63, this);i++;
       if(i==4&&j!=3){//pues si i=4 entonces ya debo cambiar de fila para seguir poniendo las imagenes
       i=0;j++;
       }
       }
       
       
    }
public void agregarImagen(){
this.numImagen++;

this.repaint();
}
public int numeroIm(){
return this.numImagen;
}
public Image CargarImagen(String ruta){
ImageIcon img=new ImageIcon(ruta);
Image imagen=img.getImage();
return imagen;
}

}
