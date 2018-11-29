package io.github.oscarmaestre.jminilogo;
import java_cup.runtime.*;

parser code {:
    Lexer s;
    public Parser(Lexer scanner){
        this.s=scanner;
        System.out.println("Construyendo...");
    }
:}


init with {: s.init(); :};
scan with {: return s.next_token(); :};

/* Terminals (tokens returned by the scanner). */
terminal            SUBELAPIZ, BAJALAPIZ, AVANZA, GIRA, PUNTOCOMA;
terminal Integer    ENTERO; 

/* Non terminals */
non terminal            lista_sentencias;
non terminal Integer    sentencia;      // used to store evaluated subexpressions

/* The grammar rules */
lista_sentencias ::= sentencia | sentencia lista_sentencias ;
sentencia ::= SUBELAPIZ {: System.out.println("Subiendo");:}
                    | BAJALAPIZ {: System.out.println("Bajando");:}
                    | AVANZA {: System.out.println("avanzando");:}
                    | GIRA  {: System.out.println("Girando");:} ;
