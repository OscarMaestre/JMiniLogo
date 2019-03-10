package io.github.oscarmaestre.jminilogo.programa;

import io.github.oscarmaestre.jminilogo.excepciones.VariableNoExisteException;
import java.util.HashMap;

public class SentenciaGira extends Sentencia{
    Parametro grados;

    public SentenciaGira(Parametro grados) {
        this.grados = grados;
    }
    
    @Override
    public boolean ejecutar(IContextoEjecucion contexto, TablaSimbolos tablaSimbolos) throws VariableNoExisteException {
        Integer iGrados=tablaSimbolos.getValor(grados);
        contexto.gira(iGrados);
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
