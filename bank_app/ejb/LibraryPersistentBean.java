//Create Stateless EJB

@Stateless
public class LibraryPersistentBean implements LibraryPersistentBeanRemote {
	
   public void addBook(Book book) {
     //persist book using jdbc calls
   }    

   public List<Book> getBooks() {        
     //get books using jdbc calls
   }
   ...
}
