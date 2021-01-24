package cse321_lab04;

import java.util.*;

public class PriorityScheduling {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] burstT = new int[n];
        int[] priorityT = new int[n];
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        StringTokenizer st1 = new StringTokenizer(s1, " ");
        StringTokenizer st2 = new StringTokenizer(s2, " ");
        for (int i = 0; i < n; i++) {
            burstT[i] = Integer.parseInt(st1.nextToken());
            priorityT[i] = Integer.parseInt(st2.nextToken());
        }
        int min;
        int index = 0;
        for (int j = 0; j < n; j++) {
            min = 10000;
            for (int i = 0; i < n; i++) {
                
                if (priorityT[i] < min) {
                    min = priorityT[i];
                    index = i;
                }
            }
            System.out.println("P"+(index+1));
            priorityT[index] = 100000;
        }
    }
}
