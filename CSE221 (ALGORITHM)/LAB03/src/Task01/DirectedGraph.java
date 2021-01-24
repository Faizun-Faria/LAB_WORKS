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
import java.io.*;
import java.util.*;

public class DirectedGraph {

    static int[][] directedGraph;
    static int source;

    public static void main(String[] args) {
        BFS bfs = new BFS();
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the source node?");
        source = sc.nextInt();
        BufferedReader obj = null;
        try {
            String str;
            FileReader fr = new FileReader("lab03task01.txt");
            obj = new BufferedReader(fr);
            str = obj.readLine();
            int vertices;
            vertices = Integer.parseInt(str);
            str = obj.readLine();
            int edges;
            edges = Integer.parseInt(str);
            createAdjList(vertices, edges);

            bfs.bfsMethod(directedGraph, source);
        } catch (IOException e) {
        }

    }

    public static void createAdjList(int vertices, int edge) {
        directedGraph = new int[vertices + 1][vertices + 1];
        BufferedReader obj = null;
        try {
            String str;
            FileReader fr = new FileReader("lab03task01.txt");
            obj = new BufferedReader(fr);
            str = obj.readLine();
            str = obj.readLine();

            for (int x = 0; x <= vertices; x++) {
                directedGraph[x][0] = x; //vertice number
                for (int y = 1; y <= vertices; y++) {
                    directedGraph[x][y] = -1;
                }
            }
            int i = 0;
            while (i < edge) {
                i++;
                str = obj.readLine();
                StringTokenizer st = new StringTokenizer(str, " ");
                int token1 = Integer.parseInt(st.nextToken());
                int token2 = Integer.parseInt(st.nextToken());
                for (int z = 1; z <= vertices; z++) {
                    if (directedGraph[token1][z] == -1) {
                        directedGraph[token1][z] = token2;
                        break;
                    }
                }

            }
        } catch (IOException e) {
        }

    }
}
