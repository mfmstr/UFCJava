package ufc.l24.main;

/**
* Rectangle class describes Rectagnle objects, extends Figure class and it's methods.
* Take a look at the parent class {@link ufc.l23.main.Figure} 
* @version 17
* @author Giorgi Kharebava
*/
public class Rectangle extends Figure{
	
	
	/**
	 * This variable saves the width of rectangle
	 */
	@SkipSerialization
	private double a;
	
	/**
	 * This variable saves the length of rectangle
	 */
	@Validator(min = 1, max = 20)
	private double b;
	
	
	/**
	 * Constructor of class Rectangle
	 * @param a is for width
	 * @param b is for height
	 */
	public Rectangle(double a, double b) {
		this.a = a;
		this.b = b;
	}
	
    /**
     * @deprecated This method is old, better to use anotherMethod();
     * @since 1.4
     */
	@Deprecated(since = "1.4", forRemoval = false)
	public static double getLengthStatic(Figure f) {
		return f.getLength();
	}
	
	/**
     * <p>This method is for calculating perimeter</p>
     * @return Returns the perimeter of Rectangle
     */
	@Override
	public double getLength() {
		return (a + b) * 2;
	}
	
	
	/**
	 * This method is for calculating Area for Rectangle
	 * @return Returns amount of area of Rectangle
	 */
	@Override
	public double getArea() {
		return a*b;
	}

	/**
     * <p>This method checks validation for Rectangle</p>
     * @return Returns the boolean, which tells if validation is successfull or not
     */
	
	@Validator
	public boolean checkValidation() {
		if(a > 0 && b > 0) {
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
		return ((Double)a).hashCode() + ((Double)b).hashCode();
	}
	
	/**
	 * Overrides toString method 
	 * @return Returns all the information about Rectangle object 
	 * @since 1.0
	 */
	@Override
	public String toString() {
		return "Width: " + a +" Height: " + b + " Perimeter: " + getLength();
	}
}
