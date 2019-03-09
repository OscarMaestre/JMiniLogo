package io.github.oscarmaestre.jminilogo;

import io.github.oscarmaestre.jminilogo.programa.Parametro;
import io.github.oscarmaestre.jminilogo.programa.Sentencia;
import io.github.oscarmaestre.jminilogo.programa.SentenciaAsignacion;
import io.github.oscarmaestre.jminilogo.programa.SentenciaAsignacionConMatematica;
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
    
    private String    signo;
    private Parametro parametro1;
    private Parametro parametro2;
    private String  variableDestino;

    public AntoParser(Scanner scanner, SymbolFactory sf) {
        super(scanner, sf);
    }
    
    
    public AntoParser(Lexer scanner){
        super(scanner);
        this.s=scanner;
        programa=new SentenciaCompuesta();
        procedimientos=new HashMap<>();
    }

    /**
     *
     * @param nombre
     * @return
     */
    public SentenciaProcedimiento getProcedimiento(String nombre){
        return procedimientos.get(nombre);
    }
    @Override
    public void crearNuevaListaParametros(){
        this.listaParametros=new ArrayList<>();
    }
    @Override
    public void anadirParametro(String parametro){
        this.listaParametros.add(parametro);
    }
    
    @Override
    public void anotarParam1(Parametro p ){
        this.parametro1=p;
        //System.out.println("Anotado parametro 1");
    }
    @Override
    public void anotarParam2(Parametro p ){
        this.parametro2=p;
        //System.out.println("Anotado parametro 2");
    }
    


    @Override
    public void crearNuevaListaParametrosPasados(){
        this.parametrosPasados=new ArrayList<>();
    }
    @Override
    public void anadirParametroPasado(Parametro parametro){
        this.parametrosPasados.add(parametro);
    }
    
    
    @Override
    public void anadirSentenciaSubeLapiz(){
        Sentencia sentencia=new SentenciaSubeLapiz();
        programa.anadirSentencia ( sentencia );
    }
    @Override
    public void anadirSentenciaBajaLapiz(){
        Sentencia sentencia=new SentenciaBajaLapiz();
        programa.anadirSentencia ( sentencia );
    }
    @Override
    public void anadirSentenciaAvanza(String puntos){
        //System.out.println("Anadiendo avance:"+puntos.toString());
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
    
    @Override
    public void anadirSentenciaGira(String puntos){
        //System.out.println("Anadiendo giro:"+puntos.toString());
        Sentencia sentencia=new SentenciaGira(new Integer(puntos));
        programa.anadirSentencia ( sentencia );
    }
    @Override
    public void anadirSentenciaRepetir(String veces){
        SentenciaRepetir sentenciaRepetir=new SentenciaRepetir(Integer.parseInt(veces));
        programa.anadirSentencia(sentenciaRepetir);
        pila.push ( programa );
        programa=new SentenciaCompuesta();
    }
    
    @Override
    public void anadirSentenciaProcedimiento(SentenciaProcedimiento sentenciaProcedimiento){
        this.procedimientos.put(sentenciaProcedimiento.getNombre(), sentenciaProcedimiento);
        
        pila.push ( programa );
        programa=sentenciaProcedimiento;
    }
    @Override
    public void terminarSentenciaProcedimiento(){
        SentenciaCompuesta programaAnterior=pila.pop();
        /*SentenciaProcedimiento sentenciaProcedimiento=(SentenciaProcedimiento)
                    programaAnterior.getUltimaSentencia();*/

        //sentenciaProcedimiento.setCuerpoProcedimiento( programa );
        this.programa = programaAnterior;
    }

    @Override
    public void anadirSentenciaEjecutar(SentenciaEjecutar s){
        s.setParametros (this.parametrosPasados);
        programa.anadirSentencia(s);
    }

    @Override
    public void anadirSentenciaColor(Color color){
        SentenciaColor sentenciaColor = new SentenciaColor(color);
        programa.anadirSentencia(sentenciaColor);
    }
    @Override
    public void terminarSentenciaRepetir(){
        SentenciaCompuesta cuerpoRepetir = programa;
        SentenciaCompuesta programaAnterior=pila.pop();
        SentenciaRepetir sentenciaRepetir=(SentenciaRepetir)programaAnterior.getUltimaSentencia();

        sentenciaRepetir.setSentenciaCompuesta( cuerpoRepetir );
        this.programa = programaAnterior;
    }

    @Override
    public ArrayList<String> getListaParametros() {
        return listaParametros;
    }
   
    @Override
    public SentenciaCompuesta getPrograma(){
        return programa;
    }

    @Override
    public void anotarSigno(String signo) {
        this.signo=signo;
        //System.out.println("anotado signo "+signo);
    }

    @Override
    public void anotarVariableResultado(String variable) {
        this.variableDestino=variable;
        this.parametro1=null;
        this.parametro2=null;
        this.signo=null;
    }

    @Override
    public void cerrarAsignacion() throws Exception {
        System.out.println("Cerrando..");
        System.out.println("\tVar destino:"+this.variableDestino);
        System.out.println("\tParam 1:"+this.parametro1);
        System.out.println("\tSigno:  "+this.signo);
        System.out.println("\tParam 2:"+this.parametro2);
        
        if ((this.signo==null) && (this.parametro2==null)){
            SentenciaAsignacion s=new SentenciaAsignacion(this.variableDestino, this.parametro1);
            this.programa.anadirSentencia(s);
            return ;
        }
        if ((this.signo!=null) && (this.parametro2!=null)){
            SentenciaAsignacionConMatematica s;
            s=new SentenciaAsignacionConMatematica(
                    this.variableDestino, this.parametro1, this.signo, this.parametro2);
            this.programa.anadirSentencia(s);
            return ;
        }
        throw new Exception();
    }

}
   
