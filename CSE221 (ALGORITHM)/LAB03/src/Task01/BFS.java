package Task01;

import static Task01.DirectedGraph.directedGraph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Faizun
 */
public class BFS {

    int[] color;
    int[] distance;
    int[] parent;
    int numberOfVertices;

    void bfsMethod(int[][] directedGraph, int source) {

        numberOfVertices = directedGraph.length;
//        ArrayList<Integer> path[] = new ArrayList[numberOfVertices+1];
//            for(int x =0; x<=numberOfVertices;x++){
//                path[x] = new ArrayList<Integer>();
//            }
        color = new int[numberOfVertices + 1];
        distance = new int[numberOfVertices + 1];
        parent = new int[numberOfVertices + 1];
        Arrays.fill(color, 0);
        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        color[source] = 1;//Gray
        distance[source] = 0;
        parent[source] = -1;

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(source);
        queue.add(source);
        int v;
        int x;
        while (queue.peek() != null) {
            int u = queue.poll();

            x = 1;
            while (directedGraph[u][x] > -1) {
                v = directedGraph[u][x];
                if (color[v] == 0) {
                    color[v] = 1;
                    distance[v] = distance[u] + 1;
                    parent[v] = u;
                    queue.add(v);
                }
                x++;
            }
            color[u] = 2;
        }
        print(color, parent, distance);
    }

    void print(int[] color, int[] parent, int[] distance) {
        for (int x = 1; x < numberOfVertices; x++) {
            System.out.print(x + " : distance from source - " + distance[x] + ", path -> ");
            for (int y = 0; y <= directedGraph[x].length; y++) {
                if (directedGraph[x][y] != -1) {
                    System.out.print(directedGraph[x][y] + ",");
                } else {
                    break;
                }
            }
            System.out.println();
        }
    }

}
