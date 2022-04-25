package item;

public class Weapon extends Item{
    
    private int atack;
    
    public Weapon (String name, int durability, int weight, int atack) {
        super(name, durability, weight);
        this.atack = atack;
    }

    public int getAtack(){
        return atack;
    }
}
