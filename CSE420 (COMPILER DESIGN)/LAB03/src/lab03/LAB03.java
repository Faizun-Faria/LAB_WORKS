package lab03;
import java.io.*;
import java.util.*;
import java.util.regex.*;
public class LAB03 {
    static int numberOfRE;
    static int numberOfPatterns;
    static String [] regEx;
    static String [] patterns;
    
    public static void main(String[] args) {
        try {
            File f=new File ("lab03_file.txt");
            Scanner sc=new Scanner(f);
            String s;
            s = sc.nextLine();
            numberOfRE = Integer.valueOf(s);
            regEx = new String[numberOfRE];
            for(int i=0; i<numberOfRE; i++){
                regEx[i] = sc.nextLine();
            }
            s = sc.nextLine();
            numberOfPatterns = Integer.valueOf(s);
            patterns = new String[numberOfPatterns];
            for(int i=0; i<numberOfPatterns; i++){
                patterns[i] = sc.nextLine();
            }
        } catch (IOException e) {
        }
        check();
    }

    public static void check() {
        Pattern p; 
        for(int i=0; i<numberOfPatterns; i++){
            Boolean flag = false;
            for(int j=0; j<numberOfRE; j++){
                p = Pattern.compile(regEx[j]);
                Matcher m = p.matcher(patterns[i]);
                if(m.find()){
                    flag = true;
                    System.out.println("YES, "+(j+1));
                    break;
                } 
            }
            if(!flag) System.out.println("NO, "+0);
        }
    }
}
     