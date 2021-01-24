package lab04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class LAB04 {

    
    static String returnType[] = {"int", "float", "double", "long", "String", "char"};
    static StringTokenizer st ;
    public static void main(String[] args) throws FileNotFoundException {
        Check ch = new Check();
        try {
            File f = new File("input.txt");
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String strng = sc.nextLine();
                st= new StringTokenizer(strng, " ");
                int count = st.countTokens();
                
                for (int i = 0; i < count; i++) {
                    String str2 = st.nextToken();
                    ch.keywords(str2);
                    Boolean flag = ch.methodStart(str2, i, count);
                    if(flag) break;
                }
            }
        } catch (IOException e) {

        }
    }

}
