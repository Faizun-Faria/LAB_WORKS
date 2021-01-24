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
public class DalaiLama{
    int [] color;
    int [] distance;
    int [] parent;
    Scanner sc = new Scanner(System.in);
    public void bfsMethod(ArrayList<Integer> adjList[], int source){
        int numberOfVertices = adjList.length;
        color = new int[numberOfVertices+1];
        distance = new int[numberOfVertices+1];
        parent = new int[numberOfVertices+1];
        Arrays.fill(color, 0);
        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        color[source] =1;//Gray
        distance [source] = 0;
        parent [source] = -1;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(source);
        while (queue.peek()!=null){
            int u =queue.poll();
//            System.out.println(2);
            for(int x=0; x<adjList[u].size();x++){
                int v = adjList[u].get(x);
//                System.out.println(3);
                if(color[v]==0){
                    color[v] = 1;
                    distance [v] = distance[u]+1;
//                    System.out.println(v+" " +distance [v]);
                    parent[v] = u;
                    queue.add(v);
                }
            }
            color[u] =2;
        }
        System.out.println("In which node do you want to reach?");
        int reachPoint = sc.nextInt();
        System.out.println(distance[reachPoint]);
    }
    
}



