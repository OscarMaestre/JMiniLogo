package io.github.oscarmaestre.jminilogo.programa;

public class SentenciaBajaLapiz extends Sentencia{

    @Override
    public boolean ejecutar(IContextoEjecucion contexto, TablaSimbolos tablaSimbolos) {
        contexto.bajaLapiz();
        return true;
    }
    @Override
    public String toString() {
        return " bajalapiz;";
    }

    @Override
    public void ejecutarPaso(IContextoEjecucion contexto, TablaSimbolos tablaSimbolos) throws Exception {
        this.ejecutar(contexto, tablaSimbolos);
    }

}
