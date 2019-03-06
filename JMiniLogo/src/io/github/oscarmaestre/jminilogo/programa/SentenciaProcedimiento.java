package io.github.oscarmaestre.jminilogo.programa;

import java.util.ArrayList;
import java.util.HashMap;

public class SentenciaProcedimiento extends Sentencia{
    String nombre;
    SentenciaCompuesta cuerpoProcedimiento;
    protected ArrayList<String> nombresParametros;
    public SentenciaProcedimiento(String nombre) {
        this.nombre = nombre;
        this.nombresParametros=new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setNombresParametros(ArrayList<String> lista){
        this.nombresParametros=lista;
    }
    public ArrayList<String> getNombresParametros(){
        return this.nombresParametros;
    }
    public void anadirNombreParametro(String nombre){
        this.nombresParametros.add(nombre);
    }
    
    
    
    public void setCuerpoProcedimiento(SentenciaCompuesta cuerpo){
        this.cuerpoProcedimiento = cuerpo;
    }
    
    @Override
    public boolean ejecutar(IContextoEjecucion contexto, HashMap<String, Integer> tablaSimbolos) {
        this.cuerpoProcedimiento.ejecutar(contexto, tablaSimbolos);
        return true;
    }

    @Override
    public String toString() {
        StringBuilder str;
        str = new StringBuilder();
        str.append("procedimiento " + this.nombre+System.lineSeparator());
        for (String parametro : this.nombresParametros){
            str.append("\t").append(parametro).append(System.lineSeparator());
        }
        return str.toString();
                
    }

}
