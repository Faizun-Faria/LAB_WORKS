package cyrusbeck;

/**
 *
 * @author Faizun
 */
public class CyrusBeck {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Cyrus Beck Algorithm");
        System.out.println();
        System.out.println();
        
        int xmin, xmax, ymin, ymax, x0, x1, y0, y1, NiD=0;
        double t=0, tE=0, tL=1;
        String boundary="", PE_PL="", Ni ="";
        xmin = -141;
        xmax = 283;
        ymin = -102;
        ymax = 131;
        x0 = -151;
        y0 = 210;
        x1 = 353;
        y1 = -145;
        
        int Dx = x1 - x0;
        int Dy = y1 - y0;
        System.out.println("P("+Dx+","+Dy+")");
        System.out.println();
        System.out.println();
        
        for (int i = 1; i<= 4; i++){
            if(i == 1){
                boundary = "Left    ";
                Ni = "(-1, 0)";
                NiD = -Dx;
                t = countT(xmin,x0,x1,x0);
            }else if(i == 2){
                boundary = "Right   ";
                Ni = "( 1, 0)";
                NiD = Dx;
                t = countT(xmax,x0,x1,x0);
            }else if(i == 4){
                boundary = "Top     ";
                Ni = "( 0, 1)";
                NiD = Dy; 
                t = countT(ymax,y0,y1,y0);
            }else if(i == 3){
                boundary = "Bottom   ";
                Ni = "( 0,-1)";
                NiD = -Dy;
                t = countT(ymin,y0,y1,y0);
            }
            PE_PL = det_PE_PL(NiD);
            tE = calculateTE(t, tE, PE_PL);
            tL = calculateTL(t, tL, PE_PL);
            print(boundary+"", Ni+"", NiD+"", t+"", PE_PL+"", tE+"", tL+"");    
        }
        System.out.println();
        calculate_p(tE, x0, x1, y0, y1);
        System.out.println();
        calculate_p(tL, x0, x1, y0, y1);
    }
    
    public static void print(String s1, String s2,String s3,String s4,String s5,String s6,String s7){
        System.out.print("Boundary = "+s1+"     ");
        System.out.print("Ni = "+s2+"     ");
        System.out.print("NiD = "+s3+"     ");
        System.out.print("t = "+s4+"     ");
        System.out.print("PE_PL = "+s5+"     ");
        System.out.print("tE = "+s6+"     ");
        System.out.print("tL = "+s7+"     ");
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
    public static String det_PE_PL(int NiD){
        if (NiD < 0)  return "PE";
        else if (NiD > 0) return "PL";
        else return "XX";
    }
    private static double countT(int a, int b, int c, int d){
        double val = 1.0*(a-b)/(c-d);
        return val;
    }


    private static double calculateTE(double t, double tE, String PE_PL) {
        if ("PE".equals(PE_PL)) tE = max(tE,t);
        return tE;
    }

    private static double calculateTL(double t, double tL, String PE_PL) {
        if ("PL".equals(PE_PL)) tL = min(tL,t);
        return tL;
    }
    private static double max(double a, double b){
        if(a>b) return a;
        else return b;
    }
    private static double min(double a, double b){
        if(a<b) return a;
        else return b;
    }

    private static void calculate_p(double t, int x0, int x1, int y0, int y1) {
        double x = x0+(t*(x1-x0));
        double y = y0+(t*(y1-y0));
        System.out.println("("+x+","+y+")");    
    }
    
}
