/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author mariano
 */
public class Principal {
    public static void main(String[] args) throws Exception {
        String ruta1 = "/home/mariano/Escritorio/Archivos/analizador-lexico-sintactico/AnalizadorLexicoSintactico/src/codigo/Lexer.flex";
        String ruta2 = "/home/mariano/Escritorio/Archivos/analizador-lexico-sintactico/AnalizadorLexicoSintactico/src/codigo/LexerCup.flex";
        String[] rutas = {"-parser", "Sintax", "/home/mariano/Escritorio/Archivos/analizador-lexico-sintactico/AnalizadorLexicoSintactico/src/codigo/Sintax.cup"};
        generar(ruta1, ruta2, rutas);
    }
    
    public static void generar(String ruta1, String ruta2, String[] rutas) throws IOException, Exception{
        File archivo;
        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(rutas);
        
        Path rutaSym = Paths.get("/home/mariano/Escritorio/Archivos/analizador-lexico-sintactico/AnalizadorLexicoSintactico/src/codigo/sym.java");
        
        if(Files.exists(rutaSym)){
            Files.delete(rutaSym);
        }
        
        Files.move(
            Paths.get("/home/mariano/Escritorio/Archivos/analizador-lexico-sintactico/AnalizadorLexicoSintactico/sym.java"),
            Paths.get("/home/mariano/Escritorio/Archivos/analizador-lexico-sintactico/AnalizadorLexicoSintactico/src/codigo/sym.java")
        );
        
        Path rutaSin = Paths.get("/home/mariano/Escritorio/Archivos/analizador-lexico-sintactico/AnalizadorLexicoSintactico/src/codigo/Sintax.java");
        
        if(Files.exists(rutaSin)){
            Files.delete(rutaSin);
        }
        
        Files.move(
            Paths.get("/home/mariano/Escritorio/Archivos/analizador-lexico-sintactico/AnalizadorLexicoSintactico/Sintax.java"),
            Paths.get("/home/mariano/Escritorio/Archivos/analizador-lexico-sintactico/AnalizadorLexicoSintactico/src/codigo/Sintax.java")
        );
    }
}
