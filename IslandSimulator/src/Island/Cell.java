package IslandSimulator.src.Island;

import IslandSimulator.src.Animals.Animal;
import IslandSimulator.src.Animals.AnimalType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Cell {
    public static final int MAX_AMOUNT_OF_PLANTS =
            IslandPropertiesSerializer.getMaxAmountOfPlantsPerCell();
    @Getter
    private final int x;
    @Getter
    private final int y;
    @Getter
    @Setter
    private int plants;
    @Getter
    private final List<Animal> animalList;

    public Cell(int x, int y, List<Animal> animalList) {
        this.x = x;
        this.y = y;
        this.animalList = animalList;
    }

    public int countType(AnimalType type) {
        return (int) animalList.stream().filter(animal -> animal.getAnimalType() == type).count();
    }

    @Override
    public String toString() {
        return "Cell{" +
                "x=" + x +
                ", y=" + y
                + '}';
    }

}
