package io.github.oscarmaestre.jminilogo.programa;

public class SentenciaProcedimiento extends Sentencia{
    String nombre;
    SentenciaCompuesta cuerpoProcedimiento;
    public SentenciaProcedimiento(String nombre) {
        this.nombre = nombre;
    }

    public void setCuerpoProcedimiento(SentenciaCompuesta cuerpo){
        this.cuerpoProcedimiento = cuerpo;
    }
    
    @Override
    public boolean ejecutar(IContextoEjecucion contexto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
