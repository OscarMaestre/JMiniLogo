package io.github.oscarmaestre.jminilogo.programa;

import io.github.oscarmaestre.jminilogo.excepciones.VariableNoExisteException;
import java.util.HashMap;

public class SentenciaAsignacion extends Sentencia{
    protected String variable;
    protected Parametro valorDerecho;

    public SentenciaAsignacion(String variable, Parametro valorDerecho) {
        this.variable = variable;
        this.valorDerecho = valorDerecho;
    }
    
    
    @Override
    public boolean ejecutar(IContextoEjecucion contexto, TablaSimbolos tablaSimbolos) throws VariableNoExisteException{
        Integer valor=tablaSimbolos.getValor(valorDerecho);
        tablaSimbolos.almacenar(variable, valor);
        //System.out.println(variable + " toma el valor "+valor);
        return true;
    }
    
    @Override
    public String toString() {
        return this.variable+"="+this.valorDerecho.toString();
    }
}
