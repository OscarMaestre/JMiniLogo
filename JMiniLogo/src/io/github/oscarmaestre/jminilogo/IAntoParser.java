/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.oscarmaestre.jminilogo;

import io.github.oscarmaestre.jminilogo.programa.Parametro;
import io.github.oscarmaestre.jminilogo.programa.Sentencia;
import io.github.oscarmaestre.jminilogo.programa.SentenciaAvanza;
import io.github.oscarmaestre.jminilogo.programa.SentenciaAvanzaConVariable;
import io.github.oscarmaestre.jminilogo.programa.SentenciaBajaLapiz;
import io.github.oscarmaestre.jminilogo.programa.SentenciaColor;
import io.github.oscarmaestre.jminilogo.programa.SentenciaCompuesta;
import io.github.oscarmaestre.jminilogo.programa.SentenciaEjecutar;
import io.github.oscarmaestre.jminilogo.programa.SentenciaGira;
import io.github.oscarmaestre.jminilogo.programa.SentenciaGiraConVariable;
import io.github.oscarmaestre.jminilogo.programa.SentenciaProcedimiento;
import io.github.oscarmaestre.jminilogo.programa.SentenciaRepetir;
import io.github.oscarmaestre.jminilogo.programa.SentenciaSubeLapiz;
import java.awt.Color;
import java.util.ArrayList;
import javax.management.BadStringOperationException;

/**
 *
 * @author usuario
 */
interface IAntoParser {
    public abstract SentenciaProcedimiento getProcedimiento(String nombre);
    
    public abstract void crearNuevaListaParametros();
    
    public abstract void anadirParametro(String parametro);
    
    public abstract void anotarVariableResultado(String variable);
    
    public abstract void anotarParam1(Parametro p );
    
    public abstract void anotarParam2(Parametro p );
    
    public abstract String sumar(Object o1, Object o2);

    public abstract void crearNuevaListaParametrosPasados();
    
    public abstract void anadirParametroPasado(Parametro parametro);
    
    public abstract Integer getValor(String simbolo) throws BadStringOperationException;
    
    public abstract void setValor(String simbolo, Integer valor);
    
    public abstract void setValor(String simbolo, String valor);
    
    public abstract void setValor(String simbolo, Object valor);
    
    public abstract void anadirSentenciaSubeLapiz();
    
    public abstract void anadirSentenciaBajaLapiz();
    
    public abstract void anadirSentenciaAvanza(String puntos);
    
    public abstract void anadirSentenciaAvanzaConVariable(String nombreVariable);
    
    public abstract void anadirSentenciaGiraConVariable(String nombreVariable);
    
    public abstract void anadirSentenciaGira(String puntos);
    
    public abstract void anadirSentenciaRepetir(String veces);
    
    public abstract void anadirSentenciaProcedimiento(SentenciaProcedimiento sentenciaProcedimiento);
    
    public abstract void terminarSentenciaProcedimiento();

    public abstract void anadirSentenciaEjecutar(SentenciaEjecutar s);

    public abstract void anadirSentenciaColor(Color color);
    
    public abstract void terminarSentenciaRepetir();

    public abstract ArrayList<String> getListaParametros() ;
   
    public abstract SentenciaCompuesta getPrograma();
}
