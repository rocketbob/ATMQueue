// Bob Japundza module 6 assignment 2

// ATM test program
public class Module6 {
	public static void main(String[] args) {

		ATMMachine atmMachine;
		ATMQueue atmQueue;
		ATMCustomer atmCustomer;
		int time;

		atmQueue = new ATMQueue();
		// load 12 minutes worth of customers.  Initally loaded 60 minutes worth, took too long to debug.
		atmQueue.readCustomerListFile();
		atmMachine = new ATMMachine(3); // constructor takes how many customers an ATM can handle
		atmCustomer = new ATMCustomer();
		time = 0;

		System.out.println("Early AM, customers begin to arrive.");

		// spin thru customer list and process queue
		while (!atmMachine.isEmpty() || !atmQueue.isEmpty() || !atmCustomer.isEmpty()) {
			if (atmCustomer.isEmpty() && !atmMachine.isEmpty()) {
				atmCustomer.addCustomer(atmMachine.peek());
				atmMachine.removeCustomer();
			}

			if (atmQueue.peek().getArrivalTime() == time) {
				if (atmMachine.isFull()) {
					System.out.println("All ATM lines are full");
					System.out.println(atmQueue.peek().getName() + " leaves ATM");
				} else {
					atmMachine.addCustomer(atmQueue.peek());
					System.out.println(atmQueue.peek().getName() + " starts using ATM");
				}
				atmQueue.removeCustomer();
			}

			atmQueue.printATMQueueCustomerInfo();
			atmMachine.showCustomers();
			atmCustomer.printCustomerInfo();
			time++;
			atmCustomer.checkCustomerFinished();
		}
		System.out.println("No more customers.");
	}
}