package unit.strategyToCreateUnit;

import java.util.Random;
import java.util.Scanner;

import item.Armor;
import item.Weapon;
import unit.Dwarf;
import unit.Elf;
import unit.Giant;
import unit.Human;
import unit.Orc;
import unit.Unit;

public class CreateWeakUnit implements StrategyInteface {

    private Unit unit;

    @Override
    public Unit createUnit() {
        String[] names = new String[]{"Бабай","Клолик","Луна","Мордоворот","Пупа"};
        String[] armorNames = new String[]{"Пузо","Брюхо","Жирок","Майка"};
        String[] weaponNames = new String[]{"Кинжал","Топор","Лук"};
        System.out.println("Выберите кого будем создавать\n 1 - Орк\n 2 - Человек\n 3 - Эльф\n 4 - Великан\n 5 - Гном");
        Scanner in = new Scanner(System.in);
        int type = in.nextInt();
        if (type==3){
            unit = new Elf(names[new Random().nextInt(names.length)], 10 + new Random().nextInt(40), 5 + new Random().nextInt(70), 100);
        } else if (type == 1) {
            unit = new Orc(names[new Random().nextInt(names.length)], 10 + new Random().nextInt(70), 15 + new Random().nextInt(70), 100);
        } else if (type == 5){
            unit = new Dwarf(names[new Random().nextInt(names.length)], 10 + new Random().nextInt(60), 10 + new Random().nextInt(70), 100);
        } else if (type == 4){
            unit = new Giant(names[new Random().nextInt(names.length)], 10 + new Random().nextInt(100), 20 + new Random().nextInt(70), 100);
        } else if (type == 2) {
            unit = new Human(names[new Random().nextInt(names.length)], 10 + new Random().nextInt(50), 10 + new Random().nextInt(70), 100);
        } else System.out.println("Таких персонажей в игре нет!!!");
        unit.putOn(new Armor(armorNames[new Random().nextInt(armorNames.length)], 100, 10 + new Random().nextInt(25), 10 + new Random().nextInt(20)));
        unit.putOn(new Weapon(weaponNames[new Random().nextInt(weaponNames.length)], 100, 10 + new Random().nextInt(25), 10 + new Random().nextInt(30)));
        in.close();
        return unit;
    }

    public Unit getUnit() {
        return unit;
    }
    
}
