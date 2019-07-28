/** @author marcia.tobias */

package Week5Ex2;

import java.io.Serializable;

// Serialization mechanism to automate the process of storing objects and arrays.
public abstract class Product implements Serializable {

	// Declaration of serialVersionUID
	private static final long serialVersionUID = -879687890784248218L;

	// Attributes
	public String productID;
	public String name;
	public double price;
	public int quantity;

	/* Constructor with the given attributes */
	public Product(String id, String n, double p, int q) {
		productID = id;
		name = n;
		price = p;
		quantity = q;
	}

	/* Return the productId of the item */
	public String getProductID() {
		return productID;
	}

	/* Return the name of the item */
	public String getName() {
		return name;
	}

	/* Return the price of the item */
	public double getPrice() {
		return price;
	}

	/* Setter of quantity */
	public void setQuantity(int q) {
		quantity = q;
	}

	/* Return the quantity of the item */
	public int getQuantity() {
		return quantity;
	}

	/* Method to set the new quantity after buy */
	public void buyProduct(String productID, int quantity) {
		int p = getQuantity() - quantity;
		setQuantity(p);
	}
	
	/* Method to display details about a product */
	abstract void display();
}
