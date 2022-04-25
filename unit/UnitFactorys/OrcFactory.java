package unit.UnitFactorys;
import unit.Orc;
import unit.Unit;
import java.util.Random;
import java.util.Scanner;

import item.Armor;
import item.Weapon;


public class OrcFactory implements Factory {
    private static String[] armorNames = new String[]{"Пузо","Брюхо","Жирок","Майка"};
    private static String[] weaponNames = new String[]{"Кинжал","Топор","Лук"};

    public Unit create(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя персонажа");
        String name = in.next();
        System.out.println("Выберите диапозон здоровья\n1 - от 70 до 80\n2 - от 80 до 90\n3 - от 90 до 100");
        int hp = in.nextInt();
        if (hp==1) hp=70;
        else if (hp==2) hp=80;
        else hp=90;
        System.out.println("Выберите диапозон атаки\n1 - от 30 до 40\n2 - от 40 до 50\n3 - от 50 до 60");
        int atack = in.nextInt();
        if (atack==1) atack=30;
        else if (atack==2) atack=40;
        else atack=50;
        Unit unit = new Orc(name, 
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
