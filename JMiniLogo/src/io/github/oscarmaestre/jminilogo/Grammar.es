package io.github.oscarmaestre.jminilogo;
import java_cup.runtime.*;
import java.util.Stack;
import java.awt.Color;
import io.github.oscarmaestre.jminilogo.programa.*;
import javax.management.BadStringOperationException;
import java.util.HashMap;
import java.util.ArrayList;
parser code {:
    Lexer s;
    SentenciaCompuesta programa;
    Stack<SentenciaCompuesta> pila=new Stack<SentenciaCompuesta>();
    HashMap<String, SentenciaProcedimiento> procedimientos;
    ArrayList<String> listaParametros;
    ArrayList<Parametro> parametrosPasados;
    public Parser(Lexer scanner){
        this.s=scanner;
        programa=new SentenciaCompuesta();
        procedimientos=new HashMap<>();
    }
    public SentenciaProcedimiento getProcedimiento(String nombre){
        return procedimientos.get(nombre);
    }
    public void crearNuevaListaParametros(){
        this.listaParametros=new ArrayList<>();
    }
    public void anadirParametro(String parametro){
        this.listaParametros.add(parametro);
    }

    public void crearNuevaListaParametrosPasados(){
        this.parametrosPasados=new ArrayList<>();
    }
    public void anadirParametroPasado(Parametro parametro){
        this.parametrosPasados.add(parametro);
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
        
        
        SentenciaRepetir sentenciaRepetir=new SentenciaRepetir(Integer.parseInt(veces));
        programa.anadirSentencia(sentenciaRepetir);
        pila.push ( programa );
        programa=new SentenciaCompuesta();
    }
    
    public void anadirSentenciaProcedimiento(SentenciaProcedimiento sentenciaProcedimiento){
        this.procedimientos.put(sentenciaProcedimiento.getNombre(), sentenciaProcedimiento);
        programa.anadirSentencia(sentenciaProcedimiento);
        pila.push ( programa );
        programa=new SentenciaCompuesta();
    }

    public void anadirSentenciaEjecutar(SentenciaEjecutar s){
        s.setParametros (this.parametrosPasados);
        programa.anadirSentencia(s);
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
non terminal            asignacion, expresion_matematica_simple;
non terminal            valores_pasados_a_procedimiento, parametro, ejecutar_proc, lista_valores_pasados ;


lista_sentencias ::= sentencia final_sentencia | sentencia final_sentencia lista_sentencias ;

final_sentencia  ::= PUNTOCOMA | ESPACIO PUNTOCOMA | ESPACIO PUNTOCOMA ESPACIO ;

sentencia ::= subir  | bajar | avanzar | girar | repetir | color | procedimiento | asignacion | ejecutar_proc;




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
                {: 
                    this.parser.crearNuevaListaParametros();
                :}
                PARENIZQ {: System.out.println("Proc "+id); :} lista_parametros PARENDER
                {: 
                    SentenciaProcedimiento s=new SentenciaProcedimiento(id); 
                    s.setNombresParametros(this.parser.listaParametros); 
                    this.parser.anadirSentenciaProcedimiento (s);
                :}
                LLAVEABIERTA {:System.out.println("Incluyendo sentencias en proc"); :}
                lista_sentencias LLAVECERRADA
                {:
                    this.parser.terminarSentenciaProcedimiento();
                :};

lista_parametros ::= IDENTIFICADOR:id {: this.parser.anadirParametro(id); :} | 
                    IDENTIFICADOR:id {: this.parser.anadirParametro(id);  :}COMA lista_parametros;


ejecutar_proc   ::= EJECUTAR IDENTIFICADOR:id
                    {:
                        
                        this.parser.crearNuevaListaParametrosPasados();
                    :}
                    lista_valores_pasados 
                    {:
                        SentenciaProcedimiento sp=this.parser.getProcedimiento(id);
                        SentenciaEjecutar s=new SentenciaEjecutar(sp);
                        this.parser.anadirSentenciaEjecutar(s);
                    :};
lista_valores_pasados ::= PARENIZQ valores_pasados_a_procedimiento PARENDER;

valores_pasados_a_procedimiento ::= parametro | parametro COMA valores_pasados_a_procedimiento ;

parametro ::= IDENTIFICADOR:id 
                {:
                    boolean esSimbolico=true;
                    Parametro p=new Parametro(esSimbolico);
                    p.setNombre(id);
                    this.parser.anadirParametroPasado(p);
                :}
                | ENTERO:entero
                {:
                    boolean esSimbolico=false;
                    Parametro p=new Parametro(esSimbolico);
                    p.setValor(entero);
                    this.parser.anadirParametroPasado(p);
                :}
                ;