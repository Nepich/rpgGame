package unit;
import item.Item;

public class FlyingCreature extends Unit{
    
    public FlyingCreature(String name, int hp, int atack, int wearableWeight, Item[] inventory) {
        super(name, hp, atack, wearableWeight);
    }

    public void fly (double[] from, double[] to){
//в дальнейшем прописать полет откуда - куда
    }
}
