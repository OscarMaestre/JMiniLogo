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
%state NO_IGNORAR_ESPACIOS  
%{
      boolean DEPURANDO = false;
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


Rojo            = "rojo";
Negro           = "negro";
Azul            = "azul";


SubeLapiz       = "subelapiz"
BajaLapiz       = "bajalapiz"  
Entero          =   0 | [1-9][0-9]*

FinLinea        = \r|\n|\r\n

EspacioEnBlanco = ({FinLinea} | [ \t\f])+
Gira            = "gira" 
Avanza          = "avanza" 
LlaveAbierta    = "{"
LlaveCerrada    = "}"
Repetir         = "repetir"
PuntoComa       = ";"
%%

<YYINITIAL> {SubeLapiz}             { 
                                        if (DEPURANDO){
                                            System.out.println("Encontrando -subelapiz-");
                                        }
                                        return symbol (sym.SUBELAPIZ); 
                                    }
<YYINITIAL> {BajaLapiz}             { 
                                        if (DEPURANDO){
                                            System.out.println("Encontrando -bajalapiz-");
                                        }
                                        return symbol (sym.BAJALAPIZ); 
                                    }
<YYINITIAL> {Gira}                  { 
                                        if (DEPURANDO){
                                            System.out.println("Encontrando -gira-, aceptando espacios...");
                                        }
                                        yybegin(NO_IGNORAR_ESPACIOS); 
                                        return symbol (sym.GIRA); 
                                    }
<YYINITIAL> {Avanza}                { 
                                        if (DEPURANDO){
                                            System.out.println("Encontrando -avanza-, aceptando espacios...");
                                        }
                                        yybegin(NO_IGNORAR_ESPACIOS); 
                                        return symbol (sym.AVANZA); 
                                    }
{Repetir}               { 
                                        if (DEPURANDO){
                                            System.out.println("Encontrando -repetir-, aceptando espacios...");
                                        }
                                        yybegin(NO_IGNORAR_ESPACIOS); 
                                        return symbol (sym.REPETIR); 
                        }
{LlaveAbierta}          { return symbol (sym.LLAVEABIERTA); }
{LlaveCerrada}          { return symbol (sym.LLAVECERRADA); }

{PuntoComa}             { yybegin(YYINITIAL);return symbol (sym.PUNTOCOMA); }
{Entero}                { 
                                        yybegin(YYINITIAL); 
                                        if (DEPURANDO){
                                            System.out.println("Encontrando -Entero-"+yytext());
                                        }
                                        return symbol (sym.ENTERO, new String(yytext())); 
                                    }

<NO_IGNORAR_ESPACIOS>{EspacioEnBlanco} 
                                    { 
                                        return symbol (sym.ESPACIO); 
                                    }

<YYINITIAL> {EspacioEnBlanco}       { 
                                        
                                        /* En este estado ignoramos los espacios en blanco*/ 
                                    }

{Rojo}                          {
                                    return symbol (sym.ROJO); 
                                }

{Negro}                         {
                                    return symbol (sym.NEGRO); 
                                }

{Azul}                          {
                                    return symbol (sym.AZUL); 
                                }


/* error fallback */
[^]                              { throw new Error("Simbolo no esperado <"+
                                                        yytext()+">"); }