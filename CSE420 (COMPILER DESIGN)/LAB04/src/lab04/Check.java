package lab04;
import java.util.Stack;
import java.util.StringTokenizer;
public class Check extends LAB04{
    
    Stack<String> keywords = new Stack<>();
    public void keywords(String s){
        for(int i =0; i<returnType.length;i++){
            if(s.equals(returnType[i])) keywords.add(returnType[i]);
        }
    }
    public Boolean methodStart(String s, int l, int m){
        String methodName=s;
        Boolean f = false;
        if(s.endsWith("(")){
            String strn= st.nextToken();
            if(!strn.endsWith("(")){
                f= true;
                methodName+=strn;
                for(int i=l+3; i<=m ;i++){
                    methodName+=st.nextToken();
                }
                printM(methodName);
                System.out.println();
                System.out.print("Return Type: ");  
                System.out.println(keywords.peek());
            }else {
                 f= true;
                 methodName = strn;
                for(int i=l+3; i<=m ;i++){
                    methodName+=st.nextToken();
                }
                if(methodName.contains(".")){
                    StringTokenizer str = new StringTokenizer(methodName, ".");
                    methodName = str.nextToken();
                    methodName = str.nextToken();
                }
                printM(methodName);
                System.out.println();
                System.out.print("Return Type: ");  
                System.out.println(keywords.peek());
            }
            
        }
         return f;   
     }
    public void printM(String ss){
        System.out.println(ss);
    }
}
    

