
/**
 *
 * @author Faizun
 */
import java.util.Scanner;

public class LCS {

    static Scanner sc = new Scanner(System.in);
    static String s1;
    static String s2;
    static int l1;
    static int l2;
    static int[][] costGraph;
    static char[] c1;
    static char[] c2;
    static int n1;
    static int n2;
    static int[][] directionGraph;

    static int sizeOfLcs;
    static char[] lcs;
    
    public static void main(String[] args) {
        System.out.println("What is the first subsequence");
        s1 = sc.nextLine();
        System.out.println("What is the second subsequence");
        s2 = sc.nextLine();
        Graph();
        costMatrix();
        //printCostMatrix();
        directionMatrix();
        //printDirectionMatrix();
        printLengthOfLcs();
        findLcs();
        printLcs();
    }

    private static void Graph() {
        l1 = s1.length();
        l2 = s2.length();
        costGraph = new int[l1 + 1][l2 + 1];
        c1 = new char[l1 + 1];
        c2 = new char[l2 + 1];
        for (int i = 0; i < l1; i++) {
            c1[i + 1] = s1.charAt(i);
        }
        for (int j = 0; j < l2; j++) {
            c2[j + 1] = s2.charAt(j);
        }
        directionGraph = new int[l1 + 1][l2 + 1];
    }

    private static void costMatrix() {
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if ((i == 0) && (j == 0)) {
                    costGraph[i][j] = 0;
                } else if (c1[i] == c2[j]) {
                    costGraph[i][j] = costGraph[i - 1][j - 1] + 1;
                } else if (c1[i] != c2[j]) {
                    n1 = costGraph[i - 1][j];
                    n2 = costGraph[i][j - 1];
                    costGraph[i][j] = Max(n1, n2);
                }
            }
        }
        sizeOfLcs = costGraph[l1][l2];
    }

    private static int Max(int n1, int n2) {
        if (n1 >= n2) {
            return n1;
        } else {
            return n2;
        }
    }

    private static void printCostMatrix() {
        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                System.out.print(costGraph[i][j]);
            }
            System.out.println();
        }
    }

    private static void printDirectionMatrix() {
        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                System.out.print(directionGraph[i][j]);
            }
            System.out.println();
        }
    }

    private static void directionMatrix() {
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (c1[i] == c2[j]) {
                    directionGraph[i][j] = 1;
                } else if (costGraph[i - 1][j] >= costGraph[i][j - 1]) {
                    directionGraph[i][j] = 2;
                } else if (costGraph[i - 1][j] < costGraph[i][j - 1]) {
                    directionGraph[i][j] = 3;
                }
            }
        }
    }

    private static void printLengthOfLcs() {
        System.out.println(costGraph[l1][l2]);
    }

    private static void findLcs() {
        lcs = new char[sizeOfLcs];
        int i = l1;
        int j = l2;

        int s = sizeOfLcs - 1;
        while (s >= 0) {
            if (directionGraph[i][j] == 1) {
                lcs[s] = c1[i];
                i--;
                j--;
                s--;
            } else if (directionGraph[i][j] == 2){
                i--;
            }else if (directionGraph[i][j] == 3){
                j--;
            }
        }
    }
    private static void printLcs(){
       for(int k =0; k <sizeOfLcs;k++){
           System.out.println(lcs[k]);
       }
    
    }
}

/*
What is the first subsequence
AJBCE
What is the second subsequence
ABEJ
*/
