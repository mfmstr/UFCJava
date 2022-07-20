package ufc.l23.main;

/**
* Cicle class describes circle objects, extends Figure class and it's methods.
* Take a look at the parent class {@link ufc.l23.main.Figure} 
* @version 17
* @author Giorgi Kharebava
*/
public class Circle extends Figure{
	
	/**
	 * This variable saves the radius of Circle
	 */
	private double radius;
	
	/**
	 * Constructor of class Circle
	 * @param radius is for radius
	 */
	public Circle(double radius) {
		this.radius = radius;
	}
	
	/**
     * @deprecated This method is old, better to use anotherMethod();
     * @since 1.4
     */
	@Deprecated(since = "1.4", forRemoval = true)
	public static double getLengthStatic(Figure f) {
		return f.getLength();
	}

	/**
     * <p>This method is for calculating Length</p>
     * @return Returns the perimeter of Circle
     */
	@Override
	public double getLength() {
		return 2 * Math.PI * radius;
	}
	
	/**
	 * This method is for calculating Area for Circle
	 * @return Returns amount of area of Circle
	 */
	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}
	
	
	/**
     * <p>This method checks validation for Circle</p>
     * @return Returns the boolean, which tells if validation is successfull or not
     */
	public boolean checkValidation() {
		if(radius > 0) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * Overrides hashcode 
	 * @return returns unique hashcode for the different values
	 */
	@Override
	public int hashCode() {
		return ((Double)radius).hashCode();
	}
	
	/**
	 * Overrides toString method 
	 * @return Returns all the information about Circle object 
	 * @since 1.0
	 */
	@Override
	public String toString() {
		return "Radius: " + radius + " Perimeter: " + getLength();
	}
	
	
	

}
