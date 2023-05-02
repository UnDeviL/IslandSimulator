package IslandSimulator.src.Animals.Predators;

import IslandSimulator.src.Animals.AnimalType;
import lombok.Getter;

public class Eagle extends Predator{
    @Getter
    private static final String PROPERTIES_PATH =
            "IslandSimulator/src/resources/animalConfig/eagleProperties.json";
    private Eagle() {
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.EAGLE;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
