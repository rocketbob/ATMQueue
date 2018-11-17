import java.util.Scanner;
import java.io.*;

public class ATMQueue {
	private int numberOfCustomers;
	private Customer firstCustomer;
	private Customer lastCustomer;

	public ATMQueue() {
		firstCustomer = null;
		lastCustomer = null;
		numberOfCustomers = 0;
	}

	public void addCustomer(Customer newFirstCustomer) {
		if (firstCustomer == null && lastCustomer == null) {
			firstCustomer = newFirstCustomer;
			lastCustomer = newFirstCustomer;
			numberOfCustomers++;
		} else {
			firstCustomer.setNext(newFirstCustomer);
			firstCustomer = newFirstCustomer;
			numberOfCustomers++;
		}
	}

	public Customer removeCustomer() {
		Customer c = lastCustomer;
		lastCustomer = lastCustomer.getNext();
		numberOfCustomers--;
		return c;
	}

	public void printATMQueueCustomerInfo() {
		Customer tempCustomer = lastCustomer;
		while (tempCustomer != null) {
			tempCustomer.printCustomerInfo();
			tempCustomer = tempCustomer.getNext();
		}
	}

	public Customer peek() {
		if (!isEmpty())
			return lastCustomer;
		else {
			Customer cust = new Customer(1, 1, "made up cust");
			return cust;
		}
	}

	public boolean isEmpty() {
		if (numberOfCustomers == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void readCustomerListFile() {
		Scanner fileInput;
		File inFile = new File("Customers.txt");

		try {
			fileInput = new Scanner(inFile);

			while (fileInput.hasNext()) {
				Customer cust = new Customer();
				cust.setArrivalTime(fileInput.nextInt());
				cust.setServiceTime(fileInput.nextInt());
				cust.setName(fileInput.nextLine());
				addCustomer(cust);
			}

			fileInput.close();
		}

		catch (FileNotFoundException e) {
			System.out.println(e);
			System.exit(1);
		}
	}
}