/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse321_lab04;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Faizun
 */
public class SJF {
    public static void main(String [] args){
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        int [] arrivalT= new int[n];
        int [] burstT = new int[n];
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        StringTokenizer st1 = new StringTokenizer(s1," ");
        StringTokenizer st2 = new StringTokenizer(s2," ");
        
        int sumOfBurstT=0;
        for(int i=0; i<n; i++){
            arrivalT[i]=Integer.parseInt(st1.nextToken());
            burstT[i]=Integer.parseInt(st2.nextToken());
            sumOfBurstT+=burstT[i];
        }
        int index=0;
        int min;
        for(int i=0; i<sumOfBurstT;i++){
            min=1000000;
            for(int j=0; j<n; j++){
                if(arrivalT[j]<=i&&burstT[j]<min&&burstT[j]>0){
                    min = burstT[j];
                    index=j;
                }
            }
            System.out.print("P"+(index+1)+",");
            min = --burstT[index];
        }
    }
}
