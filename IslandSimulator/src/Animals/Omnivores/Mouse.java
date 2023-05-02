package IslandSimulator.src.Animals.Omnivores;

import IslandSimulator.src.Animals.AnimalType;
import lombok.Getter;

public class Mouse extends Omnivore{
    @Getter
    private static final String PROPERTIES_PATH =
            "IslandSimulator/src/resources/animalConfig/mouseProperties.json";

    private Mouse() {
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.MOUSE;
    }
}
