/** @author marcia.tobias */

package Week5Ex2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public final class Driver {

	public static ArrayList<Product> listProducts = new ArrayList<>();

	/* Method to read the file input.txt, if the binary file is not available */
	public static void readFileTxt() {
		Scanner fileIn;
		String fileName = "input.txt";

		try {
			fileIn = new Scanner(new FileReader(fileName));

			// while there is next line, read according to type of the material and save in
			// the array
			while (fileIn.hasNextLine()) {
				String line = fileIn.nextLine();
				String[] split = line.split(",");
				String department = split[0];

				// if the first word at file is Chair
				if (department.contentEquals("Chair")) {

					// Split after comma an save at the array
					Chair chair = new Chair(split[1].trim(), split[2].trim(), Double.parseDouble(split[3].trim()),
							Integer.parseInt(split[4]));
					listProducts.add(chair);
				}

				if (department.contentEquals("Dresser")) {

					Dresser dresser = new Dresser(split[1].trim(), split[2].trim(), Double.parseDouble(split[3].trim()),
							Integer.parseInt(split[4].trim()), Double.parseDouble(split[5].trim()),
							Double.parseDouble(split[6].trim()), Double.parseDouble(split[7]));
					listProducts.add(dresser);
				}

				if (department.contentEquals("Fork")) {

					Fork fork = new Fork(split[1].trim(), split[2].trim(), Double.parseDouble(split[3].trim()),
							Integer.parseInt(split[4].trim()), split[5]);
					listProducts.add(fork);
				}

				if (department.contentEquals("Keyboard")) {

					Keyboard keyboard = new Keyboard(split[1].trim(), split[2].trim(),
							Double.parseDouble(split[3].trim()), Integer.parseInt(split[4]));
					listProducts.add(keyboard);
				}

				if (department.contentEquals("Knive")) {

					Knive knive = new Knive(split[1].trim(), split[2].trim(), Double.parseDouble(split[3].trim()),
							Integer.parseInt(split[4].trim()), split[5]);
					listProducts.add(knive);
				}

				if (department.contentEquals("MobilePhone")) {

					MobilePhone mobilephone = new MobilePhone(split[1].trim(), split[2].trim(),
							Double.parseDouble(split[3].trim()), Integer.parseInt(split[4]));
					listProducts.add(mobilephone);
				}

				if (department.contentEquals("MP3")) {

					MP3 mp3 = new MP3(split[1].trim(), split[2].trim(), Double.parseDouble(split[3].trim()),
							Integer.parseInt(split[4].trim()), split[5]);
					listProducts.add(mp3);
				}

				if (department.contentEquals("Plate")) {

					Plate plate = new Plate(split[1].trim(), split[2].trim(), Double.parseDouble(split[3].trim()),
							Integer.parseInt(split[4].trim()), split[5]);
					listProducts.add(plate);
				}

				if (department.contentEquals("Spoon")) {

					Spoon spoon = new Spoon(split[1].trim(), split[2].trim(), Double.parseDouble(split[3].trim()),
							Integer.parseInt(split[4].trim()), split[5]);
					listProducts.add(spoon);
				}

				if (department.contentEquals("Table")) {

					Table table = new Table(split[1].trim(), split[2].trim(), Double.parseDouble(split[3].trim()),
							Integer.parseInt(split[4]));
					listProducts.add(table);
				}
				if (department.contentEquals("TV")) {

					TV tv = new TV(split[1].trim(), split[2].trim(), Double.parseDouble(split[3].trim()),
							Integer.parseInt(split[4].trim()), Integer.parseInt(split[5]));
					listProducts.add(tv);
				}
			}

			// Closes the file
			fileIn.close();
			fileIn = null;

		} catch (FileNotFoundException e) { // print exceptions
			System.out.println(e.getMessage());
		}
	}

	/* Method to save the stock when the option 6 , exit, had been chosen */
	public static void saveBinaryFile() throws IOException {

		try {
			FileOutputStream fileOut = new FileOutputStream("store.log");
			ObjectOutputStream os = new ObjectOutputStream(fileOut);
			//
			// For loop to write the array list at the binary file
			for (int i = 0; i < listProducts.size(); i++) {
				os.writeObject(listProducts.get(i));
			}
			// Closes the file
			fileOut.close();
			fileOut = null;

			System.out.println("Log of the day Saved");

		} catch (FileNotFoundException e) { // print exceptions
			System.out.println(e.getMessage());
		}
	}

	/* Method to read the binary file. The text file is the second option */
	public static void readBinaryFile() {

		Product product;

		try {
			// Creating the local variable to taking from the file the object and populate
			// the array list
			FileInputStream fileStream = new FileInputStream("store.log");
			ObjectInputStream os = new ObjectInputStream(fileStream);

			product = (Product) os.readObject();

			// creating the while to populate the array list
			while (product != null) {

				// Instance of guarantees if the product is of the target class in the case
				if (product instanceof Chair) {
					Chair chair = (Chair) product;
					listProducts.add(chair);
				}

				if (product instanceof Table) {
					Table table = (Table) product;
					listProducts.add(table);
				}

				if (product instanceof Dresser) {
					Dresser dresser = (Dresser) product;
					listProducts.add(dresser);
				}

				if (product instanceof Spoon) {
					Spoon spoon = (Spoon) product;
					listProducts.add(spoon);
				}

				if (product instanceof Fork) {
					Fork fork = (Fork) product;
					listProducts.add(fork);
				}

				if (product instanceof Knive) {
					Knive knife = (Knive) product;
					listProducts.add(knife);
				}

				if (product instanceof Plate) {
					Plate plate = (Plate) product;
					listProducts.add(plate);
				}

				if (product instanceof Keyboard) {
					Keyboard keyboard = (Keyboard) product;
					listProducts.add(keyboard);
				}

				if (product instanceof MobilePhone) {
					MobilePhone mobilephone = (MobilePhone) product;
					listProducts.add(mobilephone);
				}

				if (product instanceof MP3) {
					MP3 mp3player = (MP3) product;
					listProducts.add(mp3player);
				}

				if (product instanceof TV) {
					TV tvset = (TV) product;
					listProducts.add(tvset);
				}

				product = (Product) os.readObject();
			}

			fileStream.close();
			fileStream = null;

		} catch (FileNotFoundException e) { // print exceptions
			System.out.println(e.getMessage());

			// In case of the binary file is not found
			readFileTxt();

		} catch (IOException e) { // If will print a error if the list is empty
			if (listProducts.size() == 0)
				System.out.println(e.getMessage());

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	/* Method to write products were sold in the day */
	public static void writeSalesTxt(String productId, String name, int quantity, double price, double taxReturn) {

		Date date = new Date();
		StringBuilder sb = new StringBuilder();

		try {
			PrintWriter fileOut = new PrintWriter(new FileWriter("sales.txt", true));

			sb.append(date.toString());
			sb.append(" - Product ID: " + productId);
			sb.append(" - Product Name: " + name);
			sb.append(" - Quantity: " + quantity);
			sb.append(" - Unit price: " + price);
			sb.append(" - SubTotal: " + (quantity * price));
			sb.append(" - Total " + taxReturn);
			sb.append(" - Total Price: " + ((price * quantity) + taxReturn));

			fileOut.println(sb.toString());

			fileOut.close();

		} // end try

		catch (IOException e) {
			e.printStackTrace();
		} // closing catch
	}

	public static void add() throws Exception {
		readFileTxt();
		//readBinaryFile();
	}

	public static void main(String[] args) throws Exception {

		Driver.add();
		int choice = 0; // inicialize the variable

		do { // it will run this part until the user choose the option to exit the program

			System.out.println("\n\t===========================================");
			System.out.println("\t|               LOZZBY.COM                |");
			System.out.println("\t===========================================");
			System.out.println("\t|                                         |");
			System.out.println("\t| 1. BUY PRODUCT                          |");
			System.out.println("\t| 2. CHECK IF THE PRODUCT IS IN STOCK     |");
			System.out.println("\t| 3. RESTOCK                              |");
			System.out.println("\t| 4. DISPLAY PRODUCT DETAILS              |");
			System.out.println("\t| 5. CALCULATE TAX RETURN                 |");
			System.out.println("\t| 6. EXIT                                 |");
			System.out.println("\t===========================================\n");

			System.out.print("Choose a option from the Menu: ");

			// Try catch block, if the user write something different than the options from
			// the menu above
			try {
				@SuppressWarnings("resource")
				Scanner selecInput = new Scanner(System.in); // permits the user insert the data
				choice = selecInput.nextInt(); // options from the menu

				switch (choice) { // switch case to choose the options from the menu

				case 1:

					// Print the list of products with productID, name and type
					System.out.print("\n====================================================");
					System.out.println("\nProductID\t\bName\t\t\tDepartment ");
					System.out.print("====================================================\n");
					System.out.println("F011\t\tChair Stefan\t\tFurniture");
					System.out.println("F012\t\tChair Tobias\t\tFurniture");
					System.out.println("F013\t\tTable Paris\t\tFurniture");
					System.out.println("F014\t\tTable Sunsine\t\tFurniture");
					System.out.println("F015\t\tDresser Primark\t\tFurniture");
					System.out.println("F016\t\tDresser Sorela\t\tFurniture");
					System.out.println("K017\t\tSpoon Stella\t\tKitchenware");
					System.out.println("K018\t\tSpoon Morocco\t\tKitchenware");
					System.out.println("K019\t\tFork Stella\t\tKitchenware");
					System.out.println("K020\t\tFork Morocco\t\tKitchenware");
					System.out.println("K021\t\tKnive Stella\t\tKitchenware");
					System.out.println("K022\t\tKnive Morocco\t\tKitchenware");
					System.out.println("K023\t\tPlate Stella\t\tKitchenware");
					System.out.println("K024\t\tPlate Morocco\t\tKitchenware");
					System.out.println("E025\t\tTV Blue Sky\t\tEletronic");
					System.out.println("E026\t\tTV Gradiente\t\tEletronic");
					System.out.println("E027\t\tMP3 Bush\t\tEletronic");
					System.out.println("E028\t\tMP3 Sony\t\tEletronic");
					System.out.println("E029\t\tApple Phone X\t\tEletronic");
					System.out.println("E030\t\tSamasung S10\t\tEletronic");
					System.out.println("E031\t\tKeyboard HP4\t\tEletronic");
					System.out.println("E032\t\tKeyboard Mac\t\tEletronic");

					Scanner sc1 = new Scanner(System.in);
					System.out.print("\nEnter the ProductID: ");
					String userProductID = sc1.nextLine(); // save the productId from the user
					for (int i = 0; i < listProducts.size(); i++) {

						// if the prodcutID from the user is the same as the productID
						if ((userProductID != null && listProducts.get(i).productID.equalsIgnoreCase(userProductID))) {

							// Declaration of variables to permit to use the method writeSalesTxt()
							String productID = listProducts.get(i).getProductID();
							String name = listProducts.get(i).getName();
							double price = listProducts.get(i).getPrice();
							double totalPrice = 0;

							// it will show the name of the product and quantity available in the store
							System.out.println("\n\tProduct Name: " + name);
							System.out.println(
									"\tQuantity at store: " + listProducts.get(i).getQuantity() + " item(s).\n");

							// it will run the if statement just if there is product at stock
							if (listProducts.get(i).getQuantity() > 0) {

								@SuppressWarnings("resource")
								Scanner sc2 = new Scanner(System.in);
								System.out.print("Enter Quantity: ");
								int userQuantity = sc2.nextInt();

								// It will prevent if the user to input a negative number
								if (userQuantity > 0) {

									// if there is quantity available at stock
									if (userQuantity <= listProducts.get(i).getQuantity()) {

										System.out.print("\n===================================================");
										System.out.println("\nProductID\t\bName\t\tQt.\tPrice Unit");
										System.out.print("===================================================\n");
										System.out.print(productID);
										System.out.print("\t\t" + name);
										System.out.print("\t" + userQuantity);
										System.out.print("\t\b" + price);

										// If the product has tax, will calculate the tax for one or multiple quantities
										// and the price without and with tax
										if (listProducts.get(i) instanceof Taxable) {

											// It will update the quantity of the product in the stock, using the method
											// buy product from the driver

											listProducts.get(i).buyProduct(userProductID, userQuantity);

											double tax = ((Taxable) listProducts.get(i)).taxReturn();
											double quantityTax = userQuantity * tax;

											price = listProducts.get(i).getPrice();
											double quantity = listProducts.get(i).getQuantity();
											double subPrice = price * userQuantity;

											double totalTax = subPrice * tax;
											totalPrice = subPrice + totalTax;

											System.out.printf("\n\nSub Total: " + "$%.2f\t", subPrice);
											System.out.printf("\nTotal Tax: " + "$%.2f\t", totalTax);
											System.out.printf("\nTotal Price: " + "$%.2f\t", totalPrice);

										} else { // It will calculate the price when the product is zero tax

											// It will update the quantity of the product in the stock, using the method
											// buy product from the driver
											listProducts.get(i).buyProduct(userProductID, userQuantity);

											price = listProducts.get(i).getPrice();
											double quantity = listProducts.get(i).getQuantity();
											totalPrice = price * quantity;

											System.out.println("\n\nTotal tax: $0.00");
											System.out.printf("Total Price: " + "$%.2f\t", totalPrice);

										}
										// String productId, String name, int quantity, double price, double taxReturn
										writeSalesTxt(productID, name, userQuantity, price, userQuantity);
										System.out.println(
												"\n\n\tYour purchase was successful!\n\n\n\t*** Thanks to buy with LoozBy ***");
									}

								} else {
									System.out.println("\n\t--> Product not available at stock");
								}

							} else {
								System.out.println("\t--> Choose another item.\n\tProduct not available at stock.");
							}
						}
					}

					break;

				case 2: // Check if the product is in stock

					// Print the list of products with productID, name and type
					System.out.print("\n====================================================");
					System.out.println("\nProductID\t\bName\t\t\tDepartment ");
					System.out.print("====================================================\n");
					System.out.println("F011\t\tChair Stefan\t\tFurniture");
					System.out.println("F012\t\tChair Tobias\t\tFurniture");
					System.out.println("F013\t\tTable Paris\t\tFurniture");
					System.out.println("F014\t\tTable Sunsine\t\tFurniture");
					System.out.println("F015\t\tDresser Primark\t\tFurniture");
					System.out.println("F016\t\tDresser Sorela\t\tFurniture");
					System.out.println("K017\t\tSpoon Stella\t\tKitchenware");
					System.out.println("K018\t\tSpoon Morocco\t\tKitchenware");
					System.out.println("K019\t\tFork Stella\t\tKitchenware");
					System.out.println("K020\t\tFork Morocco\t\tKitchenware");
					System.out.println("K021\t\tKnive Stella\t\tKitchenware");
					System.out.println("K022\t\tKnive Morocco\t\tKitchenware");
					System.out.println("K023\t\tPlate Stella\t\tKitchenware");
					System.out.println("K024\t\tPlate Morocco\t\tKitchenware");
					System.out.println("E025\t\tTV Blue Sky\t\tEletronic");
					System.out.println("E026\t\tTV Gradiente\t\tEletronic");
					System.out.println("E027\t\tMP3 Bush\t\tEletronic");
					System.out.println("E028\t\tMP3 Sony\t\tEletronic");
					System.out.println("E029\t\tApple Phone X\t\tEletronic");
					System.out.println("E030\t\tSamasung S10\t\tEletronic");
					System.out.println("E031\t\tKeyboard HP4\t\tEletronic");
					System.out.println("E032\t\tKeyboard Mac\t\tEletronic");

					Scanner sc3 = new Scanner(System.in);
					System.out.print("\nEnter the ProductID: ");
					userProductID = sc3.nextLine(); // save the productId from the user

					for (int i = 0; i < listProducts.size(); i++) { // for loop to check at the array

						if ((userProductID != null && listProducts.get(i).productID.equalsIgnoreCase(userProductID))) {

							// it will print name and quantity of the product
							System.out.println("\n\tProduct Name: " + listProducts.get(i).getName());
							System.out.println(
									"\tQuantity at store: " + listProducts.get(i).getQuantity() + " item(s).\n");
						}
					}
					break;

				case 3: // Restock

					// Print the list of products with productID, name and type
					System.out.print("\n====================================================");
					System.out.println("\nProductID\t\bName\t\t\tDepartment ");
					System.out.print("====================================================\n");
					System.out.println("F011\t\tChair Stefan\t\tFurniture");
					System.out.println("F012\t\tChair Tobias\t\tFurniture");
					System.out.println("F013\t\tTable Paris\t\tFurniture");
					System.out.println("F014\t\tTable Sunsine\t\tFurniture");
					System.out.println("F015\t\tDresser Primark\t\tFurniture");
					System.out.println("F016\t\tDresser Sorela\t\tFurniture");
					System.out.println("K017\t\tSpoon Stella\t\tKitchenware");
					System.out.println("K018\t\tSpoon Morocco\t\tKitchenware");
					System.out.println("K019\t\tFork Stella\t\tKitchenware");
					System.out.println("K020\t\tFork Morocco\t\tKitchenware");
					System.out.println("K021\t\tKnive Stella\t\tKitchenware");
					System.out.println("K022\t\tKnive Morocco\t\tKitchenware");
					System.out.println("K023\t\tPlate Stella\t\tKitchenware");
					System.out.println("K024\t\tPlate Morocco\t\tKitchenware");
					System.out.println("E025\t\tTV Blue Sky\t\tEletronic");
					System.out.println("E026\t\tTV Gradiente\t\tEletronic");
					System.out.println("E027\t\tMP3 Bush\t\tEletronic");
					System.out.println("E028\t\tMP3 Sony\t\tEletronic");
					System.out.println("E029\t\tApple Phone X\t\tEletronic");
					System.out.println("E030\t\tSamasung S10\t\tEletronic");
					System.out.println("E031\t\tKeyboard HP4\t\tEletronic");
					System.out.println("E032\t\tKeyboard Mac\t\tEletronic");

					Scanner sc4 = new Scanner(System.in);
					System.out.print("\nEnter the ProductID to Restok: ");
					userProductID = sc4.nextLine(); // save the productId from the user

					for (int i = 0; i < listProducts.size(); i++) { // for loop to check at the array

						if ((userProductID != null && listProducts.get(i).productID.equalsIgnoreCase(userProductID))) {

							// it will print name and quantity of the product
							System.out.println("\n\tProduct Name: " + listProducts.get(i).getName());
							System.out.println(
									"\tQuantity at store: " + listProducts.get(i).getQuantity() + " item(s).\n");

							Scanner sc9 = new Scanner(System.in);
							System.out.print("Enter Quantity: ");
							int userQuantity = sc9.nextInt();

							// It will prevent if the user to input a negative number
							if (userQuantity > 0) {

								// Set the new quantity at stock
								listProducts.get(i).setQuantity(userQuantity);
								System.out.println("Stock Updated");

								// it will print name and quantity of the product
								System.out.println("\n\tProduct Name: " + listProducts.get(i).getName());
								System.out.println(
										"\tQuantity at store: " + listProducts.get(i).getQuantity() + " item(s).\n");
							}
						}
					}

					break;

				case 4: // Display product details

					// Print the list of products with productID, name and type
					System.out.print("\n====================================================");
					System.out.println("\nProductID\t\bName\t\t\tDepartment ");
					System.out.print("====================================================\n");
					System.out.println("F011\t\tChair Stefan\t\tFurniture");
					System.out.println("F012\t\tChair Tobias\t\tFurniture");
					System.out.println("F013\t\tTable Paris\t\tFurniture");
					System.out.println("F014\t\tTable Sunsine\t\tFurniture");
					System.out.println("F015\t\tDresser Primark\t\tFurniture");
					System.out.println("F016\t\tDresser Sorela\t\tFurniture");
					System.out.println("K017\t\tSpoon Stella\t\tKitchenware");
					System.out.println("K018\t\tSpoon Morocco\t\tKitchenware");
					System.out.println("K019\t\tFork Stella\t\tKitchenware");
					System.out.println("K020\t\tFork Morocco\t\tKitchenware");
					System.out.println("K021\t\tKnive Stella\t\tKitchenware");
					System.out.println("K022\t\tKnive Morocco\t\tKitchenware");
					System.out.println("K023\t\tPlate Stella\t\tKitchenware");
					System.out.println("K024\t\tPlate Morocco\t\tKitchenware");
					System.out.println("E025\t\tTV Blue Sky\t\tEletronic");
					System.out.println("E026\t\tTV Gradiente\t\tEletronic");
					System.out.println("E027\t\tMP3 Bush\t\tEletronic");
					System.out.println("E028\t\tMP3 Sony\t\tEletronic");
					System.out.println("E029\t\tApple Phone X\t\tEletronic");
					System.out.println("E030\t\tSamasung S10\t\tEletronic");
					System.out.println("E031\t\tKeyboard HP4\t\tEletronic");
					System.out.println("E032\t\tKeyboard Mac\t\tEletronic");

					Scanner sc7 = new Scanner(System.in);
					System.out.print("\nEnter the ProductID: ");
					userProductID = sc7.nextLine(); // save the productId from the user

					for (int i = 0; i < listProducts.size(); i++) { // for loop to check at the array

						if ((userProductID != null && listProducts.get(i).productID.equalsIgnoreCase(userProductID))) {
							listProducts.get(i).display(); // Display details of products
						}
					}

					break;

				case 5: // Calculate tax return

					// Print the list of products with productID, name and type
					System.out.print("\n====================================================");
					System.out.println("\nProductID\t\bName\t\t\tDepartment ");
					System.out.print("====================================================\n");
					System.out.println("F011\t\tChair Stefan\t\tFurniture");
					System.out.println("F012\t\tChair Tobias\t\tFurniture");
					System.out.println("F013\t\tTable Paris\t\tFurniture");
					System.out.println("F014\t\tTable Sunsine\t\tFurniture");
					System.out.println("F015\t\tDresser Primark\t\tFurniture");
					System.out.println("F016\t\tDresser Sorela\t\tFurniture");
					System.out.println("K017\t\tSpoon Stella\t\tKitchenware");
					System.out.println("K018\t\tSpoon Morocco\t\tKitchenware");
					System.out.println("K019\t\tFork Stella\t\tKitchenware");
					System.out.println("K020\t\tFork Morocco\t\tKitchenware");
					System.out.println("K021\t\tKnive Stella\t\tKitchenware");
					System.out.println("K022\t\tKnive Morocco\t\tKitchenware");
					System.out.println("K023\t\tPlate Stella\t\tKitchenware");
					System.out.println("K024\t\tPlate Morocco\t\tKitchenware");
					System.out.println("E025\t\tTV Blue Sky\t\tEletronic");
					System.out.println("E026\t\tTV Gradiente\t\tEletronic");
					System.out.println("E027\t\tMP3 Bush\t\tEletronic");
					System.out.println("E028\t\tMP3 Sony\t\tEletronic");
					System.out.println("E029\t\tApple Phone X\t\tEletronic");
					System.out.println("E030\t\tSamasung S10\t\tEletronic");
					System.out.println("E031\t\tKeyboard HP4\t\tEletronic");
					System.out.println("E032\t\tKeyboard Mac\t\tEletronic");

					Scanner sc5 = new Scanner(System.in);
					System.out.print("\nEnter the ProductID: ");
					userProductID = sc5.nextLine(); // save the productId from the user

					for (int i = 0; i < Driver.listProducts.size(); i++) {

						if ((userProductID != null
								&& Driver.listProducts.get(i).productID.equalsIgnoreCase(userProductID))) {

							// it will print name and quantity of the product
							System.out.println("\n\tProduct Name: " + listProducts.get(i).getName());
							System.out.println(
									"\tQuantity at store: " + listProducts.get(i).getQuantity() + " item(s).\n");

							Scanner sc8 = new Scanner(System.in);
							System.out.print("Enter Quantity: ");
							int userQuantity = sc8.nextInt();

							if (userQuantity > 0 && userQuantity <= Driver.listProducts.get(i).getQuantity()) {

								// If the material has tax
								if (Driver.listProducts.get(i) instanceof Taxable) {

									// it will return the tax
									double tax = ((Taxable) Driver.listProducts.get(i)).taxReturn();
									double quantityTax = userQuantity * tax;

									System.out.printf("\n\tUnit tax: $" + "%.2f", tax);
									System.out.printf("\n\tTotal tax: $" + "%.2f", quantityTax);
									System.out.print(" buying " + userQuantity + " unit(s)\n");

								} else {
									System.out.println("\n\tUnit tax: $0.00\n\tTotal tax: $0.00");
								}
							} else {
								System.out.println("\n\tQuantity not avalaible at stock");
								System.out.println(
										"\tStock with: " + Driver.listProducts.get(i).getQuantity() + " unit(s)");
							}
						}
					}
					break;

				case 6:

					System.out.println("\n===========================================");
					System.out.println("******** See you soon at LoZzBy!!! ********"); // this option close the program
					System.out.println("===========================================");
					saveBinaryFile(); // it will save the data in the binary file
					
					System.exit(0);
					break;

				default:
					System.out.println("\n*** Write a valid option ***");
				}
			} catch (Exception e) {
				System.out.println("\n\t--> Write a valid Product ID");
			}
		}

		while (choice != 6); // the program will run until the user choose the option 6 (to exit)
	}
}