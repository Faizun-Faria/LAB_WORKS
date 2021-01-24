package cse321_lab04;

import java.util.Scanner;
import java.util.StringTokenizer;

public class RoundRobin {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String s= sc.nextLine();
        StringTokenizer st = new StringTokenizer(s," ");
        int num = st.countTokens();
        int [] arr= new int[num];
        int quantumTime=0;
        
        for(int i=0; i<num; i++){
            arr[i]= Integer.parseInt(st.nextToken());
            quantumTime+=arr[i];
        }
        while(quantumTime>0){
            for(int i=0; i<num; i++){
                if((arr[i]>0)&&(arr[i]>=4)){
                    arr[i]-=4;
                    quantumTime-=4;
                    System.out.println(i);
                }
                else if((arr[i]>0)&&(arr[i]<4)){
                    quantumTime-=arr[i];
                    arr[i]=0;
                    System.out.println(i);
                }
            }   
        
        }
        
    }
}
