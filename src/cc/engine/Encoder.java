/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

/**
 *
 * @author Bart
 */
public class Encoder {
    
    // lista, do przechowania wczytanej zawartości
    public static ArrayList<Integer> letterCodeList = new ArrayList<>();
    
    // wejście do metody
    public static void encodeTarget(String source, int codeShift) throws IOException {
        Encoder.encode(source, codeShift);
    }
    
    // metoda na wczytanie tekstu do listy
    private static void encode(String source, int codeShift) throws IOException {
        // cleanup
        Encoder.letterCodeList.clear();
        
        BufferedReader letterReader = new BufferedReader(new StringReader(source));
                
        for (int i = 0; i < source.length(); i++) {
            int currentChar = letterReader.read();
            // zachowanie znaku spacji
            if (currentChar == 32) {
                Encoder.letterCodeList.add(currentChar);
                continue;
            } else {
                currentChar += codeShift;
            }
            Encoder.letterCodeList.add(currentChar); 
        }
    }
    
    // metoda na wyświetlenie zawartości
    public static String printEncodedString(ArrayList<Integer> letterCodeList) {
        String targetString = "";
        
        for (int i = 0; i < letterCodeList.size(); i++){
            int currentLetterCode = letterCodeList.get(i);
            Character encodedCharacter = (char) currentLetterCode;
            targetString += encodedCharacter.toString();
        }
        
        return targetString;
    }

}
