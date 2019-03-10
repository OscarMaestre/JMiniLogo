package io.github.oscarmaestre.jminilogo;
import java_cup.runtime.*;
import java.util.Stack;
import java.awt.Color;
import io.github.oscarmaestre.jminilogo.programa.*;
import javax.management.BadStringOperationException;
import java.util.HashMap;
import java.util.ArrayList;
parser code {:
    Lexer s;
    public Parser(Lexer scanner){
        this.s=scanner;
    }
    public abstract SentenciaProcedimiento getProcedimiento(String nombre);
    
    public abstract void crearNuevaListaParametros();
    
    public abstract void anadirParametro(String parametro);

    public abstract void crearNuevaListaParametrosPasados();
    
    public abstract void anadirParametroPasado(Parametro parametro);
   
    public abstract void anadirSentenciaSubeLapiz();
    
    public abstract void anadirSentenciaBajaLapiz();
    
    public abstract void anadirSentenciaAvanza(Parametro puntos);
    
    public abstract void anadirSentenciaGira(Parametro puntos);
    
    public abstract void anadirSentenciaRepetir(Parametro veces);
    
    public abstract void anadirSentenciaProcedimiento(SentenciaProcedimiento sentenciaProcedimiento);
    
    public abstract void terminarSentenciaProcedimiento();

    public abstract void anadirSentenciaEjecutar(SentenciaEjecutar s);

    public abstract void anadirSentenciaColor(Color color);
    
    public abstract void terminarSentenciaRepetir();

    public abstract ArrayList<String> getListaParametros() ;
   
    public abstract SentenciaCompuesta getPrograma();    

    public abstract void anotarVariableResultado(String variable);
    
    public abstract void anotarParam1(Parametro p );
    
    public abstract void anotarParam2(Parametro p );
    
    public abstract void anotarSigno(String signo);

    public abstract void cerrarAsignacion() throws Exception;
    
:}


init with {: s.init(); :};
scan with {: return s.next_token(); :};


terminal            ROJO, NEGRO, AZUL, VERDE, CYAN, MAGENTA, AMARILLO, BLANCO;
terminal            String IDENTIFICADOR;
terminal            PARENIZQ, PARENDER;
terminal            String SUMA;
terminal            String RESTA;
terminal            String MULTIPLICACION;
terminal            String DIVISION;
terminal            IGUAL;
terminal            PROCEDIMIENTO, COMA, EJECUTAR;
terminal            SUBELAPIZ, BAJALAPIZ, AVANZA, GIRA, PUNTOCOMA, ESPACIO, REPETIR, LLAVEABIERTA, LLAVECERRADA;
terminal            String ENTERO; 

non terminal            lista_sentencias;
non terminal            subir, bajar, avanzar, girar, repetir, color, procedimiento;
non terminal            sentencia, final_sentencia, lista_parametros;
non terminal            asignacion, expresion;
non terminal Parametro  operando;
non terminal String     signo;
non terminal            valores_pasados_a_procedimiento, parametro, ejecutar_proc, lista_valores_pasados ;

lista_sentencias ::= sentencia final_sentencia | sentencia final_sentencia lista_sentencias ;

final_sentencia  ::= PUNTOCOMA | ESPACIO PUNTOCOMA | ESPACIO PUNTOCOMA ESPACIO ;

sentencia ::= subir  | bajar | avanzar | girar | repetir | color | procedimiento | asignacion | ejecutar_proc;


color ::= ROJO {:  this.parser.anadirSentenciaColor(
                FabricaColores.getColorSpectrum(FabricaColores.ZX_SPECTRUM_RED)
                ); :}|  
          NEGRO {:  this.parser.anadirSentenciaColor(
                FabricaColores.getColorSpectrum(FabricaColores.ZX_SPECTRUM_BLACK)
                ); :}  | 
          AZUL {:  this.parser.anadirSentenciaColor(
                FabricaColores.getColorSpectrum(FabricaColores.ZX_SPECTRUM_BLUE)
                ); :}  | 
          CYAN {:  this.parser.anadirSentenciaColor(
                FabricaColores.getColorSpectrum(FabricaColores.ZX_SPECTRUM_CYAN)
                ); :}  | 
          BLANCO {:  this.parser.anadirSentenciaColor(
                FabricaColores.getColorSpectrum(FabricaColores.ZX_SPECTRUM_WHITE)
                ); :}| 
        AMARILLO {:  this.parser.anadirSentenciaColor(
                FabricaColores.getColorSpectrum(FabricaColores.ZX_SPECTRUM_YELLOW)
                ); :}| 
        MAGENTA {:  this.parser.anadirSentenciaColor(
                FabricaColores.getColorSpectrum(FabricaColores.ZX_SPECTRUM_MAGENTA)
                ); :} |
        VERDE {:  this.parser.anadirSentenciaColor(
                FabricaColores.getColorSpectrum(FabricaColores.ZX_SPECTRUM_GREEN)
                ); :} ;


asignacion ::= IDENTIFICADOR:id {: this.parser.anotarVariableResultado(id); :}
                IGUAL expresion
                {:
                    this.parser.cerrarAsignacion();
                :} ;
