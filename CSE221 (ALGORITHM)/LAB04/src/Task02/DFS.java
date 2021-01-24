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
import java.util.*;
public class DFS{
    int [] color;
    int [] distance;
    int [] parent;
    int time;
    int [] startTime;
    int [] finalTime;

    Stack topSortNodes = new Stack();
    Scanner sc = new Scanner(System.in);
//    public void dfsMethod(ArrayList<Integer> adjList[], int source, int reachPoint){
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
        topSortNodes.push(u);
    }
    public void print(int numberOfVertices){
        int []  num=new int[numberOfVertices];
        int i =0;
        while (i<numberOfVertices-1) {
            num[i] = (int)topSortNodes.pop();
            i++;
        }
        System.out.println("After Topological Sort: Nodes: ");
        i =0;
        while (i<numberOfVertices-1) {
            System.out.print(num[i]+"->");
            i++;
        }
        System.out.println();
        i =0;
        System.out.println("Finish Times: ");
        while (i<numberOfVertices-1) {
            System.out.print(finalTime[num[i]]+" ");
            i++;
        }
        System.out.println();
    }
}


