package item;

public class Weapon extends Item{
    
    public int atack;
    
    public Weapon (String name, int durability, int weight, int atack) {
        super(name, durability, weight);
        this.atack = atack;
    }
}
