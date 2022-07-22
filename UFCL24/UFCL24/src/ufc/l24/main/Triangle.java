package ufc.l24.main;

/**
* Rectangle class describes Triangle objects, extends Figure class and it's methods.
* Take a look at the parent class {@link ufc.l23.main.Figure} 
* @version 17
* @author Giorgi Kharebava
*/
public class Triangle extends Figure{
	/**
	 * This variable saves the first side of Triangle object
	 */
	@SkipSerialization
	private double a;
	/**
	 * This variable saves the second side of Triangle object
	 */
	@Validator
	private double b;
	/**
	 * This variable saves the third side of Triangle object
	 */
	@Validator(min = 10, max = 50)
	private double c;
	
	/**
	 * Constructor of class Triangle
	 * @param a if for the first side
	 * @param b is for the second side
	 * @param c is for the third side
	 */
	public Triangle(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
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
     * <p>This method is for calculating perimeter</p>
     * @return Returns the perimeter of Triangle
     */
	@Override
	public double getLength() {
		return a + b + c;
	}
	
	/**
	 * This method is for calculating Area for Triangle
	 * @return Returns amount of area of Triangle
	 */
	@Override
	public double getArea() {
		double z = getLength() / 2;
        return Math.sqrt(z * (z-a) * (z-b) * (z-c));

	}
	
	/**
     * <p>This method checks validation for Triangle</p>
     * @return Returns the boolean, which tells if validation is successfull or not
     */
	@Validator
	public boolean checkValidation() {
		if((a + b > c && a + c > b && b + c > a) && (a > 0 && b > 0 && c > 0)) {
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
		return ((Double)a).hashCode() + ((Double)b).hashCode() + ((Double)c).hashCode();
	}
	
	/**
	 * Overrides toString method 
	 * @return Returns all the information about Triangle object 
	 * @since 1.0
	 */
	@Override
	public String toString() {
		return "a: " + a + " b: " + b + " c: " + c + " Perimeter: " + getLength();
	}
	
}
