/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import io.github.oscarmaestre.jminilogo.Parser;
import io.github.oscarmaestre.jminilogo.Lexer;
import io.github.oscarmaestre.jminilogo.AntoParser;
import io.github.oscarmaestre.jminilogo.excepciones.VariableNoExisteException;
import io.github.oscarmaestre.jminilogo.graficos.ContextoConsola;
import io.github.oscarmaestre.jminilogo.programa.SentenciaCompuesta;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author usuario
 */
public class PruebaScanner {
    Parser p;
    Lexer l;
    StringReader sr;
    public PruebaScanner() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

    
    public void pruebaEstandar(String msg, String prg) {
        StackTraceElement[] pila = Thread.currentThread().getStackTrace();
        StackTraceElement metodo = pila[2];
        System.out.println("\n------------:"+metodo.getMethodName()+"------------");
        System.out.println(prg);
        sr=new StringReader(prg);
        l=new Lexer(sr);
        p=new AntoParser(l);
        try {
            p.parse();
            SentenciaCompuesta s=p.getPrograma();
            System.out.println(s.toString());
            ContextoConsola c=new ContextoConsola();
            System.out.println("Iniciamos ejecucion");
            s.iniciarEjecucion(c);
            System.out.println("Fin ejecucion");
            
        } 
        catch (VariableNoExisteException e){
            System.out.println("Variable "+e.getNombreVariable()+" no existe!!!");
            e.printStackTrace();
        }
        catch (Exception ex) {
            Logger.getLogger(PruebaScanner.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("------------ fin de "+metodo.getMethodName()+"------------");
    }
    
    @Test
    public void subir() {
        String prg="subelapiz;";
        this.pruebaEstandar("Subiendo lapiz", prg);
    }
    
    @Test
    public void avanza() {
        String programa="avanza 20;";
        this.pruebaEstandar(programa, programa);
    }
    
    @Test
    public void gira() {
        String programa="gira     20;";
        this.pruebaEstandar(programa, programa);
    }
    
    @Test
    public void avanzagira() {
        String programa="avanza 20;gira 20;";
        this.pruebaEstandar(programa, programa);
    }
    
    @Test
    public void avanzagiraIncluyendoFinDeLinea() {
        String programa="avanza 199;\n   ";
        this.pruebaEstandar(programa, programa);
    }
    
    @Test
    public void repetir() {
        String programa="repetir 5{avanza 20;\n gira 20;};";
        this.pruebaEstandar(programa, programa);
    }
    
    @Test 
    public void programaSimple(){
        String programa="     subelapiz   ;      ";
        this.pruebaEstandar(programa, programa);
    }
    
    @Test 
    public void programaNegro(){
        String programa="negro;";
        this.pruebaEstandar(programa, programa);
    }
    
    @Test 
    public void programaRojo(){
        String programa="rojo;";
        this.pruebaEstandar(programa, programa);
    }
    @Test 
    public void programaAzul() throws IOException{
        String programa="azul   ;";
        this.pruebaEstandar(programa, programa);
    }
    
    @Test 
    public void programaConProcedimiento() throws IOException{
        String programa="procedimiento aaa (a, b) { rojo; negro; };  ejecutar aaa(3, 4);";
        this.pruebaEstandar(programa, programa);
    }
    
    @Test 
    public void programaConProcedimiento2Ejecutar() throws IOException{
        String programa="procedimiento aaa (a, b) { rojo; negro; };  ejecutar aaa(3, 4); ejecutar aaa(3, 4);";
        this.pruebaEstandar(programa, programa);
    }
    
    
    @Test 
    public void programaConPasoDeParametros() throws IOException{
        String programa="procedimiento aaa (a, b) { rojo; avanza a; avanza b;  negro; };  i=2; c=i; ejecutar aaa(i, c); ejecutar aaa(13, 14);";
        this.pruebaEstandar(programa, programa);
    }
    
    @Test 
    public void programaAsignacionesMatematicas() throws IOException{
        String programa="i=2;j=i+44;";
        this.pruebaEstandar(programa, programa);
    }
    
    
    @Test 
    public void asignacionSimple() throws IOException{
        String programa="i=3;";
        this.pruebaEstandar(programa, programa);
    }
    
    @Test 
    public void asignacionDoble() throws IOException{
        String programa="i=3;j=i;";
        this.pruebaEstandar(programa, programa);
    }
    
    @Test 
    public void espiral() throws IOException{
        String programa="i=200;"
                + "repetir 5{"
                    + "avanza i; gira 20; i=i-20;"
                + "};";
        this.pruebaEstandar(programa, programa);
    }
    
    @Test
    public void asignacionNegativa(){
        String programa="i=-20;";
        this.pruebaEstandar(programa, programa);
    }
    
    @Test
    public void restaNegativa(){
        String programa="j=-30--20;";
        this.pruebaEstandar(programa, programa);
    }
    
}
