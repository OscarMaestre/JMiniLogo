package io.github.oscarmaestre.jminilogo.programa;

public class SentenciaBajaLapiz extends Sentencia{

    @Override
    public boolean ejecutar(IContextoEjecucion contexto) {
        contexto.bajaLapiz();
        return true;
    }
    @Override
    public String toString() {
        return " bajalapiz;";
    }

}
