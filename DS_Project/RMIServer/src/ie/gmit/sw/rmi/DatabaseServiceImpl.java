package ie.gmit.sw.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ie.gmit.sw.Model.Order;

public class DatabaseServiceImpl extends UnicastRemoteObject implements DatabaseService {

	private static final long serialVersionUID = 1L;
	private Connection conn;
	private Statement stmt;
	private PreparedStatement prepStmt;

	protected DatabaseServiceImpl() throws RemoteException, SQLException, Exception{
		super();
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carhiredb?useSSL=false", "root", "");
	}

	@Override
	public List<Order> read() throws RemoteException, SQLException {
		System.out.println("In read");

		stmt = conn.createStatement();

		List<Order> orderList = new ArrayList<Order>();
		String sql = "select * from orders";
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) { 
			int orderID = rs.getInt("order_id");
			String startDate = rs.getString("start_date");
			String endDate = rs.getString("end_date");
			int custID = rs.getInt("cust_id");
			int carID = rs.getInt("car_id");
			
			Order s = new Order(orderID, startDate, endDate, custID, carID);
			orderList.add(s);
		}
		return orderList;
	}

	@Override
	public void write(Order o) throws RemoteException, SQLException {
		System.out.println("In write/create");
		
		stmt = conn.createStatement();
		
		String sql = "INSERT into orders (start_date, end_date, cust_id, car_id) "
					+ "VALUES('" + o.getStartDate() + "', '" + o.getEndDate() + "', " + o.getCustID() + ", " + o.getCarID() +");";
		
		stmt.execute(sql);
	}

	@Override
	public void update(Order o) throws RemoteException, SQLException {
		
		System.out.println("In update");
		String sql = "UPDATE orders SET start_date = ?, end_date = ?, car_id = ? WHERE cust_id = ?;";
		
		prepStmt = conn.prepareStatement(sql);
		
		prepStmt.setString(1, o.getStartDate());
		prepStmt.setString(2, o.getEndDate());
		prepStmt.setInt(3, o.getCarID());
		prepStmt.setInt(4, o.getCustID());
		
		prepStmt.executeUpdate();
		prepStmt.close();
	}

	@Override
	public void delete(int id) throws RemoteException, SQLException {
		
		System.out.println("In delete");
		
		stmt = conn.createStatement();
		
		String sql = "DELETE FROM orders WHERE order_id =" + id + ";";
		
		stmt.execute(sql);
		
		
	}

}
