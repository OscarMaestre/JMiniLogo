package io.github.oscarmaestre.jminilogo.programa;

import java.util.HashMap;

public abstract class Sentencia {
    boolean pasoAPaso;

    public boolean isPasoAPaso() {
        return pasoAPaso;
    }

    public void setPasoAPaso(boolean pasoAPaso) {
        this.pasoAPaso = pasoAPaso;
    }
    
    public abstract boolean ejecutar(IContextoEjecucion contexto, HashMap<String, Integer> tablaSimbolos);
    @Override
    public abstract String toString();
}
