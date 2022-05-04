package unit.UnitFactorys;
import unit.Elf;
import unit.Unit;
import java.util.Random;
import java.util.Scanner;

import item.Armor;
import item.Weapon;


public class ElfFactory implements Factory {

    private static String[] armorNames = new String[]{"Пузо","Брюхо","Жирок","Майка"};
    private static String[] weaponNames = new String[]{"Кинжал","Топор","Лук"};

    public Unit create(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя персонажа");
        String name = in.next();
        System.out.println("Выберите диапозон здоровья\n1 - от 50 до 60\n2 - от 60 до 70\n3 - от 70 до 80");
        int hp = in.nextInt();
        if (hp==1) hp=50;
        else if (hp==2) hp=60;
        else hp=70;
        System.out.println("Выберите диапозон атаки\n1 - от 10 до 20\n2 - от 20 до 30\n3 - от 30 до 40");
        int atack = in.nextInt();
        if (atack==1) atack=10;
        else if (atack==2) atack=20;
        else atack=30;
        Unit unit = new Elf(name, 
        hp + new Random().nextInt(11),
        atack + new Random().nextInt(11),
        100);
        System.out.println("Надеть случайное оружие?(Y/N)");
        String choice = in.next();
        if (choice.equalsIgnoreCase("Y")){
            unit.putOn(new Weapon(weaponNames[new Random().nextInt(weaponNames.length)], 100, 10 + new Random().nextInt(25), 10 + new Random().nextInt(30)));
        }
        System.out.println("Надеть случайную броню?(Y/N)");
        choice = in.next();
        if (choice.equalsIgnoreCase("Y")){
            unit.putOn(new Armor(armorNames[new Random().nextInt(armorNames.length)], 100, 10 + new Random().nextInt(25), 10 + new Random().nextInt(20)));
        }
        return unit;
    }
}
