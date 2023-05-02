package IslandSimulator.src.Animals.Predators;

import IslandSimulator.src.Animals.AnimalType;
import lombok.Getter;

public class Boa extends Predator {
    @Getter
    private static final String PROPERTIES_PATH =
            "IslandSimulator/src/resources/animalConfig/boaProperties.json";

    private Boa() {
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.BOA;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
