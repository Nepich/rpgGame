package unit.strategyToCreateUnit;

import java.util.Random;

import item.Armor;
import item.Weapon;
import unit.Dwarf;
import unit.Elf;
import unit.Giant;
import unit.Human;
import unit.Orc;
import unit.Unit;

public class CreateStrongUnit implements StrategyInteface {

    @Override
    public Unit createUnit(String type) {
        String[] names = new String[]{"Бабай","Клолик","Луна","Мордоворот","Пупа"};
        String[] armorNames = new String[]{"Пузо","Брюхо","Жирок","Майка"};
        String[] weaponNames = new String[]{"Кинжал","Топор","Лук"};
        Unit unit = new Human(names[new Random().nextInt(names.length)], 50 + new Random().nextInt(70), 40 + new Random().nextInt(70), 100);
        if (type.equals("Эльф")){
            unit = new Elf(names[new Random().nextInt(names.length)], 30 + new Random().nextInt(70), 30 + new Random().nextInt(70), 100);
        } else if (type.equals("Орк")) {
            unit = new Orc(names[new Random().nextInt(names.length)], 70 + new Random().nextInt(70), 50 + new Random().nextInt(70), 100);
        } else if (type.equals("Гном")){
            unit = new Dwarf(names[new Random().nextInt(names.length)], 60 + new Random().nextInt(70), 40 + new Random().nextInt(70), 100);
        } else if (type.equals("Великан")){
            unit = new Giant(names[new Random().nextInt(names.length)], 100 + new Random().nextInt(70), 100 + new Random().nextInt(70), 100);
        }
        unit.putOn(new Armor(armorNames[new Random().nextInt(armorNames.length)], 100, 10 + new Random().nextInt(25), 30 + new Random().nextInt(20)));
        unit.putOn(new Weapon(weaponNames[new Random().nextInt(weaponNames.length)], 100, 10 + new Random().nextInt(25), 50 + new Random().nextInt(30)));
        return unit;
    }
    
}
