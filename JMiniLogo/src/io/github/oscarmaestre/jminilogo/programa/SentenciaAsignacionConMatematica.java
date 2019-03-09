package io.github.oscarmaestre.jminilogo.programa;

import io.github.oscarmaestre.jminilogo.excepciones.VariableNoExisteException;
import java.text.MessageFormat;
import java.util.HashMap;

public class SentenciaAsignacionConMatematica extends Sentencia{

    String variableDestino;
    Parametro operando1;
    String signo;
    Parametro operando2;

    public SentenciaAsignacionConMatematica(String variableDestino, Parametro operando1, String signo, Parametro operando2) {
        this.variableDestino = variableDestino;
        this.operando1 = operando1;
        this.signo = signo;
        this.operando2 = operando2;
    }

    @Override
    public boolean ejecutar(IContextoEjecucion contexto, TablaSimbolos tablaSimbolos) throws VariableNoExisteException  {        
        Integer valor1=tablaSimbolos.getValor(operando1);
        Integer valor2=tablaSimbolos.getValor(operando2);
        Integer resultado=0;
        if (signo.equals("+")){
            resultado=valor1+valor2;
        }
        if (signo.equals("-")){
            resultado=valor1-valor2;
        }
        if (signo.equals("*")){
            resultado=valor1*valor2;
        }
        if (signo.equals("/")){
            resultado=valor1/valor2;
        }
        //System.out.println(variableDestino + " toma el valor "+resultado);
        tablaSimbolos.almacenar(this.variableDestino, resultado);
        return true;
    }

    @Override
    public String toString() {
        String cad=MessageFormat.format("{0} = {1} {2} {3}", variableDestino, operando1, signo, operando2);
        return cad;
    }

    @Override
    public void ejecutarPaso(IContextoEjecucion contexto, TablaSimbolos tablaSimbolos) throws Exception {
        this.ejecutar(contexto, tablaSimbolos);
    }
}
