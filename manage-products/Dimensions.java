package Week5Ex2;

import java.io.Serializable;

/* This class implements Serializable. This permits to take the size of dressers from Dimension Class */
public class Dimensions implements Serializable {

	private static final long serialVersionUID = 1L; // Declaration of serialVersionUID
	private double wide;
	private double deep;
	private double tall;

	/* Constructor */
	public Dimensions(double w, double d, double t) {
		wide = w;
		deep = d;
		tall = t;
	}
	
	/* Return the wide of a dresser */
	public double getWide() {
		return wide;
	}
	
	/* Return the wide of a dresser */
	public double getDeep() {
		return deep;
	}
	
	/* Return the wide of a dresser */
	public double getTall() {
		return tall;
	}
}