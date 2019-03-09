package io.github.oscarmaestre.jminilogo;

import io.github.oscarmaestre.jminilogo.programa.Parametro;
import io.github.oscarmaestre.jminilogo.programa.Sentencia;
import io.github.oscarmaestre.jminilogo.programa.SentenciaAsignacion;
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
import java.util.HashMap;
import java.util.Stack;
import java_cup.runtime.Scanner;
import java_cup.runtime.SymbolFactory;
import javax.management.BadStringOperationException;

public class AntoParser extends Parser  {
    Lexer s;
    SentenciaCompuesta programa;
    Stack<SentenciaCompuesta> pila=new Stack<SentenciaCompuesta>();
    HashMap<String, SentenciaProcedimiento> procedimientos;
    ArrayList<String> listaParametros;
    ArrayList<Parametro> parametrosPasados;
    private String nombreVariableResultado;
    private Parametro parametro1;
    private Parametro parametro2;

    public AntoParser(Scanner scanner, SymbolFactory sf) {
        super(scanner, sf);
    }
    
    
    public AntoParser(Lexer scanner){
        super(scanner);
        this.s=scanner;
        programa=new SentenciaCompuesta();
        procedimientos=new HashMap<>();
    }
    public SentenciaProcedimiento getProcedimiento(String nombre){
        return procedimientos.get(nombre);
    }
    public void crearNuevaListaParametros(){
        this.listaParametros=new ArrayList<>();
    }
    public void anadirParametro(String parametro){
        this.listaParametros.add(parametro);
    }
    public void anotarVariableResultado(String variable){
        this.nombreVariableResultado=variable;
    }
    public void anotarParam1(Parametro p ){
        this.parametro1=p;
    }
    public void anotarParam2(Parametro p ){
        this.parametro2=p;
    }
    
    public String sumar(Object o1, Object o2){
        String n1=(String) o1;
        String n2=(String) o2;
        int num1 = Integer.parseInt(n1);
        int num2 = Integer.parseInt(n2);
        Integer resultado = num1 + num2;
        return resultado.toString();
    }

    public void crearNuevaListaParametrosPasados(){
        this.parametrosPasados=new ArrayList<>();
    }
    public void anadirParametroPasado(Parametro parametro){
        this.parametrosPasados.add(parametro);
    }
    
    public Integer getValor(String simbolo) throws BadStringOperationException{
        return programa.getValor(simbolo);
    }
    public void setValor(String simbolo, Integer valor){
        this.programa.asignarValor(simbolo, valor);
    }
    public void setValor(String simbolo, String valor){
        Integer iValor=Integer.parseInt(valor);
        this.programa.asignarValor(simbolo, iValor);
    }
    public void setValor(String simbolo, Object valor){
        String strValor=valor.toString();
        Integer iValor=Integer.parseInt(strValor);
        this.programa.asignarValor(simbolo, iValor);
    }

    
    public void anadirSentenciaSubeLapiz(){
        Sentencia sentencia=new SentenciaSubeLapiz();
        programa.anadirSentencia ( sentencia );
    }
    public void anadirSentenciaBajaLapiz(){
        Sentencia sentencia=new SentenciaBajaLapiz();
        programa.anadirSentencia ( sentencia );
    }
    public void anadirSentenciaAvanza(String puntos){
        System.out.println("Anadiendo avance:"+puntos.toString());
        Sentencia sentencia=new SentenciaAvanza(new Integer(puntos));
        programa.anadirSentencia ( sentencia );
    }
    public void anadirSentenciaAvanzaConVariable(String nombreVariable){
        SentenciaAvanzaConVariable sentencia=
                new SentenciaAvanzaConVariable(nombreVariable);
        programa.anadirSentencia(sentencia);   
    }
    public void anadirSentenciaGiraConVariable(String nombreVariable){
        SentenciaGiraConVariable sentencia=
                new SentenciaGiraConVariable(nombreVariable);
        programa.anadirSentencia(sentencia);   
    }
    
    public void anadirSentenciaGira(String puntos){
        System.out.println("Anadiendo giro:"+puntos.toString());
        Sentencia sentencia=new SentenciaGira(new Integer(puntos));
        programa.anadirSentencia ( sentencia );
    }
    public void anadirSentenciaRepetir(String veces){
        SentenciaRepetir sentenciaRepetir=new SentenciaRepetir(Integer.parseInt(veces));
        programa.anadirSentencia(sentenciaRepetir);
        pila.push ( programa );
        programa=new SentenciaCompuesta();
    }
    
    public void anadirSentenciaProcedimiento(SentenciaProcedimiento sentenciaProcedimiento){
        this.procedimientos.put(sentenciaProcedimiento.getNombre(), sentenciaProcedimiento);
        
        pila.push ( programa );
        programa=sentenciaProcedimiento;
    }
    public void terminarSentenciaProcedimiento(){
        SentenciaCompuesta programaAnterior=pila.pop();
        /*SentenciaProcedimiento sentenciaProcedimiento=(SentenciaProcedimiento)
                    programaAnterior.getUltimaSentencia();*/

        //sentenciaProcedimiento.setCuerpoProcedimiento( programa );
        this.programa = programaAnterior;
    }

    public void anadirSentenciaEjecutar(SentenciaEjecutar s){
        s.setParametros (this.parametrosPasados);
        programa.anadirSentencia(s);
    }

    public void anadirSentenciaColor(Color color){
        SentenciaColor sentenciaColor = new SentenciaColor(color);
        programa.anadirSentencia(sentenciaColor);
    }
    public void terminarSentenciaRepetir(){
        SentenciaCompuesta cuerpoRepetir = programa;
        SentenciaCompuesta programaAnterior=pila.pop();
        SentenciaRepetir sentenciaRepetir=(SentenciaRepetir)programaAnterior.getUltimaSentencia();

        sentenciaRepetir.setSentenciaCompuesta( cuerpoRepetir );
        this.programa = programaAnterior;
    }

    public ArrayList<String> getListaParametros() {
        return listaParametros;
    }
   
    public SentenciaCompuesta getPrograma(){
        return programa;
    }

    @Override
    public void anadirSentenciaAsignacionSimple(String variable, String entero) {
        boolean esSimbolico=false;
        Parametro p=new Parametro(esSimbolico);
        p.setValor(entero);
        SentenciaAsignacion asignacion=new SentenciaAsignacion(variable, p);
        this.programa.anadirSentencia(asignacion);
    }

    @Override
    public void anadirSentenciaAsignacionConVariable(String variableIzq, String variableDer) {
        boolean esSimbolico=true;
        Parametro p=new Parametro(esSimbolico);
        p.setNombre(variableDer);
        SentenciaAsignacion asignacion=new SentenciaAsignacion(variableIzq, p);
        this.programa.anadirSentencia(asignacion);
    }


    
}
