package unit.Strategy;

import java.util.Random;
import java.util.Scanner;

import item.Weapon;
import unit.Unit;

public class CreateWeapon implements CreateSome {

    @Override
    public void setAtributes(Unit unit) {
        String[] weaponNames = new String[]{"Кинжал","Топор","Лук"};
        Scanner in = new Scanner(System.in);
        System.out.println("Дать персонажу оружие:\n1-Мощное\n2-Слабое");
        int type = in.nextInt();
        if (type == 1) {
            unit.putOn(new Weapon(weaponNames[new Random().nextInt(weaponNames.length)], 100, 10 + new Random().nextInt(25), 50 + new Random().nextInt(30)));
        } else unit.putOn(new Weapon(weaponNames[new Random().nextInt(weaponNames.length)], 100, 10 + new Random().nextInt(25), 10 + new Random().nextInt(30)));
    }
    
}
