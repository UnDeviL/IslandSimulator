package IslandSimulator.src.Animals.Herbivores;

import IslandSimulator.src.Animals.AnimalType;
import lombok.Getter;

public class Deer extends Herbivore{
    @Getter
    private static final String PROPERTIES_PATH =
            "IslandSimulator/src/resources/animalConfig/deerProperties.json";
    private Deer(){
    }
    @Override
    public AnimalType getAnimalType() {
        return AnimalType.DEER;
    }
}
