import java.util.*;


public class CareTaker {
   private List<Memento> mementoList = new ArrayList<Memento>();

   public void add(Memento state){
      mementoList.add(state);
   }

   public Memento get(){
       if (mementoList.isEmpty())
           return null;
       else
       {     
      Memento m = mementoList.get(mementoList.size() - 1);
      mementoList.remove(mementoList.size()-1);
      return m;
       }
   }
}
