package Week5Ex2;

@SuppressWarnings("serial")
public class Furniture extends Product {

	/* Constructor */
	public Furniture(String id, String n, double p, int q) {
		super(id, n, p, q);
	}
	
	/* Method to display details about a product */
	public void display() {
		System.out.println("\n\tDepartment: Furniture");
		System.out.println("\tProduct ID: " + productID);
		System.out.println("\tProduct Name: " + name);
		System.out.println("\tProduct Price: " + price);
		System.out.println("\tQuantity at store: " + quantity + " item(s).\n");
	}
}
