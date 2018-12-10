package ie.gmit.sw.dsProject;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ie.gmit.sw.Model.Order;
import ie.gmit.sw.rmi.DatabaseService;
import ie.gmit.sw.rmi.RMIClient;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     * @throws Exception 
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Order> getIt() throws Exception {
    	
    	RMIClient rmi = new RMIClient();
    	
        return rmi.readData();
    }
    
    @DELETE
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_XML)
    public void deleteOrder(Order o) throws Exception {
    	
    	DatabaseService ds;
    	
    	ds = (DatabaseService) Naming.lookup("rmi://127.0.0.1/database");
    	
    	ds.delete(o.getOrderID());
    	
    }
    
    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_XML)
    public void updateOrder(Order o) throws Exception {
    	
    	DatabaseService ds;
    	
    	ds = (DatabaseService) Naming.lookup("rmi://127.0.0.1/database");
    	
    	ds.update(o);
    }
    
    /*@POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void create(@FormParam("start_date")String start_date,
    				@FormParam("end_date") String end_date,
    				@FormParam("cust_id") int cust_id,
    				@FormParam("car_id") int car_id) throws Exception {
    	
    	DatabaseService ds;
    	
    	ds = (DatabaseService) Naming.lookup("rmi://127.0.0.1/database");
    	
    	ds.write(new Order(start_date, end_date, cust_id, car_id));
    	
    	
    }*/
    
    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_XML)
    public void create(Order o) throws Exception {
    	
    	DatabaseService ds;
    	
    	ds = (DatabaseService) Naming.lookup("rmi://127.0.0.1/database");
    	
    	ds.write(o);
    }
}