expresion ::= operando:op {:this.parser.anotarParam1(op);:} | 
                operando:op1 {: this.parser.anotarParam1(op1); System.out.println("Param 1:"+op1); :}
                 signo:s {:this.parser.anotarSigno(s); :}
                operando:op2{: this.parser.anotarParam2(op2); System.out.println("Param 2:"+op2);:};
                

operando ::= IDENTIFICADOR:id 
                {:
                    boolean esSimbolico=true;
                    Parametro p=new Parametro(esSimbolico);
                    p.setNombre(id);
                    System.out.println("Encontrado id "+id);
                    RESULT = p;
                :}
                | RESTA IDENTIFICADOR:id 
                {:
                    boolean esSimbolico=true;
                    Parametro p=new Parametro(esSimbolico);
                    p.setNombre(id);
                    p.setNegativo(true);
                    System.out.println("Encontrado id negativo "+id);
                    RESULT = p;
                :}
                | ENTERO:entero
                {:
                    boolean esSimbolico=false;
                    Parametro p=new Parametro(esSimbolico);
                    System.out.println("Encontrado numero "+entero);
                    p.setValor(entero);
                    RESULT = p;
                :}
                | RESTA ENTERO:enteroneg
                {:
                    boolean esSimbolico=false;
                    Parametro p=new Parametro(esSimbolico);
                    p.setNegativo(true);
                    p.setValor(enteroneg);
                    System.out.println("Encontrado num negativo "+enteroneg);
                    RESULT = p;
                :}
                ;



signo ::=   SUMA:s           {: RESULT=s; :}| 
            RESTA:s          {: RESULT=s; :}| 
            MULTIPLICACION:s {: RESULT=s; :}| 
            DIVISION:s       {: RESULT=s; :}
            ;



subir ::=   SUBELAPIZ {: 
                System.out.println("Subiendo");
                this.parser.anadirSentenciaSubeLapiz();
            :}  ;


bajar ::=   BAJALAPIZ {: 
                this.parser.anadirSentenciaBajaLapiz();
            :}  ;


avanzar::=  AVANZA ESPACIO operando:entero {: 
                this.parser.anadirSentenciaAvanza(entero);
            :} ;



girar ::=   GIRA  ESPACIO operando:entero {: 
                this.parser.anadirSentenciaGira(entero);
            :} ;


repetir::= REPETIR ESPACIO operando:veces {:
                this.parser.anadirSentenciaRepetir(veces);
                System.out.println("Repitiendo :"+veces);
            :}  LLAVEABIERTA lista_sentencias LLAVECERRADA {:
                this.parser.terminarSentenciaRepetir();
            :};

procedimiento ::= PROCEDIMIENTO IDENTIFICADOR:id 
                {: 
                    this.parser.crearNuevaListaParametros();
                :}
                PARENIZQ {: System.out.println("Proc "+id); :} lista_parametros PARENDER
                {: 
                    SentenciaProcedimiento s=new SentenciaProcedimiento(id); 
                    s.setNombresParametros(this.parser.getListaParametros()); 
                    this.parser.anadirSentenciaProcedimiento (s);
                :}
                LLAVEABIERTA {:System.out.println("Incluyendo sentencias en proc"); :}
                lista_sentencias LLAVECERRADA
                {:
                    this.parser.terminarSentenciaProcedimiento();
                :};

lista_parametros ::= IDENTIFICADOR:id {: this.parser.anadirParametro(id); :} | 
                    IDENTIFICADOR:id {: this.parser.anadirParametro(id);  :}COMA lista_parametros;


ejecutar_proc   ::= EJECUTAR ESPACIO IDENTIFICADOR:id
                    {:
                        
                        this.parser.crearNuevaListaParametrosPasados();
                    :}
                    lista_valores_pasados 
                    {:
                        SentenciaProcedimiento sp=this.parser.getProcedimiento(id);
                        SentenciaEjecutar s=new SentenciaEjecutar(sp);
                        this.parser.anadirSentenciaEjecutar(s);
                    :};
lista_valores_pasados ::= PARENIZQ valores_pasados_a_procedimiento PARENDER;

valores_pasados_a_procedimiento ::= parametro | parametro COMA valores_pasados_a_procedimiento ;

parametro ::= IDENTIFICADOR:id 
                {:
                    boolean esSimbolico=true;
                    Parametro p=new Parametro(esSimbolico);
                    p.setNombre(id);
                    this.parser.anadirParametroPasado(p);
                :}
                | RESTA IDENTIFICADOR:id 
                {:
                    boolean esSimbolico=true;
                    Parametro p=new Parametro(esSimbolico);
                    p.setNombre(id);
                    p.setNegativo(true);
                    this.parser.anadirParametroPasado(p);
                :}
                |
                | ENTERO:entero
                {:
                    boolean esSimbolico=false;
                    Parametro p=new Parametro(esSimbolico);
                    p.setValor(entero);
                    this.parser.anadirParametroPasado(p);
                :}
                | RESTA ENTERO:enteroneg
                {:
                    boolean esSimbolico=false;
                    Parametro p=new Parametro(esSimbolico);
                    p.setNegativo(true);
                    this.parser.anadirParametroPasado(p);
                :}
                ;