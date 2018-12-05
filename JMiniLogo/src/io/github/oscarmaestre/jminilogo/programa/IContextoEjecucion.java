package io.github.oscarmaestre.jminilogo.programa;

public interface IContextoEjecucion {
    public boolean lapizSubido();
    public void subeLapiz();
    public void bajaLapiz();
    public void avanza(int pasos);
    public void gira (int grados);
}
