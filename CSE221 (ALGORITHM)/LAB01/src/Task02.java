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

public class Task02 {

    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("input.txt");
        int i;
        while ((i = fr.read()) != -1) {
            System.out.print((char) i);
        }
    }
}
