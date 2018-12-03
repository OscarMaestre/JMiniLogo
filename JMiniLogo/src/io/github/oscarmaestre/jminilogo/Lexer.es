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
      }
%}



SubeLapiz       = "subelapiz"
BajaLapiz       = "bajalapiz"  
Entero          =   0 | [1-9][0-9]*
EspacioEnBlanco = [\n\t ]+
Gira            = "gira" 
Avanza          = "avanza" 
LlaveAbierta    = "{"
LlaveCerrada    = "}"
Repetir         = "repetir"
PuntoComa       = ";"
%%

<YYINITIAL> {SubeLapiz}             { return symbol (sym.SUBELAPIZ); }
<YYINITIAL> {BajaLapiz}             { return symbol (sym.BAJALAPIZ); }
<YYINITIAL> {Gira}                  { return symbol (sym.GIRA); }
<YYINITIAL> {Avanza}                { return symbol (sym.AVANZA); }
<YYINITIAL> {Repetir}               { return symbol (sym.REPETIR); }
<YYINITIAL> {LlaveAbierta}          { return symbol (sym.LLAVEABIERTA); }
<YYINITIAL> {LlaveCerrada}          { return symbol (sym.LLAVECERRADA); }
<YYINITIAL> {PuntoComa}             { return symbol (sym.PUNTOCOMA); }
<YYINITIAL> {Entero}                { return symbol (sym.ENTERO); }
<YYINITIAL> {EspacioEnBlanco}       { return symbol (sym.ESPACIO); }
/* error fallback */
[^]                              { throw new Error("Simbolo no esperado <"+
                                                        yytext()+">"); }