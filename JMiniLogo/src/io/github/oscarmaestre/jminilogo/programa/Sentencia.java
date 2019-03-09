package io.github.oscarmaestre.jminilogo.programa;

import java.util.HashMap;
import java.util.Set;

public abstract class Sentencia {
    boolean pasoAPaso;
    
    
    
    public boolean isPasoAPaso() {
        return pasoAPaso;
    }

    public void setPasoAPaso(boolean pasoAPaso) {
        this.pasoAPaso = pasoAPaso;
    }
    
    
    
    public abstract boolean ejecutar(IContextoEjecucion contexto, TablaSimbolos tablaSimbolos)
            throws Exception;
    @Override
    public abstract String toString();
}
