
/**
 *
 * @author Faizun
 */
import java.util.*;

public class KnapSack {

    static int capacity;
    static int[][] costMatrix;
    static int[][] directionMatrix;
    static int numberOfValue;
    static int[] weight;
    static int[] value;
    static ArrayList<Integer> pickedIndex = new ArrayList();
    static int count = 0;

    public static int max(int i, int j) {
        if (i >= j) {
            return i;
        } else {
            return j;
        }
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the capacity");
        capacity = sc.nextInt();
        String weightString;
        String valueString;
        System.out.println("How many values are there?");
        numberOfValue = sc.nextInt();
        sc.nextLine();
        weight = new int[numberOfValue + 1];
        value = new int[numberOfValue + 1];
        System.out.println("Weights of the goods");
        weightString = sc.nextLine();
        StringTokenizer stWeight = new StringTokenizer(weightString, " ");
        for (int j = 1; j <= numberOfValue; j++) {
            weight[j] = Integer.parseInt(stWeight.nextToken());
        }
        System.out.println("Values of the goods");
        valueString = sc.nextLine();
        StringTokenizer stValue = new StringTokenizer(valueString, " ");
        for (int j = 1; j <= numberOfValue; j++) {
            value[j] = Integer.parseInt(stValue.nextToken());
        }

    }

    public static void createCostMatrix() {
        costMatrix = new int[numberOfValue + 1][capacity + 1];
        for (int i = 1; i <= numberOfValue; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (j < weight[i]) {
                    costMatrix[i][j] = costMatrix[i - 1][j];
                } else {
                    costMatrix[i][j] = max(costMatrix[i - 1][j], (costMatrix[i - 1][j - weight[i]]) + value[i]);
                }
            }
        }
    }

    public static void printCostMatrix() {
        for (int i = 0; i <= numberOfValue; i++) {
            for (int j = 0; j <= capacity; j++) {
                System.out.print(costMatrix[i][j]);
            }
            System.out.println();
        }

    }

    public static void pickedValues() {
        int i = numberOfValue;
        int j = capacity;
        while(i>0&&j>0){
            if (costMatrix[i][j] != costMatrix[i - 1][j]){
               pickedIndex.add(count, i);
               count++;
               j = j - weight[i];
               i--;
            }else{ 
                i--;
            }
        }
    }

    public static void main(String[] args) {
        input();
        createCostMatrix();
        System.out.println("Printing cost matrix");
        printCostMatrix();
        System.out.println("-------------------");
        pickedValues();
        System.out.println("Printing picked items");
        while(count>0){
            System.out.print(pickedIndex.get(--count)+"  ");
        }
    }
}
