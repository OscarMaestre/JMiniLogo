package io.github.oscarmaestre.jminilogo.programa;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;



public class SentenciaCompuesta extends Sentencia{
    ArrayList<Sentencia> programa=new ArrayList<Sentencia>();
    TablaSimbolos tablaSimbolos=new TablaSimbolos();
    Sentencia     proximaSentenciaAEjecutar=null;
    int contadorDePrograma=0;
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
    public boolean iniciarEjecucion(IContextoEjecucion contexto) throws Exception{
        return this.ejecutar(contexto, this.tablaSimbolos);
    }
    public Sentencia iniciarEjecucionPasoAPaso(IContextoEjecucion contexto) throws Exception{
        this.contadorDePrograma=0;
        this.proximaSentenciaAEjecutar=this.programa.get(this.contadorDePrograma);
        return this.proximaSentenciaAEjecutar;
    }

    public TablaSimbolos getTablaSimbolos() {
        return tablaSimbolos;
    }
    
    
    @Override
    public boolean ejecutar(IContextoEjecucion contexto, TablaSimbolos tablaSimbolos) throws Exception{
        
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
    
    
    
    
    @Override
    public String toString() {
        String resultado="";
        for (Sentencia s:programa){
            resultado = resultado + s.toString()+"\n";
        }
        return resultado;
    }
    public Sentencia getSiguienteSentenciaParaEjecutar(){
        System.out.println("Recuperando instruccion "+contadorDePrograma);
        if (contadorDePrograma>=this.programa.size()){
            return null;
        }
        Sentencia s= this.programa.get(contadorDePrograma);
        return s;
    }
    @Override
    public void ejecutarPaso(IContextoEjecucion contexto, TablaSimbolos tablaSimbolos) throws Exception {
        
        Sentencia siguiente=this.getSiguienteSentenciaParaEjecutar();
        siguiente.ejecutarPaso(contexto, tablaSimbolos);
        this.contadorDePrograma++;
    }

}
