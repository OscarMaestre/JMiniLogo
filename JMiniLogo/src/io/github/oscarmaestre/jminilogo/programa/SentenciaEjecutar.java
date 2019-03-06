package io.github.oscarmaestre.jminilogo.programa;

import java.util.ArrayList;
import java.util.HashMap;

public class SentenciaEjecutar extends Sentencia {

    SentenciaProcedimiento nombreProcedimiento;
    ArrayList<Parametro> parametros;
    public SentenciaEjecutar(SentenciaProcedimiento nombreProcedimiento) {
        this.nombreProcedimiento = nombreProcedimiento;
    }
    public void setParametros(ArrayList<Parametro> parametros){
        this.parametros=parametros;
    }
    @Override
    public boolean ejecutar(IContextoEjecucion contexto, HashMap<String, Integer> tablaSimbolos) {
        System.out.println("Ejecutando "+this.nombreProcedimiento.getNombre());
        this.nombreProcedimiento.ejecutar(contexto, tablaSimbolos);
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("ejecutar ").append(this.nombreProcedimiento.getNombre());
        sb.append(" (");
        for (Parametro p:parametros){
            sb.append(p.toString()).append(" ");
        }
        sb.append(" )");
        return sb.toString();
    }
    
}
