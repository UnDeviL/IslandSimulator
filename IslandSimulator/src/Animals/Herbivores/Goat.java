package IslandSimulator.src.Animals.Herbivores;

import IslandSimulator.src.Animals.AnimalType;
import lombok.Getter;

public class Goat extends Herbivore{
    @Getter
    private static final String PROPERTIES_PATH =
            "IslandSimulator/src/resources/animalConfig/goatProperties.json";
    private Goat(){
    }
    @Override
    public AnimalType getAnimalType() {
        return AnimalType.GOAT;
    }
}
