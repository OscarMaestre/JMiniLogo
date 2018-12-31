package io.github.oscarmaestre.jminilogo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;


public class SwingGUI extends GUI implements ActionListener{
    private final String MENU_ABRIR             =   "Abrir";
    private final String MENU_GUARDAR           =   "Guardar";
    private final String MENU_GUARDAR_COMO      =   "Guardar como";
    private final String MENU_SALIR             =   "Salir";
    
    private final String MENU_CORTAR            =   "Cortar";
    private final String MENU_COPIAR            =   "Copiar";
    private final String MENU_PEGAR             =   "Pegar";
    
    private final String MENU_MOSTRAR_AYUDA     =   "Mostrar ayuda";
    private final String MENU_ACERCA_DE         =   "Acerca de";
    
    public Container contenedor;
    public JTextArea txtAreaPrograma;
    public JTextArea txtAreaMensajes;
    public JButton   btnEjecutar;
    public JButton   btnPasoAPaso;
    public JPanel    panelDibujo;
    public JFrame    ventana;
    public boolean   depurandoGUI=false;
    private void anadirBoton(String texto, int x, int y, int altura, int anchura,
            int expansion){
        JButton boton=new JButton(texto);
        GridBagConstraints gc=new GridBagConstraints();
        gc.gridx=x;
        gc.gridwidth=anchura;
        gc.gridy=y;
        gc.gridheight=altura;
        gc.fill=expansion;
        gc.insets=new Insets(15,15,15,15);
        contenedor.add(boton, gc);        
    }
    
    private void anadirTextAreaPrograma(Container contenedor){
        txtAreaPrograma=new JTextArea();
        GridBagConstraints gc=new GridBagConstraints();
        gc.gridx        = 0;
        gc.gridy        = 0;
        gc.gridheight   = 6;
        gc.gridwidth    = 3;
        gc.fill         = GridBagConstraints.BOTH;
        contenedor.add(txtAreaPrograma, gc);
    } /*Fin de anadirTextAreaPrograma*/
    
    private void anadirTextAreaMensajes(Container contenedor){
        txtAreaMensajes=new JTextArea();
        GridBagConstraints gc=new GridBagConstraints();
        gc.gridx        = 0;
        gc.gridy        = 7;
        gc.gridheight   = 3;
        gc.gridwidth    = 3;
        gc.fill         = GridBagConstraints.BOTH;
        txtAreaMensajes.setText("Aquí veras los mensajes");
        contenedor.add(txtAreaMensajes, gc);
    }
    
    private void anadirBotones(Container contenedor){
        btnEjecutar=        new JButton("Ejecutar hasta el final");
        GridBagConstraints gc=new GridBagConstraints();
        gc.gridx        = 3;
        gc.gridy        = 0;
        gc.gridheight   = 1;
        gc.gridwidth    = 1;
        gc.fill         = GridBagConstraints.BOTH;
        gc.insets       = new Insets(20,20,20,20);
        contenedor.add(btnEjecutar, gc);
        
        btnPasoAPaso    =   new JButton ("Ejecutar paso a paso");
        gc=new GridBagConstraints();
        gc.gridx        = 3;
        gc.gridy        = 1;
        gc.gridheight   = 1;
        gc.gridwidth    = 1;
        gc.fill         = GridBagConstraints.BOTH;
        gc.insets       = new Insets(20,20,20,20);
        contenedor.add(btnPasoAPaso, gc);
    }
    
    private void anadirPanelDibujo(Container contenedor){
        panelDibujo=new JPanel();
        
        panelDibujo.setPreferredSize(new Dimension(400,300));
        Border borde;
        borde=BorderFactory.createLineBorder(Color.BLACK);
        panelDibujo.setBorder(borde);
        GridBagConstraints gc=new GridBagConstraints();
        gc.gridx        = 4;
        gc.gridy        = 0;
        gc.gridheight   = 10;
        gc.gridwidth    = 6;
        gc.fill         = GridBagConstraints.BOTH;
        //gc.insets       = new Insets(20,20,20,20);
        contenedor.add(panelDibujo, gc);
    }
    public void activarDepuracionGUI(){
        this.depurandoGUI=true;
    }
    private void instalarControladoresEventos(){
        this.menuAbrir.addActionListener(this);
        this.menuAbrir.
        this.menuAbrir.setActionCommand(this.MENU_ABRIR);
        System.out.println("PPPP");
    }
    public JFrame getUI(){
        if (ventana!=null){
            return ventana;
        }
        double[] pesosColumnas={10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        double[] pesosFilas={10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        ventana=new GUI();
        if (depurandoGUI){
            GridBagCellPanel panelBordes=new GridBagCellPanel();
            ventana.setContentPane(panelBordes);
        }
        
        contenedor=ventana.getContentPane();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(500,400);
        GridBagLayout layout=new GridBagLayout();
        layout.columnWeights=pesosColumnas;
        layout.rowWeights=pesosFilas;
        
        
        contenedor.setLayout(layout);
        
        
        anadirTextAreaPrograma(contenedor);
        anadirTextAreaMensajes(contenedor);
        anadirBotones(contenedor);
        anadirPanelDibujo(contenedor);
        
        instalarControladoresEventos();
        return ventana;
    }    

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
