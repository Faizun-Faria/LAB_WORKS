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
import java.util.*;

public class Task03 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Directed dGraph = new Directed();
        Undirected udGraph = new Undirected();
        System.out.println("Is it an undirected graph or directed?");
        String UndirectedOrDirected = sc.nextLine();
        if (UndirectedOrDirected.equals("directed") || UndirectedOrDirected.equals("Directed")) {
            BufferedReader obj = null;
            try {
                String str;
                FileReader fr = new FileReader("input.txt");
                obj = new BufferedReader(fr);
                str = obj.readLine();
                int vertices;
                vertices = Integer.parseInt(str);
                System.out.println("Printing adjacency matrix of a directed graph");
                dGraph.printAdjMatrix(vertices);
                System.out.println("Printing adjacency list of a directed graph");
                dGraph.printAdjList(vertices);
                System.out.println("Printing out degree of a directed graph");
                dGraph.printOutDegree(vertices);
                System.out.println("Printing in degree of a directed graph");
                dGraph.printInDegree(vertices);
            } catch (IOException e) {

                e.printStackTrace();

            }

        } else if (UndirectedOrDirected.equals("undirected") || UndirectedOrDirected.equals("Undirected")) {
            BufferedReader obj = null;
            try {
                String str;
                FileReader fr = new FileReader("input.txt");
                obj = new BufferedReader(fr);
                str = obj.readLine();
                int vertices;
                vertices = Integer.parseInt(str);
                System.out.println("Printing adjacency matrix of an undirected graph");
                udGraph.printAdjMatrix(vertices);
                System.out.println("Printing adjacency list of an undirected graph");
                udGraph.printAdjList(vertices);
                System.out.println("Printing out degree of an undirected graph");
                udGraph.printOutDegree(vertices);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
