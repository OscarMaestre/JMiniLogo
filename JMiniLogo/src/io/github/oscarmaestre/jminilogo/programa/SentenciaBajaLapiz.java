package io.github.oscarmaestre.jminilogo.programa;

import java.util.HashMap;

public class SentenciaBajaLapiz extends Sentencia{

    @Override
    public boolean ejecutar(IContextoEjecucion contexto, HashMap<String, Integer> tablaSimbolos) {
        contexto.bajaLapiz();
        return true;
    }
    @Override
    public String toString() {
        return " bajalapiz;";
    }

}
