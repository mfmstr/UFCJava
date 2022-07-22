package ufc.l24.main;

/**
* Figure is parent class of Rectangle, Circle and Triangle
* @author Giorgi Kharebava
* @version this project with all classes are written in JAVA 17
*/

@CustomStringSerializable
public abstract class Figure{
	
	/**
	 * This method is for calculating Perimeter, which is overriden in child classes
	 * @return Returns perimeter of figure and it's child classes
	 */
	public abstract double getLength();
	
	/**
	 * This method is for calculating Area, which is overriden in child classes
	 * @return Returns Area of figure and it's child classes
	 */
	public abstract double getArea();

}
