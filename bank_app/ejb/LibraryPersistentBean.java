import com.tutorialspoint.entity.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class LibraryPersistentBean implements LibraryPersistentBeanRemote {
    
   public LibraryPersistentBean(){
   }

   public void addBook(Book book) {
      Connection con = null;
      String url = "jdbc:postgresql://localhost:5432/postgres";
      String driver = "org.postgresql.driver";

      String userName = "sa";
      String password = "sa";
      List<Book> books = new ArrayList<Book>();
      try {

         Class.forName(driver).newInstance();
         con = DriverManager.getConnection(url , userName, password);

         PreparedStatement st = 
         con.prepareStatement("insert into book(name) values(?)");
         st.setString(1,book.getName());

         int result = st.executeUpdate();                

      } catch (SQLException ex) {
         ex.printStackTrace();
      } catch (InstantiationException ex) {
         ex.printStackTrace();
      } catch (IllegalAccessException ex) {
         ex.printStackTrace();
      } catch (ClassNotFoundException ex) {
         ex.printStackTrace();
      }    
   }    

   public List<Book> getBooks() {
      Connection con = null;
      String url = "jdbc:postgresql://localhost:5432/postgres";
      String driver = "org.postgresql.driver";
   
      String userName = "sa";
      String password = "sa";
      List<Book> books = new ArrayList<Book>();
      try {

         Class.forName(driver).newInstance();
         con = DriverManager.getConnection(url , userName, password);

         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery("select * from book");

         Book book;
         while (rs.next()) {
            book = new Book();
            book.setId(rs.getInt(1));                 
            book.setName(rs.getString(2));
            books.add(book);
         }
      } catch (SQLException ex) {
         ex.printStackTrace();
      } catch (InstantiationException ex) {
         ex.printStackTrace();
      } catch (IllegalAccessException ex) {
         ex.printStackTrace();
      } catch (ClassNotFoundException ex) {
         ex.printStackTrace();
      }
      return books;
   }
}
