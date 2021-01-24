public class BubbleSort{
  public static void main(String [] args){
    int [] arr = {5,4,3,6,7,1,2,8,1};
    int min;
    for (int m=1;m<arr.length;m++){
      for (int k=1;k<arr.length;k++){
        if(arr[k]<arr[k-1]){
          min = arr[k];
          arr[k] = arr[k-1];
          arr[k-1] = min;
        }
      }
    }
    for(int x=0; x<arr.length; x++){
      System.out.print(arr[x]+" ");
    } 
  }
}
