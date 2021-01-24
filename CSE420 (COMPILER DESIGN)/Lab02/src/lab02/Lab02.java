package lab02;

import java.util.Scanner;
import java.util.regex.*;

/**
 *
 * @author 17201003
 */
public class Lab02 {

    /**
     * @param args the command line arguments
     */
    static String s;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int testCase = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < testCase; i++) {
            check(i+1);
        }
    }

    public static void check(int n) {
        s = sc.nextLine();
        int state = 0;
        Pattern p1 = Pattern.compile("[A-za-z0-9_%+-]");
        Pattern p2 = Pattern.compile("[@]");
        Pattern p3 = Pattern.compile("[.]");
        Pattern p4 = Pattern.compile("[A-Za-z]");

        for (int x = 0; x < s.length(); x++) {
            if ((x == 0) && (s.startsWith("www"))) {
                state = 7;
                x += 2;
                continue;
            }
            char c = s.charAt(x);
            String ch = String.valueOf(c);
            Matcher m1 = p1.matcher(ch);
            Matcher m2 = p2.matcher(ch);
            Matcher m3 = p3.matcher(ch);
            Matcher m4 = p4.matcher(ch);
            //email
            if ((state == 0) && (m1.find())) {
                state = 1;
            } else if ((state == 1) && (m1.find())) {
                state = 1;
            } else if ((state == 1) && (m2.find())) {
                state = 2;
            } else if ((state == 2) && (m1.find())) {
                state = 3;
            } else if ((state == 3) && (m1.find())) {
                state = 3;
            } else if ((state == 3) && (m3.find())) {
                state = 4;
            } else if ((state == 4) && (m4.find())) {
                state = 5;
            } else if ((state == 5) && (m4.find())) {
                state = 6;
            } else if ((state == 6) && (m4.find())) {
                state = 6;
            } //website
            else if ((state == 7) && (m3.find())) {
                state = 8;
            } else if ((state == 8) && (m1.find())) {
                state = 9;
            } else if ((state == 9) && (m1.find())) {
                state = 9;
            } else if ((state == 9) && (m3.find())) {
                state = 10;
            } else if ((state == 10) && (m4.find())) {
                state = 11;
            } else if ((state == 11) && (m4.find())) {
                state = 11;
            } else {
                state = 12;
                break;
            }
        }
        if (state == 6) {
            System.out.println("Email, " + n);
        } else if (state == 11) {
            System.out.println("Website, " + n);
        } else {
            System.out.println("Invalid, " + n);
        }
    }

}

//www.farai.com
