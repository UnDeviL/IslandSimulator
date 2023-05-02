package IslandSimulator.src.Animals.Predators;

import IslandSimulator.src.Animals.AnimalType;
import lombok.Getter;

public class Wolf extends Predator{
@Getter
    private static final String PROPERTIES_PATH =
            "IslandSimulator/src/resources/animalConfig/wolfProperties.json";
    private Wolf() {
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.WOLF;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
