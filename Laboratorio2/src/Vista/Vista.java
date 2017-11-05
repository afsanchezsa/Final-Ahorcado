/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.PopupMenu;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
     public Vista() throws IOException{
      this.cuadros=new ArrayList<>();
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setSize(800,500);
            this.setLocationRelativeTo(null);
            this.menu=new ButtonGroup();
                    
            this.radios=new JRadioButton[3];
            this.radios[0]=new JRadioButton("Palabras",true);
            this.radios[0].addActionListener(controlador);
         
            
             this.radios[1]=new JRadioButton("Frases");
                this.radios[1].addActionListener(controlador);
              this.radios[2]=new JRadioButton("Textos");
              this.radios[2].addActionListener(controlador);
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
     this.botones=new JButton[26];
     this.campo=new JTextField();
     this.panelDerecho=new JPanel();
     this.panelDerecho.setBackground(Color.BLUE);
  
     this.panel=new PanelImagen();
     this.panel.agregarImagen();
   this.panel.agregarImagen();
this.panel.agregarImagen();
     
this.panel.agregarImagen();
  
    
   
    this.labelderecho.setText("Puntaje Obtenido");
    this.labellzquierdo.setText("Numero de Intentos");
  
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
        for(int i=14;i<26;i++){
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
         
       this.add(this.panel,BorderLayout.CENTER);
         this.panelIzquierdo.add(this.radios[0]);
            this.panelIzquierdo.add(this.radios[1]);
            this.panelIzquierdo.add(this.radios[2]);
            
   this.setVisible(true);
  
    
     }
     public JButton[] LlenarBotones(JButton []botones){
     for(int i=0;i<26;i++){
         JButton boton=new JButton(Character.toString((char)('A'+i)));
       //  boton.addActionListener(this.controlador);
     botones[i]=boton;
     }
     return botones;
     }
     
public void setControlador(Controlador controlador){
this.controlador=controlador;
for(JButton boton:this.botones){
boton.addActionListener(this.controlador);

}

}
public void LlenarCampos(int cantidad,JPanel panel){
for(int i=0;i<cantidad;i++){
  this.cuadros.add(new JTextField(1));
}
  for(JTextField c:this.cuadros){
  panel.add(c);
  
  }

}
}
