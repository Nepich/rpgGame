package item;

public class Armor extends Item{
    
    private int armor;
    
    public Armor (String name, int durability, int weight, int armor) {
        super(name, durability, weight);
        this.armor = armor;
    }

    public int getArmor(){
        return armor;
    }
}
