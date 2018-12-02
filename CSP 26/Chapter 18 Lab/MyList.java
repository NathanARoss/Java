import java.util.ArrayList;
/**
 * @author nathan
 */
final public class MyList <T extends Number> {
    private ArrayList<T> list;
    
    public MyList() {
        list = new ArrayList<>();
    }
    
    public void add(T t) {
        list.add(t);
    }
    
    public T largest() {
        if (list.isEmpty())
            return null;
        
        T largest = list.get(0);
        
        for (int i = 1; i < list.size(); ++i) {
            if (list.get(i).doubleValue() > largest.doubleValue()) {
                largest = list.get(i);
            }
        }
        
        return largest;
    }
    
    public T smallest() {
        if (list.isEmpty())
            return null;
        
        T smallest = list.get(0);
        
        for (int i = 1; i < list.size(); ++i) {
            if (list.get(i).doubleValue() < smallest.doubleValue()) {
                smallest = list.get(i);
            }
        }
        
        return smallest;
    }
}
