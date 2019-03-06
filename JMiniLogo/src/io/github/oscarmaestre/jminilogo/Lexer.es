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

Ejecutar        = "ejecutar"

Identificador   = [a-zA-Z]+

Gira            = "gira" 
Avanza          = "avanza" 
LlaveAbierta    = "{"
LlaveCerrada    = "}"
Repetir         = "repetir"
PuntoComa       = ";"

SubeLapiz       = "subelapiz"
BajaLapiz       = "bajalapiz"  
Entero          =  "-"?( 0 | [1-9][0-9]*)

Suma            = "+"
Resta           = "-"
Multiplicacion  = "*"
Division        = "/"
SignoIgual      = "="
FinLinea        = \r|\n|\r\n
Coma            = ","
EspacioEnBlanco = ({FinLinea} | [ \t\f])+

ParenIzq        = "("
ParenDer        = ")"
Procedimiento   = "procedimiento"{EspacioEnBlanco}
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
{ParenIzq}              { return symbol (sym.PARENIZQ); }
{ParenDer}              { return symbol (sym.PARENDER); }
{Coma}                  { return symbol (sym.COMA); }

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


{Procedimiento}          { return symbol (sym.PROCEDIMIENTO); }
{Ejecutar}                        {
                                    if (DEPURANDO){
                                            System.out.println("Encontrando -EJECUTAR-");
                                        }
                                    return symbol (sym.EJECUTAR); 
                                }
{Identificador}                {
                                    if (DEPURANDO){
                                        System.out.println("Encontrado -IDENTIFICADOr-"+yytext());
                                        System.out.println("Estabamos en el estado:"+yystate());
                                    }
                                    return symbol (sym.IDENTIFICADOR, new String(yytext())); 
                                }

{Suma}                      { return symbol (sym.SUMA); }
{Resta}                     { return symbol (sym.RESTA); }
{Multiplicacion}            { return symbol (sym.MULTIPLICACION); }
{Division}                  { return symbol (sym.DIVISION); }
{SignoIgual}                { return symbol (sym.IGUAL); }
/* error fallback */
[^]                              { throw new Error("Simbolo no esperado <"+
                                                        yytext()+">"); }