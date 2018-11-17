
public class Customer {
	private int arrivalTime;
	private String name;
	private int serviceTime;
	private Customer next;

	public Customer(int conArrivalTime, int conServiceTime, String conName) {
		arrivalTime = conArrivalTime;
		serviceTime = conServiceTime;
		name = conName;
		next = null;
	}

	public Customer() {
		arrivalTime = 0;
		serviceTime = 0;
		name = null;
		next = null;
	}

	public Customer getNext() {
		return next;
	}

	public String getName() {
		return name;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public int getServiceTime() {
		return serviceTime;
	}

	public void setNext(Customer nextCustomer) {
		next = nextCustomer;
	}

	public void setName(String newName) {
		name = newName;
	}

	public void setArrivalTime(int newArrivalTime) {
		arrivalTime = newArrivalTime;
	}

	public void setServiceTime(int newServiceTime) {
		serviceTime = newServiceTime;
	}

	public void printCustomerInfo() {
		System.out.println(name + ": " + " arrivalTime = " + arrivalTime + ':' + " serviceTime = " + serviceTime);
	}

	public boolean hasNext() {
		return next == null;
	}
}
