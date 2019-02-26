package io.github.oscarmaestre.jminilogo.programa;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class SentenciaCompuesta extends Sentencia{
    ArrayList<Sentencia> programa=new ArrayList<Sentencia>();
    
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
        programa.add(s);
    }
    @Override
    public boolean ejecutar(IContextoEjecucion contexto){
        if (this.isDebug()){
            System.out.println("Ejecutando programa...");
        }
        for (Sentencia s : programa){
            if (this.isDebug()){
                System.out.println(s);
            }
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
