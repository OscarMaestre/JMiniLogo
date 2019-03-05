package io.github.oscarmaestre.jminilogo;
import java_cup.runtime.*;
import java.util.Stack;
import java.awt.Color;
import io.github.oscarmaestre.jminilogo.programa.*;
import javax.management.BadStringOperationException;
parser code {:
    Lexer s;
    SentenciaCompuesta programa;
    Stack<SentenciaCompuesta> pila=new Stack<SentenciaCompuesta>();
    public Parser(Lexer scanner){
        this.s=scanner;
        programa=new SentenciaCompuesta();
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
    public void anadirSentenciaGira(String puntos){
        System.out.println("Anadiendo giro:"+puntos.toString());
        Sentencia sentencia=new SentenciaGira(new Integer(puntos));
        programa.anadirSentencia ( sentencia );
    }
    public void anadirSentenciaRepetir(String veces){
        
        System.out.println("Anadiendo repetir :"+ veces);
        SentenciaRepetir sentenciaRepetir=new SentenciaRepetir(Integer.parseInt(veces));
        programa.anadirSentencia(sentenciaRepetir);
        pila.push ( programa );
        programa=new SentenciaCompuesta();
    }
    
    public void anadirSentenciaProcedimiento(String nombre){
        
        System.out.println("Anadiendo procedimiento:"+ nombre);
        SentenciaProcedimiento sentenciaProcedimiento = new SentenciaProcedimiento(nombre);
        programa.anadirSentencia(sentenciaProcedimiento);
        pila.push ( programa );
        programa=new SentenciaCompuesta();
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
    public void terminarSentenciaProcedimiento(){
        SentenciaCompuesta cuerpoProcedimiento = programa;
        SentenciaCompuesta programaAnterior=pila.pop();
        SentenciaProcedimiento sentenciaProcedimiento=(SentenciaProcedimiento)
                    programaAnterior.getUltimaSentencia();

        sentenciaProcedimiento.setCuerpoProcedimiento( cuerpoProcedimiento );
        this.programa = programaAnterior;
    }
    public SentenciaCompuesta getPrograma(){
        return programa;
    }
:}


init with {: s.init(); :};
scan with {: return s.next_token(); :};


terminal            ROJO, NEGRO, AZUL, VERDE, CYAN, MAGENTA, AMARILLO, BLANCO;
terminal            String IDENTIFICADOR;
terminal            PARENIZQ, PARENDER;
terminal            SUMA, RESTA, MULTIPLICACION, DIVISION, IGUAL;
terminal            PROCEDIMIENTO, COMA, EJECUTAR;
terminal            SUBELAPIZ, BAJALAPIZ, AVANZA, GIRA, PUNTOCOMA, ESPACIO, REPETIR, LLAVEABIERTA, LLAVECERRADA;
terminal            String ENTERO; 


non terminal            lista_sentencias;
non terminal            subir, bajar, avanzar, girar, repetir, color, procedimiento;
non terminal            sentencia, final_sentencia, lista_parametros;
non terminal                asignacion, expresion_matematica_simple;

lista_sentencias ::= sentencia final_sentencia | sentencia final_sentencia lista_sentencias ;

final_sentencia  ::= PUNTOCOMA | ESPACIO PUNTOCOMA | ESPACIO PUNTOCOMA ESPACIO ;

sentencia ::= subir  | bajar | avanzar | girar | repetir | color | procedimiento | asignacion;




color ::= ROJO {:  this.parser.anadirSentenciaColor(
                FabricaColores.getColorSpectrum(FabricaColores.ZX_SPECTRUM_CYAN)
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


asignacion ::= IDENTIFICADOR:id IGUAL expresion_matematica_simple:entero 
                {:this.parser.setValor(id, entero); System.out.println(id+"<-"+entero);:};

expresion_matematica_simple ::= ENTERO:entero {: RESULT=entero; :} |
                IDENTIFICADOR:id {: RESULT = this.parser.getValor(id);
                System.out.println("Tabla tiene el valor "+RESULT+" para el simbolo:"+id); :};

subir ::=   SUBELAPIZ {: 
                System.out.println("Subiendo");
                this.parser.anadirSentenciaSubeLapiz();
            :}  ;


bajar ::=   BAJALAPIZ {: 
                this.parser.anadirSentenciaBajaLapiz();
            :}  ;


avanzar::=  AVANZA ESPACIO ENTERO:entero {: 
                this.parser.anadirSentenciaAvanza(entero);
            :} ;


girar ::=   GIRA  ESPACIO ENTERO:entero {: 
                this.parser.anadirSentenciaGira(entero);
            :} ;


repetir::= REPETIR ESPACIO ENTERO:entero {:
                this.parser.anadirSentenciaRepetir(entero);
            :}  LLAVEABIERTA lista_sentencias LLAVECERRADA {:
                this.parser.terminarSentenciaRepetir();
            :};

procedimiento ::= PROCEDIMIENTO IDENTIFICADOR:id
                PARENIZQ {: System.out.println("Proc "+id); :} lista_parametros PARENDER
                {: System.out.println ("Declaracion de proc completa"); :}
                LLAVEABIERTA {:System.out.println("Incluyendo sentencias en proc"); :}lista_sentencias LLAVECERRADA;

lista_parametros ::= IDENTIFICADOR:id {: System.out.println("Parametro:"+id); :} | IDENTIFICADOR:id {: System.out.println("Parametro:"+id); :}COMA lista_parametros;