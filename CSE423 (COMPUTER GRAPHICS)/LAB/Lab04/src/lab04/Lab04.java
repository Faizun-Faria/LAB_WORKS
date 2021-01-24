package lab04;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;

public class Lab04 implements GLEventListener{

    private GLU glu;
    
    @Override
    public void init(GLAutoDrawable gld) {
       GL2 gl = gld.getGL().getGL2();
       glu = new GLU();
       gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
       gl.glViewport(-100, -100, 100, 100);
       gl.glMatrixMode(GL2.GL_PROJECTION);
       gl.glLoadIdentity();
       glu.gluOrtho2D(-100.0, 100.0, -100.0, 100.0);
    }
    @Override
    public void dispose(GLAutoDrawable glad) {
        // Method body 
    }
    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
        //Method body
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        
        drawCircle(gl,-20,40,10);
        drawCircle(gl,-10,48,10);
        drawCircle(gl,0,50,10);
        drawCircle(gl,10,48,10);
        drawCircle(gl,20,40,10);
        drawCircle(gl,24,30,10);
        drawCircle(gl,24,20,10);
        drawCircle(gl,20,10,10);
        drawCircle(gl,10,2,10);
        drawCircle(gl,0,0,10);
        
        drawCircle(gl,-20,-40,10);
        drawCircle(gl,-10,-48,10);
        drawCircle(gl,0,-50,10);
        drawCircle(gl,10,-48,10);
        drawCircle(gl,20,-40,10);
        drawCircle(gl,24,-30,10);
        drawCircle(gl,24,-20,10);
        drawCircle(gl,20,-10,10);
        drawCircle(gl,10,-2,10);
        
    }
    
    public static void drawEightPoints(GL2 gl,int x,int y,int addx,int addy) {
        gl.glPointSize(3.0f);
        gl.glColor3d(1, 0, 0);
        gl.glBegin (GL2.GL_POINTS);//static field
        gl.glVertex3f((float)(x+addx),(float)(y+addy),0);
        gl.glVertex3f((float)(x+addy),(float)(y+addx),0);
        gl.glVertex3f((float)(x+addy),(float)(y-addx),0);
        gl.glVertex3f((float)(x+addx),(float)(y-addy),0);
        gl.glVertex3f((float)(x-addx),(float)(y+addy),0);
        gl.glVertex3f((float)(x-addx),(float)(y-addy),0); 
        gl.glVertex3f((float)(x-addy),(float)(y+addx),0);
        gl.glVertex3f((float)(x-addy),(float)(y-addx),0); 
    }

    public void drawCircle(GL2 gl, int x, int y, int r) {
        int d = 1 - r;
        int addx = 0, addy = r;  
        drawEightPoints(gl,x, y, addx, addy);
        while(addx < addy){
            addx++;
            if (d < 0) {
                d += 2 * addx + 1;
            }else{
                addy--;
                d += 2 * (addx - addy) + 1;
            }
            drawEightPoints(gl,x, y, addx, addy);
        }
        gl.glEnd();
    }  
    
}
