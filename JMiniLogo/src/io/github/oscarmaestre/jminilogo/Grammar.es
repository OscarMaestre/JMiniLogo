package io.github.oscarmaestre.jminilogo;
import java_cup.runtime.*;
import java.util.Stack;
import java.awt.Color;
import io.github.oscarmaestre.jminilogo.programa.*;
parser code {:
    Lexer s;
    SentenciaCompuesta programa;
    Stack<SentenciaCompuesta> pila=new Stack<SentenciaCompuesta>();
    public Parser(Lexer scanner){
        this.s=scanner;
        programa=new SentenciaCompuesta();
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
        System.out.println("Termino el repetir");
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
terminal            PROCEDIMIENTO, COMA;
terminal            SUBELAPIZ, BAJALAPIZ, AVANZA, GIRA, PUNTOCOMA, ESPACIO, REPETIR, LLAVEABIERTA, LLAVECERRADA;
terminal            String ENTERO; 


non terminal            lista_sentencias;
non terminal            subir, bajar, avanzar, girar, repetir, color, procedimiento;
non terminal            sentencia, final_sentencia, lista_parametros;


lista_sentencias ::= sentencia final_sentencia | sentencia final_sentencia lista_sentencias ;

final_sentencia  ::= PUNTOCOMA | ESPACIO PUNTOCOMA | ESPACIO PUNTOCOMA ESPACIO ;

sentencia ::= subir  | bajar | avanzar | girar | repetir | color | procedimiento;




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