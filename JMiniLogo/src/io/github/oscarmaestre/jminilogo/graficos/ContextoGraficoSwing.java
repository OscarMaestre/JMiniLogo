package io.github.oscarmaestre.jminilogo.graficos;

import io.github.oscarmaestre.jminilogo.programa.IContextoEjecucion;
import java.awt.Color;
import java.awt.Graphics2D;

public class ContextoGraficoSwing implements IContextoEjecucion{
    Graphics2D contextoGrafico;
    int x, y;
    boolean lapizActivado;
    int grados;
    Color colorActivo;
    public ContextoGraficoSwing(Graphics2D contextoGrafico, int x, int y, boolean lapizActivado, int grados) {
        this.contextoGrafico = contextoGrafico;
        this.x = x;
        this.y = y;
        this.lapizActivado = lapizActivado;
        this.grados = grados;
    }
    
    
    
    @Override
    public boolean lapizSubido() {
        return (this.lapizActivado==false);
    }

    @Override
    public void subeLapiz() {
        this.lapizActivado=false;
    }

    @Override
    public void bajaLapiz() {
        this.lapizActivado=true;
    }

    @Override
    public void avanza(int pasos) {
        double radianes=this.grados*2*Math.PI/360;
        int nueva_x=x+(int) (pasos * Math.cos(radianes));
        int nueva_y=y+(int) (pasos * Math.sin(radianes));
        System.out.print("Yendo de ("+x+", "+y+")");
        System.out.print(" a  ("+nueva_x+", "+nueva_y+")");
        System.out.println("");
        if (this.lapizActivado){
            this.contextoGrafico.drawLine(x, y, nueva_x, nueva_y);
            System.out.println("Avanzando en Swing");
        }
        this.x=nueva_x;
        this.y=nueva_y;
    }

    @Override
    public void gira(int grados) {
        this.grados+=grados;
    }

    @Override
    public void cambiaColorActivo(Color color) {
        this.colorActivo=color;
        this.contextoGrafico.setColor(color);
    }
    

}
