
/**
 *
 * @author Faizun
 */
import java.util.*;

public class CoinDividing {

    static int capacity;
    static int[][] costMatrix;
    static int[][] directionMatrix;
    static int[] value;
    static int numberOfValue;
    static ArrayList<Integer> pickedIndexFirst = new ArrayList();
    static ArrayList<Integer> pickedIndexSecond = new ArrayList();
    static int countOne = 0;
    static int countTwo = 0;

    static int valueOne = 0;
    static int valueTwo = 0;

    public static int max(int i, int j) {
        if (i >= j) {
            return i;
        } else {
            return j;
        }
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);
        String valueString = sc.nextLine();
        StringTokenizer stValue = new StringTokenizer(valueString, " ");
        numberOfValue = stValue.countTokens();

        value = new int[numberOfValue + 1];
        for (int j = 1; j <= numberOfValue; j++) {
            value[j] = Integer.parseInt(stValue.nextToken());
            capacity += value[j];
        }
        capacity /= 2;
    }

    public static void createCostMatrix() {
        costMatrix = new int[numberOfValue + 1][capacity + 1];
        for (int i = 1; i <= numberOfValue; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (j < value[i]) {
                    costMatrix[i][j] = costMatrix[i - 1][j];
                } else {
                    int a = costMatrix[i - 1][j];
                    int b = (costMatrix[i - 1][j - value[i]]) + value[i];
                    int max = max(a, b);
                    costMatrix[i][j] = max(a, b);
                }
            }
        }
    }

    public static void printCostMatrix() {
        System.out.println("Cost Matrix");
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
        while (i > 0 && j > 0) {
            if (costMatrix[i][j] != costMatrix[i - 1][j]) {
                pickedIndexFirst.add(countOne, i);
                countOne++;
                j = j - value[i];
                i--;
            } else {
                i--;
            }
        }

        for (int k = 1; k <= numberOfValue; k++) {
            if (!pickedIndexFirst.contains(k)) {
                pickedIndexSecond.add(countTwo++, k);
            }
        }
    }

    public static void printValue() {
        System.out.print("P1 : ");
        while (countOne > 0) {
            int indexFirst = pickedIndexFirst.get(--countOne);
            valueOne += value[indexFirst];
            System.out.print(value[indexFirst] + " ");
        }
        System.out.print(",");
        System.out.print("P2 : ");
        while (countTwo > 0) {
            int indexSecond = pickedIndexSecond.get(--countTwo);
            valueTwo += value[indexSecond];
            System.out.print(value[indexSecond] + " ");
        }
        System.out.print(",");
        int difference = valueOne - valueTwo;
        if (difference < 0) {
            difference = -difference;
        }
        System.out.println("difference : "+difference);
    }

    public static void main(String[] args) {
        input();
        createCostMatrix();
        System.out.println("Printing cost matrix");
        printCostMatrix();
        System.out.println("-------------------");
        pickedValues();
        printValue();
    }
}
