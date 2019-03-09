package io.github.oscarmaestre.jminilogo.programa;

import io.github.oscarmaestre.jminilogo.excepciones.VariableNoExisteException;
import java.util.HashMap;

public class SentenciaGiraConVariable extends Sentencia{
    String nombreVariable;

    public SentenciaGiraConVariable(String nombreVariable) {
        this.nombreVariable = nombreVariable;
    }
    
    @Override
    public boolean ejecutar(IContextoEjecucion contexto, HashMap<String, Integer> tablaSimbolos) throws VariableNoExisteException {
        Integer pasos=tablaSimbolos.get(this.nombreVariable);
        
        if (pasos==null){
            VariableNoExisteException e= new VariableNoExisteException(this.nombreVariable);
            throw e;
        }
        contexto.gira(pasos);
        return true;
    }

    @Override
    public String toString() {
        return "avanza " + this.nombreVariable;
    }
}
