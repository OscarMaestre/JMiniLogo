/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import io.github.oscarmaestre.jminilogo.Parser;
import io.github.oscarmaestre.jminilogo.Lexer;
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

    @Test
    public void subir() {
        sr=new StringReader("subelapiz;");
        l=new Lexer(sr);
        p=new Parser(l);
        try {
            p.parse();
        } catch (Exception ex) {
            Logger.getLogger(PruebaScanner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void bajalapiz() {
        sr=new StringReader("bajalapiz;");
        l=new Lexer(sr);
        p=new Parser(l);
        try {
            p.parse();
        } catch (Exception ex) {
            Logger.getLogger(PruebaScanner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void avanza() {
        String programa="avanza 20;";
        sr=new StringReader(programa);
        l=new Lexer(sr);
        p=new Parser(l);
        try {
            p.parse();
        } catch (Exception ex) {
            Logger.getLogger(PruebaScanner.class.getName()).log(Level.SEVERE, null, ex);
            fail("Fallo en avanza:\n"+programa);
        }
    }
    
    @Test
    public void gira() {
        String programa="gira     20;";
        sr=new StringReader(programa);
        l=new Lexer(sr);
        p=new Parser(l);
        try {
            p.parse();
        } catch (Exception ex) {
            Logger.getLogger(PruebaScanner.class.getName()).log(Level.SEVERE, null, ex);
            fail("Fallo en giro:\n"+programa);
        }
    }
    
    @Test
    public void avanzagira() {
        String programa="avanza 20;gira 20;";
        sr=new StringReader(programa);
        l=new Lexer(sr);
        p=new Parser(l);
        try {
            p.parse();
        } catch (Exception ex) {
            Logger.getLogger(PruebaScanner.class.getName()).log(Level.SEVERE, null, ex);
            fail("Error en secuencia de sentencias:\n"+programa);
        }
    }
    
    @Test
    public void avanzagiraIncluyendoFinDeLinea() {
        System.out.println("Probando con fines de linea");
        String programa="avanza 199;\n   ";
        sr=new StringReader(programa);
        l=new Lexer(sr);
        p=new Parser(l);
        try {
            p.parse();
        } catch (Exception ex) {
            Logger.getLogger(PruebaScanner.class.getName()).log(Level.SEVERE, null, ex);
            fail("Error en secuencia de sentencias:\n"+programa);
        }
    }
    
    @Test
    public void repetir() {
        String programa="repetir 5{avanza 20;\n gira 20;};";
        sr=new StringReader(programa);
        l=new Lexer(sr);
        p=new Parser(l);
        try {
            p.parse();
        } catch (Exception ex) {
            Logger.getLogger(PruebaScanner.class.getName()).log(Level.SEVERE, null, ex);
            fail("Error en sentencia repetir:\n"+programa);
        }
    }
    
    @Test 
    public void programaSimple(){
        sr=new StringReader("     subelapiz   ;      ");
        l=new Lexer(sr);
        p=new Parser(l);
        try {
            p.parse();
            SentenciaCompuesta s=p.getPrograma();
        } catch (Exception ex) {
            Logger.getLogger(PruebaScanner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test 
    public void programaNegro(){
        System.out.println("Negro");
        sr=new StringReader("negro;");
        l=new Lexer(sr);
        p=new Parser(l);
        try {
            p.parse();
            //SentenciaCompuesta s=p.getPrograma();
        } catch (Exception ex) {
            Logger.getLogger(PruebaScanner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Test 
    public void programaRojo(){
        System.out.println("Rojo");
        sr=new StringReader("rojo;");
        l=new Lexer(sr);
        p=new Parser(l);
        try {
            p.parse();
            //SentenciaCompuesta s=p.getPrograma();
        } catch (Exception ex) {
            Logger.getLogger(PruebaScanner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Test 
    public void programaAzul() throws IOException{
        System.out.println("Azul");
        sr=new StringReader("azul   ;");
        l=new Lexer(sr);
        p=new Parser(l);
        try {
            p.parse();
            //SentenciaCompuesta s=p.getPrograma();
        } catch (Exception ex) {
            Logger.getLogger(PruebaScanner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
