package io.github.oscarmaestre.jminilogo.programa;

import java.util.ArrayList;

public class SentenciaCompuesta extends Sentencia{
    ArrayList<Sentencia> programa=new ArrayList<Sentencia>();
    public void anadirSentencia (Sentencia s){
        programa.add(s);
    }
    @Override
    public boolean ejecutar(IContextoEjecucion contexto){
        for (Sentencia s : programa){
            s.ejecutar(contexto);
        }
        return true;
    }  
    
    @Override
    public String toString() {
        String resultado="";
        for (Sentencia s:programa){
            resultado = resultado + s.toString()+"\n";
        }
        return resultado;
    }

}
