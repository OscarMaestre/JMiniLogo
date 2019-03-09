package io.github.oscarmaestre.jminilogo.programa;

import java.util.HashMap;

public class SentenciaSubeLapiz extends Sentencia{
    
    @Override
    public String toString() {
        return " subelapiz;";
    }

    @Override
    public boolean ejecutar(IContextoEjecucion contexto, TablaSimbolos tablaSimbolos) {
        contexto.subeLapiz();
        return true;
    }

    @Override
    public void ejecutarPaso(IContextoEjecucion contexto, TablaSimbolos tablaSimbolos) throws Exception {
        this.ejecutar(contexto, tablaSimbolos);
    }

}
