/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Faizun
 */
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Directed {

    static int[][] directedGraph;

    public static void main(String[] args) {

    }

    public static void createAdjMatrix(int vertices) {
        directedGraph = new int[vertices][vertices];

        for (int x = 0; x < vertices; x++) {
            for (int y = 0; y < vertices; y++) {
                directedGraph[x][y] = 0;

            }
        }

        BufferedReader obj = null;
        try {
            String str;
            FileReader fr = new FileReader("input.txt");
            obj = new BufferedReader(fr);
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
        for (int x = 0; x < vert; x++) {
            for (int y = 0; y < vert; y++) {
                System.out.print(directedGraph[x][y] + " ");
            }
            System.out.println();
        }
    }

    public static void createAdjList(int vertices) {
        directedGraph = new int[vertices][vertices];
        BufferedReader obj = null;
        try {
            String str;
            FileReader fr = new FileReader("input.txt");
            obj = new BufferedReader(fr);
            str = obj.readLine();

            for (int x = 0; x < vertices; x++) {
                directedGraph[x][0] = x; //vertice number
                for (int y = 1; y < vertices; y++) {
                    directedGraph[x][y] = -1;
                }
            }
            while ((str = obj.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(str, " ");
                int token1 = Integer.parseInt(st.nextToken());
                int token2 = Integer.parseInt(st.nextToken());
                for (int z = 1; z < vertices; z++) {
                    if (directedGraph[token1][z] == -1) {
                        directedGraph[token1][z] = token2;
                        break;

                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void printAdjList(int vertices) {
        createAdjList(vertices);
        for (int x = 0; x < vertices; x++) {
            System.out.print(directedGraph[x][0] + "--> ");
            for (int y = 1; y < vertices; y++) {
                if (directedGraph[x][y] > -1) {
                    System.out.print(directedGraph[x][y] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void printOutDegree(int vertices) {
        createAdjList(vertices);
        int count;
        for (int x = 0; x < vertices; x++) {
            count = 0;
            System.out.print(directedGraph[x][0] + "--> ");
            for (int y = 1; y < vertices; y++) {
                if (directedGraph[x][y] > -1) {
                    count++;
                }
            }
            System.out.print(count);
            System.out.println();
        }

    }

    public static void printInDegree(int vertices) {
        createAdjList(vertices);
        int count;
        for (int x = 0; x < vertices; x++) {
            count = 0;
            System.out.print(directedGraph[x][0] + "--> ");
            for (int y = 0; y < vertices; y++) {
                for (int z = 1; z < vertices; z++) {
                    if (directedGraph[y][z] == x) {
                        count++;
                        break;
                    }
                }
            }

            System.out.print(count);

            System.out.println();
        }

    }
}
