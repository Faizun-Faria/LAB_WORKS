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
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class DalaiLamaGraph {
    public static void main(String [] args){
        DalaiLama dl = new DalaiLama();
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the source node?");
        int source = sc.nextInt();
        BufferedReader obj= null;
        try {
            String str;
            FileReader fr = new FileReader("lab03task03.txt");
            obj = new BufferedReader(fr);
            str = obj.readLine();
            int testCase ;
            testCase = Integer.parseInt(str);
            for(int j =0; j<testCase;j++){
                str = obj.readLine();
                StringTokenizer st = new StringTokenizer(str," ");
                int t1 = Integer.parseInt(st.nextToken());
                int t2 = Integer.parseInt(st.nextToken());
                int nodes = t1;
                int edges = t2;
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
                dl.bfsMethod(adjList, source);
            }
        } catch (IOException e) {
        }
    }
}
