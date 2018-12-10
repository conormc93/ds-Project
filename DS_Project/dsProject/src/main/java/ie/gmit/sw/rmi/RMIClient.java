package ie.gmit.sw.rmi;

import java.rmi.Naming;
import java.util.List;

import ie.gmit.sw.Model.Order;

public class RMIClient {
	
	private DatabaseService ch;

	public RMIClient() throws Exception {
		ch = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/database");

	}

	public List<Order> readData() throws Exception {
		return ch.read();
	}
	
	public void deleteData(int a) throws Exception {
		ch.delete(a);
	}

}
