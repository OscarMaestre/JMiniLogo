package io.github.oscarmaestre.jminilogo.programa;

public class Parametro {
    private boolean esSimbolico;
    private String nombre;
    private Integer valor;
    
    public Parametro(boolean esSimbolico) {
        this.esSimbolico = esSimbolico;
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
