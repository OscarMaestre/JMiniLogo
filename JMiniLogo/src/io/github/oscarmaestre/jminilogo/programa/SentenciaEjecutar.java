package io.github.oscarmaestre.jminilogo.programa;

import io.github.oscarmaestre.jminilogo.excepciones.CantidadParametrosInvalidaException;
import io.github.oscarmaestre.jminilogo.excepciones.VariableNoExisteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SentenciaEjecutar extends Sentencia {

    SentenciaProcedimiento procedimiento;
    ArrayList<Parametro> parametros;
    public SentenciaEjecutar(SentenciaProcedimiento nombreProcedimiento) {
        this.procedimiento = nombreProcedimiento;
    }
    public void setParametros(ArrayList<Parametro> parametros){
        this.parametros=parametros;
    }
    
    public TablaSimbolos asignarParametros(TablaSimbolos tablaSimbolos) throws CantidadParametrosInvalidaException, VariableNoExisteException{
        
        ArrayList<String> parametrosDeclarados=this.procedimiento.nombresParametros;
        int numParametrosDeclarados=parametrosDeclarados.size();
        int numParametrosPasados   = parametros.size();
        String nombreProcedimiento = this.procedimiento.getNombre();
        
        if (numParametrosPasados!=numParametrosDeclarados){
            throw new CantidadParametrosInvalidaException(numParametrosDeclarados, numParametrosPasados, nombreProcedimiento);
        }
        
        ArrayList<Integer> valoresParaPasar=new ArrayList<>();
        for (Parametro p : parametros){
            if (p.isEsSimbolico()){
                Integer valorVariable=tablaSimbolos.getValor(p.getNombre());
                valoresParaPasar.add(valorVariable);
            } else {
                valoresParaPasar.add(p.getValor());
            }
        }
        
        TablaSimbolos tablaSimbolosProcedimiento=new TablaSimbolos();
        /* Una vez que tenemos todos los valores podemos fabricar una nueva tabla de
        simbolos para el procedimiento */
        
        for (int i=0; i<parametros.size(); i++){
            String nombreParametro  =   parametrosDeclarados.get(i);
            Integer valor           =   valoresParaPasar.get(i);
            tablaSimbolosProcedimiento.almacenar(nombreParametro, valor);
        }
        return tablaSimbolosProcedimiento;
    }
    
  
    
    @Override
    public boolean ejecutar(IContextoEjecucion contexto, TablaSimbolos tablaSimbolos) throws Exception {
        try {
            TablaSimbolos nuevaTabla=this.asignarParametros(tablaSimbolos);
            System.out.println("----Tabla de simbolos para el proc "+this.procedimiento.getNombre()+"-----");
            nuevaTabla.imprimir();
            System.out.println("----Fin de simbolos para el proc-----");
            System.out.println("Ejecutando "+this.procedimiento.getNombre());
            this.procedimiento.ejecutar(contexto, nuevaTabla);
            return true;
        } catch (CantidadParametrosInvalidaException ex) {
            Logger.getLogger(SentenciaEjecutar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("ejecutar ").append(this.procedimiento.getNombre());
        sb.append(" (");
        for (Parametro p:parametros){
            sb.append(p.toString()).append(" ");
        }
        sb.append(" )");
        return sb.toString();
    }
    
}
