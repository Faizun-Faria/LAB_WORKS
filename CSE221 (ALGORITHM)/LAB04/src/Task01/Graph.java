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
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Graph {

    static int[][] directedGraph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BufferedReader obj = null;
        int nodes = 0;
        try {
            String str;
            FileReader fr = new FileReader("lab04task01.txt");
            obj = new BufferedReader(fr);
            str = obj.readLine();
            nodes = Integer.parseInt(str);
        } catch (IOException e) {
            e.printStackTrace();
        }

        printAdjMatrix(nodes);

        System.out.println("What is the source node?");
        int source = sc.nextInt();
        createAdjList(source);

    }

//    public static void createAdjList(int source, int reachPoint){
    public static void createAdjList(int source) {
        BufferedReader obj = null;
        try {
            String str;
            FileReader fr = new FileReader("lab04task01.txt");
            obj = new BufferedReader(fr);
            str = obj.readLine();
            int nodes = Integer.parseInt(str);
            str = obj.readLine();
            int edges = Integer.parseInt(str);

            ArrayList<Integer> adjList[] = new ArrayList[nodes + 1];
            for (int x = 0; x <= nodes; x++) {
                adjList[x] = new ArrayList<Integer>();
            }
            int i = 1;
            while (i <= edges) {
                str = obj.readLine();
                StringTokenizer stT = new StringTokenizer(str, " ");
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

    public static void createAdjMatrix(int vertices) {
        directedGraph = new int[vertices + 1][vertices + 1];

        for (int x = 0; x <= vertices; x++) {
            for (int y = 0; y <= vertices; y++) {
                directedGraph[x][y] = 0;

            }
        }

        BufferedReader obj = null;
        try {
            String str;
            FileReader fr = new FileReader("lab04task01.txt");
            obj = new BufferedReader(fr);
            str = obj.readLine();
            str = obj.readLine();

            while ((str = obj.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(str, " ");
                int token1 = Integer.parseInt(st.nextToken());
                int token2 = Integer.parseInt(st.nextToken());
                directedGraph[token1][token2] = 1;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void printAdjMatrix(int vert) {
        createAdjMatrix(vert);
        System.out.println("Printing Adjacency Matrix");
        for (int x = 1; x <= vert; x++) {
            for (int y = 1; y <= vert; y++) {
                System.out.print(directedGraph[x][y] + " ");
            }
            System.out.println();
        }
    }

}
