package io.github.oscarmaestre.jminilogo.programa;

public class SentenciaAvanza extends Sentencia{
    int pasos;

    public SentenciaAvanza(int pasos) {
        this.pasos = pasos;
    }
    @Override
    public boolean ejecutar(IContextoEjecucion contexto, TablaSimbolos tablaSimbolos) {
        int numPasos;
        contexto.avanza(this.pasos);
        return true;
    }

    @Override
    public String toString() {
        return " avanza " + this.pasos + ";";
    }

}
