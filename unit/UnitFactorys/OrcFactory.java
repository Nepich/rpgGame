package unit.UnitFactorys;
import unit.Unit;
import java.util.Random;


public class OrcFactory implements Factory {
    private static String [] names = new String[]{"Ухкогром", "Кронозаг", "Карийк", "Шиктердрак", "Горморрик", "Гогигор", "Тудкоген", "Альренгрим" , "Балкаун", "Айнозог"};
    public Unit create(){
        Unit orc = new Unit(names[new Random().nextInt(names.length)], 
        new Random().nextInt(51) + 100,
        new Random().nextInt(41) + 30,
        100){};
        return orc;
    }

}
