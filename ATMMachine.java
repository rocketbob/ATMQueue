public class ATMMachine {
	private int numCustomers = 0;
	private int firstCustomer;
	private int lastCustomer;
	private int size;
	private Customer[] customers;

	public ATMMachine(int sizeOfATM) {
		size = sizeOfATM;
		customers = new Customer[size];
		lastCustomer = 0;
		firstCustomer = 0;
	}

	public Customer peek() {
		return customers[lastCustomer];
	}

	public void addCustomer(Customer cust) {
		if (!isFull()) {
			customers[firstCustomer] = cust;
			firstCustomer = (firstCustomer + 1) % size;
			numCustomers++;
		} else {
			System.out.println("Customer queue is full");
		}
	}

	public Customer removeCustomer() {
		Customer cust = customers[lastCustomer];
		lastCustomer = (lastCustomer + 1) % size;
		numCustomers--;
		return cust;
	}

	public boolean isFull() {
		if (numCustomers == size) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isEmpty() {
		if (numCustomers == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void showCustomers() {
		if (!isEmpty()) {
			System.out.println("Current customers at an ATM:");
			for (int i = 0; i < numCustomers; i++) {
				customers[(lastCustomer + i) % size].printCustomerInfo();
			}
		} 
	}
}