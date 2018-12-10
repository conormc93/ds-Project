package ie.gmit.sw.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import ie.gmit.sw.Model.Order;

public interface DatabaseService extends Remote {

	public List<Order> read() throws RemoteException, SQLException;
	public void write(Order o) throws RemoteException, SQLException;	
	public void update(Order o) throws RemoteException, SQLException;
	public void delete(int id) throws RemoteException, SQLException;

}
