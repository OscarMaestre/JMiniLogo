package io.github.oscarmaestre.jminilogo.programa;

import java.util.HashMap;

public class SentenciaSubeLapiz extends Sentencia{
    
    @Override
    public String toString() {
        return " subelapiz;";
    }

    @Override
    public boolean ejecutar(IContextoEjecucion contexto, HashMap<String, Integer> tablaSimbolos) {
        contexto.subeLapiz();
        return true;
    }

}
