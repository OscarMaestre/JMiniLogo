package io.github.oscarmaestre.jminilogo.programa;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.HashMap;
import javax.management.BadStringOperationException;

public class SentenciaCompuesta extends Sentencia{
    ArrayList<Sentencia> programa=new ArrayList<Sentencia>();
    HashMap<String, Integer> tablaSimbolos=new HashMap<>();
    protected boolean debug;

    /**
     * Get the value of debug
     *
     * @return the value of debug
     */
    public boolean isDebug() {
        return debug;
    }

    /**
     * Set the value of debug
     *
     * @param debug new value of debug
     */
    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    /**
     * Add PropertyChangeListener.
     *
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    /**
     * Remove PropertyChangeListener.
     *
     * @param listener
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    public void anadirSentencia (Sentencia s){
        //System.out.println("Anadiendo sentencia..."+s.toString());
        programa.add(s);
    }
    
    public Sentencia getUltimaSentencia(){
        int ultimaPosicion=this.programa.size();
        return this.programa.get(ultimaPosicion-1);
    }
    
    public void borrarSentencia(Sentencia s){
        this.programa.remove(s);
    }
    @Override
    public boolean ejecutar(IContextoEjecucion contexto, HashMap<String, Integer> tablaSimbolos){
        if (this.isDebug()){
            System.out.println("Ejecutando programa...");
        }
        for (Sentencia s : programa){
            if (this.isDebug()){
                System.out.println(s);
            }
            s.ejecutar(contexto, tablaSimbolos);
        }
        return true;
    }  
    
    public void asignarValor (String simbolo, Integer valor){
        this.tablaSimbolos.put(simbolo, valor);
    }
    public Integer getValor (String simbolo) throws BadStringOperationException{
        Integer valor=this.tablaSimbolos.get(simbolo);
        if (valor==null){
            throw new BadStringOperationException("No existe la variable "+simbolo);
        }
        return valor;
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
