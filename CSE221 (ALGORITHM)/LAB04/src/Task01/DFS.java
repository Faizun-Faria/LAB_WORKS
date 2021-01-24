/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task01;

/**
 *
 * @author Faizun
 */
import java.util.*;
public class DFS{
    int [] color;
    int [] distance;
    int [] parent;
    int time;
    int [] startTime;
    int [] finalTime;
    ArrayList<Integer> discoveredN = new ArrayList<Integer>();
    ArrayList<Integer> processedN = new ArrayList<Integer>();
    
    Scanner sc = new Scanner(System.in);
    public void dfsMethod(ArrayList<Integer> adjList[], int source ){
        int numberOfVertices = adjList.length;
        color = new int[numberOfVertices+1];
        distance = new int[numberOfVertices+1];
        parent = new int[numberOfVertices+1];
        startTime = new int[numberOfVertices+1];
        finalTime = new int[numberOfVertices+1];
        Arrays.fill(color, 0);
        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        time =0;
        for(int x=1;x<= numberOfVertices; x++){
            if(color[source]==0){
                dfsVisit(adjList, source );
            }
        }
        print(numberOfVertices);
    }
    
    
    public void dfsVisit(ArrayList<Integer> adjList[] , int u){
        discoveredN.add(u);
        startTime[u] = ++time;
        int v =0;
        color[u] =1;
        
        for (int y=0; y<adjList[u].size();y++){
            v = adjList[u].get(y);
            if(color[v]==0){
                parent[v]=u;
                dfsVisit(adjList, v);
            }
        }
        color[u] = 2;
        finalTime[u] = ++time;
        processedN.add(u);
    }
    public void print(int numberOfVertices){


        
        int i =0;
        System.out.println("Discovered Nodes:");
        while (i<numberOfVertices-1) {
            System.out.print(discoveredN.get(i)+",");
            i++;
        }
        System.out.println();
        
        i =0;
        System.out.println("Processed Nodes:");
        while (i<numberOfVertices-1) {
            System.out.print(processedN.get(i)+",");
            i++;
        }
        System.out.println();
        
        
    }
    
}


