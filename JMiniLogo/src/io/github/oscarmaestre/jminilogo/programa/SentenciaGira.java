package io.github.oscarmaestre.jminilogo.programa;

import java.util.HashMap;

public class SentenciaGira extends Sentencia{
    int grados;

    public SentenciaGira(int grados) {
        this.grados = grados;
    }
    @Override
    public boolean ejecutar(IContextoEjecucion contexto, TablaSimbolos tablaSimbolos) {
        contexto.gira(grados);
        return true;
    }
    
    @Override
    public String toString() {
        return " gira " + this.grados + ";";
    }

    @Override
    public void ejecutarPaso(IContextoEjecucion contexto, TablaSimbolos tablaSimbolos) throws Exception {
        this.ejecutar(contexto, tablaSimbolos);
    }
}
