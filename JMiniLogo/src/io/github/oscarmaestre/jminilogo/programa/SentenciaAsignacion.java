package io.github.oscarmaestre.jminilogo.programa;

import java.util.HashMap;

public class SentenciaAsignacion extends Sentencia{
    protected String variable;
    protected Parametro valorDerecho;

    public SentenciaAsignacion(String variable, Parametro valorDerecho) {
        this.variable = variable;
        this.valorDerecho = valorDerecho;
    }
    
    
    @Override
    public boolean ejecutar(IContextoEjecucion contexto, HashMap<String, Integer> tablaSimbolos) throws Exception{
        Integer valor;
        if (this.valorDerecho.isEsSimbolico()){
            String nombreVariable=this.valorDerecho.getNombre();
            valor=tablaSimbolos.get(nombreVariable);
        } else{
            valor=this.valorDerecho.getValor();
        }
        tablaSimbolos.put(variable, valor);
        return true;
    }
    
    @Override
    public String toString() {
        return this.variable+"="+this.valorDerecho.toString();
    }
}
