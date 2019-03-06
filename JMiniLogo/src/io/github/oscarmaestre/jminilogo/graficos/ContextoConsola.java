package io.github.oscarmaestre.jminilogo.graficos;

import io.github.oscarmaestre.jminilogo.programa.IContextoEjecucion;
import java.awt.Color;

public class ContextoConsola implements IContextoEjecucion{

    @Override
    public boolean lapizSubido() {
        System.out.println("Comprobando si el lapiz está subido");
        return true;
    }

    @Override
    public void subeLapiz() {
        System.out.println("Subimos lapiz");
    }

    @Override
    public void bajaLapiz() {
        System.out.println("Bajamos lapiz");
    }

    @Override
    public void avanza(int pasos) {
        System.out.println("Avanzamos "+pasos);
    }

    @Override
    public void gira(int grados) {
        System.out.println("Giramos "+grados);
    }

    @Override
    public void cambiaColorActivo(Color color) {
        System.out.println("Color nuevo:"+color.toString());
    }

}
