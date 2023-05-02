package IslandSimulator.src.Animals.Herbivores;

import IslandSimulator.src.Animals.AnimalType;
import lombok.Getter;

public class Caterpillar extends Herbivore{
    @Getter
    private static final String PROPERTIES_PATH =
            "IslandSimulator/src/resources/animalConfig/caterpillarProperties.json";
    private Caterpillar(){

    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.CATERPILLAR;
    }
}
