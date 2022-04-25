package unit.UnitFactorys;
import unit.Unit;
import java.util.Random;


public class ElfFactory implements Factory {
    private static String [] names = new String[]{"Ара", "Брин", "Валь", "Дель", "Иннил", "Лаэль", "Мелла", "Наиль", "Наэрис", "Раэль"}; 
    public Unit create(){
        Unit elf = new Unit(names[new Random().nextInt(names.length)], 
        new Random().nextInt(21) + 80,
        new Random().nextInt(21) + 100,
        100){};
        return elf;
    }
}
