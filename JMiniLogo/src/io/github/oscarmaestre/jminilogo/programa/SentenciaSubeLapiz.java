package io.github.oscarmaestre.jminilogo.programa;

public class SentenciaSubeLapiz extends Sentencia{

    @Override
    public boolean ejecutar(IContextoEjecucion contexto) {
        contexto.subeLapiz();
        return true;
    }
    
    @Override
    public String toString() {
        return " subelapiz;";
    }

}
