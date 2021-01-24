import java.util.*;
public class Tabulation {
    
    static StringTokenizer st;
    static String str1;
    static String str2;
    static String str;
    static String underscore = "_";
    static int totalNumberOfChanges=1;
    
    static Queue<String> binaryQueue = new LinkedList<String>();
    static Queue<String> unpickedBinaryQueue = new LinkedList<String>();
    
    static String[] binaryArr;
    static int size;
    static String [] primeImplicantsBinary;
    static String [] primeImplicants;
    static String [] letters  = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p"};
    
    public static void main(String[] args) {
        input();
        while(totalNumberOfChanges!=0){
            compare();
        }
        primeImplicants();
        print();
    }
    
    //I am taking inputs here
    //I am saving the minterms into two arrays - one array for saving decimal value and 
    //another one for binary value
    public static void input(){
        int numberOfVariables;
        String minterms;
        int numberOfMinterms;
        int[] mintermsDecimal;
        String[] mintermsBinary;
        Scanner sc = new Scanner(System.in);
        numberOfVariables = sc.nextInt();
        sc.nextLine();
        minterms = sc.nextLine();
        st = new StringTokenizer(minterms);
        numberOfMinterms = st.countTokens();
        mintermsDecimal = new int [numberOfMinterms];
        mintermsBinary = new String [numberOfMinterms];
        String[] temp;        
        temp = new String [numberOfMinterms];
        int x;
        for(int i = 0; i<numberOfMinterms; i++){
            temp[i] = st.nextToken();
            x = Integer.valueOf(temp [i]);
            mintermsDecimal[i] = x;
            mintermsBinary [i] = Integer.toBinaryString(x);
            if (mintermsBinary [i].length()<numberOfVariables){
                x= numberOfVariables - mintermsBinary [i].length(); 
                for(int j=0;j<x;j++){
                    mintermsBinary [i]="0"+mintermsBinary [i];
                }
            }
        }
        toBinaryArr(mintermsBinary,numberOfMinterms); 
    }
    public static int bitDifference(String str1, String str2){
        int counter=0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                counter++; 
            }
        }
        return counter;
    }
    //Here I am comparing two numbers bit difference taking help from another method. Then, if one bit difference found, I am converting the corresponding 
    //strings into a new string e.g. 10_1 . After that I am adding the binary string  10_1 into a queue.At the same time I am adding the corresponding 
    //decimal numbers into a queue as a string.
    public static void compare(){
        totalNumberOfChanges =0;
        for(int i =0; i<binaryArr.length-1; i++){
            for(int j =i+1; j<binaryArr.length; j++){
                str1 = binaryArr[i];
                str2 = binaryArr[j];
                int count = bitDifference(str1,str2);
                if (count == 1) {
                    for (int k = 0; k < str1.length(); k++) {
                        if (str1.charAt(k) != str2.charAt(k)) {
                            str = str1.substring(0, k) + underscore + str1.substring(k + 1);
                        }
                    }
                    if((unpickedBinaryQueue.contains(str1))&&(unpickedBinaryQueue.contains(str2))){
                        unpickedBinaryQueue.remove(str1);
                        unpickedBinaryQueue.remove(str2);
                    }
                    else if (unpickedBinaryQueue.contains(str2)){
                        unpickedBinaryQueue.remove(str2);
                    }else if(unpickedBinaryQueue.contains(str1)){
                        unpickedBinaryQueue.remove(str1);
                    }
                    toBinaryQueue(str);
                    totalNumberOfChanges++;
                }
            }
        }
        toBinaryArr();
    }
    //from queue to array
    public static void toBinaryArr(){
        size = binaryQueue.size();
        binaryArr = new String [size];
        for(int i=0;i<size;i++){
            binaryArr[i] = binaryQueue.remove();
        }
        toUnpickedBinary();
    }
    //from array to array
    public static void toBinaryArr(String [] arr,int s){
        size = s;
        binaryArr = new String [s];
        for(int i=0;i<s;i++){
            binaryArr[i] = arr[i];
        }
        toUnpickedBinary();
    }
    
    public static void toUnpickedBinary(){
        for(int i =0;i<size;i++){
            unpickedBinaryQueue.add(binaryArr[i]);
        }        
    }   
    public static void toBinaryQueue(String str){
        binaryQueue.add(str);
    }  
    
    public static void primeImplicants(){
        size = unpickedBinaryQueue.size();
        Queue<String> temp = new LinkedList<String>();
        for(int i =0; i<size;i++){
            String s = unpickedBinaryQueue.remove();
            if(!temp.contains(s)){
                temp.add(s);
            }
        }
        size= temp.size();
        primeImplicantsBinary = new String[size];
        primeImplicants = new String[size];
        for(int i =0; i<size;i++){
            primeImplicantsBinary[i] = temp.remove();
        }
        for(int i =0; i<size;i++){
            String str="";
            for(int j =0; j<primeImplicantsBinary[i].length();j++){
                if(primeImplicantsBinary[i].charAt(j)=='0'){
                    str+=letters[j]+"'";
                }else if(primeImplicantsBinary[i].charAt(j)=='1'){
                    str+=letters[j];
                }
            }
            primeImplicants[i] = str;
        }
    }
    public static void print(){
        System.out.println("Prime Implicants: ");
        for(int i =0; i<size;i++){
            System.out.println( primeImplicants[i]);
        }
    }  
}
//4
//0 1 3 7 8 9 11 15