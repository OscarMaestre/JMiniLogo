package io.github.oscarmaestre.jminilogo.programa;

public abstract class Sentencia {
    boolean pasoAPaso;

    public boolean isPasoAPaso() {
        return pasoAPaso;
    }

    public void setPasoAPaso(boolean pasoAPaso) {
        this.pasoAPaso = pasoAPaso;
    }
    
    public abstract boolean ejecutar(IContextoEjecucion contexto);
    @Override
    public abstract String toString();
}
