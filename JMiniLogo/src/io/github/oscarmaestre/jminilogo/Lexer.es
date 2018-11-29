package io.github.oscarmaestre.jminilogo;
import java_cup.runtime.Symbol;

%%

%class Lexer
%unicode
%cup
%implements sym
%line
%public
%column

%{
      StringBuffer string = new StringBuffer();

      private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
      }
      private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
      }
      public void init(){
        System.out.println("Por fin");
      }
%}



SubeLapiz       = "subelapiz"
BajaLapiz       = "bajalapiz"  
Entero          =   0 | [1-9][0-9]*
EspacioEnBlanco = " "+
Gira            = "gira" EspacioEnBlanco Entero
Avanza          = "avanza" EspacioEnBlanco Entero
PuntoComa       = ";"
%%

<YYINITIAL> {SubeLapiz} { return symbol (sym.SUBELAPIZ); }
<YYINITIAL> {BajaLapiz} { return symbol (sym.BAJALAPIZ); }
<YYINITIAL> {Gira}      { return symbol (sym.GIRA); }
<YYINITIAL> {Avanza}    { return symbol (sym.AVANZA); }
<YYINITIAL> {PuntoComa} { return symbol (sym.PUNTOCOMA); }

/* error fallback */
[^]                              { throw new Error("Simbolo no esperado <"+
                                                        yytext()+">"); }