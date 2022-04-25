package item;

public class Armor extends Item{
    
    public int armor;
    
    public Armor (String name, int durability, int weight, int armor) {
        super(name, durability, weight);
        this.armor = armor;
    }
}
