/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task02;

/**
 *
 * @author Faizun
 */
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Graph {
    static int [][] directedGraph;
    
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        BufferedReader obj= null;
        int nodes=0;
        try {
            String str;
            FileReader fr = new FileReader("lab04task02.txt");
            obj = new BufferedReader(fr);
            str = obj.readLine();
            nodes =Integer.parseInt(str) ;
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("What is the source node?");
        int source = sc.nextInt();
        createAdjList(source);
        
    }
    
    
//    public static void createAdjList(int source, int reachPoint){
      public static void createAdjList(int source){
        BufferedReader obj= null;
        try {
            String str;
            FileReader fr = new FileReader("lab04task02.txt");
            obj = new BufferedReader(fr);
            str = obj.readLine();
            int nodes =Integer.parseInt(str) ;         
            str = obj.readLine();
            int edges =Integer.parseInt(str);
            
            ArrayList<Integer> adjList[] = new ArrayList[nodes+1];
            for(int x =0; x<=nodes;x++){
                adjList[x] = new ArrayList<Integer>();
            }
            int i =1;
            while (i<=edges) {
                str = obj.readLine();
                StringTokenizer stT = new StringTokenizer(str," ");
                int token1 = Integer.parseInt(stT.nextToken());
                int token2 = Integer.parseInt(stT.nextToken());
                adjList[token1].add(token2);
                i++;   
            }
             DFS d = new DFS();
             d.dfsMethod(adjList, source);
             ///////////////d.dfsMethod(adjList, source, reachPoint);//
        } catch (IOException e) {
            e.printStackTrace();
        }
       
    }
}
