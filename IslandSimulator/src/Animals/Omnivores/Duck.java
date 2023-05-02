package IslandSimulator.src.Animals.Omnivores;

import IslandSimulator.src.Animals.AnimalType;
import lombok.Getter;

public class Duck extends Omnivore{
    @Getter
    private static final String PROPERTIES_PATH =
            "IslandSimulator/src/resources/animalConfig/duckProperties.json";

    private Duck() {
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.DUCK;
    }
}
