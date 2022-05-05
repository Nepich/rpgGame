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

public class CreateStrongUnit implements StrategyInteface {

    private Unit unit;

    @Override
    public Unit createUnit() {
        String[] names = new String[]{"Бабай","Клолик","Луна","Мордоворот","Пупа"};
        String[] armorNames = new String[]{"Пузо","Брюхо","Жирок","Майка"};
        String[] weaponNames = new String[]{"Кинжал","Топор","Лук"};
        System.out.println("Выберите кого будем создавать\n 1 - Орк\n 2 - Человек\n 3 - Эльф\n 4 - Великан\n 5 - Гном");
        Scanner in = new Scanner(System.in);
        int type = in.nextInt();
        if (type == 3){
            unit = new Elf(names[new Random().nextInt(names.length)], 30 + new Random().nextInt(70), 30 + new Random().nextInt(70), 100);
        } else if (type == 1) {
            unit = new Orc(names[new Random().nextInt(names.length)], 70 + new Random().nextInt(70), 50 + new Random().nextInt(70), 100);
        } else if (type == 5){
            unit = new Dwarf(names[new Random().nextInt(names.length)], 60 + new Random().nextInt(70), 40 + new Random().nextInt(70), 100);
        } else if (type == 4){
            unit = new Giant(names[new Random().nextInt(names.length)], 100 + new Random().nextInt(70), 100 + new Random().nextInt(70), 100);
        } else if (type == 2) {
            unit = new Human(names[new Random().nextInt(names.length)], 50 + new Random().nextInt(70), 40 + new Random().nextInt(70), 100);
        } else System.out.println("Таких персонажей в игре нет!!!");
        unit.putOn(new Armor(armorNames[new Random().nextInt(armorNames.length)], 100, 10 + new Random().nextInt(25), 30 + new Random().nextInt(20)));
        unit.putOn(new Weapon(weaponNames[new Random().nextInt(weaponNames.length)], 100, 10 + new Random().nextInt(25), 50 + new Random().nextInt(30)));
        in.close();
        return unit;
    }
    
}
