/** @author marcia.tobias */

package Week5Ex2;

@SuppressWarnings("serial")
public class Kitchenware extends Product implements Taxable {

	private String material;

	/* Constructor */
	public Kitchenware(String id, String n, double p, int q, String m) {
		super(id, n, p, q);
		material = m;
	}
	
	/* Return the material of the item */
	public String getMaterial() {
		return material;
	}
	
	/* Return the tax of the item */
	public double taxReturn() {

		double taxRate = dRate; // 12% default tax
		if (material != null && material.equals("plastic")) { 
			taxRate += pRate; // 5% more if the product has plastic material
		}
		return taxRate;
	}
	
	/* Method to display details about a product */
	public void display() {
		System.out.println("\n\tDepartment: Kitchenware");
		System.out.println("\tProduct ID: " + productID);
		System.out.println("\tProduct Name: " + name);
		System.out.println("\tProduct Price: " + price);
		System.out.println("\tQuantity at store: " + quantity + " item(s).");
		System.out.println("\tMaterial: " + material);
	}

}
