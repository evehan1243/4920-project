import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Account {
	String jdbc_Driver = "com.mysql.jdbc.Driver";
    
	String db_Address = "jdbc:mysql://localhost/";
	String db_Name    = "Game";

    String userName = "Game";
    String password = "admin";
    

    
	public Account(){
		
	}
	//will register given user if not in database, if user is in database then will return false
	public boolean register(String login, String pswrd){
		String command = "INSERT INTO account (Login, Password) VALUES ('"+login+"', '"+pswrd+"')";
		try {
			executeSQL(command);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	//will login user if exist in database and has matching password, if login fails, will return false
	public boolean login(String login, String pswrd) throws SQLException{
		ArrayList<String> userList = new ArrayList<String>();
		ArrayList<String> pass = new ArrayList<String>();
		String command = "SELECT Login, Password FROM account WHERE Login = '"+login+"' AND Password = '"+pswrd+"'";
		
		Statement stat = null;
	    Connection conn = null;
	    ResultSet result = null;
		try{
		Class.forName(jdbc_Driver);
		String url = db_Address+db_Name;
		conn = DriverManager.getConnection(url, userName, password);
		stat = conn.createStatement();
		result = stat.executeQuery(command);
		
		}catch(ClassNotFoundException e){
			System.out.println("Class Not Found !");
			e.printStackTrace();
		}catch(SQLException e){
			System.out.println("An error occure when excute SQL!");
			e.printStackTrace();
		} 
		
		while(result.next()){
			userList.add(result.getString("Login"));
			pass.add(result.getString("Password"));
		}
		
		stat.close();
		conn.close();
		if(!userList.isEmpty()){
			return true;
		}
		return false;
	}
	//Initializes table in database
	public void initiateCredentials() throws Exception{
	    Statement stat = null;
	    Connection conn = null;
		try{
	    	Class.forName(jdbc_Driver);
	    	String url = db_Address + db_Name;

	    	conn = DriverManager.getConnection(url, userName, password);
	    	stat = conn.createStatement();
	    	stat.executeUpdate("create table account( "
	    			+ "Id int PRIMARY KEY NOT NULL AUTO_INCREMENT, "
	    			+ "Login varchar(30) BINARY NOT NULL, "
	    			+ "Password varchar(60) BINARY NOT NULL, "
	    			+ "UNIQUE (Login) "
	    			+ ")");
	    	
	    	}catch(ClassNotFoundException e){
	    		System.out.println("Class Not Found !");
	    		e.printStackTrace();
	    	}catch(SQLException e){
	    		System.out.println("An error occure when excute SQL!");
	    		e.printStackTrace();
	    	} 
	    	stat.close();
	    	conn.close();
	}
	//retrieves friends associated with a single individual
	public ArrayList<String> displayFriends(String login) throws Exception{
		
		ArrayList<String> returnResult = new ArrayList<String>();
		String command = "SELECT * " +
						 "FROM Friends a, Account b " +
						 "WHERE a.Id = b.Id AND b.Login = '"+login+"'";
		
		Statement stat = null;
	    Connection conn = null;
	    ResultSet result = null;
		try{
		Class.forName(jdbc_Driver);
		String url = db_Address+db_Name;
		conn = DriverManager.getConnection(url, userName, password);
		stat = conn.createStatement();
		result = stat.executeQuery(command);
		
		}catch(ClassNotFoundException e){
			System.out.println("Class Not Found !");
			e.printStackTrace();
		}catch(SQLException e){
			System.out.println("An error occure when excute SQL!");
			e.printStackTrace();
		} 
		
		while(result.next()){
			returnResult.add(result.getString("friend"));
		}
		
		stat.close();
		conn.close();
		
		return returnResult;
	}
	//adds a name to the friends list
	public boolean addFriend(String login, String friend) throws Exception{
		if(login.equals(friend)){
			return false;
		}
		int userID = getID(login);
		String command = "INSERT INTO friends (Id, Friend) VALUES ('"+userID+"', '"+friend+"')";
		try {
			executeSQL(command);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	//delete friend association between user and friend
	public boolean deleteFriend(String login, String friend) throws Exception{
		int userID = getID(login);
		String command = "DELETE FROM friends WHERE Id = '"+userID+"' AND Friend = '"+friend+"'";
		try {
			executeSQL(command);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	//Initializes friends list, only one copy can exist at any one time
	public void initiateFriendsList() throws Exception{
		Statement stat = null;
	    Connection conn = null;
		try{
	    	Class.forName(jdbc_Driver);
	    	String url = db_Address + db_Name;

	    	conn = DriverManager.getConnection(url, userName, password);
	    	stat = conn.createStatement();
	    	stat.executeUpdate("create table friends( "
	    			+ "Id int NOT NULL, "
	    			+ "Friend varchar(30) BINARY NOT NULL, "
	    			+ "UNIQUE (Id, Friend) "
	    			+ ")");
	    	
	    	}catch(ClassNotFoundException e){
	    		System.out.println("Class Not Found !");
	    		e.printStackTrace();
	    	}catch(SQLException e){
	    		System.out.println("An error occure when excute SQL!");
	    		e.printStackTrace();
	    	} 
	    	stat.close();
	    	conn.close();
	}
	// function to execute SQL command (edit table e.g. insert, delete etc.) 
		public void executeSQL(String command) throws Exception{
			String jdbc_Driver = "com.mysql.jdbc.Driver";
		    
			String db_Address = "jdbc:mysql://localhost/";
			String db_Name    = "Game";
		   
		    String userName = "Game";
		    String password = "admin";

		    Statement stat = null;
		    Connection conn = null;
	    	try{
	    	Class.forName(jdbc_Driver);
	    	String url = db_Address+db_Name;
	    	conn = DriverManager.getConnection(url, userName, password);
	    	stat = conn.createStatement();
	    	stat.executeUpdate(command);
	    	
	    	}catch(ClassNotFoundException e){
	    		System.out.println("Class Not Found !");
	    		//e.printStackTrace();
	    	}catch(SQLException e){
	    		System.out.println("An error occure when excute SQL!");
	    		//e.printStackTrace();
	    	} 
	    	stat.close();
	    	conn.close();	
		}
		//gets the DB id for a particular user
		public int getID(String login) throws Exception{
			int returnResult = 0;
			String command = "SELECT * " +
							 "FROM Account " +
							 "WHERE Login = '"+login+"'";
			
			Statement stat = null;
		    Connection conn = null;
		    ResultSet result = null;
			try{
			Class.forName(jdbc_Driver);
			String url = db_Address+db_Name;
			conn = DriverManager.getConnection(url, userName, password);
			stat = conn.createStatement();
			result = stat.executeQuery(command);
			
			}catch(ClassNotFoundException e){
				System.out.println("Class Not Found !");
				e.printStackTrace();
			}catch(SQLException e){
				System.out.println("An error occure when excute SQL!");
				e.printStackTrace();
			} 
			
			while(result.next()){
				returnResult = Integer.parseInt(result.getString("Id"));
			}
			
			stat.close();
			conn.close();
			
			return returnResult;
		}
}
