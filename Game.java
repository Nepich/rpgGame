//import item.*;
import unit.*;
/*import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;*/
import java.io.IOException;
//import java.io.ObjectOutputStream;
import unit.UnitFactorys.*;
import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Arrays;
import java.util.Random;

public class Game {

    public static void main(String[] args) throws IOException {
    /*    Unit elf = new Elf("Гурандок", 100, 30, 100);
        elf.money = 100;
        System.out.println(elf.name);
        System.out.println(elf.hp);
        System.out.println(elf.atack);
        System.out.println(elf.inventory[0]);
        System.out.println(elf.wearableWeight);

        Unit orc = new Orc("Кровоклык", 150, 50, 100);
        orc.money=30;
        System.out.println("Здоровье орка до атаки " + orc.hp);

        Weapon bow = new Weapon("Убийца сущего", 100, 20, 100);
        Armor cuirass = new Armor("Железное пузо", 100, 10, 30);
        elf.inventory[0] = bow;
        elf.inventory[1] = cuirass;
        elf.putOn(bow);
        elf.putOn(cuirass);
        System.out.println(Arrays.deepToString(elf.inventory));

        Weapon axe = new Weapon("Черепоруб", 100, 10, 100);
        Armor cuirass2 = new Armor("Железное брюхо", 100, 30, 50);
        orc.inventory[0] = axe;
        orc.inventory[1] = cuirass2;
        orc.putOn(cuirass2);
        System.out.println("Атака эльфа равна " + elf.atack);
        System.out.println("Броня эльфа равна " + elf.armor);
        System.out.println("Переносимый вес эльфа равна " + elf.wearableWeight);
        elf.atack(orc);
        System.out.println("Здоровье орка после атаки " + orc.hp);
        System.out.println(bow.durability);
        System.out.println(cuirass2.durability);
        elf.atack(orc);
        System.out.println("Здоровье орка после атаки " + orc.hp);
        System.out.println(bow.durability);
        System.out.println(cuirass2.durability);
        System.out.println(Arrays.deepToString(elf.inventory));
        System.out.println(elf.money);
        System.out.println("Переносимый вес эльфа равна " + elf.wearableWeight);
        System.out.println(Arrays.deepToString(orc.inventory));
        SaveUnit(elf);*/
        ArrayList<Unit> elfArmy = createArmy(new ElfFactory());
        ArrayList<Unit> orcArmy = createArmy(new OrcFactory());
        War(elfArmy,orcArmy);
    }

//  Новый вариант с реализацией Интерфейса
    public static ArrayList<Unit> createArmy (Factory factory) {
        ArrayList<Unit> Army = new ArrayList<>();
        for (int i=0; i<10; i++) {
            Unit unit= factory.create();
            Army.add(unit);}
        return Army;
    }

/*  Старый вариант
    public static ArrayList<Unit> createArmy(Factory type) {
        ArrayList<Unit> Army = new ArrayList<>();
        if (type=="Elf") {
        for (int i=0; i<10; i++) Army.add(ElfFactory.create());
        } else if (type=="Orc") {
        for (int i=0; i<10; i++) Army.add(OrcFactory.create());
        }
        return Army;
        
    };*/

    public static void War (ArrayList<Unit> first, ArrayList<Unit> second) {
        Object[] armies = new Object[] {first, second};
        while (first.size() != 0 && second.size() != 0) {
            int armyAtacker = new Random().nextInt(2);
            int armyDefender = 1-armyAtacker;
            Unit atacker = (Unit) ((ArrayList<Unit>) armies[armyAtacker]).get(new Random().nextInt(Arrays.asList(armies[armyAtacker]).size()));
            Unit defender = (Unit) ((ArrayList<Unit>) armies[armyDefender]).get(new Random().nextInt(Arrays.asList(armies[armyDefender]).size()));
            atacker.atack(defender);
            System.out.println(atacker.name + " атаковал " + defender.name);
            if (defender.hp <= 0) {
                System.out.println(defender.name + " умер!");
                ((ArrayList<Unit>) armies[armyDefender]).remove(((ArrayList<Unit>) armies[armyDefender]).indexOf(defender));
            } else System.out.println("У " + defender.name + " осталось " + defender.hp + " здоровья");
        }
        if (first.size()==0) System.out.println("Вторая армия победила");
        else System.out.println("Первая армия победила");
    }

/*    public static void SaveUnit(Unit unit) throws FileNotFoundException, IOException {
        File file = new File("unit.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(new Elf(unit.name, unit.atack, unit.hp, unit.wearableWeight));
        oos.close();

    }*/
}


