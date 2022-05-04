package item;

public class Item{
    
    public String name;
    public int durability;
    public boolean putOn = false;
    public int weight;

    public Item (String name, int durability, int weight) {
        this.name = name;
        this.durability = durability;
        this.weight = weight;
    }

    public int getDurability (){
        return durability;
    }
}
