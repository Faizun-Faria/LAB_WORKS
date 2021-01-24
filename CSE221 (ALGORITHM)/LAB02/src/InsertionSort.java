
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Faizun
 */
public class InsertionSort {

    int[] array;

    public InsertionSort(int[] arr) {
        array = new int[arr.length];
        for (int k = 0; k < arr.length; k++) {
            array[k] = arr[k];
        }
    }

    public void insertionSort() {
        int temp = 0;
        for (int x = 1; x < array.length; x++) {
            for (int y = 0; y < x; y++) {
                if (array[x] < array[y]) {
                    temp = array[x];
                    for (int z = x; z > y; z--) {
                        array[z] = array[z - 1];
                    }
                    array[y] = temp;
                    break;
                }
            }

        }
    }

    public String toString() {
        return Arrays.toString(array);
    }
}