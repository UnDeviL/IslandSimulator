package IslandSimulator.src.Animals.Predators;

import IslandSimulator.src.Animals.AnimalType;
import lombok.Getter;

public class Bear extends Predator{
    @Getter

    private static final String PROPERTIES_PATH =
            "IslandSimulator/src/resources/animalConfig/bearProperties.json";
    private Bear() {
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.BEAR;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
