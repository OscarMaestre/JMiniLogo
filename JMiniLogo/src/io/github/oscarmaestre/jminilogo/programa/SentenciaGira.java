package io.github.oscarmaestre.jminilogo.programa;

public class SentenciaGira extends Sentencia{
    int grados;

    public SentenciaGira(int grados) {
        this.grados = grados;
    }
    @Override
    public boolean ejecutar(IContextoEjecucion contexto) {
        contexto.gira(grados);
        return true;
    }
    
    @Override
    public String toString() {
        return " gira " + this.grados + ";";
    }
}
