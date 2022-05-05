
import unit.*;
import unit.Strategy.CreateArmor;
import unit.Strategy.CreateSetAtributes;
import unit.Strategy.CreateSome;
import unit.Strategy.CreateWeapon;
import unit.UnitFactorys.ElfFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.ObjectOutputStream;
import unit.UnitFactorys.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.sql.*;

public class Game {

    private static CreateSome strategy;
    public static void main(String[] args) throws IOException {

        try{
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:db/game.db");
            System.out.println("Подключиличь к БД");
            Statement stmt = connection.createStatement();
            String query = "CREATE TABLE units (name TEXT, atack INTEGER, hp INTEGER, wearableWeight INTEGER, armor INTEGER, money INTEGER);";
            stmt.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }


//  Работы стратегии
        Unit unit;

        Scanner in = new Scanner(System.in);
        System.out.println("Какого персонажа создать?:\n1 - Человек\n2 - Орк\n3 - Эльф\n4 - Гном\n5 - Великан");
        int type = in.nextInt();
        if (type == 1) {
            unit = new Human("Иван", 50, 30, 100);   
        } else if (type == 2) {
            unit = new Orc("Потрошитель", 70, 50, 100);
        } else if (type == 3) {
            unit = new Elf("Леголас", 40, 40, 100);
        } else if (type == 4) {
            unit = new Dwarf("Гимли", 60, 50, 100);
        } else {
            unit = new Giant("Пустоголов", 100, 90, 100);
        }
        System.out.println("Ваш персонаж: " + unit.getName() + 
        "\nЗдоровье: " + unit.getHp() + 
        "\nАтака: " + unit.getAtack() + 
        "\nЗащита: " + unit.getArmor());
        System.out.println("Изменить что-то?\n1 - Да!\n2 - Нет");
        int choice = in.nextInt();
        while (choice != 2){
            System.out.println("1 - Изменить параметры персонажа\n2 - Дать оружие\n3- Дать броню");
            int choice1 = in.nextInt();
            if (choice1 == 1) {
                strategy = new CreateSetAtributes();
            } else if (choice1 == 2) {
                strategy = new CreateArmor();
            } else {
                strategy = new CreateWeapon();
            }
            unit = changeUnit(strategy, unit);
            System.out.println("Изменить что-то?\n1 - Да!\n2 - Нет");    
            choice = in.nextInt();
        }
        in.close();
        System.out.println(unit);

        // Работа фабрики
        Unit unit1 = new ElfFactory().create();
        System.out.println(unit1);
    }

    public static Unit changeUnit(CreateSome strategy, Unit unit) {
        strategy.setAtributes(unit);
        return unit;
    }

//   Новый вариант с реализацией Интерфейса
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
            System.out.println(atacker.getName() + " атаковал " + defender.getName());
            if (defender.getHp() <= 0) {
                System.out.println(defender.getName() + " умер!");
                ((ArrayList<Unit>) armies[armyDefender]).remove(((ArrayList<Unit>) armies[armyDefender]).indexOf(defender));
            } else System.out.println("У " + defender.getName() + " осталось " + defender.getHp() + " здоровья");
        }
        if (first.size()==0) System.out.println("Вторая армия победила");
        else System.out.println("Первая армия победила");
    }

    public static void SaveUnit(Unit unit) throws FileNotFoundException, IOException {
        File file = new File("unit.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(new Elf(unit.getName(), unit.getAtack(), unit.getHp(), unit.getWearableWeight()));
        oos.close();

    }

}


