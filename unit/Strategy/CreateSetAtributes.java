package unit.Strategy;

import java.util.Scanner;

import unit.Unit;

public class CreateSetAtributes implements CreateSome {

    @Override
    public void setAtributes(Unit unit) {
        Scanner in = new Scanner(System.in);
        String choise = "1";
        while (choise.equals("1")){
        System.out.println("Какие характеристики устанавливаем персонажу:\n1-Имя\n2-Атака\n3-Защита\n4-Количество здоровья");
        int type = in.nextInt();
        if (type == 1){
            System.out.println("Новое имя персонажа:");
            String name = in.next();
            unit.setName(name);
        } else if (type == 2){
            System.out.println("Показатель атаки:");
            int atack = in.nextInt();
            unit.setAtack(atack);
        } else if (type == 3){
            System.out.println("Показатель защиты:");
            int armor = in.nextInt();
            unit.setArmor(armor);
        } else if (type == 4){
            System.out.println("Показатель здоровья:");
            int hp = in.nextInt();
            unit.setHp(hp);
        }
        System.out.println("Изменить что-то еще?\n1-Да\n2-Закончить создание персонажа");
        choise = in.next();
    }
    }
    
}
