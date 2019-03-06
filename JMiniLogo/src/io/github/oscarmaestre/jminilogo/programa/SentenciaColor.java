package io.github.oscarmaestre.jminilogo.programa;

import io.github.oscarmaestre.jminilogo.FabricaColores;
import java.awt.Color;
import java.util.HashMap;

public class SentenciaColor extends Sentencia{

    int r, g, b;
    Color color;
    public SentenciaColor(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
        color  = FabricaColores.getColor(r, g, b);
    }
    public SentenciaColor (Color color){
        this.color=color;
        this.r=color.getRed();
        this.g=color.getGreen();
        this.b=color.getBlue();
    }
    
    @Override
    public boolean ejecutar(IContextoEjecucion contexto, HashMap<String, Integer> tablaSimbolos) {
        contexto.cambiaColorActivo(this.color);
        return true;
    }

    @Override
    public String toString() {
        return "cambio de color;";
    }

}
