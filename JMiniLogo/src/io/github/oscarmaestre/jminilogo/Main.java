/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.oscarmaestre.jminilogo;

import io.github.oscarmaestre.jminilogo.graficos.ContextoGraficoJavaFX;
import io.github.oscarmaestre.jminilogo.programa.SentenciaCompuesta;
import java.io.StringReader;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author usuario
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(300, 250);
        Button btn = new Button();
        btn.setText("Dibujar");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Pulsado");
                String programa="bajalapiz;gira 290;avanza 200;gira     20;";
                StringReader sr=new StringReader(programa);
                Lexer l=new Lexer(sr);
                Parser p=new Parser(l);
                try {
                    p.parse();
                    SentenciaCompuesta pr=p.getPrograma();
                    System.out.println("Ejecutando programa:");
                    System.out.println(pr.toString());
                    ContextoGraficoJavaFX contexto=new ContextoGraficoJavaFX(canvas);
                    
                    boolean b;
                    b = pr.ejecutar(contexto);
                    System.out.println("Programa ejecutado!");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        root.getChildren().add(canvas);
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        System.out.println("Creado");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
