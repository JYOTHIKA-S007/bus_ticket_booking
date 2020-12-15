package bus_booking;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class bus {
	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
	Connection c = null;
	Statement stmt = null;
	int no_of_seats;
	String bus_owner;
	String bus_driver;
	String bus_conductor;
	String bus_id;
	int route_no;
	bus()
	{
	}
	public
	void addBus(int no_of_seats,String bus_owner,String bus_driver,String bus_conductor,String bus_id, int route_no)
	{
		this.no_of_seats=no_of_seats;
		this.bus_owner=bus_owner;
		this.bus_driver=bus_driver;
		this.bus_conductor=bus_conductor;
		this.bus_id=bus_id;
		this.route_no=route_no;
		try 
		{
			
			// This will load the MySQL driver, each DB has its own driver
        	Class.forName("org.postgresql.Driver");
            // Setup the connection with the DB
        	connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bus_ticket_booking",
                    "postgres", "postgres");
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
         // PreparedStatements can use variables and are more efficient
            preparedStatement = connect
                    .prepareStatement("insert into bus values (?, ?,?,?,?,?)");
            
            
            // Parameters start with 1
            preparedStatement.setString(1, bus_conductor);
            preparedStatement.setInt(2, route_no);
            preparedStatement.setInt(3, no_of_seats);
            preparedStatement.setString(4, bus_driver);
            preparedStatement.setString(5, bus_owner);
            preparedStatement.setString(6, bus_id);
              
            preparedStatement.executeUpdate();

            preparedStatement = connect
                    .prepareStatement("SELECT * from bus");
            resultSet = preparedStatement.executeQuery(); 
            System.out.print("New Bus added");
            
            
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
		}
	}
	void searchBus(String bus_id)
	{
		try
		{

			// This will load the MySQL driver, each DB has its own driver
        	Class.forName("org.postgresql.Driver");
            // Setup the connection with the DB
        	connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bus_ticket_booking",
                    "postgres", "postgres");
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
         // PreparedStatements can use variables and are more efficient
            preparedStatement = connect
                    .prepareStatement( ("SELECT * from bus where bus_id=?"));
            preparedStatement.setString(1, bus_id);
                    resultSet = preparedStatement.executeQuery();
                    writeResultSet(resultSet);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
		}
		
	}
	void editBus(String bus_id)
	{
		System.out.println("What do you want to edit?");
		
	}
	void deleteBus(String bus_id)
	{
		try {
			Class.forName("org.postgresql.Driver");
            // Setup the connection with the DB
        	connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bus_ticket_booking",
                    "postgres", "postgres");
        	statement = connect.createStatement();
        	preparedStatement = connect
                    .prepareStatement( ("DELETE from bus where bus_id = ? "));
            preparedStatement.setString(1, bus_id);
            System.out.println("Deleted successfully");
            preparedStatement.executeQuery();
            

				}
		catch (Exception e)
		{
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
		}
	}
	private void writeResultSet(ResultSet resultSet) throws SQLException{
		 while (resultSet.next()) {
		 String bus_conductor = resultSet.getString("bus_conductor");
			int route_no = resultSet.getInt("route_no");
			int no_of_seats  = resultSet.getInt("no_of_seats");
			String bus_driver = resultSet.getString("bus_driver");
			String bus_owner = resultSet.getString("bus_owner");
			System.out.println( "Bus Conductor = " + bus_conductor );
			System.out.println( "Route number = " + route_no );
			System.out.println( "Number of seats = " + no_of_seats );
			System.out.println( "Bus Driver = " + bus_driver );
			System.out.println( "Bus Owner = " + bus_owner );
			System.out.println();
		 }
	 }	
};