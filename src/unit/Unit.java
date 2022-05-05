package unit;
import java.io.Serializable;
import java.util.Arrays;

import item.*;

public abstract class Unit implements InterfUnit, Serializable {
    
private String name;
private int atack;
private int hp;
private int wearableWeight;
private int armor = 0;
private Item[] inventory = new Item[10];
private int money;
private static Item get;
private Armor def;
private Weapon atc;


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
        atc = (Weapon) item;
        atack += ((Weapon) item).getAtack();
    }
    else if (item instanceof Armor && item.durability>0 && wearableWeight>0) {
        def = (Armor) item;
        armor+= ((Armor) item).getArmor();    
    } else {
        System.out.println("Не могу надеть, слишком тяжело!!!");
    }
}

public void takeOff (Item item) {
    if (item instanceof Weapon && item.equals(atc)){
        atc = null;
    } else if (item instanceof Armor && item.equals(def)){
        def = null;
    };
}

public int drop (Unit target){
    int drop = target.getMoney();
    return drop;
}

public String getName(){
    return name;
}

public String setName(String name){
    return this.name = name;
}

public int getAtack(){
    return atack;
}

public int setAtack(int atack){
    return this.atack = atack;
}


public Item[] getInventory(){
    return inventory;
}

public int getMoney(){
    return money;
}

public int setMoney(int money){
    return this.money = money;
}

public int getHp(){
    return hp;
}

public int setHp(int hp){
    return this.hp=hp;
}

public int getWearableWeight(){
    return wearableWeight;
}

public int getArmor(){
    return armor;
}

public int setArmor(int armor){
    return this.armor = armor;
}


public void atack (Unit target){
for (Item x : target.getInventory()) {
    if (x instanceof Armor && x.durability>0 && x.putOn) {
        ((Armor) x).durability -= 1;
    }
}
for (Item y : inventory) { 
    if (y instanceof Weapon && y.durability>0 && y.putOn) {
        ((Weapon) y).durability-=1;
    }
}
if (atack > target.getArmor()) {
    target.setHp(target.getHp()-atack);
} else {
    System.out.println("Не пробил броню");
}

if (target.getHp()<=0) {
    money+=drop(target);
    for (Item j : target.getInventory()) {
        if (j != null && j instanceof Weapon) {
            get = new Weapon (((Weapon)j).name, ((Weapon)j).durability, ((Weapon)j).weight, ((Weapon)j).getAtack());
            wearableWeight-=get.weight;
        } else if (j != null && j instanceof Armor) {
            get = new Armor (((Armor)j).name, ((Armor)j).durability, ((Armor)j).weight, ((Armor)j).getArmor());
            wearableWeight-=get.weight;
        }
        for (int f=0; f < 10; f++){
            if (inventory[f] == null && get instanceof Weapon && wearableWeight>0) {
                inventory[f] = new Weapon (((Weapon)get).name, ((Weapon)get).durability, ((Weapon)get).weight, ((Weapon)get).getAtack());
                get = null;
        } else if (inventory[f] == null && get instanceof Armor && wearableWeight>0) {
                inventory[f] = new Armor (((Armor)get).name, ((Armor)get).durability, ((Armor)get).weight, ((Armor)get).getArmor());
                get = null;
            }
        }
    }
    Arrays.fill(target.getInventory(), null);
    target.setMoney(0);
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

