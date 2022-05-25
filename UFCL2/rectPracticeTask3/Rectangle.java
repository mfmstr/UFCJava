package rectPracticeTask3;

public class Rectangle {
	
	private double width;
	private double height;
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getWidth() {
		return width;
	}
	
	public double getHeight() {
		return height;
	}
	

	public static void main(String[] args) {
		
		Rectangle obj;
		
		// System.out.println(obj.getWidth()); --> Output: The local variable obj may not have been initialized;
		
		obj = new Rectangle();
		
		// System.out.println(obj.getWidth()); --> Output: 0.0;(Without Setter);
		
		obj = null;
		
		obj = new Rectangle();
		
		// System.out.println(obj.getWidth()); --> Output: NullPointerException;
		
		Rectangle obj2 = new Rectangle();
		
//		if(obj == obj2) {
//			System.out.println("==");
//		}else {
//			System.out.println("!=");
//		} --> Ar udris, radgan gansxvavebul misamartebs miekutvnebian;
		
		
		obj.setHeight(10);
		obj2.setHeight(20);
		
		obj = obj2;
		
		if(obj == obj2) {
			System.out.println("==");
		}else {
			System.out.println("!=");
		} 
//		aq tolia, radgan obj gadavida obj2-is misamartze da obj2-s axla ori mimtitebeli kavs;
//		shesabamisad obj da obj2 warmoadgenen ertidaigive obieqts;
//	    toli iqneba shemdeg shemtxvevashic; 
		
		System.out.println(obj.getHeight()); // obj-s gamoakvs obj2-is Height, anu ukve tavisi;
		
		// ganvsazgvrot tavidan;
		
		obj = new Rectangle();
		obj2 = new Rectangle();
		
		obj.setHeight(10);
		obj2.setHeight(20);
		
		obj2 = obj;
		
		if(obj == obj2) {
			System.out.println("==");
		}else {
			System.out.println("!=");
		} 
		
		System.out.println(obj2.getHeight());
		
//		am shemtxvevashic tolia, tumca axla obj2-is obiekti rcheba mimtiteblis gareshe da obj-s 
//	    misamartze mkop obiekts ekoleba ori mimtitebeli obj, obj2;
//		obj2 gadavida obj-is obiektze, shesabamisad radiusic msgavsi akvs;
		
//  	axla gamovidzaxot setter romelime objectze da davrwmundet rom oriverstvis sheicvleba height;
		
		obj.setHeight(100);
		System.out.println(obj.getHeight());
		System.out.println(obj2.getHeight());
		
		
		// DONE!;
		
		// P.S vici rom komentars ar unda ';' boloshi;
		
	}

}

