package io.github.oscarmaestre.jminilogo;
import java_cup.runtime.*;

parser code {:
    Lexer s;
    public Parser(Lexer scanner){
        this.s=scanner;
    }
:}


init with {: s.init(); :};
scan with {: return s.next_token(); :};

/* Terminals (tokens returned by the scanner). */
terminal            SUBELAPIZ, BAJALAPIZ, AVANZA, GIRA, PUNTOCOMA, ESPACIO, REPETIR, LLAVEABIERTA, LLAVECERRADA;
terminal Integer    ENTERO; 

/* Non terminals */
non terminal            lista_sentencias;
non terminal            subir, bajar, avanzar, girar, repetir;
non terminal Integer    sentencia;      // used to store evaluated subexpressions

/* The grammar rules */
lista_sentencias ::= sentencia | sentencia lista_sentencias ;

subir ::=   SUBELAPIZ {: System.out.println("Subiendo");:} PUNTOCOMA |
            SUBELAPIZ {: System.out.println("Subiendo");:} ESPACIO PUNTOCOMA ;


bajar ::=   BAJALAPIZ {: System.out.println("Bajando");:} PUNTOCOMA |
            BAJALAPIZ {: System.out.println("Bajando");:} ESPACIO PUNTOCOMA ;


avanzar::=  AVANZA ESPACIO ENTERO {: System.out.println("avanzando");:} |
            AVANZA ESPACIO ENTERO {: System.out.println("avanzando");:} PUNTOCOMA |
            AVANZA ESPACIO ENTERO {: System.out.println("avanzando");:} ESPACIO PUNTOCOMA;


girar ::=   GIRA  ESPACIO ENTERO {: System.out.println("Girando Numero!");:} |
            GIRA  ESPACIO ENTERO {: System.out.println("Girando Numero!");:} PUNTOCOMA |
            GIRA  ESPACIO ENTERO {: System.out.println("Girando Numero!");:} ESPACIO PUNTOCOMA;

sentencia ::= subir | bajar | avanzar | girar | repetir ;
repetir::= REPETIR ESPACIO ENTERO LLAVEABIERTA lista_sentencias LLAVECERRADA;
