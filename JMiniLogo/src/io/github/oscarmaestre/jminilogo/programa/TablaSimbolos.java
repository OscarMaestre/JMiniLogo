package io.github.oscarmaestre.jminilogo.programa;

import io.github.oscarmaestre.jminilogo.excepciones.VariableNoExisteException;
import java.util.HashMap;
import java.util.Set;

public class TablaSimbolos {
    protected HashMap<String, Integer> tabla;

    public TablaSimbolos() {
        tabla=new HashMap<>();
    }
    
    public void almacenar(String clave, Integer valor){
        tabla.put(clave, valor);
    }
    
    public Integer getValor(String clave) throws VariableNoExisteException{
        Integer valor=tabla.get(clave);
        if (valor==null){
            VariableNoExisteException e=new VariableNoExisteException(clave);
            throw e;
        }
        return valor;
    }
    
    public void imprimir(){
        Set<String> claves = tabla.keySet();
        for (String clave : claves){
            Integer valor=tabla.get(clave);
            System.out.println("\t"+clave+":"+valor);
        }
    }
    
    public Integer getValor(Parametro p) throws VariableNoExisteException{
        if (!p.isEsSimbolico()){
            return p.getValor();
        }
        String clave=p.getNombre();
        return getValor(clave);
    }
    
    
}
