

import java.sql.*;



public class DbAccess {

	private Connection conn;
	private Statement s;
	
	public boolean initializeConnection(String SERVER, String DATABASE, String USER_ID, 
			String PASSWORD) throws ClassNotFoundException, SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String path = ("jdbc:mysql://"+ SERVER + "/" + DATABASE + "?user=" 
					+ USER_ID + "&password=" + PASSWORD);
			conn = DriverManager.getConnection(path);
			s = conn.createStatement();
			return true;
		}
		catch (SQLException e) { 
			return false;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void CreateConnection(){
		  if(conn == null)
		  try{
		  initializeConnection("localhost","bank","root","unyt");
		  }catch(Exception e){e.printStackTrace();}	  
	  }
	
	public Connection getConnection() {
		return conn;
	}
	
	public void closeConnection() {
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public void closeStatement(){
		try{
			s.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
