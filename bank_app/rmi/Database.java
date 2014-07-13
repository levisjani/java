import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;




public class Database {

	  private static DbAccess dba = new DbAccess(); 	
	  private static Connection conn;
	  
	  
	  public static void CreateConnection(){
		  dba.CreateConnection();
		  conn = dba.getConnection();
	  }
	  
	  public static void main(String args[])
	  {
		CreateConnection();
		System.out.println(getCustomerId(2));
	  }

          public static ArrayList<Integer> getCustomerId(int idAccount){
              ArrayList<Integer> ids = new  ArrayList<Integer>();
			try {
				Statement s = dba.getConnection().createStatement();
				String sql = "Select idCustomer from accountCustomer where idAccount ='" + idAccount + "'";
				ResultSet r = s.executeQuery(sql);
				while(r.next()){
					ids.add(r.getInt("IdCustomer"));
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return ids;
          }

              public static int getCustomerId2(int idAccount){
              ArrayList<Integer> ids = new  ArrayList<Integer>();
			try {
				Statement s = dba.getConnection().createStatement();
				String sql = "Select idCustomer from accountCustomer where idAccount ='" + idAccount + "'";
				ResultSet r = s.executeQuery(sql);
				while(r.next()){
					ids.add(r.getInt("idCustomer"));
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return 1;
          }

}
