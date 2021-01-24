/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Faizun
 */
public class SortTest{
    public static void main(String [] args){
        int [] array = {3, 5 , 10, 23, 25, 8, 7, 9, 50, 47};
        long time1;
        long time2;
        long time;
        time1= System.nanoTime();
        MergeSort m = new MergeSort(array);
        System.out.print("Before sorting: ");
        System.out.println(m.toString());
        m.mergeSort();
        System.out.print("After merge sort: ");
        System.out.println(m.toString());
        time2= System.nanoTime();
        time = time2- time1;
        System.out.println("Run time for merge sort : "+time);
        System.out.println("------------------------------------------------");
        time1= System.nanoTime();
        InsertionSort i = new InsertionSort(array);
        System.out.print("Before sorting: ");
        System.out.println(i.toString());
        i.insertionSort();
        System.out.print("After insertion sort: ");
        System.out.println(i.toString());
        time2= System.nanoTime();
        time = time2- time1;
        System.out.println("Run time for insertion sort : "+time);
        System.out.println("------------------------------------------------");
     
        
        
        time1=System.nanoTime();
        HeapSort h = new HeapSort(array);
        System.out.print("Before sorting: ");
        System.out.println(h.toString(array));
        h.buildHeap();
        h.buildMinHeap();
        h.extractMin();
        System.out.print("After heap sort: ");
        System.out.println(h.toString());
        time2= System.nanoTime();
        time = time2- time1;
        System.out.println("Run time for heap sort : "+time);
        System.out.println("------------------------------------------------");
    
           time1 = System.nanoTime();
        QuickSort q = new QuickSort(array);
        System.out.print("Before sorting: ");
        System.out.println(q.toString(array));
        q.quickSort(array, 0, array.length - 1);
        System.out.print("After quick sort: ");
        System.out.println(q.toString());
        time2 =System.nanoTime();
        time = time2 - time1;
        System.out.println("Run time for quick sort : " + time);
        System.out.println("------------------------------------------------");
    
    
    }
}