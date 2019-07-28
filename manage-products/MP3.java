package Week5Ex2;

@SuppressWarnings("serial")
public class MP3 extends Eletronic implements Taxable {

	private String memorySize;

	/* Constructor */
	public MP3(String id, String n, double p, int q, String mS) {
		super(id, n, p, q);
		memorySize = mS;
	}

	/* Return the memory size of the MP3 */
	public String getMemorySize() {
		return memorySize;
	}
	
	@Override
	public void display() {
		super.display();
		System.out.println("\tMemory Size:" + memorySize);
	}
}
