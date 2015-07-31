package BuilderPattern;

import Interface.*;

public class ProjectException extends Exception {
    
     public ProjectException(String exception) {

        ReservationInterface interfaceRes = ReservationInterface.getInstance();
        interfaceRes.showMessageTextField(exception);
        
    }
}
