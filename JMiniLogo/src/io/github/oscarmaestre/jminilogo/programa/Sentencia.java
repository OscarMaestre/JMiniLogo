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
    
    public void imprimirTablaSimbolos(HashMap<String, Integer> tablaSimbolos){
        Set<String> claves = tablaSimbolos.keySet();
        for (String clave : claves){
            Integer valor=tablaSimbolos.get(clave);
            System.out.println("\t"+clave+":"+valor);
        }
    }
    
    public abstract boolean ejecutar(IContextoEjecucion contexto, HashMap<String, Integer> tablaSimbolos)
            throws Exception;
    @Override
    public abstract String toString();
}
