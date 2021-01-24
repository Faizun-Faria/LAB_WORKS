package lab01;
import java.util.regex.*;
/**
 *
 * @author 17201003
 */
public class Check extends Lab01{
    
    public void keywords(String s){
        for(int i =0; i<k.length;i++){
            if((s.equals(k[i]))&&(!keywords.contains(k[i]))) keywords.add(k[i]);
        }
    }
    
    public void identifiers(String s){
        Pattern p = Pattern.compile("[a-zA-Z][a-zA-Z0-9]*");
        Matcher mat =p.matcher(s);
        if(mat.find()){
            String s1 = mat.group();
            if((!keywords.contains(s1))&&(!identifiers.contains(s1))){
                identifiers.add(s1);
            }
        }
    }
    
    public void mathOperators(String s){
       for(int i =0; i< m.length;i++){
            if((s.equals(m[i]))&&(!mathOperators.contains(m[i]))) mathOperators.add(m[i]);
        }     
    }
    
    public void logicalOperators(String s){
        for(int i =0; i< l.length;i++){
            if((s.equals(l[i]))&&(!logicalOperators.contains(l[i]))) logicalOperators.add(l[i]);
        }   
    }
    
    public void numericalValues(String s){
        Pattern p = Pattern.compile("\\d+\\.?\\d*");
        Matcher mat =p.matcher(s);
        if(mat.find()){
            String s1 = mat.group();
            numericalValues.add(s1);
        }
    }
    public void others(String s){
        for(int i =0; i< o.length;i++){
            if((s.contains(o[i]))&&(!others.contains(o[i]))) others.add(o[i]);
        }
    }
    
    
}
