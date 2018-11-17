public class ATMCustomer {
	private int serviceTime;
	private Customer customer;

	public ATMCustomer() {
		serviceTime = 0;
		customer = null;
	}

	public Customer peek() {
		return customer;
	}

	public void printCustomerInfo() {
		if (isEmpty()) {
			System.out.println("ATM available");
		} else {
			System.out.println(customer.getName() + " has been at the ATM for " + serviceTime + " min");
		}
	}

	public boolean isEmpty() {
		if (customer == null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean addCustomer(Customer addedCustomer) {
		if (isEmpty()) {
			customer = addedCustomer;
			serviceTime = addedCustomer.getServiceTime();
			return true;
		} else {
			return false;
		}
	}

	public void removeCustomer() {
		customer = null;
	}

	public void checkCustomerFinished() {
		serviceTime--;
		if (serviceTime == 0) {
			removeCustomer();
		}
	}
}