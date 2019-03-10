package io.github.oscarmaestre.jminilogo.programa;

import io.github.oscarmaestre.jminilogo.excepciones.VariableNoExisteException;

public class SentenciaAvanza extends Sentencia{
    Parametro pasos;

    public SentenciaAvanza(Parametro pasos) {
        this.pasos = pasos;
    }
    
    @Override
    public boolean ejecutar(IContextoEjecucion contexto, TablaSimbolos tablaSimbolos) throws VariableNoExisteException {
        int numPasos=tablaSimbolos.getValor(pasos);
        contexto.avanza(numPasos);
        return true;
    }

    @Override
    public String toString() {
        return " avanza " + this.pasos + ";";
    }

    @Override
    public void ejecutarPaso(IContextoEjecucion contexto, TablaSimbolos tablaSimbolos) throws Exception {
        this.ejecutarPaso(contexto, tablaSimbolos);
    }

}
