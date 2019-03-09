package io.github.oscarmaestre.jminilogo.programa;

import io.github.oscarmaestre.jminilogo.excepciones.VariableNoExisteException;
import java.util.HashMap;

public class SentenciaAvanzaConVariable extends Sentencia{
    String nombreVariable;

    public SentenciaAvanzaConVariable(String nombreVariable) {
        this.nombreVariable = nombreVariable;
    }
    
    @Override
    public boolean ejecutar(IContextoEjecucion contexto, HashMap<String, Integer> tablaSimbolos) throws VariableNoExisteException {
        Integer pasos=tablaSimbolos.get(this.nombreVariable);
        System.out.println("Acceso a variable: "+this.nombreVariable+" valor "+pasos);
        if (pasos==null){
            VariableNoExisteException e= new VariableNoExisteException(this.nombreVariable);
            throw e;
        }
        contexto.avanza(pasos);
        return true;
    }

    @Override
    public String toString() {
        return "avanza " + this.nombreVariable;
    }
    
}
