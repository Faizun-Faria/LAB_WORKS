
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
public class MergeSort{
    //this array will be sorted afterwards
    int [] array;
    //this is the constructor which is coping the array from the SortTest class
    public MergeSort(int [] arr){
        array = new int[arr.length];
        for(int x=0; x<arr.length; x++){
            array[x] = arr[x];
        }
    }
    
    public void mergeSort(){
        mergeSort(array);
    }
    //even though the name of this method is mergeSort, no sorting will be done within this method
    //eventually this method is breaking down the whole array into pieces
    //this method works with the left elements first and gradually goes towards right
    public void mergeSort(int [] arrayM){
        if(arrayM.length<2) return;
        else{
            int middlePoint = arrayM.length/2;
            int [] leftArray = new int[middlePoint];
            for(int x=0; x<leftArray.length; x++){
                leftArray[x] = arrayM[x];
            }
            int [] rightArray = new int[arrayM.length-middlePoint];
            for(int x=0; x<rightArray.length; x++){
                rightArray[x] = arrayM[leftArray.length+x];
            }
            mergeSort(leftArray);
            mergeSort(rightArray);
            merge(leftArray, rightArray,arrayM );
        }
    }
    //this method is for merging two arrays
    public void merge(int [] lArray,int [] rArray, int [] ar){
        /*Here I'm using i, j and k to keep the record of index number of leftArray, 
         * rightArray and arrayM respectively*/
        int i =0; 
        int j=0;
        int k =0;
        while((i<lArray.length)&&(j<rArray.length)){
            if(lArray[i]>rArray[j]){
                ar[k] = rArray[j];
                j++;
                k++;
            }else{
                ar[k] = lArray[i];
                i++;
                k++;
            }
        }
        if((i==lArray.length)||(j==rArray.length)){
            if(i==lArray.length){
                while(j<rArray.length){
                    ar[k]= rArray[j];
                    j++;
                    k++;
                }
            }
            else if(j==rArray.length){
                while(i<lArray.length){
                    ar[k]= lArray[i];
                    i++;
                    k++;
                }
            }
        }
    }
    public String toString() {
        return Arrays.toString(array);
    }
    
}