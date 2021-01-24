
package cse321_lab04;

import java.util.*;

/**
 *
 * @author Faizun
 */
public class FCFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfProcess = sc.nextInt();
        sc.nextLine();
        int [] processTime = new int[numOfProcess];
        String s = sc.nextLine();
        StringTokenizer st = new StringTokenizer(s," ");
        int [] waitT= new int[numOfProcess];
        int [] startT= new int[numOfProcess];
        int [] endT= new int[numOfProcess];
        for(int i=0; i<numOfProcess; i++){
            processTime[i]=Integer.parseInt(st.nextToken()) ;
            if(i!=0) endT[i]=endT[i-1]+processTime[i];
            else endT[i]=processTime[i];
            if(i==0) continue;
            waitT[i]=waitT[i-1]+processTime[i-1];
            startT[i]=startT[i-1]+processTime[i-1];
        }
        System.out.println("ID Time WaitT Start EndT");
        System.out.println("---------------------------");
        
        for(int i=0; i<numOfProcess; i++){
            System.out.println((i+1)+" "+processTime[i]+" "+waitT[i]+" "+startT[i]+" "+endT[i]);
        }
        
    }
    
}
