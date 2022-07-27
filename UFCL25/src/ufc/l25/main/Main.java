package ufc.l25.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class Message extends Thread {
    private String message;
    
    public void setMessage(String msg) {
    	message = msg;
    }

    public Message(String message) {
        this.message = message;
    }

    public void run() {
        while (true) {
            System.out.println(message);
            try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
}


class ThreadCircle extends Thread {
	   
    public void run() {
    	try(BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src\\Circles_in.dat")));){
    			for(int i = 0; i < 70000; i++) {
    				out.write(String.valueOf(Math.round((Math.random() * 100))));
    				out.write('-');
    			}
    		}catch(IOException e) {
    			
    		}
    }
}

class ThreadRect extends Thread {
   
    public void run() {
    	try(BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src\\Rectangles_in.dat")));){
			for(int i = 0; i < 70000; i++) {
				out.write(String.valueOf(Math.round((Math.random() * 100))));
				out.write('-');
				out.write(String.valueOf(Math.round((Math.random() * 100))));
				out.write(System.lineSeparator());
			}
		}catch(IOException e) {
			
		}
    }
}

class ThreadTriangle extends Thread {
	public void run() {
		try(BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src\\Triangles_in.dat")));){
			for(int i = 0; i < 70000; i++) {
				out.write(String.valueOf(Math.round((Math.random() * 100))));
				out.write('-');
				out.write(String.valueOf(Math.round((Math.random() * 100))));
				out.write('-');
				out.write(String.valueOf(Math.round((Math.random() * 100))));
				out.write(System.lineSeparator());
			}
		}catch(IOException e) {
			
		}
	}
}

class ThreadCircleOut extends Thread {
	   
    public void run() {
    	try(BufferedReader xbf = new BufferedReader(new InputStreamReader(new FileInputStream("src\\Circles_in.dat"), "UTF-8"));
    			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src\\Circles_out.dat")));){
    			String readLn = xbf.readLine();
    			String[] cir = readLn.split("-");

    			for(int i = 0; i < cir.length; i++) {
    				if(new Circle(Integer.valueOf(cir[i])).checkValidation()) {
    				out.write(cir[i]);
    				out.write('#');
    				}
    			}
    		}catch(IOException e) {
    			System.err.println("Failis wakitxvisas an failshi chawerisas dapiksirda shecdoma.");
    		}
    }
}

class ThreadRectangleOut extends Thread {
    public void run() {
    	try(BufferedReader xbf = new BufferedReader(new InputStreamReader(new FileInputStream("src\\Rectangles_in.dat"), "UTF-8"));
    			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src\\Rectangles_out.dat")));){
    			String readLine = xbf.readLine();
    			
    			while(readLine != null) {
    				String splited[] = readLine.split("-");
    				Rectangle x = new Rectangle(Double.valueOf(splited[0]), Double.valueOf(splited[1]));
    				if(x.checkValidation()) {
    					out.write(String.valueOf(x.getA()));
    					out.write('#');
    					out.write(String.valueOf(x.getB()));
    					out.write(System.lineSeparator());
    				}
    				readLine = xbf.readLine();
    			}		
    			
    			
    		}catch(IOException e) {
    			System.err.println("Failis wakitxvisas an failshi chawerisas dapiksirda shecdoma.");
    		}
    }
}

class ThreadTriangleOut extends Thread {
	   
    public void run() {
    	try(BufferedReader xbf = new BufferedReader(new InputStreamReader(new FileInputStream("src\\Triangles_in.dat"), "UTF-8"));
    			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src\\Triangles_out.dat")));){
    			String readLn = xbf.readLine();
    			 
    			
    			while(readLn != null) {
    				String splited[] = readLn.split("-");
    				Triangle x = new Triangle(Double.valueOf(splited[0]), Double.valueOf(splited[1]), Double.valueOf(splited[2]));
    				if(x.checkValidation()) {
    					out.write(String.valueOf(x.getA()));
    					out.write('#');
    					out.write(String.valueOf(x.getB()));
    					out.write('#');
    					out.write(String.valueOf(x.getC()));
    					out.write(System.lineSeparator());
    					
    				}
    				readLn = xbf.readLine();
    			}		
    			
    		}catch(IOException e) {
    			System.err.println("Failis wakitxvisas an failshi chawerisas dapiksirda shecdoma.");
    		}	
}
}

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		
		ThreadCircle c = new ThreadCircle();
		ThreadRect r = new ThreadRect();
		ThreadTriangle t = new ThreadTriangle();
		Message x = new Message("generating in files");
		x.setDaemon(true);
		x.start();
		c.start();
		r.start();
		t.start();
		
		c.join();
		r.join();
		t.join();
		
		x.setMessage("generating out files");
		ThreadCircleOut cOut = new ThreadCircleOut();
		ThreadRectangleOut rOut = new ThreadRectangleOut();
		ThreadTriangleOut tOut = new ThreadTriangleOut();
		
		cOut.start();
		rOut.start();
		tOut.start();
		
	}
	
		
}

