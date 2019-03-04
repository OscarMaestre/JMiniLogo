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



Negro           = "negro"
Azul            = "azul"
Rojo            = "rojo"
Magenta         = "magenta"
Verde           = "verde"
Cyan            = "cyan"
Amarillo        = "amarillo"
Blanco          = "blanco"



Gira            = "gira" 
Avanza          = "avanza" 
LlaveAbierta    = "{"
LlaveCerrada    = "}"
Repetir         = "repetir"
PuntoComa       = ";"

SubeLapiz       = "subelapiz"
BajaLapiz       = "bajalapiz"  
Entero          =   0 | [1-9][0-9]*

FinLinea        = \r|\n|\r\n

EspacioEnBlanco = ({FinLinea} | [ \t\f])+

%%


{Rojo}                          {
                                    if (DEPURANDO){
                                        System.out.println("Encontrado -rojo-");
                                        System.out.println("Estabamos en el estado:"+yystate());
                                    }
                                    return symbol (sym.ROJO); 
                                }

{Negro}                         {
                                    if (DEPURANDO){
                                        System.out.println("Encontrado -negro-");
                                        System.out.println("Estabamos en el estado:"+yystate());
                                    }
                                    return symbol (sym.NEGRO); 
                                }

{Azul}                          {
                                    if (DEPURANDO){
                                        System.out.println("Encontrado -azul-");
                                        System.out.println("Estabamos en el estado:"+yystate());
                                    }
                                    return symbol (sym.AZUL); 
                                }

{Magenta}                       {
                                    return symbol (sym.MAGENTA); 
                                }
{Amarillo}                      {
                                    return symbol (sym.AMARILLO); 
                                }
{Cyan}                          {
                                    return symbol (sym.CYAN); 
                                }
{Verde}                         {
                                    return symbol (sym.VERDE); 
                                }
{Blanco}                        {
                                    return symbol (sym.BLANCO); 
                                }

{SubeLapiz}             { 
                                        if (DEPURANDO){
                                            System.out.println("Encontrando -subelapiz-");
                                        }
                                        return symbol (sym.SUBELAPIZ); 
                                    }
{BajaLapiz}             { 
                                        if (DEPURANDO){
                                            System.out.println("Encontrando -bajalapiz-");
                                        }
                                        return symbol (sym.BAJALAPIZ); 
                                    }
{Gira}                  { 
                                        if (DEPURANDO){
                                            System.out.println("Encontrando -gira-, aceptando espacios...");
                                        }
                                        yybegin(NO_IGNORAR_ESPACIOS); 
                                        return symbol (sym.GIRA); 
                                    }
 {Avanza}                { 
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

{PuntoComa}             { 
                            if (DEPURANDO){
                                System.out.println("Encontrando -Punto y coma-"+yytext());  
                                System.out.println("Estabamos en el estado:"+yystate());
                            }
                            yybegin(YYINITIAL);return symbol (sym.PUNTOCOMA); 
                        }
{Entero}                { 
                                        yybegin(YYINITIAL); 
                                        if (DEPURANDO){
                                            System.out.println("Encontrando -Entero-"+yytext());
                                        }
                                        return symbol (sym.ENTERO, new String(yytext())); 
                                    }

<NO_IGNORAR_ESPACIOS>{EspacioEnBlanco} 
                                    { 
                                        if (DEPURANDO){
                                            System.out.println("Encontrando -espacio que NO IGNORAMOS-"+yytext());
                                        }
                                        return symbol (sym.ESPACIO); 
                                    }

{EspacioEnBlanco}       { 
                                        if (DEPURANDO){
                                            System.out.println("Encontrando -espacio que ignorar-"+yytext());
                                        }
                                        
                                        /* En este estado ignoramos los espacios en blanco*/ 
                                    }




/* error fallback */
[^]                              { throw new Error("Simbolo no esperado <"+
                                                        yytext()+">"); }