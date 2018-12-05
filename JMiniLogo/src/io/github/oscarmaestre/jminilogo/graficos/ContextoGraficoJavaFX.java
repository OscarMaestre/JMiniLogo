package io.github.oscarmaestre.jminilogo.graficos;

import io.github.oscarmaestre.jminilogo.programa.IContextoEjecucion;
import javafx.scene.canvas.Canvas;

public class ContextoGraficoJavaFX implements IContextoEjecucion{
    int gradosActuales=0;
    int x,y;
    boolean lapizSubido=false;
    int lapsoEntrePuntos=0;
    Canvas lienzo;

    public ContextoGraficoJavaFX(Canvas lienzo) {
        this.lienzo = lienzo;
    }
    @Override
    public boolean lapizSubido() {
        return this.lapizSubido;
    }

    @Override
    public void subeLapiz() {
        this.lapizSubido=true;
    }

    @Override
    public void bajaLapiz() {
        this.lapizSubido=false;
    }

    @Override
    public void avanza(int pasos) {
        int nueva_x=(int) (pasos * Math.cos(this.gradosActuales));
        int nueva_y=(int) (pasos * Math.sin(this.gradosActuales));
        if (!this.lapizSubido){
            this.lienzo.getGraphicsContext2D().strokeLine(x, y, nueva_x, nueva_y);
            System.out.println("Avanzando en JavaFX");
        }
        this.x=nueva_x;
        this.y=nueva_y;
    }

    @Override
    public void gira(int grados) {
        this.gradosActuales = (this.gradosActuales + grados ) % 360;
    }

}
