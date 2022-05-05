package unit;
import item.*;

public interface InterfUnit { 
    public void putOn (Item item);
    public void takeOff (Item item);
    public void atack (Unit target);
    public int drop(Unit target);
}
