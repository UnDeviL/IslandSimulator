package IslandSimulator.src.Animals.Predators;

import IslandSimulator.src.Animals.AnimalType;
import lombok.Getter;

public class Fox extends Predator{
    @Getter
    private static final String PROPERTIES_PATH =
            "IslandSimulator/src/resources/animalConfig/foxProperties.json";
    private Fox() {
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.FOX;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
