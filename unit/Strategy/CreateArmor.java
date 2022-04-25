package unit.Strategy;

import java.util.Random;
import java.util.Scanner;

import item.Armor;
import unit.Unit;

public class CreateArmor implements CreateSome {

    @Override
    public void setAtributes(Unit unit) {
        String[] armorNames = new String[]{"Пузо","Брюхо","Жирок","Майка"};
        Scanner in1 = new Scanner(System.in);
        System.out.println("Дать персонажу броню:\n1-Мощную\n2-Слабую");
        String type = in1.nextLine();
        if (type.equals("1")) {
            unit.putOn(new Armor(armorNames[new Random().nextInt(armorNames.length)], 100, 10 + new Random().nextInt(25), 50 + new Random().nextInt(30)));
        } else unit.putOn(new Armor(armorNames[new Random().nextInt(armorNames.length)], 100, 10 + new Random().nextInt(25), 10 + new Random().nextInt(30)));
    }
    
}
