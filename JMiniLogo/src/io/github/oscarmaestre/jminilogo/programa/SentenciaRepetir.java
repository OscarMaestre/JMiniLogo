package io.github.oscarmaestre.jminilogo.programa;

import io.github.oscarmaestre.jminilogo.excepciones.VariableNoExisteException;
import java.util.HashMap;

public class SentenciaRepetir extends Sentencia{
    Parametro veces;
    SentenciaCompuesta cuerpoRepetir;
    
    public SentenciaRepetir(Parametro veces) {
        this.veces=veces;
    }
    public void setSentenciaCompuesta(SentenciaCompuesta cuerpo){
        this.cuerpoRepetir = cuerpo;
    }
    
    @Override
    public boolean ejecutar(IContextoEjecucion contexto, TablaSimbolos tablaSimbolos) throws VariableNoExisteException, Exception {
        int max=tablaSimbolos.getValor(veces);
        for (int i=0; i<max; i++){
            this.cuerpoRepetir.ejecutar(contexto, tablaSimbolos);
        }
        return true;
    }

    @Override
    public String toString() {
        String programa="repetir "+ veces +"{\n"+
                this.cuerpoRepetir.toString()+"\n}";
        return programa;
        
    }

    @Override
    public void ejecutarPaso(IContextoEjecucion contexto, TablaSimbolos tablaSimbolos) throws Exception {
        cuerpoRepetir.ejecutarPaso(contexto, tablaSimbolos);
    }

}
