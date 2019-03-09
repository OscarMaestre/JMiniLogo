package io.github.oscarmaestre.jminilogo.programa;

import java.util.HashMap;

public class SentenciaAsignacionSuma extends SentenciaAsignacion{

    public SentenciaAsignacionSuma(String variable, Parametro valorDerecho) {
        super(variable, valorDerecho);
    }

    @Override
    public boolean ejecutar(IContextoEjecucion contexto, HashMap<String, Integer> tablaSimbolos) throws Exception {
        return true;
    }

}
