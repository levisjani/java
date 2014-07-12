import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import javax.xml.bind.annotation.adapters.HexB

public class MD5{
        
        public static void main(String args[]){

                //Create instance Scanner for input 
                Scanner scan = new
                Scanner(System.in);  
                //Convert text in HASH
                System.out.print("String for hash code: ");
                String text = scan.nextLine();
                
                scan.close();
                
                try{
                    //MessageDigest for MD5 algorithm 
                    MessageDigest md = MessageDigest.getInstance("MD5");
                    
                    //HexBinaryAdapter
                    HexBinaryAdapter hba = new HexBinaryAdapter();
                    
                    //
                    byte[] textBytes = text.getBytes();
                    
                    //digest Bytes
                    byte[] digestBytes = md.digest(textBytes);
                    
                    //HexBinaryAdapter for marshalling into hex
                    String hash = hba.marshal(digestBytes);
                    
                    //Result
                    System.out.println("Hex HASH: " + hash);
                }
                    catch (NoSuchAlgorithmException e){
                        e.printStackTrace();
                        System.out.println("MD5 algorithm not found.");
                    }
                }
}
