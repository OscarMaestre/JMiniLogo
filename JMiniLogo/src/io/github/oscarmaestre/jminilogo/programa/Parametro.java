package io.github.oscarmaestre.jminilogo.programa;

import java.util.HashMap;

public class Parametro {
    private boolean esSimbolico;
    private String nombre;
    private Integer valor;
    private boolean negativo;
    public Parametro(boolean esSimbolico) {
        this.esSimbolico = esSimbolico;
        this.negativo=false;
    }

    public boolean isNegativo() {
        return negativo;
    }

    public void setNegativo(boolean negativo) {
        this.negativo = negativo;
    }
    

    public boolean isEsSimbolico() {
        return esSimbolico;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setValor(Integer i){
        this.valor=i;
    }
    
    public void setValor(String cad){
        Integer i=Integer.parseInt(cad);
        this.valor=i;
    }
    
    
    
    
    public String toString(){
        if (this.esSimbolico){
            return this.getNombre();
        } else {
            return this.valor.toString();
        }
    }
    Integer getValor() {
        return this.valor;
    }
    
    
    
}
