package unit;
import java.io.Serializable;
import java.util.Arrays;

import item.*;

public abstract class Unit implements InterfUnit, Serializable {
    
public String name;
public int atack;
public int hp;
public int wearableWeight;
public int armor = 0;
public Item[] inventory = new Item[10];
public int money;
public int attack;
public static Item get;


public Unit (String name, int hp, int atack, int wearableWeight) {
    this.name = name;
    this.hp = hp;
    this.atack = atack;
    this.wearableWeight = wearableWeight;
}

public void putOn (Item item) {
    item.putOn = true;
    wearableWeight -= item.weight;
    if (item instanceof Weapon && item.durability>0 && wearableWeight>0) {
        atack += ((Weapon) item).atack;
    }
    else if (item instanceof Armor && item.durability>0 && wearableWeight>0) {
        armor+= ((Armor) item).armor;
    } else {
        System.out.println("Не могу надеть, слишком тяжело!!!");
    }
}

public void takeOff (Item item) {
    item.putOn = false;
}

public int drop (Unit target){
    int drop = target.money;
    return drop;
}

public void atack (Unit target){
for (Item x : target.inventory) {
    if (x instanceof Armor && x.durability>0 && x.putOn) {
        ((Armor) x).durability -= 1;
    }
}
for (Item y : inventory) { 
    if (y instanceof Weapon && y.durability>0 && y.putOn) {
        ((Weapon) y).durability-=1;
    }
}
if (atack > target.armor) {
    target.hp-=atack;
} else {
    System.out.println("Не пробил броню");
}

if (target.hp<=0) {
    money+=drop(target);
    for (Item j : target.inventory) {
        if (j != null && j instanceof Weapon) {
            get = new Weapon (((Weapon)j).name, ((Weapon)j).durability, ((Weapon)j).weight, ((Weapon)j).atack);
            wearableWeight-=get.weight;
        } else if (j != null && j instanceof Armor) {
            get = new Armor (((Armor)j).name, ((Armor)j).durability, ((Armor)j).weight, ((Armor)j).armor);
            wearableWeight-=get.weight;
        }
        for (int f=0; f < 10; f++){
            if (inventory[f] == null && get instanceof Weapon && wearableWeight>0) {
                inventory[f] = new Weapon (((Weapon)get).name, ((Weapon)get).durability, ((Weapon)get).weight, ((Weapon)get).atack);
                get = null;
        } else if (inventory[f] == null && get instanceof Armor && wearableWeight>0) {
                inventory[f] = new Armor (((Armor)get).name, ((Armor)get).durability, ((Armor)get).weight, ((Armor)get).armor);
                get = null;
            }
        }
    }
    Arrays.fill(target.inventory, null);
    }
    }

@Override
public String toString() {
    return "Unit {" + 
    "Name = '" + name + "\'" +
    ", Atack = " + atack +
    ", HP = " + hp +
    ", Weight = " + wearableWeight +
    ", Armor = " + armor +
    ", Inventory = " + inventory +
    ", Money = " + money;
}

}

