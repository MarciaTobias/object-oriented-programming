package Week5Ex2;

@SuppressWarnings("serial")
public class TV extends Eletronic {
	
	private int displaySize;

	/* Constructor */
	public TV(String id, String n, double p, int q, int d) {
		super(id, n, p, q);
		displaySize = d;
	}
	
	/* Return the display size of the TV */
	public int getDisplaySize() {
		return displaySize;
	}
	
	@Override
	public void display() {
		super.display();
		System.out.println("\tDisplay Size: " + displaySize);
	}
}
