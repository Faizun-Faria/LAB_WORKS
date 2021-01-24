/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab01;
import java.io.*;
import java.util.*;
/**
 *
 * @author 17201003
 */
public class Lab01 {
    String k [] = {"int", "float", "double", "long", "String", "char", "if", "else", "else if", "while", "for"};
    String m [] = {"+", "-", "*", "/", "%", "^", "="};
    String l[] = {">","<",">=","<=","==","!="};
    String o [] = {",", ";", "(", ")", "{", "}", "[", "]"};
    
    //keywords
    static Queue<String> keywords = new LinkedList<>();
    //identifiers
    static Queue<String> identifiers = new LinkedList<>();
    //math operators
    static Queue<String> mathOperators = new LinkedList<>();
    //logical operators
    static Queue<String> logicalOperators = new LinkedList<>();
    //numerical values
    static Queue<String> numericalValues = new LinkedList<>();
    //others
    static Queue<String> others = new LinkedList<>();
    /**
     * @param args the command line arguments
     */
    static Check ch = new Check();
    public static void main(String[] args) {
        try {
            File f=new File ("file.txt");
            Scanner sc=new Scanner(f);
            while(sc.hasNextLine()){
                String strng= sc.nextLine();
                StringTokenizer st = new StringTokenizer(strng," ");
                int count = st.countTokens();
                for(int i=0; i<count; i++){ 
                    String str = st.nextToken();
                    ch.keywords(str);
                    ch.identifiers(str);
                    ch.mathOperators(str);
                    ch.logicalOperators(str);
                    ch.numericalValues(str);
                    ch.others(str);
                
                }
            }
            print();
        } catch (IOException e) {
        }
 
        
    }
    
    public static void print(){
        System.out.println("Keywords: "+keywords);
        System.out.println("Identifiers: "+identifiers);
        System.out.println("Math Operators: "+mathOperators);
        System.out.println("Logical Operators: "+logicalOperators);
        System.out.println("Numerical Values: "+numericalValues);
        System.out.println("Others: "+others);
    }
}
