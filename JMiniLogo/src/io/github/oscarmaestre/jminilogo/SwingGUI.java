package io.github.oscarmaestre.jminilogo;

import io.github.oscarmaestre.jminilogo.graficos.ContextoGraficoSwing;
import io.github.oscarmaestre.jminilogo.programa.SentenciaCompuesta;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;


public class SwingGUI extends GUI implements ActionListener{
    private final String MENU_NUEVO             =   "Nuevo";
    private final String MENU_ABRIR             =   "Abrir";
    private final String MENU_GUARDAR           =   "Guardar";
    private final String MENU_GUARDAR_COMO      =   "Guardar como";
    private final String MENU_SALIR             =   "Salir";
    
    private final String MENU_CORTAR            =   "Cortar";
    private final String MENU_COPIAR            =   "Copiar";
    private final String MENU_PEGAR             =   "Pegar";
    
    private final String MENU_MOSTRAR_AYUDA     =   "Mostrar ayuda";
    private final String MENU_ACERCA_DE         =   "Acerca de";
    
    
    private final String BTN_EJECUTAR           =   "Ejecutar";
    
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
    public void instalarControladoresEventos(){
        this.menuNuevo.addActionListener(this);
        this.menuAbrir.addActionListener(this);
        this.menuGuardar.addActionListener(this);
        this.menuGuardarComo.addActionListener(this);
        this.menuSalir.addActionListener(this);
        this.btnEjecutar.addActionListener(this);
        this.btnEjecutar.setActionCommand(this.BTN_EJECUTAR);
        System.out.println(this.menuAbrir);
        System.out.println("instaladors");
    }
    public JFrame getUI(){
        
        double[] pesosColumnas={10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        double[] pesosFilas={10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        if (depurandoGUI){
            GridBagCellPanel panelBordes=new GridBagCellPanel();
            ventana.setContentPane(panelBordes);
        }
        
        contenedor=this.getContentPane();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,400);
        GridBagLayout layout=new GridBagLayout();
        layout.columnWeights=pesosColumnas;
        layout.rowWeights=pesosFilas;
        
        
        contenedor.setLayout(layout);
        
        
        anadirTextAreaPrograma(contenedor);
        anadirTextAreaMensajes(contenedor);
        anadirBotones(contenedor);
        anadirPanelDibujo(contenedor);
        instalarControladoresEventos();
        this.cargarProgramaPrueba();
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        return this;
    }    
    
    private void ejecutarPrograma(){
        
        
        Graphics2D contextoGrafico=(Graphics2D) this.panelDibujo.getGraphics();
        ContextoGraficoSwing contextoSwing;
        int x_inicial=this.panelDibujo.getWidth()/2;
        int y_inicial=this.panelDibujo.getHeight()/2;
        boolean lapizActivado=true;
        int gradosIniciales=-90;
        contextoSwing=new ContextoGraficoSwing(contextoGrafico, x_inicial, y_inicial, lapizActivado, gradosIniciales);
        String programa=this.txtAreaPrograma.getText();
        StringReader sr=new StringReader(programa);
        Lexer l=new Lexer(sr);
        Parser p=new Parser(l);
        try {
            p.parse();
            SentenciaCompuesta s=p.getPrograma();
            s.setDebug(true);
            System.out.println("Esta desactivada la ejecución en Swing");
            //s.ejecutar(contextoSwing);
            
            System.out.println("Programa ejecutado");
            System.out.println(s.toString());
        } catch (Exception ex) {
            this.txtAreaMensajes.setText(ex.toString());
        }
    }
    
    public void cargarProgramaPrueba2(){
        String programa;
        programa ="repetir 10{\n" +
            "	negro; avanza 220; gira 20;\n" +
            "	azul; avanza 220; gira 20;\n" +
            "	rojo; avanza 220; gira 20;\n" +
            "	cyan; avanza 220; gira 20;	\n" +
            "	magenta; avanza 220; gira 20;\n" +
            "	amarillo; avanza 220; gira 20;\n" +
            "	blanco; avanza 220; gira 20;	\n" +
            "};";
        this.txtAreaPrograma.setText(programa);
        
    }
    
    public void cargarProgramaPrueba(){
        String programa;
        programa="repetir 5\n{\n\tnegro; avanza 50;\n\tgira 20;\n};azul; avanza 20;gira 20; magenta; avanza 20;gira 20;avanza 20;gira 20;avanza 20;gira 20;";
        this.txtAreaPrograma.setText(programa);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando=e.getActionCommand();
        if (comando.equals(this.MENU_NUEVO)){
            System.out.println("Nuevo...");
        }
        if (comando.equals(this.MENU_ABRIR)){
            System.out.println("Abriendo");
        }
        if (comando.equals(this.MENU_GUARDAR)){
            System.out.println("Guardar...");
        }
        if (comando.equals(this.MENU_GUARDAR_COMO)){
            System.out.println("Guardar como...");
        }
        if (comando.equals(this.MENU_SALIR)){
            System.out.println("Salir...");
        }
        
        if (comando.equals(this.BTN_EJECUTAR)){
            this.txtAreaMensajes.setText("");
            System.out.println("Ejecutando todo");
            this.ejecutarPrograma();
        }
    }
}
