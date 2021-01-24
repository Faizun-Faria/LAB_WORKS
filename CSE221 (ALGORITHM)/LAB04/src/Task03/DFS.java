/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task03;

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
    int number =0;
    int numberOfVertices;
    Queue<Integer> maze = new LinkedList<>(); 
    Stack mazeS = new Stack();
    Scanner sc = new Scanner(System.in);
    public void dfsMethod(ArrayList<Integer> adjList[], int source, int reachPoint){
        numberOfVertices = adjList.length;
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
               
                dfsVisit(adjList, source,reachPoint );
            }
        }
        print(numberOfVertices,reachPoint);
    }
    public void dfsVisit(ArrayList<Integer> adjList[] , int u, int reachPoint){
        
        startTime[u] = ++time;
        int v =0;
        maze.add(u);
        mazeS.push(u);
        number++;
        color[u] =1;
        for (int y=0; y<adjList[u].size();y++){
            v = adjList[u].get(y);
            if(color[v]==0){
                parent[v]=u;
                dfsVisit(adjList, v , reachPoint);
            }
        }
        color[u] = 2;
        finalTime[u] = ++time;
        if(u!=(int)mazeS.peek()){
        maze.add(u);
        mazeS.push(u);
        number++;
        }
    }
       
    public void print(int numberOfVertices, int reachPoint){
    int k;
    for(int x =0; x<numberOfVertices; x++){
       k = maze.remove();
        if(k==reachPoint)break;
        System.out.print(k+",");
    }
    System.out.print(reachPoint);
    System.out.println();
    }
}


