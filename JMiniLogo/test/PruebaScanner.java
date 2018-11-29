/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import io.github.oscarmaestre.jminilogo.Parser;
import io.github.oscarmaestre.jminilogo.Lexer;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public void hello() {
        Parser p;
        Lexer l;
        StringReader sr;
        sr=new StringReader("subelapiz");
        l=new Lexer(sr);
        p=new Parser(l);
        try {
            p.parse();
        } catch (Exception ex) {
            Logger.getLogger(PruebaScanner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
