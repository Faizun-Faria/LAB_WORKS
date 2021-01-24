/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse340;

/**
 *
 * @author Faizun
 */
public class CSE340 {
    static int t1,t2,t3,t4,t5;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        t1=3;
        t2=15;
        t3=20;
        t4=0;
        t5=5;
        loop_i();
    }
    
    public static void loop_i(){
        if(t1==0) {
            
        
        exit_();
        }
        t3 += t1;
        loop_j();
    }
    public static void loop_j(){
        if(t2==t5) exit_j();
        t4 = t2+t3;
        t2 += t5;
        loop_j();
    }
    public static void exit_j(){
        t1 -=1;
        loop_i();
    }
    public static void exit_(){
        System.out.println("t1="+t1);
        System.out.println("t2="+t2);
        System.out.println("t3="+t3);
        System.out.println("t4="+t4);
        System.out.println("t5="+t5);
        System.out.println("End");
    }
}
