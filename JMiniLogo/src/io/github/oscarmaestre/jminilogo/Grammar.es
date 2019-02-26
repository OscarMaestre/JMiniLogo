package io.github.oscarmaestre.jminilogo;
import java_cup.runtime.*;
import java.util.Stack;
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


terminal            SUBELAPIZ, BAJALAPIZ, AVANZA, GIRA, PUNTOCOMA, ESPACIO, REPETIR, LLAVEABIERTA, LLAVECERRADA;
terminal            String ENTERO; 


non terminal            lista_sentencias;
non terminal            subir, bajar, avanzar, girar, repetir;
non terminal            sentencia, final_sentencia;


lista_sentencias ::= sentencia final_sentencia | sentencia final_sentencia lista_sentencias ;

final_sentencia  ::= PUNTOCOMA | ESPACIO PUNTOCOMA | ESPACIO PUNTOCOMA ESPACIO ;

sentencia ::= subir | bajar | avanzar | girar | repetir ;

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
