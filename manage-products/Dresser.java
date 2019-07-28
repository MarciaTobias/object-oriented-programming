package Week5Ex2;

public class Dresser extends Furniture {

	private Dimensions dimensions;
	
	// Declaration of serialVersionUID
	private static final long serialVersionUID = 1L; 

	/* Constructor */
	public Dresser(String id, String n, double p, int q, double w, double h, double t) {
		super(id, n, p, q);
		this.dimensions = new Dimensions(w, h, t);
	}
	
	/* Return dimensions of the item */
	public Dimensions getDimensions() {
		return dimensions;
	}
	
	/* Set dimensions of the item */
	public void setDimensions(double w, double h, double t) {
		this.dimensions = new Dimensions(w, h, t);
	}
	
	@Override
	public void display() {
		super.display();
		System.out.println("\tDimensions");
		System.out.println("\tWide: " + this.dimensions.getWide() + " cm");
		System.out.println("\tDeep: " + this.dimensions.getDeep() + " cm");
		System.out.println("\tTall: " + this.dimensions.getTall() + " cm");
	}
}
