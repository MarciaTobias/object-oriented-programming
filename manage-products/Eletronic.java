package Week5Ex2;

@SuppressWarnings("serial")
public class Eletronic extends Product implements Taxable {

	/* Constructor */
	public Eletronic(String id, String n, double p, int q) {
		super(id, n, p, q);
	}

	/* Method to calculate the tax for all electronics and for TVs */
	public double taxReturn() {
		double taxRate = eRate; // 10% Electronics
		if (name != null && name.contains("TV")) {
			taxRate = tRate; // 16% TV
		}
		return taxRate;
	}

	/* Method to display details about a product */
	public void display() {
		System.out.println("\n\tDepartment: Eletronic");
		System.out.println("\tProduct ID: " + productID);
		System.out.println("\tProduct Name: " + name);
		System.out.println("\tProduct Price: " + price);
		System.out.println("\tQuantity at store: " + quantity + " item(s).");
		System.out.println("\tTax: " + (taxReturn() * 100) + "%");
	}
}
