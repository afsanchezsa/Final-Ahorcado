/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.PopupMenu;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author COMPAQ
 */
public class Vista extends JFrame {
    private JButton  botones[];
     private JTextField campo;
     private PanelImagen panel;
     private JPanel panelInferiorGeneral;
     private JPanel panelInferior1;
     private JPanel panelInferior2;
     private JPanel panelDerecho;
     private JPanel panelIzquierdo;
     private JPanel panelCentral;
     private JPanel paneltextos;
     private Controlador controlador;
     private JLabel labelderecho;
     private JLabel labellzquierdo;
    private JLabel labelSuperior;
    private JPanel PanelSuperior;
    private JRadioButton []radios;
    private ButtonGroup menu;
    private ArrayList<JTextField>cuadros;
    private JButton siguiente;
    private JButton escuchar;
     public Vista() throws IOException{
      this.cuadros=new ArrayList<>();
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setSize(800,500);
            this.setLocationRelativeTo(null);
            this.menu=new ButtonGroup();
                    this.siguiente=new JButton("Siguiente");
                  this.escuchar=new JButton("Escuchar");
            this.radios=new JRadioButton[3];
            this.radios[0]=new JRadioButton("Palabras",true);
            
         
            
             this.radios[1]=new JRadioButton("Frases");
               
              this.radios[2]=new JRadioButton("Textos");
              
            this.menu.add(this.radios[0]);
            this.menu.add(this.radios[1]);
            this.menu.add(this.radios[2]);
            
            this.labelSuperior=new JLabel();
            this.labelderecho=new JLabel();
            this.labellzquierdo=new JLabel();
            
            this.panelIzquierdo=new JPanel();
            this.panelCentral=new JPanel();
            this.paneltextos=new JPanel();
            this.panelIzquierdo.setLayout(new BoxLayout(this.panelIzquierdo,BoxLayout.Y_AXIS ));
            this.PanelSuperior=new JPanel();
            this.labelSuperior.setFont(new Font("Arial",Font.BOLD,25));
            this.labelSuperior.setText("Ahorcado");
            this.PanelSuperior.add(labelSuperior);
     this.botones=new JButton[27];
     this.campo=new JTextField();
     this.panelDerecho=new JPanel();
     this.panelDerecho.setBackground(Color.BLUE);
  
     this.panel=new PanelImagen();
     
 
         
    
   
    this.labelderecho.setText("Descubre el texto oculto");
    this.labellzquierdo.setText("Seleccione el tipo");
  
    this.labellzquierdo.setBackground(Color.red);
    this.panelDerecho.add(labelderecho);
    this.panelIzquierdo.add(labellzquierdo);
    
     this.panelInferior1=new JPanel();
     this.panelInferior2=new JPanel();
     this.panelInferiorGeneral=new JPanel();
     this.panelInferiorGeneral.setLayout(new BoxLayout(this.panelInferiorGeneral,BoxLayout.Y_AXIS));
     this.panelInferior1.setLayout(new FlowLayout());
     
     this.panelInferior2.setLayout(new FlowLayout());
     this.setLayout(new BorderLayout());
     this.botones=LlenarBotones(botones);
     for(int i=0;i<13;i++){
       this.panelInferior1.add(botones[i]);
     }
        for(int i=14;i<27;i++){
       this.panelInferior2.add(botones[i]);
     }
        this.panelInferiorGeneral.add(panelInferior1);
        this.panelInferiorGeneral.add(this.panelInferior2);
        this.add(PanelSuperior,BorderLayout.NORTH);
    this.add(panelInferiorGeneral,BorderLayout.SOUTH);
       this.add(panelDerecho,BorderLayout.EAST);
       this.add(panelIzquierdo,BorderLayout.WEST);
       this.panelCentral.setLayout(new BoxLayout(this.panelCentral, BoxLayout.Y_AXIS));
       
       this.panelCentral.add(this.panel);
         
       this.add(this.panelCentral,BorderLayout.CENTER);
         this.panelIzquierdo.add(this.radios[0]);
            this.panelIzquierdo.add(this.radios[1]);
            this.panelIzquierdo.add(this.radios[2]);
            this.panelIzquierdo.add(this.siguiente);
            this.panelIzquierdo.add(this.escuchar);
           
   this.setVisible(true);
  
    
     }
     public JButton[] LlenarBotones(JButton []botones){
     for(int i=0;i<26;i++){
         JButton boton=new JButton(Character.toString((char)('A'+i)));
       //  boton.addActionListener(this.controlador);
     botones[i]=boton;
     }
     botones[26]=new JButton("N");
     return botones;
     }
     
public void setControlador(Controlador controlador){
this.controlador=controlador;
for(JButton boton:this.botones){
boton.addActionListener(this.controlador);

}
this.siguiente.addActionListener(this.controlador);
this.radios[0].addActionListener(controlador);
 this.radios[1].addActionListener(controlador);
 this.radios[2].addActionListener(controlador);
 this.escuchar.addActionListener(controlador);
}
public void LlenarCampos(int cantidad){
this.cuadros.clear();
/*int numeroComponente=this.paneltextos.getComponentCount();
for(int i=0;i<numeroComponente;i++){
this.panelCentral.remove(i);
}*/
this.panelCentral.remove(this.paneltextos);
this.paneltextos=null;

this.paneltextos=new JPanel();
    for(int i=0;i<cantidad;i++){
  this.cuadros.add(new JTextField(1));
  
}
  for(JTextField c:this.cuadros){
  this.paneltextos.add(c);
  
  }
  this.panelCentral.add(this.paneltextos);
     
  this.setVisible(false);
  this.setVisible(true);
}
public void setCamposTexto(ArrayList<Integer>indices,String letra){
int numerocuadrostexto=this.cuadros.size();
/*this.cuadros.clear();
this.panelCentral.remove(this.paneltextos);
this.paneltextos=null;
this.paneltextos=new JPanel();
for(int i=0;i<numerocuadrostexto;i++){

}*/
for(Integer i:indices){
JTextField campo=(JTextField)this.paneltextos.getComponent(i);

campo.setText(letra);

}


}
public void Equivocacion(){
this.panel.agregarImagen();


}
public int numImagen(){
return this.panel.numeroIm();

}
public void AvisoPerder(){
JOptionPane.showMessageDialog(this, "PERDISTE");
}
}
